/**
 * 
 */
package com.spark.ntw.editableprofile.mapper;

import org.mapstruct.Mapper;

import com.spark.ntw.editableprofile.domain.Profile;
import com.spark.ntw.editableprofile.dto.ProfileDto;

/**
 * @author nkurup
 *
 * @created_Date Nov 22, 2018
 *
 */

@Mapper
public interface ProfileMapper {

	/**
	 * @param dto
	 * @return
	 */
	Profile toEntity(final ProfileDto dto);
	
	/**
	 * @param entity
	 * @return
	 */
	ProfileDto toDto(final Profile entity);
}
