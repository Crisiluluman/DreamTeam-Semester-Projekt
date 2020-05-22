package client.view;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.scene.layout.Region;


public interface viewController
{


  void init(ViewHandler vh, ViewModelFactory vmf, Region root);
  Region getRoot();


}
