package client.model.Police;

import java.util.ArrayList;
import java.util.List;

public class PoliceList
{
  private List<Police> policies;

  public PoliceList()
  {
    this.policies = new ArrayList<Police>();
  }

  // Create a police
  public void addPolicy(Police police)
  {
    policies.add(police);
  }

  // Delete a police
  public void removePolicy(Police police)
  {
    policies.remove(police);
  }

  public String getPoliceInfo()
  {
    String info = "";
    for (Police police: policies)
    {
      info += police.toString();
    }
    return info;
  }

}
