/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess;

import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Cidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Endereco;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Estado;
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
public class EnderecoDAO {
    private ConexaoBanco conexao;
    
    public EnderecoDAO(){
        conexao = new ConexaoBanco();
    }
    
    
    public boolean Salvar(Endereco obj, int idPessoa ) throws SQLException{
        try{
            if(obj.getIdEndereco()== 0){
                CallableStatement comando = conexao.getConexao().prepareCall("CALL sp_Endereco(?,?,?,?,?,?,?)");
                comando.setString(1, obj.getRua());
                comando.setString(2, obj.getBairro());
                comando.setInt(3, obj.getCep());
                comando.setInt(4, obj.getNumero());
                comando.setString(5, obj.getComplemento());
                comando.setInt(6, idPessoa);
                comando.setInt(7, obj.getCidade().getIdCidade());
                comando.execute();
            }else{
                CallableStatement comando1 = conexao.getConexao().prepareCall(""
                        + "CALL sp_EnderecoAtualiza(?,?,?,?,?,?,?)");
                comando1.setString(1, obj.getRua());
                comando1.setString(2, obj.getBairro());
                comando1.setInt(3, obj.getCep());
                comando1.setInt(4, obj.getNumero());
                comando1.setString(5, obj.getComplemento());
                comando1.setInt(6, idPessoa);
                comando1.setInt(7, obj.getCidade().getIdCidade());
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
    
    public List<Endereco> ListarTodos(int idPessoa) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(""
                    + "SELECT * FROM vw_Endereco WHERE idPessoa = ?  ");
            comando.setInt(1, idPessoa);
            ResultSet consulta = comando.executeQuery();
            List<Endereco> lista = new LinkedList<>();
            while(consulta.next()){
                Endereco novo = new Endereco();
                Cidade novoCidade = new Cidade();
                Estado novoEstado = new Estado();
                
                novo.setRua(consulta.getString("rua"));
                novo.setNumero(consulta.getInt("numero"));
                novo.setBairro(consulta.getString("bairro"));
                novo.setCep(consulta.getInt("cep"));
                novo.setComplemento(consulta.getString("complemento"));
                
                novoCidade.setIdCidade(consulta.getInt("idCidade"));
                novoCidade.setNome(consulta.getString("nome"));
                
                
                
                novoEstado.setIdEstado(consulta.getInt("idEstado"));
                novoEstado.setNome(consulta.getString("nomeEstado"));
                
                novoCidade.setEstado(novoEstado);
                
                novo.setCidade(novoCidade);
                
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
    
    public boolean Apagar(int idEndereco ) throws SQLException{
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement("CALL sp_EnderecoApaga(?)");
            comando.setInt(1, idEndereco);
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
