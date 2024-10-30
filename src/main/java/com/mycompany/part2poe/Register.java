/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part2poe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
public class Register {
    
    private String name, lastName, username, password;
    
    public boolean checkUsername(String username){
        return username.contains("_") && username.length()<=5;
    }
    public boolean checkPasswordComplexity(String password){
        String regex = "(?=.*[0-9])" + "(?=.*[A-Z])(?=.*[a-z])" + 
                "(?=.*[~!@#$%^&*()*;]).{8,}$";
        
        Pattern p = Pattern.compile(regex);
        if(password == null){
        return false;
    }
        
        
        System.out.println(password.length()>=8);
        System.out.println(password.matches(regex));
        Matcher m = p.matcher(password);
        return m.matches();
    }
    
    public String registerUser(String name, String lname, String username, String Password){
        if(!checkPasswordComplexity(password)){
            return "Password does not meet the necessary requirements";
        }
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
        return "Both username and password requirements are met";
    }
    
    public boolean loginUser(String username, String password){
        return username.equals(this.username) && password.equals(this.password);
    }
    public String returnLoginStatus(boolean login){
        if(login){
            return "Welcome " + name + lastName + "Its great to see you as always ";
            
        }
        return "Password or username do not meet the requirements";
    }
  
}


