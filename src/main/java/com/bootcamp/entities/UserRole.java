package com.bootcamp.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by darextossa on 12/16/17.
 */

@Entity
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private PagUser pagUser;
    
    private PagRole pagRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PagUser getPagUser() {
        return pagUser;
    }

    public void setPagUser(PagUser pagUser) {
        this.pagUser = pagUser;
    }

    public PagRole getPagRole() {
        return pagRole;
    }

    public void setPagRole(PagRole pagRole) {
        this.pagRole = pagRole;
    }
    
}
