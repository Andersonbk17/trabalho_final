/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.EstadoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.NacionalidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.TelefoneDAO;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lewandowsky
 */
public class Teste {
    public static void main(String args[]) {
        List<Telefone> lista;// = new LinkedList<>();
        TelefoneDAO dao = new TelefoneDAO();
        Telefone aaa = new Telefone();
        
        aaa.setDdd(38);
        aaa.setNumero(123);
        
        try {
            
            lista = dao.ListarTodos(1);
            dao.Salvar(aaa, 1);
            System.out.print(lista);
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
}
