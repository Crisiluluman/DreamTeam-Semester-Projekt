package client.view.DamageEmployee.Policies.EditPolicy;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import shared.Policy;

public class EditPolicyViewModel {
    private Model model;
    private StringProperty policeType;
    private StringProperty policyNr;
    private StringProperty price;
    private StringProperty deductible;
    private StringProperty coverage;
    private ObservableList list;


    public EditPolicyViewModel(Model model)
    {
        this.model = model;
        policeType = new SimpleStringProperty();
        policyNr = new SimpleStringProperty();
        price = new SimpleStringProperty();
        deductible = new SimpleStringProperty();
        coverage = new SimpleStringProperty();
    }


    public void onSave()
    {
        Policy policy = new Policy(String.valueOf(policeType.getValue()),Integer.parseInt(String.valueOf(price.getValue())),Integer.parseInt(String.valueOf(deductible.getValue())),String.valueOf(coverage.getValue()),Integer.parseInt(
            (String) list.get(5)));
        policy.setPoliceNo(Integer.parseInt(
            (String) list.get(0)));
        model.updatePolicy(policy);
    }
    public void setFields(ObservableList<String> list)
    {
        this.list=list;
policyNr.setValue(list.get(0));
policeType.setValue(list.get(1));
price.setValue(list.get(2));
deductible.setValue(list.get(3));
coverage.setValue(list.get(4));
    }
    public void setChoiceBox(ChoiceBox choiceBox)
    {
        choiceBox.setValue(policeType.getValue());
    }


    public StringProperty policeTypeProperty()
    {
        return policeType;
    }
    public StringProperty policyNrProperty()
    {
        return policyNr;
    }

    public StringProperty priceProperty()
    {
        return price;
    }



    public StringProperty deductibleProperty()
    {
        return deductible;
    }



    public StringProperty coverageProperty()
    {
        return coverage;
    }


}
