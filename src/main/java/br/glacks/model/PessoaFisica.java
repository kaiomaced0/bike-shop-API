package br.glacks.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Usuario{
    
    @Size(min = 11, max = 11)
    private String cpf; 
    
    @Column(name ="data_nascimento")
    private String dataNascimento;
    
    private String sobrenome;


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