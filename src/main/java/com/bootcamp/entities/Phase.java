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
@ApiModel(value = "Phase", description = "Description of state service")
public class Phase implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;
    
    @Column(nullable = false)
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

    @Column
    @ManyToOne
    @JoinColumn(name="projet",referencedColumnName = "id",insertable = false,updatable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private Projet projet;

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the dateDebut
     */
    public long getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(long dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return the dateFin
     */
    public long getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(long dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return the actif
     */
    public boolean isActif() {
        return actif;
    }

    /**
     * @param actif the actif to set
     */
    public void setActif(boolean actif) {
        this.actif = actif;
    }
    
}