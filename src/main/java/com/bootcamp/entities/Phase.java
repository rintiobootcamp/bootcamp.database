package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.*;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Iso-Doss
 */
@Entity
@ApiModel(value = "Phase", description = "Description of state service")
public class Phase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "name of state", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String nom;

    @Column(nullable = false)
    @ApiModelProperty(value = "creation estimated date of state")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateDebutPrevisionnel;

    @Column(nullable = false)
    @ApiModelProperty(value = "update estimated date of state")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateFinPrevisionnel;

    @Column(nullable = false)
    @ApiModelProperty(value = "creation real date of state")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateDebutReel;

    @Column(nullable = false)
    @ApiModelProperty(value = "update real date of state")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateFinReel;

    @Column(nullable = false)
    @ApiModelProperty(value = "check if the state is enable or not", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private boolean actif;

    @ManyToOne
    @JoinColumn(name = "projet", referencedColumnName = "id", insertable = false, updatable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private Projet projet;

    /**
     * Get the phase id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the phase id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the phase name
     *
     * @return the name
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the phase name
     *
     * @param nom the name to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getDateDebutPrevisionnel() {
        return dateDebutPrevisionnel;
    }

    public void setDateDebutPrevisionnel(long dateDebutPrevisionnel) {
        this.dateDebutPrevisionnel = dateDebutPrevisionnel;
    }

    public long getDateFinPrevisionnel() {
        return dateFinPrevisionnel;
    }

    public void setDateFinPrevisionnel(long dateFinPrevisionnel) {
        this.dateFinPrevisionnel = dateFinPrevisionnel;
    }

    public long getDateDebutReel() {
        return dateDebutReel;
    }

    public void setDateDebutReel(long dateDebutReel) {
        this.dateDebutReel = dateDebutReel;
    }

    public long getDateFinReel() {
        return dateFinReel;
    }

    public void setDateFinReel(long dateFinReel) {
        this.dateFinReel = dateFinReel;
    }

    public boolean isActif() {
        return actif;
    }

    /**
     * Enable or Disable the phase
     *
     * @param actif
     */
    public void setActif(boolean actif) {
        this.actif = actif;
    }

    /**
     * Get the phase project
     *
     * @return the project
     */
    public Projet getProjet() {
        return projet;
    }

    /**
     * Set the phase project
     *
     * @param projet the project to set
     */
    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
