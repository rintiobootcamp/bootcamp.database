package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import com.bootcamp.commons.enums.TypeImpact;
import io.swagger.annotations.*;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Moh
 */
@Entity
@ApiModel(value = "Impact", description = "Description of the impact of the projects")
public class Impact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Basic(fetch = FetchType.LAZY, optional = false)
    @ApiModelProperty(value = "Type of the impact of the project", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private TypeImpact typeImpact;

    @ApiModelProperty(value = "description of the impact", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String unite;

    @ApiModelProperty(value = "gives the type of impact", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double value;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(length = 1024)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String autres;

    @ManyToOne
//    @ApiModelProperty(value = "The projet of Impact", required = true)
//    @JoinColumn(name = "projet", referencedColumnName = "id", insertable = false, updatable = false)
//    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private Projet projet;

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    /**
     * Get the impact id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the impact id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the impact type
     *
     * @return the impact type
     */
    public TypeImpact getTypeImpact() {
        return typeImpact;
    }

    /**
     * Set the impact type
     *
     * @param typeImpact impact type to set
     */
    public void setTypeImpact(TypeImpact typeImpact) {
        this.typeImpact = typeImpact;
    }

    /**
     * Get the impact unit
     *
     * @return the unit
     */
    public String getUnite() {
        return unite;
    }

    /**
     * Set the impact unit
     *
     * @param unite the unit to set
     */
    public void setUnite(String unite) {
        this.unite = unite;
    }

    /**
     * Get the impact value
     *
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * Set the impact value
     *
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Get the other impact
     *
     * @return the other impact
     */
    public String getAutres() {
        return autres;
    }

    /**
     * Set the other impact
     *
     * @param autres the other impact to set
     */
    public void setAutres(String autres) {
        this.autres = autres;
    }
}
