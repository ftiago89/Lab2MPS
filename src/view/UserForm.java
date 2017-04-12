//Classe de interface com o usuario.
package view;

import business.control.LoginException;
import business.control.NoUserException;
import business.control.PasswordException;
import business.control.UserControl;
import infra.InfraException;
import javax.swing.JOptionPane;


public class UserForm {
    private UserControl userControl;
    
    public UserForm(){
        try {
            userControl = new UserControl();
        } catch (InfraException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.exit(0);
        }
    }
    
    //Metodo de menu para interacao com usuario.
    public void menu(){
        String option = "";
        String login, pass;
        boolean valid = false;
        while (true){
            option = (JOptionPane.showInputDialog(null, "O que deseja fazer?\n"
                    + "1 - Cadastrar usuario.\n"
                    + "2 - Listar usuarios.\n" 
                    + "3 - Remover usuario.\n"
                    + "4 - Sair.\n"));
            
            
            if (option == null){
                //usuario apertou cancel.
                System.exit(0);
            }
            
            switch (option){
                case "1":
                    do{
                        
                        login = JOptionPane.showInputDialog(null, "Digite o Login: ");
                        if (login == null){
                            //usuario apertou cancel.
                            break;
                        }
                        pass = JOptionPane.showInputDialog(null, "Digite o Senha: ");
                        
                        try {
                            userControl.addUser(login, pass);
                            valid = true;
                        } catch (LoginException | PasswordException ex) {
                            //login ou password digitados incorretamente.
                            JOptionPane.showMessageDialog(null, ex.getMessage() + "\nTente novamente.");
                        } catch (InfraException ex) {
                            //erro ocasionado na camada infra.
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                            System.exit(0);
                        } catch (NullPointerException ex){
                            //usuario apertou cancel.
                            break;
                        }  
                    }while(!valid);
                    
                    break;
                    
                case "2":
                    try {
                        JOptionPane.showMessageDialog(null, userControl.listAll());
                    } catch (NoUserException | InfraException ex) {
                        //erro ocasionado na camada infra.
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        System.exit(0);
                    }
                    break;
                    
                case "3":
                    login = JOptionPane.showInputDialog(null, "Digite o login do usuario a ser removido:");
                    try {
                        userControl.remove(login);
                    } catch (NoUserException ex) {
                        //usuario nao foi cadastrado anteriormente.
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    } catch  (InfraException ex){
                        //erro ocasionado na camada infra.
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        System.exit(0);
                    }
                    break;
                    
                case "4":
                    System.exit(0);
                    break;
                
                
                    
                default:
                    //qualquer outra opcao digitada.
                    JOptionPane.showMessageDialog(null, "Por favor digite uma opcao valida.");
                    break;
            }
        }
    }
}
