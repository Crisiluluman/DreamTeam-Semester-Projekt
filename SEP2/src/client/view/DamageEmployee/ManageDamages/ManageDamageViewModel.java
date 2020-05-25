package client.view.DamageEmployee.ManageDamages;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import shared.*;
import client.model.Model;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.Optional;

public class ManageDamageViewModel implements PropertyChangeListener
{
  Model model;
  ObservableList<ObservableList> rows;
  int policeNo;
  private boolean update;

  public ManageDamageViewModel(Model model)
  {
    this.model = model;
    this.model.addListener(this);
    update = false;
  }

  public void setPoliceNo(ObservableList list)
{
  policeNo = Integer.parseInt((String) list.get(0));
}

  public int getPoliceNo()
  {
    return policeNo;
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

  public void readPolicy(TableView TV,int policeno)
  {
      List<Damage> damages = model.readDamage(policeno);
      ObservableList<String> row;
      rows = FXCollections.observableArrayList();

    if (TV.getColumns().size() == 0)
    {

      setUpColumn(TV, "policyNo", 0);
      setUpColumn(TV, "DamageNo", 1);
      setUpColumn(TV, "expenses", 2);
      setUpColumn(TV, "info", 3);
      setUpColumn(TV, "policyType", 4);
    }
      for (int i = 0; i < damages.size()  ; i++)
      {
        row = FXCollections.observableArrayList();
        row.add(String.valueOf(damages.get(i).getPoliceNo()));
        row.add(String.valueOf(damages.get(i).getDamageNo()));
        row.add(String.valueOf(damages.get(i).getExpenses()));
        row.add(damages.get(i).getInfo());
        row.add(damages.get(i).getPoliceType());
        rows.add(row);
      }
    TV.setItems(rows);
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
    ObservableList list = rows.get(selected);
    if (selected != -1)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmation Dialog");
      alert.setHeaderText("Deletion of a Employee");
      alert.setContentText("Are you sure you want to delete this Employee?");


      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == ButtonType.OK){
        //her kalder vi på metoden som sletter en employee fra databasen
        model.deleteDamage(Integer.parseInt((String) list.get(1)));
        System.out.println("Damage deleted");
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
