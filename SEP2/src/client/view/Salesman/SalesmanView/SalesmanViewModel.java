package client.view.Salesman.SalesmanView;

import client.model.Model;
import client.view.Salesman.ManageCustomer.ManageCustomerViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SalesmanViewModel
{
  private Model model;
  private StringProperty searchField;
  ObservableList<ObservableList> list;
  ObservableList<String> row;
  ManageCustomerViewModel manageCustomerViewModel;

  public SalesmanViewModel(Model model)
  {
    this.model = model;
    searchField = new SimpleStringProperty();
    manageCustomerViewModel = new ManageCustomerViewModel(model);
  }


  public void getCustomersFromDB(TableView TV)
  {
    list = FXCollections.observableArrayList();
    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1122");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM \"createpolicy\".Customer;");

      for (int i = 0; i < rs.getMetaData().getColumnCount(); i++)
      {
        //We are using non property style for making dynamic table
        final int j = i;
        TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
        col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>()
        {
          public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param)
          {
            return new SimpleStringProperty(param.getValue().get(j).toString());
          }
        });

        TV.getColumns().addAll(col);
        System.out.println("Column [" + i + "] ");
      }

      while (rs.next())
      {
        //Iterate Row
        row = FXCollections.observableArrayList();
        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
        {
          //Iterate Column
          row.add(rs.getString(i));
        }
        System.out.println("Row [1] added " + row);
        list.add(row);


      }

      //FINALLY ADDED TO TableView
      TV.setItems(list);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error on Building Data");
    }


  }
  public boolean editSelect(TableView TV)
  {
    int selected = TV.getSelectionModel().getFocusedIndex();
    if (selected != 0)
    {
      manageCustomerViewModel.setFields(list.get(selected));
      return true;
    }
    return false;
  }
}
