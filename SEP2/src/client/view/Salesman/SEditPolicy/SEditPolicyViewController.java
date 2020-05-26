package client.view.Salesman.SEditPolicy;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class SEditPolicyViewController implements viewController {

    private ViewHandler vh;
    private SEditPolicyViewModel epv;
    private Region root;

    @FXML TextField policyNr;
    @FXML TextField price;
    @FXML TextField deductible;
    @FXML TextField coverage;
    @FXML TextField Customer;
    @FXML ChoiceBox policyType;

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
        epv = vmf.getSEditPolicyViewModel();
        this.root = root;
        price.textProperty().bindBidirectional(epv.priceProperty());
        deductible.textProperty().bindBidirectional(epv.deductibleProperty());
        coverage.textProperty().bindBidirectional(epv.coverageProperty());
      policyType.setItems(options);
      epv.setChoiceBox(policyType);

    }
    @Override
    public Region getRoot() {
        return root;
    }

    public void onBack()
    {
        vh.openView("Policies");
    }
}
