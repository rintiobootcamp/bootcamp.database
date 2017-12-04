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
import com.bootcamp.entities.Phase;
import com.bootcamp.repositories.PhaseRepository;
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
public class PhaseTest {

    private final PhaseRepository phaseRepository = new PhaseRepository(AppConstants.PERSISTENCE_UNIT);

    //@Test(priority = 0, groups = {"Phase Test"})
    public void createPhase() throws SQLException, FileNotFoundException, IOException {
        String nom[] = {"Phase 1", "Phase 2", "Phase 3", "Phase 4", "Phase 5", "Phase 6", "Phase 7"};
        for (int i = 0; i < nom.length; i++) {
            Phase phase = new Phase();
            phase.setNom(nom[i]);
            phase.setActif(true);
            phase.setDateDebut(15118908400L);
            phase.setDateFin(1511890840L);
            phaseRepository.create(phase);
        }
        List<Phase> phases = phaseRepository.findAll();
        Assert.assertEquals(phases.size(), 7);
    }

    @Test(priority = 1, groups = {"Phase Test"})
    public void getPhaseByCriteria() throws SQLException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));
        List<Phase> phases = phaseRepository.getDataByCriteria(criterias, "be");
        Assert.assertNotEquals(phases.size(), 0);
    }

    //@Test(priority = 2, groups = {"Phase Test"})
    public void getPhaseWithFields() throws SQLException, IllegalAccessException, DatabaseException, InvocationTargetException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "Phase 1"));
        List<String> fields = new ArrayList<String>() {
            {
                add("id");
                add("nom");
            }
        };
        List<Phase> phases = phaseRepository.getDataByCriteria(criterias, "be", fields);
        for (Phase phase : phases) {
            Assert.assertNotNull(phase.getId());
            Assert.assertNull(phase.getNom());
        }
    }

}
