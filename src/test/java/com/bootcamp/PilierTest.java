/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

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
import java.sql.SQLException;
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

    @Test
    public void createPilier() throws SQLException, FileNotFoundException, IOException {
        String nom[] = {"Pilier Pilier 1", "Pilier Pilier 2", "Pilier Pilier 3", "Pilier Pilier 4", "Pilier Pilier 5", "Pilier Pilier 6", "Pilier Pilier 7"};

        for (int i = 0; i < nom.length; i++) {
            Pilier pilier = new Pilier();
            pilier.setNom(nom[i]);
            pilier.setDescription("Description pilier");
            pilier.setDateCreation(15118908400L);
            pilier.setDateMiseAJour(15118908400L);
            pilierRepository.create(pilier);
        }

        List<Pilier> piliers = pilierRepository.findAll();
        //Assert.assertEquals(piliers.size(), 7);
    }

}
