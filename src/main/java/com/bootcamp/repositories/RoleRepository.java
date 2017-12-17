/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Role;

/**
 *
 * @author Bello
 */
public class RoleRepository extends BaseRepository<Role> {
    public RoleRepository(String unitPersistence) {
        super(unitPersistence, Role.class);
    }
}
