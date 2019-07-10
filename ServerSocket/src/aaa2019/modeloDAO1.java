package aaa2019;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONException;
import org.json.JSONObject;
public class modeloDAO1 {
    private final Connection con;
    private final Statement stmt, stmRecebimento;
    private PreparedStatement pstmt, pUsuario, pRegistroDeposito,
            pRegistroSaque, pRegistroTransferencia, pRecebimento; 
    private ResultSet res;
    String msgRetorno = null;
    
    public modeloDAO1() throws SQLException {   
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcaixaeletronico", "root", "");
        stmt = con.createStatement();
        stmRecebimento = con.createStatement();          
    }
    public String login(String usuario, String senha){  
      String json_string="Verifique sua senha";       
      try {          
        res = stmt.executeQuery("SELECT * FROM conta where login = '"+usuario+"' and senha = '"+senha+"'");
        while (res.next()) {                  
            JSONObject my_obj = new JSONObject();//saldo
            my_obj.put("idUsuario", res.getString("id_conta"));
            my_obj.put("nomeUsuario", res.getString("nome"));  
            my_obj.put("saldoUsuario", res.getString("saldo"));                          
            json_string = my_obj.toString();
        }
        con.close();
     } catch (SQLException | JSONException e) {
        json_string=e.toString();
     }        
        return json_string;        
    }
    public String cadastroConta(String json_str){                                          
        try {          
            pstmt = con.prepareStatement("INSERT INTO conta (login, senha, nome, cpf, rg, agencia, saldo) VALUES (?,?,?,?,?,?, ?)");              
            JSONObject my_obj = new JSONObject(json_str);                                                              
            pstmt.setString(1, my_obj.getString("usuario"));
            pstmt.setString(2, my_obj.getString("senha"));
            pstmt.setString(3, my_obj.getString("nome"));
            pstmt.setString(4, my_obj.getString("cpf"));
            pstmt.setString(5, my_obj.getString("rg"));
            pstmt.setString(6, my_obj.getString("agencia"));
            pstmt.setString(7, my_obj.getString("saldo"));    
            pstmt.execute();                       
            con.close();
            msgRetorno= "Inserido com sucesso!";         
        }catch (SQLException | JSONException e) {
            msgRetorno=String.valueOf(e);
        }     
     return msgRetorno;  
     
     
    }   
    public String saque(String conta, String txtValorSaque) throws JSONException{  
         try {                                         
            res = stmt.executeQuery("select * from conta where id_conta = '"+conta+"'");               
            if (res.next()) {                  
                Float saldoAtualUsuario = Float.valueOf(res.getString("saldo"));
                Float valorSaque = Float.valueOf(txtValorSaque);          
                Float calculoSaldoAtual = saldoAtualUsuario - valorSaque; 
                  
                if(calculoSaldoAtual >= 0){               
                    pUsuario = con.prepareStatement("UPDATE conta SET saldo = ? WHERE id_conta = ?");   
                    pUsuario.setFloat(1, calculoSaldoAtual);
                    pUsuario.setInt(2, Integer.parseInt(conta));
                    pUsuario.execute();
                    pUsuario.close();                          
                    pRegistroSaque = con.prepareStatement("INSERT INTO saque (valor, id_contaFK) values (?, ?)");
                    pRegistroSaque.setFloat(1, valorSaque);
                    pRegistroSaque.setInt(2, Integer.parseInt(conta));
                    pRegistroSaque.execute();
                    pRegistroSaque.close();
                              
                    JSONObject obj_json = new JSONObject();
                    obj_json.put("mensagem", "Saque realizado!");
                    obj_json.put("saldo", String.valueOf(calculoSaldoAtual)); 
                    msgRetorno = obj_json.toString();   
                    
                }else 
                    msgRetorno= "{\"mensagem\":\"Saldo insuficiente!\",\"saldo\":\""+saldoAtualUsuario+"\"}";
            } 
            else 
                msgRetorno="Saque impossível";                       

        }catch (SQLException | HeadlessException e) {
            msgRetorno= String.valueOf(e);
        }  
        return msgRetorno;        
    }
    public String transferencia(String id_conta, String valor, String contaParaTransferencia) throws JSONException{   
        try {       
            res = stmt.executeQuery("select * from conta where id_conta = '"+id_conta+"'");                      
            if (res.next()) {                     
                //(1) Aqui iremos mexer com o saldo do usuário que está fazendo depósito
                Float saldoAtualUsuario = Float.valueOf(res.getString("saldo"));
                Float saldoDigitado = Float.valueOf(valor);                 
                Float calculoSaldoAtual = saldoAtualUsuario - saldoDigitado; 
                  
                if (calculoSaldoAtual >= 0) {  
                    //Essa sessão atualiza o saldo do Usuario ao clicar no botao, fazendo ele perder o dinheiro que transferiu
                    pUsuario = con.prepareStatement("UPDATE conta SET saldo = ? WHERE id_conta = ?");   
                    pUsuario.setFloat(1, calculoSaldoAtual);
                    pUsuario.setInt(2, Integer.parseInt(id_conta));
                    pUsuario.execute();
                    pUsuario.close();                          
                    pRegistroTransferencia = con.prepareStatement("INSERT INTO transferencia (valor, id_contaFK) values (?, ?)");
                    pRegistroTransferencia.setFloat(1, saldoDigitado);
                    pRegistroTransferencia.setInt(2, Integer.parseInt(id_conta));
                    pRegistroTransferencia.execute();
                    pRegistroTransferencia.close();
                                            
                    //Aqui iremos mexer com o saldo do usuário que está recebendo o depósito
                    String sqlRecebimento = "select * from conta where login = '"+contaParaTransferencia+"'";
                    ResultSet rsRecebimento = stmRecebimento.executeQuery(sqlRecebimento);
                          
                    if (rsRecebimento.next()) {  
                        //Continha básica para pegar o que foi digitado e somar com o saldo atual 
                        Float saldoAtualRecebimento = Float.valueOf(rsRecebimento.getString("saldo"));                    
                        Float calculoSaldoRecebido = saldoAtualRecebimento + saldoDigitado;                          
                        //Criamos um PreparedStatement para atualizar o saldo atual da conta recebimento
                        pRecebimento = con.prepareStatement("UPDATE conta SET saldo = ? WHERE login = ?");
                        pRecebimento.setFloat(1, calculoSaldoRecebido);
                        pRecebimento.setInt(2, Integer.valueOf(contaParaTransferencia));
                        pRecebimento.execute();
                        pRecebimento.close();                               
                                               
                        JSONObject obj_json = new JSONObject();
                        obj_json.put("mensagem", "Deposito realizado!");
                        obj_json.put("saldo", String.valueOf(calculoSaldoAtual)); 
                        msgRetorno = obj_json.toString();     
                    }
                } else   msgRetorno= "{\"mensagem\":\"Saldo insuficiente!\",\"saldo\":\""+saldoAtualUsuario+"\"}";
                                        
            } else  msgRetorno = "Depósito impossível";                       
                
        }catch (SQLException | HeadlessException e) {
            msgRetorno =String.valueOf(e);
        }         
    return msgRetorno;        
    }
    public String deposito(String conta, String valorDeposito) throws JSONException{
        try {                        
            res = stmt.executeQuery("select * from conta where id_conta = '"+conta+"'");   
            if (res.next()) {                          
                //(1) Aqui iremos mexer com o saldo do usuário que está fazendo depósito
                Float saldoAtualUsuario = Float.valueOf(res.getString("saldo"));
                Float saldoDigitado = Float.valueOf(valorDeposito);
                Float calculoSaldoAtual = saldoAtualUsuario + saldoDigitado;        
                if (saldoDigitado >= 25) {  
                //Essa sessão atualiza o saldo do Usuario ao clicar no botao, fazendo ele perder o dinheiro que transferiu
                    pUsuario = con.prepareStatement("UPDATE conta SET saldo = ? WHERE id_conta = ?");   
                    pUsuario.setFloat(1, calculoSaldoAtual);
                    pUsuario.setInt(2, Integer.parseInt(conta));
                    pUsuario.execute();
                    pUsuario.close();
                          
                    pRegistroDeposito = con.prepareStatement("INSERT INTO deposito (valor, id_contaFK) values (?, ?)");
                    pRegistroDeposito.setFloat(1, saldoDigitado);
                    pRegistroDeposito.setInt(2, Integer.parseInt(conta));
                    pRegistroDeposito.execute();
                    pRegistroDeposito.close();
            
                    JSONObject obj_json = new JSONObject();
                    obj_json.put("mensagem", "Depósito realizado!");
                    obj_json.put("saldo", String.valueOf(calculoSaldoAtual)); 
                    msgRetorno = obj_json.toString();  
                    //Aqui atualiza o saldo na Singleton, para que seja atualizado na TelaPrincipal também                                
                } else 
                   msgRetorno= "{\"mensagem\":\"Valor mínimo para depósito é R$25,00!\",\"saldo\":\""+saldoAtualUsuario+"\"}";
             } else 
                msgRetorno= "Depósito impossível";                       
             
        }catch (SQLException | HeadlessException e) {
            msgRetorno= String.valueOf(e);
        }
        return msgRetorno;   
    }
}