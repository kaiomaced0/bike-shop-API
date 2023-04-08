package br.glacks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Size;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class PessoaFisica extends Usuario{
    
    @Size(min = 11, max = 11)
    private String cpf; 
    
    @Column(name ="data_nascimento")
    private String dataNascimento;

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