package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Bello
 */
@Entity
@ApiModel(value = "pilier", description = "the pilier model of the PAG")
public class Pilier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Id of pilier' Model", notes = "This id is automatically generated ,it doesn't required")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "the name of this particular pilier", notes = "this name is required during the creation of a pilier", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String nom;

    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "the description of the pilar", notes = "the description is not obligatory but necessary", required = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String description;

    @Column(nullable = false)
    @ApiModelProperty(value = "the date of creation of this particular pilar")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateCreation;

    @Column(nullable = false)
    @ApiModelProperty(value = "the updated date", notes = "the date when this pilar has been modified at last")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateMiseAJour;

    @OneToMany
    @NotNull(message = "The list of axes field must not be empty")
    private List<Axe> axes;

    /**
     * Get the Pillar id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the Pillar id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the Pillar name
     *
     * @return the name
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the Pillar name
     *
     * @param nom the name to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the Pillar description
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the Pillar description
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the Pillar creation date
     *
     * @return the creation date
     */
    public long getDateCreation() {
        return dateCreation;
    }

    /**
     * Set the Pillar creation date
     *
     * @param dateCreation the creation date to set
     */
    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Get the Pillar update date
     *
     * @return the update date
     */
    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    /**
     * Set the Pillar update date
     *
     * @param dateMiseAJour the date to set
     */
    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    /**
     * Get the Pillar axes list
     *
     * @return the axes
     */
    public List<Axe> getAxes() {
        return axes;
    }

    /**
     * Set the Pillar axes list
     *
     * @param axes the axes to set
     */
    public void setAxes(List<Axe> axes) {
        this.axes = axes;
    }

}
