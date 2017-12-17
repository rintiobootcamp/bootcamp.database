/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author rosius
 */
@Entity
public class Media implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(name = "originalName", length = 45, nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String originalName;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(name = "internalName", length = 45, nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String internalName;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String entityType;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int entityId;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(name = "type", length = 45, nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String type;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(name = "link", nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String lien;

    @ApiModelProperty(value = "creation date of Axe")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateCreation;

    @ApiModelProperty(value = "update date of Axe")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateMiseAJour;

    /**
     * Get the media id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Get the media id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the media original name
     *
     * @return the original name
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * Set the media original name
     *
     * @param originalName the original name to set
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    /**
     * Get the media internal name
     *
     * @return the internal name
     */
    public String getInternalName() {
        return internalName;
    }

    /**
     * Set the media internal name
     *
     * @param internalName the internal name to set
     */
    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    /**
     * Get the media type
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the media type
     *
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the media link
     *
     * @return the link
     */
    public String getLien() {
        return lien;
    }

    /**
     * Set the media link
     *
     * @param lien the link to set
     */
    public void setLien(String lien) {
        this.lien = lien;
    }

    /**
     * Get the media creation date
     *
     * @return the creation date
     */
    public long getDateCreation() {
        return dateCreation;
    }

    /**
     * @param dateCreation the date to set
     */
    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Get the media update date
     *
     * @return the update date
     */
    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    /**
     * Set the media update date
     *
     * @param dateMiseAJour the date to set
     */
    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    /**
     * Get the media entity type
     *
     * @return the entity type
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * Set the media entity type
     *
     * @param entityType the entity type to set
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * Get the media entity id
     *
     * @return the entity id
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Set the media entity id
     *
     * @param entityId the entity id to set
     */
    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

}
