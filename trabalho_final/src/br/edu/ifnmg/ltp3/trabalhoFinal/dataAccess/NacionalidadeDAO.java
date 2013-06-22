/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Nacionalidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Modric
 */
public class NacionalidadeDAO {
    private ConexaoBanco conexao;
    
    public NacionalidadeDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public Nacionalidade Abrir(int idNacionalidade) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_Nacionalidade WHERE idNacionalidade = ?");
            comando.setInt(1, idNacionalidade);
            ResultSet consulta = comando.executeQuery();
            Nacionalidade novo = null;
            if(consulta.first()){
                novo = new Nacionalidade();
                novo.setIdNacionalida(idNacionalidade);
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
    
    public List<Nacionalidade> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_Nacionalidade");
            ResultSet consuta = comando.executeQuery();
            List<Nacionalidade> lista = new LinkedList<>();
            while(consuta.next()){
                Nacionalidade novo = new Nacionalidade();
                novo.setIdNacionalida(consuta.getInt("idNacionalidade"));
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
