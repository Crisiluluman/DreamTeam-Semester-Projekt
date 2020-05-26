package client.view.Salesman.Policies;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

public class PoliciesViewController implements viewController
{

  private ViewHandler vh;
  private PoliciesViewModel pvm;
  private Region root;
  @FXML TableView tableview;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
    this.vh = vh;
    pvm = vmf.getPoliciesViewModel();
    this.root = root;
   pvm.readPolicy(tableview,pvm.getCustomerNo());

  }

  @Override
  public Region getRoot() {
    return root;
  }

  public void onBack()
  {
      vh.updateCustomerViews();
      vh.openView("Salesman");


  }
  public void onCreatePolicy()
  {
    vh.openView("CreatePolicy");

  }
  public void onSelect()
  {

    ObservableList data = pvm.editSelect(tableview);
    if (data != null)
{
  vh.openEditSEditPolice(data);
}
  }

  public void onDelete()
  {
    pvm.Delete(tableview);
    if(pvm.getUpdate())
    {
      vh.updatePolicyViews();
    }
  }
}
