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
public class MediaTest {

    private final MediaRepository mediaRepository = new MediaRepository(AppConstants.PERSISTENCE_UNIT);

    @Test
    public void createMedia() throws SQLException, FileNotFoundException, IOException {
        String internalName[] = {"internalName1", "internalName2", "internalName3", "internalName4", "internalName5", "internalName6", "internalName7"};
        for (int i = 0; i < internalName.length; i++) {
            Media media = new Media();
            media.setInternalName(internalName[i]);
            media.setDateCreation(15118908400L);
            media.setDateMiseAJour(1511890840L);
            media.setLien("lien");
            media.setType("tof");
            media.setOriginalName("origin name");
            mediaRepository.create(media);
        }

        List<Media> medias = mediaRepository.findAll();
        //Assert.assertEquals(medias.size(), 7);
    }

    @Test(priority = 2, groups = {"Media Test"})
    public void getMediaByCriteria() throws SQLException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("lien", "<>", "TOTO"));
        List<Media> medias = mediaRepository.getDataByCriteria(criterias, "be");

        Assert.assertNotEquals(medias.size(), 0);

    }

    @Test(priority = 3, groups = {"Media Test"})
    public void getMediaWithFields() throws SQLException, IllegalAccessException, DatabaseException, InvocationTargetException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("originalName", "<>", "TOTO"));

        List<String> fields = new ArrayList<String>() {
            {
                add("id");
                add("originalName");
            }
        };

        List<Media> medias = mediaRepository.getDataByCriteria(criterias, "be", fields);

//        for (Media media : medias) {
//            Assert.assertNotNull(media.getId());
//            Assert.assertNull(media.getOriginalName());
//        }

    }

}
