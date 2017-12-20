package com.bootcamp.entities;

import com.bootcamp.commons.annotations.NativeQueryResultColumn;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.ALL;

@Entity
public class PagUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Id of the user", notes = "This id is automatically generated ,it doesn't required")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private int id;

    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "Login of the User")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String username;

    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "Password of the User")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String password;

    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "Email of the User")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String email;

    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "name of the User")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String nom;

    @Column(nullable = false)
    @ApiModelProperty(value = "Creation date of the User", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateCreation;

    @Column(nullable = false)
    @ApiModelProperty(value = "Update date of the User", required = true)
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private long dateMiseAJour;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pagUser")
    //@OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name="pagUser_id")
    private List<UserRole> userRoles = new ArrayList<>();
    
    @Column(nullable = false, length = 1024)
    @ApiModelProperty(value = "Numero of the User")
    @NativeQueryResultColumn(columnType = NativeQueryResultColumn.COLUMNTYPE.SIMPLE)
    private String numero;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
