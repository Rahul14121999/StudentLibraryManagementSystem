package com.broCode.StudentLibraryManagementSystem.DTO;

public class StudentUpdateMobRequestDTO {
    private int id;
    private String mobNo;

    public StudentUpdateMobRequestDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
