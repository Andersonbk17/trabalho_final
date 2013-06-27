/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Aluno;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Email;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Endereco;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Telefone;
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
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_Aluno(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setInt(2, obj.getCpf());
                comando.setString(3, obj.getRg());
                comando.setString(4, obj.getTituloEleitoral());
      
                java.sql.Date dataBd = new java.sql.Date(obj.getDataNascimento().getTime());
                comando.setDate(5, dataBd);
           
                comando.setString(6, obj.getOrgaoExpeditor());
               
                java.sql.Date dataBd2 = new java.sql.Date(obj.getDataExpedicao().getTime());
                comando.setDate(7, dataBd2);
               
                comando.setInt(8, obj.getCampus().getIdCampus());
                comando.setInt(9, obj.getCursoArea().getIdCursoArea());
                comando.setInt(10, obj.getNacionalidade().getIdNacionalida());
                comando.setInt(11, obj.getEstado().getIdEstado());
                comando.setString(12, obj.getSecaoEleitoral());
                comando.setString(13, obj.getZonaEleitoral());
                comando.setString(14, obj.getSituacaoMilitar());
                comando.setString(15, obj.getCertidaoMilitar());
                comando.setString(16, obj.getNomePai());
                comando.setString(17, obj.getRgPai());
                comando.setString(18, obj.getOrgaoExpedidorPai());
                comando.setInt(19, obj.getCpfPai());
                comando.setString(20, obj.getNomeMae());
                comando.setString(21, obj.getRgMae());
                comando.setString(22, obj.getOrgaoExpedidorMae());
                comando.setInt(23, obj.getCpfMae());
                comando.setInt(24, obj.getMatricula());
               
                comando.execute();
                
                
                PreparedStatement comando1 = conexao.getConexao().prepareStatement("SELECT MAX(idPessoa)  FROM vw_Aluno ");
                ResultSet rs = comando1.executeQuery();
                rs.first();
                
                EmailDAO emailDAO = new EmailDAO();
                for(Email e :obj.getEmail()){
                    emailDAO.Salvar(e, rs.getInt("MAX(idPessoa)"));
               }
                
                TelefoneDAO telefoneDAO = new TelefoneDAO();
                for(Telefone t :obj.getTelefone()){
                    telefoneDAO.Salvar(t, rs.getInt("MAX(idPessoa)"));
               }
                
                EnderecoDAO enderecoDAO = new EnderecoDAO();
                for(Endereco t :obj.getEndereco()){
                    enderecoDAO.Salvar(t, rs.getInt(("MAX(idPessoa)")));
               }
                
                
                
              
                
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall(""
                        + "CALL sp_AlunoAtualiza(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                comando1.setString(1, obj.getNome());
                comando1.setInt(2, obj.getCpf());
                comando1.setString(3, obj.getRg());
                comando1.setString(4, obj.getTituloEleitoral());
                
                java.sql.Date dataBd = new java.sql.Date(obj.getDataNascimento().getTime());
                comando1.setDate(5, dataBd);
           
                comando1.setString(6, obj.getOrgaoExpeditor());
               
                java.sql.Date dataBd2 = new java.sql.Date(obj.getDataExpedicao().getTime());
                comando1.setDate(7, dataBd2);
                
                comando1.setInt(8, obj.getCampus().getIdCampus());
                comando1.setInt(9, obj.getCursoArea().getIdCursoArea());
                comando1.setInt(10, obj.getNacionalidade().getIdNacionalida());
                comando1.setInt(11, obj.getEstado().getIdEstado());
                comando1.setString(12, obj.getSecaoEleitoral());
                comando1.setString(13, obj.getZonaEleitoral());
                comando1.setString(14, obj.getSituacaoMilitar());
                comando1.setString(15, obj.getCertidaoMilitar());
                comando1.setString(16, obj.getNomePai());
                comando1.setString(17, obj.getRgPai());
                comando1.setString(18, obj.getOrgaoExpedidorPai());
                comando1.setInt(19, obj.getCpfPai());
                comando1.setString(20, obj.getNomeMae());
                comando1.setString(21, obj.getRgMae());
                comando1.setString(22, obj.getOrgaoExpedidorMae());
                comando1.setInt(23, obj.getCpfMae());
                comando1.setInt(2, obj.getIdAluno());
                comando1.setInt(25, obj.getIdPessoa());
                comando1.setInt(26, obj.getMatricula());
                comando1.execute();
                
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
    
    public Aluno Abrir(int idAluno) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("SELECT * "
                    + "FROM Aluno WHERE idAluno = ?"); 
            comando.setInt(1, idAluno);
            ResultSet consulta = comando.executeQuery();
            Aluno novoAluno = null;
            if(consulta.first()){
                EmailDAO emails = new EmailDAO();
                TelefoneDAO telefones = new TelefoneDAO();
                EnderecoDAO enderecos = new EnderecoDAO();
                CampusDAO campus = new CampusDAO();
                CursoAreaDAO cursoArea = new CursoAreaDAO();
                NacionalidadeDAO nacionalidade = new NacionalidadeDAO();
                EstadoDAO estado = new EstadoDAO();
                PlanoTrabalhoDAO planoTrabalhoDAO = new PlanoTrabalhoDAO();
                LocalTrabalhoDAO localTrabalho = new LocalTrabalhoDAO();
                novoAluno = new Aluno();
                
                novoAluno.setCampus(campus.Abrir(consulta.getInt("idCampus")));
                novoAluno.setCertidaoMilitar(consulta.getString("certidaoMilitar"));
                novoAluno.setCpf(consulta.getInt("cpf"));
                novoAluno.setCpfMae(consulta.getInt("cpfMae"));
                novoAluno.setCpfPai(consulta.getInt("cpfResponsavel"));
                novoAluno.setCursoArea(cursoArea.Abrir(consulta.getInt("idCursoArea")));
                //novoAluno.setDataExpedicao(null);
                //novoAluno.setDataNascimento(null);
                novoAluno.setEmail(emails.ListarTodos(consulta.getInt("idPessoa")));
                novoAluno.setEndereco(enderecos.ListarTodos(consulta.getInt("idPessoa")));
                novoAluno.setEstado(estado.Abrir(consulta.getInt("idPessoa")));
                novoAluno.setIdAluno(idAluno);
                novoAluno.setIdPessoa(consulta.getInt("idPessoa"));
                novoAluno.setListaLocalTrabalho(localTrabalho.ListarTodos(idAluno));
                novoAluno.setMatricula(consulta.getInt("numeroMatricula"));
                novoAluno.setNacionalidade(nacionalidade.Abrir(consulta.getInt("idNacionalidade")));
                novoAluno.setNome(consulta.getString("nome"));
                novoAluno.setNomeMae(consulta.getString("nomeMae"));
                novoAluno.setNomePai(consulta.getString("nomeResponsavel"));
                novoAluno.setOrgaoExpedidorMae(consulta.getString("orgaoExpeditorMae"));
                novoAluno.setOrgaoExpedidorPai(consulta.getString("orgaoExpeditorResponsavel"));
                novoAluno.setOrgaoExpeditor(consulta.getString("orgaoExpeditor"));
                novoAluno.setPlanoTrabalho(planoTrabalhoDAO.Abrir(idAluno));
                novoAluno.setRg(consulta.getString("rg"));
                novoAluno.setRgMae(consulta.getString("rgMae"));
                novoAluno.setRgPai(consulta.getString("rgResponsavel"));
                novoAluno.setSecaoEleitoral(consulta.getString("secaoEleitoral"));
                novoAluno.setSituacaoMilitar(consulta.getString("situacaoMilitar"));
                novoAluno.setTelefone(telefones.ListarTodos(consulta.getInt("idPessoa")));
                novoAluno.setTituloEleitoral(consulta.getString("tituloEleitoral"));
                novoAluno.setZonaEleitoral(consulta.getString("zonaEleitoral"));
                
                
            }
        
        return novoAluno;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        
        }finally{
        
            conexao.getConexao().close();
                    
        
        }
    }
    
    
    
    public List<Aluno> ListarTodos() throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM vw_Aluno");
           
            ResultSet consulta = comando.executeQuery();
            List<Aluno> lista = new LinkedList<>();
            while(consulta.next()){
                
                EmailDAO emails = new EmailDAO();
                TelefoneDAO telefones = new TelefoneDAO();
                EnderecoDAO enderecos = new EnderecoDAO();
                CampusDAO campus = new CampusDAO();
                CursoAreaDAO cursoArea = new CursoAreaDAO();
                NacionalidadeDAO nacionalidade = new NacionalidadeDAO();
                EstadoDAO estado = new EstadoDAO();
                PlanoTrabalhoDAO planoTrabalhoDAO = new PlanoTrabalhoDAO();
                LocalTrabalhoDAO localTrabalho = new LocalTrabalhoDAO();
                Aluno novoAluno = new Aluno();
                
                novoAluno.setCampus(campus.Abrir(consulta.getInt("idCampus")));
                novoAluno.setCertidaoMilitar(consulta.getString("certidaoMilitar"));
                novoAluno.setCpf(consulta.getInt("cpf"));
                novoAluno.setCpfMae(consulta.getInt("cpfMae"));
                novoAluno.setCpfPai(consulta.getInt("cpfResponsavel"));
                novoAluno.setCursoArea(cursoArea.Abrir(consulta.getInt("idCursoArea")));
                //novoAluno.setDataExpedicao(null);
                //novoAluno.setDataNascimento(null);
                novoAluno.setEmail(emails.ListarTodos(consulta.getInt("idPessoa")));
                novoAluno.setEndereco(enderecos.ListarTodos(consulta.getInt("idPessoa")));
                novoAluno.setEstado(estado.Abrir(consulta.getInt("idPessoa")));
                novoAluno.setIdAluno(consulta.getInt("idAluno"));
                novoAluno.setIdPessoa(consulta.getInt("idPessoa"));
                novoAluno.setListaLocalTrabalho(localTrabalho.ListarTodos(consulta.getInt("idAluno")));
                novoAluno.setMatricula(consulta.getInt("numeroMatricula"));
                novoAluno.setNacionalidade(nacionalidade.Abrir(consulta.getInt("idNacionalidade")));
                novoAluno.setNome(consulta.getString("nome"));
                novoAluno.setNomeMae(consulta.getString("nomeMae"));
                novoAluno.setNomePai(consulta.getString("nomeResponsavel"));
                novoAluno.setOrgaoExpedidorMae(consulta.getString("orgaoExpeditorMae"));
                novoAluno.setOrgaoExpedidorPai(consulta.getString("orgaoExpeditorResponsavel"));
                novoAluno.setOrgaoExpeditor(consulta.getString("orgaoExpeditor"));
                novoAluno.setPlanoTrabalho(planoTrabalhoDAO.Abrir(consulta.getInt("idAluno")));
                novoAluno.setRg(consulta.getString("rg"));
                novoAluno.setRgMae(consulta.getString("rgMae"));
                novoAluno.setRgPai(consulta.getString("rgResponsavel"));
                novoAluno.setSecaoEleitoral(consulta.getString("secaoEleitoral"));
                novoAluno.setSituacaoMilitar(consulta.getString("situacaoMilitar"));
                novoAluno.setTelefone(telefones.ListarTodos(consulta.getInt("idPessoa")));
                novoAluno.setTituloEleitoral(consulta.getString("tituloEleitoral"));
                novoAluno.setZonaEleitoral(consulta.getString("zonaEleitoral"));
                
                
                lista.add(novoAluno);
            }
            return lista;
         }catch(SQLException ex){
               ex.printStackTrace();
               return null;
        }finally{
            conexao.getConexao().close();
        }
     }
    
    public boolean Apagar(int idPessoa, int idAluno ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("CALL sp_AlunoApagar(?,?)");
            comando.setInt(1, idPessoa);
            comando.setInt(1, idAluno);
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
