/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.christianfont.Controller;

import com.portfolio.christianfont.Dto.dtoSkills;
import com.portfolio.christianfont.Entity.Skills;
import com.portfolio.christianfont.Security.Controller.Mensaje;
import com.portfolio.christianfont.Service.SSkills;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://christianfont-2022.web.app")
public class CSkills {
    @Autowired
    SSkills sSkills;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list (){
    List<Skills> list = sSkills.list();
    return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = sSkills.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sSkills.delete(id);
        return new ResponseEntity (new Mensaje ("Habilidad eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkills dtoskills){
        if (StringUtils.isBlank(dtoskills.getNombreSk())){
            return new ResponseEntity (new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);            
        }
        if (sSkills.existsByNombreE(dtoskills.getNombreSk())){
            return new ResponseEntity(new Mensaje("Ese nombre ya esxiste"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = new Skills(
                dtoskills.getNombreSk(), dtoskills.getDescripcionSk()
        );
        sSkills.save(skills);
        return new ResponseEntity(new Mensaje("Habilidad creada"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoSkills dtoskills){
        if(!sSkills.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);            
        }
        if(sSkills.existsByNombreE(dtoskills.getNombreSk()) && sSkills.getByNombre(dtoskills.getNombreSk()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoskills.getNombreSk())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = sSkills.getOne(id).get();
        skills.setNombreSk(dtoskills.getNombreSk());
        skills.setDescripcionSk(dtoskills.getDescripcionSk());
        
        sSkills.save(skills);
        
        return new ResponseEntity(new Mensaje("Habilidad actualizada"), HttpStatus.OK);
    }
    
}
