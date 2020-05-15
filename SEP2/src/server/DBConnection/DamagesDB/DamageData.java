package server.DBConnection.DamagesDB;

import client.model.Damage.Damage;
import client.model.Policy.Policy;
import javafx.scene.control.TableView;

public interface DamageData
{
  void addDamageData(Policy policy, Damage damage);
  void updateDamageData(Damage damage, Damage damageOld);
  void readDamageData(TableView TV);
  void deleteDamageData(Damage damage);
}
