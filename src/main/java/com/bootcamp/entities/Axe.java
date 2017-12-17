package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

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

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 2000)
    @ApiModelProperty(value = "name of Axe", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String nom;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 2000)
    @ApiModelProperty(value = "description of Axe", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String description;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 2000)
    @ApiModelProperty(value = "title of Axe", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String titre;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 2000)
    @ApiModelProperty(value = "title of focus", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String titreFocus;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 1024)
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

    @ManyToOne
    @ApiModelProperty(value = "The pilier of Axe", required = true)
    @JoinColumn(name = "pilier", referencedColumnName = "id", insertable = false, updatable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private Pilier pilier;

    /**
     * Get the id of the axe
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the axe
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the axe
     *
     * @return the name
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the name of the axe
     *
     * @param nom the name to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the description of the axe
     *
     * @return the description of the axe
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the axe
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the axe title
     *
     * @return the title of the axe
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Set the axe title
     *
     * @param titre the title to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Get the axe focus title
     *
     * @return the axe focus title
     */
    public String getTitreFocus() {
        return titreFocus;
    }

    /**
     * Set the axe focus title
     *
     * @param titreFocus the axe focus title to set
     */
    public void setTitreFocus(String titreFocus) {
        this.titreFocus = titreFocus;
    }

    /**
     * Get the axe focus description
     *
     * @return the axe focus description
     */
    public String getDescriptionFocus() {
        return descriptionFocus;
    }

    /**
     * Set the axe focus description
     *
     * @param descriptionFocus the axe focus description to set
     */
    public void setDescriptionFocus(String descriptionFocus) {
        this.descriptionFocus = descriptionFocus;
    }

    /**
     * Get the axe creation date
     *
     * @return the creation date of the axe
     */
    public long getDateCreation() {
        return dateCreation;
    }

    /**
     * Set the axe creation date
     *
     * @param dateCreation the axe creation date to set
     */
    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Get the axe update date
     *
     * @return the axe update date
     */
    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    /**
     * Set the axe update date
     *
     * @param dateMiseAJour the axe update date to set
     */
    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    /**
     * Get the axe sector list
     *
     * @return the axe sector list
     */
    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    /**
     * Set the axe sector list
     *
     * @param secteurs the axe sector list to set
     */
    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    /**
     * Get the axe pillar
     *
     * @return the axe pillar
     */
    public Pilier getPilier() {
        return pilier;
    }

    /**
     * Set the axe pillar
     *
     * @param pilier the axe pillar to set
     */
    public void setPilier(Pilier pilier) {
        this.pilier = pilier;
    }

}
