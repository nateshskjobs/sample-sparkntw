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
public enum MaritialStatusEnum {
    SINGLE, MARRIED, WIDOWED, DIVORCED, UNKNOWN;
    
    public static List<String> getAllValues() {
        List<String> values = new ArrayList<>();
        for (MaritialStatusEnum e : MaritialStatusEnum.values()) {
            values.add(e.name());
        }
        return values;
    }

}
