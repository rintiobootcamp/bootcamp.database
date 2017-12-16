package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Archange on 04/12/2017.
 */
@Entity
@ApiModel(value = "Censure", description = "Descripition of a Censure")
public class Censure implements Serializable {

    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String entityType;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int entityId;

    @ApiModelProperty(value = "creation date of the Censure")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateCreation;

    @ApiModelProperty(value = "update date of the Censure")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateMiseAJour;

    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 1024)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String message;

    /**
     * Get the censeor id
     *
     * @return the censor id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the censeor id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the censeor entity type
     *
     * @return the censor entity type
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * Set the censeor entity type
     *
     * @param entityType the entity type to set
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * Get the censeor entity id
     *
     * @return the censor entity id
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Set the censeor entity id
     *
     * @param entityId the entity id to set
     */
    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    /**
     * Get the censeor creation date
     *
     * @return the censor creation date
     */
    public long getDateCreation() {
        return dateCreation;
    }

    /**
     * Set the censeor creation date
     *
     * @param dateCreation the date to set
     */
    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Get the censeor update date
     *
     * @return the censor update date
     */
    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    /**
     * Set the censeor update date
     *
     * @param dateMiseAJour the date to set
     */
    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    /**
     * Get the censeor message
     *
     * @return the censor message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the censeor message
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
