package br.glacks.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Usuario{
    
    @NotBlank(message = "O campo 'nome' nao pode ser vazio (2 - 50 caracteres)")
    @Size(min = 2, max = 50)
    private String nome;

    @CPF
    private String cpf; 
    
    @Column(name ="data_nascimento")
    private String dataNascimento;
    
    private String sobrenome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    
}