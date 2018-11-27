/**
*
 */

package com.spark.ntw.editableprofile.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum for Gender.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 24, 2018
 *
 */
public enum GenderEnum {
    MALE('M'), FEMALE('F');

    /**
     * Type of gender.
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
                genderMap.put(g.getType(), g.name());
        }
        return genderMap;
    }

    /**
     * Derive the enum from the type.
     * 
     * @param type
     * @return {@link GenderEnum}
     */
    public static GenderEnum fromType(final char type) {
        GenderEnum val = null;
        for (GenderEnum g : GenderEnum.values()) {
            if (g.type == type) {
                val = g;
                break;
            }
        }
        return val;
    }
}
