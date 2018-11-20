/**
 * 
 */
package com.spark.ntw.editableprofile.dto;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * @author nkurup
 *
 * @created_Date Nov 21, 2018
 *
 */
public class ListProfileDto implements Serializable {
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

}
