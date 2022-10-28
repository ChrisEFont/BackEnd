/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.christianfont.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreCu;
    private String descripcionCu;

    public Cursos() {
    }

    public Cursos(String nombreCu, String descripcionCu) {
        this.nombreCu = nombreCu;
        this.descripcionCu = descripcionCu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
