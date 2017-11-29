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
public class AxeTest {

    private final AxeRepository axeRepository = new AxeRepository(AppConstants.PERSISTENCE_UNIT);

    @Test
    public void createAxe() throws SQLException, FileNotFoundException, IOException {
        String nom[] = {"Axe stratégique 1", "Axe stratégique 2", "Axe stratégique 3", "Axe stratégique 4", "Axe stratégique 5", "Axe stratégique 6", "Axe stratégique 7"};
        for (int i = 0; i < nom.length; i++) {
            Axe axe = new Axe();
            axe.setNom("Axe stratégique 1");
            axe.setTitre("Renforcement des bases de la démocratie et de l’État de droit");
            axe.setDescription("Cela passera notamment par une révision d.");
            axe.setTitreFocus("un cadre institutionnel et démocratique plus équilibré");
            axe.setDescriptionFocus("Cet axe stratégique insistera sur la mise en place d’instruments juridiques ayant vocation à répondre aux défis de l’État de droit tels que la révision de la Constitution du 11 décembre 1990, l’adoption de la loi organique sur l’administration publique, la revitalisation du système partisan et la modernisation dusystème électoral.De plus, d’autres instruments juridiques auront pour objectif de renforcer les institutions de contre-pou.");
            axe.setDateCreation(15118908400L);
            axe.setDateMiseAJour(1511890840L);
            axeRepository.create(axe);
        }

        List<Axe> axes = axeRepository.findAll();
        //Assert.assertEquals(axes.size(), 7);
    }

}
