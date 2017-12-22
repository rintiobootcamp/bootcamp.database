package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import com.bootcamp.commons.enums.EtatProjet;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bello
 */
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

    @ApiModelProperty(value = "Current state of the project")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private EtatProjet etat;

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
    @Column(nullable = false)
    private double financementPrivePrevisionnel;

    @ApiModelProperty(value = "Part of the financing obtained from the Public")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private double financementPublicPrevisionnel;

    @ApiModelProperty(value = "Part of the financing obtained from the Prive")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private double financementPriveReel;

    @ApiModelProperty(value = "Part of the financing obtained from the Public")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private double financementPublicReel;

    @ApiModelProperty(value = "Id of the Unique Programme in which the projet is allocated to", required = true)
    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int idProgramme;

    /**
     * Get the project id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the project id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the project name
     *
     * @return the name
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the project name
     *
     * @param nom the name to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the project reference
     *
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * Set the project reference
     *
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Get the project description
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the project description
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the project real started date
     *
     * @return the real started date
     */
    public long getDateDebutReel() {
        return dateDebutReel;
    }

    /**
     * Set the project real started date
     *
     * @param dateDebutReel the date to set
     */
    public void setDateDebutReel(long dateDebutReel) {
        this.dateDebutReel = dateDebutReel;
    }

    /**
     * Get the project real ended date
     *
     * @return the real ended date
     */
    public long getDateFinReel() {
        return dateFinReel;
    }

    /**
     * Set the project real ended date
     *
     * @param dateFinReel the date to set
     */
    public void setDateFinReel(long dateFinReel) {
        this.dateFinReel = dateFinReel;
    }

    /**
     * Get the project estimate started date
     *
     * @return the estimate started date
     */
    public long getDateDebutPrevisionnel() {
        return dateDebutPrevisionnel;
    }

    /**
     * Set the project estimate started date
     *
     * @param dateDebutPrevisionnel the date to set
     */
    public void setDateDebutPrevisionnel(long dateDebutPrevisionnel) {
        this.dateDebutPrevisionnel = dateDebutPrevisionnel;
    }

    /**
     * Get the project estimate ended date
     *
     * @return the estimate ended date
     */
    public long getDateFinPrevisionnel() {
        return dateFinPrevisionnel;
    }

    /**
     * Set the project estimate ended date
     *
     * @param dateFinPrevisionnel the date to set
     */
    public void setDateFinPrevisionnel(long dateFinPrevisionnel) {
        this.dateFinPrevisionnel = dateFinPrevisionnel;
    }

    /**
     * Get the project estimate funds
     *
     * @return the estimate funds
     */
    public double getBudgetPrevisionnel() {
        return budgetPrevisionnel;
    }

    /**
     * Set the project estimate funds
     *
     * @param budgetPrevisionnel the funds to set
     */
    public void setBudgetPrevisionnel(double budgetPrevisionnel) {
        this.budgetPrevisionnel = budgetPrevisionnel;
    }

    /**
     * Get the project real cost
     *
     * @return the real cost
     */
    public double getCoutReel() {
        return coutReel;
    }

    /**
     * Set the project real cost
     *
     * @param coutReel the cost to set
     */
    public void setCoutReel(double coutReel) {
        this.coutReel = coutReel;
    }

    /**
     * Get the project step list
     *
     * @return the step list
     */
    public List<Phase> getPhases() {
        return phases;
    }

    /**
     * Set the project step list
     *
     * @param phases the step list to set
     */
    public void setPhases(List<Phase> phases) {
        this.phases = phases;
    }

    /**
     * Get the project sector id
     *
     * @return the sector id
     */
    public int getIdSecteur() {
        return idSecteur;
    }

    /**
     * Set the project sector id
     *
     * @param idSecteur the project sector id to set
     */
    public void setIdSecteur(int idSecteur) {
        this.idSecteur = idSecteur;
    }

    /**
     * Get the project location list
     *
     * @return the location list
     */
    public List<Region> getRegions() {
        return regions;
    }

    /**
     * Set the project location list
     *
     * @param regions the location list to set
     */
    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    /**
     * Get the project impact list
     *
     * @return the impact list
     */
    public List<Impact> getImpactList() {
        return impactList;
    }

    /**
     * Set the project impact list
     *
     * @param impactList the impact list to set
     */
    public void setImpactList(List<Impact> impactList) {
        this.impactList = impactList;
    }

    /**
     * Get the project goal list
     *
     * @return the goal list
     */
    public List<Objectif> getObjectifList() {
        return objectifList;
    }

    /**
     * Set the project goal list
     *
     * @param objectifList the goal list to set
     */
    public void setObjectifList(List<Objectif> objectifList) {
        this.objectifList = objectifList;
    }

    public double getFinancementPrivePrevisionnel() {
        return financementPrivePrevisionnel;
    }

    public void setFinancementPrivePrevisionnel(double financementPrivePrevisionnel) {
        this.financementPrivePrevisionnel = financementPrivePrevisionnel;
    }

    public double getFinancementPublicPrevisionnel() {
        return financementPublicPrevisionnel;
    }

    public void setFinancementPublicPrevisionnel(double financementPublicPrevisionnel) {
        this.financementPublicPrevisionnel = financementPublicPrevisionnel;
    }

    public double getFinancementPriveReel() {
        return financementPriveReel;
    }

    public void setFinancementPriveReel(double financementPriveReel) {
        this.financementPriveReel = financementPriveReel;
    }

    public double getFinancementPublicReel() {
        return financementPublicReel;
    }

    public void setFinancementPublicReel(double financementPublicReel) {
        this.financementPublicReel = financementPublicReel;
    }

    /**
     * Get the project program id
     *
     * @return the program id
     */
    public int getIdProgramme() {
        return idProgramme;
    }

    /**
     * Set the project program id
     *
     * @param idProgramme the program id to set
     */
    public void setIdProgramme(int idProgramme) {
        this.idProgramme = idProgramme;
    }

    public EtatProjet getEtat() {
        return etat;
    }

    public void setEtat(EtatProjet etat) {
        this.etat = etat;
    }
}
