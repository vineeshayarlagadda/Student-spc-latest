package com.g3.spc.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;


@Entity
public class Subject {
	
	@Id
	@ApiModelProperty(name = "SubjectID",value="Holds the subject id",required = true)
    @NotNull(message = "Subject id cannot be null or blank")
	private int subjectId;
	
	@ApiModelProperty(name = "SubjectTitle",value="Holds the subject title",required = true)
    @NotEmpty(message = "Subject title cannot be null or blank")
	private String title;
	
//	@JsonIgnore
//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(
//			name="Students___Subjects",
//			joinColumns=@JoinColumn(name="subjectId"),
//			inverseJoinColumns=@JoinColumn(name="studentId"))
//	private List<Student> students;
	
	public Subject() {
		super();
	}

	public Subject(int subjectId, String title) {
		super();
		this.subjectId = subjectId;
		this.title = title;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

//	public List<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(List<Student> students) {
//		this.students = students;
//	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + subjectId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Subject other = (Subject) obj;
		if (subjectId != other.subjectId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", title=" + title + "]";
	}
	
}