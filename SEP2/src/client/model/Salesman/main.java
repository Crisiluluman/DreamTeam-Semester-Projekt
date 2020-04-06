package client.model.Salesman;

public class main
{
  public static void main(String[] args)
  {
    Salesman salesman1 = new Salesman("Ling",123,"China","test@fml.com",12345678);
    Salesman salesman2 = new Salesman("Martin",1234,"Denmark","test@fml1.com",98765432);
    Salesman salesman3 = new Salesman("Chris",12345,"Germany","test@fml2.com",73948327);

    SalesmanList salesmen = new SalesmanList();
    salesmen.addSalesman(salesman1);
    salesmen.addSalesman(salesman2);
    salesmen.addSalesman(salesman3);


    System.out.println(salesmen.getSalesmenInfo());

  }
}
