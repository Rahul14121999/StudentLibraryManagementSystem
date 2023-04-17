package com.broCode.StudentLibraryManagementSystem.Controller;

import com.broCode.StudentLibraryManagementSystem.DTO.AuthorEntryDTO;
import com.broCode.StudentLibraryManagementSystem.DTO.AuthorResponseDTO;
import com.broCode.StudentLibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDTO authorEntryDto){
        return authorService.createAuthor(authorEntryDto);
    }

    @GetMapping("/getAuthor")
    public AuthorResponseDTO getAuthor(@RequestParam("authorId")Integer authorId){
        return authorService.getAuthor(authorId);
    }
}
