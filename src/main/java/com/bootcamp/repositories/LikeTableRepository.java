/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.LikeTable;

/**
 *
 * @author Archange
 */
public class LikeTableRepository extends BaseRepository<LikeTable>{
    public LikeTableRepository(String unitPersistence) {
        super(unitPersistence, LikeTable.class);
    }    
}
