package client.view.Manager.ManagerView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class ManagerViewController implements viewController
{
  public Label loggedInLabel;

  private ManagerViewModel mvm;
  private ViewHandler vh;
  private Region root;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
    this.vh = vh;
    this.root = root;
    mvm = vmf.getManagerViewModel();
  }
}
