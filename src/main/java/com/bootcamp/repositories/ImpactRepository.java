/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;


import com.bootcamp.entities.Impact;

/**
 *
 * @author Moh
 */
public class ImpactRepository extends BaseRepository<Impact>{
    public ImpactRepository(String unitPersistence) {
        super(unitPersistence, Impact.class);
    }    
}
