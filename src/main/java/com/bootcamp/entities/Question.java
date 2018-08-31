/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.HashMap;
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
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String entityType;

    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int entityId;

    /**
     * les sujets de sondage doivent etre unique pour faciliter la recherche
     */
    @Lob
    @Column(nullable = false,length = 2000)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String sujet;

    @ApiModelProperty(value = "creation date of sondage")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateCreation;

    @ApiModelProperty(value = "update date of sondage")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateMiseAJour;

    @Column
    @ApiModelProperty(value = "List of responses")
    private HashMap<String,Long> typeReponses;


    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String cover;

    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private boolean une=false;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public boolean isUne() {
        return une;
    }

    public void setUne(boolean une) {
        this.une = une;
    }

    public int getId() {
        return id;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * Get the question id
     *
     * @return the id



    /**
     * Set the question id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the question entity Id
     *
     * @return the entity Id
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Set the question entity Id
     *
     * @param entityId the entity Id to set
     */
    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    /**
     * Get the question entity type
     *
     * @return the entity type
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * Set the question entity type
     *
     * @param entityType the entity type to set
     */
    public void setEntityId(String entityType) {
        this.entityType = entityType;
    }

    /**
     * Get the question subject
     *
     * @return the question subject
     */
    public String getSujet() {
        return sujet;
    }

    /**
     * Set the question subject
     *
     * @param sujet the subject to set
     */
    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    /**
     * Get the question creation date
     *
     * @return the creation date
     */
    public long getDateCreation() {
        return dateCreation;
    }

    /**
     * Set the question creation date
     *
     * @param dateCreation the date to set
     */
    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Get the question update date
     *
     * @return the update date
     */
    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    /**
     * Set the question update date
     *
     * @param dateMiseAJour the date to set
     */
    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    /**
     * Get the question responses type and responses number list
     *
     * @return the responses type and responses number list
     */
    public HashMap<String, Long> getTypeReponses() {
        return typeReponses;
    }

    /**
     * Set the question responses type and responses number list
     *
     * @param typeReponses the responses type and responses number list to set
     */
    public void setTypeReponses(HashMap<String, Long> typeReponses) {
        this.typeReponses = typeReponses;
    }
}
