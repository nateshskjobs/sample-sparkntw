/**
*
 */

package com.spark.ntw.editableprofile.validation.impl;

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
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isValid(ProfileDto dto, ConstraintValidatorContext ctx) {
        boolean flag = true;
        ctx.disableDefaultConstraintViolation();
        // Display Name
        if (StringUtils.isEmpty(dto.getDisplayName()) || dto.getDisplayName().length() > 256) {
            flag = false;
            ctx.buildConstraintViolationWithTemplate("Incorrect Display Name")
                    .addConstraintViolation();
        }

        if (null == dto.getDateOfBirth()) {
            flag = false;
            ctx.buildConstraintViolationWithTemplate("Incorrect Date Of Birth")
                    .addConstraintViolation();
        }

        return flag;
    }

}
