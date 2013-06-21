/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lewandowsky
 */
public class LoginDAO {
    private ConexaoBanco conexao;
    
    public LoginDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public int Autenticar(String usuario,String senha) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * "
                    + "FROM usuarios WHERE idUsuario = ? AND senha = ?");
            ResultSet consulta = comando.executeQuery();
            int idUsuario = 0;
            if(consulta.first()){
                idUsuario = consulta.getInt("idUsuario");
            }
            return idUsuario;
        }catch(SQLException ex){
            ex.printStackTrace();
            return 0;
        }finally{
            conexao.getConexao().close();
        }
    
    }
}
