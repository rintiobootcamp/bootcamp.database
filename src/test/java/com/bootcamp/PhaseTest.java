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
public class PhaseTest {

    private final PhaseRepository phaseRepository = new PhaseRepository(AppConstants.PERSISTENCE_UNIT);

    @Test
    public void createPhase() throws SQLException, FileNotFoundException, IOException {
        String nom[] = {"Phase Phase 1", "Phase Phase 2", "Phase Phase 3", "Phase Phase 4", "Phase Phase 5", "Phase Phase 6", "Phase Phase 7"};
        for (int i = 0; i < nom.length; i++) {
            Phase phase = new Phase();
            phase.setNom(nom[i]);
            phase.setActif(true);
            phase.setDateDebut(15118908400L);
            phase.setDateFin(1511890840L);
            phaseRepository.create(phase);
        }

        List<Phase> phases = phaseRepository.findAll();
        //Assert.assertEquals(phases.size(), 7);
    }

}
