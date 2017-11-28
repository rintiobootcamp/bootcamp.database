package com.bootcamp.entities;

import io.swagger.annotations.*;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;
/**
 *
 * @author Iso-Doss
 */
@Entity
@ApiModel(value = "Axe", description = "Description of axe service")
public class Axe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 255)
    @ApiModelProperty(value = "name of Axe", required = true)
    private String name;
    
    @Column(nullable = false, length = 255)
    @ApiModelProperty(value = "description of Axe", required = true)
    private String description;
    
    @ApiModelProperty(value = "creation date of Axe")
    private Timestamp createAt;
    
    @ApiModelProperty(value = "update date of Axe")
    private Timestamp updateAt;
    
    @Column(nullable = false)
    @ApiModelProperty(value = "focus of Axe", required = true)
    private String focus;
    
    @OneToMany
    @ApiModelProperty(value = "list of sectors of Axe", required = true)
    private List<Secteur> listSecteurs;
    
    @ApiModelProperty(value = "list of medias of Axe", required = true)
    private List<Integer> listMedias;
    
    @ApiModelProperty(value = "list of comments of Axe", required = true)
    private List<Integer> listComments;
    
    @ManyToOne
    @ApiModelProperty(value = "The pilier of Axe", required = true)
    @JoinColumn(name = "pilier", referencedColumnName = "id", insertable = false, updatable = false)
    Pilier pilier;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "com.bootcamp.database.entities.Axe[ id=" + id + " ]";
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the createAt
     */
    public Timestamp getCreateAt() {
        return createAt;
    }
    /**
     * @param createAt the createAt to set
     */
    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }
    /**
     * @return the updateAt
     */
    public Timestamp getUpdateAt() {
        return updateAt;
    }
    /**
     * @param updateAt the updateAt to set
     */
    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
    /**
     * @return the focus
     */
    public String getFocus() {
        return focus;
    }
    /**
     * @param focus the focus to set
     */
    public void setFocus(String focus) {
        this.focus = focus;
    }
    
    /**
     * @return the listMedias
     */
    public List<Integer> getListMedias() {
        return listMedias;
    }
    /**
     * @param listMedias the listMedias to set
     */
    public void setListMedias(List<Integer> listMedias) {
        this.listMedias = listMedias;
    }
    /**
     * @return the listComments
     */
    public List<Integer> getListComments() {
        return listComments;
    }
    /**
     * @param listComments the listComments to set
     */
    public void setListComments(List<Integer> listComments) {
        this.listComments = listComments;
    }
    
    public Pilier getPilier() {
        return pilier;
    }
    
    public void setPilier(Pilier pilier) {
        this.pilier = pilier;
    }

    /**
     * @return the listSecteurs
     */
    public List<Secteur> getListSecteurs() {
        return listSecteurs;
    }

    /**
     * @param listSecteurs the listSecteurs to set
     */
    public void setListSecteurs(List<Secteur> listSecteurs) {
        this.listSecteurs = listSecteurs;
    }
    
}