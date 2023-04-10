package com.miportfolio.CAB.dto;

import javax.validation.constraints.NotBlank;

public class DtoSkills {

    @NotBlank
    private String nombreSkill;

    @NotBlank
    private int progreso;

    @NotBlank
    private String imgSkill;
    
    public DtoSkills() {
    }

    public DtoSkills(String nombreSkill, int progreso, String imgSkill) {
        this.nombreSkill = nombreSkill;
        this.progreso = progreso;
        this.imgSkill = imgSkill;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    public String getImgSkill() {
        return imgSkill;
    }

    public void setImgSkill(String imgSkill) {
        this.imgSkill = imgSkill;
    }

    
}
