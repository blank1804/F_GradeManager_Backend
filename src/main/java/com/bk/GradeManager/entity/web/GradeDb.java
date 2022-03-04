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

	@Column(name = "sId1")
	private Integer sId1;

	@Column(name = "subjectCredit1")
	private Integer subjectCredit1;

	@Column(name = "subjectId1")
	private String subjectId1;

	@Column(name = "sId2")
	private Integer sId2;

	@Column(name = "subjectCredit2")
	private Integer subjectCredit2;

	@Column(name = "subjectId2")
	private String subjectId2;

	@Column(name = "sId3")
	private Integer sId3;

	@Column(name = "subjectCredit3")
	private Integer subjectCredit3;

	@Column(name = "subjectId3")
	private String subjectId3;

	@Column(name = "sId4")
	private Integer sId4;

	@Column(name = "subjectCredit4")
	private Integer subjectCredit4;

	@Column(name = "subjectId4")
	private String subjectId4;

	@Column(name = "sId5")
	private Integer sId5;

	@Column(name = "subjectCredit5")
	private Integer subjectCredit5;

	@Column(name = "subjectId5")
	private String subjectId5;

	@Column(name = "sId6")
	private Integer sId6;

	@Column(name = "subjectCredit6")
	private Integer subjectCredit6;

	@Column(name = "subjectId6")
	private String subjectId6;

	public void deleteById(GradeDb studentDb) {
		// TODO Auto-generated method stub
		
	}

}