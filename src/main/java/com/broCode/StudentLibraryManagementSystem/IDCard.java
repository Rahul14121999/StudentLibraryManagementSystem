package com.broCode.StudentLibraryManagementSystem;

import com.broCode.StudentLibraryManagementSystem.Enums.CardStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="IDcard")
public class IDCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value= EnumType.STRING)     // telling mysql to keep the cardstatus value in the form of string becoz
    private CardStatus cardStatus;          // mysql doesnt have CardStatus datatype

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToOne
    @JoinColumn
    private Student studentVariable;

    //IDCard is parent wrt Book class
    @OneToMany(mappedBy = "idCardVariable",cascade = CascadeType.ALL)
    private List<Book> bookList;

    public IDCard() {
        bookList=new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public Student getStudentVariable() {
        return studentVariable;
    }
    public void setStudentVariable(Student studentVariable) {
        this.studentVariable = studentVariable;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
