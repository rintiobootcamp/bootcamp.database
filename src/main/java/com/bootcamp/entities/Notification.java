/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import com.bootcamp.commons.enums.EntityType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Moh
 */
@Entity
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Column(nullable = false)
    @ApiModelProperty(value = "gives the action trigger of the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String action;

    @ApiModelProperty(value = "creation date of the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateCreation;

    @ApiModelProperty(value = "update date of the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private long dateMiseAJour;


    @ApiModelProperty(value = "the deails gsm of the the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String contenuGsm;

    @ApiModelProperty(value = "the deails gsm of the the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String contenuWebApp;


    @ApiModelProperty(value = "the deails gsm of the the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String contenuMobileApp;


    @ApiModelProperty(value = "the deails gsm of the the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String contenuMail;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String entityType;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int entityId;


    @ApiModelProperty(value = "gives the libelle of the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String libelle;


    @ApiModelProperty(value = "verifie if sms is send")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private boolean sendSms;


    @ApiModelProperty(value = "verifie if mail is send")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private boolean sendMail;

    @ApiModelProperty(value = "verifie if webApp; is send")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private boolean sendWebApp;

    @ApiModelProperty(value = "verifie if Mobil is send")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private boolean sendMobil;

    public boolean isSendSms() {
        return sendSms;
    }

    public void setSendSms(boolean sendSms) {
        this.sendSms = sendSms;
    }

    public boolean isSendMail() {
        return sendMail;
    }

    public void setSendMail(boolean sendMail) {
        this.sendMail = sendMail;
    }

    public boolean isSendWebApp() {
        return sendWebApp;
    }

    public void setSendWebApp(boolean sendWebApp) {
        this.sendWebApp = sendWebApp;
    }

    public boolean isSendMobil() {
        return sendMobil;
    }

    public void setSendMobil(boolean sendMobil) {
        this.sendMobil = sendMobil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    public String getContenuGsm() {
        return contenuGsm;
    }

    public void setContenuGsm(String contenuGsm) {
        this.contenuGsm = contenuGsm;
    }

    public String getContenuWebApp() {
        return contenuWebApp;
    }

    public void setContenuWebApp(String contenuWebApp) {
        this.contenuWebApp = contenuWebApp;
    }

    public String getContenuMobileApp() {
        return contenuMobileApp;
    }

    public void setContenuMobileApp(String contenuMobileApp) {
        this.contenuMobileApp = contenuMobileApp;
    }

    public String getContenuMail() {
        return contenuMail;
    }

    public void setContenuMail(String contenuMail) {
        this.contenuMail = contenuMail;
    }
}
