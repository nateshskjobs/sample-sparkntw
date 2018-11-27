/**
*
 */

package com.spark.ntw.editableprofile.exception;

import java.util.Optional;

import lombok.Getter;

/**
 * Exception class for failures in application.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 27, 2018
 *
 */
@Getter
public final class ApplicationException extends RuntimeException {

    /**
     * Default Constructor.
     */
    private ApplicationException() {
        super();
    }

    /**
     * @param arg0
     * @param arg1
     */
    private ApplicationException(String msg, Throwable ex) {
        super(msg, ex);
    }

    /**
     * @param arg0
     */
    private ApplicationException(String msg) {
        super(msg);
    }

    /**
     * @param arg0
     */
    private ApplicationException(Throwable ex) {
        super(ex);
    }

    /**
     * Create an instance of {@link ApplicationException}.
     * 
     * @param msg - mandatory, the message for the exception.
     * @param ex - optional, the underlying exception.
     * @return {@link ApplicationException}
     */
    public static ApplicationException getInstance(final String msg, final Optional<Throwable> ex) {
        ApplicationException appEx;
        if (ex.isPresent()) {
            appEx = new ApplicationException(msg, ex.get());
        }
        else {
            appEx = new ApplicationException(msg);
        }
        return appEx;
    }

}
