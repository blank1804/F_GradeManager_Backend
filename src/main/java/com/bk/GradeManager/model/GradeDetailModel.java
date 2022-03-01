package com.bk.GradeManager.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GradeDetailModel {

	@JsonProperty("gId")
	public Integer gId;
	
	@JsonProperty("id")
	public Integer id;
	
	@JsonProperty("studentId")
	public String studentId;
	
	@JsonProperty("year")
	public String year;

	@JsonProperty("turm")
	public Integer turm;

	@JsonProperty("subject1")
	public String subject1;
	
	@JsonProperty("point1")
	public Integer point1;

	@JsonProperty("subject2")
	public String subject2;
	
	@JsonProperty("point2")
	public Integer point2;

	@JsonProperty("subject3")
	public String subject3;

	@JsonProperty("point3")
	public Integer point3;

	@JsonProperty("subject4")
	public String subject4;

	@JsonProperty("point4")
	public Integer point4;

	@JsonProperty("subject5")
	public String subject5;

	@JsonProperty("point5")
	public Integer point5;

	@JsonProperty("subject6")
	public String subject6;

	@JsonProperty("point6")
	public Integer point6;



	@Data
	public static class GetDetail {
		@JsonProperty("gId")
		public Integer gId;

	}

}
