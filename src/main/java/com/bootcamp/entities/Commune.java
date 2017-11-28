/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Link;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "commune")
@ApiModel(value = "Commune",
        description = "Commune")
public class Commune implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Id of the Commune", required = true)
    private int id;

    @Column(nullable = false, length = 30)
    @ApiModelProperty(value = "name of the commune", required = true)
    private String nom;

    @Column(nullable = false)
    @ApiModelProperty(value = "longitude of the commune", required = true)
    private double longitude;

    @Column(nullable = false)
    @ApiModelProperty(value = "latitude of the commune", required = true)
    private double latitude;

    @ManyToOne
    @JoinColumn(name = "departement", referencedColumnName = "id", insertable = false, updatable = false)
    Departement departement;

    @Transient
    private Link self;

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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitud(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
