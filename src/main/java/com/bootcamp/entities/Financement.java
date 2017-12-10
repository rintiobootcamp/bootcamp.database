package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.*;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author leger
 */
@Entity
@ApiModel(value = "Financement", description = "Description of a program's funding")
public class Financement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false)
    @ApiModelProperty(value = "amount of funding", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double montant;
    
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = true)
    @ApiModelProperty(value = "amount of public funding", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double montantDuPublic;

    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = true)
    @ApiModelProperty(value = "amount of private funding", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double montantDuPrivee;

    @Column(nullable = false)
    @ApiModelProperty(value = "creation date of amount")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateCreation;

    @Column(nullable = false)
    @ApiModelProperty(value = "update date of amount")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateMiseAJour;

    @OneToOne(mappedBy = "financement")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private Projet projet;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontantDuPublic() {
        return montantDuPublic;
    }

    public void setMontantDuPublic(double montantDuPublic) {
        this.montantDuPublic = montantDuPublic;
    }

    public double getMontantDuPrivee() {
        return montantDuPrivee;
    }

    public void setMontantDuPrivee(double montantDuPrivee) {
        this.montantDuPrivee = montantDuPrivee;
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

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

}
