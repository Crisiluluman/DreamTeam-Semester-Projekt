package client.view.Manager.CreateEmployee;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CreateEmployeeViewController implements viewController {

    private ViewHandler vh;
    private CreateEmployeeViewModel cev;
    private Region root;
    @FXML TextField name;
    @FXML TextField address;
    @FXML TextField ID;
    @FXML TextField position;
    @FXML TextField email;
    @FXML TextField phone;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf, Region root) {
        this.vh = vh;
        cev = vmf.getCreateEmployeeViewModel();
        this.root = root;

    }

    @Override
    public Region getRoot() {
        return root;
    }
}
