//Classe controla para adicionar, remover e listar os dados cadastrados para o usuario.
package business.control;

import business.model.User;
import business.util.UserValidator;
import infra.InfraException;
import infra.UserPersistence;
import java.util.HashMap;


public class UserControl {
    private HashMap<String, User> users; //utilizado para guardar usuarios sendo o login a key do mapa.
    private UserValidator usrValidator;
    private UserPersistence usrPersistence;
    
    public UserControl() throws InfraException{
            usrPersistence = new UserPersistence();
            users = usrPersistence.load();
            usrPersistence.save(users);
            usrValidator = new UserValidator();
    }
    
    //metodo para adicionar usuarios no hashmap
    public void addUser(String login, String pass) throws LoginException, PasswordException, InfraException{
        usrValidator.loginValidate(login);
        usrValidator.passwordValidate(pass);
        users = usrPersistence.load();
        users.put(login, new User(login, pass));
        usrPersistence.save(users);
    }
    
    //metodo para listar todos os usuarios cadastrados
    public String listAll() throws NoUserException, InfraException{
        users = usrPersistence.load();
       
        String all = "";
        for (User u: users.values()){
            all = all + u.toString();
        }
        
        if (all.equals("")){
            throw new NoUserException();
        }
        return all;
    }
    
    //metodo para remover usuarios previamente cadastrados.
    public void remove(String login) throws NoUserException, InfraException{
        
        users = usrPersistence.load();
        
        if(users.remove(login) == null){
            throw new NoUserException("Este usuario nao existe, por favor digite um usuario valido.");
        }
        
        usrPersistence.save(users);
    }
   
}


