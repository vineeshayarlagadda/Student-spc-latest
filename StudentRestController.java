package com.g3.spc.web;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g3.spc.dto.StudentDto;
import com.g3.spc.entities.Student;
import com.g3.spc.exception.StudentIDNotFoundException;
import com.g3.spc.service.IStudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@RestController
@RequestMapping("/api")
@Api(value = "School Parent communication App")
public class StudentRestController {
	Logger log = org.slf4j.LoggerFactory.getLogger(StudentRestController.class);
	
	@Autowired
	private IStudentService students;
	
	
	public StudentRestController() {
		log.info("Inside Student Rest Controller Constructor");
		System.out.println("------>> Student Rest Controller Constructor");
	}
	
	@GetMapping("/home")
	public String homeRequest() {
		return "Welcome : School Parent Communication App" + LocalDateTime.now();
	}
	
	
	
	@ApiOperation(value = "Student post mapping" , response = Student.class)
	@PostMapping("/students")
	public StudentDto insertStudent(@RequestBody @Valid Student s) {
		log.info("Inside insert student");
		Student s1=students.addStudent(s);
		StudentDto studentDto = students.displayStudent(s1);
		return studentDto;
	}
	
	@PutMapping("/students/update")
	public StudentDto updateStudent(@RequestBody Student s) throws StudentIDNotFoundException
	{
		log.info("Inside update student");
		Student s1 = students.updateStudent(s);
		StudentDto studentDto = students.displayStudent(s1);
		return studentDto;
	}
	
	@PostMapping("/deleteStudents")
	public StudentDto deleteStudent(@RequestBody Student s) throws StudentIDNotFoundException{
		log.info("Inside delete student by id");
		Student s1 = students.deleteStudent(s);
		StudentDto studentDto = students.displayStudent(s1);
		return studentDto;	
	}
	
	
	@ApiOperation(value = "Student Get mapping to fetch all students" , response = List.class)
	@GetMapping("/students")
	public List<StudentDto> getAllStudents(){
		log.info("Inside get all students");
		List<Student> studentsList = students.retrieveAllStudents();
		List<StudentDto> list = new ArrayList<>();
		for(Student s : studentsList) {
			StudentDto studentDto = students.displayStudent(s);
			list.add(studentDto);
		}
		return list;
	}
	
	
	@GetMapping("/students/{id}")
	public StudentDto getStudentById(@PathVariable int id) throws StudentIDNotFoundException{
		log.info("Inside search student by id");
		Student s = students.retrieveStudentById(id);
		StudentDto studentDto = students.displayStudent(s);
		return studentDto;
	}

}
