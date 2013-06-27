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
    private int trabalhoStatus;
    
    private String nomePai;
    private String rgPai;
    private String orgaoExpedidorPai;
    private int cpfPai;
    private String nomeMae;
    private String rgMae;
    private String orgaoExpedidorMae;
    private int cpfMae;
   
    private List<LocalTrabalho> listaLocalTrabalho;      
    private PlanoTrabalho planoTrabalho;
    
    //Construtores

    public Aluno(int idAluno, int matricula, String tituloEleitoral, String secaoEleitoral, 
            String zonaEleitoral, String situacaoMilitar, String certidaoMilitar, 
            int trabalhoStatus, String nomePai, String rgPai, String orgaoExpedidorPai, int cpfPai, 
            String nomeMae, String rgMae, String orgaoExpedidorMae, int cpfMae, 
            List<LocalTrabalho> listaLocalTrabalho, PlanoTrabalho planoTrabalho) {
        this.idAluno = idAluno;
        this.matricula = matricula;
        this.tituloEleitoral = tituloEleitoral;
        this.secaoEleitoral = secaoEleitoral;
        this.zonaEleitoral = zonaEleitoral;
        this.situacaoMilitar = situacaoMilitar;
        this.certidaoMilitar = certidaoMilitar;
        this.trabalhoStatus = trabalhoStatus;
        this.nomePai = nomePai;
        this.rgPai = rgPai;
        this.orgaoExpedidorPai = orgaoExpedidorPai;
        this.cpfPai = cpfPai;
        this.nomeMae = nomeMae;
        this.rgMae = rgMae;
        this.orgaoExpedidorMae = orgaoExpedidorMae;
        this.cpfMae = cpfMae;
        this.listaLocalTrabalho = listaLocalTrabalho;
        this.planoTrabalho = planoTrabalho;
    }
    
     public Aluno() {
        this.idAluno = 0;
        this.matricula = 0;
        this.tituloEleitoral = "vazio";
        this.secaoEleitoral = "vazio";
        this.zonaEleitoral = "vazio";
        this.situacaoMilitar = "vazio";
        this.certidaoMilitar = "vazio";
        this.trabalhoStatus = 1;
        this.nomePai = "vazio";
        this.rgPai = "vazio";
        this.orgaoExpedidorPai = "vazio";
        this.cpfPai = 0;
        this.nomeMae = "vazio";
        this.rgMae = "vazio";
        this.orgaoExpedidorMae = "vazio";
        this.cpfMae = 0;
        this.listaLocalTrabalho = listaLocalTrabalho;
        this.planoTrabalho = planoTrabalho;
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

    public int getTrabalhoStatus() {
        return trabalhoStatus;
    }

    public void setTrabalhoStatus(int trabalhoStatus) {
        this.trabalhoStatus = trabalhoStatus;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getRgPai() {
        return rgPai;
    }

    public void setRgPai(String rgPai) {
        this.rgPai = rgPai;
    }

    public String getOrgaoExpedidorPai() {
        return orgaoExpedidorPai;
    }

    public void setOrgaoExpedidorPai(String orgaoExpedidorPai) {
        this.orgaoExpedidorPai = orgaoExpedidorPai;
    }

    public int getCpfPai() {
        return cpfPai;
    }

    public void setCpfPai(int cpfPai) {
        this.cpfPai = cpfPai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getRgMae() {
        return rgMae;
    }

    public void setRgMae(String rgMae) {
        this.rgMae = rgMae;
    }

    public String getOrgaoExpedidorMae() {
        return orgaoExpedidorMae;
    }

    public void setOrgaoExpedidorMae(String orgaoExpedidorMae) {
        this.orgaoExpedidorMae = orgaoExpedidorMae;
    }

    public int getCpfMae() {
        return cpfMae;
    }

    public void setCpfMae(int cpfMae) {
        this.cpfMae = cpfMae;
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
        int hash = 5;
        hash = 13 * hash + this.idAluno;
        hash = 13 * hash + this.matricula;
        hash = 13 * hash + Objects.hashCode(this.tituloEleitoral);
        hash = 13 * hash + Objects.hashCode(this.secaoEleitoral);
        hash = 13 * hash + Objects.hashCode(this.zonaEleitoral);
        hash = 13 * hash + Objects.hashCode(this.situacaoMilitar);
        hash = 13 * hash + Objects.hashCode(this.certidaoMilitar);
        hash = 13 * hash + this.trabalhoStatus;
        hash = 13 * hash + Objects.hashCode(this.nomePai);
        hash = 13 * hash + Objects.hashCode(this.rgPai);
        hash = 13 * hash + Objects.hashCode(this.orgaoExpedidorPai);
        hash = 13 * hash + this.cpfPai;
        hash = 13 * hash + Objects.hashCode(this.nomeMae);
        hash = 13 * hash + Objects.hashCode(this.rgMae);
        hash = 13 * hash + Objects.hashCode(this.orgaoExpedidorMae);
        hash = 13 * hash + this.cpfMae;
        hash = 13 * hash + Objects.hashCode(this.listaLocalTrabalho);
        hash = 13 * hash + Objects.hashCode(this.planoTrabalho);
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
        if (this.matricula != other.matricula) {
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
        if (this.trabalhoStatus != other.trabalhoStatus) {
            return false;
        }
        if (!Objects.equals(this.nomePai, other.nomePai)) {
            return false;
        }
        if (!Objects.equals(this.rgPai, other.rgPai)) {
            return false;
        }
        if (!Objects.equals(this.orgaoExpedidorPai, other.orgaoExpedidorPai)) {
            return false;
        }
        if (this.cpfPai != other.cpfPai) {
            return false;
        }
        if (!Objects.equals(this.nomeMae, other.nomeMae)) {
            return false;
        }
        if (!Objects.equals(this.rgMae, other.rgMae)) {
            return false;
        }
        if (!Objects.equals(this.orgaoExpedidorMae, other.orgaoExpedidorMae)) {
            return false;
        }
        if (this.cpfMae != other.cpfMae) {
            return false;
        }
        if (!Objects.equals(this.listaLocalTrabalho, other.listaLocalTrabalho)) {
            return false;
        }
        if (!Objects.equals(this.planoTrabalho, other.planoTrabalho)) {
            return false;
        }
        return true;
    }

   
    
    //toString

    @Override
    public String toString() {
        return "Aluno{" + "idAluno=" + idAluno + ", matricula=" + matricula + ", tituloEleitoral=" + 
                tituloEleitoral + ", secaoEleitoral=" + secaoEleitoral + ", zonaEleitoral=" + 
                zonaEleitoral + ", situacaoMilitar=" + situacaoMilitar + ", certidaoMilitar=" + 
                certidaoMilitar + ", trabalhoStatus=" + trabalhoStatus + ", nomePai=" + 
                nomePai + ", rgPai=" + rgPai + ", orgaoExpedidorPai=" + orgaoExpedidorPai + ", cpfPai=" + 
                cpfPai + ", nomeMae=" + nomeMae + ", rgMae=" + rgMae + ", orgaoExpedidorMae=" + 
                orgaoExpedidorMae + ", cpfMae=" + cpfMae + ", listaLocalTrabalho=" + 
                listaLocalTrabalho + ", planoTrabalho=" + planoTrabalho + '}';
    }

    

   
    
}



