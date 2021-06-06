package com.g3.spc.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@ApiModel(value = "Student Bean")
public class Student {
	@Id
	private long studentId;
	
	@ApiModelProperty(name = "StudentDOB",value="Holds the date of birth of student",required = true)
    @NotNull(message = "DOB cannot be null or blank")
	@Past(message = "Invalid date")
	private LocalDate dateOfBirth;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)                       
	@JoinTable(name="ClassInfo", joinColumns = @JoinColumn(name = "studentId"),inverseJoinColumns = @JoinColumn(name = "classId"))
	@Valid
	private ClassId currentClass;
	
	
	@ManyToMany
	@JoinColumn(name = "Student_subject", referencedColumnName = "subjectId")
	private List<Subject> subjects;
	
	
	@ApiModelProperty(name = "StudentName",value="Holds the name of student",required = true)
    @NotEmpty(message = "Name cannot be null or blank")
	@Size(min=3,max=40,message="Invalid name")
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	@Valid
	private List<Attendance> attendance;

	@OneToOne(cascade = CascadeType.ALL)                           
	@JoinColumn(name = "ClassDiary_ID",referencedColumnName = "classDiaryId")
	@Valid
	private ClassDiary classDiary;
	
	
	@ApiModelProperty(name = "StudentEmailId",value="Holds the email id of student",required = true)
    @NotEmpty(message = "Email id cannot be null or blank")
	@Email(message  = "Email id should be a valid one")
	private String emailId;
	
	
	@ApiModelProperty(name = "StudentMobileNumber",value="Holds the phone number of student and it should consist 10 digits",required = true)
    @NotEmpty(message = "Phone number cannot be null or blank")
	@Size(min=10,max=10,message="Invalid phone number")
	private String mobileNumber;
	

	@Embedded
	@ApiModelProperty(name = "StudentAddress",value="Holds the address of student",required = true)
	@NotNull(message = "Address should not be null")
	@Valid
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="studentId")
	@Valid
	private List<Fee> fee;
	
	
	public Student(long userId, LocalDate dateOfBirth,String name,String emailId, String mobileNumber) {
		super();
		this.studentId = userId;
		this.dateOfBirth = dateOfBirth;
		this.name = name;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
	}

	public Student() {
		super();
	}


	public Student(long studentId,
		@NotNull(message = "DOB cannot be null or blank") @Past(message = "Invalid date") LocalDate dateOfBirth,
		ClassId currentClass, List<Subject> subjects,
		@NotEmpty(message = "Name cannot be null or blank") @Size(min = 3, max = 40, message = "Invalid name") String name,
		@Valid List<Attendance> attendance, @Valid ClassDiary classDiary,
		@NotEmpty(message = "Email id cannot be null or blank") @Email(message = "Email id should be a valid one") String emailId,
		@NotEmpty(message = "Phone number cannot be null or blank") @Size(min = 10, max = 10, message = "Invalid phone number") String mobileNumber,
		@NotNull(message = "Address should not be null") @Valid Address address, List<Fee> fee) {
	super();
	this.studentId = studentId;
	this.dateOfBirth = dateOfBirth;
	this.currentClass = currentClass;
	this.subjects = subjects;
	this.name = name;
	this.attendance = attendance;
	this.classDiary = classDiary;
	this.emailId = emailId;
	this.mobileNumber = mobileNumber;
	this.address = address;
	this.fee = fee;
}



	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long userId) {
		this.studentId = userId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	

	public ClassId getCurrentClass() {
		return currentClass;
	}



	public void setCurrentClass(ClassId currentClass) {
		this.currentClass = currentClass;
	}



	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ClassDiary getClassDiary() {
		return classDiary;
	}

	public void setClassDiary(ClassDiary classDiary) {
		this.classDiary = classDiary;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	
	

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}
	
	public List<Fee> getFee() {
		return fee;
	}

	public void setFee(List<Fee> fee) {
		this.fee = fee;
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

	@Override
	public String toString() {
		return "Student [userId=" + studentId + ", dateOfBirth=" + dateOfBirth + ", currentClass=" + currentClass
				+ ", subjects=" + subjects + ", name=" + name + ", emailId=" + emailId
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}
	
}
