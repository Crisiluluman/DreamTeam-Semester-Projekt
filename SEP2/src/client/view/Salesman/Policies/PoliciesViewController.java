package client.view.Salesman.Policies;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
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

  }
}
