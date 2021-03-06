/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.ltp3.trabalhoFinal.interfaceUsuario;

import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.AlunoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CampusDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.CursoAreaDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.EstadoDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.dataAccess.NacionalidadeDAO;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Aluno;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Campus;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Cidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.CursoArea;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Email;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Endereco;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Estado;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.LocalTrabalho;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Nacionalidade;
import br.edu.ifnmg.ltp3.trabalhoFinal.domainModel.Telefone;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class ifrmAlunoCad extends javax.swing.JInternalFrame {

    /**
     * Creates new form ifrmCampusCad
     */
    Aluno aluno = new Aluno();
    List<Cidade> cidades;
    List<Estado> estados;
    List<CursoArea> cursos;
    List<Campus> campus;
    List<Nacionalidade> nacionalidades;
  
    AlunoDAO alunoDao = new AlunoDAO();
    
    public Date formatarData(String data) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
        
        Date dataFormatada = format.parse(data);
        
        return dataFormatada; 
    }
    
    private void addTelefone(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("DDD");
        model.addColumn("Telefone");
        
        for(Telefone te : aluno.getTelefone()){
            Vector v = new Vector();
            v.add(0, te.getDdd());
            v.add(1, te.getNumero());
            model.addRow(v);
        }
        jtbListaTeleAluno.setModel(model);
    }
    
     private void addEmail(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("Endereço de E-mail");
 
        for(Email em : aluno.getEmail()){
            Vector v = new Vector();
            v.add(em.getEnderecoEmail());
            model.addRow(v);
        }
        jtbListaEmailAluno.setModel(model);
    }
     
     private void addEndereco(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("Rua");
        model.addColumn("Num");
        model.addColumn("Bairro");
        model.addColumn("Cep");
        model.addColumn("Complemento");
        model.addColumn("Cidade");
        model.addColumn("Estado");
 
        for(Endereco en : aluno.getEndereco()){
            Vector v = new Vector();
            v.add(0,en.getRua());
            v.add(1,en.getNumero());
            v.add(2,en.getBairro());
            v.add(3,en.getCep());
            v.add(4,en.getComplemento());
            v.add(5,en.getCidade().getNome());
            v.add(6,en.getCidade().getEstado().getNome());
            model.addRow(v);
        }
        jtbListaEndAluno.setModel(model);
    }
    
     private void addLocalTrabalho(){
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("Local trabalho");
        model.addColumn("Telefone");
       

        for(LocalTrabalho lt : aluno.getListaLocalTrabalho()){
            Vector v = new Vector();
            v.add(0,lt.getNome());
            v.add(1,lt.getTelefone().getNumero());
            model.addRow(v);
        }
        jtbListaLocTrabalhoAluno.setModel(model);
    }
    
    public ifrmAlunoCad() throws SQLException {
        initComponents();
        CidadeDAO cidadeDao = new CidadeDAO();
        EstadoDAO estadoDao = new EstadoDAO();
        CursoAreaDAO cursoAreaDao = new CursoAreaDAO(); 
        CampusDAO campusDao = new CampusDAO();
        NacionalidadeDAO nacionalidadeDao = new NacionalidadeDAO();
      
        //Cidade
        cidades = cidadeDao.ListarTodas();
        jcbCidadeAluno.removeAllItems();
        for(Cidade ci: cidades){
            jcbCidadeAluno.addItem(ci);
        }
        
        //Estado
        estados = estadoDao.ListarTodos();
        jcbAlunoEstado.removeAllItems();
        for(Estado es: estados){
            jcbAlunoEstado.addItem(es);
        }
        
        //Campus
        campus = campusDao.ListarTodos();
        jcbAlunoCampus.removeAllItems();
        for(Campus ca: campus){
            jcbAlunoCampus.addItem(ca);
        }
        
        //Nacionalidade
        nacionalidades = nacionalidadeDao.ListarTodos();
        jcbAlunoNascionalidade.removeAllItems();
        for(Nacionalidade na: nacionalidades){
            jcbAlunoNascionalidade.addItem(na);
        }
        
        //Curso
        cursos = cursoAreaDao.ListarTodos();
        jcbAlunoCurso.removeAllItems();
        for(CursoArea cu: cursos){
            jcbAlunoCurso.addItem(cu);
        }
        
        
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gjrtrabalho = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalvarAluno = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAlunoNome = new javax.swing.JTextField();
        txtAlunoRg = new javax.swing.JTextField();
        txtAlunoCpf = new javax.swing.JTextField();
        txtAlunoDataExp = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            txtAlunoDataExp = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jLabel7 = new javax.swing.JLabel();
        txtAlunoOrgaoEx = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbAlunoCampus = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jcbAlunoNascionalidade = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jcbAlunoCurso = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jcbAlunoEstado = new javax.swing.JComboBox();
        jLabel35 = new javax.swing.JLabel();
        txtAlunoDataNasc = new javax.swing.JTextField();
        try{
            javax.swing.text.MaskFormatter data= new javax.swing.text.MaskFormatter("##/##/####");
            txtAlunoDataNasc = new javax.swing.JFormattedTextField(data);
        }
        catch (Exception e){
        }
        jPanel3 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        txtAlunoSessao = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtAlunoTitulo = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtAlunoZona = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtAlunoCertidaoMilitar = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtAlunoSituaçãoMilitar = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtAlunoMatricula = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        lblAlunoLocalTrab = new javax.swing.JLabel();
        txtAlunoLocalTrabalho = new javax.swing.JTextField();
        txtAlunoTelefoneTrabalho = new javax.swing.JTextField();
        lblAlunoFoneTrab = new javax.swing.JLabel();
        btnAlunoAddLocalTrab = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbListaLocTrabalhoAluno = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtResponsavelNomePai = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtResponsavelRgPai = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtResponsavelOrgaoExpPai = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtResponsavelCpfPai = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtResponsavelNomeMae = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtResponsavelRgMae = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtResponsavelOrgaoExpMae = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtResponsavelCpfMae = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbListaTeleAluno = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txtAlunoddd = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtAlunoTelefone = new javax.swing.JTextField();
        btnaddTelefoneAluno = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbListaEndAluno = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtAlunoRua = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtAlunoBairro = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtAlunoCep = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtAlunoNumero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtAlunoComplemento = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jcbCidadeAluno = new javax.swing.JComboBox();
        btnaddEnderecoAluno = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbListaEmailAluno = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtAlunoEmail = new javax.swing.JTextField();
        btnAddEmailAluno = new javax.swing.JButton();
        btnCancelarAluno = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(102, 204, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cadastrar Aluno");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ifl.png"))); // NOI18N

        btnSalvarAluno.setText("Salvar");
        btnSalvarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlunoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel4.setText("Rg");

        jLabel5.setText("Cpf");

        jLabel6.setText("Data Exp.");

        jLabel7.setText("Orgão Exp.");

        jLabel8.setText("Campus");

        jcbAlunoCampus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Nacionalidade");

        jcbAlunoNascionalidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Curso");

        jcbAlunoCurso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Estado");

        jcbAlunoEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel35.setText("Data Nasc.");

        txtAlunoDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlunoDataNascActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAlunoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(8, 8, 8)
                                .addComponent(txtAlunoOrgaoEx))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAlunoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAlunoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlunoDataExp)
                                    .addComponent(txtAlunoDataNasc))))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbAlunoNascionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbAlunoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbAlunoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbAlunoCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(193, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAlunoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtAlunoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAlunoOrgaoEx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtAlunoDataExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlunoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel35)
                    .addComponent(txtAlunoDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jcbAlunoNascionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jcbAlunoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAlunoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jcbAlunoCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Geral", jPanel2);

        jLabel29.setText("Titulo");

        jLabel30.setText("Sessão");

        jLabel31.setText("Zona");

        jLabel32.setText("Situação Militar");

        jLabel33.setText("Certidão Militar");

        jLabel34.setText("Matricula");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAlunoSessao, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txtAlunoZona)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAlunoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAlunoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAlunoCertidaoMilitar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAlunoSituaçãoMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txtAlunoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAlunoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel29))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtAlunoSituaçãoMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(txtAlunoCertidaoMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtAlunoSessao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtAlunoZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aluno", jPanel3);

        gjrtrabalho.add(jRadioButton1);
        jRadioButton1.setText("Sim");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        gjrtrabalho.add(jRadioButton2);
        jRadioButton2.setText("Não");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel36.setText("Está Trabalhando?");

        lblAlunoLocalTrab.setText("Local");

        txtAlunoLocalTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlunoLocalTrabalhoActionPerformed(evt);
            }
        });

        txtAlunoTelefoneTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlunoTelefoneTrabalhoActionPerformed(evt);
            }
        });

        lblAlunoFoneTrab.setText("Fone");

        btnAlunoAddLocalTrab.setText("Adicionar");
        btnAlunoAddLocalTrab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlunoAddLocalTrabActionPerformed(evt);
            }
        });

        jtbListaLocTrabalhoAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbListaLocTrabalhoAluno.setEnabled(false);
        jScrollPane4.setViewportView(jtbListaLocTrabalhoAluno);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel36))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblAlunoLocalTrab)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAlunoLocalTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lblAlunoFoneTrab)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAlunoTelefoneTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAlunoAddLocalTrab)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlunoLocalTrab)
                    .addComponent(txtAlunoLocalTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlunoTelefoneTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlunoFoneTrab)
                    .addComponent(btnAlunoAddLocalTrab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Trabalho", jPanel8);

        jLabel21.setText("Nome Pai");

        jLabel22.setText("Rg Pai");

        jLabel23.setText("O. Exp.");

        jLabel24.setText("Cpf");

        jLabel25.setText("Nome Mãe");

        jLabel26.setText("Rg Mãe");

        jLabel27.setText("O. Exp.");

        jLabel28.setText("Cpf");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel21))
                        .addComponent(jLabel25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtResponsavelNomePai)
                    .addComponent(txtResponsavelCpfPai)
                    .addComponent(txtResponsavelNomeMae)
                    .addComponent(txtResponsavelCpfMae, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtResponsavelRgPai)
                    .addComponent(txtResponsavelRgMae, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtResponsavelOrgaoExpPai, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtResponsavelOrgaoExpMae)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtResponsavelNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(txtResponsavelRgPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtResponsavelOrgaoExpPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtResponsavelCpfPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtResponsavelNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(txtResponsavelRgMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtResponsavelOrgaoExpMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtResponsavelCpfMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Responsável", jPanel7);

        jtbListaTeleAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbListaTeleAluno.setEnabled(false);
        jScrollPane3.setViewportView(jtbListaTeleAluno);

        jLabel19.setText("DDD");

        jLabel20.setText("Telefone");

        btnaddTelefoneAluno.setText("Adicionar");
        btnaddTelefoneAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddTelefoneAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAlunoddd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAlunoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnaddTelefoneAluno)
                .addGap(50, 50, 50))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtAlunoddd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtAlunoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnaddTelefoneAluno)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Telefone", jPanel4);

        jtbListaEndAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbListaEndAluno.setEnabled(false);
        jScrollPane2.setViewportView(jtbListaEndAluno);

        jLabel13.setText("Rua");

        jLabel14.setText("Bairro");

        jLabel15.setText("Cep");

        jLabel16.setText("Numero");

        jLabel17.setText("Complemento");

        txtAlunoComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlunoComplementoActionPerformed(evt);
            }
        });

        jLabel18.setText("Cidade");

        jcbCidadeAluno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnaddEnderecoAluno.setText("Adicionar");
        btnaddEnderecoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddEnderecoAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAlunoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAlunoCep)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAlunoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtAlunoNumero))))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtAlunoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbCidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnaddEnderecoAluno)
                        .addGap(50, 50, 50))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtAlunoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtAlunoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAlunoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(txtAlunoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtAlunoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jcbCidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaddEnderecoAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Endereço", jPanel5);

        jtbListaEmailAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbListaEmailAluno.setEnabled(false);
        jScrollPane1.setViewportView(jtbListaEmailAluno);

        jLabel12.setText("Email");

        btnAddEmailAluno.setText("Adicionar");
        btnAddEmailAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmailAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAlunoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddEmailAluno)
                .addGap(50, 50, 50))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtAlunoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnAddEmailAluno)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Email", jPanel6);

        btnCancelarAluno.setText("Cancelar");
        btnCancelarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAlunoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(299, 299, 299)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jTabbedPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCancelarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnSalvarAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarAluno)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAlunoComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlunoComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlunoComplementoActionPerformed

    private void btnAddEmailAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmailAlunoActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(rootPane,"Deseja realmente adicionar esse email?")==0){
            Email email = new Email();
            email.setEnderecoEmail(txtAlunoEmail.getText());

            aluno.addEmail(email);
            JOptionPane.showMessageDialog(rootPane, "Email adicionado");
            addEmail();
            
            txtAlunoEmail.setText(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ação cancelada");
        }
    }//GEN-LAST:event_btnAddEmailAlunoActionPerformed

    private void btnaddTelefoneAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddTelefoneAlunoActionPerformed
        // TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(rootPane,"Deseja realmente adicionar esse telefone?")==0){
            Telefone telefone = new Telefone();
            telefone.setDdd(Integer.parseInt(txtAlunoddd.getText()));
            telefone.setNumero(Integer.parseInt(txtAlunoTelefone.getText()));

            aluno.addTelefone(telefone);
            JOptionPane.showMessageDialog(rootPane, "Telefone adicionado");
            addTelefone();
            
            txtAlunoddd.setText(null);
            txtAlunoTelefone.setText(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ação cancelada");
        }
    }//GEN-LAST:event_btnaddTelefoneAlunoActionPerformed

    private void btnaddEnderecoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddEnderecoAlunoActionPerformed
        // TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(rootPane,"Deseja realmente adicionar esse endereco?")==0){
            Endereco endereco = new Endereco();
            
            Cidade c = (Cidade)jcbCidadeAluno.getSelectedItem();
   
            endereco.setRua(txtAlunoRua.getText());
            endereco.setNumero(Integer.parseInt(txtAlunoNumero.getText()));
            endereco.setBairro(txtAlunoBairro.getText());
            endereco.setCep(Integer.parseInt(txtAlunoCep.getText()));
            endereco.setComplemento(txtAlunoComplemento.getText());
            endereco.setCidade(c);
            
            aluno.addEndereco(endereco);
            JOptionPane.showMessageDialog(rootPane, "Endereco adicionado");
            addEndereco();
            
            txtAlunoRua.setText(null);
            txtAlunoNumero.setText(null);
            txtAlunoBairro.setText(null);
            txtAlunoCep.setText(null);
            txtAlunoComplemento.setText(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ação cancelada");
        }
    }//GEN-LAST:event_btnaddEnderecoAlunoActionPerformed

    private void btnCancelarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAlunoActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja cancelar a operação?")==0){
            JOptionPane.showMessageDialog(rootPane, "Operação cancelada");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Continuar de onde parou.");
        }
    }//GEN-LAST:event_btnCancelarAlunoActionPerformed

    private void btnSalvarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlunoActionPerformed
        // TODO add your handling code here:
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja realmente salvar esses dados?")==0){
            
            CursoArea cu = (CursoArea) jcbAlunoCurso.getSelectedItem();
            Campus ca = (Campus) jcbAlunoCampus.getSelectedItem();
            Nacionalidade na = (Nacionalidade) jcbAlunoNascionalidade.getSelectedItem();
            Estado es = (Estado) jcbAlunoEstado.getSelectedItem();
            
            aluno.setMatricula(Integer.parseInt(txtAlunoMatricula.getText()));
            aluno.setNome(txtAlunoNome.getText());
            aluno.setCpf(Integer.parseInt(txtAlunoCpf.getText()));
            aluno.setRg(txtAlunoRg.getText());
            aluno.setOrgaoExpeditor(txtAlunoOrgaoEx.getText());
            
            //Data Nascimento
            try {
                //.setData(DataF(txtNascimentoClienteEditar.getText()));
                aluno.setDataNascimento(formatarData(txtAlunoDataNasc.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ifrmAlunoCad.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Data Expedição Rg
            try {
                //.setData(DataF(txtNascimentoClienteEditar.getText()));
                aluno.setDataExpedicao(formatarData(txtAlunoDataExp.getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ifrmAlunoCad.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            aluno.setTituloEleitoral(txtAlunoTitulo.getText());
            aluno.setZonaEleitoral(txtAlunoZona.getText());
            aluno.setSecaoEleitoral(txtAlunoSessao.getText());
            aluno.setCampus(ca);
            aluno.setCursoArea(cu);
            aluno.setNacionalidade(na);
            aluno.setEstado(es);
            
            //Dados dos responsaveis legais pelo aluno
            aluno.setNomePai(txtResponsavelNomePai.getText());
            aluno.setCpfPai(Integer.parseInt(txtResponsavelCpfPai.getText()));
            aluno.setRgPai(txtResponsavelRgPai.getText());
            aluno.setOrgaoExpedidorPai(txtResponsavelOrgaoExpPai.getText());
            aluno.setNomeMae(txtResponsavelNomeMae.getText());
            aluno.setCpfMae(Integer.parseInt(txtResponsavelCpfMae.getText()));
            aluno.setRgMae(txtResponsavelRgMae.getText());
            aluno.setOrgaoExpedidorMae(txtResponsavelOrgaoExpMae.getText());
            //----
           
            try {
                if(alunoDao.Salvar(aluno)){
                    JOptionPane.showMessageDialog(rootPane, "Dados foram salvos com sucesso.");
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao salvar os dados.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ifrmAlunoCad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            txtAlunoNome.setText(null);
            txtAlunoRg.setText(null);
            txtAlunoOrgaoEx.setText(null);
            txtAlunoDataExp.setText(null);
            txtAlunoDataNasc.setText(null);
            txtAlunoCpf.setText(null);
            txtAlunoMatricula.setText(null);
            txtAlunoCertidaoMilitar.setText(null);
            txtAlunoSituaçãoMilitar.setText(null);
            txtAlunoTitulo.setText(null);
            txtAlunoSessao.setText(null);
            txtAlunoZona.setText(null);
            txtResponsavelNomePai.setText(null);
            txtResponsavelNomeMae.setText(null);
            txtResponsavelCpfMae.setText(null);
            txtResponsavelCpfPai.setText(null);
            txtResponsavelRgMae.setText(null);
            txtResponsavelOrgaoExpMae.setText(null);
            txtResponsavelRgPai.setText(null);
            txtResponsavelOrgaoExpPai.setText(null);
           
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro ao salvar os dados, consulte o administrador do sistema.");
        }
    }//GEN-LAST:event_btnSalvarAlunoActionPerformed

    private void txtAlunoDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlunoDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlunoDataNascActionPerformed

    private void txtAlunoLocalTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlunoLocalTrabalhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlunoLocalTrabalhoActionPerformed

    private void txtAlunoTelefoneTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlunoTelefoneTrabalhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlunoTelefoneTrabalhoActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        aluno.setTrabalhoStatus(1);
        txtAlunoLocalTrabalho.setVisible(true);
        txtAlunoTelefoneTrabalho.setVisible(true);
        btnAlunoAddLocalTrab.setVisible(true);
        lblAlunoLocalTrab.setVisible(true);
        lblAlunoFoneTrab.setVisible(true);
        //Limpar os campos
        txtAlunoLocalTrabalho.setText(null);
        txtAlunoTelefoneTrabalho.setText(null);
    
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        aluno.setTrabalhoStatus(2);
        //Bloquear os campos
        txtAlunoLocalTrabalho.setVisible(false);
        txtAlunoTelefoneTrabalho.setVisible(false);
        lblAlunoLocalTrab.setVisible(false);
        lblAlunoFoneTrab.setVisible(false);
        btnAlunoAddLocalTrab.setVisible(false);
         //limpar os  campos
        txtAlunoLocalTrabalho.setText(null);
        txtAlunoTelefoneTrabalho.setText(null);
       
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnAlunoAddLocalTrabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlunoAddLocalTrabActionPerformed
        // TODO add your handling code here:
         if(JOptionPane.showConfirmDialog(rootPane,"Deseja realmente adicionar esse Local de Trabalho?")==0){
            LocalTrabalho localtrab = new LocalTrabalho();
            Telefone fone = new Telefone();
            
            localtrab.setNome(txtAlunoLocalTrabalho.getText());
            fone.setNumero(Integer.parseInt(txtAlunoTelefoneTrabalho.getText()));
            localtrab.setTelefone(fone);
            
            aluno.addLocalTrabalho(localtrab);
            
            JOptionPane.showMessageDialog(rootPane, "Local de Trabalho adicionado");
            addLocalTrabalho();
            
            txtAlunoLocalTrabalho.setText(null);
            txtAlunoTelefoneTrabalho.setText(null);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Ação cancelada");
        }
    }//GEN-LAST:event_btnAlunoAddLocalTrabActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmailAluno;
    private javax.swing.JButton btnAlunoAddLocalTrab;
    private javax.swing.JButton btnCancelarAluno;
    private javax.swing.JButton btnSalvarAluno;
    private javax.swing.JButton btnaddEnderecoAluno;
    private javax.swing.JButton btnaddTelefoneAluno;
    private javax.swing.ButtonGroup gjrtrabalho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox jcbAlunoCampus;
    private javax.swing.JComboBox jcbAlunoCurso;
    private javax.swing.JComboBox jcbAlunoEstado;
    private javax.swing.JComboBox jcbAlunoNascionalidade;
    private javax.swing.JComboBox jcbCidadeAluno;
    private javax.swing.JTable jtbListaEmailAluno;
    private javax.swing.JTable jtbListaEndAluno;
    private javax.swing.JTable jtbListaLocTrabalhoAluno;
    private javax.swing.JTable jtbListaTeleAluno;
    private javax.swing.JLabel lblAlunoFoneTrab;
    private javax.swing.JLabel lblAlunoLocalTrab;
    private javax.swing.JTextField txtAlunoBairro;
    private javax.swing.JTextField txtAlunoCep;
    private javax.swing.JTextField txtAlunoCertidaoMilitar;
    private javax.swing.JTextField txtAlunoComplemento;
    private javax.swing.JTextField txtAlunoCpf;
    private javax.swing.JTextField txtAlunoDataExp;
    private javax.swing.JTextField txtAlunoDataNasc;
    private javax.swing.JTextField txtAlunoEmail;
    private javax.swing.JTextField txtAlunoLocalTrabalho;
    private javax.swing.JTextField txtAlunoMatricula;
    private javax.swing.JTextField txtAlunoNome;
    private javax.swing.JTextField txtAlunoNumero;
    private javax.swing.JTextField txtAlunoOrgaoEx;
    private javax.swing.JTextField txtAlunoRg;
    private javax.swing.JTextField txtAlunoRua;
    private javax.swing.JTextField txtAlunoSessao;
    private javax.swing.JTextField txtAlunoSituaçãoMilitar;
    private javax.swing.JTextField txtAlunoTelefone;
    private javax.swing.JTextField txtAlunoTelefoneTrabalho;
    private javax.swing.JTextField txtAlunoTitulo;
    private javax.swing.JTextField txtAlunoZona;
    private javax.swing.JTextField txtAlunoddd;
    private javax.swing.JTextField txtResponsavelCpfMae;
    private javax.swing.JTextField txtResponsavelCpfPai;
    private javax.swing.JTextField txtResponsavelNomeMae;
    private javax.swing.JTextField txtResponsavelNomePai;
    private javax.swing.JTextField txtResponsavelOrgaoExpMae;
    private javax.swing.JTextField txtResponsavelOrgaoExpPai;
    private javax.swing.JTextField txtResponsavelRgMae;
    private javax.swing.JTextField txtResponsavelRgPai;
    // End of variables declaration//GEN-END:variables
}
