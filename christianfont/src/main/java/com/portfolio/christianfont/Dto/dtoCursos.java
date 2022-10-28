/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.christianfont.Dto;

import javax.validation.constraints.NotBlank;


public class dtoCursos {
    @NotBlank
    private String nombreCu;
    @NotBlank
    private String descripcionCu;  

    public dtoCursos() {
    }

    public dtoCursos(String nombreCu, String descripcionCu) {
        this.nombreCu = nombreCu;
        this.descripcionCu = descripcionCu;
    }

    public String getNombreCu() {
        return nombreCu;
    }

    public void setNombreCu(String nombreCu) {
        this.nombreCu = nombreCu;
    }

    public String getDescripcionCu() {
        return descripcionCu;
    }

    public void setDescripcionCu(String descripcionCu) {
        this.descripcionCu = descripcionCu;
    }
}
