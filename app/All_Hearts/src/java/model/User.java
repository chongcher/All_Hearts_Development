/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author ccchia.2014
 */
public class User {
    private String username;
    private String password;
    private HashMap<String,String> permissions;
    
    public User(String username, String password, HashMap<String,String> permissions){
        this.username = username;
        this.password = password;
        this.permissions = permissions;
    }
    
    public String getUsername(){
        return username;
    }
    
    public boolean verifyPassword(String username, String password){
        return(this.username.equals(username) && this.password.equals(password));
    }
    
    public HashMap<String,String> getPermissions(){
        return permissions;
    }
}
