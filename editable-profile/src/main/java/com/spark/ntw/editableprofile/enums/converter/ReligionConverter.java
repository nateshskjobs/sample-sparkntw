/**
*
 */
package com.spark.ntw.editableprofile.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;

import com.spark.ntw.editableprofile.enums.LocationEnum;
import com.spark.ntw.editableprofile.enums.MaritialStatusEnum;
import com.spark.ntw.editableprofile.enums.ReligionEnum;

/**
 * @author Natesh Kurup
*  <p/>Created Date: Nov 27, 2018
 *
 */
@Converter
public class ReligionConverter  implements AttributeConverter<ReligionEnum, String> {

    @Override
    public String convertToDatabaseColumn(ReligionEnum val) {
        String data="";
        if(null!=val){
            data=val.name();
        }
        return data;
    }

    @Override
    public ReligionEnum convertToEntityAttribute(String val) {
        ReligionEnum data=null;
        if(StringUtils.isNotEmpty(val)){
            data=data.valueOf(val);
        }
        return data;
    }

}
