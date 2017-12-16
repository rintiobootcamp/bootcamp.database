/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
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
    @Column(nullable = false)
    private String contenuGsm;

    @ApiModelProperty(value = "the deails gsm of the the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private String contenuWebApp;

    @ApiModelProperty(value = "the deails gsm of the the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private String contenuMobileApp;

    @ApiModelProperty(value = "the deails gsm of the the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
    private String contenuMail;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String entityType;

    @Column(nullable = false)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int entityId;

    @ApiModelProperty(value = "gives the libelle of the notification")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    @Column(nullable = false)
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

    /**
     * Check if the sms message has been sent
     */
    public boolean isSendSms() {
        return sendSms;
    }

    /**
     *
     * @param sendSms
     */
    public void setSendSms(boolean sendSms) {
        this.sendSms = sendSms;
    }

    /**
     * Check if the mail message has been sent
     */
    public boolean isSendMail() {
        return sendMail;
    }

    /**
     *
     * @param sendMail
     */
    public void setSendMail(boolean sendMail) {
        this.sendMail = sendMail;
    }

    /**
     * Check if the web app message has been sent
     */
    public boolean isSendWebApp() {
        return sendWebApp;
    }

    /**
     *
     * @param sendWebApp
     */
    public void setSendWebApp(boolean sendWebApp) {
        this.sendWebApp = sendWebApp;
    }

    /**
     * Check if the mobil app message has been sent
     */
    public boolean isSendMobil() {
        return sendMobil;
    }

    /**
     *
     * @param sendMobil
     */
    public void setSendMobil(boolean sendMobil) {
        this.sendMobil = sendMobil;
    }

    /**
     * Get the notification message object
     *
     * @return the message object
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Set the notification message object
     *
     * @param libelle the message object to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Get the notification entity type
     *
     * @return the censor entity type
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * Set the notification entity type
     *
     * @param entityType the entity type to set
     */
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    /**
     * Get the notification entity id
     *
     * @return the censor entity id
     */
    public int getEntityId() {
        return entityId;
    }

    /**
     * Set the notification entity id
     *
     * @param entityId the entity id to set
     */
    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    /**
     * Get the notification id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the notification id
     *
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the action that create have the notification
     *
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * Set the action that create have the notification
     *
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Get the notification creation date
     *
     * @return the censor creation date
     */
    public long getDateCreation() {
        return dateCreation;
    }

    /**
     * Set the notification creation date
     *
     * @param dateCreation the date to set
     */
    public void setDateCreation(long dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Get the notification update date
     *
     * @return the censor update date
     */
    public long getDateMiseAJour() {
        return dateMiseAJour;
    }

    /**
     * Set the notification update date
     *
     * @param dateMiseAJour the date to set
     */
    public void setDateMiseAJour(long dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    /**
     * Get the notification message to send by sms
     *
     * @return the message
     */
    public String getContenuGsm() {
        return contenuGsm;
    }

    /**
     * Set the notification message to send by sms
     *
     * @param contenuGsm the message to set
     */
    public void setContenuGsm(String contenuGsm) {
        this.contenuGsm = contenuGsm;
    }

    /**
     * Get the notification message to send to the web app
     *
     * @return the message
     */
    public String getContenuWebApp() {
        return contenuWebApp;
    }

    /**
     * Set the notification message to send to the web app
     *
     * @param contenuWebApp the message to set
     */
    public void setContenuWebApp(String contenuWebApp) {
        this.contenuWebApp = contenuWebApp;
    }

    /**
     * Get the notification message to send to the mobil app
     *
     * @return the message
     */
    public String getContenuMobileApp() {
        return contenuMobileApp;
    }

    /**
     * Get the notification message to send to the mobil app
     *
     * @param contenuMobileApp the message to set
     */
    public void setContenuMobileApp(String contenuMobileApp) {
        this.contenuMobileApp = contenuMobileApp;
    }

    /**
     * Get the notification message to send by mail
     *
     * @return the message
     */
    public String getContenuMail() {
        return contenuMail;
    }

    /**
     * Set the notification message to send by mail
     *
     * @param contenuMail the message to set
     */
    public void setContenuMail(String contenuMail) {
        this.contenuMail = contenuMail;
    }
}
