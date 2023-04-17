package com.broCode.StudentLibraryManagementSystem.Controller;

import com.broCode.StudentLibraryManagementSystem.DTO.BookRequestDTO;
import com.broCode.StudentLibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDTO bookRequestDto){

        return bookService.addBook(bookRequestDto);

    }
}
