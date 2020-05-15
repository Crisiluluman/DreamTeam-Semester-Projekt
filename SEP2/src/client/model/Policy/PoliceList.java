package client.model.Policy;

import java.util.ArrayList;
import java.util.List;

public class PoliceList
{
  private List<Policy> policies;

  public PoliceList()
  {
    this.policies = new ArrayList<Policy>();
  }

  // Create a police
  public void addPolicy(Policy policy)
  {
    policies.add(policy);
  }

  // Delete a police
  public void removePolicy(Policy policy)
  {
    policies.remove(policy);
  }

  public String getPoliceInfo()
  {
    String info = "";
    for (Policy policy : policies)
    {
      info += policy.toString();
    }
    return info;
  }

}
