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
public class Estado {
    private int idEstado;
    private String nome;
    private String uf;
    private boolean status;
    
    //Construtores

    public Estado(int idEstado, String nome, boolean status,String uf) {
        this.idEstado = idEstado;
        this.nome = nome;
        this.status = status;
        this.uf = uf;
    }
    
    public Estado() {
        this.idEstado = 0;
        this.nome = "vazio";
        this.status = true;
        this.uf = "vazio";
    }
    
    //Metodos

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
    
    //Hashcodes

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.idEstado;
        hash = 61 * hash + Objects.hashCode(this.nome);
        hash = 61 * hash + (this.status ? 1 : 0);
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
        final Estado other = (Estado) obj;
        if (this.idEstado != other.idEstado) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
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
        return nome;
    }

    
}
