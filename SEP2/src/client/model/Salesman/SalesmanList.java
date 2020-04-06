package client.model.Salesman;

import java.util.ArrayList;
import java.util.List;

public class SalesmanList
{
  private List<Salesman> salesmen;

  public SalesmanList()
  {
    this.salesmen = new ArrayList<Salesman>();
  }

  // Create a salesman
  public void addSalesman(Salesman salesman)
  {
    salesmen.add(salesman);
  }

  // Delete a salesman
  public void removeSalesman(Salesman salesman)
  {
    salesmen.remove(salesman);
  }


  public String getSalesmenInfo()
  {
    String info = "";
    for (Salesman salesman: salesmen)
    {
     info += salesman.toString();
    }
    return info;
  }

}
