/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.repositories;


import com.bootcamp.entities.Impact;
import com.bootcamp.entities.Notification;

/**
 *
 * @author Moh
 */
public class NotificationRepository extends BaseRepository<Notification>{
    public NotificationRepository(String unitPersistence) {
        super(unitPersistence, Notification.class);
    }    
}
