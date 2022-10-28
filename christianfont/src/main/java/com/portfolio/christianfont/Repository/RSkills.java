/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.christianfont.Repository;

import com.portfolio.christianfont.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RSkills extends JpaRepository<Skills, Integer> {
    public Optional<Skills> findByNombreSk(String nombreSk);
    public boolean existsByNombreSk(String nombreSk);    
}
