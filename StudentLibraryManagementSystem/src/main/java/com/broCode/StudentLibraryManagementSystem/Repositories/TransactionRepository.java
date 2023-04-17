package com.broCode.StudentLibraryManagementSystem.Repositories;

import com.broCode.StudentLibraryManagementSystem.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    @Query(value = "select * from transactions where book_id=:bookId and card_id=:cardId and is_issue_operation=true",
            nativeQuery = true)
    List<Transaction> getTransactionsForBookAndCard(int bookId, int cardId);

    @Query(value = "select * from transactions where book_id= bookId and card_id=cardId and transaction_status='success' and is_issue_operation=true", nativeQuery = true)
    Transaction issueTransactionUsingBookIdCardId(int bookId, int cardId);

}
