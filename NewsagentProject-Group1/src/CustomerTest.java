import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CustomerTest {

	// TC01
	// Test Objective: Verify firstName is accepted when 1 character
	// Input(s): FirstName = "B"
	// Expected Output(s): FirstName accepted
	@Test
	void validFirstNameMinBoundary_TC01() {
		Customer customer = new Customer();
		assertTrue(customer.verifyFirstName("B"));
	}
	
	//TCO02
	//Test Objective: Verify firstName is accepted when more than 1 character
	//Input(s): FirstName = "Brian"
	//Expected Output(s): FirstName accepted
	@Test
	void validFirstName_TC02() {
		Customer customer = new Customer();
		assertTrue(customer.verifyFirstName("Brian"));
	}
	
	//TC03
	//Test Objective: Verify firstName is rejected when blank
	//Input(s): FirstName = ""
	//Expected Output(s): Error message: Invalid First Name
	@Test
	void invalidFirstNameBlank_TC03() {
		Customer customer = new Customer();
		assertFalse(customer.verifyFirstName(""));
	}
	
	//TC04
	//Test Objective: Verify firstName is rejected with digits
	//Input(s): FirstName = "Mik3"
	
}
