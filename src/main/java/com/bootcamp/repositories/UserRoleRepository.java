/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Axe;
import com.bootcamp.entities.UserRole;

/**
 *
 * @author Bello
 */
public class UserRoleRepository extends BaseRepository<UserRole> {
    public UserRoleRepository(String unitPersistence) {
        super(unitPersistence, UserRole.class);
    }
}
