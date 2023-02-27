package com.broCode.StudentLibraryManagementSystem;

import com.broCode.StudentLibraryManagementSystem.Enums.Genre;

import javax.persistence.*;

@Entity
@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="Book_name")
    private String name;

    @Column(name="Pages")
    private int pages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Author authorVariable;

    //book is child wrt IDCard class
    @ManyToOne
    @JoinColumn
    private IDCard idCardVariable;

    public Book() {

    }

    public Author getAuthorVariable() {
        return authorVariable;
    }

    public void setAuthorVariable(Author authorVariable) {
        this.authorVariable = authorVariable;
    }

    public IDCard getIdCardVariable() {
        return idCardVariable;
    }

    public void setIdCardVariable(IDCard idCardVariable) {
        this.idCardVariable = idCardVariable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
