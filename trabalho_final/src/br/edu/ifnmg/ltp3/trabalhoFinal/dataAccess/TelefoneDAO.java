/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Telefone;
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
public class TelefoneDAO {
    private ConexaoBanco conexao;
    
    public TelefoneDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(Telefone obj, int idPessoa ) throws SQLException{
        try{
            if(obj.getIdTelefone()== 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_Telefone(?,?,?)");
                comando.setInt(1, obj.getDdd());
                comando.setInt(2, obj.getNumero());
                comando.setInt(3, idPessoa);
                comando.execute();
                comando.close();
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall(""
                        + "CALL sp_TelefoneAtualiza(?,?,?)");
                comando1.setInt(1, obj.getDdd());
                comando1.setInt(2, obj.getNumero());
                comando1.setInt(3, obj.getIdTelefone());
                comando1.executeUpdate();
           }
            return true;
            
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            //conexao.getConexao().close();
        }
    
    }
    
    
    public boolean Salvar(Telefone obj ) throws SQLException{
        try{
            if(obj.getIdTelefone()== 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_Telefone(?,?,?)");
                comando.setInt(1, obj.getDdd());
                comando.setInt(2, obj.getNumero());
                comando.setInt(3, 0);
                comando.execute();
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall(""
                        + "CALL sp_TelefoneAtualiza(?,?,?)");
                comando1.setInt(1, obj.getDdd());
                comando1.setInt(2, obj.getNumero());
                comando1.setInt(3, obj.getIdTelefone());
                comando1.executeUpdate();
           }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            //conexao.getConexao().close();
        }
    
    }
    
    
    
    public Telefone Abrir(int idTelefone) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_Telefone WHERE idTelefone = ?");
            comando.setInt(1, idTelefone);
            ResultSet consulta = comando.executeQuery();
            Telefone novo = null;
            if(consulta.first()){
                novo = new Telefone();
                novo.setDdd(consulta.getInt("ddd"));
                novo.setIdTelefone(idTelefone);
                novo.setNumero(consulta.getInt("numero"));
            }
            return novo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        
        }finally{
            //conexao.getConexao().close();
        }
    
    
    }
    
    public List<Telefone> ListarTodos(int idPessoa) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM vw_Telefone WHERE idPessoa = ? ");
            comando.setInt(1, idPessoa);
            ResultSet consulta = comando.executeQuery();
            List<Telefone> lista = new LinkedList<>();
            while(consulta.next()){
                Telefone novo = new Telefone();
                novo.setDdd(consulta.getInt("ddd"));
                novo.setNumero(consulta.getInt("numero"));
                novo.setIdTelefone(consulta.getInt("idTelefone"));
                
                lista.add(novo);
            }
            
            return lista;
         }catch(SQLException ex){
               ex.printStackTrace();
               return null;
        }finally{
            //conexao.getConexao().close();
        }
     }
    
    public boolean Apagar(int idTelefone ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("CALL sp_TelefoneApaga(?)");
            comando.setInt(1, idTelefone);
            comando.executeUpdate();
            return true;
        }catch(SQLException ex){
           ex.printStackTrace();
           return false;
        }finally{
            //conexao.getConexao().close();
        }
    
    
    }
}
