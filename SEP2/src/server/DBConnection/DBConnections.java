package server.DBConnection;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import shared.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnections
{

  // Has a lot of logic, dealing with the database

  public void AddToDB(String sql)
  {
    Connection connection = null;
    Statement statement = null;

    try
    {
      Class.forName("org.postgresql.Driver");
      System.out.println("før");
      connection = DriverManager

          .getConnection("jdbc:postgresql://localhost:5432/Sonny", "postgres",
              "1234");
      System.out.println("efter");
      statement = connection.createStatement();

      String toSql = sql;

      statement.executeUpdate(toSql);
      statement.close();
      connection.close();
    }
    catch (Exception e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);

    }
    System.out.println("Insert to Database ok!");
  }

  public List<Customer> fillTableDB(String sql)
  {
    ArrayList<Customer> list = new ArrayList<>();
    ObservableList<String> row;

    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/Sonny", "postgres", "1234");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
        //We are using non property style for making dynamic table
        String name = rs.getString("name");
        String address = rs.getString("address");
        int postcode = rs.getInt("postcode");
        int costumerNo = rs.getInt("customerNo");
        long cprNr = rs.getLong("cpr");

        Customer customer = new Customer(name, address, postcode, costumerNo, cprNr);
        list.add(customer);
//
//        TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
//        col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>()
//        {
//          public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param)
//          {
//            return new SimpleStringProperty(param.getValue().get(j).toString());
//          }
//        });

     //   TV.getColumns().addAll(col);
        //System.out.println("Column [" + i + "] ");
      }

//      while (rs.next())
//      {
//        //Iterate Row
//        row = FXCollections.observableArrayList();
//        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
//        {
//          //Iterate Column
//          row.add(rs.getString(i));
//        }
//        System.out.println("Row [1] added " + row);
//        list.add(row);
//
//      }

      //FINALLY ADDED TO TableView
 //     TV.setItems(list);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error on Building Data");
    }
    System.out.println(list);
    return list;
  }

  public void updateEmployee(){}

  public void getEmployee(){}

}
