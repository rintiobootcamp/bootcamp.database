package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import javax.validation.constraints.NotNull;

@Entity
@ApiModel(value="pilier",description = "the pilier model of the PAG")
public class Pilier implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="Id of pilier' Model",notes = "This id is automatically generated ,it doesn't required")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Column(nullable = false)
    @ApiModelProperty(value="the name of this particular pilier",notes ="this name is required during the creation of a pilier",required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String nom;

    @Column(nullable = false)
    @ApiModelProperty(value="the description of the pilar",notes="the description is not obligatory but necessary",required = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String description;

    @Column(nullable = false)
    @ApiModelProperty(value="the date of creation of this particular pilar")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateCreation;

    @Column(nullable = false)
    @ApiModelProperty(value="the updated date",notes="the date when this pilar has been modified at last")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateMiseAJour;

    @Column(nullable = false)
    @ApiModelProperty(value="comments list",notes = "the list of all comments related to this pilar")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private List<Integer> commentaires;

    @Column(nullable = false)
    @ApiModelProperty(value="media list",notes = "the list of all media  related to this pilar")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private List<Integer> medias;
    
    @OneToMany
    @NotNull(message = "The list of axes field must not be empty")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private List<Axe> axes;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public List<Integer> getMedias() {
        return medias;
    }

    public void setMedias(List<Integer> medias) {
        this.medias = medias;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    public List<Integer> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Integer> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Axe> getAxes() {
        return axes;
    }

    public void setAxes(List<Axe> axes) {
        this.axes = axes;
    }
}
