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
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSk;
    private String descripcionSk;

    public Skills() {
    }

    public Skills(String nombreSk, String descripcionSk) {
        this.nombreSk = nombreSk;
        this.descripcionSk = descripcionSk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
