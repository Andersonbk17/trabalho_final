/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author emerson
 */
public class Pessoa {
   private int idPessoa;
   private String nome;
   private String rg;
   private String cpf;
   private String naturalidade;
   private String nacionalidade;
   private Date dataNascimento;
   private List<Endereco> endereco;
   private List<Telefone> telefone;
   private List<Email> email;
   private int status;
   
   //Construtores

    public Pessoa(int idPessoa, String nome, String rg, String cpf, String naturalidade, String nacionalidade, Date dataNascimento, List<Endereco> endereco, List<Telefone> telefone, List<Email> email, int status) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.naturalidade = naturalidade;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.status = status;
    }

    public Pessoa() {
        this.idPessoa = 0;
        this.nome = "vazio";
        this.rg = "vazio";
        this.cpf = "vazio";
        this.naturalidade = "vazio";
        this.nacionalidade = "vazio";
        this.dataNascimento = new Date();
        this.endereco = new LinkedList<Endereco>();
        this.telefone = new LinkedList<Telefone>();
        this.email = new LinkedList<Email>();
        this.status = 1;
    }
    
    //Metodos

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public void addEndereco(Endereco e){
        if(!endereco.contains(e)){
            endereco.add(e);
        }  
    }
    
    public void removeEndereco(Endereco e){
        if(endereco.contains(e)){
            endereco.remove(e);
        }
    }
    
    public void addTelefone(Telefone t){
        if(!telefone.contains(t)){
            telefone.add(t);
        }  
    }
    
    public void removeTelefone(Telefone t){
        if(telefone.contains(t)){
            telefone.remove(t);
        }
    }
    
    public void addEmail(Email em){
        if(!email.contains(em)){
            email.add(em);
        }  
    }
    
    public void removeEmail(Email em){
        if(email.contains(em)){
            email.remove(em);
        }
    }
   
    //hashCodes

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idPessoa;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.rg);
        hash = 37 * hash + Objects.hashCode(this.cpf);
        hash = 37 * hash + Objects.hashCode(this.naturalidade);
        hash = 37 * hash + Objects.hashCode(this.nacionalidade);
        hash = 37 * hash + Objects.hashCode(this.dataNascimento);
        hash = 37 * hash + this.status;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.naturalidade, other.naturalidade)) {
            return false;
        }
        if (!Objects.equals(this.nacionalidade, other.nacionalidade)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "Pessoa{" + "idPessoa=" + idPessoa + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", naturalidade=" + naturalidade + ", nacionalidade=" + nacionalidade + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", status=" + status + '}';
    }
    
}
