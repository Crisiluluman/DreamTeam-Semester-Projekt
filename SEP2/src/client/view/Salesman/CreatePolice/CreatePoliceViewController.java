package client.view.Salesman.CreatePolice;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.scene.layout.Region;

public class CreatePoliceViewController implements viewController
{

  private ViewHandler vh;
  private CreatePoliceViewModel cpv;
  private Region root;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
       this.vh = vh;
       cpv = vmf.getCreatePoliceViewModel();
       this.root = root;
  }
}
