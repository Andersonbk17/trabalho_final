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
   
    
    private Responsavel responsavel;
    private List<LocalTrabalho> listaLocalTrabalho;      
    private PlanoTrabalho planoTrabalho;
    
    //Construtores

    public Aluno(int idAluno, int matricula, String tituloEleitoral, String secaoEleitoral, 
            String situacaoMilitar, String certidaoMilitar, Responsavel responsavel, 
            List<LocalTrabalho> listaLocalTrabalho, PlanoTrabalho planoTrabalho) {
        this.idAluno = idAluno;
        this.matricula = matricula;
        this.tituloEleitoral = tituloEleitoral;
        this.secaoEleitoral = secaoEleitoral;
        this.situacaoMilitar = situacaoMilitar;
        this.certidaoMilitar = certidaoMilitar;
        this.responsavel = responsavel;
        this.listaLocalTrabalho = listaLocalTrabalho;
        this.planoTrabalho = planoTrabalho;
                
    }
    
     public Aluno() {
        this.idAluno = 0;
        this.matricula = 0;
        this.tituloEleitoral = "vazio";
        this.secaoEleitoral = "vazio";
        this.situacaoMilitar = "vazio";
        this.certidaoMilitar = "vazio";
        this.responsavel = new Responsavel();
        this.listaLocalTrabalho = new LinkedList<>();
        this.planoTrabalho = new PlanoTrabalho();
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

    public List<LocalTrabalho> getListaLocalTrabalho() {
        return listaLocalTrabalho;
    }

    public void setListaLocalTrabalho(List<LocalTrabalho> listaLocalTrabalho) {
        this.listaLocalTrabalho = listaLocalTrabalho;
    }

    public PlanoTrabalho getPlanoTrabalho() {
        return planoTrabalho;
    }

    public void setPlanoTrabalho(PlanoTrabalho planoTrabalho) {
        this.planoTrabalho = planoTrabalho;
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
    
        if (!Objects.equals(this.responsavel, other.responsavel)) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", tituloEleitoral=" + tituloEleitoral + 
                ", secaoEleitoral=" + secaoEleitoral + ", zonaEleitoral=" + zonaEleitoral + 
                ", situacaoMilitar=" + situacaoMilitar + ", certidaoMilitar=" + certidaoMilitar + '}';
    }

   
    
}



