package business.model;

import java.io.Serializable;


public class User implements Serializable {
    private String login;
    private String senha;
    
    public User(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public void setLogin(String s){
        this.login = s;
    }
    
    public String getSenha(){
        return this.senha;
    }
    
    public void setSenha(String s){
        this.senha = s;
    }
    
    @Override
    public String toString(){
        return login + "\n";
    }
    
}
