//Excecao para tratamento de login incorreto.
package business.control;


public class LoginException extends Exception {
   public LoginException(){
        super("Erro no login.");
    }
    
    public LoginException(String mensagem){
        super(mensagem);
    } 
}
