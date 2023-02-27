package com.broCode.StudentLibraryManagementSystem.DTOs;

public class StudentUpdateMobRequestDTO {
        private int id;
        private String mobileNumber;

        public StudentUpdateMobRequestDTO() {
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getMobileNumber() {
                return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
                this.mobileNumber = mobileNumber;
        }
}
