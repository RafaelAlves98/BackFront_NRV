package com.atividade.back.controller;

import Service.TurmaService;
import com.atividade.back.entity.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")

public class TurmaController {

        @Autowired
        private TurmaService turmaService;

        @PostMapping
        public ResponseEntity<String> criarTurma(@RequestBody Turma turma) {
            try {
                String resultado = turmaService.salvarTurma(turma);
                return ResponseEntity.ok(resultado);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @GetMapping
        public ResponseEntity<List<Turma>> listarTurmas() {
            try {
                return ResponseEntity.ok(turmaService.listarTurmas());
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();
            }
        }

        @PutMapping("/atualizar/{id}")
        public ResponseEntity<String> atualizarTurma(@PathVariable Long id, @RequestBody Turma turma) {
            try {
                String resultado = turmaService.atualizarTurma(id, turma);
                return ResponseEntity.ok(resultado);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }

        @DeleteMapping("/deletar/{id}")
        public ResponseEntity<String> deletarTurma(@PathVariable Long id) {
            try {
                String resultado = turmaService.deletarTurma(id);
                return ResponseEntity.ok(resultado);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
    }

