/**
*
 */
package com.spark.ntw.editableprofile.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDate;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.spark.ntw.editableprofile.domain.Profile;
import com.spark.ntw.editableprofile.enums.EthinicityEnum;
import com.spark.ntw.editableprofile.enums.LocationEnum;
import com.spark.ntw.editableprofile.enums.MaritialStatusEnum;
import com.spark.ntw.editableprofile.enums.ReligionEnum;

/**
 * @author Natesh Kurup
*  <p/>Created Date: Nov 26, 2018
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private ProfileRepository repo;
    
    private Profile profile;
    
    /**
     * Initialization.
     */
    @Before
    public void init() {
        profile=this.createInstance();
        entityManager.persist(profile);
        entityManager.flush();
    }

    /**
     * 
     */
    private Profile createInstance() {
        final Profile profile=new Profile();
        profile.setDisplayName("Dummy User");
        profile.setDateOfBirth(LocalDate.now());
        profile.setGender('M');
        profile.setAboutMe("Test Data");
        profile.setEthinicity(EthinicityEnum.ASIAN);
        profile.setId(0L);
        profile.setLocation(LocationEnum.MUMBAI);
        profile.setMaritialStatus(MaritialStatusEnum.SINGLE);
        profile.setOccupation("MISC");
        profile.setRealName("Dummy Real Name");
        profile.setReligion(ReligionEnum.HINDU);
        
        return profile;
    }
    
    @Test
    public void testFindById(){
        final Long id=profile.getId();
        final Profile profile =repo.findOne(id);
        assertNotEquals(null, profile);
    }

    @Test
    public void testNoFindById(){
        final Profile profile =repo.findOne(301L);
        assertEquals(null, profile);
    }
    
    @Test
    public void testValidSave(){
        final Profile profile=this.createInstance();
        repo.save(profile);
        assertNotEquals(profile.getId(), null);
    }
    
    @Test(expected=ConstraintViolationException.class)
    public void testInvlaidSaveForNullValue(){
        final Profile profile=this.createInstance();
        profile.setDisplayName(null);
        profile.setDateOfBirth(null);
        repo.save(profile);
    }

}
