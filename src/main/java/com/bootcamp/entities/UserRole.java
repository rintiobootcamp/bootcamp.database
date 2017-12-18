package com.bootcamp.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by darextossa on 12/16/17.
 * Modified by bignonfebron on 12/18/17.
 */

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private PagUser pagUser;
    private Role role;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
