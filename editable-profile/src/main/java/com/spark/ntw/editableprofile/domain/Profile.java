/**
*
 */

package com.spark.ntw.editableprofile.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
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
    @Column(name="display_name")
    private String displayName;
    /**
     * Real Name.
     */
    @Column(name="real_name")
    private String realName;
    /**
     * Date Of Birth.
     */
    @Column(name="dob")
    private LocalDate dateOfBirth;
    /**
     * Gender.
     */
    @Column(name="gender")
    private char gender;
    /**
     * Ethinicity.
     */
    @Column(name="ethinicity")
    private String ethinicity; // TODO: convert to enum.
    /**
     * Religion.
     */
    @Column(name="religion")
    private String religion; // TODO: convert to enum.
    /**
     * Height.
     */
    @Column(name="height")
    private float height;
    /**
     * Picture.
     */
    @Lob
    @Column(name="picture")
    private byte[] picture;
    /**
     * Martial Status.
     */
    @Column(name="maritial_status")
    private String maritialStatus; // TODO: convert to enum.
    /**
     * Occupation.
     */
    @Column(name="occupation")
    private String occupation;
    /**
     * About Me.
     */
    @Column(name="about_me")
    private String aboutMe;
    /**
     * Location.
     */
    @Column(name="location")
    private String location;
}
