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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

public class DEMainViewModel {

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

    public void readCustomer(TableView TV){
        model.readCustomer(TV);
    }

}
