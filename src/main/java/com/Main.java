package com;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    final String host = "mysql";
    final String dbname = "myDB";
    try {
		Thread.sleep(60000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    execute(host, dbname);
  }

  static void execute(String host, String dbname) throws ClassNotFoundException, SQLException {
   try
   {
	  Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection(
        "jdbc:mySql://" + host + "/" + dbname , "root", "123");
    PreparedStatement stmt = conn.prepareStatement("INSERT INTO emp(id,name,city) VALUES(?, ?,?)");
    stmt.setInt(1, 5);
    stmt.setString(2, "Yamada");
    stmt.setString(3, "Yamada");
    stmt.executeUpdate();
    System.out.println("new Line inserted");
   }
   catch(Exception ex)
   {
	   System.out.println("MysqlError : " + ex.getMessage());
   }
  }

}