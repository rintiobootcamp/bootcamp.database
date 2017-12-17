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
    @ApiModelProperty(value = "creation date of state")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateDebut;

    @Column(nullable = false)
    @ApiModelProperty(value = "update date of state")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateFin;

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

    /**
     * Get the phase started date
     *
     * @return the started date
     */
    public long getDateDebut() {
        return dateDebut;
    }

    /**
     * Set the phase started date
     *
     * @param dateDebut the date to set
     */
    public void setDateDebut(long dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Get the phase ended date
     *
     * @return the ended date
     */
    public long getDateFin() {
        return dateFin;
    }

    /**
     * Set the phase ended date
     *
     * @param dateFin the date to set
     */
    public void setDateFin(long dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Check if the phase is enable
     */
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
