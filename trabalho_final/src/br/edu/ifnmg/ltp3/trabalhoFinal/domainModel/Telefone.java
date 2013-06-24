/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

/**
 *
 * @author emerson
 */
public class Telefone {
    private int idTelefone;
    private int ddd;
    private int numero;
    private int status;
    
    //Construtores

    public Telefone(int idTelefone, int ddd, int numero, int status) {
        this.idTelefone = idTelefone;
        this.ddd = ddd;
        this.numero = numero;
        this.status = status;
    }

    public Telefone() {
        this.idTelefone = 0;
        this.ddd = 0;
        this.numero = 0;
        this.status = 1;
    }
    
    //Metodos

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
        return "Telefone{" + "idTelefone=" + idTelefone + ", ddd=" + ddd + ", numero=" +numero + ", status=" + status + '}';
    }
    
    
    
    
    
}
