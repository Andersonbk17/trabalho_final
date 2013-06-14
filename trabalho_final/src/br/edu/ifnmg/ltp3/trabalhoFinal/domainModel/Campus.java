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
public class Campus {
    private int idCampus;
    private String nome;
    private int statusCampus;
    
    //Construtores

    public Campus(int idCampus, String nome, int statusCampus) {
        this.idCampus = idCampus;
        this.nome = nome;
        this.statusCampus = statusCampus;
    }
    
    public Campus() {
        this.idCampus = 0;
        this.nome = "vazio";
        this.statusCampus = 1;
    }
    
    //Metodos

    public int getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(int idCampus) {
        this.idCampus = idCampus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatusCampus() {
        return statusCampus;
    }

    public void setStatusCampus(int statusCampus) {
        this.statusCampus = statusCampus;
    }

    //HashCodes
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idCampus;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + this.statusCampus;
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
        final Campus other = (Campus) obj;
        if (this.idCampus != other.idCampus) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.statusCampus != other.statusCampus) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "Campus{" + "idCampus=" + idCampus + ", nome=" + nome + ", statusCampus=" + statusCampus + '}';
    }
    
}
