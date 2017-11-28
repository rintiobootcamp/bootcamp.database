/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "pag_secteur")
@ApiModel(value = "Secteur", description = "representation d'une signature Secteur")
public class Secteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @ApiModelProperty(value = "Id of the Sector", required = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 50)
    @ApiModelProperty(value = "Name of the sector", required = true)
    private String nom;

    @Column(nullable = false, length = 255)
    @ApiModelProperty(value = "Description of the sector", required = true)
    private String description;
    
    @Column(nullable = false, length = 255)
    @ApiModelProperty(value = "Objectif of the sector", required = true)
    private String objectif;

    @Column(nullable = false)
    @ApiModelProperty(value = "The date when the sector is created", required = true)
    private Timestamp createAt;

    @Column(nullable = false)
    @ApiModelProperty(value = "The date when the sector is updated", required = true)
    private Timestamp updateAt;

    private List<Integer> projets;

    private List<Integer> medias;

    private List<Integer> commentaires;
    
    @ManyToOne
    @ApiModelProperty(value = "The Axe of Secteur", required = true)
    @JoinColumn(name = "axe", referencedColumnName = "id", insertable = false, updatable = false)
    private Axe axe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public List<Integer> getProjets() {
        return this.projets;
    }

    public void setProjets(List<Integer> projets) {
        this.projets = projets;
    }

    public List<Integer> getCommentaires() {
        return this.commentaires;
    }

    public void setCommentaires(List<Integer> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Integer> getMedias() {
        return medias;
    }

    public void setMedias(List<Integer> medias) {
        this.medias = medias;
    }

    /**
     * @return the objectif
     */
    public String getObjectif() {
        return objectif;
    }

    /**
     * @param objectif the objectif to set
     */
    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    /**
     * @return the axe
     */
    public Axe getAxe() {
        return axe;
    }

    /**
     * @param axe the axe to set
     */
    public void setAxe(Axe axe) {
        this.axe = axe;
    }
}
