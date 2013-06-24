/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.CronogramaAtividade;
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
public class CronogramaAtividadeDAO {
    private ConexaoBanco conexao;
    
    public CronogramaAtividadeDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    
    public boolean Salvar(CronogramaAtividade obj,int idPlanoTrabalho) throws SQLException{
        try{
            if(obj.getIdCronogramaAtividade() == 0){
               CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_CronogramaAtividade(?,?,?,?,?)");
               comando.setString(1, obj.getDescricao());
               comando.setInt(2, obj.getNumeroAtividade());
               //comando.setDate(3, null);
               //comando.setDate(4, null);
               comando.setInt(5, idPlanoTrabalho);
               comando.executeUpdate();
             }else{
               CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_CronogramaAtividadeAtualiza(?,?,?,?,?,?)");
               comando.setString(1, obj.getDescricao());
               comando.setInt(2, obj.getNumeroAtividade());
               //comando.setDate(3, null);
               //comando.setDate(4, null);
               comando.setInt(5, idPlanoTrabalho);
               comando.setInt(6, obj.getIdCronogramaAtividade());
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
    
    
    
    
    
    public CronogramaAtividade Abrir(int idCronogramaAtividade) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_CronogramaDeAtividade "
                    + "WHERE idCronogramaAtividade = ?");
            comando.setInt(1, idCronogramaAtividade);
            ResultSet consulta = comando.executeQuery();
            CronogramaAtividade novo = null;
            if(consulta.first()){
                novo = new CronogramaAtividade();
                novo.setIdCronogramaAtividade(idCronogramaAtividade);
                novo.setDescricao(consulta.getString("descricao"));
                novo.setNumeroAtividade(consulta.getInt("numeroAtividade"));
                //novo.setDataInicio(null);
                // novo.setDataTermino(null);
                
                
            }
            return novo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
    
    
    }
    
    public List<CronogramaAtividade> ListarTodos(int idPlanoTrabalho) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_CronogramaAtividade "
                    + "WHERE idPlanoDeTrabalho = ?");
            comando.setInt(1, idPlanoTrabalho);
            ResultSet consuta = comando.executeQuery();
            List<CronogramaAtividade> lista = new LinkedList<>();
            while(consuta.next()){
                CronogramaAtividade novo = new CronogramaAtividade();
                novo.setIdCronogramaAtividade(consuta.getInt("idCronogramaAtividade"));
                //novo.setDataInicio(const);
                //novo.setDataTermino(null);
                novo.setDescricao(consuta.getString("descricao"));
                novo.setNumeroAtividade(consuta.getInt("numeroAtividade"));
                
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
    
    
    public boolean Apagar(int idCronogramaAtividade) throws SQLException{
        try{
            CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_CronogramaAtividadeApagar(?)");
            comando.setInt(1, idCronogramaAtividade);
            comando.executeQuery();
                    
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            conexao.getConexao().close();
        }
    
    
    }
}
