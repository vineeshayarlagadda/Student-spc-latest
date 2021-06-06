package com.g3.spc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Teacher {
	@Id
	@ApiModelProperty(name = "TeacherID",value="Holds the teacher id",required = true)
    @NotNull(message = "Teacher id cannot be null or blank")
	private int teacherId;
	
	@ApiModelProperty(name = "TeacherName",value="Holds the teacher name",required = true)
    @NotEmpty(message = "Teacher name cannot be null or blank")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SubjectInfo", referencedColumnName = "subjectId")
	@Valid
	private Subject subject;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	name="Student_TeacherInfo",
	joinColumns=@JoinColumn(name="teacherID"),
	inverseJoinColumns=@JoinColumn(name="classID"))
	List<ClassId> ClassIdList;

	public Teacher() {
		super();
	}

	
	
	public Teacher(int teacherId, String name) {
		super();
		this.teacherId = teacherId;
		this.name = name;
	}
	
	

	public Teacher(@NotNull(message = "Teacher id cannot be null or blank") int teacherId,
			@NotEmpty(message = "Teacher name cannot be null or blank") String name, @Valid Subject subject) {
		super();
		this.teacherId = teacherId;
		this.name = name;
		this.subject = subject;
	}



	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<ClassId> getClassIdList() {
		return ClassIdList;
	}

	public void setClassIdList(List<ClassId> classIdList) {
		ClassIdList = classIdList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ClassIdList == null) ? 0 : ClassIdList.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + teacherId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (ClassIdList == null) {
			if (other.ClassIdList != null)
				return false;
		} else if (!ClassIdList.equals(other.ClassIdList))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", subject=" + subject + ", ClassIdList="
				+ ClassIdList + "]";
	}
	
}