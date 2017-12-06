/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Debat;

/**
 *
 * @author Bello
 */
public class DebatRepository extends BaseRepository<Debat> {
    public DebatRepository(String unitPersistence) {
        super(unitPersistence, Debat.class);
    }
}
