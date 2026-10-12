import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerTest {
	
	// -------------------------
    // FirstName TESTS (TC01–TC05)
    // -------------------------

    // TC01
    // Test Objective: Verify firstName is accepted when 1 character
    // Input(s): FirstName = "B"
    // Expected Output(s): FirstName accepted
    @Test
    void validFirstNameMinBoundary_TC01() {
        Customer customer = new Customer();
        assertTrue(customer.verifyFirstName("B"));
    }

    // TC02
    // Test Objective: Verify firstName is accepted when more than 1 character
    // Input(s): FirstName = "Brian"
    // Expected Output(s): FirstName accepted
    @Test
    void validFirstName_TC02() {
        Customer customer = new Customer();
        assertTrue(customer.verifyFirstName("Brian"));
    }

    // TC03
    // Test Objective: Verify firstName is rejected when blank
    // Input(s): FirstName = ""
    // Expected Output(s): Error message: Invalid First Name
    @Test
    void invalidFirstNameBlank_TC03() {
        Customer customer = new Customer();
        assertFalse(customer.verifyFirstName(""));
    }

    // TC04
    // Test Objective: Verify firstName is rejected with digits
    // Input(s): FirstName = "M1k3"
    // Expected Output(s): Error message: Invalid First Name
    @Test
    void invalidFirstNameDigits_TC04() {
        Customer customer = new Customer();
        assertFalse(customer.verifyFirstName("M1k3"));
    }

    // TC05
    // Test Objective: Verify firstName is rejected with symbols
    // Input(s): FirstName = "J@hn!"
    // Expected Output(s): Error message: Invalid First Name
    @Test
    void invalidFirstNameSymbols_TC05() {
        Customer customer = new Customer();
        assertFalse(customer.verifyFirstName("J@hn!"));
    }

    // -------------------------
    // SURNAME TESTS (TC06–TC10)
    // -------------------------

    // TC06
    // Test Objective: Verify surname is accepted when 1 character
    // Input(s): Surname = "K"
    // Expected Output(s): Surname accepted
    @Test
    void validSurnameMinBoundary_TC06() {
        Customer customer = new Customer();
        assertTrue(customer.verifySurname("K"));
    }

    // TC07
    // Test Objective: Verify surname is accepted when more than 1 character
    // Input(s): Surname = "Kelly"
    // Expected Output(s): Surname accepted
    @Test
    void validSurname_TC07() {
        Customer customer = new Customer();
        assertTrue(customer.verifySurname("Kelly"));
    }

    // TC08
    // Test Objective: Verify surname is rejected when blank
    // Input(s): Surname = ""
    // Expected Output(s): Error message: Invalid Surname
    @Test
    void invalidSurnameBlank_TC08() {
        Customer customer = new Customer();
        assertFalse(customer.verifySurname(""));
    }

    // TC09
    // Test Objective: Verify surname is rejected with digits
    // Input(s): Surname = "Sm1th"
    // Expected Output(s): Error message: Invalid Surname
    @Test
    void invalidSurnameDigits_TC09() {
        Customer customer = new Customer();
        assertFalse(customer.verifySurname("Sm1th"));
    }

    // TC10
    // Test Objective: Verify surname is rejected with symbols
    // Input(s): Surname = "O'Ne!l"
    // Expected Output(s): Error message: Invalid Surname
    @Test
    void invalidSurnameSymbols_TC10() {
        Customer customer = new Customer();
        assertFalse(customer.verifySurname("O'Ne!l"));
    }
}
