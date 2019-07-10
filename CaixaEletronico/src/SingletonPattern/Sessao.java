package SingletonPattern;


/**
 * @author Otavio & Alan
 */
public class Sessao {
    public static Sessao instancia; 
    String nome; 
    Float saldo; 
    int id; 

    public int getId() {
        return instancia.id;
    }

    public void setId(int id) {
        instancia.id = id;
    }
  
    //Construtor
    public Sessao(){
        
    }
    
    public String getNome() {
        return instancia.nome;
    }
    
    public void setNome(String nome) {
        instancia.nome = nome; 
    }

    public Float getSaldo() {
        return instancia.saldo;
    }

    public void setSaldo(Float saldo) {
        instancia.saldo = saldo;
    }

    public static synchronized Sessao getSessao(){ 
        if(instancia == null)
            instancia = new Sessao(); 
        
        return instancia; 
    }
    
}
