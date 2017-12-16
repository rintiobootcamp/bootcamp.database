package com.bootcamp.repositories;

import com.bootcamp.entities.Pilier;

/**
 *
 * @author Bello
 */
public class PilierRepository extends BaseRepository<Pilier> {

    /**
     * Initialize the repository with the wanted persistence unit
     *
     * @param unitPersistence
     */
    public PilierRepository(String unitPersistence) {
        super(unitPersistence, Pilier.class);
    }
}
