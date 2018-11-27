/**
*
 */

package com.spark.ntw.editableprofile.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 26, 2018
 *
 */
public enum ReligionEnum {
    CHRISTIAN, ISLAM, HINDU, UNKNOWN;

    public static List<String> getAllValues() {
        List<String> values = new ArrayList<>();
        for (ReligionEnum e : ReligionEnum.values()) {
            values.add(e.name());
        }
        return values;
    }
}
