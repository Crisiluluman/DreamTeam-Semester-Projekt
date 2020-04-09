package client.view.Manager.EditEmployee;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class EditEmployeeViewController implements viewController {

    private ViewHandler vh;
    private EditEmployeeViewModel eev;
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
        eev = vmf.getEditEmployeeViewModel();
        this.root = root;
    }
}
