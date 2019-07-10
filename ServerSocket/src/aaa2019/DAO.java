package aaa2019;
import java.sql.SQLException;
import org.json.JSONException;
import org.json.JSONObject;
public class DAO {
    
    public static void main (String[] args) throws JSONException, SQLException {
            //cadastro 
     /*      JSONObject obj_json = new JSONObject();
             obj_json.put("usuario", "95");
             obj_json.put("senha", "91");  
             obj_json.put("nome", "91");              
             obj_json.put("cpf", "95");
             obj_json.put("rg", "91");  
             obj_json.put("agencia", "91"); 
             obj_json.put("saldo", "91");               
                      
             String json_str = obj_json.toString(); */   
             modeloDAO cad= new modeloDAO();
            //System.out.print(cad.cadastroConta(json_str));  
            
           String a, b, c=null;
          
     /*     try{
            JSONObject obj = new JSONObject(cad.login("5", "1"));  
              System.out.println(obj.getString("nomeUsuario"));         
              System.out.println( obj.getString("saldoUsuario"));
              System.out.println( obj.getString("id_conta")); 
          }catch (JSONException e) {
           // msgRetorno=String.valueOf(e);
          }  
       */     
            //saque
              String conta="5";
              String valorSaque="2";
             
           System.out.println(cad.saque(conta, valorSaque));   
            
           try{
            JSONObject obj = new JSONObject(cad.saque(conta, valorSaque));  
              System.out.println(obj.getString("mensagem"));         
              System.out.println( obj.getString("saldo"));
          }catch (JSONException e) {
           // msgRetorno=String.valueOf(e);
          }  
            
            
            
            
            
            
            
            
            //System.out.print(cad.transferencia(conta, valorSaque, "33333"));       
            //System.out.print(cad.deposito(conta, "26"));    
    }
   
}
