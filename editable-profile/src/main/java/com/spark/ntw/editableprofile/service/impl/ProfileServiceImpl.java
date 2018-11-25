/**
 * 
 */

package com.spark.ntw.editableprofile.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spark.ntw.editableprofile.domain.Profile;
import com.spark.ntw.editableprofile.dto.ListProfileDto;
import com.spark.ntw.editableprofile.dto.ProfileDto;
import com.spark.ntw.editableprofile.mapper.ProfileMapper;
import com.spark.ntw.editableprofile.repository.ProfileRepository;
import com.spark.ntw.editableprofile.service.ProfileService;

/**
 * @author nkurup
 *
 */
@Service
public class ProfileServiceImpl implements ProfileService {
    final Logger log = LoggerFactory.getLogger(ProfileServiceImpl.class);
    @Autowired
    ProfileRepository repo;

    ProfileMapper mapper;

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.ntw.editableprofile.service.ProfileService#getAllProfiles()
     */
    @Override
    @Transactional(
            readOnly = true)
    public List<ListProfileDto> getAllProfiles() {
        final List<Profile> profiles = repo.findAll();
        List<ProfileDto> profileDtos = new ArrayList<>();
        List<ListProfileDto> listProfileDtos = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(profiles)) {
            listProfileDtos = profiles.stream().map(p -> {
                final ListProfileDto dto = new ListProfileDto();
                dto.setDateOfBirth(p.getDateOfBirth());
                dto.setDisplayName(p.getDisplayName());
                dto.setGender(p.getGender());
                dto.setId(p.getId());
                dto.setLocation(p.getLocation());
                dto.setUrl("");
                return dto;
            }).collect(Collectors.toList());
        }
        return listProfileDtos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.ntw.editableprofile.service.ProfileService#getProfile(long)
     */
    @Override
    @Transactional(
            readOnly = true)
    public ProfileDto getProfile(long id) {
        final Profile profile= this.repo.findOne(id);
        final ProfileMapper mapper=Mappers.getMapper(ProfileMapper.class);
        return mapper.toDto(profile);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.ntw.editableprofile.service.ProfileService#saveProfile(com.spark.ntw.
     * editableprofile.dto.ProfileDto)
     */
    @Override
    @Transactional
    public long saveProfile(ProfileDto dto) {
        final ProfileMapper mapper = Mappers.getMapper(ProfileMapper.class);
        Profile profile = mapper.toEntity(dto);
        profile=repo.save(profile);
        log.debug("Saved Record !!!!");
        return profile.getId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.ntw.editableprofile.service.ProfileService#removeProfile(long)
     */
    @Override
    @Transactional
    public boolean removeProfile(long id) {
        // TODO Auto-generated method stub
        return false;
    }

}
