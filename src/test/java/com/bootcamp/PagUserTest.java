package com.bootcamp;

import com.bootcamp.commons.models.Criteria;
import com.bootcamp.commons.models.Criterias;
import com.bootcamp.constants.AppConstants;
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

    private final UserRepository userRepository = new UserRepository(AppConstants.PERSISTENCE_UNIT);
    private final PagRoleRepository roleRepository = new PagRoleRepository(AppConstants.PERSISTENCE_UNIT);
    private final UserRoleRepository userPagRoleRepository = new UserRoleRepository(AppConstants.PERSISTENCE_UNIT);

    @Test(priority = 0, groups = {"User Test"})
    public void namageUser() throws Exception {

        PagUser pagUser = new PagUser();
        pagUser.setNom("TOSSA Gildas");
        pagUser.setUsername("username");
        pagUser.setEmail("email");
        pagUser.setPassword("password");
        userRepository.create(pagUser);

        Assert.assertNotNull(pagUser.getId());

        PagRole role = new PagRole();
        role.setName("admin");
        roleRepository.create(role);

        Assert.assertNotNull(role.getId());

        UserRole userRole = new UserRole();
        userRole.setPagRole(role);
        userRole.setPagUser(pagUser);
        userPagRoleRepository.create(userRole);

        Assert.assertNotNull(userRole.getId());
    }

    @Test(priority = 1, groups = {"User Test"})
    public void getUserRole() {
        Criterias criterias = new Criterias();
        criterias.addCriteria(new Criteria("id", "=", 1));
        PagUser pagUser = userRepository.getDataByCriteria(criterias).get(0);

        Assert.assertEquals(pagUser.getUsername(), "username");

        System.out.println(pagUser.getUserRoles());
    }
}
