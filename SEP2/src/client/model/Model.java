package client.model;

import client.model.Policy.Policy;
import client.model.Policy.PoliceList;

public interface Model
{
void createPolice(Policy policy);
PoliceList getPolice();
}
