import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import server.DBConnection.CustomerDB.CustomerHandler;
import shared.*;
import client.*;
import server.*;

public class Tester
{

  private CustomerHandler ch = new CustomerHandler();

  @BeforeEach
  // initial setup runs before each test

//  public void setup()
//  {}

  @Test public void testAddOneCustomer()
  {

    Customer customer = new Customer("Sonny","Hejvej",8700,1305901122);
    assertTrue(customer.getName() == "Sonny");
  }

}
