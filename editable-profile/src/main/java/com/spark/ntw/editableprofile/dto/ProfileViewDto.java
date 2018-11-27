/**
*
 */

package com.spark.ntw.editableprofile.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * DTO for the read only Profile Screen.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 27, 2018
 *
 */
@Data
public class ProfileViewDto implements Serializable {
    /**
     * Display Name.
     */
    private String displayName;

    /**
     * Date Of Birth.
     */
    private String dateOfBirth;

    /**
     * Gender.
     */
    private char gender;
    /**
     * Ethinicity.
     */
    private String ethinicity;
    /**
     * Religion.
     */
    private String religion;
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
    
    /**
     * Gender Name.
     */
    private String genderName;

}
