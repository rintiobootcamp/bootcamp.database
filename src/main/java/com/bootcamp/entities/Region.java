package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import com.bootcamp.commons.enums.RegionType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bello
 */
@Entity
@ApiModel(value = "location", description = "Description of location service")
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 1024)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Name of the location", required = true)
    private String nom;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "The type of the location", required = true)
    private RegionType type;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "The longitude of the location", required = true)
    private long longitude;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "The latitude of the location", required = true)
    private long latitude;

    @ManyToMany
    private List<Projet> projets = new ArrayList<Projet>();

    /**
     * Get the location id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the location id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the location name
     *
     * @return the name
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the location name
     *
     * @param nom the name to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the location type
     *
     * @return the type
     */
    public RegionType getType() {
        return type;
    }

    /**
     * Set the location type
     *
     * @param type the type to set
     */
    public void setType(RegionType type) {
        this.type = type;
    }

    /**
     * Get the location longitude
     *
     * @return the longitude
     */
    public long getLongitude() {
        return longitude;
    }

    /**
     * Set the location longitude
     *
     * @param longitude the longitude to set
     */
    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    /**
     * Get the location latitude
     *
     * @return the latitude
     */
    public long getLatitude() {
        return latitude;
    }

    /**
     * Set the location latitude
     *
     * @param latitude the latitude to set
     */
    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    /**
     * Get the location projects list
     *
     * @return the projects
     */
    public List<Projet> getProjets() {
        return projets;
    }

    /**
     * Set the location projects list
     *
     * @param projets the projects to set
     */
    public void setProjets(List<Projet> projets) {
        this.projets = projets;
    }

}
