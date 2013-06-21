/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Estado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Modric
 */
public class EstadoDAO {
    private ConexaoBanco conexao;
    
    public EstadoDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public Estado Abrir(int idEstado) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Estado WHERE idEstado = ?");
            comando.setInt(1, idEstado);
            ResultSet consulta = comando.executeQuery();
            Estado novo = null;
            if(consulta.first()){
                novo = new Estado();
                novo.setIdEstado(idEstado);
                novo.setNome(consulta.getString("nome"));
             }
            return novo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
    
    
    }
    
    public List<Estado> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM Estado ");
            ResultSet consuta = comando.executeQuery();
            List<Estado> lista = new LinkedList<>();
            while(consuta.next()){
                Estado novo = new Estado();
                novo.setIdEstado(consuta.getInt("idEstado"));
                novo.setNome(consuta.getString("nome"));
                
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
