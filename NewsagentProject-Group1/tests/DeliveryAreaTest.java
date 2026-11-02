import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DeliveryAreaTest {

// ------------------------------------------------------------
//				AreaCode Tests (TC01–TC05)
// ------------------------------------------------------------

// TC01
// Test Objective: Verify areaCode is accepted when within valid range
// Input(s): AreaCode = 12
// Expected Output(s): AreaCode accepted
	@Order(1)
	@Test
	void validAreaCode_TC01() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertTrue(deliveryArea.verifyAreaCode(12));
	}

// TC02
// Test Objective: Verify areaCode is accepted at lower boundary
// Input(s): AreaCode = 1
// Expected Output(s): AreaCode accepted
	@Order(2)
	@Test
	void validAreaCodeLowerBoundary_TC02() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertTrue(deliveryArea.verifyAreaCode(1));
	}

// TC03
// Test Objective: Verify areaCode is accepted at upper boundary
// Input(s): AreaCode = 24
// Expected Output(s): AreaCode accepted
	@Order(3)
	@Test
	void validAreaCodeUpperBoundary_TC03() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertTrue(deliveryArea.verifyAreaCode(24));
	}

// TC04
// Test Objective: Verify areaCode is rejected when below valid range
// Input(s): AreaCode = 0
// Expected Output(s): Error message: Invalid Area Code
	@Order(4)
	@Test
	void invalidAreaCodeTooLow_TC04() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertFalse(deliveryArea.verifyAreaCode(0));
	}

// TC05
// Test Objective: Verify areaCode is rejected when above valid range
// Input(s): AreaCode = 25
// Expected Output(s): Error message: Invalid Area Code
	@Order(5)
	@Test
	void invalidAreaCodeTooHigh_TC05() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertFalse(deliveryArea.verifyAreaCode(25));
	}
// ------------------------------------------------------------
//				Name Tests (TC06–TC11)
// ------------------------------------------------------------

// TC06
// Test Objective: Verify name is accepted when 1 character
// Input(s): Name = "A"
// Expected Output(s): Name accepted
	@Order(6)
	@Test
	void validNameMinBoundary_TC06() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertTrue(deliveryArea.verifyName("A"));
	}

// TC07
// Test Objective: Verify name is accepted when more than 1 character
// Input(s): Name = "Athlone"
// Expected Output(s): Name accepted
	@Order(7)
	@Test
	void validName_TC07() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertTrue(deliveryArea.verifyName("Athlone"));
	}

// TC08
// Test Objective: Verify name is rejected when blank
// Input(s): Name = ""
// Expected Output(s): Error message: Invalid Name
	@Order(8)
	@Test
	void invalidNameBlank_TC08() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertFalse(deliveryArea.verifyName(""));
	}

// TC09
// Test Objective: Verify name is rejected with digits
// Input(s): Name = "Athlon3"
// Expected Output(s): Error message: Invalid Name
	@Order(9)
	@Test
	void invalidNameDigits_TC09() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertFalse(deliveryArea.verifyName("Athlon3"));
	}

// TC10
// Test Objective: Verify name is rejected with invalid symbols
// Input(s): Name = "@!#$%^&*()_+=[]{};:"<>?/\\|~"
// Expected Output(s): Error message: Invalid Name
	@Order(10)
	@Test
	void invalidNameInvalidSymbols_TC10() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertFalse(deliveryArea.verifyName("@!#$%^&*()_+=[]{};:\"<>?/\\\\|~"));
	}

// TC11
// Test Objective: Verify name is accepted with allowed symbols
// Input(s): Name = "'-"
// Expected Output(s): Name accepted
	@Order(11)
	@Test
	void validNameAllowedSymbols_TC11() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertTrue(deliveryArea.verifyName("'-"));
	}

// ------------------------------------------------------------
//				Creation Tests (TC12–TC14)
// ------------------------------------------------------------

//TC12
//Test Objective: Verify delivery area is created when all details are valid
//Input(s): 12, Athlone
//Expected Output(s): Delivery area created successfully
	@Order(12)
	@Test
	void createValidDeliveryArea_TC12() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertTrue(deliveryArea.createDeliveryArea(12, "Athlone"));
	}

//TC13
//Test Objective: Verify delivery area creation fails with invalid area code
//Input(s): -1, Athlone
//Expected Output(s): Delivery area not created
	@Order(13)
	@Test
	void createDeliveryAreaInvalidAreaCode_TC13() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertFalse(deliveryArea.createDeliveryArea(-1, "Athlone"));
	}

//TC14
//Test Objective: Verify delivery area creation fails with invalid name
//Input(s): 12, Athlon3
//Expected Output(s): Delivery area not created
	@Order(14)
	@Test
	void createDeliveryAreaInvalidName_TC14() {
		DeliveryArea deliveryArea = new DeliveryArea();
		assertFalse(deliveryArea.createDeliveryArea(12, "Athlon3"));
	}

// ------------------------------------------------------------
//				Customers Tests (TC15–TC15)
// ------------------------------------------------------------

//TC15
// Test Objective: Verify only customers with the matching area code belong to the delivery area
// Input(s): AreaCode = 12, Name = "Athlone"
// Expected Output(s): All customers in the delivery area have AreaCode 12
	@Order(15)
	@Test
	void matchingCustomersAreaCode_TC15() {
		DeliveryArea deliveryArea = new DeliveryArea();
		deliveryArea.createDeliveryArea(12, "Athlone");
		for (Customer customer : deliveryArea.getCustomers()) {
			assertEquals(12, customer.getAreaCode());
		}
	}
}