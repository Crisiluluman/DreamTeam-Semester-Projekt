package client.view.DamageEmployee.DEMain;

import client.core.ViewModelFactory;
import client.model.Model;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import shared.Customer;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

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


      setUpColumn(TV, "name",0);
      setUpColumn(TV, "address",1);
      setUpColumn(TV, "postcode",2);
      setUpColumn(TV, "cpr",3);
      setUpColumn(TV, "customerno",4);


       for (int i = 0; i < customers.size()  ; i++)
      {
          row = FXCollections.observableArrayList();
          row.add(customers.get(i).getName());
          row.add(customers.get(i).getAddress());
          row.add(String.valueOf(customers.get(i).getPostcode()));
          row.add(String.valueOf(customers.get(i).getCprNr()));
          row.add(String.valueOf(customers.get(i).getCustomerNo()));
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

    private void setUpColumn(TableView TV, String ColumnName,int index)
    {
        TableColumn col = new TableColumn(ColumnName);

      col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList<String>, String>, ObservableValue<String>>() {
        public ObservableValue<String> call(
            TableColumn.CellDataFeatures<ObservableList<String>, String> p) {
          // p.getValue() returns the Person instance for a particular TableView row
          return new ReadOnlyObjectWrapper(p.getValue().get(index));
        }
      });

        TV.getColumns().addAll(col);
    }

}
