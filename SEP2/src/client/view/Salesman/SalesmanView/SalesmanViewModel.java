package client.view.Salesman.SalesmanView;

import client.core.ViewModelFactory;
import client.model.Model;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import shared.Customer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class SalesmanViewModel implements PropertyChangeListener
{
  private Model model;
  private StringProperty searchField;
  ObservableList<ObservableList> rows;
  ObservableList<String> row;
  private ViewModelFactory viewModelFactory;
  public boolean update;

  public SalesmanViewModel(Model model)
  {
    this.model = model;
    this.model.addListener(this);
    update = false;

    searchField = new SimpleStringProperty();
  }

  public void readCustomer(TableView TV)
  {
    List<Customer> customers = model.readCustomer();
    ObservableList<String> row;
    rows = FXCollections.observableArrayList();

    if(TV.getColumns().size() == 0)
    {
      setUpColumn(TV, "name", 0);
      setUpColumn(TV, "address", 1);
      setUpColumn(TV, "postcode", 2);
      setUpColumn(TV, "cpr", 3);
      setUpColumn(TV, "customerno", 4);
      setUpColumn(TV,"combined ratio",5);
    }

    for (int i = 0; i < customers.size()  ; i++)
    {
      row = FXCollections.observableArrayList();
      row.add(customers.get(i).getName());
      row.add(customers.get(i).getAddress());
      row.add(String.valueOf(customers.get(i).getPostcode()));
      row.add(String.valueOf(customers.get(i).getCprNr()));
      row.add(String.valueOf(customers.get(i).getCustomerNo()));
      row.add(String.valueOf(model.readDamage(model.readPolicy(customers.get(i).getCustomerNo()).get(i).getPoliceNo())));
      rows.add(row);
    }
    TV.setItems(rows);
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
  public ObservableList editSelect(TableView TV)
  {
    int selected = TV.getSelectionModel().getSelectedIndex();
    if (selected != -1)
    {
      return rows.get(selected);
    }
    return null;
  }

  public void Delete(TableView TV)
  {
    int selected = TV.getSelectionModel().getSelectedIndex();
    ObservableList list = rows.get(selected);
    if (selected != -1)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmation Dialog");
      alert.setHeaderText("Deletion of a customer");
      alert.setContentText("Are you sure you want to delete this customer?");

      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == ButtonType.OK){
       model.deleteCustomer(Integer.parseInt((String) list.get(4)));
       System.out.println("deleted" + list.get(4));
      } else {
        //gør ingenting
      }
    }
  }

  public boolean getUpdate()
  {
    return update;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    update = true;
  }
}
