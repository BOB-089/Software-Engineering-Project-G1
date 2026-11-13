import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PublicationTest {
	
// -----------------------------------------------------------
// 					Name Tests (TC01–TC05)
// -----------------------------------------------------------

	// TC01
	// Test Objective: Verify name is accepted when 1 character
	// Input(s): Name = "T"
	// Expected Output(s): Name accepted
	@Order(1)
	@Test
	void validNameMinBoundary_TC01() {
		Publication publication = new Publication();
		assertTrue(publication.verifyName("T"));
	}
		
	// TC02
	// Test Objective: Verify name is accepted when containing only letters and numbers
	// Input(s): Name = "News24"
	// Expected Output(s): Name accepted
	@Order(2)
	@Test
	void validName_TC02() {
		Publication publication = new Publication();
		assertTrue(publication.verifyName("News24"));
	}

	// TC03
	// Test Objective: Verify name is rejected when blank
	// Input(s): Name = ""
	// Expected Output(s): Invalid Name
	@Order(3)
	@Test
	void invalidNameBlank_TC03() {
		Publication publication = new Publication();
		assertFalse(publication.verifyName(""));
	}

	// TC04
	// Test Objective: Verify name is rejected with invalid symbols
	// Input(s): Name = "@!#$%^&*()_+=[]{};:\"<>?/\\|~"
	// Expected Output(s): Invalid Name
	@Order(4)
	@Test
	void invalidNameInvalidSymbols_TC04() {
	    Publication publication = new Publication();
	    assertFalse(publication.verifyName("@!#$%^&*()_+=[]{};:\"<>?/\\\\|~"));
	}
	
	// TC05
	// Test Objective: Verify name is accepted with allowed symbols
	// Input(s): Name = "The Irish-Times'"
	// Expected Output(s): Name accepted
	@Order(5)
	@Test
	void validNameAllowedSymbols_TC05() {
	    Publication publication = new Publication();
	    assertTrue(publication.verifyName("The Irish-Times'"));
	}
	
// -----------------------------------------------------------
// 					Stock Tests (TC06–TC09)
// -----------------------------------------------------------
	
	// TC06
	// Test Objective: Verify stock is accepted when greater than 1
	// Input(s): Stock = 100
	// Expected Output(s): Stock accepted
	@Order(6)
	@Test
	void validStock_TC06() {
		Publication publication = new Publication();
		assertTrue(publication.verifyStock(100));
	}

	// TC07
	// Test Objective: Verify stock is accepted at the minimum valid value 
	// Input(s): Stock = 1
	// Expected Output(s): Stock accepted
	@Order(7)
	@Test
	void validStockMinBoundary_TC07() {
		Publication publication = new Publication();
		assertTrue(publication.verifyStock(1));
	}

	// TC08
	// Test Objective: Verify stock is rejected when equal to 0
	// Input(s): Stock = 0
	// Expected Output(s): Invalid Stock
	@Order(8)
	@Test
	void invalidStockZero_TC08() {
		Publication publication = new Publication();
		assertFalse(publication.verifyStock(0));
	}

	// TC09
	// Test Objective: Verify stock is rejected when negative
	// Input(s): Stock = -1
	// Expected Output(s): Invalid Stock
	@Order(9)
	@Test
	void invalidStockNegative_TC09() {
		Publication publication = new Publication();
		assertFalse(publication.verifyStock(-1));
	}
	
// -----------------------------------------------------------
// 					Price Tests (TC10–TC15)
// -----------------------------------------------------------

	// TC10
	// Test Objective: Verify price is accepted at the minimum valid value 
	// Input(s): Price = 0.01
	// Expected Output(s): Price accepted
	@Order(10)
	@Test
	void validPriceMinBoundary_TC10() {
		Publication publication = new Publication();
		assertTrue(publication.verifyPrice(0.01));
	}

	// TC11
	// Test Objective: Verify price is rejected when equal to 0
	// Input(s): Price = 0
	// Expected Output(s): Invalid Price
	@Order(11)
	@Test
	void invalidPriceZero_TC11() {
		Publication publication = new Publication();
		assertFalse(publication.verifyPrice(0));
	}

	// TC12
	// Test Objective: Verify price is rejected when negative
	// Input(s): Price = -1
	// Expected Output(s): Invalid Price
	@Order(12)
	@Test
	void invalidPriceNegative_TC12() {
		Publication publication = new Publication();
		assertFalse(publication.verifyPrice(-1));
	}
	
	// TC13
	// Test Objective: Verify price is accepted when entered with one decimal place
	// Input(s): Price = 2.5
	// Expected Output(s): Price accepted
	@Order(13)
	@Test
	void validPriceOneDecimalPlace_TC13() {
	    Publication publication = new Publication();
	    assertTrue(publication.verifyPrice(2.5));
	}

	// TC14
	// Test Objective: Verify price is accepted when entered with two decimal places
	// Input(s): Price = 2.99
	// Expected Output(s): Price accepted
	@Order(14)
	@Test
	void validPriceTwoDecimalPlaces_TC14() {
	    Publication publication = new Publication();
	    assertTrue(publication.verifyPrice(2.99));
	}

	// TC15
	// Test Objective: Verify price is rejected when entered with more than two decimal places
	// Input(s): Price = 2.999
	// Expected Output(s): Invalid Price
	@Order(15)
	@Test
	void invalidPriceTooManyDecimalPlaces_TC15() {
	    Publication publication = new Publication();
	    assertFalse(publication.verifyPrice(2.999));
	}
	
// ------------------------------------------------------------
// 					Creation Tests (TC16–TC19)
// ------------------------------------------------------------

	// TC16
	// Test Objective: Verify publication is created when all details are valid
	// Input(s): "DailyNews", 100, 2
	// Expected Output(s): Publication created successfully
	@Order(16)
	@Test
	void createValidPublication_TC16() {
		Publication publication = new Publication();
		assertTrue(publication.createPublication("DailyNews", 100, 2));
	}

	// TC17
	// Test Objective: Verify publication creation fails with invalid publication name
	// Input(s): "", 100, 2
	// Expected Output(s): Publication not created
	@Order(17)
	@Test
	void createPublicationInvalidName_TC17() {
		Publication publication = new Publication();
		assertFalse(publication.createPublication("", 100, 2));
	}

	// TC18
	// Test Objective: Verify publication creation fails with invalid publication stock
	// Input(s): "DailyNews", -1, 2
	// Expected Output(s): Publication not created
	@Order(18)
	@Test
	void createPublicationInvalidStock_TC18() {
		Publication publication = new Publication();
		assertFalse(publication.createPublication("DailyNews", -1, 2));
	}
	
	// TC19
	// Test Objective: Verify publication creation fails with invalid publication price
	// Input(s): "DailyNews", 100, 2.999
	// Expected Output(s): Publication not created
	@Order(19)
	@Test
	void createPublicationInvalidPrice_TC19() {
		Publication publication = new Publication();
		assertFalse(publication.createPublication("DailyNews", 100, 2.999));
	}
}