package aaa2019;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.stage.Stage;
import org.json.JSONObject;
public class Server extends Application {
	private int clientNo = 0;	
	@Override
	public void start (Stage primaryStage) throws Exception {		
		new Thread( () -> {
			try {
				ServerSocket serverSocket = new ServerSocket(8182);
				while (true) {
					Socket socket = serverSocket.accept();
					clientNo++;					
                                        System.out.println("Cliente: "+clientNo+" IP:"+socket.getInetAddress().getHostAddress());				
                                       	new Thread(new ThreadClient(socket)).start();
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}).start();
	}
	class ThreadClient implements Runnable {
	private Socket socket;
	public ThreadClient(Socket socket) {
			this.socket = socket;
		}     
            @Override
            public void run () {
                try {
                    DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                    DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                    while (true) {
                        String json_str = inputFromClient.readUTF();
                        JSONObject my_obj = new JSONObject(json_str);
                        String login = my_obj.getString("usuario");
                        String senha = my_obj.getString("senha");
                        System.out.println(json_str);
                        String retorno= String.valueOf(valorConsulta(login, senha));//função que crie consulta sql

                        outputToClient.writeUTF(retorno); 
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
	}
  

	public static void main (String[] args) { Application.launch(args); }
        public String valorConsulta(String n, String x){
            String txtUsuario=n;
            String txtSenha=x;
            String json_string="Verifique sua senha";
            try {

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcaixaeletronico", "root", "");
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM conta where login = '"+txtUsuario+"' and senha like '"+txtSenha+"'";
                ResultSet res = stmt.executeQuery(sql);

                while (res.next()) {
                  
                    JSONObject my_obj = new JSONObject();//saldo
                        my_obj.put("idUsuario", res.getInt("id_conta"));
                        my_obj.put("nomeUsuario", res.getString("nome"));  
                        my_obj.put("saldoUsuario", res.getString("saldo"));                          
                        json_string = my_obj.toString();
                }
                con.close();
            } catch (Exception e) {
                json_string=e.toString();
            }

            return json_string;
        }
              
}
