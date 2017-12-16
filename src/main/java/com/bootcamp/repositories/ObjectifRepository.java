/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Objectif;

/**
 *
 * @author Archange
 */
public class ObjectifRepository extends BaseRepository<Objectif> {

    /**
     * Initialize the repository with the wanted persistence unit
     *
     * @param unitPersistence
     */
    public ObjectifRepository(String unitPersistence) {
        super(unitPersistence, Objectif.class);
    }
}
