package com.lib.book.enums;

import com.lib.book.exception.NoRecordFound;
import lombok.Data;


public enum ErrorEnum {

    NoDataAvailable_Error(101, "No Record Available at this time"),
    NoRecordFound_Error(102, "No Record Found");

    private int code;
    private String msg;

    ErrorEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
