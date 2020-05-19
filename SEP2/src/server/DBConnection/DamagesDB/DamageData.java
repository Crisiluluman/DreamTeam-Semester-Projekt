package server.DBConnection.DamagesDB;

import client.model.Damage.Damage;
import shared.Policy;
import javafx.scene.control.TableView;

import java.util.List;

public interface DamageData
{
  void addDamageData(Policy policy, Damage damage);
  void updateDamageData(Damage damage, Damage damageOld);
  List<Damage> readDamageData(int policeno);
  void deleteDamageData(Damage damage);
}
