package com.bk.GradeManager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubjectDetailModel {
	
	@JsonProperty("sId")
	public Integer sId;
	
	@JsonProperty("subjectId")
	public String subjectId;
	
	@JsonProperty("subjectName")
	public String subjectName;

	@JsonProperty("subjectCredit")
	public String subjectCredit;
	
	@Data
	public static class GetDetail {
		@JsonProperty("sId")
		public Integer sId;

	}

}
