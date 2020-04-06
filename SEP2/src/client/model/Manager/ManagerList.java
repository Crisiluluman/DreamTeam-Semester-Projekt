package client.model.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerList {
  private List<Manager> list;

  public ManagerList()
  {
    list = new ArrayList<>();
  }

  public void addManager(Manager manager)
  {
    list.add(manager);
  }

  public void removeManager(Manager manager)
  {
    list.remove(manager);
  }

  public Manager getManager(Manager manager)
  {

    for (Manager man:list) {
      if(man == manager)
      {
        return man;
      }
    }
    return null;
  }

  public String toString()
  {
    String allManagers = "";
    for (Manager man:list) {
      allManagers += man.toString() + "\n";
    }
    return allManagers;
  }

  public String getAllManagers()
  {
    return toString();
  }
}
