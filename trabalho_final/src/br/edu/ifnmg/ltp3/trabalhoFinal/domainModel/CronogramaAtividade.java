/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author emerson
 */
public class CronogramaAtividade {
    private int idCronogramaAtividade;
    private String descricao;
    private int numeroAtividade;
    private int status;
    private String dataAtividade;
    private Date dataInicio;
    private Date dataTermino;
    
      
    //Construtores

    public CronogramaAtividade(int idCronogramaAtividade, String descricao, int numeroAtividade, int status, String dataAtividade) {
        this.idCronogramaAtividade = idCronogramaAtividade;
        this.descricao = descricao;
        this.numeroAtividade = numeroAtividade;
        this.status = status;
        this.dataAtividade = dataAtividade;
       
    }
    
    public CronogramaAtividade() {
        this.idCronogramaAtividade = 0;
        this.descricao = "vazio";
        this.numeroAtividade = 0;
        this.status = 1;
        this.dataAtividade = "vazio";
        this.dataInicio = new Date();
        this.dataTermino = new Date();
      
    }
    
    //Metodos

    public int getIdCronogramaAtividade() {
        return idCronogramaAtividade;
    }

    public void setIdCronogramaAtividade(int idCronogramaAtividade) {
        this.idCronogramaAtividade = idCronogramaAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroAtividade() {
        return numeroAtividade;
    }

    public void setNumeroAtividade(int numeroAtividade) {
        this.numeroAtividade = numeroAtividade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(String dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idCronogramaAtividade;
        hash = 29 * hash + Objects.hashCode(this.descricao);
        hash = 29 * hash + this.numeroAtividade;
        hash = 29 * hash + this.status;
        hash = 29 * hash + Objects.hashCode(this.dataAtividade);
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
        final CronogramaAtividade other = (CronogramaAtividade) obj;
        if (this.idCronogramaAtividade != other.idCronogramaAtividade) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (this.numeroAtividade != other.numeroAtividade) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.dataAtividade, other.dataAtividade)) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "CronogramaAtividade{" + "idCronogramaAtividade=" + idCronogramaAtividade + 
                ", descricao=" + descricao + ", numeroAtividade=" + numeroAtividade + ", status=" 
                + status + ", dataAtividade=" + dataAtividade + '}';
    }

}

