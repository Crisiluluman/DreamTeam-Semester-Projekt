package client.view.DamageEmployee.EditDamage;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class EditDamageViewController implements viewController
{

  @FXML public Label expensesLabel;
  @FXML public Label damageNoLabel;

  public TextField expensesTextfield;
  public TextArea infoTextArea;
  public ChoiceBox policyDropdown;
  private Region Root;
  EditDamageViewModel edv;
  ViewHandler vh;
  ObservableList<String> options =
      FXCollections.observableArrayList(
          "House",
          "Home",
          "Car",
          "Accidents"
      );


  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
    this.vh=vh;
    edv = vmf.getEditDamage();
    Root=root;
    expensesTextfield.textProperty().bindBidirectional(edv.expensesProperty());
    infoTextArea.textProperty().bindBidirectional(edv.infoProperty());
    System.out.println(edv.policyDropDownProperty().getValue());
    policyDropdown.setItems(options);
    edv.setChoiceBox(policyDropdown);
    expensesLabel.textProperty().bind(edv.getExpensesLabel());
    damageNoLabel.textProperty().bind(edv.getDamageNoLabel());
    edv.clearLabels();
  }

  @Override public Region getRoot()
  {
    return Root;
  }

  public void onBack()
  {
    vh.openView("ManageDamage");
  }
  public void onSave()
  {
    if(edv.checker())
    {
      edv.onSave();
      if(edv.getUpdate())
      {
        vh.updateDamageViews();
        vh.openView("ManageDamage");
      }
    }

  }
}
