package com.broCode.StudentLibraryManagementSystem.Service;

import com.broCode.StudentLibraryManagementSystem.DTOs.StudentUpdateMobRequestDTO;
import com.broCode.StudentLibraryManagementSystem.Enums.CardStatus;
import com.broCode.StudentLibraryManagementSystem.IDCard;
import com.broCode.StudentLibraryManagementSystem.Repositories.StudentRepository;
import com.broCode.StudentLibraryManagementSystem.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student)
    {
        //card part
        IDCard idCard = new IDCard();       // becoz we want idcard to be automatically generated whenever a student is created
                // ALWAYS SET THE ATTRIBUTES BEFORE SAVING IN THE DATABASE
        idCard.setCardStatus(CardStatus.ACTIVATED);
        idCard.setStudentVariable(student);

        //student part
        student.setIdCard(idCard);

        //Since we have used bidirectional mapping, if we save(or modify) parent entity, child entity is automatically saved(or modified)
        //i.e. by cascading effect, child will automatically be saved
        //but u need to create card repository and extend it
        studentRepository.save(student);
        return "Student and IDCard successfully added!";
    }

    public String getNameByEmail(String email)
    {
        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }

    public String updateMobileNumber(StudentUpdateMobRequestDTO studentUpdateMobRequestDTO)
    {
        //CONVERT DTO TO STUDENT OBJ
        Student student = studentRepository.findById(studentUpdateMobRequestDTO.getId()).get();

        //UPDATE/SET MOB NO
        student.setMobileNumber(studentUpdateMobRequestDTO.getMobileNumber());

        //SAVE THE MOB NO
        studentRepository.save(student);

        return "Mobile number updated.";
    }
}
