/**
 * 
 */
package com.spark.ntw.editableprofile.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.SafeHtml;

import com.spark.ntw.editableprofile.validation.ProfileValidation;

import lombok.Data;

/**
 * @author nkurup
 *
 * Nov 21, 2018
 */
@Data
@ProfileValidation
public class ProfileDto implements Serializable{
    /**
     * Id.
     */
    private long id;
	/**
     * Display Name.
     */
    @NotNull
    @Size(
            min = 1,
            max = 256)
    @SafeHtml
    private String displayName;
    
    /**
     * Real Name.
     */
    @Size(
            min = 1,
            max = 256)
    @SafeHtml
    private String realName;
    
    /**
     * Date Of Birth.
     */
    @NotNull
    private String dateOfBirth;
    
    /**
     * Gender.
     */
    @NotNull
    private char gender;
    /**
     * Ethinicity.
     */
    private String ethinicity; // TODO: convert to enum.
    /**
     * Religion.
     */
    private String religion; // TODO: convert to enum.
    /**
     * Height.
     */
    private float height;
    /**
     * Picture.
     */
    private byte[] picture;
    
    /**
     * Maritial Status.
     */
    @NotNull
    private String maritialStatus;
    /**
     * Occupation
     */
    @Size(max=256)
    @SafeHtml
    private String occupation;
    /**
     * About Me.
     */
    @Size(max=5000)
    @SafeHtml
    private String aboutMe;
    /**
     * Location.
     */
    @NotNull
    private String location;
}
