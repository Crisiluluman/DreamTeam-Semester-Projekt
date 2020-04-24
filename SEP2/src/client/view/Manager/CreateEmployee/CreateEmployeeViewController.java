package client.view.Manager.CreateEmployee;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CreateEmployeeViewController implements viewController {
@FXML
  private Label LabelErrorName;
@FXML
  private Label LabelErrorAddress;
@FXML
  private Label LabelErrorID;
@FXML
private Label LabelErrorEmail;
@FXML
private Label LabelErrorPhone;
  private ViewHandler vh;
    private CreateEmployeeViewModel cev;
    private Region root;
    @FXML private TextField name;
    @FXML private TextField address;
    @FXML private TextField CPR;
    @FXML private ChoiceBox position;
    @FXML private TextField email;
    @FXML private TextField phone;
  ObservableList<String> options =
      FXCollections.observableArrayList(
          "Manager",
          "DamageEmployee",
          "Salesman"
      );

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Region root) {
        this.vh = vh;
        cev = vmf.getCreateEmployeeViewModel();
        this.root = root;
        name.textProperty().bindBidirectional(cev.nameProperty());
        address.textProperty().bindBidirectional(cev.addressProperty());
        CPR.textProperty().bindBidirectional(cev.CPRProperty());
        email.textProperty().bindBidirectional(cev.emailProperty());
        phone.textProperty().bindBidirectional(cev.phoneProperty());

        position.setItems(options);
        position.setValue(options.get(0));
        cev.clearTextFields();
        cev.clearLabel();
    }

    @Override
    public Region getRoot() {
        return root;
    }
    public void onCreate()
    {
      if (cev.checker())
      {
        cev.onCreate((String) position.getValue());
        cev.clearTextFields();
        vh.openView("ManageEmployee");
      }
    }

    public void onBack()
    {
      cev.clearLabel();
      cev.clearTextFields();
      vh.openView("ManageEmployee");
    }
}
