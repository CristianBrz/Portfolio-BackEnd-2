package com.miportfolio.CAB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Introdicir entre 1 y 50 caracteres")
    private String nombreProy;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Introdicir entre 1 y 50 caracteres")
    private String tipoProy;
    
    @NotNull
    @Size(min = 1, max = 500, message = "Introdicir entre 1 y 50 caracteres")
    private String descripcionProy;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Introdicir entre 1 y 50 caracteres")
    private String urlProy;
    
    @NotNull
    private String imgProy;

    public Proyectos() {
    }

    public Proyectos(String nombreProy, String tipoProy, String descripcionProy, String urlProy, String imgProy) {
        this.nombreProy = nombreProy;
        this.tipoProy = tipoProy;
        this.descripcionProy = descripcionProy;
        this.urlProy = urlProy;
        this.imgProy = imgProy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public String getTipoProy() {
        return tipoProy;
    }

    public void setTipoProy(String tipoProy) {
        this.tipoProy = tipoProy;
    }

    public String getDescripcionProy() {
        return descripcionProy;
    }

    public void setDescripcionProy(String descripcionProy) {
        this.descripcionProy = descripcionProy;
    }

    public String getUrlProy() {
        return urlProy;
    }

    public void setUrlProy(String urlProy) {
        this.urlProy = urlProy;
    }

    public String getImgProy() {
        return imgProy;
    }

    public void setImgProy(String imgProy) {
        this.imgProy = imgProy;
    }

}
