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
public class LocalTrabalho {
    private int idlocalTrabalho;
    private String nome;
    private int fone;
    private boolean status;
    

    private Telefone telefone;
    
    //Construtores

    public LocalTrabalho(int idlocalTrabalho, String nome, boolean status, Telefone telefone) {
        this.idlocalTrabalho = idlocalTrabalho;
        this.nome = nome;
        this.status = status;
        this.telefone = telefone;
    }
    
    public LocalTrabalho() {
        this.idlocalTrabalho = 0;
        this.nome = "vazio";
        this.status = true;
        this.telefone = new Telefone();
    }
    
    //Metodos

    public int getIdlocalTrabalho() {
        return idlocalTrabalho;
    }

    public void setIdlocalTrabalho(int idlocalTrabalho) {
        this.idlocalTrabalho = idlocalTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public int getFone() {
        return fone;
    }

    public void setFone(int fone) {
        this.fone = fone;
    }
    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idlocalTrabalho;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + (this.status ? 1 : 0);
        hash = 53 * hash + Objects.hashCode(this.telefone);
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
        final LocalTrabalho other = (LocalTrabalho) obj;
        if (this.idlocalTrabalho != other.idlocalTrabalho) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "LocalTrabalho{" + "idlocalTrabalho=" + idlocalTrabalho + ", nome="
                + nome + ", status=" + status + ", telefone=" + telefone + '}';
    }
    
    
}
