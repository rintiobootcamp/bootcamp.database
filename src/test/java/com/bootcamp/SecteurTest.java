/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.commons.exceptions.DatabaseException;
import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.commons.models.*;
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
public class SecteurTest {

    private final SecteurRepository secteurRepository = new SecteurRepository(AppConstants.PERSISTENCE_UNIT);

    @Test
    public void createSecteur() throws SQLException, FileNotFoundException, IOException {
        String nom[] = {"Secteur Secteur 1", "Secteur Secteur 2", "Secteur Secteur 3", "Secteur Secteur 4", "Secteur Secteur 5", "Secteur Secteur 6", "Secteur Secteur 7"};

        for (int i = 0; i < nom.length; i++) {
            Secteur secteur = new Secteur();
            secteur.setNom(nom[i]);
            secteur.setDescription("Description secteur");
            secteur.setDescription("Description secteur");
            secteur.setDateCreation(15118908400L);
            secteur.setDateMiseAJour(15118908400L);
            secteur.setIcone("icone");
            secteurRepository.create(secteur);
        }

        List<Secteur> secteurs = secteurRepository.findAll();
        //Assert.assertEquals(secteurs.size(), 7);
    }

    @Test(priority = 2, groups = {"Secteur Test"})
    public void getSecteurByCriteria() throws SQLException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));
        List<Secteur> secteurs = secteurRepository.getDataByCriteria(criterias, "be");

        Assert.assertNotEquals(secteurs.size(), 0);

    }

    @Test(priority = 3, groups = {"Secteur Test"})
    public void getSecteurWithFields() throws SQLException, IllegalAccessException, DatabaseException, InvocationTargetException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));

        List<String> fields = new ArrayList<String>() {
            {
                add("id");
                add("nom");
            }
        };

        List<Secteur> secteurs = secteurRepository.getDataByCriteria(criterias, "be", fields);

        for (Secteur secteur : secteurs) {
            Assert.assertNotNull(secteur.getId());
            Assert.assertNull(secteur.getDescription());
        }

    }

}
