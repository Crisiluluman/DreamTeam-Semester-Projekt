package client.view.DamageEmployee.Policies.EditPolicy;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


public class EditPolicyViewController implements viewController {

    private ViewHandler vh;
    private EditPolicyViewModel epv;
    private Region root;

    @FXML TextField policyNr;
    @FXML TextField price;
    @FXML TextField deductible;
    @FXML TextField coverage;
    @FXML TextField Customer;
    @FXML ChoiceBox policyType;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Region root) {
        this.vh = vh;
        epv = vmf.getEditPolicyViewModel();
        this.root = root;

    }
    @Override
    public Region getRoot() {
        return root;
    }
}
