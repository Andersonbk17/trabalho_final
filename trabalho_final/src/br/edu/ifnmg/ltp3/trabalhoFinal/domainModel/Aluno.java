/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author emerson
 */
public class Aluno extends Pessoa {
    private int idAluno;
    private int matricula;
    private String tituloEleitoral;
    private String secaoEleitoral;
    private String zonaEleitoral;
    private String situacaoMilitar;
    private String certidaoMilitar;
    private boolean status;
    
    private Responsavel responsavel;
    private List<LocalTrabalho> listaLocalTrabalho;        
    
    //Construtores

    public Aluno(int idAluno, int matricula, String tituloEleitoral, String secaoEleitoral, 
            String situacaoMilitar, String certidaoMilitar, Responsavel responsavel, boolean status, List<LocalTrabalho> listaLocalTrabalho) {
        this.idAluno = idAluno;
        this.matricula = matricula;
        this.tituloEleitoral = tituloEleitoral;
        this.secaoEleitoral = secaoEleitoral;
        this.situacaoMilitar = situacaoMilitar;
        this.certidaoMilitar = certidaoMilitar;
        this.responsavel = responsavel;
        this.status = status;
        this.listaLocalTrabalho = listaLocalTrabalho;
                
    }
    
     public Aluno() {
        this.idAluno = 0;
        this.matricula = 0;
        this.tituloEleitoral = "vazio";
        this.secaoEleitoral = "vazio";
        this.situacaoMilitar = "vazio";
        this.certidaoMilitar = "vazio";
        this.responsavel = new Responsavel();
        this.status = true;
        this.listaLocalTrabalho = new LinkedList<>();
    }
    
    //Metodos

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
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

    public String getSituacaoMilitar() {
        return situacaoMilitar;
    }

    public void setSituacaoMilitar(String cituacaoMilitar) {
        this.situacaoMilitar = cituacaoMilitar;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public void addLocalTrabalho(LocalTrabalho l){
        if(!listaLocalTrabalho.contains(l)){
            this.listaLocalTrabalho.add(l);
        }
    }
    
    public void removeLocalTrabalho(LocalTrabalho l){
        if(listaLocalTrabalho.contains(l)){
            this.listaLocalTrabalho.remove(l);
        }
    }
     
    //Hashcodes

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idAluno;
        hash = 37 * hash + Objects.hashCode(this.matricula);
        hash = 37 * hash + Objects.hashCode(this.tituloEleitoral);
        hash = 37 * hash + Objects.hashCode(this.secaoEleitoral);
        hash = 37 * hash + Objects.hashCode(this.zonaEleitoral);
        hash = 37 * hash + Objects.hashCode(this.situacaoMilitar);
        hash = 37 * hash + Objects.hashCode(this.certidaoMilitar);
        hash = 37 * hash + (this.status ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.responsavel);
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
        if (!Objects.equals(this.situacaoMilitar, other.situacaoMilitar)) {
            return false;
        }
        if (!Objects.equals(this.certidaoMilitar, other.certidaoMilitar)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "Aluno{" + "idAluno=" + idAluno + ", matricula=" + matricula + ", tituloEleitoral=" +
                tituloEleitoral + ", secaoEleitoral=" + secaoEleitoral + ", zonaEleitoral=" + 
                zonaEleitoral + ", cituacaoMilitar=" + situacaoMilitar + ", certidaoMilitar=" + 
                certidaoMilitar + ", responsavel=" + responsavel + ", status=" + status + '}';
    }
    
}



