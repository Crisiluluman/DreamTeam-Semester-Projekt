package client.view.DamageEmployee.CreateDamage;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.plaf.synth.Region;

public class CreateDamageViewController implements viewController {

    private ViewHandler vh;
    private CreateDamageViewModel cdv;
    private Region root;

    @FXML TextField expenses;
    @FXML TextArea info;
    @FXML ChoiceBox policyType;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Region root) {
        this.vh = vh;
        cdv = vmf.getCreateDamageViewModel();
        this.root = root;

    }
}
