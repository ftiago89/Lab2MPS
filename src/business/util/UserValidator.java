//Classe para validar login e senha digitados pelo usuario.
package business.util;

import business.control.LoginException;
import business.control.PasswordException;


public class UserValidator {
    public void loginValidate(String login) throws LoginException{
        if (login.length() > 20){
            throw new LoginException("Login nao pode conter mais de 20 letras.");
        }else{
            if (login.isEmpty()){
                throw new LoginException("Campo de login esta vazio.");
            }else{
                if (numberCounter(login) > 0){
                    throw new LoginException("O login nao pode conter numeros.");
                }
            }
        }
    }
    
    public void passwordValidate(String pass) throws PasswordException{
        if (pass.length() > 12){
            throw new PasswordException("Senha nao pode conter mais de 12 letras.");
        }else{
            if ((pass.length()) < 8){
                throw new PasswordException("A senha precisa ter pelo menos 8 caracteres alfanumericos.");
            }else{
                if (numberCounter(pass) < 2){
                    throw new PasswordException("A senha nao precisa ter pelo menos 2 numeros.");
                }
            }
        }
    }
    
    public int numberCounter(String s){
        int i = 0;
        for(int c = 0; c < s.length(); ++c){
            if (Character.isDigit(s.charAt(c))){
                ++i;
            }
        }
        return i;
    }
}
