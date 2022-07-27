package com.example.demo;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

public class Conexao {

    public static Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String user = "root";
            String password = "maia";
            String url = "jdbc:mysql://localhost/maia";

            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        throw new IllegalArgumentException("Error ao conectar no banco");
    }
    
    /*public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}