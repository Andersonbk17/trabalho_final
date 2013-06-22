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
   
    
    //Construtores

    public AreaConhecimento(int AreaConhecimento, String nome) {
        this.idAreaConhecimento = AreaConhecimento;
        this.nome = nome;
       
    }
    
    public AreaConhecimento() {
        this.idAreaConhecimento = 0;
        this.nome = "vazio";
    }

    //Metodos
    
    public int getIdAreaConhecimento() {
        return idAreaConhecimento;
    }

    public void setIdAreaConhecimento(int AreaConhecimento) {
        this.idAreaConhecimento = AreaConhecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //HashCodes

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idAreaConhecimento;
        hash = 97 * hash + Objects.hashCode(this.nome);
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
        
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "AreaConhecimento{" + "idAreaConhecimento=" + idAreaConhecimento + ", nome=" + nome + '}';
    }

    
    
}
