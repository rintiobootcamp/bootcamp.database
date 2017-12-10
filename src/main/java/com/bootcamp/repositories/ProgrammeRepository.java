/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Programme;

/**
 *
 * @author Moh
 */
public class ProgrammeRepository extends BaseRepository<Programme> {
    public ProgrammeRepository(String unitPersistence) {
        super(unitPersistence, Programme.class);
    }
}
