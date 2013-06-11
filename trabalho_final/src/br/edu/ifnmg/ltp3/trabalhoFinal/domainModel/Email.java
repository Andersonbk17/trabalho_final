/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

/**
 *
 * @author emerson
 */
public class Email {
    private int idEmail;
    private String enderecoEmail;
    private int status;
    
    //Construtores

    public Email(int idEmail, String enderecoEmail, int status) {
        this.idEmail = idEmail;
        this.enderecoEmail = enderecoEmail;
        this.status = status;
    }

    public Email() {
        this.idEmail = 0;
        this.enderecoEmail = "vazio";
        this.status = 1;
    }
    
    //Metodos

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
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
        return "Email{" + "idEmail=" + idEmail + ", enderecoEmail=" + enderecoEmail + ", status=" + status + '}';
    }
      
}
