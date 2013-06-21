/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.CursoArea;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.ProjetoPesquisa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Modric
 */
public class ProjetoPesquisaDAO {
    private ConexaoBanco conexao;
    
    public ProjetoPesquisaDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public ProjetoPesquisa Abrir(int idProjetoPesquisa) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM "
                    + "vw_ProjetoPesquisa WHERE idProjetoPesquisa = ? ");
            comando.setInt(1, idProjetoPesquisa);
            ResultSet consulta = comando.executeQuery();
            ProjetoPesquisa novo = null;
            if(consulta.first()){
                novo = new ProjetoPesquisa();
                AreaConhecimentoDAO areaDAO = new AreaConhecimentoDAO();
                CampusDAO campusDAO = new CampusDAO();
                OrientadorDAO orientadorDAO = new OrientadorDAO();
                
                novo.setIdProjetoPesquisa(idProjetoPesquisa);
                novo.setAgenciaFinanciadora(consulta.getString("agenciaFinanciadora"));
                novo.setAreConhecimento(areaDAO.Abrir(consulta.getInt("idAreaConhecimento")));
                novo.setBolsa(consulta.getInt("bolsa"));
                novo.setCampus(campusDAO.Abrir(consulta.getInt("idCampus")));
                novo.setConvenio(consulta.getInt("convenio"));
                //novo.setDataFinanciamento(null);
                //novo.setDataInicio(null);
                //novo.setDataTermino(null);
                novo.setFinanciamento(consulta.getInt("financiamento"));
                novo.setGrupoPesquisa(consulta.getString("grupoPesquisa"));
                novo.setNomeConvenio(consulta.getString("convenio"));
                novo.setNumeroBolsa(consulta.getInt("numeroBolsas"));
                novo.setOrientador(orientadorDAO.Abrir(consulta.getInt("idOrientador")));
                novo.setProjetoMultiCampi(consulta.getInt("projetoMulticampi"));
                novo.setResumo(consulta.getString("resumo"));
                novo.setTitulo(consulta.getString("titulo"));
                novo.setValorFinanciamento(consulta.getDouble("valorFinanciamento"));
                
                
            }
            return novo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
    
    
    }
    
    public List<ProjetoPesquisa> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_ProjetoPesquisa WHERE status = 1");
            ResultSet consuta = comando.executeQuery();
            List<CursoArea> lista = new LinkedList<>();
            while(consuta.next()){
                CursoArea novo = new CursoArea();
                novo.setIdCursoArea(consuta.getInt("idCursoArea"));
                novo.setNome(consuta.getString("nome"));
                novo.setSigla(consuta.getString("sigla"));
                
                
                /*
                 
                 
                 
                 
                 
                 
                 
                  ----------------------- CONTINUAR ----------------------------------
                 
                 
                 
                 
                 
                 
                 */
                
                
                
                lista.add(novo);
            }
            
            return lista;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
        
    
    
    
    }
}
