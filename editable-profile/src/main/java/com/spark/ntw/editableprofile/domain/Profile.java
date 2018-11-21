/**
*
 */

package com.spark.ntw.editableprofile.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entity class for the Profile.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 20, 2018
 *
 */
@Entity
@Table(
        name = "m_profile")
@Data
@EqualsAndHashCode(callSuper=false)
public class Profile extends BaseEntity implements Serializable {
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
    @Lob
    private byte[] picture;
    /**
     * Martial Status.
     */
    private String maritialStatus; // TODO: convert to enum.
    /**
     * Occupation.
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
