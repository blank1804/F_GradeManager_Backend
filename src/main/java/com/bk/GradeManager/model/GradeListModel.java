package com.bk.GradeManager.model;


import com.bk.GradeManager.repository.core.PageModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GradeListModel extends PageModel {

	@JsonProperty("id")
	public Integer id;



}
