/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lewandowsky
 */
public class ConexaoBanco {
    private Connection conexao;
    
    public ConexaoBanco(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager
             //  .getConnection("jdbc:mysql://localhost:3306/trabalho","root","aluno");
            .getConnection("jdbc:mysql://localhost:3306/trabalho","root","170737");
            
            //conexao.setAutoCommit(false);
        
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        
      }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
}
