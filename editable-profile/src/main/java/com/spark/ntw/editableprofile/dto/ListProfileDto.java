/**
 * 
 */

package com.spark.ntw.editableprofile.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

/**
 * @author nkurup
 *
 * @created_Date Nov 21, 2018
 *
 */
@Data
public class ListProfileDto implements Serializable {
    /**
     * id of the profile.
     */
    private long id;
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
     * Location.
     */
    private String location;

    /**
     * URL for opening profile.
     */
    private String url;
}
