package server.DBConnection.DamagesDB;

import client.model.Damage.Damage;
import client.model.Policy.Policy;

public interface DamageData
{
  void addDamageData(Policy policy, Damage damage);
  void updateDamageData(Damage damage, Damage damageOld);
  void readDamageData(Damage damage);
  void deleteDamageData(Damage damage);
}
