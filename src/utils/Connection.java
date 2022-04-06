/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.DriverManager;
import static utils.Properties.getConfigParameters;

/**
 *
 * @author maindesktop
 */
public class Connection {
    private final String USER = getConfigParameters().getProperty("USER");
    private final String PASSWORD = getConfigParameters().getProperty("PASSWORD");
    private final String SERVER = getConfigParameters().getProperty("SERVER");
    private final String DATABASE = getConfigParameters().getProperty("DATABASE");
    
    protected java.sql.Connection connection;

    public java.sql.Connection getConnection() {
        return connection;
    }
   
    public boolean connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String cadena = "jdbc:mysql://"+SERVER+":3306/"+DATABASE;
            this.connection = DriverManager.getConnection(cadena, USER, PASSWORD);
            return true;
           
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            return false;
        }
    }
    
    public boolean disconnect(){
        try{
            this.connection.close();
            return true;
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
            return false;
        }
    }
    
}
