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
    @ApiModelProperty(value = "Description of the programme's focus", required = true)
    private String focus;


    @ApiModelProperty(value = "Estimate started date of the programme")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateDebut;

    @ApiModelProperty(value = "Estimate ended date of the programme")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateFin;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public long getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(long dateDebut) {
        this.dateDebut = dateDebut;
    }

    public long getDateFin() {
        return dateFin;
    }

    public void setDateFin(long dateFin) {
        this.dateFin = dateFin;
    }
}
