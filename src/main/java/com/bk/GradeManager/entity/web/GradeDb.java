package com.bk.GradeManager.entity.web;

import com.bk.GradeManager.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity(name = "grade_db")
public class GradeDb extends BaseEntity implements Serializable  {

private static final long serialVersionUID = 6056947135260811627L;

 @Id
    @GeneratedValue(generator = "grade_db_id_seq")
    @Column(name = "g_id", nullable = false)
    private Integer gId;

	@Column(name = "student_id")
	private String studentId;

	@Column(name = "year")
	private String year;
	
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "turm")
	private Integer turm;
	
	@Column(name = "subject1")
	private String subject1;

	@Column(name = "subject2")
	private String subject2;

	@Column(name = "subject3")
	private String subject3;

	@Column(name = "subject4")
	private String subject4;

	@Column(name = "subject5")
	private String subject5;

	@Column(name = "subject6")
	private String subject6;

	@Column(name = "point1")
	private Integer point1;

	@Column(name = "point2")
	private Integer point2;

	@Column(name = "point3")
	private Integer point3;

	@Column(name = "point4")
	private Integer point4;

	@Column(name = "point5")
	private Integer point5;

	@Column(name = "point6")
	private Integer point6;

	public void deleteById(GradeDb studentDb) {
		// TODO Auto-generated method stub
		
	}

}