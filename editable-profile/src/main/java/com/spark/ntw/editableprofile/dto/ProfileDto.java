/**
 * 
 */
package com.spark.ntw.editableprofile.dto;

import java.io.Serializable;
import java.time.LocalDate;

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
    private String displayName;
    
    /**
     * Real Name.
     */
    private String realName;
    /**
     * Date Of Birth.
     */
    private LocalDate dateOfBirth;
    /**
     * Gender.
     */
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
     * Occupation
     */
    private String occupation;
    /**
     * About Me.
     */
    private String aboutMe;
    /**
     * Location.
     */
    private String location;
}
