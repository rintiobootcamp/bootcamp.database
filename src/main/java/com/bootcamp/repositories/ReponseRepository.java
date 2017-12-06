/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Reponse;

/**
 *
 * @author Bello
 */
public class ReponseRepository extends BaseRepository<Reponse> {
    public ReponseRepository(String unitPersistence) {
        super(unitPersistence, Reponse.class);
    }
}
