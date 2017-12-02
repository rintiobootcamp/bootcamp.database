/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.loadDataFromJsonFile;

import com.bootcamp.TestUtils;
import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Axe;
import com.bootcamp.entities.Pilier;
import com.bootcamp.entities.Projet;
import com.bootcamp.entities.Secteur;
import com.bootcamp.repositories.AxeRepository;
import com.bootcamp.repositories.PilierRepository;
import com.bootcamp.repositories.ProjetRepository;
import com.bootcamp.repositories.SecteurRepository;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Iso-Doss
 */
public class loadDataFromJsonFileTest {

    private final AxeRepository axeRepository = new AxeRepository(AppConstants.PERSISTENCE_UNIT);
    private final SecteurRepository secteurRepository = new SecteurRepository(AppConstants.PERSISTENCE_UNIT);
    private final PilierRepository pilierRepository = new PilierRepository(AppConstants.PERSISTENCE_UNIT);
    private final ProjetRepository projetRepository = new ProjetRepository(AppConstants.PERSISTENCE_UNIT);

    @Test(priority = 0, groups = {"load Data From JsonFile Test"})
    public void loadDataProjetFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "projets.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Projet>>() {
        }.getType();
        List<Projet> projets = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);

        for (int i = 0; i < projets.size(); i++) {
            Projet get = projets.get(i);
            projetRepository.create(get);
        }

    }

    @Test(priority = 1, groups = {"load Data From JsonFile Test"})
    public void loadDataAxeFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "axes.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Axe>>() {
        }.getType();
        List<Axe> axes = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);
        List<Secteur> secteurs = secteurRepository.findAll();

        for (int i = 0; i < axes.size(); i++) {
            Axe get = axes.get(i);
            get.setSecteurs(secteurs);
            axeRepository.create(get);
        }

    }

    @Test(priority = 2, groups = {"load Data From JsonFile Test"})
    public void loadDataSecteurFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "secteurs.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Secteur>>() {
        }.getType();
        List<Secteur> secteurs = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);
        for (int i = 0; i < secteurs.size(); i++) {
            Secteur get = secteurs.get(i);
            secteurRepository.create(get);
        }
    }

    @Test(priority = 3, groups = {"load Data From JsonFile Test"})
    public void loadDataPilierFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "piliers.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Pilier>>() {
        }.getType();
        List<Pilier> piliers = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);
        List<Axe> axes = axeRepository.findAll();
        for (int i = 0; i < piliers.size(); i++) {
            Pilier get = piliers.get(i);
            get.setAxes(axes);
            pilierRepository.create(get);
        }
    }
}
