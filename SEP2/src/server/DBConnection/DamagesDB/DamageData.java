package server.DBConnection.DamagesDB;

import shared.Damage;
import shared.Policy;
import javafx.scene.control.TableView;

public interface DamageData
{
  void addDamageData(Policy policy, Damage damage);
  void updateDamageData(Damage damage, Damage damageOld);
  void deleteDamageData(Damage damage);
  //void readDamageData();
 // void deleteDamageData(Damage damage);
}
