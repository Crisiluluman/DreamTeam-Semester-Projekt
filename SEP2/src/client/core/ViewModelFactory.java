package client.core;

import client.view.Login.LoginViewModel;

public class ViewModelFactory
{
  private final ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  private LoginViewModel lvm;

  public LoginViewModel getLoginViewModel()
  {
    if(lvm == null)
    {
      lvm = new LoginViewModel(modelFactory.getModel());

    }
    return lvm;
  }
}
