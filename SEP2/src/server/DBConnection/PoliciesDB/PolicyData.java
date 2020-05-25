package server.DBConnection.PoliciesDB;

import shared.Policy;

import java.util.List;

public interface PolicyData
{
  void addPolicyData(Policy policy);
  void updatePolicyData(Policy policy);
  List<Policy> readPolicyData(int customerNo);
  void deletePolicyData(int policyno);
  List getIncome();
  List getExpenses();
}
