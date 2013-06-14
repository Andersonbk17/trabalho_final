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
public class CursoArea {
    private int idCursoArea;
    private String nome;
    private String sigla;
    private int statusCursoArea;
    
    //Construtores

    public CursoArea(int idCursoArea, String nome, String sigla, int statusCursoArea) {
        this.idCursoArea = idCursoArea;
        this.nome = nome;
        this.sigla = sigla;
        this.statusCursoArea = statusCursoArea;
    }
    
    public CursoArea() {
        this.idCursoArea = 0;
        this.nome = "vazio";
        this.sigla = "vazio";
        this.statusCursoArea = 1;
    }
   
    //Metodos

    public int getIdCursoArea() {
        return idCursoArea;
    }

    public void setIdCursoArea(int idCursoArea) {
        this.idCursoArea = idCursoArea;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getStatusCursoArea() {
        return statusCursoArea;
    }

    public void setStatusCursoArea(int statusCursoArea) {
        this.statusCursoArea = statusCursoArea;
    }
    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idCursoArea;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.sigla);
        hash = 97 * hash + this.statusCursoArea;
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
        final CursoArea other = (CursoArea) obj;
        if (this.idCursoArea != other.idCursoArea) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sigla, other.sigla)) {
            return false;
        }
        if (this.statusCursoArea != other.statusCursoArea) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "CursoArea{" + "idCursoArea=" + idCursoArea + ", nome=" + nome + ", sigla=" + sigla + ", statusCursoArea=" + statusCursoArea + '}';
    }
    
}
