package com.bk.GradeManager.model.core;

import com.bk.GradeManager.repository.core.PageModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginModel extends PageModel {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("studentId")
    public String studentId;

    @JsonProperty("idCard")
    public String idCard;

}
