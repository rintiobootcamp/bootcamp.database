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
public class Commentaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String entityType;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int entityId;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 1024)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String contenu;

    @ApiModelProperty(value = "creation date of Axe")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateCreation;

    @ApiModelProperty(value = "update date of Axe")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateMiseAJour;

    private String pseudo;
    private int userId;
    private String userMail;

    /**
     * Get the comment id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the comment id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the comment entity Id
     *
     * @return the entity Id
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Set the comment entity Id
     *
     * @param entityId the entity Id to set
     */
    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    /**
     * Get the comment text
     *
     * @return the comment text
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * Set the comment text
     *
     * @param contenu the text to set
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /**
     * Get the comment creation date
     *
     * @return the dateCreation
     */
    public long getDateCreation() {
        return dateCreation;
    }

    /**
     * Set the comment creation date
     *
     * @param dateCreation the date to set
     */
    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Get the comment update date
     *
     * @return the dateMiseAJour
     */
    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    /**
     * Set the comment update date
     *
     * @param dateMiseAJour the date to set
     */
    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    /**
     * Get the comment author login
     *
     * @return the author login
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Set the comment author login
     *
     * @param pseudo the author login to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Get the comment author id
     *
     * @return the author Id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the comment author id
     *
     * @param userId the author id to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get the comment author mail
     *
     * @return the author mail
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * Set the comment author mail
     *
     * @param userMail the author mail to set
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    /**
     * Get the comment entity Type
     *
     * @return the entity Type
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * Set the comment entity Type
     *
     * @param entityType the entity Type to set
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }
}
