
package com.bootcamp.repositories;

import com.bootcamp.entities.PagUser;


public class UserRepository extends BaseRepository<PagUser>{
  
    public UserRepository(String unitPersistence) {
        super(unitPersistence, PagUser.class);
    }
}
