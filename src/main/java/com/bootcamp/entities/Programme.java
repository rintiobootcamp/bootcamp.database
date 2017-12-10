package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
    @ApiModelProperty(value = "Name of the Project", required = true)
    private String nom;

    @Lob
    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Description of the Project", required = true)
    private String description;

    @Lob
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @ApiModelProperty(value = "Description of the Project", required = true)
    private String focus;

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

    @OneToMany(mappedBy = "programme", cascade = CascadeType.ALL)
    @ApiModelProperty(value = "List of the project phases")
    @Basic(fetch = FetchType.LAZY, optional = false)
    private List<Projet> projetList;

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

    public long getDateDebutReel() {
        return dateDebutReel;
    }

    public void setDateDebutReel(long dateDebutReel) {
        this.dateDebutReel = dateDebutReel;
    }

    public long getDateFinReel() {
        return dateFinReel;
    }

    public void setDateFinReel(long dateFinReel) {
        this.dateFinReel = dateFinReel;
    }

    public long getDateDebutPrevisionnel() {
        return dateDebutPrevisionnel;
    }

    public void setDateDebutPrevisionnel(long dateDebutPrevisionnel) {
        this.dateDebutPrevisionnel = dateDebutPrevisionnel;
    }

    public long getDateFinPrevisionnel() {
        return dateFinPrevisionnel;
    }

    public void setDateFinPrevisionnel(long dateFinPrevisionnel) {
        this.dateFinPrevisionnel = dateFinPrevisionnel;
    }

    public List<Projet> getProjetList() {
        return projetList;
    }

    public void setProjetList(List<Projet> projetList) {
        this.projetList = projetList;
    }


}
