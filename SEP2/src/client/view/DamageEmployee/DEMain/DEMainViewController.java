package client.view.DamageEmployee.DEMain;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;


public class DEMainViewController implements viewController {


    private ViewHandler vh;
    private DEMainViewModel dmv;
    private Region root;
    @FXML TextField searchField;
    @FXML TableView view;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Region root) {
        this.vh = vh;
        dmv = vmf.getDEMainViewModel();
        this.root = root;
        dmv.readCustomer(view);
    }
    @Override
    public Region getRoot() {
        return root;
    }
    public void onSelect()
    {
        ObservableList data = dmv.editSelect(view);
        if (data != null)
        {
            vh.openDEPolicies(data);
            vh.updateDEPolicyViews();
        }
    }


}
