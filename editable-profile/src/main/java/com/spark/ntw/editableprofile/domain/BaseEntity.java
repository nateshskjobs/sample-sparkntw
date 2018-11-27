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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    @Transient
    private final static Logger log=LoggerFactory.getLogger(BaseEntity.class);
    
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
    
    /**
     * Event Listener triggered before an entity is inserted.
     */
    @PrePersist
    public void beforeInsert() {
        log.debug("[NK] -> Inside Insert");
        this.createdBy = "dummy";
        this.createdDate = Instant.now();
        log.debug("[NK] -> Inside Insert, set audit data = {} / {} ", this.createdBy,
                this.createdDate);
    }

    /**
     * Event Listener triggered before an entity is updated.
     */
    @PreUpdate
    public void beforUpdate() {
        log.debug("[NK] -> Inside Update");
        this.modifiedBy = "dummy";
        this.modifiedDate = Instant.now();
        log.debug("[NK] -> Inside Update, set audit data = {} / {} ", this.modifiedBy,
                this.modifiedDate);
    }
    
}
