package view;
import SingletonPattern.Sessao;
import clienteSocket.socketClienteLogin;
import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

public class TelaTransferencia extends javax.swing.JFrame {

      public TelaTransferencia() {
        initComponents();
        
        Sessao sessao = Sessao.getSessao(); 
        String nomeUsuario = sessao.getNome();
        Float saldoUsuario = sessao.getSaldo();
           
    }

     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblMSN3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botaoConfirmar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        txtAgencia = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        camposObrigatorios = new javax.swing.JLabel();
        txtConta = new javax.swing.JTextField();
        lblMSN1 = new javax.swing.JLabel();
        lblMSN3d = new javax.swing.JLabel();
        lblMSN2 = new javax.swing.JLabel();

        jLabel1.setText("Banco, agenca , conta , valor - depois qjue confirmar, vai validar com uma tela de confirmacao e dar OK");

        lblMSN3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMSN3.setForeground(new java.awt.Color(204, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Tela Transferencia");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Agência");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Conta");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Valor R$");

        botaoConfirmar.setBackground(new java.awt.Color(0, 102, 102));
        botaoConfirmar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        botaoConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_ok.jpg"))); // NOI18N
        botaoConfirmar.setText("         Confirmar   ");
        botaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmarActionPerformed(evt);
            }
        });

        botaoSair.setBackground(new java.awt.Color(0, 102, 102));
        botaoSair.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botaoSair.setForeground(new java.awt.Color(255, 255, 255));
        botaoSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_voltar.png"))); // NOI18N
        botaoSair.setText("           Voltar     ");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        txtAgencia.setEditable(false);
        txtAgencia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtAgencia.setText("1000");
        txtAgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAgenciaActionPerformed(evt);
            }
        });

        txtValor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        camposObrigatorios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        camposObrigatorios.setForeground(new java.awt.Color(255, 0, 51));

        txtConta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lblMSN1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMSN1.setForeground(new java.awt.Color(204, 0, 0));

        lblMSN3d.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMSN3d.setForeground(new java.awt.Color(204, 0, 0));

        lblMSN2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblMSN2.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(botaoConfirmar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtValor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(camposObrigatorios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAgencia, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtConta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMSN1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(lblMSN3d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMSN2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(camposObrigatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtConta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMSN1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMSN2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(lblMSN3d, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botaoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        TelaPrincipal tela = new TelaPrincipal(); 
        tela.setVisible(true);
        dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_botaoSairActionPerformed

    private void txtAgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAgenciaActionPerformed
      
    }//GEN-LAST:event_txtAgenciaActionPerformed
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    
    private void botaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmarActionPerformed
         
        if(txtAgencia.getText().equals("")||txtConta.getText().equals("")||txtValor.getText().equals("")){           
            if(txtAgencia.getText().equals(""))
                lblMSN1.setText("*Campo vazio!");             
            else
                lblMSN1.setText("");
               
            if(txtConta.getText().equals(""))
                lblMSN2.setText("*Campo vazio!");          
            else
                lblMSN2.setText("");
            
            if(txtValor.getText().equals(""))
                lblMSN3d.setText("*Campo vazio!");          
            else
                lblMSN3d.setText("");
                         
        }else{
      
            Sessao sessao = Sessao.getSessao();
            try {
                socketClienteLogin conexaSocket=new socketClienteLogin();                    
                Socket socket = conexaSocket.getSocket();
                                
                fromServer = new DataInputStream(socket.getInputStream());
                toServer = new DataOutputStream(socket.getOutputStream()); 
               
                JSONObject my_obj = new JSONObject();
                my_obj.put("funcao", "transferencia");
                my_obj.put("id_conta", String.valueOf(sessao.getId()));
                my_obj.put("valor", txtValor.getText()); 
                my_obj.put("conta", txtConta.getText());
                String json_string = my_obj.toString();  
                
                toServer.writeUTF(json_string);
                toServer.flush();
                String resposta_do_Servidor = fromServer.readUTF();
                System.out.print(resposta_do_Servidor); 
                               
                JSONObject obj = new JSONObject(resposta_do_Servidor);  
                String mensagem= obj.getString("mensagem"); 
                Float saldo= Float.valueOf(obj.getString("saldo"));
                
                sessao.setSaldo(saldo);
                JOptionPane.showMessageDialog(null, mensagem); 
                
                TelaPrincipal tela = new TelaPrincipal(); 
                tela.setVisible(true);
                dispose(); 
                socket.close();       
                                 
            } catch (HeadlessException e) {
                JOptionPane.showConfirmDialog(null, e);
            } catch (JSONException | IOException ex) {
                Logger.getLogger(TelaTransferencia.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }  
    }//GEN-LAST:event_botaoConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTransferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaTransferencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoConfirmar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JLabel camposObrigatorios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblMSN1;
    private javax.swing.JLabel lblMSN2;
    private javax.swing.JLabel lblMSN3;
    private javax.swing.JLabel lblMSN3d;
    private javax.swing.JTextField txtAgencia;
    private javax.swing.JTextField txtConta;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
