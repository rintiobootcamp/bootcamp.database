/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.TypeReponse;

/**
 *
 * @author Bello
 */
public class TypeReponseRepository extends BaseRepository<TypeReponse> {
    public TypeReponseRepository(String unitPersistence) {
        super(unitPersistence, TypeReponse.class);
    }
}
