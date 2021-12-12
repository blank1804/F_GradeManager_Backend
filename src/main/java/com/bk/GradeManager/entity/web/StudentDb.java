package com.bk.GradeManager.entity.web;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.bk.GradeManager.entity.base.BaseEntity;

import lombok.Data;

@Data
@Entity(name = "student_db")
public class StudentDb extends BaseEntity implements Serializable  {

private static final long serialVersionUID = 6056947135260811627L;

 @Id
    @GeneratedValue(generator = "student_db_id_seq")
    @Column(name = "id", nullable = false)
    private Integer id;

	@Column(name = "student_id")
	private String studentId;

	@Column(name = "pre_name")
	private String preName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "field_of_study ")
	private String fieldOfStudy ;
	
	@Column(name = "class_year")
	private String classYear;
	
	@Column(name = "id_card")
	private String idCard;

	public void deleteById(StudentDb studentDb) {
		// TODO Auto-generated method stub
		
	}

}