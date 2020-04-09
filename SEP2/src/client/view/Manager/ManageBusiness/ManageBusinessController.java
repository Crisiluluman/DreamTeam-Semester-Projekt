package client.view.Manager.ManageBusiness;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.Manager.ManagerView.ManagerViewModel;
import client.view.viewController;
import javafx.scene.layout.Region;

public class ManageBusinessController implements viewController
{
  private ViewHandler vh;
  private ManagerViewModel mvm;
  private ManageBusinessViewModel mbvm;
  private Region root;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
    this.vh = vh;
    this.root = root;
    mbvm = vmf.getManageBusinessViewModel();
  }
}
