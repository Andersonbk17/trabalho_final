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
public class Aluno extends Pessoa {
    private int idAluno;
    private String matricula;
    private String tituloEleitoral;
    private String secaoEleitoral;
    private String zonaEleitoral;
    private String cituacaoMilitar;
    private String certidaoMilitar;
    private Responsavel responsavel;
    private int statusAluno;
    
    //Construtores

    public Aluno(int idAluno, String matricula, String tituloEleitoral, String secaoEleitoral, String cituacaoMilitar, String certidaoMilitar, Responsavel responsavel, int statusAluno) {
        this.idAluno = idAluno;
        this.matricula = matricula;
        this.tituloEleitoral = tituloEleitoral;
        this.secaoEleitoral = secaoEleitoral;
        this.cituacaoMilitar = cituacaoMilitar;
        this.certidaoMilitar = certidaoMilitar;
        this.responsavel = responsavel;
        this.statusAluno = statusAluno;
    }
    
     public Aluno() {
        this.idAluno = 0;
        this.matricula = "vazio";
        this.tituloEleitoral = "vazio";
        this.secaoEleitoral = "vazio";
        this.cituacaoMilitar = "vazio";
        this.certidaoMilitar = "vazio";
        this.responsavel = new Responsavel();
        this.statusAluno = 1;
    }
    
    //Metodos

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTituloEleitoral() {
        return tituloEleitoral;
    }

    public void setTituloEleitoral(String tituloEleitoral) {
        this.tituloEleitoral = tituloEleitoral;
    }

    public String getSecaoEleitoral() {
        return secaoEleitoral;
    }

    public void setSecaoEleitoral(String secaoEleitoral) {
        this.secaoEleitoral = secaoEleitoral;
    }

    public String getZonaEleitoral() {
        return zonaEleitoral;
    }

    public void setZonaEleitoral(String zonaEleitoral) {
        this.zonaEleitoral = zonaEleitoral;
    }

    public String getCituacaoMilitar() {
        return cituacaoMilitar;
    }

    public void setCituacaoMilitar(String cituacaoMilitar) {
        this.cituacaoMilitar = cituacaoMilitar;
    }

    public String getCertidaoMilitar() {
        return certidaoMilitar;
    }

    public void setCertidaoMilitar(String certidaoMilitar) {
        this.certidaoMilitar = certidaoMilitar;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public int getStatusAluno() {
        return statusAluno;
    }

    public void setStatusAluno(int statusAluno) {
        this.statusAluno = statusAluno;
    }
     
    //Hashcodes

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idAluno;
        hash = 47 * hash + Objects.hashCode(this.matricula);
        hash = 47 * hash + Objects.hashCode(this.tituloEleitoral);
        hash = 47 * hash + Objects.hashCode(this.secaoEleitoral);
        hash = 47 * hash + Objects.hashCode(this.zonaEleitoral);
        hash = 47 * hash + Objects.hashCode(this.cituacaoMilitar);
        hash = 47 * hash + Objects.hashCode(this.certidaoMilitar);
        hash = 47 * hash + Objects.hashCode(this.responsavel);
        hash = 47 * hash + this.statusAluno;
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
        final Aluno other = (Aluno) obj;
        if (this.idAluno != other.idAluno) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.tituloEleitoral, other.tituloEleitoral)) {
            return false;
        }
        if (!Objects.equals(this.secaoEleitoral, other.secaoEleitoral)) {
            return false;
        }
        if (!Objects.equals(this.zonaEleitoral, other.zonaEleitoral)) {
            return false;
        }
        if (!Objects.equals(this.cituacaoMilitar, other.cituacaoMilitar)) {
            return false;
        }
        if (!Objects.equals(this.certidaoMilitar, other.certidaoMilitar)) {
            return false;
        }
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        if (this.statusAluno != other.statusAluno) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "Aluno{" + "idAluno=" + idAluno + ", matricula=" + matricula + ", tituloEleitoral=" + tituloEleitoral + ", secaoEleitoral=" + secaoEleitoral + ", zonaEleitoral=" + zonaEleitoral + ", cituacaoMilitar=" + cituacaoMilitar + ", certidaoMilitar=" + certidaoMilitar + ", responsavel=" + responsavel + ", statusAluno=" + statusAluno + '}';
    }
    
}


