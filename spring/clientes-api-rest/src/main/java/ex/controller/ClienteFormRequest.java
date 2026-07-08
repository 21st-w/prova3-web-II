package ex.controller;

import ex.model.Cliente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ClienteFormRequest {

    private Long id;
    private String nome;
    private String nascimento; // in EJS we get strings (YYYY-MM-DD from <input type="date">)
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;

    public ClienteFormRequest() {}

    public Cliente toModel() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        if (this.nascimento != null && !this.nascimento.isEmpty()) {
            cliente.setNascimento(LocalDate.parse(this.nascimento, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        cliente.setCpf(this.cpf);
        cliente.setEndereco(this.endereco);
        cliente.setTelefone(this.telefone);
        cliente.setEmail(this.email);
        return cliente;
    }

    public static ClienteFormRequest fromModel(Cliente cliente) {
        ClienteFormRequest dto = new ClienteFormRequest();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        if (cliente.getNascimento() != null) {
            dto.setNascimento(cliente.getNascimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        dto.setCpf(cliente.getCpf());
        dto.setEndereco(cliente.getEndereco());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        return dto;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
