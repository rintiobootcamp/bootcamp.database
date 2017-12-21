/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author leger
 */
@Entity
public class Debat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String entityType;

    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int entityId;

    @Lob
    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String sujet;

    @ApiModelProperty(value = "creation date of debat")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateCreation;

    @ApiModelProperty(value = "update date of debat")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateMiseAJour;

    /**
     * Get the debate Id
     *
     * @return the Id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the debate Id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the debate entity type
     *
     * @return the entity type
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * Set the debate entity type
     *
     * @param entityType the entity type to set
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * Get debate the entity id
     *
     * @return the entity id
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Set debate the entity id
     *
     * @param entityId the entity id to set
     */
    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    /**
     * Get the debate subject
     *
     * @return the subject
     */
    public String getSujet() {
        return sujet;
    }

    /**
     * Set the debate subject
     *
     * @param sujet the subject to set
     */
    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    /**
     * Get the debate creation date
     *
     * @return the creation date
     */
    public long getDateCreation() {
        return dateCreation;
    }

    /**
     * Set the debate creation date
     *
     * @param dateCreation the date to set
     */
    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Get the debate update date
     *
     * @return the update date
     */
    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    /**
     * Set the debate update date
     *
     * @param dateMiseAJour the date to set
     */
    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

}
