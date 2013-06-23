/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author emerson
 */
public class ProjetoPesquisa {
    private int idProjetoPesquisa;
    private String titulo;
    private Date dataInicio;
    private Date dataTermino;
    private String grupoPesquisa;
    private String resumo;
    private int financiamento;
    private int bolsa;
    private int convenio;
    private double valorFinanciamento;
    private Date dataFinanciamento;
    private int numeroBolsa;
    private String agenciaFinanciadora;
    private String nomeConvenio;
    private int projetoMultiCampi;
    private boolean status;
    
    private Orientador orientador;
    private Campus campus;
    private AreaConhecimento areConhecimento;
    private  List<ParticipanteProjeto> listaParticipantes;
   
    
    //Construtores

    public ProjetoPesquisa(int idProjetoPesquisa, String titulo, Date dataInicio, Date dataTermino, 
           String grupoPesquisa, String resumo, int financiamento, int bolsa, int convenio, double 
                   valorFinanciamento, Date dataFinanciamento, int numeroBolsa, String agenciaFinanciadora, 
                   String nomeConvenio, int projetoMultiCampi, boolean status, Orientador orientador, 
                   Campus campus, AreaConhecimento areConhecimento, List<ParticipanteProjeto> participantes) {
        this.idProjetoPesquisa = idProjetoPesquisa;
        this.titulo = titulo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.grupoPesquisa = grupoPesquisa;
        this.resumo = resumo;
        this.financiamento = financiamento;
        this.bolsa = bolsa;
        this.convenio = convenio;
        this.valorFinanciamento = valorFinanciamento;
        this.dataFinanciamento = dataFinanciamento;
        this.numeroBolsa = numeroBolsa;
        this.agenciaFinanciadora = agenciaFinanciadora;
        this.nomeConvenio = nomeConvenio;
        this.projetoMultiCampi = projetoMultiCampi;
        this.status = status;
        this.orientador = orientador;
        this.campus = campus;
        this.areConhecimento = areConhecimento;
        this.listaParticipantes = participantes;
    }
    
    public ProjetoPesquisa() {
        this.idProjetoPesquisa = 0;
        this.titulo = "vazio";
        this.dataInicio = new Date();
        this.dataTermino = new Date();
        this.grupoPesquisa = "vazio";
        this.resumo = "vazio";
        this.financiamento = 0;
        this.bolsa = 0;
        this.convenio = 0;
        this.valorFinanciamento = 0;
        this.dataFinanciamento = new Date();
        this.numeroBolsa = 0;
        this.agenciaFinanciadora = "vazio";
        this.nomeConvenio = "vazio";
        this.projetoMultiCampi = 0;
        this.status = true;
        this.orientador = new Orientador();
        this.campus = new Campus();
        this.areConhecimento = new AreaConhecimento();
        this.listaParticipantes = new LinkedList<>();
    }
    
    //Metodos

    public int getIdProjetoPesquisa() {
        return idProjetoPesquisa;
    }

    public void setIdProjetoPesquisa(int idProjetoPesquisa) {
        this.idProjetoPesquisa = idProjetoPesquisa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getGrupoPesquisa() {
        return grupoPesquisa;
    }

    public void setGrupoPesquisa(String grupoPesquisa) {
        this.grupoPesquisa = grupoPesquisa;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getFinanciamento() {
        return financiamento;
    }

    public void setFinanciamento(int financiamento) {
        this.financiamento = financiamento;
    }

    public int getBolsa() {
        return bolsa;
    }

    public void setBolsa(int bolsa) {
        this.bolsa = bolsa;
    }

    public int getConvenio() {
        return convenio;
    }

    public void setConvenio(int convenio) {
        this.convenio = convenio;
    }

    public double getValorFinanciamento() {
        return valorFinanciamento;
    }

    public void setValorFinanciamento(double valorFinanciamento) {
        this.valorFinanciamento = valorFinanciamento;
    }

    public Date getDataFinanciamento() {
        return dataFinanciamento;
    }

    public void setDataFinanciamento(Date dataFinanciamento) {
        this.dataFinanciamento = dataFinanciamento;
    }

    public int getNumeroBolsa() {
        return numeroBolsa;
    }

    public void setNumeroBolsa(int numeroBolsa) {
        this.numeroBolsa = numeroBolsa;
    }

    public String getAgenciaFinanciadora() {
        return agenciaFinanciadora;
    }

    public void setAgenciaFinanciadora(String agenciaFinanciadora) {
        this.agenciaFinanciadora = agenciaFinanciadora;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public int getProjetoMultiCampi() {
        return projetoMultiCampi;
    }

    public void setProjetoMultiCampi(int projetoMultiCampi) {
        this.projetoMultiCampi = projetoMultiCampi;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public AreaConhecimento getAreConhecimento() {
        return areConhecimento;
    }

    public void setAreConhecimento(AreaConhecimento areConhecimento) {
        this.areConhecimento = areConhecimento;
    }
    
    public void addParticipantesProjeto(ParticipanteProjeto p){
        if(!listaParticipantes.equals(p)){
            this.listaParticipantes.add(p);
        }
    }
    
    public void removeParticipantesProjeto(ParticipanteProjeto p){
        if(listaParticipantes.equals(p)){
            this.listaParticipantes.remove(p);
        }
    }

    public List<ParticipanteProjeto> getListaParticipantes() {
        return listaParticipantes;
    }

    public void setListaParticipantes(List<ParticipanteProjeto> listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }
    
    
    
    //HashCodes

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idProjetoPesquisa;
        hash = 59 * hash + Objects.hashCode(this.titulo);
        hash = 59 * hash + Objects.hashCode(this.dataInicio);
        hash = 59 * hash + Objects.hashCode(this.dataTermino);
        hash = 59 * hash + Objects.hashCode(this.grupoPesquisa);
        hash = 59 * hash + Objects.hashCode(this.resumo);
        hash = 59 * hash + this.financiamento;
        hash = 59 * hash + this.bolsa;
        hash = 59 * hash + this.convenio;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.valorFinanciamento) ^ (Double.doubleToLongBits(this.valorFinanciamento) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.dataFinanciamento);
        hash = 59 * hash + this.numeroBolsa;
        hash = 59 * hash + Objects.hashCode(this.agenciaFinanciadora);
        hash = 59 * hash + Objects.hashCode(this.nomeConvenio);
        hash = 59 * hash + this.projetoMultiCampi;
        hash = 59 * hash + (this.status ? 1 : 0);
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
        final ProjetoPesquisa other = (ProjetoPesquisa) obj;
        if (this.idProjetoPesquisa != other.idProjetoPesquisa) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataTermino, other.dataTermino)) {
            return false;
        }
        if (!Objects.equals(this.grupoPesquisa, other.grupoPesquisa)) {
            return false;
        }
        if (!Objects.equals(this.resumo, other.resumo)) {
            return false;
        }
        if (this.financiamento != other.financiamento) {
            return false;
        }
        if (this.bolsa != other.bolsa) {
            return false;
        }
        if (this.convenio != other.convenio) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorFinanciamento) != Double.doubleToLongBits(other.valorFinanciamento)) {
            return false;
        }
        if (!Objects.equals(this.dataFinanciamento, other.dataFinanciamento)) {
            return false;
        }
        if (this.numeroBolsa != other.numeroBolsa) {
            return false;
        }
        if (!Objects.equals(this.agenciaFinanciadora, other.agenciaFinanciadora)) {
            return false;
        }
        if (!Objects.equals(this.nomeConvenio, other.nomeConvenio)) {
            return false;
        }
        if (this.projetoMultiCampi != other.projetoMultiCampi) {
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
        return "ProjetoPesquisa{" + "idProjetoPesquisa=" + idProjetoPesquisa + ", titulo=" + titulo + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", grupoPesquisa=" + grupoPesquisa + ", resumo=" + resumo + ", financiamento=" + financiamento + ", bolsa=" + bolsa + ", convenio=" + convenio + ", valorFinanciamento=" + valorFinanciamento + ", dataFinanciamento=" + dataFinanciamento + ", numeroBolsa=" + numeroBolsa + ", agenciaFinanciadora=" + agenciaFinanciadora + ", nomeConvenio=" + nomeConvenio + ", projetoMultiCampi=" + projetoMultiCampi + ", status=" + status + ", orientador=" + orientador + ", campus=" + campus + ", areConhecimento=" + areConhecimento + '}';
    }
    
}
