/**
*
 */

package com.spark.ntw.editableprofile.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum for Location.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 26, 2018
 *
 */
public enum LocationEnum {
    BERLIN, MUMBAI;

    /**
     * Will return names of all the enum instances.
     * 
     * @return {@link List}
     */
    public static List<String> getAllValues() {
        List<String> values = new ArrayList<>();
        for (LocationEnum e : LocationEnum.values()) {
            values.add(e.name());
        }
        return values;
    }
}
