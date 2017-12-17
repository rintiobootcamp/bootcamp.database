/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.loadDataFromJsonFile;

import com.bootcamp.TestUtils;
import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.*;
import com.bootcamp.repositories.*;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Iso-Doss
 */
public class loadDataFromJsonFileTest {

    private final AxeRepository axeRepository = new AxeRepository(AppConstants.PERSISTENCE_UNIT);
    private final SecteurRepository secteurRepository = new SecteurRepository(AppConstants.PERSISTENCE_UNIT);
    private final PilierRepository pilierRepository = new PilierRepository(AppConstants.PERSISTENCE_UNIT);
    private final ProjetRepository projetRepository = new ProjetRepository(AppConstants.PERSISTENCE_UNIT);
    private final PhaseRepository phaseRepository = new PhaseRepository(AppConstants.PERSISTENCE_UNIT);
    private final ObjectifRepository objectifRepository = new ObjectifRepository(AppConstants.PERSISTENCE_UNIT);

    @Test(priority = 1, groups = {"load Data From JsonFile Test"})
    public void loadDataObjectifFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "objectifs.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Objectif>>() {
        }.getType();
        List<Objectif> objectifs = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);

        for (int i = 0; i < objectifs.size(); i++) {
            Objectif get = objectifs.get(i);
            objectifRepository.create(get);
        }

    }

    @Test(priority = 2, groups = {"load Data From JsonFile Test"})
    public void loadDataPhaseFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "phases.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Phase>>() {
        }.getType();
        List<Phase> phases = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);

        for (int i = 0; i < phases.size(); i++) {
            Phase get = phases.get(i);
            phaseRepository.create(get);
        }

    }

    @Test(priority = 3, groups = {"load Data From JsonFile Test"})
    public void loadDataProjetFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "projets.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Projet>>() {
        }.getType();
        List<Projet> projets = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);
        setProjetPhase(projets);

    }

    @Test(priority = 4, groups = {"load Data From JsonFile Test"})
    public void loadDataUpdateObjectifFromJsonFile() throws Exception {
        List<Objectif> objectifs = objectifRepository.findAll();
        for (int i = 0; i < objectifs.size(); i++) {
            Objectif get = objectifs.get(i);
            get.setProjet(projetRepository.findById(i+1));
            objectifRepository.create(get);
        }

    }

    @Test(priority = 5, groups = {"load Data From JsonFile Test"})
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

    @Test(priority = 6, groups = {"load Data From JsonFile Test"})
    public void loadDataAxeFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "axes.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Axe>>() {
        }.getType();
        List<Axe> axes = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);
        for (int i = 0; i < axes.size(); i++) {
            Axe get = axes.get(i);
            List<Secteur> secteurs = new LinkedList();
            switch (i) {
                case 0:
                    secteurs.add(secteurRepository.findById(8));
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    secteurs.add(secteurRepository.findById(1));
                    secteurs.add(secteurRepository.findById(2));
                    secteurs.add(secteurRepository.findById(5));
                    secteurs.add(secteurRepository.findById(9));
                    break;
                case 4:
                    secteurs.add(secteurRepository.findById(3));
                    break;
                case 5:
                    secteurs.add(secteurRepository.findById(8));
                    break;
                case 6:
                    secteurs.add(secteurRepository.findById(6));
                    break;
            }
            get.setSecteurs(secteurs);
            axeRepository.create(get);
        }
    }

    @Test(priority = 7, groups = {"load Data From JsonFile Test"})
    public void loadDataPilierFromJsonFile() throws Exception {
        TestUtils testUtils = new TestUtils();
        File dataFile = testUtils.getFile("data-json" + File.separator + "piliers.json");

        String text = Files.toString(new File(dataFile.getAbsolutePath()), Charsets.UTF_8);

        Type typeOfObjectsListNew = new TypeToken<List<Pilier>>() {
        }.getType();
        List<Pilier> piliers = GsonUtils.getObjectFromJson(text, typeOfObjectsListNew);
        //List<Axe> axes = axeRepository.findAll();
        for (int i = 0; i < piliers.size(); i++) {
            List<Axe> axes = new LinkedList();
            Pilier get = piliers.get(i);
            switch (i) {
                case 0:
                    axes.add(axeRepository.findById(1));
                    axes.add(axeRepository.findById(2));
                    break;
                case 1:
                    axes.add(axeRepository.findById(3));
                    axes.add(axeRepository.findById(4));
                    axes.add(axeRepository.findById(5));
                    break;
                case 2:
                    axes.add(axeRepository.findById(6));
                    axes.add(axeRepository.findById(7));
                    break;
            }
            get.setAxes(axes);
            pilierRepository.create(get);
        }
    }

    private void setProjetPhase(List<Projet> projets) throws Exception {
        for (int i = 0; i < projets.size(); i++) {
            Projet get = projets.get(i);
            List<Objectif> objectifs = new LinkedList();
            objectifs.add(objectifRepository.findById(i+1));
            get.setObjectifList(objectifs);
            List<Phase> phases = new LinkedList();
            switch (i) {
                case 0:
                    for (int j = 0; j < 8; j++) {
                        phases.add(phaseRepository.findById(j+1));
                    }
                    break;
                case 1:
                    for (int j = 0; j < 8; j++) {
                        phases.add(phaseRepository.findById(j+9));
                    }
                    break;
                case 2:
                    for (int j = 0; j < 7; j++) {
                        phases.add(phaseRepository.findById(j+16));
                    }
                    break;
                case 3:
                    for (int j = 0; j < 7; j++) {
                        phases.add(phaseRepository.findById(j+23));
                    }
                    break;
                case 4:
                    for (int j = 0; j < 8; j++) {
                        phases.add(phaseRepository.findById(j+31));
                    }
                    break;
                case 5:
                    for (int j = 0; j < 7; j++) {
                        phases.add(phaseRepository.findById(j+38));
                    }
                    break;
                case 6:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+43));
                    }
                    break;
                case 7:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+48));
                    }
                    break;
                case 8:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+53));
                    }
                    break;
                case 9:
                    for (int j = 0; j < 6; j++) {
                        phases.add(phaseRepository.findById(j+59));
                    }
                    break;
                case 10:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+64));
                    }
                    break;
                case 11:
                    for (int j = 0; j < 3; j++) {
                        phases.add(phaseRepository.findById(j+67));
                    }
                    break;
                case 12:
                    for (int j = 0; j < 3; j++) {
                        phases.add(phaseRepository.findById(j+70));
                    }
                    break;
                case 13:
                    for (int j = 0; j < 3; j++) {
                        phases.add(phaseRepository.findById(j+73));
                    }
                    break;
                case 14:
                    for (int j = 0; j < 3; j++) {
                        phases.add(phaseRepository.findById(j+76));
                    }
                    break;
                case 15:
                    for (int j = 0; j < 3; j++) {
                        phases.add(phaseRepository.findById(j+79));
                    }
                    break;
                case 16:
                    for (int j = 0; j < 3; j++) {
                        phases.add(phaseRepository.findById(j+82));
                    }
                    break;
                case 17:
                    for (int j = 0; j < 3; j++) {
                        phases.add(phaseRepository.findById(j+85));
                    }
                    break;
                case 18:
                    for (int j = 0; j < 6; j++) {
                        phases.add(phaseRepository.findById(j+91));
                    }
                    break;
                case 19:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+96));
                    }
                    break;
                case 20:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+100));
                    }
                    break;
                case 21:
                    for (int j = 0; j < 7; j++) {
                        phases.add(phaseRepository.findById(j+107));
                    }
                    break;
                case 22:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+112));
                    }
                    break;
                case 23:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+117));
                    }
                    break;
                case 24:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+122));
                    }
                    break;
                case 25:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+126));
                    }
                    break;
                case 26:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+130));
                    }
                    break;
                case 27:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+134));
                    }
                    break;
                case 28:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+138));
                    }
                    break;
                case 29:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+143));
                    }
                    break;
                case 30:
                    for (int j = 0; j < 3; j++) {
                        phases.add(phaseRepository.findById(j+146));
                    }
                    break;
                case 31:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+151));
                    }
                    break;
                case 32:
                    for (int j = 0; j < 6; j++) {
                        phases.add(phaseRepository.findById(j+157));
                    }
                    break;
                case 33:
                    for (int j = 0; j < 7; j++) {
                        phases.add(phaseRepository.findById(j+164));
                    }
                    break;
                case 34:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+68));
                    }
                    break;
                case 35:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+172));
                    }
                    break;
                case 36:
                    for (int j = 0; j < 6; j++) {
                        phases.add(phaseRepository.findById(j+178));
                    }
                    break;
                case 37:
                    for (int j = 0; j < 2; j++) {
                        phases.add(phaseRepository.findById(j+180));
                    }
                    break;
                case 38:
                    for (int j = 0; j < 5; j++) {
                        phases.add(phaseRepository.findById(j+185));
                    }
                    break;
                case 39:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+189));
                    }
                    break;
                case 40:
                    for (int j = 0; j < 6; j++) {
                        phases.add(phaseRepository.findById(j+195));
                    }
                    break;
                case 41:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+199));
                    }
                    break;
                case 42:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+203));
                    }
                    break;
                case 43:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+207));
                    }
                    break;
                case 44:
                    for (int j = 0; j < 4; j++) {
                        phases.add(phaseRepository.findById(j+211));
                    }
                    break;
            }
            get.setPhases(phases);
            projetRepository.create(get);
        }

    }
}
