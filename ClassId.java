package com.g3.spc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import io.swagger.annotations.ApiModelProperty;

@Entity
public class ClassId {
	
	@Id
	@ApiModelProperty(name = "StudentClassID",value="Holds the Class Id of student",required = true)
    @NotEmpty(message = "Student class id cannot be null or blank")
	private String classId;
	
	@ApiModelProperty(name = "StudentGrade",value="Holds the grade of student",required = true)
    @NotNull(message = "Student grade cannot be null or blank")
	private int grade;
	
	@ApiModelProperty(name = "StudentDivision",value="Holds the division of student",required = true)
    @NotNull(message = "Student division cannot be null or blank")
	private char division;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "classTeacher", referencedColumnName = "teacherId")
	@Valid
	private Teacher classTeacher;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	name="Student_TeacherInfo",
	joinColumns=@JoinColumn(name="classID"),
	inverseJoinColumns=@JoinColumn(name="teacherID"))
	@Valid
	private List<Teacher> subjectTeachers;
	
	public ClassId(int grade,char division){
		this.grade =  grade;
		this.division = division;
		this.classId =  ""+this.grade+this.division;
		
	}
	
	

	public ClassId(@NotNull(message = "Student grade cannot be null or blank") int grade,
			@NotNull(message = "Student division cannot be null or blank") char division, @Valid Teacher classTeacher,
			@Valid List<Teacher> subjectTeachers) {
		super();
		this.grade = grade;
		this.division = division;
		this.classId =  ""+this.grade+this.division;
		this.classTeacher = classTeacher;
		this.subjectTeachers = subjectTeachers;
	}



	public ClassId() {
		super();
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	public char getDivision() {
		return division;
	}



	public void setDivision(char division) {
		this.division = division;
	}



	public Teacher getClassTeacher() {
		return classTeacher;
	}



	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}



	public List<Teacher> getSubjectTeachers() {
		return subjectTeachers;
	}



	public void setSubjectTeachers(List<Teacher> subjectTeachers) {
		this.subjectTeachers = subjectTeachers;
	}


	@Override
	public String toString() {
		return "ClassId [classId=" + classId + ", grade=" + grade + ", division=" + division + ", classTeacher="
				+ classTeacher + ", subjectTeachers=" + subjectTeachers + "]";
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


}
