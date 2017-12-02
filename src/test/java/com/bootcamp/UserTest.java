/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.commons.exceptions.DatabaseException;
import com.bootcamp.commons.utils.GsonUtils;
import com.bootcamp.commons.models.*;
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
public class UserTest {

    private final UserRepository userRepository = new UserRepository(AppConstants.PERSISTENCE_UNIT);

    //@Test
    public void createUser() throws SQLException, FileNotFoundException, IOException {
        String nom[] = {"User User 1", "User User 2", "User User 3", "User User 4", "User User 5", "User User 6", "User User 7"};

        for (int i = 0; i < nom.length; i++) {
            User user = new User();
            user.setNom(nom[i]);
            user.setDateCreation(15118908400L);
            user.setDateMiseAJour(15118908400L);
            user.setLogin("login");
            user.setPassword("login");
            userRepository.create(user);
        }

        List<User> users = userRepository.findAll();
        //Assert.assertEquals(users.size(), 7);
    }

    //@Test(priority = 2, groups = {"User Test"})
    public void getUserByCriteria() throws SQLException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));
        List<User> users = userRepository.getDataByCriteria(criterias, "be");

        Assert.assertNotEquals(users.size(), 0);

    }

    //@Test(priority = 3, groups = {"User Test"})
    public void getUserWithFields() throws SQLException, IllegalAccessException, DatabaseException, InvocationTargetException {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("nom", "<>", "TOTO"));

        List<String> fields = new ArrayList<String>() {
            {
                add("id");
                add("nom");
            }
        };

//        List<User> users = userRepository.getDataByCriteria(criterias, "be", fields);
//
//        for (User user : users) {
//            Assert.assertNotNull(user.getId());
//            Assert.assertNull(user.getNom());
//        }
    }

}
