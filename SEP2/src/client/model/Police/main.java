package client.model.Police;

public class main
{
  public static void main(String[] args)
  {
    Police policy1 = new Police(1,2000,300,400);
    Police policy2 = new Police(2,3300,650,230);

    PoliceList policeList = new PoliceList();
    policeList.addPolicy(policy1);
    policeList.addPolicy(policy2);

    System.out.println(policeList.getPoliceInfo());
  }
}
