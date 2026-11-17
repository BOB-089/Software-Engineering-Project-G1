import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BillTest {

// ------------------------------------------------------------
// 					Month Tests (TC01–TC04)
// ------------------------------------------------------------

	// TC01
	// Test Objective: Verify month is accepted at lower boundary
	// Input(s): Month = 1
	// Expected Output(s): Month accepted
	@Order(1)
	@Test
	void validMonthLowerBoundary_TC01() {
		Bill bill = new Bill();
		assertTrue(bill.verifyMonth(1));
	}

	// TC02
	// Test Objective: Verify month is accepted at upper boundary
	// Input(s): Month = 12
	// Expected Output(s): Month accepted
	@Order(2)
	@Test
	void validMonthUpperBoundary_TC02() {
		Bill bill = new Bill();
		assertTrue(bill.verifyMonth(12));
	}

	// TC03
	// Test Objective: Verify month is rejected when below valid range
	// Input(s): Month = 0
	// Expected Output(s): Invalid Month
	@Order(3)
	@Test
	void invalidMonthTooLow_TC03() {
		Bill bill = new Bill();
		assertFalse(bill.verifyMonth(0));
	}

	// TC04
	// Test Objective: Verify month is rejected when above valid range
	// Input(s): Month = 13
	// Expected Output(s): Invalid Month
	@Order(4)
	@Test
	void invalidMonthTooHigh_TC04() {
		Bill bill = new Bill();
		assertFalse(bill.verifyMonth(13));
	}

// ------------------------------------------------------------
// 					Year Tests (TC05–TC07)
// ------------------------------------------------------------

	// TC05
	// Test Objective: Verify year is accepted at lower boundary
	// Input(s): Year = 1900
	// Expected Output(s): Year accepted
	@Order(5)
	@Test
	void validYearLowerBoundary_TC05() {
		Bill bill = new Bill();
		assertTrue(bill.verifyYear(1900));
	}

	// TC06
	// Test Objective: Verify year is accepted when above lower boundary
	// Input(s): Year = 2026
	// Expected Output(s): Year accepted
	@Order(6)
	@Test
	void validYear_TC06() {
		Bill bill = new Bill();
		assertTrue(bill.verifyYear(2026));
	}

	// TC07
	// Test Objective: Verify year is rejected when below valid range
	// Input(s): Year = 1899
	// Expected Output(s): Invalid Year
	@Order(7)
	@Test
	void invalidYearTooLow_TC07() {
		Bill bill = new Bill();
		assertFalse(bill.verifyYear(1899));
	}

// ------------------------------------------------------------
// 					Creation Tests (TC08–TC11)
// ------------------------------------------------------------

	// TC08
	// Test Objective: Verify bill is created when all details are valid
	// Input(s): 1, 10, 2026, 25.50
	// Expected Output(s): Bill created successfully
	@Order(8)
	@Test
	void createValidBill_TC08() {
		Bill bill = new Bill();
		assertTrue(bill.createBill(1, 10, 2026, 25.50));
	}

	// TC09
	// Test Objective: Verify bill creation fails with invalid month
	// Input(s): 1, 13, 2026, 25.50
	// Expected Output(s): Bill not created
	@Order(9)
	@Test
	void createBillInvalidMonth_TC09() {
		Bill bill = new Bill();
		assertFalse(bill.createBill(1, 13, 2026, 25.50));
	}

	// TC10
	// Test Objective: Verify bill creation fails with invalid year
	// Input(s): 1, 10, 1899, 25.50
	// Expected Output(s): Bill not created
	@Order(10)
	@Test
	void createBillInvalidYear_TC10() {
		Bill bill = new Bill();
		assertFalse(bill.createBill(1, 10, 1899, 25.50));
	}
}