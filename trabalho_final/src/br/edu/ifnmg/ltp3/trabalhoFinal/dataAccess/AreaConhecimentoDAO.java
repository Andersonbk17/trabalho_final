/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.AreaConhecimento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Modric
 */
public class AreaConhecimentoDAO {
    private ConexaoBanco conexao;
    
    public AreaConhecimentoDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public AreaConhecimento Abrir(int idAreaConhecimento) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_AreaConhecimento "
                    + "WHERE idAreaConhecimento = ? ");
            comando.setInt(1, idAreaConhecimento);
            ResultSet consulta = comando.executeQuery();
            AreaConhecimento novo = null;
            if(consulta.first()){
                novo = new AreaConhecimento();
                novo.setIdAreaConhecimento(idAreaConhecimento);
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
    
    public List<AreaConhecimento> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM "
                    + "vw_AreaConhecimento WHERE status = 1");
            ResultSet consuta = comando.executeQuery();
            List<AreaConhecimento> lista = new LinkedList<>();
            while(consuta.next()){
                AreaConhecimento novo = new AreaConhecimento();
                novo.setIdAreaConhecimento(consuta.getInt("idAreaConhecimento"));
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
