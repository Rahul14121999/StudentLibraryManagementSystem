package com.broCode.StudentLibraryManagementSystem.Service;

import com.broCode.StudentLibraryManagementSystem.DTO.BookRequestDTO;
import com.broCode.StudentLibraryManagementSystem.Models.Author;
import com.broCode.StudentLibraryManagementSystem.Models.Book;
import com.broCode.StudentLibraryManagementSystem.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;


    public String addBook(BookRequestDTO bookRequestDto){

        //I want to get the AuthorEntity ???
        int authorId  = bookRequestDto.getAuthorId();

        //Now I will be fetching the authorEntity

        Author author = authorRepository.findById(authorId).get();


        //Convertor
        //We have created this Entity so that we can save it into the DB.
        Book book = new Book();

        //Basic attributes are being from Dto to the Entity Layer
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());


        //Setting the foreign key attr in the child class :
        book.setAuthor(author);


        //We need to upate the listOfBooks written in the parent cla

        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);


        //Now the book is to be saved, but also author is alsoooo to be saved.

        //Why do we need to again save (updating) the author ?? bcz
        //bcz the author Entity has been updated....we need to resave/update it.

        authorRepository.save(author); //Date was modified

        //.save function works both as save function and as update function


        //bookRepo.save is not required : bcz it will be autocalled by cascading
        //effect

        return "Book Added successfully";

    }
}
