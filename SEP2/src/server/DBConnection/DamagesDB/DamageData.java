package server.DBConnection.DamagesDB;

import shared.Damage;
import shared.Policy;
import java.util.List;

public interface DamageData
{
  void addDamageData(Policy policy, Damage damage);
  void updateDamageData(Damage damage, Damage damageOld);
  List<Damage> readDamageData(int policeno);
  void deleteDamageData(Damage damage);
}
