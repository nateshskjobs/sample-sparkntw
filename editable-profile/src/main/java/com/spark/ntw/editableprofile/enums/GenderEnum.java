/**
*
 */

package com.spark.ntw.editableprofile.enums;

/**
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 24, 2018
 *
 */
public enum GenderEnum {
    MALE('M'), FEMALE('F');

    char type;

    GenderEnum(final char gender) {
        this.type = gender;
    }

    public char getType(){
        return type;
    }
}
