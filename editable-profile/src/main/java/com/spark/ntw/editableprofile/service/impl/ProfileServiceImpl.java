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
import com.spark.ntw.editableprofile.dto.ProfileViewDto;
import com.spark.ntw.editableprofile.enums.GenderEnum;
import com.spark.ntw.editableprofile.mapper.ProfileMapper;
import com.spark.ntw.editableprofile.mapper.ProfileViewMapper;
import com.spark.ntw.editableprofile.repository.ProfileRepository;
import com.spark.ntw.editableprofile.service.ProfileService;

/**
 * @author nkurup
 *
 */
@Service
public class ProfileServiceImpl implements ProfileService {
    final static Logger log = LoggerFactory.getLogger(ProfileServiceImpl.class);
    @Autowired
    ProfileRepository repo;

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.ntw.editableprofile.service.ProfileService#getAllProfiles()
     */
    @Override
    @Transactional(
            readOnly = true)
    public List<ListProfileDto> getAllProfiles() {
        // get all the profiles.
        final List<Profile> profiles = repo.findAll();
        List<ListProfileDto> listProfileDtos = new ArrayList<>();
        // transform each Profile to ListProfile.
        if (CollectionUtils.isNotEmpty(profiles)) {
            listProfileDtos = profiles.stream().map(p -> {
                final ListProfileDto dto = new ListProfileDto();
                dto.setDateOfBirth(p.getDateOfBirth());
                dto.setDisplayName(p.getDisplayName());
                dto.setGender(p.getGender());
                dto.setId(p.getId());
                if (null != p.getLocation()) {
                    dto.setLocation(p.getLocation().name());
                }
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
        final Profile profile = this.repo.findOne(id);
        final ProfileMapper mapper = Mappers.getMapper(ProfileMapper.class);
        final ProfileDto dto = mapper.toDto(profile);
        dto.setNewRecord(false);
        return dto;
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
        profile = repo.save(profile);
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

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.ntw.editableprofile.service.ProfileService#getProfileForView(long)
     */
    @Override
    public ProfileViewDto getProfileForView(long id) {
        final Profile profile = this.repo.findOne(id);
        final ProfileViewMapper mapper = Mappers.getMapper(ProfileViewMapper.class);
        final ProfileViewDto dto = mapper.toDto(profile);
        if(dto.getGender()!=' '){
            GenderEnum val=GenderEnum.fromType(dto.getGender());
            if(null!=val){
                dto.setGenderName(val.name());
            }
        }
        return dto;
    }

}
