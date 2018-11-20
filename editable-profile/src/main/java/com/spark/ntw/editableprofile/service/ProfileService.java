/**
 * 
 */
package com.spark.ntw.editableprofile.service;

import java.util.List;

import com.spark.ntw.editableprofile.dto.ListProfileDto;
import com.spark.ntw.editableprofile.dto.ProfileDto;

/**
 * @author nkurup
 *
 */
public interface ProfileService {

	List<ListProfileDto> getAllProfiles();
	
	ProfileDto getProfile(final long id);
	
	long saveProfile(final ProfileDto profile);
	
	boolean removeProfile(final long id);
}
