/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.commons.exceptions.DatabaseException;
import com.bootcamp.commons.models.Criteria;
import com.bootcamp.commons.models.Criterias;
import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.*;
import com.bootcamp.repositories.*;
import com.google.common.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Iso-Doss
 */
public class PilierTest {

    private final PilierRepository pilierRepository = new PilierRepository(AppConstants.PERSISTENCE_UNIT);

    @Test(priority = 0, groups = {"Pilier Pilier"})
    public void createPilier() throws SQLException, FileNotFoundException, IOException {
        String nom[] = {"Pilier 1", "Pilier 2", "Pilier 3", "Pilier 4", "Pilier 5", "Pilier 6", "Pilier 7"};
        for (int i = 0; i < nom.length; i++) {
            Pilier pilier = new Pilier();
            pilier.setNom(nom[i]);
            pilier.setDescription("Description pilier");
            pilier.setDateCreation(15118908400L);
            pilier.setDateMiseAJour(15118908400L);
            pilierRepository.create(pilier);
        }
        List<Pilier> piliers = pilierRepository.findAll();
        Assert.assertEquals(piliers.size(), 7);
    }


    @Test(priority = 1, groups = {"Pilier Test"})
    public void getPilierByCriteria() throws SQLException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));
        List<Pilier> piliers = pilierRepository.getDataByCriteria(criterias, "be");
        Assert.assertNotEquals(piliers.size(), 0);
    }

    //@Test(priority = 2, groups = {"Pilier Test"})
    public void getPilierWithFields() throws SQLException, IllegalAccessException, DatabaseException, InvocationTargetException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "Pilier 1"));
        List<String> fields = new ArrayList<String>() {
            {
                add("id");
                add("nom");
            }
        };
        List<Pilier> piliers = pilierRepository.getDataByCriteria(criterias, "be", fields);
        for (Pilier pilier : piliers) {
            Assert.assertNotNull(pilier.getId());
            Assert.assertNull(pilier.getNom());
        }
    }

}
