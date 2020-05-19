package server.Model;

import javafx.scene.control.TableView;
import shared.Customer;

import java.util.List;

public interface ServerModelInterface
{
   void addCustomer(Customer customer);
   List<Customer> readCustomers();

}
