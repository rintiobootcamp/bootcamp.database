/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Bello
 */
@Entity
@ApiModel(value = "Secteur", description = "representation d'une signature Secteur")
public class Secteur implements Serializable {

    @Id
    @ApiModelProperty(value = "Id of the Sector", required = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "Name of the sector", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String nom;

    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "Description of the sector", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String description;

    @Column(length = 1024)
    @ApiModelProperty(value = "Icone of the sector", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String icone;

    @Column(nullable = false)
    @ApiModelProperty(value = "The date when the sector is created", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateCreation;

    @Column(nullable = false)
    @ApiModelProperty(value = "The date when the sector is updated", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateMiseAJour;

    @ManyToOne
    @ApiModelProperty(value = "The Axe of Secteur", required = true)
    @JoinColumn(name = "axe", referencedColumnName = "id", insertable = false, updatable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private Axe axe;

    /**
     * Get the sector id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the sector id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the sector name
     *
     * @return the name
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the sector name
     *
     * @param nom the name to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the sector description
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the sector description
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the sector icone
     *
     * @return the icone
     */
    public String getIcone() {
        return icone;
    }

    /**
     * Set the sector icone
     *
     * @param icone the icone to set
     */
    public void setIcone(String icone) {
        this.icone = icone;
    }

    /**
     * Get the sector creation date
     *
     * @return the creation date
     */
    public long getDateCreation() {
        return dateCreation;
    }

    /**
     * Set the sector creation date
     *
     * @param dateCreation the creation date to set
     */
    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Get the sector update date
     *
     * @return the update date
     */
    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    /**
     * Set the sector update date
     *
     * @param dateMiseAJour the date to set
     */
    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    /**
     * Get the sector axe
     *
     * @return the axe
     */
    public Axe getAxe() {
        return axe;
    }

    /**
     * Set the sector axe
     *
     * @param axe the axe to set
     */
    public void setAxe(Axe axe) {
        this.axe = axe;
    }

}
