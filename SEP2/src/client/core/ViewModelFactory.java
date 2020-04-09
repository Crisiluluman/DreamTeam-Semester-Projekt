package client.core;

import client.view.DamageEmployee.CreateDamage.CreateDamageViewModel;
import client.view.DamageEmployee.DEMain.DEMainViewModel;
import client.view.DamageEmployee.EditPolicy.EditPolicyViewModel;
import client.view.DamageEmployee.Policies.PoliciesViewModel;
import client.view.Login.LoginViewModel;
import client.view.Manager.ManageBusiness.ManageBusinessViewModel;
import client.view.Manager.ManagerView.ManagerViewModel;
import client.view.Salesman.CreateCustomer.CreateCustomerViewModel;
import client.view.Salesman.ManageCustomer.ManageCustomerViewModel;
import client.view.Salesman.SalesmanView.SalesmanViewModel;

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
  private CreateCustomerViewModel ccv;
  private SalesmanViewModel svm;
  private ManageCustomerViewModel mcv;
  private ManagerViewModel mvm;
  private ManageBusinessViewModel mb;

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

  public CreateCustomerViewModel getCreateCustomerViewModel()
  {
    if(ccv == null)
    {
      ccv = new CreateCustomerViewModel(modelFactory.getModel());
    }
    return ccv;
  }
  public SalesmanViewModel getSalesmanViewModel()
  {
    if(svm == null)
    {
      svm = new SalesmanViewModel(modelFactory.getModel());
    }
    return svm;
  }
  public ManageCustomerViewModel getManageCustomerViewModel()
  {
    if(mcv == null)
    {
      mcv = new ManageCustomerViewModel(modelFactory.getModel());
    }
    return mcv;
  }
  public ManagerViewModel getManagerViewModel()
  {
    if(mvm == null)
    {
      mvm = new ManagerViewModel(modelFactory.getModel());
    }
    return mvm;
  }
  public ManageBusinessViewModel getManageBusinessViewModel()
  {
    if(mb == null)
    {
      mb = new ManageBusinessViewModel(modelFactory.getModel());
    }
    return mb;
  }

}
