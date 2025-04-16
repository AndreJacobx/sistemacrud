package com.example.crud.controller;
import com.example.crud.dto.TrabalhoDTO;
import com.example.crud.model.Trabalho;
import com.example.crud.service.TrabalhoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {
    private final TrabalhoService service;

    public TrabalhoController(TrabalhoService service) {
        this.service = service;
    }

    @PostMapping
    public Trabalho create(@RequestBody TrabalhoDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Trabalho> list() {
        return service.list();
    }

    @PutMapping("/{id}")
    public Trabalho update(@PathVariable Long id, @RequestBody TrabalhoDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
