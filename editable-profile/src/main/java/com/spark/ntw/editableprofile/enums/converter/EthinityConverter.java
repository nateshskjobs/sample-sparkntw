/**
*
 */

package com.spark.ntw.editableprofile.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;

import com.spark.ntw.editableprofile.enums.EthinicityEnum;

/**
 * Converter for {@link EthinicityEnum}.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 27, 2018
 *
 */
@Converter
public class EthinityConverter implements AttributeConverter<EthinicityEnum, String> {

    /*
     * (non-Javadoc)
     * 
     * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
     */
    @Override
    public String convertToDatabaseColumn(EthinicityEnum val) {
        String data = "";
        if (null != val) {
            data = val.name();
        }
        return data;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
     */
    @Override
    public EthinicityEnum convertToEntityAttribute(String val) {
        EthinicityEnum data = null;
        if (StringUtils.isNotEmpty(val)) {
            data = data.valueOf(val);
        }
        return data;
    }

}
