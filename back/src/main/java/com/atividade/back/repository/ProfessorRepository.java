package com.atividade.back.repository;

import com.atividade.back.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    }

