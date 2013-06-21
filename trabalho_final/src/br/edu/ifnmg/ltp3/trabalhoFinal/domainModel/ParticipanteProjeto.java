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
public class ParticipanteProjeto {
    private int idParticipanteProjeto;
    private String nome;
    private String titulacao;
    private String observacao;
    private boolean status;
    
    private Campus campus;

    
    //Constutores

    public ParticipanteProjeto(int idParticaProjeto, String nome, String titulacao, String observacao, boolean status, 
            Campus campus) {
        this.idParticipanteProjeto = idParticaProjeto;
        this.nome = nome;
        this.titulacao = titulacao;
        this.observacao = observacao;
        this.status = status;
        this.campus = campus;
     
    }
    
    public ParticipanteProjeto() {
        this.idParticipanteProjeto = 0;
        this.nome = "vazio";
        this.titulacao = "vazio";
        this.observacao = "vazio";
        this.status = true;
        this.campus = new Campus();
    }
    
    //Metodos

    public int getIdParticipanteProjeto() {
        return idParticipanteProjeto;
    }

    public void setIdParticipanteProjeto(int idParticaProjeto) {
        this.idParticipanteProjeto = idParticaProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulocao) {
        this.titulacao = titulocao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idParticipanteProjeto;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.titulacao);
        hash = 97 * hash + Objects.hashCode(this.observacao);
        hash = 97 * hash + (this.status ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.campus);
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
        final ParticipanteProjeto other = (ParticipanteProjeto) obj;
        if (this.idParticipanteProjeto != other.idParticipanteProjeto) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.titulacao, other.titulacao)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.campus, other.campus)) {
            return false;
        }
  
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "ParticipanteProjeto{" + "idParticipanteProjeto=" + idParticipanteProjeto +
                ", nome=" + nome + ", titulocao=" + titulacao + ", observacao=" + observacao + 
                ", status=" + status + ", campus=" + campus + '}';
    }

    
}
