/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Email;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.PlanoTrabalho;
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
public class PlanoTrabalhoDAO {
    private ConexaoBanco conexao;
    
    public PlanoTrabalhoDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(PlanoTrabalho obj, int idAluno,int idProjetoPesquisa ) throws SQLException{
        try{
            if(obj.getIdPlanoTrabalho() == 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_PlanoDeTrabalho(?,?,?,?,?,?,?,?)");
                comando.setInt(1, idAluno);
                comando.setInt(2, idProjetoPesquisa);
                comando.setString(3, obj.getIntroducao());
                comando.setString(4, obj.getJustificativa());
                comando.setString(5, obj.getObjetivo());
                comando.setString(6, obj.getMetodologia());
                comando.setString(7, obj.getResultadoEsperado());
                comando.setString(8, obj.getReferenciaBibliografica());
                comando.execute();
            }else{
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_PlanoDeTrabalhoAtualiza(?,?,?,?,?,?,?,?,?)");
                comando.setInt(1, idAluno);
                comando.setInt(2, idProjetoPesquisa);
                comando.setString(3, obj.getIntroducao());
                comando.setString(4, obj.getJustificativa());
                comando.setString(5, obj.getObjetivo());
                comando.setString(6, obj.getMetodologia());
                comando.setString(7, obj.getResultadoEsperado());
                comando.setString(8, obj.getReferenciaBibliografica());
                comando.setInt(9, obj.getIdPlanoTrabalho());
                comando.execute();
           }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            conexao.getConexao().close();
        }
    
    }
    
    public PlanoTrabalho Abrir(int idPlanoTrabalho) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * FROM vw_PlanoDeTrabalho WHERE idPlanoTrabalho");
            ResultSet consulta = comando.executeQuery();
            PlanoTrabalho novo = null;
            if(consulta.first()){
                novo = new PlanoTrabalho();
                CronogramaAtividadeDAO croonogramaDAO =  new CronogramaAtividadeDAO();
                novo.setCronogramaAtividade(croonogramaDAO.ListarTodos(idPlanoTrabalho));
                //novo.setDataFinal(null);
                //novo.setDataInicial(null);
                novo.setIdPlanoTrabalho(idPlanoTrabalho);
                novo.setIntroducao(consulta.getString("introducao"));
                novo.setJustificativa(consulta.getString("jutificativa"));
                novo.setMetodologia(consulta.getString("metodologia"));
                novo.setObjetivo(consulta.getString("objetivo"));
                novo.setReferenciaBibliografica(consulta.getString("referenciasBibliograficas"));
                novo.setResultadoEsperado(consulta.getString("resultadosEsperados"));
                
            
            }
            return novo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }finally{
            conexao.getConexao().close();
        }
    
    
    }
    
    public boolean Apagar(int idPlanoTrabalho ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("CALL sp_PlanoDeTrabalhoApaga(?)");
            comando.setInt(1, idPlanoTrabalho);
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
