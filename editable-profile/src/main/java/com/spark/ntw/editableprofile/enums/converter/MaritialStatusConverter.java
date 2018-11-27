/**
*
 */

package com.spark.ntw.editableprofile.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.apache.commons.lang3.StringUtils;

import com.spark.ntw.editableprofile.enums.LocationEnum;
import com.spark.ntw.editableprofile.enums.MaritialStatusEnum;

/**
 * Converter for {@link MaritialStatusEnum}.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 27, 2018
 *
 */
@Converter
public class MaritialStatusConverter implements AttributeConverter<MaritialStatusEnum, String> {

    /* (non-Javadoc)
     * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
     */
    @Override
    public String convertToDatabaseColumn(MaritialStatusEnum val) {
        String data = "";
        if (null != val) {
            data = val.name();
        }
        return data;
    }

    /* (non-Javadoc)
     * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
     */
    @Override
    public MaritialStatusEnum convertToEntityAttribute(String val) {
        MaritialStatusEnum data = null;
        if (StringUtils.isNotEmpty(val)) {
            data = data.valueOf(val);
        }
        return data;
    }

}
