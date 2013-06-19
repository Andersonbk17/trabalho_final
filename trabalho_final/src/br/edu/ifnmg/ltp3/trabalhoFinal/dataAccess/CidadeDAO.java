/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Cidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Estado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Modric
 */
public class CidadeDAO {
    private ConexaoBanco conexao;
    
    public CidadeDAO(){
        conexao = new ConexaoBanco();
    }
    
    public List<Cidade> ListarTodas() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM "
                    + "vw_Cidade");
            ResultSet consulta = comando.executeQuery();
            List<Cidade> lista = new LinkedList<>();
            while(consulta.next()){
                Cidade novo = new Cidade();
                Estado novoEstado = new Estado();
                
                novo.setIdCidade(consulta.getInt("idCidade"));
                novo.setNome(consulta.getString("Cidade"));
                
                novoEstado.setIdEstado(consulta.getInt("idEstado"));
                novoEstado.setNome(consulta.getString("Estado"));
                        
                novo.setEstado(novoEstado);
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
