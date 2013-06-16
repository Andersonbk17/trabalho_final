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
public class Email {
    private int idEmail;
    private String enderecoEmail;
    private boolean status;
    
    //Construtores

    public Email(int idEmail, String enderecoEmail, boolean status) {
        this.idEmail = idEmail;
        this.enderecoEmail = enderecoEmail;
        this.status = status;
    }

    public Email() {
        this.idEmail = 0;
        this.enderecoEmail = "vazio";
        this.status = true;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    //Hashcodes

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idEmail;
        hash = 17 * hash + Objects.hashCode(this.enderecoEmail);
        hash = 17 * hash + (this.status ? 1 : 0);
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
        final Email other = (Email) obj;
        if (this.idEmail != other.idEmail) {
            return false;
        }
        if (!Objects.equals(this.enderecoEmail, other.enderecoEmail)) {
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
        return "Email{" + "idEmail=" + idEmail + ", enderecoEmail=" + enderecoEmail + ", status=" + status + '}';
    }
      
}
