package com.example.crud.service;
import com.example.crud.dto.TrabalhoDTO;
import com.example.crud.model.Trabalho;
import com.example.crud.repository.TrabalhoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrabalhoService {
    private final TrabalhoRepository trabalhoRepo;

    public TrabalhoService(TrabalhoRepository trabalhoRepo) {
        this.trabalhoRepo = trabalhoRepo;
    }

    public Trabalho create(TrabalhoDTO dto) {
        Trabalho t = new Trabalho();
        t.setNome(dto.nome);
        t.setEndereco(dto.endereco);
        return trabalhoRepo.save(t);
    }

    public List<Trabalho> list() {
        return trabalhoRepo.findAll();
    }

    public Trabalho update(Long id, TrabalhoDTO dto) {
        Trabalho t = trabalhoRepo.findById(id).orElse(null);
        if (t != null) {
            t.setNome(dto.nome);
            t.setEndereco(dto.endereco);
            return trabalhoRepo.save(t);
        }
        return null;
    }

    public void delete(Long id) {
        trabalhoRepo.deleteById(id);
    }
}
