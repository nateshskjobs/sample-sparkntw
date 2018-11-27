/**
*
 */

package com.spark.ntw.editableprofile.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum for Ethinicity.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 26, 2018
 *
 */
public enum EthinicityEnum {
    EUROPEAN, ASIAN, AMERICAN;

    /**
     * Will return names of all the enum instance.
     * 
     * @return {@link List}
     */
    public static List<String> getAllValues() {
        List<String> values = new ArrayList<>();
        for (EthinicityEnum e : EthinicityEnum.values()) {
            values.add(e.name());
        }
        return values;
    }
}
