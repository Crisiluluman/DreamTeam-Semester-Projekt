package client.model.Customer;

public class Main
{
  public static void main(String[] args)
  {
    Customer customer = new Customer("Martin","CoolStreet 231",21,814242);
    CustomerList customerList = new CustomerList();
    customerList.addCustomer(customer);
    System.out.println(customerList.getCustomers().toString());
  }
}
