/**
 * 
 */

package com.spark.ntw.editableprofile.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.spark.ntw.editableprofile.domain.Profile;
import com.spark.ntw.editableprofile.dto.ProfileViewDto;
import com.spark.ntw.editableprofile.enums.EthinicityEnum;
import com.spark.ntw.editableprofile.enums.LocationEnum;
import com.spark.ntw.editableprofile.enums.MaritialStatusEnum;
import com.spark.ntw.editableprofile.enums.ReligionEnum;

/**
 * Mapper to transfer data between {@link Profile} and {@link ProfileViewDto}.
 * 
 * @author nkurup
 *
 * @created_Date Nov 22, 2018
 *
 */

@Mapper
public abstract class ProfileViewMapper {

    /**
     * @param entity
     * @return
     */
    @Mappings({
        @Mapping(
                target = "dateOfBirth",
                source = "dateOfBirth",
                dateFormat = "dd/MM/yyyy")
    })
    public abstract ProfileViewDto toDto(final Profile entity);

    /**
     * @param val
     * @return
     */
    String toString(final MaritialStatusEnum val) {
        return (null != val) ? val.name() : "";
    }

    /**
     * @param val
     * @return
     */
    String toString(final EthinicityEnum val) {
        return (null != val) ? val.name() : "";
    }

    /**
     * @param val
     * @return
     */
    String toString(final ReligionEnum val) {
        return (null != val) ? val.name() : "";
    }

    /**
     * @param val
     * @return
     */
    String toString(final LocationEnum val) {
        return (null != val) ? val.name() : "";
    }
}
