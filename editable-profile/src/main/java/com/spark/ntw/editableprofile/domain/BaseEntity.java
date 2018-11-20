/**
*
 */

package com.spark.ntw.editableprofile.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * Base Class for all the entities.
 * 
 * @author Natesh Kurup
 *         <p/>
 *         Created Date: Nov 20, 2018
 *
 */
@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    /**
     * Primary Key.
     */
    @Id
    @Column(
            name = "id",
            nullable = false,
            updatable = false)
    @GeneratedValue
    long id;

    /**
     * Created by.
     */
    @Column(
            name = "created_by",
            updatable = false,
            nullable = false)
    String createdBy;
    /**
     * Created On Date.
     */
    @Column(
            name = "created_date",
            updatable = false,
            nullable = false)
    Instant createdDate;
    /**
     * Modified by.
     */
    @Column(
            name = "modified_by")
    String modifiedBy;
    /**
     * Modified on Date.
     */
    @Column(
            name = "modified_date")
    Instant modifiedDate;
}
