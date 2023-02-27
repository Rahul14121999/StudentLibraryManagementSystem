package com.broCode.StudentLibraryManagementSystem.DTOs;

public class AuthorEntryDTO {
    private String name;

    private int age;

    private double rating;

    public AuthorEntryDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
