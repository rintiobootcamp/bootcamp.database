/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.commons.enums.RegionType;
import com.bootcamp.commons.exceptions.DatabaseException;
import com.bootcamp.commons.models.Criteria;
import com.bootcamp.commons.models.Criterias;
import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Region;
import com.bootcamp.repositories.RegionRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Iso-Doss
 */
public class RegionTest {

    private final RegionRepository regionRepository = new RegionRepository(AppConstants.PERSISTENCE_UNIT);

    @Test(priority = 0, groups = {"Region Test"})
    public void createRegion() throws SQLException, FileNotFoundException, IOException {
        String nom[] = {"Region 1", "Region 2", "Region 3", "Region 4", "Region 5", "Region  6", "Region 7"};

        for (int i = 0; i < nom.length; i++) {
            Region region = new Region();
            region.setNom(nom[i]);
            region.setLatitude(15118908400L);
            region.setLongitude(15118908400L);
            region.setType(RegionType.VILLE);
            regionRepository.create(region);
        }

        List<Region> regions = regionRepository.findAll();
        Assert.assertEquals(regions.size(), 7);
    }

    @Test(priority = 1, groups = {"Region Test"})
    public void getRegionByCriteria() throws SQLException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));
        List<Region> regions = regionRepository.getDataByCriteria(criterias, "be");

        Assert.assertNotEquals(regions.size(), 0);

    }

    //@Test(priority = 2, groups = {"Region Test"})
    public void getRegionWithFields() throws SQLException, IllegalAccessException, DatabaseException, InvocationTargetException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));

        List<String> fields = new ArrayList<String>() {
            {
                add("id");
                add("nom");
            }
        };

        List<Region> regions = regionRepository.getDataByCriteria(criterias, "be", fields);

        for (Region region : regions) {
            Assert.assertNotNull(region.getId());
            Assert.assertNull(region.getNom());
        }
    }

}
