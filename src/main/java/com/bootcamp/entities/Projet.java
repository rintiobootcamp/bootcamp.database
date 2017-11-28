package com.bootcamp.entities;

import com.bootcamp.commons.enums.EtatProjet;
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
    private int id;
    
    private int idIndicateur;
    
    @Column(length = 30)
    private String nom;
    
    @Column(length = 50)
    private String reference;
    
    @Column(length = 255)
    private String description;
    
    @Column(length = 50)
    private String phaseActuelle;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dateDeDebutReelle;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dateDeFinReelle;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dateDeDebutPrevisionnelle;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dateDeFinPrevisionnelle;
    
    @Column(scale =2 )
    private double budgetPrevisionnel;
    
    @Column(scale = 2)
    private double coutReel;
    
    private EtatProjet etat ;
    
    private List<Integer> commentaires = new ArrayList<Integer>();
    
    private List<Integer> geographies = new ArrayList<Integer>();

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

    public String getPhaseActuelle() {
        return phaseActuelle;
    }

    public void setPhaseActuelle(String phaseActuelle) {
        this.phaseActuelle = phaseActuelle;
    }

    public Date getDateDeDebutReelle() {
        return dateDeDebutReelle;
    }


    public Date getDateDeFinReelle() {
        return dateDeFinReelle;
    }


    public Date getDateDeDebutPrevisionnelle() {
        return dateDeDebutPrevisionnelle;
    }


    public Date getDateDeFinPrevisionnelle() {
        return dateDeFinPrevisionnelle;
    }

    public void setDateDeDebutReelle(Timestamp dateDeDebutReelle) {
        this.dateDeDebutReelle = dateDeDebutReelle;
    }

    public void setDateDeFinReelle(Timestamp dateDeFinReelle) {
        this.dateDeFinReelle = dateDeFinReelle;
    }

    public void setDateDeDebutPrevisionnelle(Timestamp dateDeDebutPrevisionnelle) {
        this.dateDeDebutPrevisionnelle = dateDeDebutPrevisionnelle;
    }

    public void setDateDeFinPrevisionnelle(Timestamp dateDeFinPrevisionnelle) {
        this.dateDeFinPrevisionnelle = dateDeFinPrevisionnelle;
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

    public EtatProjet getEtat() {
        return etat;
    }

    public void setEtat(EtatProjet etat) {
        this.etat = etat;
    }

    public int getIdIndicateur() {
        return idIndicateur;
    }

    public void setIdIndicateur(int idIndicateur) {
        this.idIndicateur = idIndicateur;
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
     * @return the geographies
     */
    public List<Integer> getGeographies() {
        return geographies;
    }

    /**
     * @param geographies the geographies to set
     */
    public void setGeographies(List<Integer> geographies) {
        this.geographies = geographies;
    }
}
