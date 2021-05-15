package com.Sql;

import com.Utility.ConfigurationReader;
import com.Utility.DB_Utility;
import org.junit.Test;

import java.sql.*;

public class employeesTest {

    @Test
    public void testEmployees() throws SQLException{

        DB_Utility.createConnection();
        //Connection conn = DriverManager.getConnection(ConfigurationReader.getProperty("database.url"),ConfigurationReader.getProperty("database.username"),ConfigurationReader.getProperty("database.password")) ;
        ResultSet rs = DB_Utility.runQuery("SELECT * FROM employees");
       // Statement stmnt = conn.createStatement();
       // ResultSet rs   =   stmnt.executeQuery("SELECT * FROM employees");

        rs.next();

        System.out.println(rs.getString(1));
        System.out.println(rs.getString("EMPLOYEE_ID"));
        System.out.println(rs.getString("FIRST_NAME"));
        System.out.println(rs.getString("last_name"));

        DB_Utility.displayAllData();



    }
}
