//Excecao caso nao existam usuarios cadastrados.
package business.control;

public class NoUserException extends Exception {

    public NoUserException(){
        super("Nao existem usuarios cadastrados.");
    }
    
    public NoUserException(String mensagem){
        super(mensagem);
    }
}
