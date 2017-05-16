/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class DB {
    
    public static final String DBURL =  "jdbc:mysql://localhost/University Application?autoReconnect=true&useSSL=false";
    public static final String DBUSER = "root";
    public static final String DBPASSWORD = "";
    protected Connection connection= null;
    protected PreparedStatement statement = null;
    protected ResultSet resultSet = null;
    
    
    public DB(){
        try {
            connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (SQLException ex) {
            System.out.println("The following error has occured" + ex.getMessage());
        }
    }
    
    public void DisconnectFromDb(){
        try {
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
             System.out.println("The following error has occured" + ex.getMessage());
        }
    }
    
    public void SetConnection(){
        
        try {
            if(connection.isClosed()){
                connection =  DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
            }
        } catch (SQLException ex) {
            System.out.println("The following error has occured" + ex.getMessage());
        }
    }
}
