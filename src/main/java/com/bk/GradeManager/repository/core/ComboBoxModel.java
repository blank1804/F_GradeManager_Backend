package com.bk.GradeManager.repository.core;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ComboBoxModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private String query;
	private String from;
	private String to;
	private String lang;
	private String currentValue;
	private Integer limit;
	
}
