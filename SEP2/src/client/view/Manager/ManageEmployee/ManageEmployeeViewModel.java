package client.view.Manager.ManageEmployee;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.DamageEmployee.DamageEmployee;
import javafx.beans.property.ReadOnlyObjectWrapper;
import shared.Employee;
import client.model.Manager.Manager;
import client.model.Model;
import client.view.Manager.EditEmployee.EditEmployeeViewModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import shared.Policy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class ManageEmployeeViewModel
{
  private Model model;
  private EditEmployeeViewModel e;
  ObservableList<ObservableList> rows;
  ObservableList<String> row;
  ViewModelFactory viewModelFactory;

  public ManageEmployeeViewModel(Model model)
  {
    this.model = model;
  }


  public void readEmployee(TableView TV)
  {
    List<Employee> employees = model.readEmployee();
    ObservableList<String> row;
    rows = FXCollections.observableArrayList();


    setUpColumn(TV, "name",0);
    setUpColumn(TV, "address",1);
    setUpColumn(TV, "cpr",2);
    setUpColumn(TV, "email",3);
    setUpColumn(TV, "tlfnr",4);
    setUpColumn(TV, "position",5);



    for (int i = 0; i < employees.size()  ; i++)
    {
      row = FXCollections.observableArrayList();
      row.add(employees.get(i).getName());
      row.add(employees.get(i).getAddress());
      row.add(String.valueOf(employees.get(i).getCPR()));
      row.add(employees.get(i).getEmail());
      row.add(String.valueOf(employees.get(i).getTlfNr()));
      row.addAll(employees.get(i).getPosition());
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
    int selected = TV.getSelectionModel().getFocusedIndex();
    if (selected != -1)
    {
      return rows.get(selected);
    }
    return null;

  }
  public void Delete(TableView TV)
  {
    int selected = TV.getSelectionModel().getSelectedIndex();
    if (selected != -1)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmation Dialog");
      alert.setHeaderText("Deletion of a Employee");
      alert.setContentText("Are you sure you want to delete this Employee?");

      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == ButtonType.OK){
        //her kalder vi på metoden som sletter en employee fra databasen
      } else {
        //gør ingenting
      }
    }
  }
}

