/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.commons.enums.EntityType;
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
public class CommentaireTest {

    private final CommentaireRepository commentaireRepository = new CommentaireRepository(AppConstants.PERSISTENCE_UNIT);

    @Test
    public void createCommentaire() throws SQLException, FileNotFoundException, IOException {
        String pseudo[] = {"peudo1", "peudo2", "peudo3", "peudo4", "peudo5", "peudo6", "peudo7"};
        for (int i = 0; i < pseudo.length; i++) {
            Commentaire commentaire = new Commentaire();
            commentaire.setContenu("Contenu   ......");
            commentaire.setPseudo(pseudo[i]);
            commentaire.setDateCreation(15118908400L);
            commentaire.setDateMiseAJour(1511890840L);
            commentaire.setEntityType(EntityType.PROJET);
            commentaireRepository.create(commentaire);

        }

        List<Commentaire> commentaires = commentaireRepository.findAll();
        //Assert.assertEquals(commentaires.size(), 7);
    }

    @Test(priority = 2, groups = {"Commentaire Test"})
    public void getCommentaireByCriteria() throws SQLException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("contenu", "<>", "TOTO"));
        List<Commentaire> commentaires = commentaireRepository.getDataByCriteria(criterias, "be");

        Assert.assertNotEquals(commentaires.size(), 0);

    }

    @Test(priority = 3, groups = {"Commentaire Test"})
    public void getCommentaireWithFields() throws SQLException, IllegalAccessException, DatabaseException, InvocationTargetException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("contenu", "<>", "TOTO"));

        List<String> fields = new ArrayList<String>() {
            {
                add("id");
                add("pseudo");
            }
        };

//        List<Commentaire> commentaires = commentaireRepository.getDataByCriteria(criterias, "be", fields);

//        for (Commentaire commentaire : commentaires) {
//            Assert.assertNotNull(commentaire.getId());
//            Assert.assertNull(commentaire.getPseudo());
//        }

    }

}
