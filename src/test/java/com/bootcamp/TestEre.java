/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp;

import com.bootcamp.commons.constants.DatabaseConstants;
import com.bootcamp.commons.models.Criteria;
import com.bootcamp.commons.models.Criterias;
import com.bootcamp.entities.PagUser;
import com.bootcamp.repositories.UserRepository;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Bello
 */
public class TestEre {
    private final UserRepository userRepository = new UserRepository(DatabaseConstants.PERSISTENCE_UNIT);
    
    @Test(priority = 1, groups = {"User Test"})
    public void deleteUser() {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("id", "=", 1));
        PagUser pagUser = userRepository.getDataByCriteria(criterias).get(0);
        try {
            userRepository.delete(pagUser);
            System.out.println(pagUser);
        } catch (SQLException ex) {
            Logger.getLogger(TestEre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
