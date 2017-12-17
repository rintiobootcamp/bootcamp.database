/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Axe;

/**
 *
 * @author Bello
 */
public class AxeRepository extends BaseRepository<Axe> {

    /**
     * Initialize the repository with the wanted persistence unit
     *
     * @param unitPersistence
     */
    public AxeRepository(String unitPersistence) {
        super(unitPersistence, Axe.class);
    }
}
