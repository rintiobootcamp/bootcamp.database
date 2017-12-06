/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author leger
 */
@Entity
public class Reponse implements  Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @ManyToOne
    @ApiModelProperty(value = "type of Reponse", required = true)
    @JoinColumn(name = "typeReponse", referencedColumnName = "id", insertable = false, updatable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.COMPLEX)
    private TypeReponse typeReponse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeReponse getTypeReponse() {
        return typeReponse;
    }

    public void setTypeReponse(TypeReponse typeReponse) {
        this.typeReponse = typeReponse;
    }
    
    
}
