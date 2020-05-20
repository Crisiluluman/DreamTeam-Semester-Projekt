package client.view.Salesman.Policies;

import client.model.Model;
import shared.Policy;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.util.List;
import java.util.Optional;

public class PoliciesViewModel
{
  private Model model;
  ObservableList<ObservableList> rows;
  ObservableList<String> row;


  public PoliciesViewModel(Model model)
  {
    this.model = model;

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

  public void readPolicy(TableView TV)
  {
    List<Policy> policies = model.readPolicy();
    ObservableList<String> row;
    rows = FXCollections.observableArrayList();


    setUpColumn(TV, "policyNo",0);
    setUpColumn(TV, "type",1);
    setUpColumn(TV, "price",2);
    setUpColumn(TV, "deductible",3);
    setUpColumn(TV, "coverage",4);


    for (int i = 0; i < policies.size()  ; i++)
    {
      row = FXCollections.observableArrayList();
      row.add(String.valueOf(policies.get(i).getPoliceNo()));
      row.add(policies.get(i).getPoliceType());
      row.add(String.valueOf(policies.get(i).getPrice()));
      row.add(String.valueOf(policies.get(i).getDeductible()));
      row.add(policies.get(i).getCoverage());
      rows.add(row);
    }
    TV.setItems(rows);
  }

  public void Delete(TableView TV)
  {
    int selected = TV.getSelectionModel().getSelectedIndex();
    ObservableList list = rows.get(selected);
    if (selected != -1)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmation Dialog");
      alert.setHeaderText("Deletion of a policy");
      alert.setContentText("Are you sure you want to delete this policy?");

      Optional<ButtonType> result = alert.showAndWait();
      if (result.get() == ButtonType.OK){
        //her kalder vi på metoden som sletter policy fra databasen
        model.deletePolicy(Integer.parseInt((String) list.get(0)));
        System.out.println("Policy deleted");
      } else {
        //gør ingenting
      }
    }
  }
}
