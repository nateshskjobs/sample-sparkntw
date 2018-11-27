/**
*
 */
package com.spark.ntw.editableprofile.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;

import com.spark.ntw.editableprofile.enums.LocationEnum;

/**
 * @author Natesh Kurup
*  <p/>Created Date: Nov 27, 2018
 *
 */
@Converter
public class LocationConverter  implements AttributeConverter<LocationEnum, String> {

    @Override
    public String convertToDatabaseColumn(LocationEnum val) {
        String data="";
        if(null!=val){
            data=val.name();
        }
        return data;
    }

    @Override
    public LocationEnum convertToEntityAttribute(String val) {
        LocationEnum data=null;
        if(StringUtils.isNotEmpty(val)){
            data=data.valueOf(val);
        }
        return data;
    }

}
