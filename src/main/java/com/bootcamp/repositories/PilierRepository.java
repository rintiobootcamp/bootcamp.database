package com.bootcamp.repositories;

import com.bootcamp.entities.Pilier;

public class PilierRepository extends BaseRepository<Pilier>{
    public PilierRepository(String persistUnit){
        super(persistUnit,Pilier.class);
    }
}
