package com.miportfolio.CAB.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "Introdicir entre 1 y 50 caracteres")
    private String nombreEdu;

    @NotNull
    @Size(min = 1, max = 50, message = "Introdicir entre 1 y 50 caracteres")
    private String lugarEdu;

    @NotNull
    @Size(min = 1, max = 50, message = "Introdicir entre 1 y 50 caracteres")
    private String fechaEdu;

    @NotNull
    @Size(min = 1, max = 500, message = "Introdicir entre 1 y 50 caracteres")
    private String descripcionEdu;


    @Size(min = 1, max = 50, message = "Introdicir entre 1 y 50 caracteres")
    private String imgEdu;

    public Educacion() {
    }

    public Educacion(String nombreEdu, String lugarEdu, String fechaEdu, String descripcionEdu, String imgEdu) {
        this.nombreEdu = nombreEdu;
        this.lugarEdu = lugarEdu;
        this.fechaEdu = fechaEdu;
        this.descripcionEdu = descripcionEdu;
        this.imgEdu = imgEdu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getLugarEdu() {
        return lugarEdu;
    }

    public void setLugarEdu(String lugarEdu) {
        this.lugarEdu = lugarEdu;
    }

    public String getFechaEdu() {
        return fechaEdu;
    }

    public void setFechaEdu(String fechaEdu) {
        this.fechaEdu = fechaEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getImgEdu() {
        return imgEdu;
    }

    public void setImgEdu(String imgEdu) {
        this.imgEdu = imgEdu;
    }

}
