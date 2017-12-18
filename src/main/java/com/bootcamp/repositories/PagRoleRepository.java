/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.PagRole;

/**
 *
 * @author Bello
 */
public class PagRoleRepository extends BaseRepository<PagRole> {
    public PagRoleRepository(String unitPersistence) {
        super(unitPersistence, PagRole.class);
    }
}
