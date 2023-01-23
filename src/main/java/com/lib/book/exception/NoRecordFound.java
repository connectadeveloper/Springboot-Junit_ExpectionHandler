package com.lib.book.exception;

import lombok.Data;

@Data
public class NoRecordFound extends Exception{
    private final int code;

    public NoRecordFound(int code, String msg){
        super(msg);
        this.code = code;
    }
}
