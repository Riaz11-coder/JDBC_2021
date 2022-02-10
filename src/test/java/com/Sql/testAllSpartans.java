package com.Sql;

import com.Utility.ConfigurationReader;
import com.Utility.DB_Utility;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class testAllSpartans {

  @Test
    public void testAllSparta() throws SQLException {

      DB_Utility.createConnection(ConfigurationReader.getProperty("spartan.database.url"),ConfigurationReader.getProperty("spartan.database.username"),ConfigurationReader.getProperty("spartan.database.password"));

      ResultSet rs = DB_Utility.runQuery("SELECT * FROM spartans");

      rs.next();

      DB_Utility.displayAllData();

    System.out.println("COLUMN COUNT IS " + DB_Utility.getColumnCNT() );

    System.out.println("ROW COUNT IS " + DB_Utility.getRowCount() );

    System.out.println("3RD ROW DATA as a list" + DB_Utility.getRowDataAsList(3)  );


      DB_Utility.destroy();

  }

  @Test
  public void testingSpartanDatabase()throws SQLException{

    DB_Utility.createConnection(ConfigurationReader.getProperty("spartan.database.url"),ConfigurationReader.getProperty("spartan.database.username"),ConfigurationReader.getProperty("spartan.database.password"));

    ResultSet rs = DB_Utility.runQuery("SELECT * FROM spartans");


    List<String> allSpartaData = DB_Utility.getColumnDataAsList("NAME");

    System.out.println(allSpartaData);

    String expectedName = "Meade";
    System.out.println("Expected result "+expectedName);
    String actualName = DB_Utility.getColumnDataAtRow(1,"NAME");
    System.out.println("Actual result "+actualName);

    System.out.println(actualName.equals(expectedName));

    Assert.assertEquals(actualName,expectedName);

    DB_Utility.destroy();


  }
}
