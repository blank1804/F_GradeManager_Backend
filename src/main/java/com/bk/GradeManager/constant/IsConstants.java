package com.bk.GradeManager.constant;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

public class IsConstants {

	public static final String GET_MASTER_METHOD = "/findMaster";
	public static final String GET_DETAIL_METHOD = "/findDetail";
	public static final String SEARCH_METHOD = "/search";
	public static final String SEARCH_THESIS_METHOD = "/searchThesis";
	public static final String SAVE_METHOD = "/save";
	public static final String CANCEL_METHOD = "/cancel";
	public static final String UPDATE_METHOD = "/update";
	
	public static class PetitionCode {
		public static final String THESIS01 	= "001";
		public static final String THESIS03 	= "002";
		public static final String THESIS03_1 	= "003";
		public static final String THESIS03_2 	= "004";
		public static final String THESIS04 	= "005";
		public static final String THESIS04_2 	= "006";
		public static final String THESIS06 	= "007";
		public static final String THESIS06_1 	= "008";
		public static final String THESIS06_2 	= "009";
		public static final String THESIS07 	= "010";
		public static final String THESIS08 	= "011";
		public static final String THESIS09 	= "012";
		public static final String THESIS10 	= "013";
		public static final String THESIS11 	= "014";
		public static final String THESIS13 	= "015";
		public static final String THESIS13_1	= "016";
		public static final String THESIS13_2	= "017";
		public static final String THESIS14 	= "018";
		public static final String THESIS14_1 	= "019";
	}
	public static class PetitionStatus {
		public static final String NORMAL 	= "N";
		public static final String WAITING 	= "W";
		public static final String CANCEL = "C";
		public static final String APPROVE = "A";
	}

	public static class AdvisorType {
		public static final String REQUEST = "R";
		public static final String APPROVE = "A";
	}

	public static class MessageCode {
		public static final String NO_CALENDAR 	= "Message.IS00181";
		public static final String NOT_PRESENT 	= "Message.STD00001";
	}
	
	@Data
	public static class StudentInfo {
		@JsonProperty("mobileNo")
		public String mobileNo;
		
		@JsonProperty("email")
		public String email;
		
		@JsonProperty("lineId")
		public String lineId;
		
		@JsonProperty("educationTypeLevelName")
		public String educationTypeLevelName;
		
		@JsonProperty("programName")
		public String programName;

		@JsonProperty("studentId")
	    private Integer studentId;
		
		@JsonProperty("studentCode")
	    private String studentCode;
	}
	
	@Data
	public static class AdvisorModel {
		
		@JsonProperty("advisorName")
		public String advisorName;
		
		@JsonProperty("mainAdvisorDesc")
		public String mainAdvisorDesc;
	}
}
