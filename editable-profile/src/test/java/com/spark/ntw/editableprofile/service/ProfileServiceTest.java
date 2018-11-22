/**
*
 */

package com.spark.ntw.editableprofile.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;
import org.springframework.boot.test.context.SpringBootTest;

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
// @RunWith(MockitoJUnitRunner.class)
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
        profileService.getAllProfiles();
    }

    @Test
    public void getProfile() {
        final long id=0L;
        profileService.getProfile(id);
    }

    @Test
    public void saveProfile() {
        final ProfileDto profile=null;
        profileService.saveProfile(profile);
    }

    @Test
    public void removeProfile() {
        final long id=0L;
        profileService.removeProfile(id);
    }
}
