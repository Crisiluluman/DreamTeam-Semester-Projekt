package client.view.Salesman.SEditPolicy;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class SEditPolicyViewModel
{
    private Model model;
    private StringProperty policeNo;
    private StringProperty policeType;
    private StringProperty price;
    private StringProperty deductible;
    private StringProperty coverage;

    public SEditPolicyViewModel(Model model)
    {
        this.model = model;
        policeNo = new SimpleStringProperty();
        policeType = new SimpleStringProperty();
        price = new SimpleStringProperty();
        deductible = new SimpleStringProperty();
        coverage = new SimpleStringProperty();
    }

    public StringProperty policeNoProperty()
    {
        return policeNo;
    }


    public StringProperty policeTypeProperty()
    {
        return policeType;
    }



    public StringProperty priceProperty()
    {
        return price;
    }


    public StringProperty deductibleProperty()
    {
        return deductible;
    }
public void setChoiceBox(ChoiceBox choiceBox)
{
    choiceBox.setValue(policeType.getValue());
}


    public StringProperty coverageProperty()
    {
        return coverage;
    }

    public void setFields(ObservableList<String> list)
    {
policeNo.setValue(list.get(0));
policeType.setValue(list.get(1));
price.setValue(list.get(2));
deductible.setValue(list.get(3));
coverage.setValue(list.get(4));
    }
}
