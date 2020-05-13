package client.view.Salesman.CreatePolice;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

import java.util.regex.Pattern;

public class CreatePoliceViewController implements viewController
{
  @FXML
  private Label LabelErrorPrice;
  @FXML
  private Label LabelErrorDeductible;
  @FXML
  private Label LabelErrorCoverage;
  @FXML
  private Label LabelErrorPolicyNr;
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

  public Label getLabelErrorPrice()
  {
    return LabelErrorPrice;
  }

  public Label getLabelErrorDeductible()
  {
    return LabelErrorDeductible;
  }

  public Label getLabelErrorCoverage()
  {
    return LabelErrorCoverage;
  }

  public Label getLabelErrorPolicyNr()
  {
    return LabelErrorPolicyNr;
  }

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
       LabelErrorPolicyNr.textProperty().bind(cpv.labelPolicyNrProperty());
       LabelErrorPrice.textProperty().bind(cpv.labelPriceProperty());
       LabelErrorDeductible.textProperty().bind(cpv.labelDeductibleProperty());
       LabelErrorCoverage.textProperty().bind(cpv.labelCoverageProperty());

  policyType.setItems(options);
  clearAll();
  }

    @Override
    public Region getRoot() {
        return root;
    }
    public void clearAll()
    {
      coverage.clear();
      price.clear();
      deductible.clear();
      Customer.clear();
      policyNr.clear();
    cpv.labelCoverageProperty().setValue("");
    cpv.labelDeductibleProperty().setValue("");
    cpv.labelPolicyNrProperty().setValue("");
    cpv.labelPriceProperty().setValue("");
    }

    public void onBack()
    {
      clearAll();
      vh.openView("Policies");
    }
    public void onCreate()
    {

    if (cpv.checker())
    {

      cpv.createPolicy((String) policyType.getValue());
      clearAll();
      vh.openView("Policies");
    }

    }
}
