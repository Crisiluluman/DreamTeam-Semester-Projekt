package client.networking;

import javafx.scene.control.TableView;
import shared.Subject;


public interface Client extends Subject
{
  void start();
  void readCustomer(TableView TV);
}
