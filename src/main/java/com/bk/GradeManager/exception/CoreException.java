package com.bk.GradeManager.exception;

public class CoreException {

    public static Exception noDataFoundException() {
        return new Exception("No Data Found");
    }

    public static Exception dataNotUpdatedException() {
        return new Exception("Message.STD00001");
    }
}
