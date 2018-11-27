/**
*
 */

package com.spark.ntw.editableprofile.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.spark.ntw.editableprofile.enums.EthinicityEnum;
import com.spark.ntw.editableprofile.enums.LocationEnum;
import com.spark.ntw.editableprofile.enums.MaritialStatusEnum;
import com.spark.ntw.editableprofile.enums.ReligionEnum;
import com.spark.ntw.editableprofile.enums.converter.EthinityConverter;
import com.spark.ntw.editableprofile.enums.converter.LocationConverter;
import com.spark.ntw.editableprofile.enums.converter.MaritialStatusConverter;
import com.spark.ntw.editableprofile.enums.converter.ReligionConverter;

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
@EqualsAndHashCode(
        callSuper = false)
public class Profile extends BaseEntity implements Serializable {
    /**
     * Display Name.
     */
    @Column(
            name = "display_name")
    @NotNull
    @Size(
            min = 1,
            max = 256)
    private String displayName;
    /**
     * Real Name.
     */
    @NotNull
    @Column(
            name = "real_name")
    @Size(
            min = 1,
            max = 256)
    private String realName;
    /**
     * Date Of Birth.
     */
    @Column(
            name = "dob")
    @NotNull
    private LocalDate dateOfBirth;
    /**
     * Gender.
     */
    @Column(
            name = "gender")
    @NotNull
    private char gender;
    /**
     * Ethinicity.
     */
    @Column(
            name = "ethinicity")
    @Convert(converter=EthinityConverter.class)
    private EthinicityEnum ethinicity;
    /**
     * Religion.
     */
    @Column(
            name = "religion")
    @Convert(converter=ReligionConverter.class)
    private ReligionEnum religion; // TODO: convert to enum.
    /**
     * Height.
     */
    @Column(
            name = "height")
    private float height;
    /**
     * Picture.
     */
    @Lob
    @Column(
            name = "picture")
    private byte[] picture;
    /**
     * Martial Status.
     */
    @Column(
            name = "maritial_status")
    @NotNull
    @Convert(converter=MaritialStatusConverter.class)
    private MaritialStatusEnum  maritialStatus; 
    /**
     * Occupation.
     */
    @Column(
            name = "occupation")
    @Size(max=256)
    private String occupation;
    /**
     * About Me.
     */
    @Column(
            name = "about_me")
    @Size(max=5000)
    private String aboutMe;
    /**
     * Location.
     */
    @Column(
            name = "location")
    @NotNull
    @Convert(converter=LocationConverter.class)
    private LocationEnum location;
}
