package com.miportfolio.CAB.dto;

import javax.validation.constraints.NotBlank;

public class DtoProyectos {

    @NotBlank
    private String nombreProy;
    
    @NotBlank
    private String tipoProy;

    @NotBlank
    private String descripcionProy;

    @NotBlank
    private String urlProy;

    @NotBlank
    private String imgProy;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombreProy, String tipoProy, String descripcionProy, String urlProy, String imgProy) {
        this.nombreProy = nombreProy;
        this.tipoProy = tipoProy;
        this.descripcionProy = descripcionProy;
        this.urlProy = urlProy;
        this.imgProy = imgProy;
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
