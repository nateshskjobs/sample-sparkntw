/**
 * 
 */
package com.spark.ntw.editableprofile.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.spark.ntw.editableprofile.dto.ListProfileDto;
import com.spark.ntw.editableprofile.dto.ProfileDto;
import com.spark.ntw.editableprofile.mapper.ProfileMapper;
import com.spark.ntw.editableprofile.repository.ProfileRepository;
import com.spark.ntw.editableprofile.service.ProfileService;

/**
 * @author nkurup
 *
 */
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	ProfileRepository repo;
	
	@Autowired
	ProfileMapper mapper;

	/* (non-Javadoc)
	 * @see com.spark.ntw.editableprofile.service.ProfileService#getAllProfiles()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<ListProfileDto> getAllProfiles() {
		// TODO Auto-generated method 
	    System.out.println("Inside getAllProfiles");
		return null;
	}

	/* (non-Javadoc)
	 * @see com.spark.ntw.editableprofile.service.ProfileService#getProfile(long)
	 */
	@Override
	@Transactional(readOnly=true)
	public ProfileDto getProfile(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.spark.ntw.editableprofile.service.ProfileService#saveProfile(com.spark.ntw.editableprofile.dto.ProfileDto)
	 */
	@Override
	@Transactional
	public long saveProfile(ProfileDto profile) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.spark.ntw.editableprofile.service.ProfileService#removeProfile(long)
	 */
	@Override
	@Transactional
	public boolean removeProfile(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
