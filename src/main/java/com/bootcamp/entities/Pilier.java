package com.bootcamp.entities;

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
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value="Id of pilier' Model",notes = "This id is automatically generated ,it doesn't required")
    private int id;

    @Column
    @ApiModelProperty(value="the name of this particular pilier",notes ="this name is required during the creation of a pilier",required = true)
    private String name;

    @Column
    @ApiModelProperty(value="the description of the pilar",notes="the description is not obligatory but necessary",required = false)
    private String description;

    @Column
    @ApiModelProperty(value="the date of creation of this particular pilar")
    private Timestamp createAt;

    @Column
    @ApiModelProperty(value="the updated date",notes="the date when this pilar has been modified at last")
    private Timestamp updateAt;

    @Column
    @ApiModelProperty(value="comments list",notes = "the list of all comments related to this pilar")
    private List<Integer> comments;

    @Column
    @ApiModelProperty(value="media list",notes = "the list of all media  related to this pilar")
    private List<Integer> medias;
    
    @OneToMany
    @NotNull(message = "The list of axes field must not be empty")
    private List<Axe> listAxes;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    public List<Integer> getComments() {
        return comments;
    }

    public void setComments(List<Integer> comments) {
        this.comments = comments;
    }

    public List<Integer> getMedias() {
        return medias;
    }

    public void setMedias(List<Integer> medias) {
        this.medias = medias;
    }

    /**
     * @return the listAxes
     */
    public List<Axe> getListaxes() {
        return listAxes;
    }

    /**
     * @param listAxes the listAxes to set
     */
    public void setListaxes(List<Axe> listAxes) {
        this.listAxes = listAxes;
    }
}
