/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.Objects;

/**
 *
 * @author emerson
 */
public class Cidade {
    private int idCidade;
    private String nome;
    private boolean status;
    
    private Estado estado;
    
    //Construtores

    public Cidade(int idCidade, String nome, boolean status, Estado estado) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.status = status;
        this.estado = estado;
    }
    
    public Cidade() {
        this.idCidade = 0;
        this.nome = "vazio";
        this.status = true;
        this.estado = new Estado();
    }
    
    //Metodos

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idCidade;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + (this.status ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.estado);
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
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "Cidade{" + "idCidade=" + idCidade + ", nome=" + nome + ", status=" + status + ", estado=" + estado + '}';
    }
     
}
