import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.DBConnection.CustomerDB.CustomerHandler;
import shared.*;
import client.*;
import server.*;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Tester
{
  ArrayList<Customer> customers;
  CustomerHandler ch;

  @BeforeEach public void Start()
  { // initial setup runs before each test
    customers = new ArrayList<>();
    ch = new CustomerHandler();

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

  @Test public void testValidation()
  { // doesnt work
    Customer wrongCustomer = new Customer("123", "", 999, 1305901122);
    Customer rightCustomer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    assertFalse(Pattern.matches("[a-åA-Å]+", wrongCustomer.getName()));
    assertFalse(Pattern.matches("[a-åA-Å]+", wrongCustomer.getAddress()));
    assertFalse(wrongCustomer.getPostcode() < 9990
        && wrongCustomer.getPostcode() > 999);
    // assertFalse(Pattern.matches("[0-9]+",wrongCustomer.getCprNr()) || wrongCustomer.getCprNr()) < 0101000001  || wrongCustomer.getCprNr() > Long.parseLong("3112999999"))
    assertTrue(Pattern.matches("[a-åA-Å]+", rightCustomer.getName()));
    assertTrue(Pattern.matches("[a-åA-Å]+", rightCustomer.getAddress()));
    assertTrue(rightCustomer.getPostcode() < 9990
        || rightCustomer.getPostcode() > 999);
  }

  @Test public void getCustomernumber()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    assertTrue(customer.getCustomerNo() == 0);

  }

  @Test public void setCustomernumber()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);
    customer.setCustomerNo(1);
    assertTrue(customer.getCustomerNo() == 1);
  }

  @Test public void getName()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    assertTrue(customer.getName() == "Lotte");
  }

  @Test public void getAddress()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    assertTrue(customer.getAddress() == "Hejvej");
  }

  @Test public void getCpr()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    assertTrue(customer.getCprNr() == 1305991122);
  }

  @Test public void getPostcode()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    assertTrue(customer.getPostcode() == 9000);
  }

  @Test public void getCombinedRatio()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);

    assertTrue(customer.getCombinedRatio() == 0);
  }

  @Test public void setCombinedRatio()
  {
    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);
    customer.setCombinedRatio(1);
    assertTrue(customer.getCombinedRatio() == 1);
  }

  @Test public void AddToDB()
  {

    Customer customer = new Customer("Lotte","Hejvej",9000,1305991122);
    ch.addCustomerData(customer);
    int size = ch.readCustomerData().size();
    assertTrue(ch.readCustomerData().get(size - 1).getName().equals("Lotte"));
    assertFalse(ch.readCustomerData().get(size - 1).getName().equals("Lotte123"));
    System.out.println(size-1);
    ch.deleteCustomerData(ch.readCustomerData().get(size-1).getCustomerNo());
    size = ch.readCustomerData().size();
    System.out.println(size-1);
  }

  @Test public void AddNullCustomer()
  {
    Customer customer = null;

    assertThrows(NullPointerException.class, () -> ch.addCustomerData(customer));
  }

  @Test public void AddMultipleCustomers()
  { // Change "ch.readCustomerData().get(6)" to match with your local db.

    Customer customer = new Customer("Lotte", "Hejvej", 9000, 1305991122);
    Customer customer1 = new Customer("Line", "Solskinsvej", 8000, 1305991100);

    ch.addCustomerData(customer);
    int size = ch.readCustomerData().size();
    ch.addCustomerData(customer1);
    int size1 = ch.readCustomerData().size();

    assertTrue(ch.readCustomerData().get(size-1).getName().equals("Lotte"));
    assertFalse(ch.readCustomerData().get(size-1).getName().equals("Lotte123"));
    assertTrue(ch.readCustomerData().get(size1-1).getName().equals("Line"));
    assertFalse(ch.readCustomerData().get(size1-1).getName().equals("Line123"));

  }

  @Test public void getTotalCustomers()
  {

  }
}
