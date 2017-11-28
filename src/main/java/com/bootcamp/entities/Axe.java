package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
/**
 *
 * @author Iso-Doss
 */
@Entity
@ApiModel(value = "Axe", description = "Description of axe service")
public class Axe implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;
    
    @Column(nullable = false)
    @ApiModelProperty(value = "name of Axe", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String nom;
    
    @Column(nullable = false)
    @ApiModelProperty(value = "description of Axe", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String description;

    @Column(nullable = false)
    @ApiModelProperty(value = "title of Axe", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String titre;

    @Column(nullable = false)
    @ApiModelProperty(value = "title of focus", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String titreFocus;

    @Column(nullable = false)
    @ApiModelProperty(value = "focus description", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String descriptionFocus;
    
    @Column(nullable = false)
    @ApiModelProperty(value = "creation date of Axe")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateCreation;
    
    @Column(nullable = false)
    @ApiModelProperty(value = "update date of Axe")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateMiseAJour;
    
    @OneToMany
    @ApiModelProperty(value = "list of sectors of Axe", required = true)
    private List<Secteur> secteurs;
    
    @ApiModelProperty(value = "list of medias of Axe", required = true)
    private List<Integer> medias;
    
    @ApiModelProperty(value = "list of comments of Axe", required = true)
    private List<Integer> commentaires;
    
    @ManyToOne
    @ApiModelProperty(value = "The pilier of Axe", required = true)
    @JoinColumn(name = "pilier", referencedColumnName = "id", insertable = false, updatable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private Pilier pilier;


    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "com.bootcamp.database.entities.Axe[ id=" + id + " ]";
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitreFocus() {
        return titreFocus;
    }

    public void setTitreFocus(String titreFocus) {
        this.titreFocus = titreFocus;
    }

    public String getDescriptionFocus() {
        return descriptionFocus;
    }

    public void setDescriptionFocus(String descriptionFocus) {
        this.descriptionFocus = descriptionFocus;
    }

    public long getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public List<Integer> getMedias() {
        return medias;
    }

    public void setMedias(List<Integer> medias) {
        this.medias = medias;
    }

    public List<Integer> getComments() {
        return commentaires;
    }

    public void setComments(List<Integer> comments) {
        this.commentaires = comments;
    }

    public Pilier getPilier() {
        return pilier;
    }

    public void setPilier(Pilier pilier) {
        this.pilier = pilier;
    }
}