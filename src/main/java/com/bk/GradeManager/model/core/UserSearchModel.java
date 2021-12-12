package com.bk.GradeManager.model.core;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserSearchModel implements Serializable {
    private static final long serialVersionUID = 1L;


    @JsonProperty("id")
    public Integer id;


}
