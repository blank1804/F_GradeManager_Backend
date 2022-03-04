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

	@JsonProperty("sId1")
	public Integer sId1;

	@JsonProperty("subjectCredit1")
	public Integer subjectCredit1;

	@JsonProperty("subjectId1")
	public String subjectId1;

	@JsonProperty("sId2")
	public Integer sId2;

	@JsonProperty("subjectCredit2")
	public Integer subjectCredit2;

	@JsonProperty("subjectId2")
	public String subjectId2;

	@JsonProperty("sId3")
	public Integer sId3;

	@JsonProperty("subjectCredit3")
	public Integer subjectCredit3;

	@JsonProperty("subjectId3")
	public String subjectId3;

	@JsonProperty("sId4")
	public Integer sId4;

	@JsonProperty("subjectCredit4")
	public Integer subjectCredit4;

	@JsonProperty("subjectId4")
	public String subjectId4;

	@JsonProperty("sId5")
	public Integer sId5;

	@JsonProperty("subjectCredit5")
	public Integer subjectCredit5;

	@JsonProperty("subjectId5")
	public String subjectId5;

	@JsonProperty("sId6")
	public Integer sId6;

	@JsonProperty("subjectCredit6")
	public Integer subjectCredit6;

	@JsonProperty("subjectId6")
	public String subjectId6;



	@Data
	public static class GetDetail {
		@JsonProperty("gId")
		public Integer gId;

	}


}
