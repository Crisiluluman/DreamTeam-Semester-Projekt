package client.model;

import client.model.Policy.Policy;
import client.model.Policy.PoliceList;
import javafx.scene.control.TableView;
import shared.Customer;

import java.util.List;

public interface Model
{
  void createCustomer(Customer customer);
  List<Customer> readCustomer();
}
