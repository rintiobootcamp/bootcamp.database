package com.bootcamp.repositories;

import com.bootcamp.entities.Projet;

/**
 *
 * @author Bello
 */
public class ProjetRepository extends BaseRepository<Projet> {

    /**
     * Initialize the repository with the wanted persistence unit
     *
     * @param unitPersistence
     */
    public ProjetRepository(String unitPersistence) {
        super(unitPersistence, Projet.class);
    }
}
