/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Phase;

/**
 *
 * @author Bello
 */
public class PhaseRepository extends BaseRepository<Phase> {

    /**
     * Initialize the repository with the wanted persistence unit
     *
     * @param unitPersistence
     */
    public PhaseRepository(String unitPersistence) {
        super(unitPersistence, Phase.class);
    }
}
