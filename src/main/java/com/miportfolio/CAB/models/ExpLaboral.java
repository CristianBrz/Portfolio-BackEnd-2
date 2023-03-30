package com.miportfolio.CAB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ExpLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "Introdicir entre 1 y 50 caracteres")
    private String nombreExp;

    @NotNull
    @Size(min = 1, max = 50, message = "Introdicir entre 1 y 50 caracteres")
    private String lugarExp;

    @NotNull
    @Size(min = 1, max = 50, message = "Introdicir entre 1 y 50 caracteres")
    private String fechaExp;
    
     @NotNull
    @Size(min = 1, message = "Introdicir entre 1 y 50 caracteres")
    private String descripcionExp;
     
    private String imgExp;

    public ExpLaboral() {
    }

    public ExpLaboral(String nombreExp, String lugarExp, String fechaExp, String descripcionExp, String imgExp) {
        this.nombreExp = nombreExp;
        this.lugarExp = lugarExp;
        this.fechaExp = fechaExp;
        this.descripcionExp = descripcionExp;
        this.imgExp = imgExp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getLugarExp() {
        return lugarExp;
    }

    public void setLugarExp(String lugarExp) {
        this.lugarExp = lugarExp;
    }

    public String getFechaExp() {
        return fechaExp;
    }

    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }

    public String getDescripcionExp() {
        return descripcionExp;
    }

    public void setDescripcionExp(String descripcionExp) {
        this.descripcionExp = descripcionExp;
    }

    public String getImgExp() {
        return imgExp;
    }

    public void setImgExp(String imgExp) {
        this.imgExp = imgExp;
    }

}
