package com.bk.GradeManager.model;

import java.util.Date;


import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StudentDetailModel {
	
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
	
	@Data
	public static class GetDetail {
		@JsonProperty("id")
		public Integer id;

	}

}
