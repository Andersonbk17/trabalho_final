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

    
    //Construtores

    public Campus(int idCampus, String nome, boolean status) {
        this.idCampus = idCampus;
        this.nome = nome;
   
    }
    
    public Campus() {
        this.idCampus = 0;
        this.nome = "vazio";
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

    //HashCodes

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idCampus;
        hash = 89 * hash + Objects.hashCode(this.nome);
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
       
        return true;
    }
    
   
    //toString

    @Override
    public String toString() {
        return nome;
    }

    
    
}
