package client.model;

import client.model.Police.Police;
import client.model.Police.PoliceList;

public interface Model
{
void createPolice(Police police);
PoliceList getPolice();
}
