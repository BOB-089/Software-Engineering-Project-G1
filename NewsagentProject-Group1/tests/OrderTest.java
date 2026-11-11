import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class OrderTest {

// ------------------------------------------------------------
//		PublicationName Tests (TC01–TC03)
//------------------------------------------------------------
	

	// TC01
	// Test Objective: Verify publication name is rejected when the publication is not on the SQL database
	// long
	// Input(s): Publication Name = "A"
	// Expected Output(s): Invalid Publication Name
	@org.junit.jupiter.api.Order(1)
	@Test
	void validPublicationNameNotOnTable_TC01() {
		Order order = new Order();
		assertFalse(order.verifyPublicationName("A"));
	}

	// TC02
	// Test Objective: Verify publication name is accepted when the publication is on the SQL database
	// Input(s): Publication Name = "Daily-News"
	// Expected Output(s): Publication name accepted
	@org.junit.jupiter.api.Order(2)
	@Test
	void validPublicationNameOnTable_TC02() {
		Order order = new Order();
		assertTrue(order.verifyPublicationName("Daily-News"));
	}

	// TC03
	// Test Objective: Verify publication name is rejected when blank
	// Input(s): Publication Name = ""
	// Expected Output(s): Invalid Publication Name
	@org.junit.jupiter.api.Order(3)
	@Test
	void invalidPublicationNameBlank_TC03() {
		Order order = new Order();
		assertFalse(order.verifyPublicationName(""));
	}
	
// ------------------------------------------------------------
//	CustomerId Tests (TC04–TC05)
//------------------------------------------------------------

	// TC04
	// Test Objective: Verify customer ID is accepted when on the Customer
	// table SQL database
	// Input(s): Customer ID = 1
	// Expected Output(s): Customer ID accepted
	@org.junit.jupiter.api.Order(4)
	@Test
	void validCustomerID_TC04() {
		Order order = new Order();
		assertTrue(order.verifyCustomerId(1));
	}

	// TC05
	// Test Objective: Verify customer ID is rejected when on the Customer table
	// Input(s): Customer ID = 0
	// Expected Output(s): Invalid Customer ID
	@org.junit.jupiter.api.Order(5)
	@Test
	void invalidCustomerIDBlank_TC05() {
		Order order = new Order();
		assertFalse(order.verifyCustomerId(0));
	}
	
// ------------------------------------------------------------
//	Day month and year tests (TC06–TC15)
//------------------------------------------------------------

	// TC06
	// Test Objective: Verify day is accepted at the minimum boundary
	// Input(s): Day = 1
	// Expected Output(s): Day accepted
	@org.junit.jupiter.api.Order(6)
	@Test
	void validDayMinBoundary_TC06() {
		Order order = new Order();
		assertTrue(order.verifyDay(1));
	}

	// TC07
	// Test Objective: Verify day is accepted at the maximum boundary
	// Input(s): Day = 31
	// Expected Output(s): Day accepted
	@org.junit.jupiter.api.Order(7)
	@Test
	void validDayMaxBoundary_TC07() {
		Order order = new Order();
		assertTrue(order.verifyDay(31));
	}

	// TC08
	// Test Objective: Verify day is rejected when less than 1
	// Input(s): Day = 0
	// Expected Output(s): Invalid Day
	@org.junit.jupiter.api.Order(8)
	@Test
	void invalidDayTooLow_TC08() {
		Order order = new Order();
		assertFalse(order.verifyDay(0));
	}

	// TC09
	// Test Objective: Verify day is rejected when greater than 31
	// Input(s): Day = 32
	// Expected Output(s): Invalid Day
	@org.junit.jupiter.api.Order(9)
	@Test
	void invalidDayTooHigh_TC09() {
		Order order = new Order();
		assertFalse(order.verifyDay(32));
	}

	// TC10
	// Test Objective: Verify month is accepted at the minimum boundary
	// Input(s): Month = 1
	// Expected Output(s): Month accepted
	@org.junit.jupiter.api.Order(10)
	@Test
	void validMonthMinBoundary_TC10() {
		Order order = new Order();
		assertTrue(order.verifyMonth(1));
	}

	// TC11
	// Test Objective: Verify month is accepted at the maximum boundary
	// Input(s): Month = 12
	// Expected Output(s): Month accepted
	@org.junit.jupiter.api.Order(11)
	@Test
	void validMonthMaxBoundary_TC11() {
		Order order = new Order();
		assertTrue(order.verifyMonth(12));
	}

	// TC12
	// Test Objective: Verify month is rejected when less than 1
	// Input(s): Month = 0
	// Expected Output(s): Invalid Month
	@org.junit.jupiter.api.Order(12)
	@Test
	void invalidMonthTooLow_TC12() {
		Order order = new Order();
		assertFalse(order.verifyMonth(0));
	}

	// TC13
	// Test Objective: Verify month is rejected when greater than 12
	// Input(s): Month = 13
	// Expected Output(s): Invalid Month
	@org.junit.jupiter.api.Order(13)
	@Test
	void invalidMonthTooHigh_TC13() {
		Order order = new Order();
		assertFalse(order.verifyMonth(13));
	}

	// TC14
	// Test Objective: Verify year is accepted when greater than 1900
	// Input(s): Year = 2026
	// Expected Output(s): Year accepted
	@org.junit.jupiter.api.Order(14)
	@Test
	void validYear_TC14() {
		Order order = new Order();
		assertTrue(order.verifyYear(2026));
	}

	// TC15
	// Test Objective: Verify year is rejected when fewer than 4 digits
	// Input(s): Year = 999
	// Expected Output(s): Invalid Year
	@org.junit.jupiter.api.Order(15)
	@Test
	void invalidYearTooShort_TC15() {
		Order order = new Order();
		assertFalse(order.verifyYear(999));
	}

// ------------------------------------------------------------
//	Creation Tests (TC16–TC21)
//------------------------------------------------------------
	
	// TC16
	// Test Objective: Verify order is created when all details are valid
	// Input(s): "Daily-News", 12345, 12, 10, 2026
	// Expected Output(s): Order created successfully
	@org.junit.jupiter.api.Order(16)
	@Test
	void createValidOrder_TC16() {
		Order order = new Order();
		assertTrue(order.createOrder("Daily-News", 1, 12, 10, 2026));
	}

	// TC17
	// Test Objective: Verify order creation fails with invalid publication name
	// Input(s): "", 12345, 12, 10, 2026
	// Expected Output(s): Order not created
	@org.junit.jupiter.api.Order(17)
	@Test
	void createOrderInvalidPublicationName_TC17() {
		Order order = new Order();
		assertFalse(order.createOrder("", 12345, 12, 10, 2026));
	}

	// TC18
	// Test Objective: Verify order creation fails with invalid customer ID
	// Input(s): "Daily News", 1234, 12, 10, 2026
	// Expected Output(s): Order not created
	@org.junit.jupiter.api.Order(18)
	@Test
	void createOrderInvalidCustomerID_TC18() {
		Order order = new Order();
		assertFalse(order.createOrder("Daily News", 1234, 12, 10, 2026));
	}

	// TC19
	// Test Objective: Verify order creation fails with invalid day
	// Input(s): "Daily News", 12345, 0, 10, 2026
	// Expected Output(s): Order not created
	@org.junit.jupiter.api.Order(19)
	@Test
	void createOrderInvalidDay_TC19() {
		Order order = new Order();
		assertFalse(order.createOrder("Daily News", 12345, 0, 10, 2026));
	}

	// TC20
	// Test Objective: Verify order creation fails with invalid month
	// Input(s): "Daily News", 12345, 12, 13, 2026
	// Expected Output(s): Order not created
	@org.junit.jupiter.api.Order(20)
	@Test
	void createOrderInvalidMonth_TC20() {
		Order order = new Order();
		assertFalse(order.createOrder("Daily News", 12345, 12, 13, 2026));
	}

	// TC21
	// Test Objective: Verify order creation fails with invalid year
	// Input(s): "Daily News", 12345, 12, 10, 10000
	// Expected Output(s): Order not created
	@org.junit.jupiter.api.Order(21)
	@Test
	void createOrderInvalidYear_TC21() {
		Order order = new Order();
		assertFalse(order.createOrder("Daily News", 12345, 12, 10, 10000));
	}

// ------------------------------------------------------------
//	Date Tests (TC22–TC23)
//------------------------------------------------------------
	
	// TC22
	// Test Objective: Verify date is accepted when valid
	// Input(s): 28, 2, 2026
	// Expected Output(s): Date accepted
	@org.junit.jupiter.api.Order(22)
	@Test
	void validDate_TC22() {
		Order order = new Order();
		assertTrue(order.verifyDate(28, 2, 2026));
	}

	// TC23
	// Test Objective: Verify date is rejected when invalid
	// Input(s): 31, 2, 2026
	// Expected Output(s): Invalid Date
	@org.junit.jupiter.api.Order(23)
	@Test
	void invalidDate_TC23() {
		Order order = new Order();
		assertFalse(order.verifyDate(31, 2, 2026));
	}
}