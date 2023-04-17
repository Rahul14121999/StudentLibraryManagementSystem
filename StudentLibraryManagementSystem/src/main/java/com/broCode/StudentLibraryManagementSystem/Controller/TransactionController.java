package com.broCode.StudentLibraryManagementSystem.Controller;

import com.broCode.StudentLibraryManagementSystem.DTO.IssueBookRequestDTO;
import com.broCode.StudentLibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("issueBook")
    public String issueBook(@RequestBody IssueBookRequestDTO issueBookRequestDto){

        try{
            return transactionService.issueBook(issueBookRequestDto);
        }catch (Exception e){
            return e.getMessage();
        }

    }

    @GetMapping("/getTxnInfo")
    public String getTransactionEntry(@RequestParam("bookId")Integer bookId,@RequestParam("cardId")Integer cardId){

        return transactionService.getTransactions(bookId,cardId);
    }

    @PostMapping("/returnBook")
    public String returnBook(@RequestParam("bookId") int bookId,@RequestParam("cardId") int cardId )
    {
        try{
            return transactionService.returnBook(bookId,cardId);
        }catch (RuntimeException e){
            return e.getMessage();
        }
    }
}
