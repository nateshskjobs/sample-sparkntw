/**
*
 */

package com.spark.ntw.editableprofile.enums.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.spark.ntw.editableprofile.enums.GenderEnum;

/**
 * Coverter for {@link GenderEnum}.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 27, 2018
 *
 */
@Converter
public class GenderConverter implements AttributeConverter<GenderEnum, Character> {

    /* (non-Javadoc)
     * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
     */
    @Override
    public Character convertToDatabaseColumn(final GenderEnum val) {
        Character data = null;
        if (null != val) {
            data = val.getType();
        }
        return data;
    }

    /* (non-Javadoc)
     * @see javax.persistence.AttributeConverter#convertToEntityAttribute(java.lang.Object)
     */
    @Override
    public GenderEnum convertToEntityAttribute(Character val) {
        GenderEnum data = null;
        if (null != val) {
            for (GenderEnum g : GenderEnum.values()) {
                if (g.getType() == val) {
                    data = g;
                    break;
                }
            }
        }
        return data;
    }

}
