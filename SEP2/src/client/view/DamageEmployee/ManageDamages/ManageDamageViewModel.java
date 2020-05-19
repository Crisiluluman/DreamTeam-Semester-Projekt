package client.view.DamageEmployee.ManageDamages;

import client.model.Damage.Damage;
import client.model.Model;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import shared.Policy;

import java.util.List;

public class ManageDamageViewModel
{
  Model model;
  ObservableList<ObservableList> rows;
  int policeNo;

  public ManageDamageViewModel(Model model)
  {
    this.model=model;
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


    setUpColumn(TV, "policyNo",0);
    setUpColumn(TV, "DamageNo",1);
    setUpColumn(TV, "expenses",2);
    setUpColumn(TV, "info",3);
    setUpColumn(TV, "policyType",4);


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

}
