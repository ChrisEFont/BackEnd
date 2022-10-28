/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.christianfont.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkills {
    @NotBlank
    private String nombreSk;
    @NotBlank
    private String descripcionSk;

    public dtoSkills() {
    }

    public dtoSkills(String nombreSk, String descripcionSk) {
        this.nombreSk = nombreSk;
        this.descripcionSk = descripcionSk;
    }

    public String getNombreSk() {
        return nombreSk;
    }

    public void setNombreSk(String nombreSk) {
        this.nombreSk = nombreSk;
    }

    public String getDescripcionSk() {
        return descripcionSk;
    }

    public void setDescripcionSk(String descripcionSk) {
        this.descripcionSk = descripcionSk;
    }

    
}
