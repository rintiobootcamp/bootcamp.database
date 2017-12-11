/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Question;

/**
 *
 * @author Bello
 */
public class QuestionRepository extends BaseRepository<Question> {
    public QuestionRepository(String unitPersistence) {
        super(unitPersistence, Question.class);
    }
}
