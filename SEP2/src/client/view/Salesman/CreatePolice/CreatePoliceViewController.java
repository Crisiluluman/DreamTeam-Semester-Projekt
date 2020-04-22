package client.view.Salesman.CreatePolice;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CreatePoliceViewController implements viewController
{
@FXML
private ChoiceBox policyType;
@FXML
 private TextField policyNr;
@FXML
  private TextField price;
@FXML
  private TextField deductible;
@FXML
  private TextField coverage;
@FXML
  private TextField Customer;
@FXML
  private ViewHandler vh;
  private CreatePoliceViewModel cpv;
  private Region root;


  ObservableList<String> options =
      FXCollections.observableArrayList(
          "House",
          "Home",
          "Car",
          "Accidents"
      );

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
       this.vh = vh;
       cpv = vmf.getCreatePoliceViewModel();
       this.root = root;
       policyNr.textProperty().bindBidirectional(cpv.policyNrProperty());
       price.textProperty().bindBidirectional(cpv.priceProperty());
       deductible.textProperty().bindBidirectional(cpv.deductibleProperty());
       coverage.textProperty().bindBidirectional(cpv.coverageProperty());
       Customer.textProperty().bindBidirectional(cpv.customerProperty());

  policyType.setItems(options);
  }

    @Override
    public Region getRoot() {
        return root;
    }

    public void onBack()
    {
      vh.openView("Policies");
    }
    public void onCreate()
    {
      cpv.createPolicy((String) policyType.getValue());
    }
}
