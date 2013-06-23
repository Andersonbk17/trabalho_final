/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.CronogramaAtividade;
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
public class CronogramaAtividadeDAO {
    private ConexaoBanco conexao;
    
    public CronogramaAtividadeDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public CronogramaAtividade Abrir(int idCronogramaAtividade) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_CronogramaDeAtividade "
                    + "WHERE idCronogramaAtividade = ?");
            comando.setInt(1, idCronogramaAtividade);
            ResultSet consulta = comando.executeQuery();
            CronogramaAtividade novo = null;
            if(consulta.first()){
                novo = new CronogramaAtividade();
                novo.setIdCronogramaAtividade(idCronogramaAtividade);
                //novo.setDataAtividade(null); //setar a data
                novo.setDescricao(consulta.getString("descricao"));
                novo.setNumeroAtividade(consulta.getInt("nuemroAtividade"));
                novo.setPlanoTrabalho(null);
                
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
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_CursoArea ");
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
