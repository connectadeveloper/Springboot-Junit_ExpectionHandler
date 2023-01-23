package com.lib.book.exception;

import lombok.Data;

@Data
public class NoDataAvailable extends Exception{

    private final int code;

    public NoDataAvailable(int code, String msg){
        super(msg);
        this.code = code;
    }
}
