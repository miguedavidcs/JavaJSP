/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author Miguel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
       Connection con;
       String url="jdbc:mysql://localhost:3306/konecta";
       String user="";
       String pass="";
       public Connection Conexion(){
           
           try{
               Class.forName("com.mysql.jdbc.Driver");
               con=DriverManager.getConnection(url,user,pass);
           }catch (ClassNotFoundException | SQLException e){
               
           }
           return con;
           
       }
}