package client.core;

import client.view.DamageEmployee.CreateDamage.CreateDamageViewModel;
import client.view.DamageEmployee.DEMain.DEMainViewModel;
import client.view.DamageEmployee.EditDamage.EditDamageViewModel;
import client.view.DamageEmployee.ManageDamages.ManageDamageViewModel;
import client.view.DamageEmployee.Policies.EditPolicy.EditPolicyViewModel;
import client.view.DamageEmployee.Policies.DEPoliciesViewModel;
import client.view.Login.LoginViewModel;
import client.view.Manager.CreateEmployee.CreateEmployeeViewModel;
import client.view.Manager.EditEmployee.EditEmployeeViewModel;
import client.view.Manager.ManageBusiness.ManageBusinessViewModel;
import client.view.Manager.ManageEmployee.ManageEmployeeViewModel;
import client.view.Manager.ManagerView.ManagerViewModel;
import client.view.Salesman.CreateCustomer.CreateCustomerViewModel;
import client.view.Salesman.CreatePolice.CreatePoliceViewModel;
import client.view.Salesman.ManageCustomer.ManageCustomerViewModel;
import client.view.Salesman.Policies.PoliciesViewModel;
import client.view.Salesman.SEditPolicy.SEditPolicyViewModel;
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
  private DEPoliciesViewModel DEpvm;
  private EditPolicyViewModel epv;
  private CreateDamageViewModel cdv;
  private CreateCustomerViewModel ccv;
  private SalesmanViewModel svm;
  private ManageCustomerViewModel mcv;
  private ManagerViewModel mvm;
  private ManageBusinessViewModel mb;
  private PoliciesViewModel pvm;
  private CreatePoliceViewModel cpv;
  private CreateEmployeeViewModel cev;
  private EditEmployeeViewModel eev;
  private ManageEmployeeViewModel mevm;
  private SEditPolicyViewModel spev;
  private ManageDamageViewModel mdvm;
  private EditDamageViewModel edv;

  public CreatePoliceViewModel getCreatePoliceViewModel()
  {
    if(cpv == null)
    {
      cpv = new CreatePoliceViewModel(modelFactory.getModel());
    }
    return cpv;
  }

public ManageDamageViewModel getDamageViewModel()
{
  if (mdvm == null)
  {
    mdvm = new ManageDamageViewModel(modelFactory.getModel());
  }
  return mdvm;
}

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
  public DEPoliciesViewModel getDEPoliciesViewModel()
  {
    if(DEpvm == null)
    {
      DEpvm = new DEPoliciesViewModel(modelFactory.getModel());
    }
    return DEpvm;
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

  public ManageEmployeeViewModel getManageEmployeeViewModel()
  {
    if (mevm == null)
    {
      mevm = new ManageEmployeeViewModel(modelFactory.getModel());
    }
    return mevm;
  }

    public PoliciesViewModel getPoliciesViewModel()
  {
    if(pvm == null)
    {
      pvm = new PoliciesViewModel(modelFactory.getModel());
    }
    return pvm;
  }

  public CreateEmployeeViewModel getCreateEmployeeViewModel()
  {
    if(cev == null)
    {
      cev = new CreateEmployeeViewModel(modelFactory.getModel());
    }
    return cev;
  }

  public EditEmployeeViewModel getEditEmployeeViewModel()
  {
    if(eev == null)
    {
      eev = new EditEmployeeViewModel(modelFactory.getModel());
    }
    return eev;
  }

  public SEditPolicyViewModel getSEditPolicyViewModel()
{
  if(spev == null)
  {
    spev = new SEditPolicyViewModel(modelFactory.getModel());
  }
  return spev;
}
  public EditDamageViewModel getEditDamage()
  {
    if(edv == null)
    {
      edv = new EditDamageViewModel(modelFactory.getModel());
    }
    return edv;
  }
}
