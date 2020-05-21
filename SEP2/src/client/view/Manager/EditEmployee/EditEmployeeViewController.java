package client.view.Manager.EditEmployee;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.Manager.ManageEmployee.ManageEmployeeViewModel;
import client.view.viewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class EditEmployeeViewController implements viewController {

    @FXML private Label nameLabel;
    @FXML private Label addressLabel;
    @FXML private Label idLabel;
    @FXML private Label positionLabel;
    @FXML private Label emailLabel;
    @FXML private Label phoneLabel;
    private ViewHandler vh;
    private EditEmployeeViewModel eev;
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
        eev = vmf.getEditEmployeeViewModel();
        this.root = root;
        name.textProperty().bindBidirectional(eev.getNameTextFieldProperty());
        address.textProperty().bindBidirectional(eev.getAddressTextFieldProperty());
        CPR.textProperty().bindBidirectional(eev.getCPRTextFieldProperty());
        email.textProperty().bindBidirectional(eev.getEmailTextFieldProperty());
        phone.textProperty().bindBidirectional(eev.getPhoneTextFieldProperty());
        nameLabel.textProperty().bind(eev.getNameLabelProperty());
        addressLabel.textProperty().bind(eev.getAddressLabelProperty());
        idLabel.textProperty().bind(eev.getCPRLabelProperty());
        positionLabel.textProperty().bind(eev.getPositionLabelProperty());
        emailLabel.textProperty().bind(eev.getEmailLabelProperty());
        phoneLabel.textProperty().bind(eev.getPhoneLabelProperty());
        position.setItems(options);
        eev.setChoiceBox(position);
    }

    public void onSave()
    {
        if (eev.checker())
        {
            eev.onSaveClicked((String) position.getValue());
            eev.clearTextFields();
            eev.clearLabels();
            vh.openView("ManageEmployee");
        }
    }

    public void onBack()
    {
        eev.clearTextFields();
        eev.clearLabels();
        vh.openView("ManageEmployee");
    }

    @Override
    public Region getRoot() {
        return root;
    }
}
