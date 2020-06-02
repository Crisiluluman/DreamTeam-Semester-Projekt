import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.DBConnection.CustomerDB.CustomerHandler;
import shared.*;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Tester
{
  ArrayList<Customer> customers;
  CustomerHandler ch;

  @BeforeEach public void Start()
  { // initial setup runs before each test
    customers = new ArrayList<>();
  }

  @Test public void testZeroCustomer()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> customers.get(0));
  }

  @Test public void testAddOneCustomer()
  {
    Customer customer = new Customer("Sonny", "Hejvej", 8700, 1305901122);

    customers.add(customer);

    assertTrue(customers.get(0) == customer);
  }

  @Test public void testAddTwoCustomers()
  {
    Customer customer = new Customer("Sonny", "Hejvej", 8700, 1305901122);
    Customer customer1 = new Customer("Martin", "skovvej", 8700, 1010100011);

    customers.add(customer);
    customers.add(customer1);

    assertTrue(customers.get(0) == customer);
    assertTrue(customers.get(1) == customer1);
  }

  @Test public void testOutOfBounds()
  {
    Customer customer = new Customer("Sonny", "Hejvej", 8700, 1305901122);

    customers.add(customer);

    assertThrows(IndexOutOfBoundsException.class, () -> customers.get(1));
  }

  @Test public void testValidationName()
  {
    Customer customer0 = new Customer("123", "1234", 999, 1305901122);
    Customer customer1 = new Customer("Camilla", "", 1000, 1709981044);

    customers.add(customer0);
    customers.add(customer1);

    assertFalse(Pattern.matches("[a-åA-Å]+", customers.get(0).getName()));
    assertTrue(Pattern.matches("[a-åA-Å]+", customers.get(1).getName()));
  }

  @Test public void testValidationAddress()
  {
    Customer customer0 = new Customer("123", "1234", 999, 1305901122);
    Customer customer1 = new Customer("Camilla", "", 1000, 1709981044);

    customers.add(customer0);
    customers.add(customer1);

    assertFalse(customers.get(0).getAddress().equals(""));
    assertTrue(customers.get(1).getAddress().equals(""));
  }





  @Test public void testValidationPostcode()
  { // doesnt work
    Customer customer0 = new Customer("123", "1234", 999, 1305901122);
    Customer customer1 = new Customer("Camilla", "", 1000, 1709981044);
    Customer customer2 = new Customer("Lotte", "Hejvej", 1001, 1305991122);
    Customer customer3 = new Customer("Louise", "Røvvej", 9991, 1410901144);
    Customer customer4 = new Customer("Cecilie", "Margrethevej", 9990, 1420154811);
    Customer customer5 = new Customer("Astrid", "lærervej", 9989, 1091100323);

    customers.add(customer0);
    customers.add(customer1);
    customers.add(customer2);
    customers.add(customer3);
    customers.add(customer4);
    customers.add(customer5);

    assertFalse(customers.get(0).getPostcode() < 9991 && customers.get(0).getPostcode() > 999);
    assertTrue(customers.get(1).getPostcode() < 9991 && customers.get(1).getPostcode() > 999);
    assertTrue(customers.get(2).getPostcode() < 9991 && customers.get(2).getPostcode() > 999);
    assertFalse(customers.get(3).getPostcode() < 9991 && customers.get(3).getPostcode() > 999);
    assertTrue(customers.get(4).getPostcode() < 9991 && customers.get(4).getPostcode() > 999);
    assertTrue(customers.get(5).getPostcode() < 9991 && customers.get(5).getPostcode() > 999);

  }

  @Test public void testValidationCPR() // We have some problems with the long number as argument. int is the biggest we can use.
  {
   // long max0 = 3112999997L‬;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    //long max = 3112999998L‬;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    //long max1 = 3112999999L;‬;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

    Customer customer0 = new Customer("123", "1234", 999, 101000000);
    Customer customer1 = new Customer("Camilla", "", 1000, 101000001);
    Customer customer2 = new Customer("Lotte", "Hejvej", 1001, 101000002);
   // Customer customer3 = new Customer("Louise", "Røvvej", 9991, max);
  //  Customer customer4 = new Customer("Cecilie", "Margrethevej", 9990, max0);
   // Customer customer5 = new Customer("Astrid", "lærervej", 9989, max1);

    customers.add(customer0);
    customers.add(customer1);
    customers.add(customer2);

    assertTrue(Pattern.matches("[0-9]+",String.valueOf(customers.get(0).getCprNr())));

    boolean flag = customers.get(0).getCprNr() > 101000000;
    assertFalse(flag);
    flag = customers.get(0).getCprNr() < Long.parseLong("3112999999");
    assertTrue(flag);

    flag = customers.get(1).getCprNr() > 101000000;
    assertTrue(flag);
    flag = customers.get(1).getCprNr() < Long.parseLong("3112999999");
    assertTrue(flag);

    flag = customers.get(2).getCprNr() > 101000000;
    assertTrue(flag);
    flag = customers.get(2).getCprNr() < Long.parseLong("3112999999");
    assertTrue(flag);

//    flag = customer3.getCprNr() > 101000000;
//    assertTrue(flag);
//    flag = customer3.getCprNr() < Long.parseLong("3112999999");
//    assertTrue(flag);
//
//    flag = customer4.getCprNr() > 101000000;
//    assertTrue(flag);
//    flag = customer4.getCprNr() < Long.parseLong("3112999999");
//    assertTrue(flag);
//
//    flag = customer5.getCprNr() > 101000000;
//    assertTrue(flag);
//    flag = customer5.getCprNr() < Long.parseLong("3112999999");
//    assertFalse(flag);
  }


  @Test public void getCustomernumber()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    customers.add(customer);

    assertTrue(customers.get(0).getCustomerNo() == 0);

  }

  @Test public void setCustomernumber()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    customers.add(customer);

    customers.get(0).setCustomerNo(1);
    assertTrue(customers.get(0).getCustomerNo() == 1);
  }

  @Test public void getName()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    customers.add(customer);


    assertTrue(customers.get(0).getName() == "Lotte");
  }

  @Test public void getAddress()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    customers.add(customer);

    assertTrue(customers.get(0).getAddress() == "Hejvej");
  }

  @Test public void getCpr()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    customers.add(customer);

    assertTrue(customers.get(0).getCprNr() == 1305991122);
  }

  @Test public void getPostcode()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    customers.add(customer);

    assertTrue(customers.get(0).getPostcode() == 9000);
  }

  @Test public void getCombinedRatio()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    customers.add(customer);

    assertTrue(customers.get(0).getCombinedRatio() == 0);
  }

  @Test public void setCombinedRatio()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    customers.add(customer);

    customer.setCombinedRatio(1);
    assertTrue(customers.get(0).getCombinedRatio() == 1);
  }

//  @Test public void AddToDB()
//  {
//
//    Customer customer = new Customer("Lotte","Hejvej",9000,1305991122);
//    ch.addCustomerData(customer);
//    int size = ch.readCustomerData().size();
//    assertTrue(ch.readCustomerData().get(size - 1).getName().equals("Lotte"));
//    assertFalse(ch.readCustomerData().get(size - 1).getName().equals("Lotte123"));
//    System.out.println(size-1);
//    ch.deleteCustomerData(ch.readCustomerData().get(size-1).getCustomerNo());
//    size = ch.readCustomerData().size();
//    System.out.println(size-1);
//  }

//  @Test public void AddNullCustomer()
//  {
//    Customer customer = null;
//
//    assertThrows(NullPointerException.class, () -> ch.addCustomerData(customer));
//  }

//  @Test public void AddMultipleCustomers()
//  { // Change "ch.readCustomerData().get(6)" to match with your local db.
//
//    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);
//    Customer customer1 = new Customer("Line", "Solskinsvej", 8000, 1305991100);
//
//    cust.addCustomerData(customer);
//
//    ch.addCustomerData(customer1);
//
//
//    assertTrue(ch.readCustomerData().get(size-1).getName().equals("Lotte"));
//    assertFalse(ch.readCustomerData().get(size-1).getName().equals("Lotte123"));
//    assertTrue(ch.readCustomerData().get(size1-1).getName().equals("Line"));
//    assertFalse(ch.readCustomerData().get(size1-1).getName().equals("Line123"));
//
//  }

  @Test public void getTotalCustomers()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);
    customers.add(customer);
    assertTrue(customers.size() == 1);
  }
}
