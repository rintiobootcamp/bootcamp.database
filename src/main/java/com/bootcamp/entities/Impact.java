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
	@ApiModelProperty(value = "Id of the impact", notes = "This id is automatically generated ,it doesn't required")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;


    @Basic(fetch = FetchType.LAZY, optional = false)
    @ApiModelProperty(value = "Type of the project's impact", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private TypeImpact typeImpact;


    @ApiModelProperty(value = "define the impact unite")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String unite;

    @ApiModelProperty(value = "set the value of the unite")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private double value;


    @Lob
    @Basic(fetch = FetchType.LAZY, optional = false)
    @Column(nullable = false, length = 1024)
	@ApiModelProperty(value = "for the non quantifiable impact")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String autres;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeImpact getTypeImpact() {
        return typeImpact;
    }

    public void setTypeImpact(TypeImpact typeImpact) {
        this.typeImpact = typeImpact;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getAutres() {
        return autres;
    }

    public void setAutres(String autres) {
        this.autres = autres;
    }
}
