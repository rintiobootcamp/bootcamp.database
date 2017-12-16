package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Moh
 */
@Entity
@ApiModel(value = "Programme", description = "Description of a program")
public class Programme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Id of the programme", notes = "This id is automatically generated ,it doesn't required")
    private int id;

    @Lob
    @Column(nullable = false, length = 1024)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Name of the programme", required = true)
    private String nom;

    @Lob
    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Description of the programme", required = true)
    private String description;

    @Lob
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Description of the programme", required = true)
    private String focus;

    @ApiModelProperty(value = "Estimate started date of the programme")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateDebut;

    @ApiModelProperty(value = "Estimate ended date of the programme")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateFin;

    /**
     * Get the program id
     *
     * @return the program id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the program id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the program name
     *
     * @return the program name
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the program name
     *
     * @param nom the name to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the program description
     *
     * @return the program description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the program description
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the program focus
     *
     * @return the program focus
     */
    public String getFocus() {
        return focus;
    }

    /**
     * Set the program focus
     *
     * @param focus the focus to set
     */
    public void setFocus(String focus) {
        this.focus = focus;
    }

    /**
     * Get the program start date
     *
     * @return the program start date
     */
    public long getDateDebut() {
        return dateDebut;
    }

    /**
     * Set the program start date
     *
     * @param dateDebut the date to set
     */
    public void setDateDebut(long dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Get the program end date
     *
     * @return the program end date
     */
    public long getDateFin() {
        return dateFin;
    }

    /**
     * Set the program end date
     *
     * @param dateFin the date to set
     */
    public void setDateFin(long dateFin) {
        this.dateFin = dateFin;
    }
}
