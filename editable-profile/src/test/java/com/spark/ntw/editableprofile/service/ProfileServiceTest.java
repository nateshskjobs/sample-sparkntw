/**
*
 */

package com.spark.ntw.editableprofile.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.boot.test.context.SpringBootTest;

import com.spark.ntw.editableprofile.domain.Profile;
import com.spark.ntw.editableprofile.dto.ListProfileDto;
import com.spark.ntw.editableprofile.dto.ProfileDto;
import com.spark.ntw.editableprofile.mapper.ProfileMapper;
import com.spark.ntw.editableprofile.repository.ProfileRepository;
import com.spark.ntw.editableprofile.service.impl.ProfileServiceImpl;

/**
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 22, 2018
 *
 */
@SpringBootTest
public class ProfileServiceTest {
    @InjectMocks
    ProfileService profileService=new ProfileServiceImpl();

    @Mock
    ProfileRepository profileRepo;

    @Mock
    ProfileMapper profileMapper;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        profileService = new ProfileServiceImpl();
        Whitebox.setInternalState(profileService, "repo", profileRepo);
        Whitebox.setInternalState(profileService, "mapper", profileMapper);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetAllProfiles() {
        final List<Profile> profiles=new ArrayList<>();
        profiles.add(this.createProfile(100));
        Mockito.when(profileRepo.findAll()).thenReturn(profiles);
        final List<ListProfileDto> dtos= profileService.getAllProfiles();
        assertNotEquals(dtos, null);
    }

    /**
     * @param profiles
     */
    private Profile createProfile(final long id) {
        final Profile profile=new Profile();
        profile.setId(id);
        profile.setDisplayName("dummy");
        profile.setDateOfBirth(LocalDate.now());
        profile.setGender('M');
        return profile;
    }

    /**
     * @param profiles
     */
    private ProfileDto createProfileDto(final long id) {
        final ProfileDto profile=new ProfileDto();
        profile.setId(id);
        profile.setDisplayName("dummy");
        profile.setDateOfBirth(LocalDate.now());
        profile.setGender('M');
        return profile;
    }
    
    @Test
    public void getProfile() {
        final long id=101L;
        Mockito.when(profileRepo.findOne(id) ).thenReturn(this.createProfile(id));
        final ProfileDto dto= profileService.getProfile(id);
        assertEquals(101L, dto.getId());
    }

    @Test
    public void saveProfile() {
        final ProfileDto dto=this.createProfileDto(103L);
        Mockito.when(profileRepo.save(any(Profile.class)) ).thenReturn(this.createProfile(104L));
        final long id=profileService.saveProfile(dto);
        assertEquals(104L, id);
    }

    
}
