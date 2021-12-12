package com.bk.GradeManager.model.core;

import java.io.Serializable;

import lombok.Data;

@Data
public class HttpResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    Integer responseCode;
    String responseBody;

}