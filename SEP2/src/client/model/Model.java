package client.model;

import client.model.Police.Policy;
import client.core.ViewModelFactory;

import client.model.Police.PoliceList;

public interface Model
{
void createPolice(Policy policy);
PoliceList getPolice();
ViewModelFactory getViewModelFactory();
}
