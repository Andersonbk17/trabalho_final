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
public class Responsavel {
    private int idResponsavelAluno;
    private String nomePai;
    private String rgPai;
    private String orgaoExpedidorPai;
    private int cpfPai;
    private String nomeMae;
    private String rgMae;
    private String orgaoExpedidorMae;
    private int cpfMae;
    private boolean status;
    
    //Construtores

    public Responsavel(int idResponsavelAluno, String nomePai, String rgPai, String orgaoExpedidorPai, int cpfPai, String nomeMae, String rgMae, String orgaoExpedidorMae, int cpfMae, boolean status) {
        this.idResponsavelAluno = idResponsavelAluno;
        this.nomePai = nomePai;
        this.rgPai = rgPai;
        this.orgaoExpedidorPai = orgaoExpedidorPai;
        this.cpfPai = cpfPai;
        this.nomeMae = nomeMae;
        this.rgMae = rgMae;
        this.orgaoExpedidorMae = orgaoExpedidorMae;
        this.cpfMae = cpfMae;
        this.status = status;
    }
    
    public Responsavel() {
        this.idResponsavelAluno = 0;
        this.nomePai = "vazio";
        this.rgPai = "vazio";
        this.orgaoExpedidorPai = "vazio";
        this.cpfPai = 0;
        this.nomeMae = "vazio";
        this.rgMae = "vazio";
        this.orgaoExpedidorMae = "vazio";
        this.cpfMae = 0;
        this.status = true;
    }
    
    //Metodos

    public int getIdResponsavelAluno() {
        return idResponsavelAluno;
    }

    public void setIdResponsavelAluno(int idResponsavelAluno) {
        this.idResponsavelAluno = idResponsavelAluno;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatusResponsavelAluno(boolean status) {
        this.status = status;
    }
    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idResponsavelAluno;
        hash = 83 * hash + Objects.hashCode(this.nomePai);
        hash = 83 * hash + Objects.hashCode(this.rgPai);
        hash = 83 * hash + Objects.hashCode(this.orgaoExpedidorPai);
        hash = 83 * hash + this.cpfPai;
        hash = 83 * hash + Objects.hashCode(this.nomeMae);
        hash = 83 * hash + Objects.hashCode(this.rgMae);
        hash = 83 * hash + Objects.hashCode(this.orgaoExpedidorMae);
        hash = 83 * hash + this.cpfMae;
        hash = 83 * hash + (this.status ? 1 : 0);
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
        final Responsavel other = (Responsavel) obj;
        if (this.idResponsavelAluno != other.idResponsavelAluno) {
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
        if (this.status != other.status) {
            return false;
        }
        return true;
    }

    //toString

    @Override
    public String toString() {
        return "Responsavel{" + "idResponsavelAluno=" + idResponsavelAluno + ", nomePai=" + nomePai + ", rgPai=" + rgPai + ", orgaoExpedidorPai=" + orgaoExpedidorPai + ", cpfPai=" + cpfPai + ", nomeMae=" + nomeMae + ", rgMae=" + rgMae + ", orgaoExpedidorMae=" + orgaoExpedidorMae + ", cpfMae=" + cpfMae + ", status=" + status + '}';
    }
   
}
