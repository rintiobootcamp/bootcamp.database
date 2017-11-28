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
import java.util.List;
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

    @Column(nullable = false, length = 50)
    @ApiModelProperty(value = "Name of the sector", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String nom;

    @Column(nullable = false)
    @ApiModelProperty(value = "Description of the sector", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String description;
    
    @Column(nullable = false)
    @ApiModelProperty(value = "Icone of the sector", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String icone;

    @Column(nullable = false)
    @ApiModelProperty(value = "The date when the sector is created", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long createAt;

    @Column(nullable = false)
    @ApiModelProperty(value = "The date when the sector is updated", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long updateAt;

    private List<Integer> projets;

    private List<Integer> medias;

    private List<Integer> commentaires;
    
    @ManyToOne
    @ApiModelProperty(value = "The Axe of Secteur", required = true)
    @JoinColumn(name = "axe", referencedColumnName = "id", insertable = false, updatable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
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

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
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

    /**
     * @return the icone
     */
    public String getIcone() {
        return icone;
    }

    /**
     * @param icone the icone to set
     */
    public void setIcone(String icone) {
        this.icone = icone;
    }
}
