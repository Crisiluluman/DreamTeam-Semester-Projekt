package server.DBConnection.DamagesDB;

import shared.Damage;
import shared.Policy;
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
    String sql =
        "INSERT INTO \"insurance\".damage values(" + damage.getPoliceType() + "," + "'" + damage.getPoliceType() + "'"
            + "," + damage.getExpenses() + "," + damage.getDamageNo() + "," + "'" + damage
            .getInfo() + "'" + ");";
    connection.AddToDB(sql);
  }

  @Override public void updateDamageData(Damage damage, Damage damageOld)
  {

    { // TODO: Needs a policyNo in here
      String sql = "Update \"insurance\".damage set type =" + "'" + damage.getPoliceType() + "'" + ","
          + "expenses =" + damage.getExpenses() + "," + "info =" + "'" + damage.getInfo() + "'" + ","
          + "dPolicyType =" + "'" + damage.getPoliceType() + "'" + " where damageNo =" + damageOld.getDamageNo() + ";";
      connection.AddToDB(sql);
    }
  }

  @Override public void deleteDamageData(Damage damage)
  {
    String sql = "Delete from \"insurance\".damage where damageno =" + "'" + damage.getDamageNo() + "'" +";";
    connection.AddToDB(sql);
  }
}
