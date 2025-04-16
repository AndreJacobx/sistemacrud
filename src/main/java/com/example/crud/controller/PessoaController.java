package com.example.crud.controller;
import com.example.crud.dto.PessoaDTO;
import com.example.crud.model.Pessoa;
import com.example.crud.service.PessoaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public Pessoa create(@RequestBody PessoaDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Pessoa> list() {
        return service.list();
    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable Long id, @RequestBody PessoaDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
