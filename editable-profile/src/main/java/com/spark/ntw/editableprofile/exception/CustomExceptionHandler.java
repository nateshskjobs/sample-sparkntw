/**
*
 */
package com.spark.ntw.editableprofile.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Natesh Kurup
*  <p/>Created Date: Nov 26, 2018
 *
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
    private final Logger log=LoggerFactory.getLogger(CustomExceptionHandler.class);
    
    @ExceptionHandler(Exception.class)
    public String handleSQLException(HttpServletRequest request, Exception ex){
        log.error("Error Occured", ex);;
        return "error";
    }
}
