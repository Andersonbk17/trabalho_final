/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.CursoArea;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Modric
 */
public class CursoAreaDAO {
    private ConexaoBanco conexao;
    
    public CursoAreaDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public CursoArea Abrir(int idCursoArea) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM CursoArea WHERE idCursoArea = ? AND status = 1");
            comando.setInt(1, idCursoArea);
            ResultSet consulta = comando.executeQuery();
            CursoArea novo = null;
            if(consulta.first()){
                novo = new CursoArea();
                novo.setIdCursoArea(idCursoArea);
                novo.setNome(consulta.getString("nome"));
                novo.setSigla(consulta.getString("sigla"));
                
            }
            return novo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
    
    
    }
    
    public List<CursoArea> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM CursoArea WHERE status = 1");
            ResultSet consuta = comando.executeQuery();
            List<CursoArea> lista = new LinkedList<>();
            while(consuta.next()){
                CursoArea novo = new CursoArea();
                novo.setIdCursoArea(consuta.getInt("idCursoArea"));
                novo.setNome(consuta.getString("nome"));
                novo.setSigla(consuta.getString("sigla"));
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
