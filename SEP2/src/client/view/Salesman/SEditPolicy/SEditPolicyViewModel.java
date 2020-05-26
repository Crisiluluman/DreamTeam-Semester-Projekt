package client.view.Salesman.SEditPolicy;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import shared.Policy;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.regex.Pattern;

public class SEditPolicyViewModel implements PropertyChangeListener
{
    private ObservableList list;
    private Model model;
    private StringProperty policeType;
    private StringProperty price;
    private StringProperty deductible;
    private StringProperty coverage;
    private StringProperty LabelPrice;
    private StringProperty LabelDeductible;
    private StringProperty LabelCoverage;
    private boolean update;

    public SEditPolicyViewModel(Model model)
    {
        this.model = model;
        this.model.addListener(this);
        update = false;
        policeType = new SimpleStringProperty();
        price = new SimpleStringProperty();
        deductible = new SimpleStringProperty();
        coverage = new SimpleStringProperty();
        LabelPrice = new SimpleStringProperty();
        LabelDeductible = new SimpleStringProperty();
        LabelCoverage = new SimpleStringProperty();
    }


    public StringProperty priceProperty()
    {
        return price;
    }

    public StringProperty labelPriceProperty()
    {
        return LabelPrice;
    }


    public StringProperty labelDeductibleProperty()
    {
        return LabelDeductible;
    }


    public StringProperty labelCoverageProperty()
    {
        return LabelCoverage;
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
        this.list = list;
        policeType.setValue(list.get(1));
        price.setValue(list.get(2));
        deductible.setValue(list.get(3));
        coverage.setValue(list.get(4));
    }

    public void onSave()
    {
        Policy policy = new Policy(String.valueOf(policeType.getValue()),Integer.parseInt(String.valueOf(price.getValue())),Integer.parseInt(String.valueOf(deductible.getValue())),String.valueOf(coverage.getValue()),Integer.parseInt(
            (String) list.get(5)));
        policy.setPoliceNo(Integer.parseInt(
            (String) list.get(0)));
        model.updatePolicy(policy);
    }

    public boolean getUpdate()
    {
        return update;
    }

    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        update = true;
    }

    public boolean checker()
    {
        clear();

        if (price.getValue().equals("") || !(Pattern.matches("[0-9]+", price.getValue())))
        {
            LabelPrice.setValue("Missing Price or invalid input");
            return false;
        }
        if (deductible.getValue().equals("") || !(Pattern.matches("[0-9]+", deductible.getValue())))
        {
            LabelDeductible.setValue("Missing Deductible or invalid input");
            return false;
        }if (coverage.getValue().equals("") || !Pattern.matches("[a-åA-Å]+", coverage.getValue()))
    {
        LabelCoverage.setValue("Missing Coverage or invalid input");
        return false;
    }
        return true;
    }
    public void clear()
    {
        LabelCoverage.setValue("");
        LabelDeductible.setValue("");
        LabelPrice.setValue("");
    }

}
