/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Financement;

/**
 *
 * @author leger
 */
public class FinancementRepository extends BaseRepository<Financement> {
    public FinancementRepository(String unitPersistence) {
        super(unitPersistence, Financement.class);
    }
}
