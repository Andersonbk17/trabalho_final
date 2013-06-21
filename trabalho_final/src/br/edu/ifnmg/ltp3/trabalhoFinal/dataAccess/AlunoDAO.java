/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Aluno;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lewandowsky
 */
public class AlunoDAO {
    private ConexaoBanco conexao;
    
    public AlunoDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(Aluno obj) throws SQLException{
        try{
            if(obj.getIdAluno() == 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_Aluno(?,?,?,?,?,?,?,"
                        + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getCpf());
                comando.setString(3, obj.getRg());
                comando.setString(4, obj.getTituloEleitoral());
                //comando.setString(5, obj.getDataNascimento());
                comando.setString(6, obj.getOrgaoExpeditor());
                //comando.setString(7, obj.getDataExpedicao());
                comando.setInt(8, obj.getCampus().getIdCampus());
                comando.setInt(9, obj.getCursoArea().getIdCursoArea());
                comando.setInt(10, obj.getNacionalidade().getIdNacionalida());
                comando.setInt(11, obj.getEstado().getIdEstado());
                comando.setString(12, obj.getSecaoEleitoral());
                comando.setString(13, obj.getZonaEleitoral());
                comando.setString(14, obj.getSituacaoMilitar());
                comando.setString(15, obj.getCertidaoMilitar());
                comando.setString(16, obj.getResponsavel().getNomePai());
                comando.setString(17, obj.getResponsavel().getRgPai());
                comando.setString(18, obj.getResponsavel().getOrgaoExpedidorPai());
                comando.setInt(19, obj.getResponsavel().getCpfPai());
                comando.setString(20, obj.getResponsavel().getNomeMae());
                comando.setString(21, obj.getResponsavel().getRgMae());
                comando.setString(22, obj.getResponsavel().getOrgaoExpedidorMae());
                comando.setInt(23, obj.getResponsavel().getCpfMae());
                comando.setInt(24, obj.getMatricula());
               
                
                
                
                comando.execute();
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall(""
                        + "CALL sp_AlunoAtualiza(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                comando1.setString(1, obj.getNome());
                comando1.setInt(2, obj.getCpf());
                comando1.setString(3, obj.getRg());
                comando1.setString(4, obj.getTituloEleitoral());
                //comando1.setString(5, obj.getDataNascimento());
                comando1.setString(6, obj.getOrgaoExpeditor());
                //comando1.setString(7, obj.getDataExpedicao());
                comando1.setInt(8, obj.getCampus().getIdCampus());
                comando1.setInt(9, obj.getCursoArea().getIdCursoArea());
                comando1.setInt(10, obj.getNacionalidade().getIdNacionalida());
                comando1.setInt(11, obj.getEstado().getIdEstado());
                comando1.setString(12, obj.getSecaoEleitoral());
                comando1.setString(13, obj.getZonaEleitoral());
                comando1.setString(14, obj.getSituacaoMilitar());
                comando1.setString(15, obj.getCertidaoMilitar());
                comando1.setString(16, obj.getResponsavel().getNomePai());
                comando1.setString(17, obj.getResponsavel().getRgPai());
                comando1.setString(18, obj.getResponsavel().getOrgaoExpedidorPai());
                comando1.setInt(19, obj.getResponsavel().getCpfPai());
                comando1.setString(20, obj.getResponsavel().getNomeMae());
                comando1.setString(21, obj.getResponsavel().getRgMae());
                comando1.setString(22, obj.getResponsavel().getOrgaoExpedidorMae());
                comando1.setInt(23, obj.getResponsavel().getCpfMae());
                comando1.setInt(24, obj.getIdAluno());
                comando1.setInt(25, obj.getMatricula());
           }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            conexao.getConexao().close();
        }
    
    }
    
    public Aluno Abrir(int idAluno) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * "
                    + "FROM Aluno WHERE idAluno = ?"); //criar a view com inner join de pessoa com aluno
            comando.setInt(1, idAluno);
            ResultSet consulta = comando.executeQuery();
            
            if(consulta.first()){
                EmailDAO emails = new EmailDAO();
                TelefoneDAO telefones = new TelefoneDAO();
                EnderecoDAO enderecos = new EnderecoDAO();
                CampusDAO campus = new CampusDAO();
                CursoAreaDAO cursoArea = new CursoAreaDAO();
                NacionalidadeDAO nacionalidade = new NacionalidadeDAO();
                Aluno novo = new Aluno();
                
                novo.setIdAluno(consulta.getInt("idAluno"));
                novo.setIdPessoa(consulta.getInt("idPessoa"));
                novo.setCertidaoMilitar(consulta.getString("certidaoMilitar"));
                novo.setCpf(consulta.getInt("cpf"));
                //novo.setDataExpedicao(null);
                novo.setCursoArea(cursoArea.Abrir(consulta.getInt("idCursoArea")));
                //novo.setDataNascimento(null);
                novo.setMatricula(consulta.getInt("matricula"));
                novo.setNacionalidade(nacionalidade.Abrir(consulta.getInt("idNacionalidade")));
                novo.setNaturalidade(null);
                
                novo.setEmail(emails.ListarTodos(novo.getIdPessoa()));
                novo.setEndereco(enderecos.ListarTodos(novo.getIdPessoa()));
                novo.setTelefone(telefones.ListarTodos(novo.getIdPessoa()));
                novo.setCampus(campus.Abrir(consulta.getInt("idCampus")));
                
                
                /* -------------- CONTINUAR --------------------------*/
                
                
            
            
            
            }
        
        
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        
        }finally{
        
            conexao.getConexao().close();
                    
        
        }
        return null;
    
    
    
    
    }
    
    
    
    public List<String> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM vw_Aluno");
           
            ResultSet consulta = comando.executeQuery();
            List<String> lista = new ArrayList<>();
            while(consulta.next()){
                                
                lista.add(consulta.getString("nome"));
            }
            return lista;
         }catch(SQLException ex){
               ex.printStackTrace();
               return null;
        }finally{
            conexao.getConexao().close();
        }
     }
    
    public boolean Apagar(int idEmail ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "UPDATE Email SET status = 0 WHERE idEmail = ?");
            comando.setInt(1, idEmail);
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