package com.library.studentservice.mapper;

import com.library.studentservice.dto.StudentDto;
import com.library.studentservice.entity.Student;

public class StudentMapper {

    public static StudentDto mapToDto(Student student) {

        return new StudentDto(

                student.getId(),

                student.getFirstName(),

                student.getLastName(),

                student.getEmail()

        );

    }

    public static Student mapToEntity(StudentDto dto) {

        Student student = new Student();

        student.setId(dto.getId());

        student.setFirstName(dto.getFirstName());

        student.setLastName(dto.getLastName());

        student.setEmail(dto.getEmail());

        return student;

    }

}