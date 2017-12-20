package com.bootcamp;

import com.bootcamp.commons.constants.DatabaseConstants;
import com.bootcamp.commons.models.Criteria;
import com.bootcamp.commons.models.Criterias;
import com.bootcamp.entities.PagRole;
import com.bootcamp.entities.PagUser;
import com.bootcamp.entities.UserRole;
import com.bootcamp.repositories.PagRoleRepository;
import com.bootcamp.repositories.UserRepository;
import com.bootcamp.repositories.UserRoleRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by darextossa on 12/16/17.
 */
public class PagUserTest {

    private final UserRepository userRepository = new UserRepository(DatabaseConstants.PERSISTENCE_UNIT);
    private final PagRoleRepository roleRepository = new PagRoleRepository(DatabaseConstants.PERSISTENCE_UNIT);
    private final UserRoleRepository userPagRoleRepository = new UserRoleRepository(DatabaseConstants.PERSISTENCE_UNIT);
    private int userId = 0;

    @Test(priority = 0, groups = {"User Test"})
    public void namageUser() throws Exception {

        PagUser pagUser = new PagUser();
        pagUser.setNom("BELLO Mouhoutassim");
        pagUser.setUsername("Baom");
        pagUser.setEmail("mboabello@yahoo.fr");
        pagUser.setNumero("94759067");
        pagUser.setPassword("cacapa");
        userRepository.create(pagUser);
        userId = pagUser.getId();

        Assert.assertNotNull(pagUser.getId());

        PagRole role = new PagRole();
        role.setName("admin");
        roleRepository.create(role);

        Assert.assertNotNull(role.getId());

        UserRole userRole = new UserRole();
        userRole.setPagRole(role);
        userRole.setPagUser(pagUser);
        userPagRoleRepository.create(userRole);
        
        //userId = userRole.getId();

        Assert.assertNotNull(userId);
    }

    @Test(priority = 1, groups = {"User Test"})
    public void getUserRole() {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("id", "=", 1));
        PagUser pagUser = userRepository.getDataByCriteria(criterias).get(0);

        Assert.assertEquals(pagUser.getUsername(), "Baom");

        System.out.println(pagUser.getUserRoles().size());
    }
}
