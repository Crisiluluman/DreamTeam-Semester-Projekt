package client.model.DamageEmployee;

import java.util.ArrayList;

public class DamageEmployeeList
{
  ArrayList<DamageEmployee> damageEmployees;
  public DamageEmployeeList()
  {
    damageEmployees = new ArrayList<>();
  }
  public void addDamageEmployee(DamageEmployee damageEmployee)
  {
    damageEmployees.add(damageEmployee);
  }
  public void removeDamageEmployee(DamageEmployee damageEmployee)
  {
    damageEmployees.remove(damageEmployee);
  }
  public ArrayList<DamageEmployee> getDamageEmployees()
  {
    return damageEmployees;
  }
  public DamageEmployee damageEmployee(int id)
  {
    return damageEmployees.get(id);
  }

}
