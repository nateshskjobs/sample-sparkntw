/**
*
 */

package com.spark.ntw.editableprofile.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
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
    private String displayName;
    private String realName;
    private LocalDate dateOfBirth;
    private char gender;
    private String ethinicity; // TODO: convert to enum.
    private String religion; // TODO: convert to enum.
    private float height;
    // TODO: figure
    private String maritialStatus; // TODO: convert to enum.
    private String occupation;
    private String aboutMe;
    private String location;
}
