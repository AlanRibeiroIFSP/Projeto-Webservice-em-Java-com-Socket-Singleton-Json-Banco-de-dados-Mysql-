package aaa2019;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

public class testeServerBanco extends Application {
	private int clientNo = 0;	
	@Override
	public void start (Stage primaryStage) throws Exception {		
		new Thread( () -> {
			try {
				ServerSocket serverSocket = new ServerSocket(8182);
				while (true) {
					Socket socket = serverSocket.accept();
					clientNo++;					
                                        System.out.println("Conexão: "+clientNo+" IP:"+socket.getInetAddress().getHostAddress());				
                                       	new Thread(new ThreadClient(socket)).start();
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}).start();
	}
	class ThreadClient implements Runnable {
	private final Socket socket;
	public ThreadClient(Socket socket) {
			this.socket = socket;
		}     
            @Override
            public void run () {
                try {
                    DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                    DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                    while (true) {
                        String msgRetorno="sem dados";
                        modeloDAO consultaSql= new modeloDAO();
                        String json_str = inputFromClient.readUTF();                        
                        JSONObject my_obj = new JSONObject(json_str);
                        
                        if(my_obj.getString("funcao").equals("login")){                            
                            String login = my_obj.getString("usuario");
                            String senha = my_obj.getString("senha");
                            msgRetorno= consultaSql.login(login, senha);                                  
                        }
                        
                        if(my_obj.getString("funcao").equals("saque")){                            
                            String id_conta = my_obj.getString("id_conta");                             
                            String valor = my_obj.getString("valor");
                            System.out.println("sendo enviado: "+id_conta+" : " +valor);
                            msgRetorno= consultaSql.saque(id_conta, valor);
                        }                       
                        
                        if(my_obj.getString("funcao").equals("transferencia")){                            
                            String id_conta = my_obj.getString("id_conta");                             
                            String valor = my_obj.getString("valor");
                            String conta = my_obj.getString("conta");
                            msgRetorno= consultaSql.transferencia(id_conta, valor, conta);
                        } 
                        
                        if(my_obj.getString("funcao").equals("deposito")){                            
                            String conta = my_obj.getString("id_conta");                             
                            String valor = my_obj.getString("valor");
                            System.out.println("sendo enviado: "+conta+" : " +valor);
                            msgRetorno= consultaSql.deposito(conta, valor);
                        }                                 
                        
                        if(my_obj.getString("funcao").equals("cadastro")){                            
                            msgRetorno= consultaSql.cadastroConta(json_str);
                            System.out.println(json_str);
                        }                          
                        
                        switch(my_obj.getString("funcao"))
                        {
                            case "login":
                                System.out.println("alan vitorrrrrr");
                                break;                                
                            default:                               
                        }
                        
                        System.out.println(msgRetorno);
                        outputToClient.writeUTF(msgRetorno); 
                    }
                } catch (IOException | SQLException | JSONException e) {
                    System.out.println(e.toString());
                }
            }
	}

	public static void main (String[] args) { Application.launch(args); }
             
}

