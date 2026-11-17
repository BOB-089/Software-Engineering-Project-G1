import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class OrderTest {

// ------------------------------------------------------------
//		Day Tests (TC01–TC04)
// ------------------------------------------------------------

	// TC01
	// Test Objective: Verify day is accepted at lower boundary
	// Input(s): Day = 1
	// Expected Output(s): Day accepted
	@org.junit.jupiter.api.Order(1)
	@Test
	void validDayLowerBoundary_TC01() {
		Order order = new Order();
		assertTrue(order.verifyDay(1));
	}

	// TC02
	// Test Objective: Verify day is accepted at upper boundary
	// Input(s): Day = 31
	// Expected Output(s): Day accepted
	@org.junit.jupiter.api.Order(2)
	@Test
	void validDayUpperBoundary_TC02() {
		Order order = new Order();
		assertTrue(order.verifyDay(31));
	}

	// TC03
	// Test Objective: Verify day is rejected when below valid range
	// Input(s): Day = 0
	// Expected Output(s): Invalid Day
	@org.junit.jupiter.api.Order(3)
	@Test
	void invalidDayTooLow_TC03() {
		Order order = new Order();
		assertFalse(order.verifyDay(0));
	}

	// TC04
	// Test Objective: Verify day is rejected when above valid range
	// Input(s): Day = 32
	// Expected Output(s): Invalid Day
	@org.junit.jupiter.api.Order(4)
	@Test
	void invalidDayTooHigh_TC04() {
		Order order = new Order();
		assertFalse(order.verifyDay(32));
	}

// ------------------------------------------------------------
//		Month Tests (TC05–TC08)
// ------------------------------------------------------------

	// TC05
	// Test Objective: Verify month is accepted at lower boundary
	// Input(s): Month = 1
	// Expected Output(s): Month accepted
	@org.junit.jupiter.api.Order(5)
	@Test
	void validMonthLowerBoundary_TC05() {
		Order order = new Order();
		assertTrue(order.verifyMonth(1));
	}

	// TC06
	// Test Objective: Verify month is accepted at upper boundary
	// Input(s): Month = 12
	// Expected Output(s): Month accepted
	@org.junit.jupiter.api.Order(6)
	@Test
	void validMonthUpperBoundary_TC06() {
		Order order = new Order();
		assertTrue(order.verifyMonth(12));
	}

	// TC07
	// Test Objective: Verify month is rejected when below valid range
	// Input(s): Month = 0
	// Expected Output(s): Invalid Month
	@org.junit.jupiter.api.Order(7)
	@Test
	void invalidMonthTooLow_TC07() {
		Order order = new Order();
		assertFalse(order.verifyMonth(0));
	}

	// TC08
	// Test Objective: Verify month is rejected when above valid range
	// Input(s): Month = 13
	// Expected Output(s): Invalid Month
	@org.junit.jupiter.api.Order(8)
	@Test
	void invalidMonthTooHigh_TC08() {
		Order order = new Order();
		assertFalse(order.verifyMonth(13));
	}

//------------------------------------------------------------
//		Year Tests (TC9–TC11)
//------------------------------------------------------------

	// TC09
	// Test Objective: Verify year is accepted at lower boundary
	// Input(s): Year = 1900
	// Expected Output(s): Year accepted
	@org.junit.jupiter.api.Order(9)
	@Test
	void validYearLowerBoundary_TC09() {
		Order order = new Order();
		assertTrue(order.verifyYear(1900));
	}

	// TC10
	// Test Objective: Verify year is accepted when above lower boundary
	// Input(s): Year = 2026
	// Expected Output(s): Year accepted
	@org.junit.jupiter.api.Order(10)
	@Test
	void validYearAboveBoundary_TC10() {
		Order order = new Order();
		assertTrue(order.verifyYear(2026));
	}

	// TC11
	// Test Objective: Verify year is rejected when below valid range
	// Input(s): Year = 1899
	// Expected Output(s): Invalid Year
	@org.junit.jupiter.api.Order(11)
	@Test
	void invalidYearTooLow_TC11() {
		Order order = new Order();
		assertFalse(order.verifyYear(1899));
	}

//------------------------------------------------------------
//		Date Tests (TC12–TC13)
//------------------------------------------------------------

	// TC12
	// Test Objective: Verify date is accepted when valid
	// Input(s): 28, 2, 2026
	// Expected Output(s): Date accepted
	@org.junit.jupiter.api.Order(12)
	@Test
	void validDate_TC12() {
		Order order = new Order();
		assertTrue(order.verifyDate(28, 2, 2026));
	}

	// TC13
	// Test Objective: Verify date is rejected when invalid
	// Input(s): 31, 2, 2026
	// Expected Output(s): Invalid Date
	@org.junit.jupiter.api.Order(13)
	@Test
	void invalidDate_TC13() {
		Order order = new Order();
		assertFalse(order.verifyDate(31, 2, 2026));
	}

// ------------------------------------------------------------
// 					Creation Tests (TC14–TC18)
// ------------------------------------------------------------

	// TC14
	// Test Objective: Verify order is created when all details are valid
	// Input(s): "Daily News", 12345, 12, 10, 2026
	// Expected Output(s): Order created successfully
	@org.junit.jupiter.api.Order(14)
	@Test
	void createValidOrder_TC14() {
		Order order = new Order();
		assertTrue(order.createOrder("Daily News", 12345, 12, 10, 2026));
	}

	// TC15
	// Test Objective: Verify order creation fails with invalid day
	// Input(s): "Daily News", 12345, 0, 10, 2026
	// Expected Output(s): Order not created
	@org.junit.jupiter.api.Order(15)
	@Test
	void createOrderInvalidDay_TC15() {
		Order order = new Order();
		assertFalse(order.createOrder("Daily News", 12345, 0, 10, 2026));
	}

	// TC16
	// Test Objective: Verify order creation fails with invalid month
	// Input(s): "Daily News", 12345, 12, 13, 2026
	// Expected Output(s): Order not created
	@org.junit.jupiter.api.Order(16)
	@Test
	void createOrderInvalidMonth_TC16() {
		Order order = new Order();
		assertFalse(order.createOrder("Daily News", 12345, 12, 13, 2026));
	}

	// TC17
	// Test Objective: Verify order creation fails with invalid year
	// Input(s): "Daily News", 12345, 12, 10, 1700
	// Expected Output(s): Order not created
	@org.junit.jupiter.api.Order(17)
	@Test
	void createOrderInvalidYear_TC17() {
		Order order = new Order();
		assertFalse(order.createOrder("Daily News", 12345, 12, 10, 1700));
	}
	
	// TC18
	// Test Objective: Verify order creation fails with invalid date
	// Input(s): "Daily News", 12345, 31, 2, 2026
	// Expected Output(s): Order not created
	@org.junit.jupiter.api.Order(18)
	@Test
	void createOrderInvalidDate_TC18() {
		Order order = new Order();
		assertFalse(order.createOrder("Daily News", 12345, 31, 2, 2026));
	}
}