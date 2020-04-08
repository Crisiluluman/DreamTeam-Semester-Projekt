package client.view.DamageEmployee.Policies;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import javax.swing.plaf.synth.Region;

public class PoliciesViewController implements viewController {

    private ViewHandler vh;
    private PoliciesViewModel pvm;
    private Region root;

    @FXML TableView view;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Region root) {

        this.vh = vh;
        pvm = vmf.getPoliciesViewModel();
        this.root = root;
    }
}
