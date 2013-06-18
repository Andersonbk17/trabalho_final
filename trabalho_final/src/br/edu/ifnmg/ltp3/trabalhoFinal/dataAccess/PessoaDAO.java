/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Campus;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Email;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Pessoa;
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
public class PessoaDAO {
    private ConexaoBanco conexao;
    
    public PessoaDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(Pessoa obj) throws SQLException{
        try{
            if(obj.getIdPessoa() == 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_Pessoa(?,?,?,?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getCpf());
                comando.setString(3, obj.getRg());
                //comando.setDate(4, obj.getDataNascimento());
                comando.setString(5, obj.getOrgaoExpeditor());
                //comando.setDate(6, obj.getDataExpedicao());
                comando.setInt(7, obj.getCampus().getIdCampus());
                comando.setInt(8, obj.getCursoArea().getIdCursoArea());
                comando.setInt(9, obj.getNacionalidade().getIdNacionalida());
                comando.setInt(10, obj.getEstado().getIdEstado());
                
                comando.execute();
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall(""
                        + "CALL sp_PessoaAtualiza(?,?,?,?,?,?,?,?,?,?,?,?)");
                comando1.setString(1, obj.getNome());
                comando1.setInt(2, obj.getCpf());
                comando1.setString(3, obj.getRg());
                //comando1.setDate(4, obj.getDataNascimento());
                comando1.setString(5, obj.getOrgaoExpeditor());
                //comando1.setDate(6, obj.getDataExpedicao());
                comando1.setInt(7, obj.getCampus().getIdCampus());
                comando1.setInt(8, obj.getCursoArea().getIdCursoArea());
                comando1.setInt(9, obj.getNacionalidade().getIdNacionalida());
                comando1.setInt(10, obj.getEstado().getIdEstado());
                comando1.setInt(11, obj.getIdPessoa());
                
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
    /*
    public Pessoa Abrir(int idPessoa){
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * "
                    + "FROM Pessoa WHERE idPessoa = ?");
            comando.setInt(1, idPessoa);
            
            ResultSet consulta = comando.executeQuery();
            
            if(consulta.first()){
                Pessoa novo = new Pessoa();
                CampusDAO campusDAO = new CampusDAO();
                Campus campus = new Campus();
                
                
            
            
            }
            
        
        }catch(SQLException ex){
            ex.printStackTrace();
        
        }finally{
            conexao.getConexao().close();
        
        }
    
    
    
    
    
    }
    */
    public boolean Apagar(int idPessoa ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE Pessoa SET status = 0 WHERE idPessoa = ?");
            comando.setInt(1, idPessoa);
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


