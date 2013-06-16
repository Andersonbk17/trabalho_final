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
public class PlanoTrabalho {
    private int idPlanoTrabalho;
    private String introducao;
    private String justificativa;
    private String objetivo;
    private String metodologia;
    private String resultadoEsperado;
    private String referenciaBibliografica;
    private boolean status;
    private String dataInicial;
    private String dataFinal;
    
    private Aluno aluno;
    private ProjetoPesquisa projetoPesquisa;
    
    //Construtores

    public PlanoTrabalho(int idPlanoTrabalho, String introducao, String justificativa, String objetivo, String metodologia, String resultadoEsperado, String referenciaBibliografica, boolean status, String dataInicial, String dataFinal, Aluno aluno, ProjetoPesquisa projetoPesquisa) {
        this.idPlanoTrabalho = idPlanoTrabalho;
        this.introducao = introducao;
        this.justificativa = justificativa;
        this.objetivo = objetivo;
        this.metodologia = metodologia;
        this.resultadoEsperado = resultadoEsperado;
        this.referenciaBibliografica = referenciaBibliografica;
        this.status = status;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.aluno = aluno;
        this.projetoPesquisa = projetoPesquisa;
    }
    
    public PlanoTrabalho() {
        this.idPlanoTrabalho = 0;
        this.introducao = "vazio";
        this.justificativa = "vazio";
        this.objetivo = "vazio";
        this.metodologia = "vazio";
        this.resultadoEsperado = "vazio";
        this.referenciaBibliografica = "vazio";
        this.status = true;
        this.dataInicial = "vazio";
        this.dataFinal = "vazio";
        this.aluno = new Aluno();
        this.projetoPesquisa = new ProjetoPesquisa();
    }
    
    //Metodos

    public int getIdPlanoTrabalho() {
        return idPlanoTrabalho;
    }

    public void setIdPlanoTrabalho(int idPlanoTrabalho) {
        this.idPlanoTrabalho = idPlanoTrabalho;
    }

    public String getIntroducao() {
        return introducao;
    }

    public void setIntroducao(String introducao) {
        this.introducao = introducao;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getMetodologia() {
        return metodologia;
    }

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    public void setResultadoEsperado(String resultadoEsperado) {
        this.resultadoEsperado = resultadoEsperado;
    }

    public String getReferenciaBibliografica() {
        return referenciaBibliografica;
    }

    public void setReferenciaBibliografica(String referenciaBibliografica) {
        this.referenciaBibliografica = referenciaBibliografica;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public ProjetoPesquisa getProjetoPesquisa() {
        return projetoPesquisa;
    }

    public void setProjetoPesquisa(ProjetoPesquisa projetoPesquisa) {
        this.projetoPesquisa = projetoPesquisa;
    }
    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idPlanoTrabalho;
        hash = 37 * hash + Objects.hashCode(this.introducao);
        hash = 37 * hash + Objects.hashCode(this.justificativa);
        hash = 37 * hash + Objects.hashCode(this.objetivo);
        hash = 37 * hash + Objects.hashCode(this.metodologia);
        hash = 37 * hash + Objects.hashCode(this.resultadoEsperado);
        hash = 37 * hash + Objects.hashCode(this.referenciaBibliografica);
        hash = 37 * hash + (this.status ? 1 : 0);
        hash = 37 * hash + Objects.hashCode(this.dataInicial);
        hash = 37 * hash + Objects.hashCode(this.dataFinal);
        hash = 37 * hash + Objects.hashCode(this.aluno);
        hash = 37 * hash + Objects.hashCode(this.projetoPesquisa);
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
        final PlanoTrabalho other = (PlanoTrabalho) obj;
        if (this.idPlanoTrabalho != other.idPlanoTrabalho) {
            return false;
        }
        if (!Objects.equals(this.introducao, other.introducao)) {
            return false;
        }
        if (!Objects.equals(this.justificativa, other.justificativa)) {
            return false;
        }
        if (!Objects.equals(this.objetivo, other.objetivo)) {
            return false;
        }
        if (!Objects.equals(this.metodologia, other.metodologia)) {
            return false;
        }
        if (!Objects.equals(this.resultadoEsperado, other.resultadoEsperado)) {
            return false;
        }
        if (!Objects.equals(this.referenciaBibliografica, other.referenciaBibliografica)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.dataInicial, other.dataInicial)) {
            return false;
        }
        if (!Objects.equals(this.dataFinal, other.dataFinal)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        if (!Objects.equals(this.projetoPesquisa, other.projetoPesquisa)) {
            return false;
        }
        return true;
    }
    
    //toString

    @Override
    public String toString() {
        return "PlanoTrabalho{" + "idPlanoTrabalho=" + idPlanoTrabalho + ", introducao=" + introducao + ", justificativa=" + justificativa + ", objetivo=" + objetivo + ", metodologia=" + metodologia + ", resultadoEsperado=" + resultadoEsperado + ", referenciaBibliografica=" + referenciaBibliografica + ", status=" + status + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", aluno=" + aluno + ", projetoPesquisa=" + projetoPesquisa + '}';
    }
      
}
