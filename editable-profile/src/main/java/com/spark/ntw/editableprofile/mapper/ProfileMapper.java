/**
 * 
 */

package com.spark.ntw.editableprofile.mapper;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.spark.ntw.editableprofile.domain.Profile;
import com.spark.ntw.editableprofile.dto.ProfileDto;
import com.spark.ntw.editableprofile.enums.EthinicityEnum;
import com.spark.ntw.editableprofile.enums.LocationEnum;
import com.spark.ntw.editableprofile.enums.MaritialStatusEnum;
import com.spark.ntw.editableprofile.enums.ReligionEnum;

/**
 * @author nkurup
 *
 * @created_Date Nov 22, 2018
 *
 */

@Mapper
public abstract class ProfileMapper {

    /**
     * @param dto
     * @return
     */
    @Mappings({
        @Mapping(
                target = "dateOfBirth",
                source = "dateOfBirth",
                dateFormat = "dd/MM/yyyy")
        // ,@Mapping(target="maritialStatus", source="maritialStatus")
    })
    public abstract Profile toEntity(final ProfileDto dto);

    /**
     * @param entity
     * @return
     */
    @Mappings({
        @Mapping(
                target = "dateOfBirth",
                source = "dateOfBirth",
                dateFormat = "dd/MM/yyyy")
        // , @Mapping(target="maritialStatus", source="maritialStatus")
    })
    public abstract ProfileDto toDto(final Profile entity);

    /**
     * @param val
     * @return
     */
    String toString(final MaritialStatusEnum val) {
        return (null!=val)?val.name():"";
    }

    /**
     * @param val
     * @return
     */
    String toString(final EthinicityEnum val) {
        return (null!=val)?val.name():"";
    }

    /**
     * @param val
     * @return
     */
    String toString(final ReligionEnum val) {
        return (null!=val)?val.name():"";
    }

    /**
     * @param val
     * @return
     */
    String toString(final LocationEnum val) {
        return (null!=val)?val.name():"";
    }

    /**
     * @param val
     * @return
     */
    MaritialStatusEnum toMaritialStatus(final String val) {
        MaritialStatusEnum retVal = null;
        if (StringUtils.isNotBlank(val)) {
            retVal = MaritialStatusEnum.valueOf(val);
        }
        return retVal;
    }

    /**
     * @param val
     * @return
     */
    EthinicityEnum toEthinicityEnum(final String val) {
        EthinicityEnum retVal = null;
        if (StringUtils.isNotBlank(val)) {
            retVal = EthinicityEnum.valueOf(val);
        }
        return retVal;
    }

    ReligionEnum toReligionEnum(final String val) {
        ReligionEnum retVal = null;
        if (StringUtils.isNotBlank(val)) {
            retVal = ReligionEnum.valueOf(val);
        }
        return retVal;
    }

    /**
     * @param val
     * @return
     */
    LocationEnum toLocationEnum(final String val) {
        LocationEnum retVal = null;
        if (StringUtils.isNotBlank(val)) {
            retVal = LocationEnum.valueOf(val);
        }
        return retVal;
    }
}
