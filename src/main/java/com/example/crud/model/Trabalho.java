package com.example.crud.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Trabalho {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;

    @OneToMany(mappedBy = "trabalho")
    private List<Pessoa> pessoas;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public List<Pessoa> getPessoas() { return pessoas; }
    public void setPessoas(List<Pessoa> pessoas) { this.pessoas = pessoas; }
}