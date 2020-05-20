package client.view.DamageEmployee.Policies;

import client.core.ViewModelFactory;
import client.model.Model;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import shared.Policy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DEPoliciesViewModel
{
    private Model model;
    ObservableList<ObservableList> rows;
    ObservableList<String> row;
    private int customerNo;

    public DEPoliciesViewModel(Model model)
    {
        this.model = model;

    }

    public void setCustomerNo(ObservableList list)
    {
        customerNo = Integer.parseInt((String) list.get(4));
    }
    public void readPolicy(TableView TV,int customerNo)
    {
        List<Policy> policies = model.readPolicy(customerNo);
        ObservableList<String> row;
        rows = FXCollections.observableArrayList();


        setUpColumn(TV, "policyNo",0);
        setUpColumn(TV, "type",1);
        setUpColumn(TV, "price",2);
        setUpColumn(TV, "deductible",3);
        setUpColumn(TV, "coverage",4);
        setUpColumn(TV,"customerNo",5);


        for (int i = 0; i < policies.size()  ; i++)
        {
            row = FXCollections.observableArrayList();
            row.add(String.valueOf(policies.get(i).getPoliceNo()));
            row.add(policies.get(i).getPoliceType());
            row.add(String.valueOf(policies.get(i).getPrice()));
            row.add(String.valueOf(policies.get(i).getDeductible()));
            row.add(policies.get(i).getCoverage());
            row.add(String.valueOf(policies.get(i).getCustomerNo()));
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

    public int getCustomerNo()
    {
        return customerNo;
    }
}
