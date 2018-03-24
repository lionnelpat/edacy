/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lionn
 */
public class Connecter {
    
    Connection con;
    
    public Connecter(){
        try{
          Class.forName("com.mysql.jdbc.Driver");  
        }catch(ClassNotFoundException e){
            System.err.println(e); // pour afficher les erreurs de connexion 
        }
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smsdb","root",""); 
        }catch(SQLException es){
            System.err.println(es);
        }
    }
    
    public Connection obtenirConnexion(){
        return con;
    }
    
}
