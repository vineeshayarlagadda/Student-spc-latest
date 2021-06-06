package com.g3.spc.service;

import java.util.List;

import com.g3.spc.dto.StudentDto;
import com.g3.spc.entities.Student;
import com.g3.spc.exception.StudentIDNotFoundException;

public interface IStudentService {
	public Student addStudent(Student student);
	public Student updateStudent(Student student) throws StudentIDNotFoundException;
	public Student deleteStudent(Student student) throws StudentIDNotFoundException;
	public List<Student> retrieveAllStudents();
	public StudentDto displayStudent(Student s);
	public Student retrieveStudentById(int id) throws StudentIDNotFoundException;	
}
