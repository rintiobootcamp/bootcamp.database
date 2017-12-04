/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Commentaire;
import com.bootcamp.entities.LikeTable;

/**
 *
 * @author Archange
 */
public class LikeRepository extends BaseRepository<LikeTable>{
    public LikeRepository(String unitPersistence) {
        super(unitPersistence, LikeTable.class);
    }    
}
