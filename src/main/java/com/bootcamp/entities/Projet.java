package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import com.bootcamp.commons.enums.EtatProjet;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;

@Entity
//@Table(name = "rest_projet")
public class Projet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value="Id of the project",notes = "This id is automatically generated ,it doesn't required")
    private int id;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Name of the Project", required = true)
    private String nom;
    
    @Column(nullable = false)
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
    
    @Column(scale =2 )
    @ApiModelProperty(value = "Estimate funds of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double budgetPrevisionnel;
    
    @Column(scale = 2)
    @ApiModelProperty(value = "Real cost of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double budgetReel;
    
    @Column(scale = 2)
    @ApiModelProperty(value = "Real cost of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double coutReel;

    @Column(scale = 2)
    @ApiModelProperty(value = "Objectif of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String objectif;

    @OneToMany(mappedBy = "projet",cascade = CascadeType.ALL)
    @ApiModelProperty(value = "List of the project phases")
    private List<Phase> phases;


    private List<Integer> idSecteurs;

    private List<Integer> commentaires = new ArrayList<Integer>();

    @ManyToMany(mappedBy = "projets")
    private List<Region> regions = new ArrayList<Region>();

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Integer> getIdSecteurs() {
        return idSecteurs;
    }

    public void setIdSecteurs(List<Integer> idSecteurs) {
        this.idSecteurs = idSecteurs;
    }

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public double getBudgetPrevisionnel() {
        return budgetPrevisionnel;
    }

    public void setBudgetPrevisionnel(double budgetPrevisionnel) {
        this.budgetPrevisionnel = budgetPrevisionnel;
    }

    public double getCoutReel() {
        return coutReel;
    }

    public void setCoutReel(double coutReel) {
        this.coutReel = coutReel;
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

    /**
     * @return the commentaires
     */
    public List<Integer> getCommentaires() {
        return commentaires;
    }

    /**
     * @param commentaires the commentaires to set
     */
    public void setCommentaires(List<Integer> commentaires) {
        this.commentaires = commentaires;
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
}
