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
public class Endereco {
    private int idEndereco;
    private int numero;
    private String bairro;
    private String cep;
    private boolean status;
    
    private Cidade cidade;
    private Estado estado;
    
    //Construtores

    public Endereco(int idEndereco, int numero, String bairro, String cep, boolean status, Cidade cidade, Estado estado) {
        this.idEndereco = idEndereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.status = status;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    public Endereco() {
        this.idEndereco = 0;
        this.numero = 0;
        this.bairro = "vazio";
        this.cep = "vazio";
        this.status = true;
        this.cidade = new Cidade();
        this.estado = new Estado();
    }
    
    //Medodos

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idEndereco;
        hash = 29 * hash + this.numero;
        hash = 29 * hash + Objects.hashCode(this.bairro);
        hash = 29 * hash + Objects.hashCode(this.cep);
        hash = 29 * hash + (this.status ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.cidade);
        hash = 29 * hash + Objects.hashCode(this.estado);
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
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "Endereco{" + "idEndereco=" + idEndereco + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + ", status=" + status + ", cidade=" + cidade + ", estado=" + estado + '}';
    }
    
    
}
