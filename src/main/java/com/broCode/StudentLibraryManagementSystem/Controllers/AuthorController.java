package com.broCode.StudentLibraryManagementSystem.Controllers;

import com.broCode.StudentLibraryManagementSystem.Author;
import com.broCode.StudentLibraryManagementSystem.DTOs.AuthorEntryDTO;
import com.broCode.StudentLibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/author")
    public String createAuthor(@RequestBody AuthorEntryDTO authorEntryDTO)
    {
        return authorService.createAuthor(authorEntryDTO);
    }
}
