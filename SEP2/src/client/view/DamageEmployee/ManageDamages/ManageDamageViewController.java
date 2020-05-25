package client.view.DamageEmployee.ManageDamages;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.Manager.ManageEmployee.ManageEmployeeViewModel;
import client.view.viewController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

public class ManageDamageViewController implements viewController
{
  @FXML
  public TableView view;
  ViewHandler vh;
  Region root;
  ManageDamageViewModel mdvm;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
    this.vh=vh;
    mdvm=vmf.getDamageViewModel();
    this.root=root;
    mdvm.readPolicy(view,mdvm.getPoliceNo());

  }

  @Override public Region getRoot()
  {
    return root;
  }

  public void onBack()
  {
        vh.openView("DEPolicies");
  }

  public void onCreate()
  {
    vh.openView("CreateDamage");
  }
  public void onSelect()
  {
    ObservableList data = mdvm.editSelect(view);
    if (data != null)
    {
      vh.openEditDamage(data);
    }
  }

  public void onDelete()
  {
    mdvm.Delete(view);
    if (mdvm.getUpdate())
    {
      vh.updateDamageViews();
    }
  }

}
