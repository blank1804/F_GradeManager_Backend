package com.bk.GradeManager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.bk.GradeManager.repository.core.PageModel;

import lombok.Data;


@Data
public class StudentSearchModel extends PageModel {
	
	@JsonProperty("id")
	public Integer id;	

	@JsonProperty("studentId")
	public String studentId;
	
	@JsonProperty("preName")
	public String preName;

	@JsonProperty("firstName")
	public String firstName;

	@JsonProperty("lastName")
	public String lastName;
	
	@JsonProperty("fieldOfStudy")
	public String fieldOfStudy;

	@JsonProperty("classYear")
	public String classYear;
	
	@JsonProperty("idCard")
	public String idCard;
}
