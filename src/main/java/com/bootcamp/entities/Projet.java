package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Projet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Id of the project", notes = "This id is automatically generated ,it doesn't required")
    private int id;

    @Column(nullable = false, length = 1024)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Name of the Project", required = true)
    private String nom;

    @Column(nullable = false, length = 1024)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Reference of the Project", required = true)
    private String reference;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Description of the Project", required = true)
    private String description;

    @ApiModelProperty(value = "Real started date of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateDebutReel;

    @ApiModelProperty(value = "Real ended date of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateFinReel;

    @ApiModelProperty(value = "Estimate started date of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateDebutPrevisionnel;

    @ApiModelProperty(value = "Estimate ended date of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateFinPrevisionnel;

    @Column(nullable = false)
    @ApiModelProperty(value = "Estimate funds of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double budgetPrevisionnel;

    @Column(nullable = false)
    @ApiModelProperty(value = "Real cost of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double budgetReel;

    @Column(nullable = false)
    @ApiModelProperty(value = "Real cost of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double coutReel;

    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "Objectif of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String objectif;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    @ApiModelProperty(value = "List of the project phases")
    private List<Phase> phases;

    @ApiModelProperty(value = "Id of the Unique sector in which the projet is allocated to",required = true)
    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int idSecteur;

    @ManyToMany(mappedBy = "projets")
    private List<Region> regions = new ArrayList<Region>();

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
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
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
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

    /**
     * @return the dateDebutReel
     */
    public long getDateDebutReel() {
        return dateDebutReel;
    }

    /**
     * @param dateDebutReel the dateDebutReel to set
     */
    public void setDateDebutReel(long dateDebutReel) {
        this.dateDebutReel = dateDebutReel;
    }

    /**
     * @return the dateFinReel
     */
    public long getDateFinReel() {
        return dateFinReel;
    }

    /**
     * @param dateFinReel the dateFinReel to set
     */
    public void setDateFinReel(long dateFinReel) {
        this.dateFinReel = dateFinReel;
    }

    /**
     * @return the dateDebutPrevisionnel
     */
    public long getDateDebutPrevisionnel() {
        return dateDebutPrevisionnel;
    }

    /**
     * @param dateDebutPrevisionnel the dateDebutPrevisionnel to set
     */
    public void setDateDebutPrevisionnel(long dateDebutPrevisionnel) {
        this.dateDebutPrevisionnel = dateDebutPrevisionnel;
    }

    /**
     * @return the dateFinPrevisionnel
     */
    public long getDateFinPrevisionnel() {
        return dateFinPrevisionnel;
    }

    /**
     * @param dateFinPrevisionnel the dateFinPrevisionnel to set
     */
    public void setDateFinPrevisionnel(long dateFinPrevisionnel) {
        this.dateFinPrevisionnel = dateFinPrevisionnel;
    }

    /**
     * @return the budgetPrevisionnel
     */
    public double getBudgetPrevisionnel() {
        return budgetPrevisionnel;
    }

    /**
     * @param budgetPrevisionnel the budgetPrevisionnel to set
     */
    public void setBudgetPrevisionnel(double budgetPrevisionnel) {
        this.budgetPrevisionnel = budgetPrevisionnel;
    }

    /**
     * @return the budgetReel
     */
    public double getBudgetReel() {
        return budgetReel;
    }

    /**
     * @param budgetReel the budgetReel to set
     */
    public void setBudgetReel(double budgetReel) {
        this.budgetReel = budgetReel;
    }

    /**
     * @return the coutReel
     */
    public double getCoutReel() {
        return coutReel;
    }

    /**
     * @param coutReel the coutReel to set
     */
    public void setCoutReel(double coutReel) {
        this.coutReel = coutReel;
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
     * @return the phases
     */
    public List<Phase> getPhases() {
        return phases;
    }

    /**
     * @param phases the phases to set
     */
    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public int getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }

    /**
     * @return the regions
     */
    public List<Region> getRegions() {
        return regions;
    }

    /**
     * @param regions the regions to set
     */
    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

}
