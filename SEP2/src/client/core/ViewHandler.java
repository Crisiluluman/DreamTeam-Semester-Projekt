package client.core;


import client.view.DamageEmployee.CreateDamage.CreateDamageViewController;
import client.view.DamageEmployee.DEMain.DEMainViewController;
import client.view.DamageEmployee.EditDamage.EditDamageViewController;
import client.view.DamageEmployee.ManageDamages.ManageDamageViewController;
import client.view.DamageEmployee.Policies.DEPoliciesViewController;
import client.view.DamageEmployee.Policies.EditPolicy.EditPolicyViewController;
import client.view.Login.LoginViewController;
import client.view.Manager.CreateEmployee.CreateEmployeeViewController;
import client.view.Manager.EditEmployee.EditEmployeeViewController;
import client.view.Manager.ManageBusiness.ManageBusinessController;
import client.view.Manager.ManageEmployee.ManageEmployeeController;
import client.view.Manager.ManagerView.ManagerViewController;
import client.view.Salesman.CreateCustomer.CreateCustomerViewController;
import client.view.Salesman.CreatePolicy.CreatePoliceViewController;
import client.view.Salesman.ManageCustomer.ManageCustomerViewController;
import client.view.Salesman.Policies.PoliciesViewController;
import client.view.Salesman.SEditPolicy.SEditPolicyViewController;
import client.view.Salesman.SalesmanView.SalesmanViewController;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler extends Application
{
  private ViewModelFactory vmf;
  private Stage primaryStage;
  private Scene currentScene;
  private CreateDamageViewController createDamageViewController;
  private DEMainViewController deMainViewController;
  private DEPoliciesViewController depoliciesViewController;
  private EditPolicyViewController editPolicyViewController;
  private LoginViewController loginViewController;
  private CreateEmployeeViewController createEmployeeViewController;
  private EditEmployeeViewController editEmployeeViewController;
  private ManageBusinessController manageBusinessController;
  private ManageEmployeeController manageEmployeeController;
  private ManagerViewController managerViewController;
  private CreateCustomerViewController createCustomerViewController;
  private CreatePoliceViewController createPoliceViewController;
  private ManageCustomerViewController manageCustomerViewController;
  private PoliciesViewController policiesViewController;
  private SalesmanViewController salesmanViewController;
  private SEditPolicyViewController sEditPolicyViewController;
  private ManageDamageViewController manageDamageViewController;
  private EditDamageViewController editDamageViewController;


  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
  }
  @Override public void start(Stage stage)
  {
primaryStage = stage;
currentScene = new Scene(new Region());
openView("DEMain");
  }


  public void updateEmployeeViews()
  {
    manageEmployeeController.init(this,vmf,manageEmployeeController.getRoot());
  }

  public void updateCustomerViews()
  {
    salesmanViewController.init(this,vmf,salesmanViewController.getRoot());
  }

  public void updatePolicyViews()
  {
    policiesViewController.init(this,vmf,policiesViewController.getRoot());
  }

  public void updateDEPolicyViews()
  {
    depoliciesViewController.init(this,vmf,depoliciesViewController.getRoot());
  }

  public void updateDamageViews(){
    manageDamageViewController.init(this,vmf,manageDamageViewController.getRoot());
  }

  public void openEditSEditPolice(ObservableList list)
{
  vmf.getSEditPolicyViewModel().setFields(list);
  openView("SEditPolice");
}

  public void openEditManageCustomer(ObservableList list)
  {
    vmf.getManageCustomerViewModel().setFields(list);
    openView("ManageCustomer");
  }

  public void openEditEditEmployee(ObservableList list)
  {
    vmf.getEditEmployeeViewModel().setFields(list);
    openView("EditEmployee");
  }
  public void openEditDEEditPolice(ObservableList list)
  {
    vmf.getEditPolicyViewModel().setFields(list);
    openView("EditPolicy");
  }

  public void openManageDamage(ObservableList list)
  {
    vmf.getCreateDamageViewModel().setFields(list);
    vmf.getCreateDamageViewModel().setOnClick(list);
    vmf.getDamageViewModel().setPoliceNo(list);
    openView("ManageDamage");
  }
  public void openEditDamage(ObservableList list)
  {
    vmf.getEditDamage().setFields(list);
    openView("EditDamage");
  }
  public void openSPolicies(ObservableList list)
  {
    vmf.getPoliciesViewModel().setCustomerNo(list);
    vmf.getCreatePoliceViewModel().setCustomerNo(list);
    openView("Policies");
  }
public void openDEPolicies(ObservableList list)
{
  vmf.getDEPoliciesViewModel().setCustomerNo(list);
  openView("DEPolicies");
}

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "Login":
        root = loadLoginView("../view/Login/LoginView.fxml");
        break;
      case "CreateDamage":
        root = loadCreateDamageView("../view/DamageEmployee/CreateDamage/CreateDamageView.fxml");
        break;
      case "DEMain":
        root = loadDEMainView("../view/DamageEmployee/DEMain/DEMainView.fxml");
        break;
      case "DEPolicies":
        root = loadDEPoliciesView("../view/DamageEmployee/Policies/DEPoliciesView.fxml");
        break;
      case "EditDamage":
        root = loadEditDamage("../view/DamageEmployee/EditDamage/EditDamageView.fxml");
        break;
      case "EditPolicy":
        root = loadEditPolicyView("../view/DamageEmployee/Policies/EditPolicy/EditPolicyView.fxml");
        break;
      case "CreateEmployee":
        root = loadCreateEmployeeView("../view/Manager/CreateEmployee/CreateEmployeeView.fxml");
        break;
      case "EditEmployee":
        root = loadEditEmployeeView("../view/Manager/EditEmployee/EditEmployeeView.fxml");
        break;
      case "ManageBusiness":
        root = loadManageBusinessView("../view/Manager/ManageBusiness/ManageBusinessView.fxml");
        break;
      case "ManageDamage":
        root = loadManageDamageView("../view/DamageEmployee/ManageDamages/ManageDamageView.fxml");
        break;
      case "ManageEmployee":
        root = loadManageEmployeeView("../view/Manager/ManageEmployee/ManageEmployeeView.fxml");
        break;
      case "Manager":
        root = loadManagerView("../view/Manager/ManagerView/ManagerView.fxml");
        break;
      case "CreateCustomer":
        root = loadCreateCustomerView("../view/Salesman/CreateCustomer/CreateCustomerView.fxml");
        break;
      case "CreatePolicy":
        root = loadCreatePoliceView("../view/Salesman/CreatePolicy/CreatePoliceView.fxml");
        break;
      case "ManageCustomer":
        root = loadManageCustomerView("../view/Salesman/ManageCustomer/ManageCustomerView.fxml");
        break;
      case "Policies":
        root = loadPoliciesView("../view/Salesman/Policies/PoliciesView.fxml");
        break;
      case "Salesman":
        root = loadSalesmanView("../view/Salesman/SalesmanView/SalesmanView.fxml");
        break;
      case "SEditPolice":
        root = loadSEditPolicyView("../view/Salesman/SEditPolicy/SEditPoliceView.fxml");
        break;

    }

    if (root != null)
    {
      currentScene.setRoot(root);

    }

    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }

    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(600);
    primaryStage.setHeight(600);
    primaryStage.show();

  }

  private Region loadSalesmanView(String fxmlFile) {
    if (salesmanViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        salesmanViewController = loader.getController();
        salesmanViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return salesmanViewController.getRoot();
  }

  private Region loadPoliciesView(String fxmlFile) {
    if (policiesViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        policiesViewController = loader.getController();
        policiesViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return policiesViewController.getRoot();
  }

  private Region loadManageCustomerView(String fxmlFile) {
    if (manageCustomerViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        manageCustomerViewController = loader.getController();
        manageCustomerViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return manageCustomerViewController.getRoot();
  }

  private Region loadCreatePoliceView(String fxmlFile) {
    if (createPoliceViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        createPoliceViewController= loader.getController();
        createPoliceViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return createPoliceViewController.getRoot();
  }

  private Region loadCreateCustomerView(String fxmlFile) {
    if (createCustomerViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        createCustomerViewController = loader.getController();
        createCustomerViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return createCustomerViewController.getRoot();
  }

  private Region loadManagerView(String fxmlFile) {
    if (managerViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        managerViewController = loader.getController();
        managerViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return managerViewController.getRoot();
  }

  private Region loadManageEmployeeView(String fxmlFile) {
    if (manageEmployeeController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        manageEmployeeController = loader.getController();
        manageEmployeeController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return manageEmployeeController.getRoot();
  }

  private Region loadManageBusinessView(String fxmlFile) {
    if (manageBusinessController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        manageBusinessController = loader.getController();
        manageBusinessController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return manageBusinessController.getRoot();
  }

  private Region loadEditEmployeeView(String fxmlFile) {
    if (editEmployeeViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        editEmployeeViewController = loader.getController();
        editEmployeeViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return editEmployeeViewController.getRoot();
  }

  private Region loadCreateEmployeeView(String fxmlFile) {
    if (createEmployeeViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        createEmployeeViewController = loader.getController();
        createEmployeeViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return createEmployeeViewController.getRoot();
  }

  private Region loadEditPolicyView(String fxmlFile) {
    if (editPolicyViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        editPolicyViewController = loader.getController();
        editPolicyViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return editPolicyViewController.getRoot();
  }

  private Region loadDEPoliciesView(String fxmlFile) {
    if (depoliciesViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        depoliciesViewController = loader.getController();
        depoliciesViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return depoliciesViewController.getRoot();
  }

  private Region loadDEMainView(String fxmlFile) {
    if (deMainViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        deMainViewController = loader.getController();
        deMainViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return deMainViewController.getRoot();
  }


  private Region loadLoginView(String fxmlFile) {
    if (loginViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        loginViewController = loader.getController();
        loginViewController.init(this,  vmf, root);
      } catch (Exception e)
      {
        e.printStackTrace();
      }
    }
      return loginViewController.getRoot();
  }

  private Region loadCreateDamageView(String fxmlFile)
  {
    if(createDamageViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        createDamageViewController = loader.getController();
        createDamageViewController.init(this, vmf, root);
      }catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return createDamageViewController.getRoot();
  }

  private Region loadSEditPolicyView(String fxmlFile)
  {
    if (sEditPolicyViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        sEditPolicyViewController = loader.getController();
       sEditPolicyViewController.init(this, vmf, root);
      }catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return sEditPolicyViewController.getRoot();
  }
  private Region loadManageDamageView(String fxmlFile)
  {
    if (manageDamageViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        manageDamageViewController = loader.getController();
        manageDamageViewController.init(this, vmf, root);
      }catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return manageDamageViewController.getRoot();
  }
  private Region loadEditDamage(String fxmlFile)
  {
    if (editDamageViewController == null)
    {
      try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root = loader.load();
        editDamageViewController = loader.getController();
        editDamageViewController.init(this, vmf, root);
      }catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    return editDamageViewController.getRoot();
  }

}




















