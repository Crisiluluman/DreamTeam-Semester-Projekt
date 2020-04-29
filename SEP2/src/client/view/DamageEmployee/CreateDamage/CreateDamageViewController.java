package client.view.DamageEmployee.CreateDamage;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;


public class CreateDamageViewController implements viewController {

    @FXML public ChoiceBox policyDropdown;
    @FXML public TextField expensesTextfield;
    @FXML public TextField damageNoTextfield;
    @FXML public TextArea infoTextArea;
    @FXML public Label expensesLabel;
    @FXML public Label damageNoLabel;
    @FXML public Button backButton;
    @FXML public Button createButton;

    private ViewHandler vh;
    private CreateDamageViewModel cdv;
    private Region root;

    ObservableList<String> options =
        FXCollections.observableArrayList(
            "House",
            "Home",
            "Car",
            "Accidents"
        );

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Region root) {
        this.vh = vh;
        cdv = vmf.getCreateDamageViewModel();
        this.root = root;

        policyDropdown.setItems(options);
        expensesTextfield.textProperty().bindBidirectional(cdv.getExpensesTextfield());
        damageNoTextfield.textProperty().bindBidirectional(cdv.getDamageNoTextfield());
        infoTextArea.textProperty().bindBidirectional(cdv.getInfoTextArea());

        expensesLabel.textProperty().bind(cdv.getExpensesLabel());
        damageNoLabel.textProperty().bind(cdv.getDamageNoLabel());

        cdv.clearTextfields();
    }
    @Override
    public Region getRoot() {
        return root;
    }

    public void clearAll()
    {
        expensesTextfield.clear();
        damageNoTextfield.clear();
        infoTextArea.clear();

        cdv.getExpensesLabel().setValue("");
        cdv.getDamageNoTextfield().setValue("");
        cdv.getInfoTextArea().setValue("");
    }


    public void onBack()
    {
        clearAll();
        vh.openView("Policies");
    }

    public void onCreate()
    {
        if (cdv.checker())
        {
            cdv.onClick();
            cdv.clearTextfields();
            cdv.clearLabels();
            vh.openView("Policies");
        }
    }

}
