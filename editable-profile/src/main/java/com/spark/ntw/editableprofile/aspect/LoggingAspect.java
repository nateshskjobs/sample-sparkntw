/**
*
 */

package com.spark.ntw.editableprofile.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aspect for logging.
 * <p/>
 * Entry and Exit of all the application methods have been included in Debug mode.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 25, 2018
 *
 */
@Component
@Aspect
public class LoggingAspect {
    private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Pointcut that matches all Spring beans in the application's main packages.
     */
    @Pointcut("within(com.spark.ntw.editableprofile.controller..*)"
            + " || within(com.spark.ntw.editableprofile.service..*)"
            + "|| within(com.spark.ntw.editableprofile.repository..*)")
    public void applicationPointCut() {
        // No implementation
    }

    /**
     * Pointcut that matches all Spring beans in the application's main packages.
     */
    @Pointcut("execution(* com.spark.ntw.editableprofile.controller..*(..))"
            + " || execution(* com.spark.ntw.editableprofile.service..*(..))"
            + "|| execution(* com.spark.ntw.editableprofile.repository..*(..))"
            + "|| execution(* com.spark.ntw.editableprofile.validation..*(..))"
            )
    public void applicationPointCutNew() {
        // No implementation
    }
    /**
     * Around Aspect for logging.
     * 
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("applicationPointCutNew()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        if (log.isDebugEnabled()) {
            log.debug("Enter: {}.{}() with argument[s] = {}",
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
        }
        try {
            Object result = joinPoint.proceed();
            if (log.isDebugEnabled()) {
                log.debug("Exit: {}.{}() with result = {}",
                        joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(), result);
            }
            return result;
        }
        catch (IllegalArgumentException e) {
            log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
                    joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName());

            throw e;
        }
    }
}
