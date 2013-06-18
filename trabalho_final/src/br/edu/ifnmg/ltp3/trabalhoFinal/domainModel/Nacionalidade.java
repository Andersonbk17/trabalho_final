/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.Objects;

/**
 *
 * @author Modric
 */
public class Nacionalidade {
    private int idNacionalida;
    private String nome;
    private boolean status;
    
    
    public Nacionalidade(){
        this.idNacionalida = 0;
        this.nome = "vazio";
        this.status = true;
    
    
    }

    public Nacionalidade(int idNacionalida, String nome, boolean status) {
        this.idNacionalida = idNacionalida;
        this.nome = nome;
        this.status = status;
    }

    public int getIdNacionalida() {
        return idNacionalida;
    }

    public void setIdNacionalida(int idNacionalida) {
        this.idNacionalida = idNacionalida;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.idNacionalida;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + (this.status ? 1 : 0);
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
        final Nacionalidade other = (Nacionalidade) obj;
        if (this.idNacionalida != other.idNacionalida) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nacionalidade{" + "nome=" + nome + '}';
    }
    
    
    
    
    
}
