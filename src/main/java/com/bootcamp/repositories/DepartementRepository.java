package com.bootcamp.repositories;

import com.bootcamp.entities.Departement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class DepartementRepository extends BaseRepository<Departement>{
    
    public DepartementRepository(String unitPersistence) {
        super(unitPersistence, Departement.class);
    }
    
}
