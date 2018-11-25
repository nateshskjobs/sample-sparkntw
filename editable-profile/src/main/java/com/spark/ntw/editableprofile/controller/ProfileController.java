/**
*
 */

package com.spark.ntw.editableprofile.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spark.ntw.editableprofile.dto.ListProfileDto;
import com.spark.ntw.editableprofile.dto.ProfileDto;
import com.spark.ntw.editableprofile.enums.GenderEnum;
import com.spark.ntw.editableprofile.service.ProfileService;

/**
 * Controller class for Profile.
 * <p/>
 * Includes methods supporting GET and POST methods.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 23, 2018
 *
 */
@Controller
@RequestMapping("/profile-api")
public class ProfileController {
    private final Logger log = LoggerFactory.getLogger(ProfileController.class);

    /**
     * Service Class.
     */
    @Autowired
    ProfileService service;

    /**
     * Map containing key value pair of type and name.
     */
    final Map<Character, String> genderMap = new HashMap<>();

    /**
     * Default Constructor.
     */
    public ProfileController() {
        // populate the genderMap.
        for (GenderEnum g : GenderEnum.values()) {
            genderMap.put(g.getType(), g.name());
        }
    }

    /**
     * Get all the existing profiles.
     * 
     * @param model
     * @return
     */
    @GetMapping("/profiles-list")
    public String getAllProfiles(Model model) {
        model.addAttribute("profiles", this.getAllListProfiles());
        return "profileListing";
    }

    /**
     * Get the profile identified by the 'id' parameter.
     * 
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/profiles/{id}")
    public String getProfile(@PathVariable(
            name = "id") final long id, final Model model) {
        int j=1/0;
        // for an existing record.
        if (id > 0) {
            model.addAttribute("profile", this.getProfile(id));
        }
        // for an new record the id will be 0, in which an empty DTO is mapped.
        else {
            model.addAttribute("profile", new ProfileDto());
        }

        // include genderMap.
        model.addAttribute("genderValues", genderMap);
        return "profile";
    }

    /**
     * Get the Profile details.
     * 
     * @param id
     * @return {@link ProfileDto}
     */
    private ProfileDto getProfile(long id) {
        return this.service.getProfile(id);
    }

    /**
     * Will return all the existing Profiles mapped to ListProfileDto..
     * 
     * @return {@link List}
     */
    private List<ListProfileDto> getAllListProfiles() {
        return service.getAllProfiles();
    }

    /**
     * Will persist the {@link ProfileDto}.
     * 
     * @param profile
     * @param model
     * @param result
     * @return String - will determine the next page to navigate to.
     */
    @PostMapping(
            value = "/profiles",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String saveProfile(@Valid @ModelAttribute("profile") final ProfileDto profile, final BindingResult result,final Model model) {
        String nextView="";
        if(result.hasErrors()){
            nextView="profile";
        }
        else{
            service.saveProfile(profile);
            nextView=this.getAllProfiles(model);
        }
        
        return  nextView;
    }

}
