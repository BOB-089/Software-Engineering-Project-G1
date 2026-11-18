import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeliveryDocketTest {

// ------------------------------------------------------------
// 					Day Tests (TC01–TC04)
// ------------------------------------------------------------

	// TC01
	// Test Objective: Verify day is accepted at lower boundary
	// Input(s): Day = 1
	// Expected Output(s): Day accepted
	@Order(1)
	@Test
	void validDayLowerBoundary_TC01() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertTrue(deliveryDocket.verifyDay(1));
	}

	// TC02
	// Test Objective: Verify day is accepted at upper boundary
	// Input(s): Day = 31
	// Expected Output(s): Day accepted
	@Order(2)
	@Test
	void validDayUpperBoundary_TC02() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertTrue(deliveryDocket.verifyDay(31));
	}

	// TC03
	// Test Objective: Verify day is rejected when below valid range
	// Input(s): Day = 0
	// Expected Output(s): Invalid Day
	@Order(3)
	@Test
	void invalidDayTooLow_TC03() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertFalse(deliveryDocket.verifyDay(0));
	}

	// TC04
	// Test Objective: Verify day is rejected when above valid range
	// Input(s): Day = 32
	// Expected Output(s): Invalid Day
	@Order(4)
	@Test
	void invalidDayTooHigh_TC04() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertFalse(deliveryDocket.verifyDay(32));
	}

// ------------------------------------------------------------
// 					Month Tests (TC05–TC08)
// ------------------------------------------------------------

	// TC05
	// Test Objective: Verify month is accepted at lower boundary
	// Input(s): Month = 1
	// Expected Output(s): Month accepted
	@Order(5)
	@Test
	void validMonthLowerBoundary_TC05() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertTrue(deliveryDocket.verifyMonth(1));
	}

	// TC06
	// Test Objective: Verify month is accepted at upper boundary
	// Input(s): Month = 12
	// Expected Output(s): Month accepted
	@Order(6)
	@Test
	void validMonthUpperBoundary_TC06() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertTrue(deliveryDocket.verifyMonth(12));
	}

	// TC07
	// Test Objective: Verify month is rejected when below valid range
	// Input(s): Month = 0
	// Expected Output(s): Invalid Month
	@Order(7)
	@Test
	void invalidMonthTooLow_TC07() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertFalse(deliveryDocket.verifyMonth(0));
	}

	// TC08
	// Test Objective: Verify month is rejected when above valid range
	// Input(s): Month = 13
	// Expected Output(s): Invalid Month
	@Order(8)
	@Test
	void invalidMonthTooHigh_TC08() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertFalse(deliveryDocket.verifyMonth(13));
	}

// ------------------------------------------------------------
// 					Year Tests (TC09–TC11)
// ------------------------------------------------------------

	// TC09
	// Test Objective: Verify year is accepted at lower boundary
	// Input(s): Year = 1900
	// Expected Output(s): Year accepted
	@Order(9)
	@Test
	void validYearLowerBoundary_TC09() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertTrue(deliveryDocket.verifyYear(1900));
	}

	// TC10
	// Test Objective: Verify year is accepted when above lower boundary
	// Input(s): Year = 2026
	// Expected Output(s): Year accepted
	@Order(10)
	@Test
	void validYear_TC10() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertTrue(deliveryDocket.verifyYear(2026));
	}

	// TC11
	// Test Objective: Verify year is rejected when below valid range
	// Input(s): Year = 1899
	// Expected Output(s): Invalid Year
	@Order(11)
	@Test
	void invalidYearTooLow_TC11() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertFalse(deliveryDocket.verifyYear(1899));
	}

// ------------------------------------------------------------
// 					Date Tests (TC12–TC13)
// ------------------------------------------------------------

	// TC12
	// Test Objective: Verify date is accepted when valid
	// Input(s): 28, 2, 2026
	// Expected Output(s): Date accepted
	@Order(12)
	@Test
	void validDate_TC12() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertTrue(deliveryDocket.verifyDate(28, 2, 2026));
	}

	// TC13
	// Test Objective: Verify date is rejected when invalid
	// Input(s): 31, 2, 2026
	// Expected Output(s): Invalid Date
	@Order(13)
	@Test
	void invalidDate_TC13() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertFalse(deliveryDocket.verifyDate(31, 2, 2026));
	}

// ------------------------------------------------------------
// 					Creation Tests (TC14–TC)
// ------------------------------------------------------------

	// TC14
	// Test Objective: Verify delivery docket is created when all details are valid
	// Input(s): 12, 15, 10, 2026
	// Expected Output(s): Delivery docket created successfully
	@Order(14)
	@Test
	void createValidDeliveryDocket_TC14() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertTrue(deliveryDocket.createDeliveryDocket(12, 15, 10, 2026));
	}

	// TC15
	// Test Objective: Verify delivery docket creation fails with invalid day
	// Input(s): 12, 32, 10, 2026
	// Expected Output(s): Delivery docket not created
	@Order(15)
	@Test
	void createDeliveryDocketInvalidDay_TC15() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertFalse(deliveryDocket.createDeliveryDocket(12, 32, 10, 2026));
	}

	// TC16
	// Test Objective: Verify delivery docket creation fails with invalid month
	// Input(s): 12, 15, 13, 2026
	// Expected Output(s): Delivery docket not created
	@Order(16)
	@Test
	void createDeliveryDocketInvalidMonth_TC16() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertFalse(deliveryDocket.createDeliveryDocket(12, 15, 13, 2026));
	}

	// TC17
	// Test Objective: Verify delivery docket creation fails with invalid date
	// Input(s): 12, 31, 2, 2026
	// Expected Output(s): Delivery docket not created
	@Order(17)
	@Test
	void createDeliveryDocketInvalidDate_TC17() {
		DeliveryDocket deliveryDocket = new DeliveryDocket();
		assertFalse(deliveryDocket.createDeliveryDocket(12, 31, 2, 2026));
	}
}