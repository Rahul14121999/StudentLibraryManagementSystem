package com.broCode.StudentLibraryManagementSystem.DTOs;

import com.broCode.StudentLibraryManagementSystem.Enums.Genre;

public class AddBookDTO {
    private String name;
    private int pages;
    private int authorId;
    private Genre genre;

    public AddBookDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
