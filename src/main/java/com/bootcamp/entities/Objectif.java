package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import com.bootcamp.commons.enums.TypeObjectif;
import io.swagger.annotations.*;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Moh
 */
@Entity
@ApiModel(value = "Objectif", description = "Description of an object objectif")
public class Objectif implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "name of the objectif", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String nom;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "description of the objectif", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String description;

    @ApiModelProperty(value = "gives the type of Objectif", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private TypeObjectif typeObjectif;

    @ManyToOne
    @JoinColumn(name = "projet", referencedColumnName = "id", insertable = false, updatable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private Projet projet;

    /**
     * Get the goal id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the goal id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the goal name
     *
     * @return the name
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the goal name
     *
     * @param nom the name to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the goal description
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the goal description
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the goal type
     *
     * @return the goal type
     */
    public TypeObjectif getTypeObjectif() {
        return typeObjectif;
    }

    /**
     * Get the goal type
     *
     * @param typeObjectif the type to set
     */
    public void setTypeObjectif(TypeObjectif typeObjectif) {
        this.typeObjectif = typeObjectif;
    }

    /**
     * Get the goal project
     *
     * @return the project
     */
    public Projet getProjet() {
        return projet;
    }

    /**
     * Set the goal project
     *
     * @param projet the project to set
     */
    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
