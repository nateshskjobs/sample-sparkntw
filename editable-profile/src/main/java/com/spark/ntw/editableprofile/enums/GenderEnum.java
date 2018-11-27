/**
*
 */

package com.spark.ntw.editableprofile.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 24, 2018
 *
 */
public enum GenderEnum {
    MALE('M'), FEMALE('F'), UNKNOWN('O');

    /**
     * 
     */
    char type;

    /**
     * @param gender
     */
    GenderEnum(final char gender) {
        this.type = gender;
    }

    /**
     * @return
     */
    public char getType() {
        return type;
    }

    /**
     * Return Map containing key value pair of type and name.
     * 
     * @return
     */
    public static Map<Character, String> getAllValues() {
        final Map<Character, String> genderMap = new HashMap<>();
        for (GenderEnum g : GenderEnum.values()) {
            if (UNKNOWN != g) {
                genderMap.put(g.getType(), g.name());
            }
        }
        return genderMap;
    }
}
