package com.broCode.StudentLibraryManagementSystem.Service;

import com.broCode.StudentLibraryManagementSystem.DTO.IssueBookRequestDTO;
import com.broCode.StudentLibraryManagementSystem.Enums.CardStatus;
import com.broCode.StudentLibraryManagementSystem.Enums.TransactionStatus;
import com.broCode.StudentLibraryManagementSystem.Models.Book;
import com.broCode.StudentLibraryManagementSystem.Models.Card;
import com.broCode.StudentLibraryManagementSystem.Models.Transaction;
import com.broCode.StudentLibraryManagementSystem.Repositories.BookRepository;
import com.broCode.StudentLibraryManagementSystem.Repositories.CardRepository;
import com.broCode.StudentLibraryManagementSystem.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBook( IssueBookRequestDTO issueBookRequestDto)
    {
        int bookId = issueBookRequestDto.getBookId();
        int cardId = issueBookRequestDto.getCardId();

        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        Transaction transaction = new Transaction();

        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setIssueOperation(true);

        if(book==null || book.isIssued()==true)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new RuntimeException("Book is not available");
        }
        if(card==null || card.getCardStatus()!= CardStatus.ACTIVATED)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw  new RuntimeException("Invalid Card");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);


        //set attributes of book
        book.setIssued(true);
        //Btw the book and transaction : bidirectional
        List<Transaction> listOfTransactionForBook = book.getListOfTransactions();
        listOfTransactionForBook.add(transaction);
        book.setListOfTransactions(listOfTransactionForBook);


        //I need to make changes in the card
        //Book and the card
        List<Book> issuedBooksForCard = card.getBooksIssued();
        issuedBooksForCard.add(book);
        card.setBooksIssued(issuedBooksForCard);



        //Card and the Transaction : bidirectional (parent class)
        List<Transaction> transactionsListForCard = card.getTransactionsList();
        transactionsListForCard.add(transaction);
        card.setTransactionsList(transactionsListForCard);

        //save the parent.
        cardRepository.save(card);
        //automatically by cascading : book and transaction will be saved.
        //Saving the parent

        return "Book issued successfully";
    }

    public String getTransactions(int bookId,int cardId){

        List<Transaction> transactionsList = transactionRepository.getTransactionsForBookAndCard(bookId,cardId);

        String transactionId = transactionsList.get(0).getTransactionId();

        return transactionId;
    }

    public String returnBook(int bookId, int cardId)
    {
        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();


        Transaction returnTransaction = new Transaction();
        returnTransaction.setBook(book);
        returnTransaction.setCard(card);
        returnTransaction.setTransactionId(UUID.randomUUID().toString());
        returnTransaction.setIssueOperation(false);
        returnTransaction.setTransactionStatus(TransactionStatus.PENDING);


        if(book.isIssued()!=true)
        {
            returnTransaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(returnTransaction);
            throw new RuntimeException("Book is not issued yet");
        }
        if(card==null || card.getCardStatus()!=CardStatus.ACTIVATED)
        {
            returnTransaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(returnTransaction);
            throw new RuntimeException("Invalid Card");
        }

        Transaction issueTransaction = transactionRepository.issueTransactionUsingBookIdCardId(bookId,cardId);

        // calculate fine
        int fine=0;
        Date returnDate = new Date();
        if(issueTransaction.getTransactionDate().before(returnDate))        // execute only if book is issued before return
        {
            long timeDiff = returnDate.getTime() - issueTransaction.getTransactionDate().getTime();
            long diffDays = timeDiff / (24 * 60 * 60 * 1000) ;
            int intDiffDays = (int) diffDays;
            fine = 5*(intDiffDays-10);  // we assumed book is free for first 10 days
        }

        book.setIssued(false);

        //Btw the book and transaction : bidirectional
        List<Transaction> listOfTransactionForBook = book.getListOfTransactions();
        listOfTransactionForBook.add(returnTransaction);
        book.setListOfTransactions(listOfTransactionForBook);


        //I need to make changes in the card
        //Book and the card
        List<Book> issuedBooksForCard = card.getBooksIssued();
        issuedBooksForCard.remove(book);
        card.setBooksIssued(issuedBooksForCard);



        //Card and the Transaction : bidirectional (parent class)
        List<Transaction> transactionsListForCard = card.getTransactionsList();
        transactionsListForCard.add(returnTransaction);
        card.setTransactionsList(transactionsListForCard);

        returnTransaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //save the parent.
        cardRepository.save(card);
        return "Book returned successfully with fine: "+fine;
    }
}
