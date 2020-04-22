package client.model.Police;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PoliceMain
{
  public static void main(String[] args)
  {
    //TEST
    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      System.out.println("hej");
      c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1122");

      System.out.println("The database is open");

      stmt = c.createStatement();
      String sql = "INSERT INTO \"createpolicy\".PoliceList values(1,'sd',412,124,'nej');";
      System.out.println("test");
      stmt.executeUpdate(sql);



      stmt.close();
      c.close();
    } catch (Exception e)
    {

    }
  }
}
