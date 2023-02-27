package com.broCode.StudentLibraryManagementSystem.Service;

import com.broCode.StudentLibraryManagementSystem.Author;
import com.broCode.StudentLibraryManagementSystem.DTOs.AuthorEntryDTO;
import com.broCode.StudentLibraryManagementSystem.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor( AuthorEntryDTO authorEntryDTO)
    {
        //Important step is : in the params : the object i
        //of type DTO but the repository interacts only with entities

        //Solutoion : Convert authorEntryDto ---> Author

        //Created an object of type Author

        Author author=new Author();

        //set its attributes
        author.setName(authorEntryDTO.getName());
        author.setAge(authorEntryDTO.getAge());
        author.setRating(authorEntryDTO.getRating());


        authorRepository.save(author);
        //In this case we dont want that book to be child to be automatically created when a parent is created
        //becoz it is not necessary when author is created a book should be created. May be author hasnt written any book yet

        return "Author added Successfully";
    }
}
