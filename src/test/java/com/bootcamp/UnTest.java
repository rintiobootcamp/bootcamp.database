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
import org.testng.annotations.Test;

/**
 *
 * @author Bello
 */
public class UnTest {
    
    @Test
    public void unTesttr(){
        UserRepository userRepository = new UserRepository(DatabaseConstants.PERSISTENCE_UNIT);
        
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("id", "=", 2));
        PagUser user = userRepository.getDataByCriteria(criterias).get(0);
        
//        Criterias crits = new Criterias();
//        PagUser user = userHelper.readUser(2);
        
        System.out.println(user.getUserRoles().size());
        //List<RoleWs> roles = new ArrayList<RoleWs>();
        //List<UserRole> userRoles = user.getUserRoles();
        //System.out.println(user.getUserRoles().size());
        
//        for (UserRole userRole : userRoles) {
//            PagRole role = userRole.getPagRole();
//            roles.add(userHelper.buildRoleWs(role));
//        }
    }
}
