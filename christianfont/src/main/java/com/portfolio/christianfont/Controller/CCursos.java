/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.christianfont.Controller;

import com.portfolio.christianfont.Dto.dtoCursos;
import com.portfolio.christianfont.Entity.Cursos;
import com.portfolio.christianfont.Security.Controller.Mensaje;
import com.portfolio.christianfont.Service.SCursos;
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
@RequestMapping("/curs&cert")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://christianfont-2022.web.app")

public class CCursos {
    @Autowired
    SCursos sCurso;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Cursos>> list (){
    List<Cursos> list = sCurso.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Cursos> getById(@PathVariable("id") int id){
        if(!sCurso.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Cursos curso = sCurso.getOne(id).get();
        return new ResponseEntity(curso, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!sCurso.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sCurso.delete(id);
        return new ResponseEntity (new Mensaje ("Curso eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoCursos dtocurso){
        if (StringUtils.isBlank(dtocurso.getNombreCu())){
            return new ResponseEntity (new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);            
        }
        if (sCurso.existsByNombreCu(dtocurso.getNombreCu())){
            return new ResponseEntity(new Mensaje("Ese nombre ya esxiste"), HttpStatus.BAD_REQUEST);
        }
        
        Cursos curso = new Cursos(
                dtocurso.getNombreCu(), dtocurso.getDescripcionCu()
        );
        sCurso.save(curso);
        return new ResponseEntity(new Mensaje("Curso / Certificació creada"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody dtoCursos dtocurso){
        if(!sCurso.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);            
        }
        if(sCurso.existsByNombreCu(dtocurso.getNombreCu()) && sCurso.getByNombre(dtocurso.getNombreCu()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"),HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtocurso.getNombreCu())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacío"), HttpStatus.BAD_REQUEST);
        }
        
        Cursos curso = sCurso.getOne(id).get();
        curso.setNombreCu(dtocurso.getNombreCu());
        curso.setDescripcionCu(dtocurso.getDescripcionCu());
        
        sCurso.save(curso);
        
        return new ResponseEntity(new Mensaje("Curso / certificación actualizada"), HttpStatus.OK);
    }
}
