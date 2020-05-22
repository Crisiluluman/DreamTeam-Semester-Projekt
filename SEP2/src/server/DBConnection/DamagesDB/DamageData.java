package server.DBConnection.DamagesDB;

import shared.Damage;

import java.util.List;

public interface DamageData
{
  void addDamageData(Damage damage);
  void updateDamageData(Damage damage);
  List<Damage> readDamageData(int policeno);
  void deleteDamageData(int damageno);
  List totalDamages();
}
