package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.*;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author leger
 */
@Entity
@ApiModel(value = "Programme", description = "Description of a program")
public class Programme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false)
    @ApiModelProperty(value = "budget total du programme", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double budgetTotal;

    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false)
    @ApiModelProperty(value = "budget de projets phares", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double budgetProjetsPhares;

    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false)
    @ApiModelProperty(value = "budget acquis", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double budgetAcquis;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = true)
    @ApiModelProperty(value = "description of amount", required = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String descriptionFinancement;

    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = true)
    @ApiModelProperty(value = "focus of amount", required = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String focusFinancement;

    @Column(nullable = false)
    @ApiModelProperty(value = "creation date of amount")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateCreation;

    @Column(nullable = false)
    @ApiModelProperty(value = "update date of amount")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateMiseAJour;

    @ManyToOne
    @ApiModelProperty(value = "The programm of project", required = true)
    @JoinColumn(name = "projet", referencedColumnName = "id", insertable = false, updatable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private Projet projet;

}
