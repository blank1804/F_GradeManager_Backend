package com.bk.GradeManager.entity.web;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.bk.GradeManager.entity.base.BaseEntity;

import lombok.Data;

@Data
@Entity(name = "subject_db")
public class SubjectDb extends BaseEntity implements Serializable  {

 @Id
    @GeneratedValue(generator = "subject_db_id_seq")
    @Column(name = "s_id", nullable = false)
    private Integer sId;

	@Column(name = "subject_id")
	private String subjectId;

	@Column(name = "subject_name")
	private String subjectName;
	
	@Column(name = "subject_credit")
	private String subjectCredit;
	

	public void deleteById(SubjectDb studentDb) {
		// TODO Auto-generated method stub
		
	}

}