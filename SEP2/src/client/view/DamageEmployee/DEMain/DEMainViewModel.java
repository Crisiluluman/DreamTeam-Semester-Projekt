package client.view.DamageEmployee.DEMain;

import client.core.ViewModelFactory;
import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import shared.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class DEMainViewModel
{

  private Model model;
  ViewModelFactory viewModelFactory;

  public DEMainViewModel(Model model)
  {
    this.model = model;
  }

  public boolean editSelect(TableView TV)
  {
    int selected = TV.getSelectionModel().getFocusedIndex();
    if (selected != -1)
    {
      return true;
    }
    return false;
  }

  public void readCustomer(TableView TV)
  {
    List<Customer> customers = model.readCustomer();
      ObservableList<String> row;
      ObservableList<ObservableList> rows = FXCollections.observableArrayList();


      setUpColumn(TV, "name");
      setUpColumn(TV, "address");
      setUpColumn(TV, "postcode");
      setUpColumn(TV, "cpr");
      setUpColumn(TV, "customerno");


       for (int i = 0; i < customers.size()  ; i++)
      {
          row = FXCollections.observableArrayList();
          row.add(customers.get(i).getName());
          row.add(customers.get(i).getAddress());
          row.add(String.valueOf(customers.get(i).getPostcode()));
          row.add(String.valueOf(customers.get(i).getCprNr()));
          row.add(String.valueOf(customers.get(i).getCostumerNo()));
          rows.add(row);
      }
     TV.setItems(rows);
      //Iterate Row
//        row = FXCollections.observableArrayList();
//      for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
//      {
//        //Iterate Column
//        row.add(rs.getString(i));
//      }
//      System.out.println("Row [1] added " + row);
//      list.add(row);
//
//    }
  }

    private void setUpColumn(TableView TV, String ColumnName)
    {
        TableColumn col = new TableColumn(ColumnName);

//        col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>()
//            {
//                public ObservableValue<String> call(
//                    TableColumn.CellDataFeatures<ObservableList, String> param)
//                {
//                    return new SimpleStringProperty(
//                        param.getValue().get(j).toString());
//                }
//            });

        TV.getColumns().addAll(col);
    }

}
