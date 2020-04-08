package client.core;

import client.view.DamageEmployee.CreateDamage.CreateDamageViewModel;
import client.view.DamageEmployee.DEMain.DEMainViewModel;
import client.view.DamageEmployee.EditPolicy.EditPolicyViewModel;
import client.view.DamageEmployee.Policies.PoliciesViewModel;
import client.view.Login.LoginViewModel;

public class ViewModelFactory
{
  private final ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
  }

  private LoginViewModel lvm;
  private DEMainViewModel dvm;
  private PoliciesViewModel pvm;
  private EditPolicyViewModel epv;
  private CreateDamageViewModel cdv;

  public LoginViewModel getLoginViewModel()
  {
    if(lvm == null)
    {
      lvm = new LoginViewModel(modelFactory.getModel());

    }
    return lvm;
  }

  public DEMainViewModel getDEMainViewModel()
  {
    if(dvm == null)
    {
      dvm = new DEMainViewModel(modelFactory.getModel());

    }
    return dvm;
  }

  public PoliciesViewModel getPoliciesViewModel()
  {
    if(pvm == null)
    {
      pvm = new PoliciesViewModel(modelFactory.getModel());
    }
    return pvm;
  }

  public EditPolicyViewModel getEditPolicyViewModel()
  {
    if(epv == null)
    {
      epv = new EditPolicyViewModel(modelFactory.getModel());
    }
    return epv;
  }

  public CreateDamageViewModel getCreateDamageViewModel()
  {
    if(cdv == null)
    {
      cdv = new CreateDamageViewModel(modelFactory.getModel());
    }
    return cdv;
  }
}
