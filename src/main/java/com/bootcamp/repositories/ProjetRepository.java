
package com.bootcamp.repositories;

import com.bootcamp.entities.Projet;

public class ProjetRepository extends BaseRepository<Projet>{
  
    public ProjetRepository(String unitPersistence) {
        super(unitPersistence, Projet.class);
    }
}
