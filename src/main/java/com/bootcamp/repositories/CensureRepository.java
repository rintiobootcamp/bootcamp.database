/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Censure;

/**
 *
 * @author Bello
 */
public class CensureRepository extends BaseRepository<Censure> {

    /**
     * Initialize the repository with the wanted persistence unit
     *
     * @param unitPersistence
     */
    public CensureRepository(String unitPersistence) {
        super(unitPersistence, Censure.class);
    }
}
