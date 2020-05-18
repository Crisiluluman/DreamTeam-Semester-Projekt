package server.Model;

import javafx.scene.control.TableView;
import shared.Customer;

import java.util.List;

public interface ServerModelInterface
{
   List<Customer> readCustomers();
}
