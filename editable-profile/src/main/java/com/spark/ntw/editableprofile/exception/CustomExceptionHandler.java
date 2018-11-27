/**
*
 */

package com.spark.ntw.editableprofile.exception;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Application Level Exception Handler will handle gracefully any exception thrown in the
 * application.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 26, 2018
 *
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(CustomExceptionHandler.class);

    /**
     * Handler for any exception thrown from the application. <br/>
     * The exception is logged and redirected to a general error page.
     * 
     * @param request
     * @param ex
     * @return String - the view to be redirected to.
     */
    @ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        log.error("Error Occured", ex);
        return "error";
    }

    /**
     * Handle Constraint Violation exceptions thrown when an entity is persisted. <br/>
     * The violation is logged and redirected to the generic error page.
     * 
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintValidationException(HttpServletRequest request,
            ConstraintViolationException ex) {
        log.error("Error Occured", ex);
        ConstraintViolationException cex = (ConstraintViolationException) ex;
        Set<ConstraintViolation<?>> constraintViolations = cex.getConstraintViolations();
        constraintViolations.stream().forEach(p -> log.error("Constraint Violations Occured", p));

        return "error";
    }
    
    /**
     * Handler for any {@link ApplicationException} thrown from the application. <br/>
     * The exception is logged and redirected to a general error page.
     * 
     * @param request
     * @param ex
     * @return String - the view to be redirected to.
     */
    @ExceptionHandler(ApplicationException.class)
    public String handleApplicationException(HttpServletRequest request, ApplicationException ex) {
        log.error("Error Occured", ex);
        return "error";
    }
}
