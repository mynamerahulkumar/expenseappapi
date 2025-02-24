package com.expenserestapi.expenseappapi.exception;

import com.expenserestapi.expenseappapi.io.ErrorObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/**
 * Global exception handler
 */
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     *
     * @param exception
     * @return
     */

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorObject handleResourceNotFoundException(ResourceNotFoundException exception){
       return ErrorObject.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .errorCode("DATA_NOT_FOUND")
                .message(exception.getMessage())
                .timestamp(new Date())
                .build();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String,Object> errorResponse=new HashMap<>();
        List<String> errors=ex.getBindingResult().getFieldErrors()
                .stream().map(field->field.getDefaultMessage())
                .collect(Collectors.toList());
        errorResponse.put("statusCode",HttpStatus.BAD_REQUEST.value());
        errorResponse.put("message",errors);
        errorResponse.put("timestamp",new Date());
        errorResponse.put("errorCode","VALIDATION_FAILED");
        return  new ResponseEntity<Object>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
