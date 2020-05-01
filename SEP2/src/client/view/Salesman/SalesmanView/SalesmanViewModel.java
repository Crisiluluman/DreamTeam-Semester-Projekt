package client.view.Salesman.SalesmanView;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SalesmanViewModel
{
  private Model model;
  private StringProperty searchField;

  public SalesmanViewModel(Model model)
  {
    this.model = model;
    searchField = new SimpleStringProperty();
  }

  public void GetCustomers()
  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres",
              "postgres", "1122");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM \"createpolicy\".Customer;" );
      while ( rs.next() ) {
       int id = rs.getInt("CustomerNo");
        String  name = rs.getString("name");
        String  address = rs.getString("address");
        int postcode = rs.getInt("postcode");
        long cpr = rs.getLong("cpr");
        System.out.println( "CustomerNo = " + id );
        System.out.println( "name = " + name);
        System.out.println( "address = " + address );
        System.out.println( "postcode = " + postcode );
        System.out.println("cpr =" + cpr);
        System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }
    System.out.println("Database query ok ");
  }
  
}
