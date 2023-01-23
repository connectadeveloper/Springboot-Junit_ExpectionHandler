package com.lib.book.exception;

import com.lib.book.entity.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class AppControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoDataAvailable.class)
    public ResponseEntity<ErrorDto> noDataAvailable(NoDataAvailable ex, WebRequest request){

        ErrorDto body = ErrorDto.builder()
                .msg(ex.getMessage())
                .code(ex.getCode())
                .localDateTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(body, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(NoRecordFound.class)
    public ResponseEntity<ErrorDto> noRecordFound(NoDataAvailable ex, WebRequest request){

        ErrorDto body = ErrorDto.builder()
                .localDateTime(LocalDateTime.now())
                .msg(ex.getMessage())
                .code(ex.getCode())
                .build();

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}
