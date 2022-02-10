package com.Sql;

import com.Utility.DB_Utility;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class hrDatabaseTest {

  @Test
    public void testEmployeeSalary(){

      DB_Utility.createConnection();

      ResultSet rs = DB_Utility.runQuery("SELECT  first_name, last_name,employee_id,Job_id,salary from EMPLOYEES WHERE salary BETWEEN 5000 and 10000 order by SALARY asc");

      List<Map<String,String>> results = DB_Utility.getAllDataAsListOfMap();

      for (Map<String,String> each:results) {
          if(each.containsValue("5800")){
              System.out.println(each.containsKey("FIRST_NAME"));
              System.out.println(each.get("FIRST_NAME"));
              Assert.assertTrue(each.containsValue("Kevin"));
          }

      }

      DB_Utility.destroy();
  }

  @Test
    public void testingCountResults(){

      DB_Utility.createConnection();

      ResultSet rs = DB_Utility.runQuery("select count(*),department_id from employees group by department_id");

      List<Map<String,String>> results = DB_Utility.getAllDataAsListOfMap();

      for (Map<String,String> each:results) {
          if(each.containsValue("6")){
              System.out.println(each.get("COUNT(*)"));
              System.out.println(each.get("DEPARTMENT_ID"));
              Assert.assertTrue(each.containsValue("100")||each.containsValue("30"));
          }

      }

      DB_Utility.destroy();

  }
}
