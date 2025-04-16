package com.example.crud.model;

import jakarta.persistence.*;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "trabalho_id")
    private Trabalho trabalho;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public Trabalho getTrabalho() { return trabalho; }
    public void setTrabalho(Trabalho trabalho) { this.trabalho = trabalho; }
}
