
package view;

import controller.daoFuncao;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Funcao;

public class dialogFuncao extends javax.swing.JDialog {
    
    private daoFuncao daoF = new daoFuncao();
    
    //Get Object
    private Funcao getObjeto() {
        return new Funcao((textCodigo.getText().equals("") ? 0 : Integer.parseInt(textCodigo.getText())), textNome.getText());
    }
    
    //
    private void clearComponents() {
        textCodigo.setText("");
        textNome.setText("");
        textPesquisar.setText("");
        textNome.requestFocus();
    }
    
    //
    private void fillComponents(Funcao funcao) {
        textCodigo.setText(funcao.getId() + "");
        textNome.setText(funcao.getNome());
        textNome.requestFocus();
    }
    
    //
    private void fillList() {
        DefaultListModel lm = new DefaultListModel();
        lm.addAll(daoF.read());
        listFuncao.setModel(lm);
    }
    
    private void fillList(String filtro) {
        DefaultListModel lm = new DefaultListModel();
        lm.addAll(daoF.read(filtro));
        listFuncao.setModel(lm);
    }
    
    
    /**
     * Creates new form dialogFuncao
     */
    public dialogFuncao(java.awt.Frame parent, boolean modal) {
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
        textPesquisar = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listFuncao = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textCodigo = new javax.swing.JTextField();
        textNome = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastrar = new javax.swing.JMenu();
        menuItemCidade = new javax.swing.JMenuItem();
        menuItemCliente = new javax.swing.JMenuItem();
        menuItemMarca = new javax.swing.JMenuItem();
        menuItemModelo = new javax.swing.JMenuItem();
        menuItemVeiculo = new javax.swing.JMenuItem();
        menuItemFornecedor = new javax.swing.JMenuItem();
        menuItemServico = new javax.swing.JMenuItem();
        menuItemFuncionario = new javax.swing.JMenuItem();
        menuItemProduto = new javax.swing.JMenuItem();
        menuItemFormaPagamento = new javax.swing.JMenuItem();
        menuItemOrdemServico = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funções");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 102, 0))); // NOI18N

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(textPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        listFuncao.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listFuncao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listFuncaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listFuncao);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Função", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 102, 0))); // NOI18N

        jLabel1.setText("Código:");

        jLabel3.setText("Nome:");

        textCodigo.setEditable(false);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnNovo)
                        .addGap(96, 96, 96)
                        .addComponent(btnSalvar)
                        .addGap(86, 86, 86)
                        .addComponent(btnExcluir)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(textCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuCadastrar.setText("Cadastrar");

        menuItemCidade.setText("Cidade");
        menuItemCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCidadeActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemCidade);

        menuItemCliente.setText("Cliente");
        menuItemCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemClienteActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemCliente);

        menuItemMarca.setText("Marca");
        menuItemMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMarcaActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemMarca);

        menuItemModelo.setText("Modelo");
        menuItemModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemModeloActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemModelo);

        menuItemVeiculo.setText("Veículo");
        menuItemVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemVeiculoActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemVeiculo);

        menuItemFornecedor.setText("Fornecedor");
        menuItemFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFornecedorActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemFornecedor);

        menuItemServico.setText("Serviço");
        menuItemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemServicoActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemServico);

        menuItemFuncionario.setText("Funcionário");
        menuItemFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFuncionarioActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemFuncionario);

        menuItemProduto.setText("Produto");
        menuItemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProdutoActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemProduto);

        menuItemFormaPagamento.setText("Forma de Pagamento");
        menuItemFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemFormaPagamentoActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemFormaPagamento);

        menuItemOrdemServico.setText("Ordem de Serviço");
        menuItemOrdemServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOrdemServicoActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemOrdemServico);

        jMenuBar1.add(menuCadastrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try{
            this.fillList(textPesquisar.getText());
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao filtrar. \tErro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        try{
            this.clearComponents();
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (textNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome da Função obrigatória.");
            textNome.requestFocus();
            return;
        }

        try{
            if (textCodigo.getText().trim().isEmpty() || textCodigo.getText().equals("0")) {
                daoF.create(this.getObjeto());
                JOptionPane.showMessageDialog(null, "Função adicionada com sucesso.");
            }else{
                daoF.update(this.getObjeto());
                JOptionPane.showMessageDialog(null, "Função editada com sucesso.");
            }
            
            //
            this.fillList();
            this.clearComponents();
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar.", "Erro: ", JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void listFuncaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listFuncaoMouseClicked
        if (evt.getClickCount() == 2) {
            Funcao funcao = (Funcao)listFuncao.getSelectedValue();
            this.fillComponents(funcao);
        }
    }//GEN-LAST:event_listFuncaoMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (listFuncao.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Selecione para excluir.");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(null, "Confirmar a exclusão da Função?") != 0) {
            return;
        }
        
        try{
            Funcao funcao = (Funcao)listFuncao.getSelectedValue();
            JOptionPane.showMessageDialog(null, "Função " + funcao.getNome() + " excluída.");
            daoF.delete(funcao);

            //
            this.fillList();
            this.clearComponents();
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.fillList();
        //this.clearComponents();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        this.fillList();
    }//GEN-LAST:event_formWindowGainedFocus

    private void menuItemCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCidadeActionPerformed
        new dialogCidade(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemCidadeActionPerformed

    private void menuItemClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemClienteActionPerformed
        new dialogCliente(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemClienteActionPerformed

    private void menuItemMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMarcaActionPerformed
        new dialogMarca(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemMarcaActionPerformed

    private void menuItemModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemModeloActionPerformed
        new dialogModelo(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemModeloActionPerformed

    private void menuItemVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemVeiculoActionPerformed
        new dialogVeiculo(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemVeiculoActionPerformed

    private void menuItemFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFornecedorActionPerformed
        new dialogFornecedor(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemFornecedorActionPerformed

    private void menuItemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemServicoActionPerformed
        new dialogServico(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemServicoActionPerformed

    private void menuItemFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFuncionarioActionPerformed
        new dialogFuncionario(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemFuncionarioActionPerformed

    private void menuItemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProdutoActionPerformed
        new dialogProduto(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemProdutoActionPerformed

    private void menuItemFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemFormaPagamentoActionPerformed
        new dialogFormaPagamento(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemFormaPagamentoActionPerformed

    private void menuItemOrdemServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOrdemServicoActionPerformed
        new dialogOrdemServico(null, true).setVisible(true);
    }//GEN-LAST:event_menuItemOrdemServicoActionPerformed

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
            java.util.logging.Logger.getLogger(dialogFuncao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dialogFuncao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dialogFuncao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dialogFuncao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogFuncao dialog = new dialogFuncao(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listFuncao;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenuItem menuItemCidade;
    private javax.swing.JMenuItem menuItemCliente;
    private javax.swing.JMenuItem menuItemFormaPagamento;
    private javax.swing.JMenuItem menuItemFornecedor;
    private javax.swing.JMenuItem menuItemFuncionario;
    private javax.swing.JMenuItem menuItemMarca;
    private javax.swing.JMenuItem menuItemModelo;
    private javax.swing.JMenuItem menuItemOrdemServico;
    private javax.swing.JMenuItem menuItemProduto;
    private javax.swing.JMenuItem menuItemServico;
    private javax.swing.JMenuItem menuItemVeiculo;
    private javax.swing.JTextField textCodigo;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textPesquisar;
    // End of variables declaration//GEN-END:variables
}
