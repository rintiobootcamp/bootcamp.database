package com.bootcamp.repositories;

import com.bootcamp.entities.User;

/**
 *
 * @author Bello
 */
public class UserRepository extends BaseRepository<User> {

    /**
     * Initialize the repository with the wanted persistence unit
     *
     * @param unitPersistence
     */
    public UserRepository(String unitPersistence) {
        super(unitPersistence, User.class);
    }
}
