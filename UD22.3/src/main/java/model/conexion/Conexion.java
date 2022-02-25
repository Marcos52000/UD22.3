package model.conexion;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conexion {
	
   static String bd = "Cientificos";
   static String login = "remote";
   static String password = "Reus.2022";
   static String url = "jdbc:mysql://192.168.1.102:3306/" + bd + "?useTimezone=true&serverTimezone=UTC";

   Connection conexion = null;
 
   //Constructor
   public Conexion() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         conexion = DriverManager.getConnection(url, login, password);
         
         if (conexion!=null) {
            System.out.print("Conexión a la base de datos " + bd + "_SUCCESS at");
            fecha();
         }
      }
      
      catch(SQLException e) {
         System.out.println(e);
      }
      catch(ClassNotFoundException e) {
         System.out.println(e);
      }
      catch(Exception e) {
         System.out.println(e);
      }
   }
   
   //Retorno de conexión
   public Connection getConnection() {
      return conexion;
   }

   public void desconectar() {
	   conexion = null;
   }
   
   //Método fecha
   public static void fecha() {
	   Date date = new Date();
	   DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	   System.out.println(" - " + dateFormat.format(date));
   }
}
