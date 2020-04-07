package client.view;

import client.core.ViewHandler;
import client.core.ViewModelFactory;

import javax.swing.plaf.synth.Region;


public interface viewController
{
  void init(ViewHandler vh, ViewModelFactory vmf, Region root);


}
