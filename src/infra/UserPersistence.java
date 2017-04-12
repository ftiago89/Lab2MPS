//Classe para persistencia dos dados
package infra;

import business.model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;


public class UserPersistence {
    private File file;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
    public UserPersistence() throws InfraException{
         file = new File("usuarios");
    }
    
    //metodo para salvar o hashmap passado como parametro no arquivo.
    public void save(HashMap<String, User> u) throws InfraException{

        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
        } catch (FileNotFoundException ex) {
            throw new InfraException("Erro no sistema, contacte um administrador.");
        } catch (IOException ex) {
            throw new InfraException("Erro no sistema, contacte um administrador.");
        }
            
        try {
            oos.writeObject(u);
            oos.flush();
            oos.close();
        } catch (IOException ex) {
            throw new InfraException("Erro no sistema, contacte um administrador.");
        }
    }
    
    //metodo para carregar as informacoes armazenadas para o HashMap.
    public HashMap<String, User> load() throws InfraException{
        
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            throw new InfraException("Erro no sistema, contacte um administrador.");
        } catch (IOException ex) {
            throw new InfraException("Erro no sistema, contacte um administrador.");
        }
            
            
        HashMap<String, User> fileMap = new HashMap();
        try {
            fileMap = (HashMap<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new InfraException("Erro no sistema, contacte um administrador.");
        }
            
            
        try {
            ois.close();
        } catch (IOException ex) {
            throw new InfraException("Erro no sistema, contacte um administrador.");
        }

        return fileMap;
            
    }
}
