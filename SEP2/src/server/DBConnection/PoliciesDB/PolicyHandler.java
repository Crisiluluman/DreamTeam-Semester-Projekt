package server.DBConnection.PoliciesDB;

import shared.Policy;
import server.DBConnection.DBConnections;

import java.util.List;

public class PolicyHandler implements PolicyData
{
  private DBConnections connection;

  public PolicyHandler()
  {
    connection = new DBConnections();
  }

  @Override public void addPolicyData(Policy policy)
  {
    String sql = "INSERT INTO \"insurance\".policy (type, price, deductible, coverage) values(" + "'"+ policy.getPoliceType() +"'"+ ","
        + policy.getPrice()+","
        + policy.getDeductible()+","
        +"'"+ policy.getCoverage()+"'" +");";
    connection.AddToDB(sql);
  }

  @Override public void updatePolicyData(Policy policy, Policy policyOld)
  {
    String sql =
        "Update \"insurance\".policy set type =" + "'" + policy.getPoliceType()+ "'" + ","
            + "price =" + "'" + policy.getPoliceType() + "'" + ","
            + "deductible =" + "'" + policy.getDeductible() + "'" + ","
            + "coverage =" + "'" + policy.getCoverage() + "'" + ","
            + "customerno =" + "'" + 1 + "'" + "," //todo check policy for customerno
            + " where policyno =" + "'" + policy.getPoliceNo() + "'" +";";
    connection.AddToDB(sql);
  }

  @Override public List<Policy> readPolicyData()
  {
    String sql = "SELECT * FROM \"insurance\".Policy;";
    return connection.fillPolicyTableDB(sql);
  }

  @Override public void deletePolicyData(int policyno)
  {
    String sql = "Delete from \"insurance\".policy where policyNo =" + "'" + policyno + "'" +";";
    connection.AddToDB(sql);
  }
}
