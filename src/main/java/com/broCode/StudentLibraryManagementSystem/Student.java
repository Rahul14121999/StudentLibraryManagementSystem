package com.broCode.StudentLibraryManagementSystem;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EnrollmentID")
    private int enrollId;

    @Column(name="Name")
    private String name;

    @Column(name="EmailId",unique = true)
    private String email;

    @Column(name="Branch")
    private String branch;

    @Column(name="Age")
    private int age;

    @Column(name="MobileNumber",unique = true)
    private String mobileNumber;

    @OneToOne(mappedBy = "studentVariable",cascade = CascadeType.ALL)
    private IDCard idCard;      // we need to set idcard in studentService

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    public Student() {
    }

    public int getEnrollId() {
        return enrollId;
    }

    public void setEnrollId(int enrollId) {
        this.enrollId = enrollId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
