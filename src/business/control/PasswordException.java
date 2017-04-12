//Excecao para tratamento de senhas incorretas.
package business.control;


public class PasswordException extends Exception{
    public PasswordException(){
        super("Erro na senha.");
    }
    
    public PasswordException(String mensagem){
        super(mensagem);
    }
}
