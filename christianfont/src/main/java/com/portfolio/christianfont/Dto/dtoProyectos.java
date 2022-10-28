/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.christianfont.Dto;

import javax.validation.constraints.NotBlank;


public class dtoProyectos {
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String descripcionPro;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombrePro, String descripcionPro) {
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }
    
    
}
