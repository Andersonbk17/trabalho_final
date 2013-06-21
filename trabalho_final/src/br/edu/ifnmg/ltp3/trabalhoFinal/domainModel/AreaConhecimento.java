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
public class AreaConhecimento {
    private int idAreaConhecimento;
    private String nome;
    private boolean status;
    
    //Construtores

    public AreaConhecimento(int AreaConhecimento, String nome, boolean status) {
        this.idAreaConhecimento = AreaConhecimento;
        this.nome = nome;
        this.status = status;
    }
    
    public AreaConhecimento() {
        this.idAreaConhecimento = 0;
        this.nome = "vazio";
        this.status = true;
    }

    //Metodos
    
    public int getAreaConhecimento() {
        return idAreaConhecimento;
    }

    public void setAreaConhecimento(int AreaConhecimento) {
        this.idAreaConhecimento = AreaConhecimento;
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
    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idAreaConhecimento;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + (this.status ? 1 : 0);
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
        final AreaConhecimento other = (AreaConhecimento) obj;
        if (this.idAreaConhecimento != other.idAreaConhecimento) {
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
        return "AreaConhecimento{" + "AreaConhecimento=" + idAreaConhecimento + ", nome=" + nome + ", status=" + status + '}';
    } 
    
}
