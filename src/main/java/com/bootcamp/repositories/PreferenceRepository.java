/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;


import com.bootcamp.entities.Preference;

/**
 *
 * @author Moh
 */
public class PreferenceRepository extends BaseRepository<Preference>{
    public PreferenceRepository(String unitPersistence) {
        super(unitPersistence, Preference.class);
    }    
}
