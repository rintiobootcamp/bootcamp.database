/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.commons.exceptions.DatabaseException;
import com.bootcamp.commons.models.*;
import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.*;
import com.bootcamp.repositories.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Iso-Doss
 */
public class ProjetTest {

    private final ProjetRepository projetRepository = new ProjetRepository(AppConstants.PERSISTENCE_UNIT);

    @Test
    public void createProjet() throws SQLException, FileNotFoundException, IOException {
        String nom[] = {"Projet Projet 1", "Projet Projet 2", "Projet Projet 3", "Projet Projet 4", "Projet Projet 5", "Projet Projet 6", "Projet Projet 7"};
//        int j=0;//number of sector incrementor
        for (int i = 0; i < nom.length; i++) {
            Projet projet = new Projet();
            projet.setNom(nom[i]);
            projet.setDescription("Description projet");
            projet.setDescription("Description projet");
            projet.setReference("reference");
            projet.setObjectif("objectif");
            projet.setCoutReel(15118908400L);
            projet.setBudgetPrevisionnel(15118908400L);
            projet.setBudgetReel(15118908400L);
            projet.setDateDebutReel(15118908400L);
            projet.setDateFinPrevisionnel(15118908400L);
            projet.setDateFinReel(15118908400L);
            projet.setIdSecteur(1);

            projetRepository.create(projet);
        }

        List<Projet> projets = projetRepository.findAll();
        //Assert.assertEquals(projets.size(), 7);
    }

    @Test(priority = 2, groups = {"Projet Test"})
    public void getProjetByCriteria() throws SQLException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));
        List<Projet> projets = projetRepository.getDataByCriteria(criterias, "be");

        Assert.assertNotEquals(projets.size(), 0);

    }

    @Test(priority = 3, groups = {"Projet Test"})
    public void getProjetWithFields() throws SQLException, IllegalAccessException, DatabaseException, InvocationTargetException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));

        List<String> fields = new ArrayList<String>() {
            {
                add("id");
                add("nom");
            }
        };

        List<Projet> projets = projetRepository.getDataByCriteria(criterias, "be", fields);

        for (Projet projet : projets) {
            Assert.assertNotNull(projet.getId());
            Assert.assertNull(projet.getDescription());
        }

    }

}
