package server.DBConnection.PoliciesDB;

import client.model.Policy.Policy;
import server.DBConnection.DBConnections;

public class PolicyHandler implements PolicyData
{
  private DBConnections connection;

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

  @Override public void readPolicyData(Policy policy)
  {

  }

  @Override public void deletePolicyData(Policy policy)
  {

  }
}
