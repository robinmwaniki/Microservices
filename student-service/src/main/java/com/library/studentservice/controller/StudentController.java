package com.library.studentservice.controller;

import com.library.studentservice.dto.BookDto;
import com.library.studentservice.dto.StudentDto;
import com.library.studentservice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDto createStudent(@Valid @RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentDto studentDto) {

        return studentService.updateStudent(id, studentDto);
    }

    @GetMapping("/books")
    public List<BookDto> getAllBooksFromBookService() {
        return studentService.getAllBooksFromBookService();
    }
}