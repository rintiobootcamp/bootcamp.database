/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;

import com.bootcamp.entities.Region;

/**
 *
 * @author Bello
 */
public class RegionRepository extends BaseRepository<Region> {
    public RegionRepository(String unitPersistence) {
        super(unitPersistence, Region.class);
    }
}
