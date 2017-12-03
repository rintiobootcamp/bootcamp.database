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
import com.bootcamp.constants.AppConstants;
import com.bootcamp.entities.Media;
import com.bootcamp.repositories.MediaRepository;
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
public class MediaTest {

    private final MediaRepository mediaRepository = new MediaRepository(AppConstants.PERSISTENCE_UNIT);

    @Test(priority = 0, groups = {"Media Test"})
    public void createMedia() throws SQLException, FileNotFoundException, IOException {
        String internalName[] = {"internalName1", "internalName2", "internalName3", "internalName4", "internalName5", "internalName6", "internalName7"};
        for (int i = 0; i < internalName.length; i++) {
            Media media = new Media();
            media.setInternalName(internalName[i]);
            media.setDateCreation(15118908400L);
            media.setDateMiseAJour(1511890840L);
            media.setLien("lien");
            media.setType("tof");
            media.setEntityType(EntityType.PROJET.name());
            media.setOriginalName("origin name");
            media.setEntityId(1);
            mediaRepository.create(media);
        }
        List<Media> medias = mediaRepository.findAll();
        Assert.assertEquals(medias.size(), 7);
    }

    @Test(priority = 1, groups = {"Media Test"})
    public void getMediaByCriteria() throws SQLException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("lien", "<>", "TOTO"));
        List<Media> medias = mediaRepository.getDataByCriteria(criterias, "be");
        Assert.assertNotEquals(medias.size(), 0);
    }

    //@Test(priority = 2, groups = {"Media Test"})
    public void getMediaWithFields() throws SQLException, IllegalAccessException, DatabaseException, InvocationTargetException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("lien", "<>", "TOTO"));
        List<String> fields = new ArrayList<String>() {
            {
                add("id");
                add("lien");
            }
        };
        List<Media> medias = mediaRepository.getDataByCriteria(criterias, "be", fields);
        for (Media media : medias) {
            Assert.assertNotNull(media.getId());
            Assert.assertNull(media.getLien());
        }
    }

}
