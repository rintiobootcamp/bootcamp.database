/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Link;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "rest_departement")
@ApiModel(value = "Departement",
        description = "Departement")
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Id of the Departement", required = true)
    private int id;

    @Column(nullable = false, length = 30)
    @ApiModelProperty(value = "name of the departement", required = true)
    private String nom;

    @Column(nullable = false)
    @ApiModelProperty(value = "numero du departement", required = true)
    private int numero;

    @Column(nullable = false)
    @ApiModelProperty(value = "longitude of the departement", required = true)
    private double longitude;

    @Column(nullable = false)
    @ApiModelProperty(value = "latitude of the departement", required = true)
    private double latitude;

    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL)
    private List<Commune> communes;

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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public List<Commune> getCommuneList() {
        return this.communes;
    }

    public void setCommuneList(List<Commune> communes) {
        this.communes = communes;
    }


}
