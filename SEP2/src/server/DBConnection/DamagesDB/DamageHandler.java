package server.DBConnection.DamagesDB;

import client.model.Damage.Damage;
import client.model.Policy.Policy;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import server.DBConnection.DBConnections;

public class DamageHandler implements DamageData
{
  private DBConnections connection;

  public DamageHandler(DBConnections connection)
  {
    this.connection = connection;
  }

  @Override public void addDamageData(Policy policy, Damage damage)
  {
    String sql = "INSERT INTO \"insurance\".damage values("+ damage.getPoliceType() + "," + "'" + damage.getPoliceType() + "'"  + "," + damage.getExpenses() + "," + damage.getDamageNo() + "," + "'" + damage.getInfo() + "'" + ");";
    connection.AddToDB(sql);
  }

  @Override public void updateDamageData(Damage damage, Damage damageOld)
  {

  }

  @Override public void readDamageData(TableView TV)
  {
  }

  @Override public void deleteDamageData(Damage damage)
  {

  }
}
