package com.broCode.StudentLibraryManagementSystem.Service;

import com.broCode.StudentLibraryManagementSystem.Author;
import com.broCode.StudentLibraryManagementSystem.Book;
import com.broCode.StudentLibraryManagementSystem.DTOs.AddBookDTO;
import com.broCode.StudentLibraryManagementSystem.Repositories.AuthorRepository;
import com.broCode.StudentLibraryManagementSystem.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String addBooks(AddBookDTO addBookDTO)
    {
                        //WITHOUT DTO
//        int authorId = book.getAuthorVariable().getId();
//        Author author= authorRepository.findById(authorId).get();
//        book.setAuthorVariable(author);
//
//        List<Book> currentBooksWritten = author.getBooksWritten();
//        currentBooksWritten.add(book);
//
//        bookRepository.save(book);

                        //WITH DTO
        int authorId = addBookDTO.getAuthorId();
        Author author = authorRepository.findById(authorId).get();

        Book book = new Book();
        book.setAuthorVariable(author);
        book.setName(addBookDTO.getName());
        book.setPages(addBookDTO.getPages());
        book.setGenre(addBookDTO.getGenre());

        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);

        bookRepository.save(book);

        return book.getName()+" added successfully in books table.";
    }
}
