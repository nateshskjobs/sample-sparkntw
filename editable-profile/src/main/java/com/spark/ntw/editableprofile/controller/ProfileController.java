/**
*
 */

package com.spark.ntw.editableprofile.controller;

import java.util.List;
import java.util.Optional;

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

import com.spark.ntw.editableprofile.domain.Profile;
import com.spark.ntw.editableprofile.dto.ListProfileDto;
import com.spark.ntw.editableprofile.dto.ProfileDto;
import com.spark.ntw.editableprofile.dto.ProfileViewDto;
import com.spark.ntw.editableprofile.enums.EthinicityEnum;
import com.spark.ntw.editableprofile.enums.GenderEnum;
import com.spark.ntw.editableprofile.enums.LocationEnum;
import com.spark.ntw.editableprofile.enums.MaritialStatusEnum;
import com.spark.ntw.editableprofile.enums.ReligionEnum;
import com.spark.ntw.editableprofile.exception.ApplicationException;
import com.spark.ntw.editableprofile.service.ProfileService;

/**
 * Controller class for Profile. Functionalities provided include <br/>
 * <li>Getting all the profiles.</li>
 * <li>Get a particular profile.</li>
 * <li>Save and update a profile.</li>
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 23, 2018
 *
 */
@Controller
@RequestMapping("/profile-api")
public class ProfileController {
    private final static  Logger log = LoggerFactory.getLogger(ProfileController.class);

    /**
     * Service Class.
     */
    @Autowired
    private ProfileService service;

    /**
     * Default Constructor.
     */
    public ProfileController() {
    }

    /**
     * Get all the existing profiles and include it in the Model.
     * 
     * @param model
     *        - the model to be used in the view.
     * @return String - the listing page which is the view.
     */
    @GetMapping("/profiles-list")
    public String getAllProfiles(Model model) {
        model.addAttribute("profiles", this.getAllListProfiles());
        return "profileListing";
    }

    /**
     * Get the profile identified by the 'id' parameter. <br/>
     * If the id is zero then assume a new record to be created and display an empty scree.<br/>
     * If id is non zero then assume an update and fetch the record, populate the model to be
     * displayed on the UI.<br/>
     * 
     * @param id
     *        - the profile to be fetched.
     * @param model
     *        - the model to be used in the UI.
     * @return String - the profile view.
     */
    @GetMapping("/profiles/{id}")
    public String getProfile(@PathVariable(
            name = "id") final long id, final Model model) {
        // for an existing record.
        if (id > 0) {
            model.addAttribute("profile", this.getProfileDetails(id));
        }
        // for an new record the id will be 0, in which an empty DTO is mapped.
        else {
            ProfileDto dto=new ProfileDto();
            dto.setNewRecord(true);
            model.addAttribute("profile", dto);
        }
        // populate data for the drop downs and radio buttons.
        this.populateMasterData(model);
        return "profile";
    }

    /**
     * Get the data for the drop-downs and radio buttons on the UI.<br/>
     * Include the data in the model to be consumed by the UI.<br/>
     * <p/>
     * 
     * <pre>
     * NOTE: Instead of calling REST endpoints for getting the data using Enums to provide the data.
     * </pre>
     * 
     * @param model
     *        - the model which needs to be populated.
     */
    private void populateMasterData(final Model model) {
        // include genderMap.
        model.addAttribute("genderValues", GenderEnum.getAllValues());
        // include maritial Status.
        model.addAttribute("maritialStatuses", MaritialStatusEnum.getAllValues());
        // populate etinicities.
        model.addAttribute("ethinicities", EthinicityEnum.getAllValues());
        // populate the religions.
        model.addAttribute("religions", ReligionEnum.getAllValues());
        // populate the locations.
        model.addAttribute("locations", LocationEnum.getAllValues());
    }

    /**
     * Get the Profile details for the given id. If the id is incorrect then throw an exception.
     * 
     * @param id
     * @return {@link ProfileDto}
     */
    private ProfileDto getProfileDetails(long id) {
        ProfileDto dto = null;
        if (id > 0) {
            dto = this.service.getProfile(id);
        }
        else {
            throw ApplicationException.getInstance("Incorrect Id.", Optional.empty());
        }
        return dto;
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
    public String saveProfile(@Valid @ModelAttribute("profile") final ProfileDto profile,
            final BindingResult result, final Model model) {
        String nextView = "";
        if (result.hasErrors()) {
            this.populateMasterData(model);
            nextView = "profile";
        }
        else {
            service.saveProfile(profile);
            nextView = this.getAllProfiles(model);
        }

        return nextView;
    }

    /**
     * Will fetch the {@link Profile} identified by the id<br/>
     * transform the {@link Profile} to DTO. <br/>
     * Include the Dto in the map.<br/>
     * Navigate to the view screen.
     * 
     * @param id
     *        - id of the profile to be fetched.
     * @param model
     *        - the model to be used in the UI.
     * @return String - the view to be displayed.
     */
    @GetMapping("profiles-view/{id}")
    public String getProfileForView(@PathVariable(
            name = "id") final long id, final Model model) {
        ProfileViewDto dto=this.service.getProfileForView(id);
        model.addAttribute("profile", dto);
        return "profileView";
    }
}
