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
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
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
import com.spark.ntw.editableprofile.dto.ProfileViewDto;
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
    ProfileService profileService = new ProfileServiceImpl();

    @Mock
    ProfileRepository profileRepo;

    private static Validator validator;

    /**
     * 
     */
    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        profileService = new ProfileServiceImpl();
        Whitebox.setInternalState(profileService, "repo", profileRepo);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetAllProfiles() {
        final List<Profile> profiles = new ArrayList<>();
        profiles.add(this.createProfile(100));
        Mockito.when(profileRepo.findAll()).thenReturn(profiles);
        final List<ListProfileDto> dtos = profileService.getAllProfiles();
        assertNotEquals(dtos, null);
    }

    /**
     * @param profiles
     */
    private Profile createProfile(final long id) {
        final Profile profile = new Profile();
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
        final ProfileDto profile = new ProfileDto();
        profile.setId(id);
        profile.setDisplayName("dummy");
        profile.setDateOfBirth("11/11/2018");
        profile.setGender('M');
        profile.setAboutMe("Test About Me");
        //profile.setEthinicity(EthinicityEnum.ASIAN.name());
        //profile.setLocation(LocationEnum.MUMBAI.name());
        //profile.setMaritialStatus(MaritialStatusEnum.SINGLE.name());
        profile.setOccupation("Occupation Test");
        profile.setRealName("Real Name");
        //profile.setReligion(ReligionEnum.HINDU.name());
        return profile;
    }

    @Test
    public void testGetProfile() {
        final long id = 101L;
        Mockito.when(profileRepo.findOne(id)).thenReturn(this.createProfile(id));
        final ProfileDto dto = profileService.getProfile(id);
        assertEquals(101L, dto.getId());
    }

    @Test
    public void testSaveProfile() {
        final ProfileDto dto = this.createProfileDto(103L);
        //check the validations
        Set<ConstraintViolation<ProfileDto>> exceptions=validator.validate(dto);
        assertNotEquals(null, exceptions);
        Mockito.when(profileRepo.save(any(Profile.class))).thenReturn(this.createProfile(104L));
        final long id = profileService.saveProfile(dto);
        assertEquals(104L, id);
    }
    
    @Test
    public void testInvlaidSaveForInvalidHtml(){
        final ProfileDto dto=this.createProfileDto(300L);
        dto.setAboutMe("<html><script>alert('Hi')</script></html>");
        Set<ConstraintViolation<ProfileDto>> exceptions=validator.validate(dto);
        assertNotEquals(null, exceptions);
    }
    
    @Test
    public void testInvlaidSaveForMandatoryValues(){
        final ProfileDto dto=this.createProfileDto(300L);
        dto.setMaritialStatus(null);
        Set<ConstraintViolation<ProfileDto>> exceptions=validator.validate(dto);
        assertNotEquals(null, exceptions);
    }
    
    @Test
    public void testGetProfileForView(){
        final long id = 102L;
        Mockito.when(profileRepo.findOne(id)).thenReturn(this.createProfile(id));
        final ProfileViewDto dto = profileService.getProfileForView(id);
        assertNotEquals(null, dto);
        
    }
}
