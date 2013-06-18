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
   private int cpf;
   private String naturalidade;
   private Date dataNascimento;
   private String orgaoExpeditor;
   private Date dataExpedicao;
   private boolean status;
    
   private List<Endereco> endereco;
   private List<Telefone> telefone;
   private List<Email> email;
   private Estado estado;
   private Campus campus;
   private Nacionalidade nacionalidade;
   private CursoArea cursoArea;
   
   
   
  
   
   //Construtores

  

    public Pessoa(int idPessoa, String nome, String rg, int cpf, String naturalidade, Date dataNascimento, String orgaoExpeditor, Date dataExpedicao, boolean status, List<Endereco> endereco, List<Telefone> telefone, List<Email> email, Estado estado, Campus campus, Nacionalidade nacionalidade, CursoArea cursoArea) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.naturalidade = naturalidade;
        this.dataNascimento = dataNascimento;
        this.orgaoExpeditor = orgaoExpeditor;
        this.dataExpedicao = dataExpedicao;
        this.status = status;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.estado = estado;
        this.campus = campus;
        this.nacionalidade = nacionalidade;
        this.cursoArea = cursoArea;
    }

  

    public Pessoa() {
        this.idPessoa = 0;
        this.nome = "vazio";
        this.rg = "vazio";
        this.cpf = 0;
        this.naturalidade = "vazio";
        this.dataNascimento = new Date();
        this.endereco = new LinkedList<Endereco>();
        this.telefone = new LinkedList<Telefone>();
        this.email = new LinkedList<Email>();
        this.status = true;
        this.estado = new Estado();
        this.orgaoExpeditor = "vazio";
        this.dataExpedicao = new Date();
        this.campus = new Campus();
        this.nacionalidade = new Nacionalidade();
        this.cursoArea = new CursoArea();
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getOrgaoExpeditor() {
        return orgaoExpeditor;
    }

    public void setOrgaoExpeditor(String orgaoExpeditor) {
        this.orgaoExpeditor = orgaoExpeditor;
    }

    public Date getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(Date dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Nacionalidade nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public CursoArea getCursoArea() {
        return cursoArea;
    }

    public void setCursoArea(CursoArea cursoArea) {
        this.cursoArea = cursoArea;
    }
    
    
   
    
    //hashCodes

  

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.idPessoa;
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.rg);
        hash = 79 * hash + this.cpf;
        hash = 79 * hash + Objects.hashCode(this.naturalidade);
        hash = 79 * hash + Objects.hashCode(this.dataNascimento);
        hash = 79 * hash + (this.status ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.nacionalidade);
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
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        if (!Objects.equals(this.naturalidade, other.naturalidade)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.nacionalidade, other.nacionalidade)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", naturalidade=" + naturalidade + ", dataNascimento=" + dataNascimento + ", orgaoExpeditor=" + orgaoExpeditor + ", dataExpedicao=" + dataExpedicao + ", status=" + status + ", campus=" + campus + '}';
    }

    
    
}
