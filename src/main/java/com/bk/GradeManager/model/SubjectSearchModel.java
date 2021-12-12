package com.bk.GradeManager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import  com.bk.GradeManager.repository.core.PageModel;

import lombok.Data;


@Data
public class SubjectSearchModel extends PageModel {
	
	@JsonProperty("sId")
	public Integer sId;
	
	@JsonProperty("subjectId")
	public String subjectId;
	
	@JsonProperty("subjectName")
	public String subjectName;

	@JsonProperty("subjectCredit")
	public String subjectCredit;
}
