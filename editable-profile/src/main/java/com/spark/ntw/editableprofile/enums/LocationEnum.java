/**
*
 */
package com.spark.ntw.editableprofile.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Natesh Kurup
*  <p/>Created Date: Nov 26, 2018
 *
 */
public enum LocationEnum {
    BERLIN,
    MUMBAI,
    UNKNOWN;

    public static List<String> getAllValues(){
        List<String> values=new ArrayList<>();
        for(LocationEnum e: LocationEnum.values()){
            values.add(e.name());
        }
        return values;
    }
}
