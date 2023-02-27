package com.broCode.StudentLibraryManagementSystem.Controllers;

import com.broCode.StudentLibraryManagementSystem.DTOs.StudentUpdateMobRequestDTO;
import com.broCode.StudentLibraryManagementSystem.Service.StudentService;
import com.broCode.StudentLibraryManagementSystem.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add_student")
    public String createStudent(@RequestBody Student student)
    {
        return studentService.createStudent(student);
    }

    @GetMapping("/get_name")
    public String getNameByEmail(@RequestParam("email") String email)
    {
        return studentService.getNameByEmail(email);
    }

    @PutMapping("/update_mobNo")
    public String updateMobileNumber(@RequestBody StudentUpdateMobRequestDTO studentUpdateMobRequestDTO)
    {
        return studentService.updateMobileNumber(studentUpdateMobRequestDTO);
    }
}
