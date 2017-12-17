/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Secteur;

/**
 *
 * @author Bello
 */
public class SecteurRepository extends BaseRepository<Secteur> {

    /**
     * Initialize the repository with the wanted persistence unit
     *
     * @param unitPersistence
     */
    public SecteurRepository(String persistUnit) {
        super(persistUnit, Secteur.class);
    }
}
