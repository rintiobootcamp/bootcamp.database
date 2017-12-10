/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Commentaire;
import com.bootcamp.entities.Note;
import com.bootcamp.entities.Objectif;

/**
 *
 * @author Archange
 */
public class ObjectifRepository extends BaseRepository<Objectif>{
    public ObjectifRepository(String unitPersistence) {
        super(unitPersistence, Objectif.class);
    }    
}
