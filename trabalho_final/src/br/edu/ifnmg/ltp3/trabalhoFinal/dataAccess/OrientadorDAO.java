/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Email;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Endereco;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Orientador;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Telefone;
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
public class OrientadorDAO {
    private ConexaoBanco conexao;
    
    public OrientadorDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(Orientador obj) throws SQLException{
        try{
           if(obj.getIdOrientador() == 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_Orientador(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getCpf());
                comando.setString(3, obj.getRg());
                //comando.setDate(4, obj.getDataNascimento());
                comando.setString(5, obj.getOrgaoExpeditor());
                //comando.setString(6, obj.getDataExpedicao());
                comando.setInt(7, obj.getCampus().getIdCampus());
                comando.setInt(8, obj.getCursoArea().getIdCursoArea());
                comando.setInt(9, obj.getNacionalidade().getIdNacionalida());
                comando.setInt(10, obj.getEstado().getIdEstado());
                comando.setInt(11, obj.getMatriculaSiape());
                comando.setString(12, obj.getLocalPermanencia());
                comando.setString(13, obj.getFormacaoAcademica());
                comando.setString(14, obj.getTituloAcademico());
               
                comando.execute();
                
                
                PreparedStatement comando1 = conexao.getConexao().prepareStatement("SELECT MAX(idOrientador)  FROM vw_Orientador ");
                ResultSet rs = comando1.executeQuery();
                
                EmailDAO emailDAO = new EmailDAO();
                for(Email e :obj.getEmail()){
                    emailDAO.Salvar(e, rs.getInt("MAX(idOrientador)"));
               }
                
                TelefoneDAO telefoneDAO = new TelefoneDAO();
                for(Telefone t :obj.getTelefone()){
                    telefoneDAO.Salvar(t, rs.getInt("MAX(idOrientador)"));
               }
                
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                for(Endereco t :obj.getEndereco()){
                    enderecoDAO.Salvar(t, rs.getInt(("MAX(idOrientador)")));
               }
                
                
            }else{
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_Orientador(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getCpf());
                comando.setString(3, obj.getRg());
                //comando.setDate(4, obj.getDataNascimento());
                comando.setString(5, obj.getOrgaoExpeditor());
                //comando.setString(6, obj.getDataExpedicao());
                comando.setInt(7, obj.getCampus().getIdCampus());
                comando.setInt(8, obj.getCursoArea().getIdCursoArea());
                comando.setInt(9, obj.getNacionalidade().getIdNacionalida());
                comando.setInt(10, obj.getEstado().getIdEstado());
                comando.setInt(11, obj.getMatriculaSiape());
                comando.setString(12, obj.getLocalPermanencia());
                comando.setString(13, obj.getFormacaoAcademica());
                comando.setString(14, obj.getTituloAcademico());
                comando.setInt(15, obj.getIdPessoa());
                comando.setInt(16, obj.getIdOrientador());
                comando.execute();
                
              
                EmailDAO emailDAO = new EmailDAO();
                for(Email e :obj.getEmail()){
                    emailDAO.Salvar(e, obj.getIdPessoa());
               }
                
                TelefoneDAO telefoneDAO = new TelefoneDAO();
                for(Telefone t :obj.getTelefone()){
                    telefoneDAO.Salvar(t, obj.getIdPessoa());
               }
                
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                for(Endereco t :obj.getEndereco()){
                    enderecoDAO.Salvar(t, obj.getIdPessoa());
               }
                
           }
            return true;
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }finally{
            conexao.getConexao().close();
        }
    
    }
    
    public Orientador Abrir(int idOrientador) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * "
                    + "FROM vw_Orientador WHERE idOrientador = ?"); 
            comando.setInt(1, idOrientador);
            ResultSet consulta = comando.executeQuery();
            Orientador novo = null;
            if(consulta.first()){
                EmailDAO emails = new EmailDAO();
                TelefoneDAO telefones = new TelefoneDAO();
                EnderecoDAO enderecos = new EnderecoDAO();
                CampusDAO campus = new CampusDAO();
                CursoAreaDAO cursoArea = new CursoAreaDAO();
                NacionalidadeDAO nacionalidade = new NacionalidadeDAO();
                EstadoDAO estado = new EstadoDAO();
                novo = new Orientador();
                
                novo.setCampus(campus.Abrir(consulta.getInt("idCampus")));
                novo.setCpf(consulta.getInt("cpf"));
                novo.setCursoArea(cursoArea.Abrir(consulta.getInt("idCursoArea")));
                novo.setDataExpedicao(consulta.getDate("dataEpedicao"));
                novo.setDataNascimento(consulta.getDate("dataNascimento"));
                novo.setEmail(emails.ListarTodos(consulta.getInt("idPessoa")));
                novo.setEndereco(enderecos.ListarTodos(consulta.getInt("idPessoa")));
                novo.setEstado(estado.Abrir(consulta.getInt("idEstado")));
                novo.setFormacaoAcademica(consulta.getString("formacaoUniversitaria"));
                novo.setIdOrientador(idOrientador);
                novo.setIdPessoa(consulta.getInt("idPessoa"));
                novo.setLocalPermanencia(consulta.getString("localPermanencia"));
                novo.setMatriculaSiape(consulta.getInt("matriculaSiape"));
                novo.setNacionalidade(nacionalidade.Abrir(consulta.getInt("idNacionaldade")));
                novo.setNome(consulta.getString("nome"));
                novo.setOrgaoExpeditor(consulta.getString("OrgaoExpeditor"));
                novo.setRg(consulta.getString("rg"));
                novo.setTelefone(telefones.ListarTodos(consulta.getInt("idPessoa")));
                novo.setTituloAcademico(consulta.getString("tituloAcademico"));
                
            
            
            }
        
            return novo;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        
        }finally{
        
            conexao.getConexao().close();
                    
        
        }
    }
 
    
    
    
    public List<Orientador> ListarTodos() throws SQLException {
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM vw_Orientador");
           
            ResultSet consulta = comando.executeQuery();
            List<Orientador> lista = new LinkedList<> ();
            while(consulta.next()){
                EmailDAO emails = new EmailDAO();
                TelefoneDAO telefones = new TelefoneDAO();
                EnderecoDAO enderecos = new EnderecoDAO();
                CampusDAO campus = new CampusDAO();
                CursoAreaDAO cursoArea = new CursoAreaDAO();
                NacionalidadeDAO nacionalidade = new NacionalidadeDAO();
                EstadoDAO estado = new EstadoDAO();
                Orientador novo = new Orientador();
                
                novo.setCampus(campus.Abrir(consulta.getInt("idCampus")));
                novo.setCpf(consulta.getInt("cpf"));
                novo.setCursoArea(cursoArea.Abrir(consulta.getInt("idCursoArea")));
                novo.setDataExpedicao(consulta.getDate("dataEpedicao"));
                novo.setDataNascimento(consulta.getDate("dataNascimento"));
                novo.setEmail(emails.ListarTodos(consulta.getInt("idPessoa")));
                novo.setEndereco(enderecos.ListarTodos(consulta.getInt("idPessoa")));
                novo.setEstado(estado.Abrir(consulta.getInt("idEstado")));
                novo.setFormacaoAcademica(consulta.getString("formacaoUniversitaria"));
                novo.setIdOrientador(consulta.getInt("idOrientador"));
                novo.setIdPessoa(consulta.getInt("idPessoa"));
                novo.setLocalPermanencia(consulta.getString("localPermanencia"));
                novo.setMatriculaSiape(consulta.getInt("matriculaSiape"));
                novo.setNacionalidade(nacionalidade.Abrir(consulta.getInt("idNacionaldade")));
                novo.setNome(consulta.getString("nome"));
                novo.setOrgaoExpeditor(consulta.getString("OrgaoExpeditor"));
                novo.setRg(consulta.getString("rg"));
                novo.setTelefone(telefones.ListarTodos(consulta.getInt("idPessoa")));
                novo.setTituloAcademico(consulta.getString("tituloAcademico"));
                
                
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
    
    public boolean Apagar(int idPesoa,int idOrientador ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("CALL sp_OrientadorApaga(?,?)");
            comando.setInt(1, idPesoa);
            comando.setInt(2, idOrientador);
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