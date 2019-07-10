package view;
import SingletonPattern.Sessao;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import clienteSocket.socketClienteLogin;

public class TelaLogin extends javax.swing.JFrame {
 
    public TelaLogin() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAcessar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel_mensagem = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblSenhaMSN = new javax.swing.JLabel();
        jButtonSair1 = new javax.swing.JButton();
        txtUsuario = new javax.swing.JFormattedTextField();
        lblUsuarioMSN = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 255));
        setForeground(new java.awt.Color(51, 51, 255));
        getContentPane().setLayout(null);

        jButtonAcessar.setBackground(new java.awt.Color(0, 153, 102));
        jButtonAcessar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAcessar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAcessar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_login.png"))); // NOI18N
        jButtonAcessar.setText("      Acessar     ");
        jButtonAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcessarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAcessar);
        jButtonAcessar.setBounds(230, 270, 250, 40);

        jButtonCadastrar.setBackground(new java.awt.Color(0, 153, 102));
        jButtonCadastrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_cad.png"))); // NOI18N
        jButtonCadastrar.setText("     Cadastrar  ");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCadastrar);
        jButtonCadastrar.setBounds(230, 320, 250, 40);

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Conta:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 180, 60, 30);

        jLabelSenha.setBackground(new java.awt.Color(51, 51, 51));
        jLabelSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelSenha.setForeground(new java.awt.Color(0, 51, 102));
        jLabelSenha.setText("Senha:");
        getContentPane().add(jLabelSenha);
        jLabelSenha.setBounds(230, 220, 60, 30);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(290, 220, 190, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Tela de Login");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 10, 110, 20);

        jLabel_mensagem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_mensagem.setForeground(new java.awt.Color(204, 51, 0));
        getContentPane().add(jLabel_mensagem);
        jLabel_mensagem.setBounds(240, 150, 240, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo.png"))); // NOI18N
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 0, 180, 160);

        lblSenhaMSN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblSenhaMSN.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblSenhaMSN);
        lblSenhaMSN.setBounds(490, 220, 120, 30);

        jButtonSair1.setBackground(new java.awt.Color(204, 0, 0));
        jButtonSair1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonSair1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ic_close.png"))); // NOI18N
        jButtonSair1.setText("Sair");
        jButtonSair1.setAutoscrolls(true);
        jButtonSair1.setMaximumSize(new java.awt.Dimension(7, 7));
        jButtonSair1.setMinimumSize(new java.awt.Dimension(7, 7));
        jButtonSair1.setPreferredSize(new java.awt.Dimension(7, 7));
        jButtonSair1.setSelected(true);
        jButtonSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSair1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSair1);
        jButtonSair1.setBounds(590, 350, 90, 30);
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(290, 180, 190, 30);

        lblUsuarioMSN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUsuarioMSN.setForeground(new java.awt.Color(204, 0, 0));
        getContentPane().add(lblUsuarioMSN);
        lblUsuarioMSN.setBounds(490, 180, 120, 30);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 690, 400);

        setSize(new java.awt.Dimension(707, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    DataOutputStream toServer = null;
    DataInputStream fromServer = null;
    
    private void jButtonAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcessarActionPerformed
        
        if(txtUsuario.getText().equals("")||txtSenha.getText().equals("")){
            jLabel_mensagem.setText(""); 
            if(txtSenha.getText().equals(""))
                lblSenhaMSN.getText().equals("*Campo vazio!"); 
            
            else
                lblSenhaMSN.setText("");
               
            if(txtUsuario.getText().equals(""))
                lblUsuarioMSN.setText("*Campo vazio!"); 
            
            else
                lblUsuarioMSN.setText("");
                       
        } else{       
            try {
                    lblUsuarioMSN.setText("");
                    lblSenhaMSN.setText(""); 
                    
                    socketClienteLogin conexaSocket=new socketClienteLogin();                    
                    Socket socket = conexaSocket.getSocket();
                    
                    fromServer = new DataInputStream(socket.getInputStream());
                    toServer = new DataOutputStream(socket.getOutputStream());

                    JSONObject my_obj = new JSONObject();
                    my_obj.put("funcao", "login");
                    my_obj.put("usuario", txtUsuario.getText());
                    my_obj.put("senha", txtSenha.getText());
                    String json_string = my_obj.toString();               
                    toServer.writeUTF(json_string);
                    toServer.flush();
                    String resposta_do_Servidor = fromServer.readUTF();

                    if(resposta_do_Servidor.equals("Verifique sua senha")){
                        jLabel_mensagem.setText(resposta_do_Servidor);
                    }else{  

                    JSONObject obj = new JSONObject(resposta_do_Servidor);
                    String nomeUsuario = obj.getString("nomeUsuario");         
                    Float saldoUsuario=Float.valueOf(obj.getString("saldoUsuario"));
                    int idUsuario=Integer.valueOf(obj.getString("id_conta"));
                    
                    Sessao sessao = Sessao.getSessao();                          
                    sessao.setNome(String.valueOf(nomeUsuario));
                    sessao.setSaldo(saldoUsuario);
                    sessao.setId(idUsuario);                          
                    TelaPrincipal tela = new TelaPrincipal();
                    tela.setVisible(true);        
                    dispose();
                    }                

            } catch (IOException | JSONException e2) {/*area.appendText(e2.toString() + '\n');*/
            JOptionPane.showConfirmDialog(null, "Sem conexão");
            }
        }  
    }//GEN-LAST:event_jButtonAcessarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        TelaCadastrar tela = new TelaCadastrar();
        tela.setVisible(true);
        dispose();       
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSair1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSair1ActionPerformed
 
    public static void main(String args[]) {
             
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcessar;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonSair1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabel_mensagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSenhaMSN;
    private javax.swing.JLabel lblUsuarioMSN;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JFormattedTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
