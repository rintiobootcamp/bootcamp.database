/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.commons.exceptions.DatabaseException;
import com.bootcamp.commons.models.Criteria;
import com.bootcamp.commons.models.Criterias;
import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Projet;
import com.bootcamp.repositories.ProjetRepository;
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
public class ProjetTest {

    private final ProjetRepository projetRepository = new ProjetRepository(AppConstants.PERSISTENCE_UNIT);

    //@Test(priority = 0, groups = {"Projet Test"})
    public void createProjet() throws SQLException, FileNotFoundException, IOException {
        String nom[] = {"Projet 1", "Projet 2", "Projet 3", "Projet 4", "Projet 5", "Projet 6", "Projet 7"};
        for (int i = 0; i < nom.length; i++) {
            Projet projet = new Projet();
            projet.setNom(nom[i]);
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
        Assert.assertEquals(projets.size(), 7);
    }

    @Test(priority = 1, groups = {"Projet Test"})
    public void getProjetByCriteria() throws SQLException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));
        List<Projet> projets = projetRepository.getDataByCriteria(criterias, "be");
        Assert.assertNotEquals(projets.size(), 0);
    }

    //@Test(priority = 2, groups = {"Projet Test"})
    public void getProjetWithFields() throws SQLException, IllegalAccessException, DatabaseException, InvocationTargetException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "Projet 1"));
        List<String> fields = new ArrayList<String>() {
            {
                add("id");
                add("nom");
            }
        };
        List<Projet> projets = projetRepository.getDataByCriteria(criterias, "be", fields);
        for (Projet projet : projets) {
            Assert.assertNotNull(projet.getId());
            Assert.assertNull(projet.getNom());
        }
    }

}
