/**
 * 
 */
package com.spark.ntw.editableprofile.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author nkurup
 *
 * Nov 21, 2018
 */
public class ProfileDto implements Serializable{
	/**
     * Display Name.
     */
    private String displayName;
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
     * About Me.
     */
    private String aboutMe;
    /**
     * Location.
     */
    private String location;
}
