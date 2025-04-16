package com.atividade.back.service;

import com.atividade.back.entity.Atividade;
import com.atividade.back.repository.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public String salvarAtividade(Atividade atividade) {
        if (atividade.getTurma() == null || atividade.getTurma().getId() == null) {
            throw new IllegalArgumentException("A atividade deve estar associada a uma turma válida");
        }
        atividadeRepository.save(atividade);
        return "Atividade cadastrada com sucesso";
    }

    public List<Atividade> listarAtividades() {
        return atividadeRepository.findAll();
    }

    public String atualizarAtividade(Long id, Atividade atividade) {
        if (atividadeRepository.existsById(id)) {
            Atividade atividadeExistente = atividadeRepository.findById(id).get();
            atividadeExistente.setNome(atividade.getNome());
            atividadeExistente.setDescricao(atividade.getDescricao());
            atividadeExistente.setTurma(atividade.getTurma());
            atividadeRepository.save(atividadeExistente);
            return "Atividade atualizada com sucesso";
        }
        throw new IllegalArgumentException("Atividade não encontrada");
    }

    public String deletarAtividade(Long id) {
        if (atividadeRepository.existsById(id)) {
            atividadeRepository.deleteById(id);
            return "Atividade deletada com sucesso";
        }
        throw new IllegalArgumentException("Atividade não encontrada");
    }
}