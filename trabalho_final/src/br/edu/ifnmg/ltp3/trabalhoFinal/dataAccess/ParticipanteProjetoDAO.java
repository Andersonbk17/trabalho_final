/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.ParticipanteProjeto;
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
public class ParticipanteProjetoDAO {
    private ConexaoBanco conexao;
    
    public ParticipanteProjetoDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(ParticipanteProjeto obj, int idProjeto ) throws SQLException{
        try{
            if(obj.getIdParticipanteProjeto()== 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_ParticipanteProjeto(?,?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getTitulacao());
                comando.setString(3, obj.getObservacao());
                comando.setInt(4, obj.getCampus().getIdCampus());
                comando.setInt(5, idProjeto);
                        
                comando.execute();
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall(""
                        + "CALL sp_ParticipanteProjetoAtualiza(?,?,?,?,?,?)");
                comando1.setString(1, obj.getNome());
                comando1.setString(2, obj.getTitulacao());
                comando1.setString(3, obj.getObservacao());
                comando1.setInt(4, obj.getCampus().getIdCampus());
                comando1.setInt(5, idProjeto);
                comando1.setInt(6, obj.getIdParticipanteProjeto());
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
    
    public List<ParticipanteProjeto> ListarTodos(int idProjetoPesquisa) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM vw_ParticipanteProjeto WHERE idProjetoPesquisa = ?");
            comando.setInt(1, idProjetoPesquisa);
            ResultSet consulta = comando.executeQuery();
            List<ParticipanteProjeto> lista = new LinkedList<>();
            while(consulta.next()){
                ParticipanteProjeto novo = new ParticipanteProjeto();
                CampusDAO novoCampus = new CampusDAO();
                novo.setCampus(novoCampus.Abrir(consulta.getInt("idCampus")));
                novo.setIdParticipanteProjeto(consulta.getInt("idParticipanteProjeto"));
                novo.setNome(consulta.getString("nome"));
                novo.setObservacao(consulta.getString("observacao"));
                novo.setTitulacao(consulta.getString("titulacao"));
                
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
    
    public List<ParticipanteProjeto> ListarTodosQueJaParticipu() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM vw_ParticipanteProjeto");
            
            ResultSet consulta = comando.executeQuery();
            List<ParticipanteProjeto> lista = new LinkedList<>();
            while(consulta.next()){
                ParticipanteProjeto novo = new ParticipanteProjeto();
                CampusDAO novoCampus = new CampusDAO();
                novo.setCampus(novoCampus.Abrir(consulta.getInt("idCampus")));
                novo.setIdParticipanteProjeto(consulta.getInt("idParticipanteProjeto"));
                novo.setNome(consulta.getString("nome"));
                novo.setObservacao(consulta.getString("observacao"));
                novo.setTitulacao(consulta.getString("titulacao"));
                
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
    
    
    
    public boolean Apagar(int idParticpanteProjeto ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE sp_ParticipanteProjetoApaga SET status = 0 WHERE idParticipanteProjeto = ?");
            comando.setInt(1, idParticpanteProjeto);
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
