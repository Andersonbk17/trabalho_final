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
    private boolean status;
    
    //Construtores

    public CursoArea(int idCursoArea, String nome, String sigla, boolean status) {
        this.idCursoArea = idCursoArea;
        this.nome = nome;
        this.sigla = sigla;
        this.status = status;
    }
    
    public CursoArea() {
        this.idCursoArea = 0;
        this.nome = "vazio";
        this.sigla = "vazio";
        this.status = true;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idCursoArea;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.sigla);
        hash = 71 * hash + (this.status ? 1 : 0);
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
