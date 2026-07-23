package com.library.studentservice.service;

import com.library.studentservice.client.BookClient;
import com.library.studentservice.dto.BookDto;
import com.library.studentservice.dto.StudentDto;
import com.library.studentservice.entity.Student;
import com.library.studentservice.exception.StudentNotFoundException;
import com.library.studentservice.mapper.StudentMapper;
import com.library.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final BookClient bookClient;

    public StudentService(StudentRepository studentRepository,
                          BookClient bookClient) {
        this.studentRepository = studentRepository;
        this.bookClient = bookClient;
    }

    public StudentDto saveStudent(StudentDto studentDto) {

        Student student = StudentMapper.mapToEntity(studentDto);

        Student savedStudent = studentRepository.save(student);

        return StudentMapper.mapToDto(savedStudent);
    }

    public List<StudentDto> getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::mapToDto)
                .toList();
    }

    public StudentDto getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        return StudentMapper.mapToDto(student);
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());

        Student updatedStudent = studentRepository.save(student);

        return StudentMapper.mapToDto(updatedStudent);
    }

    public void deleteStudent(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found");
        }

        studentRepository.deleteById(id);
    }
    public List<BookDto> getAllBooksFromBookService() {
        return bookClient.getAllBooks();
    }
}