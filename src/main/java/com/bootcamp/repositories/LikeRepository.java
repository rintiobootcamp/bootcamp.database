/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Commentaire;
import com.bootcamp.entities.Like;

/**
 *
 * @author Archange
 */
public class LikeRepository extends BaseRepository<Like>{
    public LikeRepository(String unitPersistence) {
        super(unitPersistence, Like.class);
    }    
}
