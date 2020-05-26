package client.view.Salesman.CreatePolicy;

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

public class CreatePoliceViewController implements viewController
{
  @FXML
  private Label LabelErrorPrice;
  @FXML
  private Label LabelErrorDeductible;
  @FXML
  private Label LabelErrorCoverage;
  @FXML
  private ChoiceBox policyType;
  @FXML
  private TextField price;
  @FXML
  private TextField deductible;
  @FXML
  private TextField coverage;
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
       price.textProperty().bindBidirectional(cpv.priceProperty());
       deductible.textProperty().bindBidirectional(cpv.deductibleProperty());
       coverage.textProperty().bindBidirectional(cpv.coverageProperty());
       LabelErrorPrice.textProperty().bind(cpv.labelPriceProperty());
       LabelErrorDeductible.textProperty().bind(cpv.labelDeductibleProperty());
       LabelErrorCoverage.textProperty().bind(cpv.labelCoverageProperty());

  policyType.setItems(options);
  policyType.setValue(options.get(0));
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
    cpv.labelCoverageProperty().setValue("");
    cpv.labelDeductibleProperty().setValue("");
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
        if(cpv.getUpdate())
      {
        vh.updatePolicyViews();
        vh.openView("Policies");
      }
      }



    }
}
