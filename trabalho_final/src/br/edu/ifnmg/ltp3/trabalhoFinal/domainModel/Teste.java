/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.domainModel;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.EstadoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.NacionalidadeDAO;
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
        List<Nacionalidade> lista = new LinkedList<>();
        NacionalidadeDAO dao = new NacionalidadeDAO();
        try {
            lista.add(dao.Abrir(33));
            System.out.print(lista);
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
}
