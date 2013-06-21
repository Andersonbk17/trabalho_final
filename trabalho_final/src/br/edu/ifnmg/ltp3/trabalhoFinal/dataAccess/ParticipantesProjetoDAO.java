/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.LocalTrabalho;
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
public class ParticipantesProjetoDAO {
    private ConexaoBanco conexao;
    
    public ParticipantesProjetoDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(LocalTrabalho obj, int idAluno ) throws SQLException{
        try{
            if(obj.getIdlocalTrabalho()== 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_LocalDeTrabalho(?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getTelefone().getIdTelefone());
                comando.setInt(3, idAluno);
                comando.execute();
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall(""
                        + "CALL sp_LocalDeTrabalho(?,?,?,?)");
                comando1.setString(1, obj.getNome());
                comando1.setInt(2, obj.getTelefone().getIdTelefone());
                comando1.setInt(3, idAluno);
                comando1.setInt(4,obj.getIdlocalTrabalho());
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
    
    public List<LocalTrabalho> ListarTodos(int idAluno) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM vw_LocalTrabalho WHERE idAluno = ?");
            comando.setInt(1, idAluno);
            ResultSet consulta = comando.executeQuery();
            List<LocalTrabalho> lista = new LinkedList<>();
            while(consulta.next()){
                LocalTrabalho novo = new LocalTrabalho();
                TelefoneDAO novoTelefone = new TelefoneDAO();
                
                novo.setIdlocalTrabalho(consulta.getInt("idLocalTrabalho"));
                novo.setNome(consulta.getString("nome"));
                novo.setTelefone(novoTelefone.Abrir(consulta.getInt("idTelefone")));
                
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
                    + "UPDATE Telefone SET status = 0 WHERE idTelefone = ?");
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
