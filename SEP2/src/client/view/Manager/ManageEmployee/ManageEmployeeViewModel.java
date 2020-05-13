package client.view.Manager.ManageEmployee;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.DamageEmployee.DamageEmployee;
import client.model.Employee;
import client.model.Manager.Manager;
import client.model.Model;
import client.model.Salesman.Salesman;
import client.view.Manager.EditEmployee.EditEmployeeViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import javax.naming.Name;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManageEmployeeViewModel
{
  private Model model;
  private EditEmployeeViewModel e;
  ObservableList<ObservableList> list;
  ObservableList<String> row;
  ViewModelFactory viewModelFactory;

  public ManageEmployeeViewModel(Model model)
  {
    this.model = model;
  }

  public void getEmployeesFromDB(TableView TV)
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
      ResultSet rs = stmt.executeQuery("SELECT * FROM \"createpolicy\".Employees;");

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

  public ObservableList editSelect(TableView TV)
  {
    int selected = TV.getSelectionModel().getFocusedIndex();
    if (selected != 0)
    {
      return list.get(0);
    }
    return null;

  }
}

