package com.bootcamp.entities;
// Generated 12 nov. 2016 14:53:17 by Hibernate Tools 5.2.0.Beta1

import com.bootcamp.commons.annotations.NativeQueryResultColumn;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.ALL;

/**
 * Roles generated by hbm2java
 */
@Entity
public class PagRole implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private Integer id;
    
	@Column(nullable = false, unique = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pagRole", cascade = CascadeType.ALL)
    private List<UserRole> userRoles = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }
}
