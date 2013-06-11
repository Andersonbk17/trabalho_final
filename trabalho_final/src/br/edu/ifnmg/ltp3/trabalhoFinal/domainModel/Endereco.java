/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

/**
 *
 * @author emerson
 */
public class Endereco {
    private int idEndereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;
    private int status;
   
    //Construtores

    public Endereco(int idEndereco, int numero, String bairro, String cidade, String cep, String estado, int status) {
        this.idEndereco = idEndereco;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.status = status;
    }
    
    public Endereco() {
        this.idEndereco = 0;
        this.numero = 0;
        this.bairro = "vazio";
        this.cidade = "vazio";
        this.cep = "vazio";
        this.estado = "vazio";
        this.status = 1;
    }
    
    //Metodos

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    //toString

    @Override
    public String toString() {
        return "Endereco{" + "idEndereco=" + idEndereco + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", cep=" + cep + ", estado=" + estado + ", status=" + status + '}';
    }

}
