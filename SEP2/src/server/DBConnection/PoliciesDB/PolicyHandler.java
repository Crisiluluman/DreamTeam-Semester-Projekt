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
    System.out.println(policy.getCustomerNo());
    String sql = "INSERT INTO \"insurance\".policy (type, price, deductible, coverage, customerno) values(" + "'"+ policy.getPoliceType() +"'"+ ","
        + policy.getPrice()+","
        + policy.getDeductible()+","
        +"'"+ policy.getCoverage()+"'" + ","
        +policy.getCustomerNo() +
        ");";
    connection.AddToDB(sql);
  }

  @Override public void updatePolicyData(Policy policy)
  {
    String sql =
        "Update \"insurance\".policy set type =" + "'" + policy.getPoliceType()+ "'" + ","
            + "price ="  + policy.getPrice() + ","
            + "deductible =" + "'" + policy.getDeductible() + "'" + ","
            + "coverage =" + "'" + policy.getCoverage() + "'" + ","
            + "customerno ="  + policy.getCustomerNo()
            + " where policyno ="  + policy.getPoliceNo()  +";";
    connection.AddToDB(sql);
  }

  @Override public List<Policy> readPolicyData(int customerNo)
  {
    String sql = "SELECT * FROM \"insurance\".Policy where customerno='"+customerNo+"';";
    return connection.fillPolicyTableDB(sql);
  }

  @Override public void deletePolicyData(int policyno)
  {
    String sql = "Delete from \"insurance\".policy where policyNo =" + "'" + policyno + "'" +";";
    connection.AddToDB(sql);
  }

  @Override public List getIncome()
  {
    String sql = "SELECT sum(price) as "+"total"+" from \"insurance\".policy";
    return connection.totalFromDB(sql);
  }

  @Override public List getExpenses()
  {
    String sql = "SELECT sum(expenses) as "+"total"+" from \"insurance\".damage";
    return connection.totalFromDB(sql);
  }

  @Override public List totalPolicies()
  {
    String sql = "SELECT count(policyno) as "+"total"+" from \"insurance\".policy";
    return connection.totalFromDB(sql);
  }
}
