package Service;

import com.atividade.back.entity.Professor;
import com.atividade.back.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

        @Autowired
        ProfessorRepository professorRepository;

        public String salvarProfessor(Professor professor) {
            professorRepository.save(professor);
            return "O professor foi salvo";
        }

        public List<Professor> listarProfessor() {
            return professorRepository.findAll();
        }
    }
