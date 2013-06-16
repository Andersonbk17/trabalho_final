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
public class Orientador extends Pessoa {
    private int idOrientador;
    private int matriculaSiape;
    private String localPermanencia;
    private String formacaoAcademica;
    private String tituloAcademico;
    private boolean status;
    
    //Construtores

    public Orientador(int idOrientador, int matriculaSiape, String localPermanencia, String formacaoAcademica, String tituloAcademico, boolean status) {
        this.idOrientador = idOrientador;
        this.matriculaSiape = matriculaSiape;
        this.localPermanencia = localPermanencia;
        this.formacaoAcademica = formacaoAcademica;
        this.tituloAcademico = tituloAcademico;
        this.status = status;
    }
    
    public Orientador() {
        this.idOrientador = 0;
        this.matriculaSiape = 0;
        this.localPermanencia = "vazio";
        this.formacaoAcademica = "vazio";
        this.tituloAcademico = "vazio";
        this.status = true;
    }
    
    //Metodos

    public int getIdOrientador() {
        return idOrientador;
    }

    public void setIdOrientador(int idOrientador) {
        this.idOrientador = idOrientador;
    }

    public int getMatriculaSiape() {
        return matriculaSiape;
    }

    public void setMatriculaSiape(int matriculaSiape) {
        this.matriculaSiape = matriculaSiape;
    }

    public String getLocalPermanencia() {
        return localPermanencia;
    }

    public void setLocalPermanencia(String localPermanencia) {
        this.localPermanencia = localPermanencia;
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    public void setTituloAcademico(String tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatusOrientador(boolean status) {
        this.status = status;
    }
    
    //HaschCodes

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idOrientador;
        hash = 89 * hash + this.matriculaSiape;
        hash = 89 * hash + Objects.hashCode(this.localPermanencia);
        hash = 89 * hash + Objects.hashCode(this.formacaoAcademica);
        hash = 89 * hash + Objects.hashCode(this.tituloAcademico);
        hash = 89 * hash + (this.status ? 1 : 0);
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
        final Orientador other = (Orientador) obj;
        if (this.idOrientador != other.idOrientador) {
            return false;
        }
        if (this.matriculaSiape != other.matriculaSiape) {
            return false;
        }
        if (!Objects.equals(this.localPermanencia, other.localPermanencia)) {
            return false;
        }
        if (!Objects.equals(this.formacaoAcademica, other.formacaoAcademica)) {
            return false;
        }
        if (!Objects.equals(this.tituloAcademico, other.tituloAcademico)) {
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
        return "Orientador{" + "idOrientador=" + idOrientador + ", matriculaSiape=" + matriculaSiape + ", localPermanencia=" + localPermanencia + ", formacaoAcademica=" + formacaoAcademica + ", tituloAcademico=" + tituloAcademico + ", status=" + status + '}';
    }
    
}
