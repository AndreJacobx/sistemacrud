package com.example.crud.service;
import com.example.crud.dto.PessoaDTO;
import com.example.crud.model.Pessoa;
import com.example.crud.model.Trabalho;
import com.example.crud.repository.PessoaRepository;
import com.example.crud.repository.TrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepo;
    private final TrabalhoRepository trabalhoRepo;

    public PessoaService(PessoaRepository pessoaRepo, TrabalhoRepository trabalhoRepo) {
        this.pessoaRepo = pessoaRepo;
        this.trabalhoRepo = trabalhoRepo;
    }

    public Pessoa create(PessoaDTO dto) {
        Pessoa p = new Pessoa();
        p.setCpf(dto.cpf);
        p.setIdade(dto.idade);
        Trabalho t = trabalhoRepo.findById(dto.trabalhoId).orElse(null);
        p.setTrabalho(t);
        return pessoaRepo.save(p);
    }

    public List<Pessoa> list() {
        return pessoaRepo.findAll();
    }

    public Pessoa update(Long id, PessoaDTO dto) {
        Pessoa p = pessoaRepo.findById(id).orElse(null);
        if (p != null) {
            p.setCpf(dto.cpf);
            p.setIdade(dto.idade);
            Trabalho t = trabalhoRepo.findById(dto.trabalhoId).orElse(null);
            p.setTrabalho(t);
            return pessoaRepo.save(p);
        }
        return null;
    }

    public void delete(Long id) {
        pessoaRepo.deleteById(id);
    }
}
