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
public class ParticipantesProjeto {
    private int idParticaProjeto;
    private String nome;
    private String titulocao;
    private String observacao;
    private boolean status;
    
    private Campus campus;
    private ProjetoPesquisa projetoPesquisa;
    
    //Constutores

    public ParticipantesProjeto(int idParticaProjeto, String nome, String titulocao, String observacao, boolean status, 
            Campus campus, ProjetoPesquisa projetoPesquisa) {
        this.idParticaProjeto = idParticaProjeto;
        this.nome = nome;
        this.titulocao = titulocao;
        this.observacao = observacao;
        this.status = status;
        this.campus = campus;
        this.projetoPesquisa = projetoPesquisa;
    }
    
    public ParticipantesProjeto() {
        this.idParticaProjeto = 0;
        this.nome = "vazio";
        this.titulocao = "vazio";
        this.observacao = "vazio";
        this.status = true;
        this.campus = new Campus();
        this.projetoPesquisa = new ProjetoPesquisa();
    }
    
    //Metodos

    public int getIdParticaProjeto() {
        return idParticaProjeto;
    }

    public void setIdParticaProjeto(int idParticaProjeto) {
        this.idParticaProjeto = idParticaProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulocao() {
        return titulocao;
    }

    public void setTitulocao(String titulocao) {
        this.titulocao = titulocao;
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

    public ProjetoPesquisa getProjetoPesquisa() {
        return projetoPesquisa;
    }

    public void setProjetoPesquisa(ProjetoPesquisa projetoPesquisa) {
        this.projetoPesquisa = projetoPesquisa;
    }
    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idParticaProjeto;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.titulocao);
        hash = 97 * hash + Objects.hashCode(this.observacao);
        hash = 97 * hash + (this.status ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.campus);
        hash = 97 * hash + Objects.hashCode(this.projetoPesquisa);
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
        final ParticipantesProjeto other = (ParticipantesProjeto) obj;
        if (this.idParticaProjeto != other.idParticaProjeto) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.titulocao, other.titulocao)) {
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
        if (!Objects.equals(this.projetoPesquisa, other.projetoPesquisa)) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "ParticipaProjeto{" + "idParticaProjeto=" + idParticaProjeto + ", nome=" + nome + ", titulocao=" + titulocao + ", observacao=" + observacao + ", status=" + status + ", campus=" + campus + ", projetoPesquisa=" + projetoPesquisa + '}';
    }
       
}
