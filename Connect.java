/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author M Azhar Durrani
 */
public class Connect {
    private static final String username = "root";
    private static final String password = "mysqlroot12";
    private static final String dataconn = "jdbc:mysql://localhost:3306/Institute_Management";

//    java.sql.Connection sqlConn = null;
//    PreparedStatement pst = null;
//    ResultSet rs = null;
//    int q, i, id, deletItem;

    Connection con = null;

    public static Connection ConnectDB() {
        String dbURL = "jdbc:mysql://localhost:3306/Institute_Management";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(dataconn, username, password);

//            Connection con = DriverManager.getConnection(dbURL); 
            return con;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }
}
