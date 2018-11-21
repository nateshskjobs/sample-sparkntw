/**
 * 
 */
package com.spark.ntw.editableprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spark.ntw.editableprofile.domain.Profile;

/**
 * @author nkurup
 *
 * @created_Date Nov 21, 2018
 *
 */
public interface ProfileRepository 
extends JpaRepository<Profile, Long>{

}
