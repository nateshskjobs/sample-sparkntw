/**
 * 
 */

package com.spark.ntw.editableprofile.service;

import java.util.List;

import com.spark.ntw.editableprofile.domain.Profile;
import com.spark.ntw.editableprofile.dto.ListProfileDto;
import com.spark.ntw.editableprofile.dto.ProfileDto;

/**
 * Service class for Profile. Provides the following functionalites.<br/>
 * <li>get all the existing profiles.</li>
 * <li>get a particular profile.</li>
 * <li>create /update a profile.</li>
 * 
 * @author nkurup
 *
 */
public interface ProfileService {

    /**
     * Will get all the existing Profiles.<br/>
     * For each {@link Profile} transform the {@link Profile} to {@link ListProfileDto} and include
     * it in the List.
     * 
     * @return {@link List} - List Of {@link ListProfileDto}
     */
    List<ListProfileDto> getAllProfiles();

    /**
     * Get a particular {@link Profile} identified by id attribute.<br/>
     * Transform the {@link Profile} to {@link ProfileDto} and return the latter.
     * 
     * @param id
     * @return {@link ProfileDto}
     */
    ProfileDto getProfile(final long id);

    /**
     * Transform the {@link ProfileDto} to {@link Profile}.<br/>
     * Will persist the {@link Profile}, it could be Insert if the profile id is 0 or non existent
     * else will update an existing Profile.
     * 
     * @param profile
     * @return long- id of the Profile.
     */
    long saveProfile(final ProfileDto profile);

    /**
     * Delete an existing {@link Profile} identified by the id.
     * @param id
     * @return boolean - true if the {@link Profile} has been sucessfully deleted.
     */
    boolean removeProfile(final long id);
}
