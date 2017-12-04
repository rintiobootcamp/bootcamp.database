package com.bootcamp;

import com.bootcamp.commons.enums.EntityType;
import com.bootcamp.commons.models.Criteria;
import com.bootcamp.commons.models.Criterias;
import com.bootcamp.constants.AppConstants;
import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.util.Properties;

/**
 * Created by darextossa on 9/22/17.
 */


public class GenerateTableTest {

    @Test
    public void generateTables(){
        Persistence.generateSchema(AppConstants.PERSISTENCE_UNIT, new Properties());
//        Criterias criterias = new Criterias();
//        long k = 3;
//        Criteria c1 = new Criteria("entityId", "=", k,"AND");
//        //System.out.println(c1.getLinkOperator());
//        Criteria c2 = new Criteria("entityType", "=", EntityType.PROJET);
//        
//        //System.out.println(c1.getAsStringQuery("b"));
//        //System.out.println(c2.getAsStringQuery("b"));
//        criterias.addCriteria(c1);
//        criterias.addCriteria(c2);
//        System.out.println(criterias.getAsStringQuery("b"));
        
    }
}
