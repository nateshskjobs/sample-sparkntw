/**
*
 */

package com.spark.ntw.editableprofile.validation.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.HtmlUtils;

import com.spark.ntw.editableprofile.dto.ProfileDto;
import com.spark.ntw.editableprofile.validation.ProfileValidation;

/**
 * Validation conditions to be applied on the bean {@link ProfileDto}.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 25, 2018
 *
 */
public class ProfileValidator implements ConstraintValidator<ProfileValidation, ProfileDto> {

    @Override
    public void initialize(ProfileValidation arg0) {
    }

    @Override
    public boolean isValid(ProfileDto dto, ConstraintValidatorContext ctx) {
        boolean flag = true;
        ctx.disableDefaultConstraintViolation();
       
        if (StringUtils.isNotBlank(dto.getDateOfBirth())) {
            final DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
            final LocalDate dob=LocalDate.parse(dto.getDateOfBirth(),formatter);
            flag=!(dob.isAfter(LocalDate.now()));
            ctx.buildConstraintViolationWithTemplate("Incorrect Date Of Birth")
                    .addConstraintViolation();
        }
        

        return flag;
    }

}
