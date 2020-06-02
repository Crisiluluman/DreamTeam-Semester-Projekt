import static org.junit.jupiter.api.Assertions.*;

import client.model.Model;
import client.model.Modelmanager;
import client.networking.Client;
import client.networking.InsuranceClientImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.DBConnection.CustomerDB.CustomerHandler;
import shared.*;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Tester
{
  Client client;
  CustomerHandler ch;

  @BeforeEach public void Start()
  { // initial setup runs before each test
    ch = new CustomerHandler();
    ch.createTableCustomer();
  }
  @AfterEach public void end()
  {
    ch.clearTableCustomer();
  }

  @Test public void testZeroCustomer()
  {
    assertThrows(IndexOutOfBoundsException.class, () -> ch.readCustomerData().get(0));
  }

  @Test public void testAddOneCustomer()
  {
    Customer customer = new Customer("Sonny", "Hejvej", 8700, 1305901122);

   ch.addCustomerData(customer);

    assertTrue(ch.readCustomerData().get(0).getName().equals(customer.getName()));
  }

  @Test public void testAddTwoCustomers()
  {
    Customer customer = new Customer("Sonny", "Hejvej", 8700, 1305901122);
    Customer customer1 = new Customer("Martin", "skovvej", 8700, 1010100011);

    ch.addCustomerData(customer);
    ch.addCustomerData(customer1);

    assertTrue(ch.readCustomerData().get(0).getName().equals(customer.getName()));
    assertTrue(ch.readCustomerData().get(1).getName().equals(customer1.getName()));
  }

  @Test public void testOutOfBounds()
  {
    Customer customer = new Customer("Sonny", "Hejvej", 8700, 1305901122);

    ch.addCustomerData(customer);

    assertThrows(IndexOutOfBoundsException.class, () -> ch.readCustomerData().get(1));
  }

  @Test public void testValidationName()
  {
    Customer customer0 = new Customer("123", "1234", 999, 1305901122);
    Customer customer1 = new Customer("Camilla", "", 1000, 1709981044);

    ch.addCustomerData(customer0);
    ch.addCustomerData(customer1);

    assertFalse(Pattern.matches("[a-åA-Å]+", ch.readCustomerData().get(0).getName()));
    assertTrue(Pattern.matches("[a-åA-Å]+", ch.readCustomerData().get(1).getName()));
  }

  @Test public void testValidationAddress()
  {
    Customer customer0 = new Customer("123", "1234", 999, 1305901122);
    Customer customer1 = new Customer("Camilla", "", 1000, 1709981044);

    ch.addCustomerData(customer0);
    ch.addCustomerData(customer1);

    assertFalse(ch.readCustomerData().get(0).getAddress().equals(""));
    assertTrue(ch.readCustomerData().get(1).getAddress().equals(""));
  }





  @Test public void testValidationPostcode()
  { // doesnt work
    Customer customer0 = new Customer("123", "1234", 999, 1305901122);
    Customer customer1 = new Customer("Camilla", "", 1000, 1709981044);
    Customer customer2 = new Customer("Lotte", "Hejvej", 1001, 1305991122);
    Customer customer3 = new Customer("Louise", "Røvvej", 9991, 1410901144);
    Customer customer4 = new Customer("Cecilie", "Margrethevej", 9990, 1420154811);
    Customer customer5 = new Customer("Astrid", "lærervej", 9989, 1091100323);

    ch.addCustomerData(customer0);
    ch.addCustomerData(customer1);
    ch.addCustomerData(customer2);
    ch.addCustomerData(customer3);
    ch.addCustomerData(customer4);
    ch.addCustomerData(customer5);

    assertFalse(ch.readCustomerData().get(0).getPostcode() < 9991 && ch.readCustomerData().get(0).getPostcode() > 999);
    assertTrue(ch.readCustomerData().get(1).getPostcode() < 9991 && ch.readCustomerData().get(1).getPostcode() > 999);
    assertTrue(ch.readCustomerData().get(2).getPostcode() < 9991 && ch.readCustomerData().get(2).getPostcode() > 999);
    assertFalse(ch.readCustomerData().get(3).getPostcode() < 9991 && ch.readCustomerData().get(3).getPostcode() > 999);
    assertTrue(ch.readCustomerData().get(4).getPostcode() < 9991 && ch.readCustomerData().get(4).getPostcode() > 999);
    assertTrue(ch.readCustomerData().get(5).getPostcode() < 9991 && ch.readCustomerData().get(5).getPostcode() > 999);

  }

  @Test public void testValidationCPR() // We have some problems with the long number as argument. int is the biggest we can use.
  {


    Customer customer0 = new Customer("123", "1234", 999, 101000000);
    Customer customer1 = new Customer("Camilla", "", 1000, 101000001);
    Customer customer2 = new Customer("Lotte", "Hejvej", 1001, 101000002);
    Customer customer3 = new Customer("Louise", "Røvvej", 9991, 3112999998L);
    Customer customer4 = new Customer("Cecilie", "Margrethevej", 9990, 3112999997L);
    Customer customer5 = new Customer("Astrid", "lærervej", 9989, 3112999999L);

    ch.addCustomerData(customer0);
    ch.addCustomerData(customer1);
    ch.addCustomerData(customer2);
    ch.addCustomerData(customer3);
    ch.addCustomerData(customer4);
    ch.addCustomerData(customer5);

    assertTrue(Pattern.matches("[0-9]+",String.valueOf(ch.readCustomerData().get(0).getCprNr())));


    assertFalse(ch.readCustomerData().get(0).getCprNr() > 101000000);
    assertTrue(ch.readCustomerData().get(0).getCprNr() < Long.parseLong("3112999999"));


    assertTrue(ch.readCustomerData().get(1).getCprNr() > 101000000);
    assertTrue(ch.readCustomerData().get(1).getCprNr() < Long.parseLong("3112999999"));


    assertTrue(ch.readCustomerData().get(2).getCprNr() > 101000000);
    assertTrue(ch.readCustomerData().get(2).getCprNr() < Long.parseLong("3112999999"));


    assertTrue(ch.readCustomerData().get(3).getCprNr() > 101000000);
   assertTrue(ch.readCustomerData().get(3).getCprNr() < Long.parseLong("3112999999"));


    assertTrue(ch.readCustomerData().get(4).getCprNr() > 101000000);
  assertTrue(ch.readCustomerData().get(4).getCprNr() < Long.parseLong("3112999999"));

    assertTrue(ch.readCustomerData().get(5).getCprNr() > 101000000);
    assertFalse(ch.readCustomerData().get(5).getCprNr() < Long.parseLong("3112999999"));
  }


  @Test public void getCustomernumber()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    ch.addCustomerData(customer);

    assertTrue(ch.readCustomerData().get(0).getCustomerNo() == 1);

  }

  @Test public void setCustomernumber()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    ch.addCustomerData(customer);

   ch.readCustomerData().get(0).setCustomerNo(1);
    assertTrue(ch.readCustomerData().get(0).getCustomerNo() == 1);
  }

  @Test public void getName()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    ch.addCustomerData(customer);


    assertTrue(ch.readCustomerData().get(0).getName().equals("Lotte"));
  }

  @Test public void getAddress()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    ch.addCustomerData(customer);

    assertTrue(ch.readCustomerData().get(0).getAddress().equals("Hejvej"));
  }

  @Test public void getCpr()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    ch.addCustomerData(customer);

    assertTrue(ch.readCustomerData().get(0).getCprNr() == 1305991122);
  }

  @Test public void getPostcode()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    ch.addCustomerData(customer);

    assertTrue(ch.readCustomerData().get(0).getPostcode() == 9000);
  }

  @Test public void getCombinedRatio()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    ch.addCustomerData(customer);

    assertTrue(ch.readCustomerData().get(0).getCombinedRatio() == 0);
  }

  @Test public void setCombinedRatio()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);
customer.setCombinedRatio(1);
    ch.addCustomerData(customer);

    assertEquals(1, ch.readCustomerData().get(0).getCombinedRatio());
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
    ch.addCustomerData(customer);
    assertTrue(ch.readCustomerData().size() == 1);
  }
}
