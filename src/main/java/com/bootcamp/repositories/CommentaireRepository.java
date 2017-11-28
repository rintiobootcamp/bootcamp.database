/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Comment;

/**
 *
 * @author rosius
 */
public class CommentRepository extends BaseRepository<Comment>{
    public CommentRepository(String unitPersistence) {
        super(unitPersistence, Comment.class);
    }    
}
