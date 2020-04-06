package client.model.Damage;

import java.util.ArrayList;
import java.util.List;

public class DamageList {
  private List<Damage> list;

  public DamageList()
  {
    list = new ArrayList<>();
  }

  public void addDamage(Damage damage)
  {
    list.add(damage);
  }

  public void removeDamage(Damage damage)
  {
    list.add(damage);
  }

  public Damage getDamage(Damage damage)
  {

    for (Damage dmg:list) {
      if(dmg == damage)
      {
        return dmg;
      }
    }
    return null;
  }

  public String toString()
  {
    String allDamages = "";
    for (Damage dmg:list) {
      allDamages += dmg.toString() + "\n";
    }
    return allDamages;
  }

  public String getAllDamages()
  {
    return toString();
  }
}
