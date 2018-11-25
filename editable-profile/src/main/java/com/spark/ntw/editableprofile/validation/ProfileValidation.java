/**
*
 */
package com.spark.ntw.editableprofile.validation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spark.ntw.editableprofile.validation.impl.ProfileValidator;

@Documented
@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = ProfileValidator.class)
/**
 * @author Natesh Kurup
*  <p/>Created Date: Nov 25, 2018
 *
 */
public @interface ProfileValidation {
    String message() default "Invalid Data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
