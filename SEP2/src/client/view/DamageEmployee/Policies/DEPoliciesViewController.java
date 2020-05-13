package client.view.DamageEmployee.Policies;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;


public class DEPoliciesViewController implements viewController {

    private ViewHandler vh;
    private DEPoliciesViewModel pvm;
    private Region root;

    @FXML TableView view;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Region root) {

        this.vh = vh;
        pvm = vmf.getDEPoliciesViewModel();
        this.root = root;
        pvm.getEmployeesFromDB(view);
    }
    @Override
    public Region getRoot() {
        return root;
    }

    public void onSelect()
    {
        ObservableList data = pvm.editSelect(view);
        if (data != null)
        {
            vh.openEditDEEditPolice(data);
        }
    }

    public void onCreateDamage()
    {
        ObservableList data = pvm.editSelect(view);
        if (data != null)
        {
            vh.openCreateDamage(data);
        }
    }
}
