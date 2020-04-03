package client.view;

import javax.swing.plaf.synth.Region;

public interface viewController
{
  void init(ViewHandler vh, ViewModelFactory vmf, Region root);
}
