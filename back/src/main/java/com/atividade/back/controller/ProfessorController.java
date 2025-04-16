package com.atividade.back.controller;

import com.atividade.back.service.ProfessorService;
import com.atividade.back.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

        @Autowired
        private ProfessorService professorService;

        @PostMapping
        public ResponseEntity<String> criarProfessor(@RequestBody Professor professor){
            try{
                String resultado = professorService.salvarProfessor(professor);
                return ResponseEntity.ok(resultado);
            } catch (IllegalArgumentException e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping
        public ResponseEntity<List<Professor>> listarProfessores(){
            try{
                return ResponseEntity.ok(professorService.listarProfessor());
            } catch (IllegalArgumentException e){
                return ResponseEntity.badRequest().build();
            }
        }

    }

