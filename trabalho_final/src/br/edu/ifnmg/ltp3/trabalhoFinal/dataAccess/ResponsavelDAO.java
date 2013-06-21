/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Responsavel;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lewandowsky
 */
public class ResponsavelDAO {
    private ConexaoBanco conexao;
    
    public ResponsavelDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(Responsavel obj ) throws SQLException{
        try{
            if(obj.getIdResponsavelAluno()== 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_Responsavel(?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getNomePai());
                comando.setString(2, obj.getRgPai());
                comando.setString(3, obj.getOrgaoExpedidorPai());
                comando.setInt(4, obj.getCpfPai());
                comando.setString(5, obj.getNomeMae());
                comando.setString(6, obj.getRgMae());
                comando.setString(7, obj.getOrgaoExpedidorMae());
                comando.setInt(8, obj.getCpfMae());
                comando.execute();
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall(""
                        + "CALL sp_ResponsavelAtualiza(?,?,?,?,?,?,?,?,?)");
                comando1.setString(1, obj.getNomePai());
                comando1.setString(2, obj.getRgPai());
                comando1.setString(3, obj.getOrgaoExpedidorPai());
                comando1.setInt(4, obj.getCpfPai());
                comando1.setString(5, obj.getNomeMae());
                comando1.setString(6, obj.getRgMae());
                comando1.setString(7, obj.getOrgaoExpedidorMae());
                comando1.setInt(8, obj.getCpfMae());
                comando1.setInt(9, obj.getIdResponsavelAluno());
                comando1.executeUpdate();
           }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            conexao.getConexao().close();
        }
    
    }
    
    
    public Responsavel Abrir(int idResponsavel) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * "
                    + "FROM vw_Responsavel WHERE idResponsavel = ?");
            comando.setInt(1, idResponsavel);
            
            ResultSet consulta = comando.executeQuery();
            
            
            if(consulta.first()){
                Responsavel novo = new Responsavel();
                novo.setCpfMae(consulta.getInt("cpfMae"));
                novo.setCpfPai(consulta.getInt("cpfResponsavel"));
                novo.setIdResponsavelAluno(consulta.getInt("idResponsavel"));
                novo.setNomeMae(consulta.getString("nomeMae"));
                novo.setNomePai(consulta.getString("nomeResponsavel"));
                novo.setOrgaoExpedidorMae(consulta.getString("orgaoExpeditorMae"));
                novo.setOrgaoExpedidorPai(consulta.getString("orgaoExpeditorResponsavel"));
                novo.setRgMae(consulta.getString("rgMae"));
                novo.setRgPai(consulta.getString("rgResponsavel"));
                
                return novo;
            
            }else return null;
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
   }
    
    
 
    public List<Responsavel> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM vw_Responsavel");
            
            ResultSet consulta = comando.executeQuery();
            List<Responsavel> lista = new LinkedList<>();
            while(consulta.next()){
                Responsavel novo = new Responsavel();
                
                novo.setCpfMae(consulta.getInt("cpfMae"));
                novo.setCpfPai(consulta.getInt("cpfResponsavel"));
                novo.setIdResponsavelAluno(consulta.getInt("idResponsavel"));
                novo.setNomePai(consulta.getString("nomeResponsavel"));
                novo.setOrgaoExpedidorMae(consulta.getString("orgaoExpeditorMae"));
                novo.setOrgaoExpedidorPai(consulta.getString("orgaoExpeditorResponsavel"));
                novo.setRgMae(consulta.getString("rgMae"));
                novo.setRgPai(consulta.getString("rgResponsavel"));
                              
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
    
    public boolean Apagar(int idResponsavel ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("CALL sp_ResponsavelApaga(?)");
            comando.setInt(1, idResponsavel);
            comando.executeUpdate();
            return true;
        }catch(SQLException ex){
           ex.printStackTrace();
           return false;
        }finally{
            conexao.getConexao().close();
        }
       
    }
}

