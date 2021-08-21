
package view;

import controller.daoFuncionario;
import controller.daoItemProduto;
import controller.daoItemServico;
import controller.daoOrdemServico;
import controller.daoProduto;
import controller.daoServico;
import controller.daoVeiculo;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Funcionario;
import model.ItemProduto;
import model.ItemServico;
import model.OrdemServico;
import model.Produto;
import model.Servico;
import model.Veiculo;
import org.eclipse.persistence.history.HistoryPolicy;

public class dialogOrdemServico extends javax.swing.JDialog {

        
    DateTimeFormatter formato   = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    daoOrdemServico daoOS       = new daoOrdemServico();
    daoItemProduto daoItProduto = new daoItemProduto();
    daoItemServico daoItServico = new daoItemServico();
    
    //
    private List<ItemProduto> listItensProduto = new LinkedList<>();
    private List<ItemServico> listItensServico = new LinkedList<>();
    
    //Carrega Combo de Veículos
    private void loadComboVeiculo() {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(new daoVeiculo().read().toArray());
        comboVeiculo.setModel(cbm);
    }
    
    //Carrega Combo de Veículos
    private void loadComboFuncionario() {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(new daoFuncionario().read().toArray());
        comboFuncionario.setModel(cbm);
    }
    
    //Carrega Combo de Produtos
    private void loadComboProduto() {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(new daoProduto().read().toArray());
        comboProduto.setModel(cbm);
    }
    
    //Carrega Combo de Serviços
    private void loadComboServico() {
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(new daoServico().read().toArray());
        comboServico.setModel(cbm);
    }
    
    //Carrega Tables
    private void loadTableOS() {
        tableOrdemServico.setModel(new MyTableModel(OrdemServico.class, daoOS.read(), tableOrdemServico));
    }
    
    private void loadTableProduto() {
        tableItemProduto.setModel(new MyTableModel(ItemProduto.class, this.listItensProduto, tableItemProduto));
    }
    private void loadTableProduto(OrdemServico ordemServico) {
        tableItemProduto.setModel(new MyTableModel(ItemProduto.class, daoItProduto.read(ordemServico), tableItemProduto));
    }
    
    private void loadTableServico() {
        tableItemServico.setModel(new MyTableModel(ItemServico.class, this.listItensServico, tableItemServico));
    }
    private void loadTableServico(OrdemServico ordemServico) {
        tableItemServico.setModel(new MyTableModel(ItemServico.class, daoItServico.read(ordemServico), tableItemServico));
    }
    
    //
    private void clearComponentsAll() {
        textId.setText("");
        comboVeiculo.setSelectedIndex(0);
        comboFuncionario.setSelectedIndex(0);
        textDataEntrada.setText("");
        textDataSaida.setText("");
        textValor.setText("0");
        textDesconto.setText("0");
        textValorFinal.setText("0");
        checkBoxPago.setSelected(false);
        
        //
        comboProduto.setSelectedIndex(0);
        textQuantidade.setText("");
        textValorProduto.setText("0");
        
        //
        comboServico.setSelectedIndex(0);
        textValorServico.setText("0");
        comboVeiculo.requestFocus();
    }
    
    private void clearComponentsProduto() {
        comboProduto.setSelectedIndex(0);
        textQuantidade.setText("");
        comboProduto.requestFocus();
    }
    
    private void clearComponentsServico() {
        comboServico.setSelectedIndex(0);
        comboServico.requestFocus();
    }
    
    //Preenche campos
    private void fillComponents(OrdemServico ordemServico){
        textId.setText(ordemServico.getId() + "");
        comboVeiculo.setSelectedItem(ordemServico.getVeiculo());
        comboFuncionario.setSelectedItem(ordemServico.getFuncionario());
        textDataEntrada.setText(ordemServico.getDataEntrada().format(formato));
        textDataSaida.setText(ordemServico.getDataSaida() != null ? ordemServico.getDataSaida().format(formato) : "");
        textValor.setText(ordemServico.getValor() + "");
        textDesconto.setText(ordemServico.getDesconto()+ "");
        textValorFinal.setText(ordemServico.getValorFinal()+ "");
        checkBoxPago.setSelected(ordemServico.isPago());
    }
    
    //Cálculos
    private double getValor() {
        double total = 0;
        if (!listItensProduto.isEmpty()) {
            for (ItemProduto itemProduto : listItensProduto) {
                total += (itemProduto.getQuantidade() * itemProduto.getValor());
            }
        }
        if (!listItensServico.isEmpty()) {
            for (ItemServico itemServico : listItensServico) {
                total+= itemServico.getValor();
            }
        }
        
        return total;
    }
    
    private double getValorFinal() {
        double valorFinal = 0;
        valorFinal = getValor() - (textDesconto.equals("") ? 0 : Double.parseDouble(textDesconto.getText()));
        
        return valorFinal;
    }
    
    
    
    
    /**
     * Creates new form dialogOrdemServico
     */
    public dialogOrdemServico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        comboVeiculo = new javax.swing.JComboBox<>();
        comboFuncionario = new javax.swing.JComboBox<>();
        textDataEntrada = new javax.swing.JFormattedTextField();
        textDataSaida = new javax.swing.JFormattedTextField();
        textValor = new javax.swing.JTextField();
        textDesconto = new javax.swing.JTextField();
        textValorFinal = new javax.swing.JTextField();
        checkBoxPago = new javax.swing.JCheckBox();
        btnNovaOS = new javax.swing.JButton();
        btnSalvarOS = new javax.swing.JButton();
        btnAplicarDesconto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOrdemServico = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboProduto = new javax.swing.JComboBox<>();
        textQuantidade = new javax.swing.JTextField();
        textValorProduto = new javax.swing.JTextField();
        btnNovoProduto = new javax.swing.JButton();
        btnAdicionarProduto = new javax.swing.JButton();
        btnRemoverProduto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboServico = new javax.swing.JComboBox<>();
        textValorServico = new javax.swing.JTextField();
        btnNovoServico = new javax.swing.JButton();
        btnAdicionarServico = new javax.swing.JButton();
        btnRemoverServico = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableItemProduto = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableItemServico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordem de Serviço");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordem de Serviço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel1.setText("Código:");

        jLabel2.setText("Veículo:");

        jLabel3.setText("Funcionário:");

        jLabel4.setText("Data Entrada:");

        jLabel5.setText("Data Saída:");

        jLabel6.setText("Valor:");

        jLabel7.setText("Desconto:");

        jLabel8.setText("Valor Final:");

        textId.setEditable(false);
        textId.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        comboVeiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        try {
            textDataEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textDataEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        try {
            textDataSaida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textDataSaida.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        textValor.setEditable(false);
        textValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        textDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textDescontoFocusLost(evt);
            }
        });

        textValorFinal.setEditable(false);
        textValorFinal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        checkBoxPago.setText("Pago");

        btnNovaOS.setText("Nova OS");
        btnNovaOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaOSActionPerformed(evt);
            }
        });

        btnSalvarOS.setText("Salvar OS");
        btnSalvarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarOSActionPerformed(evt);
            }
        });

        btnAplicarDesconto.setText("Aplicar Desconto");
        btnAplicarDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarDescontoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(43, 43, 43)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNovaOS)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkBoxPago, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSalvarOS)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(btnAplicarDesconto)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(comboVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNovaOS)
                            .addComponent(btnSalvarOS))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(textDataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(textDataSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textValorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBoxPago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAplicarDesconto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableOrdemServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableOrdemServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOrdemServicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableOrdemServico);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel9.setText("Produto:");

        jLabel10.setText("Quantidade:");

        jLabel11.setText("Valor:");

        comboProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProdutoItemStateChanged(evt);
            }
        });

        textQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        textValorProduto.setEditable(false);
        textValorProduto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnNovoProduto.setText("Novo Produto");
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });

        btnAdicionarProduto.setText("Adicionar Produto");
        btnAdicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProdutoActionPerformed(evt);
            }
        });

        btnRemoverProduto.setText("Remover Produto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnNovoProduto)
                                .addGap(37, 37, 37)
                                .addComponent(btnAdicionarProduto))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(311, 311, 311)
                                .addComponent(btnRemoverProduto))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(textQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoProduto)
                    .addComponent(btnAdicionarProduto)
                    .addComponent(btnRemoverProduto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Serviços", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel12.setText("Serviço:");

        jLabel13.setText("Valor:");

        comboServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboServico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboServicoItemStateChanged(evt);
            }
        });

        textValorServico.setEditable(false);
        textValorServico.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnNovoServico.setText("Novo Serviço");
        btnNovoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoServicoActionPerformed(evt);
            }
        });

        btnAdicionarServico.setText("Adicionar Serviço");
        btnAdicionarServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarServicoActionPerformed(evt);
            }
        });

        btnRemoverServico.setText("Remover Serviço");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboServico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textValorServico, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNovoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(btnAdicionarServico)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(btnRemoverServico, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(comboServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textValorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoServico)
                    .addComponent(btnAdicionarServico)
                    .addComponent(btnRemoverServico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableItemProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableItemProduto);

        tableItemServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableItemServico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.loadTableOS();
        this.loadTableProduto();
        this.loadTableServico();
        this.loadComboFuncionario();
        this.loadComboProduto();
        this.loadComboServico();
        this.loadComboVeiculo();
        this.clearComponentsAll();
        
        //
        Produto iProduto = (Produto)comboProduto.getSelectedItem();
        textValorProduto.setText(iProduto.getValorVenda() + "");
        
        //
        Servico iServico = (Servico)comboServico.getSelectedItem();
        textValorServico.setText(iServico.getPreco() + "");
    }//GEN-LAST:event_formWindowOpened

    private void btnNovaOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaOSActionPerformed
        this.clearComponentsAll();
        this.listItensProduto.clear();
        this.listItensServico.clear();
        this.loadTableProduto();
        this.loadTableServico();
    }//GEN-LAST:event_btnNovaOSActionPerformed

    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        this.clearComponentsProduto();
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    private void btnNovoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoServicoActionPerformed
        this.clearComponentsServico();
    }//GEN-LAST:event_btnNovoServicoActionPerformed

    private void btnAdicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProdutoActionPerformed
        double quantidade = 0;
        double valor      = 0;
        
        try{
            quantidade = Double.parseDouble(textQuantidade.getText());
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor da quantidade é inválido.");
            textQuantidade.requestFocus();
            return;
        }
        
        try{
            valor = Double.parseDouble(textValorProduto.getText());
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor é inválido.");
            textValorProduto.requestFocus();
            return;
        }
        
        ItemProduto itemProd = new ItemProduto(0, null, (Produto)comboProduto.getSelectedItem(), quantidade, valor);
        
        listItensProduto.add(itemProd);
        this.loadTableProduto();
        
        //
        //DecimalFormat formato = new DecimalFormat("#.##0,00");
        textValor.setText(getValor() + "");
        textValorFinal.setText(getValorFinal() + "");
        this.clearComponentsProduto();
    }//GEN-LAST:event_btnAdicionarProdutoActionPerformed

    private void comboProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProdutoItemStateChanged
        Produto iProduto = (Produto)comboProduto.getSelectedItem();
        textValorProduto.setText(iProduto.getValorVenda() + "");
    }//GEN-LAST:event_comboProdutoItemStateChanged

    private void btnAdicionarServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarServicoActionPerformed
        double valor      = 0;
        
        try{
            valor = Double.parseDouble(textValorServico.getText());
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Valor é inválido.");
            textValorServico.requestFocus();
            return;
        }
        
        ItemServico itemServ = new ItemServico(0, null, (Servico)comboServico.getSelectedItem(), valor);
        
        listItensServico.add(itemServ);
        this.loadTableServico();
        
        //
        //DecimalFormat formato = new DecimalFormat("#.##0,00");
        textValor.setText(getValor() + "");
        textValorFinal.setText(getValorFinal() + "");
        this.clearComponentsServico();
    }//GEN-LAST:event_btnAdicionarServicoActionPerformed

    private void comboServicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboServicoItemStateChanged
        Servico iServico = (Servico)comboServico.getSelectedItem();
        textValorServico.setText(iServico.getPreco() + "");
    }//GEN-LAST:event_comboServicoItemStateChanged

    private void textDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textDescontoFocusLost
        if (Double.parseDouble(textDesconto.getText()) > Double.parseDouble(textValor.getText())) {
            JOptionPane.showMessageDialog(null, "O valor do desconto não pode ser maior que o valor.");
            textDesconto.requestFocus();
            textValorFinal.setText("0");
            return;
        }
        textValorFinal.setText(this.getValorFinal() + "");
    }//GEN-LAST:event_textDescontoFocusLost

    private void btnAplicarDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarDescontoActionPerformed
        double valorDesconto = 0;
        try{
            valorDesconto = Double.parseDouble(textDesconto.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Insira números.");
            textDesconto.requestFocus();
            textDesconto.setText("0");
            return;
        }
        double valorFinal = getValorFinal();
        if (valorFinal < 0) {
            JOptionPane.showMessageDialog(null, "O desconto não pode ser maior que o valor da Ordem. \nFavor inserir um valor de desconto válido.");
            textDesconto.requestFocus();
            textDesconto.setText("0");
            valorFinal = getValor() - (valorDesconto < 0 ? 0 : valorDesconto);
            return;
        }
        if(Double.parseDouble(textDesconto.getText()) < 0){
            JOptionPane.showMessageDialog(null, "O desconto não pode ser negativo. \nFavor inserir um valor de desconto válido.");
            textDesconto.requestFocus();
            textDesconto.setText("0");
            valorFinal = getValor() - (valorDesconto < 0 ? 0 : valorDesconto);
            return;
        }
        
        textValorFinal.setText(getValorFinal() + "");
    }//GEN-LAST:event_btnAplicarDescontoActionPerformed

    private void btnSalvarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarOSActionPerformed
        //Valida sem há produtos ou serviços na OS
        if ((this.listItensProduto.isEmpty()) && (this.listItensServico.isEmpty())) {
            JOptionPane.showMessageDialog(null, "Ordem de serviço precisa ter ao menos um(1) serviço ou produto.");
            textQuantidade.requestFocus();
            return;
        }
        
        //
        try{
            OrdemServico OS = new OrdemServico(0, (Veiculo)comboVeiculo.getSelectedItem(), (Funcionario)comboFuncionario.getSelectedItem(), (Double.parseDouble(textValor.getText())), (Double.parseDouble(textDesconto.getText())), (Double.parseDouble(textValorFinal.getText())), (checkBoxPago.isSelected()), (LocalDate.parse(textDataEntrada.getText(), formato)), (textDataSaida.getText().equals("  /  /    ") ? null : LocalDate.parse(textDataSaida.getText(), formato)));
            
            //Cria OS
            daoOS.create(OS);
            
            //Grava Produtos da OS percorrendo lista Temp.
            for (ItemProduto itemProduto : listItensProduto) {
                itemProduto.setOrdemServico(OS);
                daoItProduto.create(itemProduto);
            }
            
            //Grava Serviços da OS percorrendo lista Temp.
            for (ItemServico itemServico : listItensServico) {
                itemServico.setOrdemServico(OS);
                daoItServico.create(itemServico);
            }
            
            //Inicia uma nova OS
            this.clearComponentsAll();
            this.listItensProduto.clear();
            this.listItensServico.clear();
            this.loadTableOS();
            this.loadTableProduto();
            this.loadTableServico();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao Gravar.", "ERRO: ", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro: " + ex.getMessage());
        }
        
    }//GEN-LAST:event_btnSalvarOSActionPerformed

    private void tableOrdemServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOrdemServicoMouseClicked
        if (evt.getClickCount() == 2) {
            int codigo = Integer.parseInt(tableOrdemServico.getValueAt(tableOrdemServico.getSelectedRow(), 0) + "");
            
            OrdemServico ordemServico = daoOS.read(OrdemServico.class, codigo);
            this.loadTableProduto(ordemServico);
            this.loadTableServico(ordemServico);
            this.fillComponents(ordemServico);
        }
    }//GEN-LAST:event_tableOrdemServicoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dialogOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialogOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialogOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialogOrdemServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogOrdemServico dialog = new dialogOrdemServico(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarProduto;
    private javax.swing.JButton btnAdicionarServico;
    private javax.swing.JButton btnAplicarDesconto;
    private javax.swing.JButton btnNovaOS;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton btnNovoServico;
    private javax.swing.JButton btnRemoverProduto;
    private javax.swing.JButton btnRemoverServico;
    private javax.swing.JButton btnSalvarOS;
    private javax.swing.JCheckBox checkBoxPago;
    private javax.swing.JComboBox<String> comboFuncionario;
    private javax.swing.JComboBox<String> comboProduto;
    private javax.swing.JComboBox<String> comboServico;
    private javax.swing.JComboBox<String> comboVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableItemProduto;
    private javax.swing.JTable tableItemServico;
    private javax.swing.JTable tableOrdemServico;
    private javax.swing.JFormattedTextField textDataEntrada;
    private javax.swing.JFormattedTextField textDataSaida;
    private javax.swing.JTextField textDesconto;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textQuantidade;
    private javax.swing.JTextField textValor;
    private javax.swing.JTextField textValorFinal;
    private javax.swing.JTextField textValorProduto;
    private javax.swing.JTextField textValorServico;
    // End of variables declaration//GEN-END:variables
}
