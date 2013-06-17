/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Email;
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
public class EmailDAO {
    private ConexaoBanco conexao;
    
    public EmailDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(Email obj, int idPessoa ) throws SQLException{
        try{
            if(obj.getIdEmail() == 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_Email(?,?)");
                comando.setString(1, obj.getEnderecoEmail());
                comando.setInt(2, idPessoa);
                comando.execute();
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall(""
                        + "CALL sp_EmailAtualiza(?,?,?)");
                comando1.setString(1, obj.getEnderecoEmail());
                comando1.setInt(2, obj.getStatus());
                comando1.setInt(3, obj.getIdEmail());
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
    
    public List<Email> ListarTodos(int idPessoa) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM vw_EMAIL WHERE idPessoa = ? AND status = 1 ");
            comando.setInt(1, idPessoa);
            ResultSet consulta = comando.executeQuery();
            List<Email> lista = new LinkedList<>();
            while(consulta.next()){
                Email novo = new Email();
                novo.setEnderecoEmail(consulta.getString("endereco"));
                novo.setIdEmail(consulta.getInt("idEmail"));
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
    
    public boolean Apagar(int idEmail ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE Email SET status = 0 WHERE idEmail = ?");
            comando.setInt(1, idEmail);
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
