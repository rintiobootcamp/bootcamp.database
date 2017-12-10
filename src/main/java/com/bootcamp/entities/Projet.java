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

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 1024)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Name of the Project", required = true)
    private String nom;

    @Lob
    @Column(nullable = false, length = 1024)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Reference of the Project", required = true)
    private String reference;

    @Lob
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


    @ApiModelProperty(value = "Real cost of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double coutReel;


    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    @Basic(fetch = FetchType.LAZY, optional = false)
    @ApiModelProperty(value = "List of the project phases")
    private List<Phase> phases;

    @ApiModelProperty(value = "Id of the Unique sector in which the projet is allocated to", required = true)
    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int idSecteur;

    @ManyToMany(mappedBy = "projets")
    @Basic(fetch = FetchType.LAZY, optional = false)
    private List<Region> regions = new ArrayList<Region>();

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    @Basic(fetch = FetchType.LAZY, optional = false)
    @ApiModelProperty(value = "List of the impacts of the project")
    private List<Impact> impactList;

    @OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
    @Basic(fetch = FetchType.LAZY, optional = false)
    @ApiModelProperty(value = "List of the objectives of the project")
    private List<Objectif> objectifList;


    @ApiModelProperty(value = "Part of the financing obtained from the Prive")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double financementPrive;


    @ApiModelProperty(value = "Part of the financing obtained from the Public")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double financementPublic;


    @ApiModelProperty(value = "Id of the Unique Programme in which the projet is allocated to", required = true)
    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int idProgramme;

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

    public List<Phase> getPhases() {
        return phases;
    }

    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    public int getIdSecteur() {
        return idSecteur;
    }

    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Impact> getImpactList() {
        return impactList;
    }

    public void setImpactList(List<Impact> impactList) {
        this.impactList = impactList;
    }

    public List<Objectif> getObjectifList() {
        return objectifList;
    }

    public void setObjectifList(List<Objectif> objectifList) {
        this.objectifList = objectifList;
    }

    public double getFinancementPrive() {
        return financementPrive;
    }

    public void setFinancementPrive(double financementPrive) {
        this.financementPrive = financementPrive;
    }

    public double getFinancementPublic() {
        return financementPublic;
    }

    public void setFinancementPublic(double financementPublic) {
        this.financementPublic = financementPublic;
    }

    public int getIdProgramme() {
        return idProgramme;
    }

    public void setIdProgramme(int idProgramme) {
        this.idProgramme = idProgramme;
    }
}
