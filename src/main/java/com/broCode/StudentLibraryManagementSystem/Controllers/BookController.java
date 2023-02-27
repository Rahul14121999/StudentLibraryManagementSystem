package com.broCode.StudentLibraryManagementSystem.Controllers;

import com.broCode.StudentLibraryManagementSystem.Book;
import com.broCode.StudentLibraryManagementSystem.DTOs.AddBookDTO;
import com.broCode.StudentLibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add_book")
    public String addBooks(@RequestBody AddBookDTO addBookDTO)
    {
        return bookService.addBooks(addBookDTO);
    }
}
