package client.view.Login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;

import javax.swing.plaf.synth.Region;

public class LoginViewController implements viewController
{

  private ViewHandler vh;
  private LoginViewModel lvm;
  private Region root;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
    this.vh = vh;
    this.lvm = vmf.getLoginViewModel();
    this.root = root;
  }


}
