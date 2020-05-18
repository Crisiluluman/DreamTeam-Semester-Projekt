package client.networking;

import javafx.scene.control.TableView;
import shared.Customer;
import shared.Subject;

import java.util.List;

public interface Client extends Subject
{
  void start();
  List<Customer> readCustomer();
}
