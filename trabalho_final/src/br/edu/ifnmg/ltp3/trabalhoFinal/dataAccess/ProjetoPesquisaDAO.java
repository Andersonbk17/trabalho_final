/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.ProjetoPesquisa;
import java.sql.CallableStatement;
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
    
    
    public boolean Salvar(ProjetoPesquisa obj) throws SQLException{
    try{

            if(obj.getIdProjetoPesquisa() == 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_ProjetoPesquisa(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
                comando.setString(1, obj.getTitulo());
                //comando.setDate(2, null);
                //comando.setDate(3, null);
                comando.setString(4, obj.getGrupoPesquisa());
                comando.setInt(5, obj.getAreConhecimento().getIdAreaConhecimento());
                comando.setInt(6, obj.getCampus().getIdCampus());
                comando.setString(7, obj.getResumo() ); //varificar pq é TEXT no banco e aki não tem a opcao
                comando.setInt(8, obj.getOrientador().getIdOrientador());
                comando.setInt(9, obj.getFinanciamento());
                comando.setInt(10, obj.getBolsa());
                comando.setInt(11, obj.getConvenio());
                comando.setDouble(12,obj.getValorFinanciamento());
                //comando.setDate(13, obj.getDataFinanciamento());
                comando.setInt(14, obj.getNumeroBolsa());
                comando.setString(15, obj.getAgenciaFinanciadora());
                comando.setString(16, obj.getNomeConvenio());
                comando.setInt(17,obj.getProjetoMultiCampi());
                
                
                
                comando.execute();
            }else{
                CallableStatement comando = conexao.getConexao().prepareCall("CALL "
                        + "sp_ProjetoPesquisaAtualiza(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
                comando.setString(1, obj.getTitulo());
                //comando.setDate(2, null);
                //comando.setDate(3, null);
                comando.setString(4, obj.getGrupoPesquisa());
                comando.setInt(5, obj.getAreConhecimento().getIdAreaConhecimento());
                comando.setInt(6, obj.getCampus().getIdCampus());
                comando.setString(7, obj.getResumo() ); //varificar pq é TEXT no banco e aki não tem a opcao
                comando.setInt(8, obj.getOrientador().getIdOrientador());
                comando.setInt(9, obj.getFinanciamento());
                comando.setInt(10, obj.getBolsa());
                comando.setInt(11, obj.getConvenio());
                comando.setDouble(12,obj.getValorFinanciamento());
                //comando.setDate(13, obj.getDataFinanciamento());
                comando.setInt(14, obj.getNumeroBolsa());
                comando.setString(15, obj.getAgenciaFinanciadora());
                comando.setString(16, obj.getNomeConvenio());
                comando.setInt(17,obj.getProjetoMultiCampi());
                comando.setInt(18, obj.getIdProjetoPesquisa());
                comando.executeUpdate();
           }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            conexao.getConexao().close();
        }
    
    
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
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_ProjetoPesquisa ");
            ResultSet consulta = comando.executeQuery();
            List<ProjetoPesquisa> lista = new LinkedList<>();
            while(consulta.next()){
                ProjetoPesquisa novo = new ProjetoPesquisa();
                AreaConhecimentoDAO areaDAO = new AreaConhecimentoDAO();
                CampusDAO campusDAO = new CampusDAO();
                OrientadorDAO orientadorDAO = new OrientadorDAO();
                
                novo.setIdProjetoPesquisa(consulta.getInt("idProjetoPesquisa"));
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
