package client.view.Salesman.SalesmanView;

import client.core.ViewModelFactory;
import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.TableView;
import java.util.Optional;

public class SalesmanViewModel
{
  private Model model;
  private StringProperty searchField;
  ObservableList<ObservableList> list;
  ObservableList<String> row;
  private ViewModelFactory viewModelFactory;

  public SalesmanViewModel(Model model)
  {
    this.model = model;
    searchField = new SimpleStringProperty();
  }

  public ObservableList editSelect(TableView TV)
  {
    int selected = TV.getSelectionModel().getSelectedIndex();
    if (selected != -1)
    {
      return list.get(selected);
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
      alert.setHeaderText("Deletion of a customer");
      alert.setContentText("Are you sure you want to delete this customer?");

      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == ButtonType.OK){
        //her kalder vi på metoden som sletter customer fra databasen
      } else {
        //gør ingenting
      }
    }
  }
}
