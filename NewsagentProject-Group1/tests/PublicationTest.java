import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PublicationTest {
// -----------------------------------------------------------
//		Name Tests (TC01–TC07)
//------------------------------------------------------------

	// TC01
	// Test Objective: Verify name is accepted when containing only letters
	// Input(s): Name = "DailyNews"
	// Expected Output(s): Name accepted
	@Order(1)
	@Test
	void validName_TC01() {
		Publication publication = new Publication();
		assertTrue(publication.verifyName("DailyNews"));
	}

	// TC02
	// Test Objective: Verify name is accepted when containing a hyphen
	// Input(s): Name = "Daily-News"
	// Expected Output(s): Name accepted
	@Order(2)
	@Test
	void validNameHyphen_TC02() {
		Publication publication = new Publication();
		assertTrue(publication.verifyName("Daily-News"));
	}

	// TC03
	// Test Objective: Verify name is accepted when containing an apostrophe
	// Input(s): Name = "The'Times"
	// Expected Output(s): Name accepted
	@Order(3)
	@Test
	void validNameApostrophe_TC03() {
		Publication publication = new Publication();
		assertTrue(publication.verifyName("The'Times"));
	}

	// TC04
	// Test Objective: Verify name is rejected when blank
	// Input(s): Name = ""
	// Expected Output(s): Invalid Name
	@Order(4)
	@Test
	void invalidNameBlank_TC04() {
		Publication publication = new Publication();
		assertFalse(publication.verifyName(""));
	}

	// TC05
	// Test Objective: Verify name is rejected when null
	// Input(s): Name = null
	// Expected Output(s): Invalid Name
	@Order(5)
	@Test
	void invalidNameNull_TC05() {
		Publication publication = new Publication();
		assertFalse(publication.verifyName(null));
	}

	// TC06
	// Test Objective: Verify name is rejected when containing numbers
	// Input(s): Name = "Daily123"
	// Expected Output(s): Invalid Name
	@Order(6)
	@Test
	void invalidNameNumbers_TC06() {
		Publication publication = new Publication();
		assertFalse(publication.verifyName("Daily123"));
	}

	// TC07
	// Test Objective: Verify name is rejected when containing spaces
	// Input(s): Name = "Daily News"
	// Expected Output(s): Invalid Name
	@Order(7)
	@Test
	void invalidNameSpaces_TC07() {
		Publication publication = new Publication();
		assertFalse(publication.verifyName("Daily News"));
	}
	
// -----------------------------------------------------------
//	Stock Tests (TC08–TC12)
//------------------------------------------------------------
	
	// TC08
	// Test Objective: Verify stock is accepted when greater than 1
	// Input(s): Stock = 2
	// Expected Output(s): Stock accepted
	@Order(8)
	@Test
	void validStockMinBoundary_TC08() {
		Publication publication = new Publication();
		assertTrue(publication.verifyStock(2));
	}

	// TC09
	// Test Objective: Verify stock is accepted when greater than 2
	// Input(s): Stock = 100
	// Expected Output(s): Stock accepted
	@Order(9)
	@Test
	void validStock_TC09() {
		Publication publication = new Publication();
		assertTrue(publication.verifyStock(100));
	}

	// TC10
	// Test Objective: Verify stock is accepted at the minimum valid value 
		// Input(s): Stock = 1
		// Expected Output(s): Stock accepted
	@Order(10)
	@Test
	void validStockBoundary_TC10() {
		Publication publication = new Publication();
		assertTrue(publication.verifyStock(1));
	}

	// TC11
	// Test Objective: Verify stock is rejected when equal to 0
	// Input(s): Stock = 0
	// Expected Output(s): Invalid Stock
	@Order(11)
	@Test
	void invalidStockZero_TC11() {
		Publication publication = new Publication();
		assertFalse(publication.verifyStock(0));
	}

	// TC12
	// Test Objective: Verify stock is rejected when negative
	// Input(s): Stock = -1
	// Expected Output(s): Invalid Stock
	@Order(12)
	@Test
	void invalidStockNegative_TC12() {
		Publication publication = new Publication();
		assertFalse(publication.verifyStock(-1));
	}
	
// -----------------------------------------------------------
//		Price Tests (TC13–TC)
//------------------------------------------------------------
	
	// TC13
	// Test Objective: Verify price is accepted when greater than 1
	// Input(s): Price = 2
	// Expected Output(s): Publication stock accepted
	@Order(8)
	@Test
	void validPriceMinBoundary_TC08() {
		Publication publication = new Publication();
		assertTrue(publication.verifyPrice(2));
	}

	// TC09
	// Test Objective: Verify price is accepted when greater than 2
	// Input(s): Price = 100
	// Expected Output(s): Price accepted
	@Order(9)
	@Test
	void validPrice_TC09() {
		Publication publication = new Publication();
		assertTrue(publication.verifyPrice(100));
	}

	// TC10
	// Test Objective: Verify price is accepted at the minimum valid value 
	// Input(s): Price = 1
		// Expected Output(s): Price accepted
	@Order(10)
	@Test
	void validPriceBoundary_TC10() {
		Publication publication = new Publication();
		assertTrue(publication.verifyPrice(1));
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
	
// -----------------------------------------------------------
//	Name Set Tests (TC013–TC014)
//------------------------------------------------------------
	
	// TC13
	// Test Objective: Verify name is successfully set
	// Input(s): Name = "DailyNews"
	// Expected Output(s): Name set successfully
	@Order(13)
	@Test
	void setValidName_TC13() {
		Publication publication = new Publication();
		assertTrue(publication.setName("DailyNews"));
		assertEquals("DailyNews", publication.getName());
	}

	// TC14
	// Test Objective: Verify name is not set when invalid
	// Input(s): Name = ""
	// Expected Output(s): Name not set
	@Order(14)
	@Test
	void setInvalidName_TC14() {
		Publication publication = new Publication();
		assertFalse(publication.setName(""));
		assertNull(publication.getName());
	}
	
// -----------------------------------------------------------
//		Stock Set Tests (TC015–TC016)
//------------------------------------------------------------
		
	// TC15
	// Test Objective: Verify stock is successfully set
	// Input(s): Stock = 10
	// Expected Output(s): Stock set successfully
	@Order(15)
	@Test
	void setValidStock_TC15() {
		Publication publication = new Publication();
		assertTrue(publication.setStock(10));
		assertEquals(10, publication.getStock());
	}

	// TC16
	// Test Objective: Verify stock is successfully set at the minimum valid value 
	// Input(s): Stock = 1
	// Expected Output(s): Stock set successfully
	@Order(16)
	@Test
	void setValidStock_TC16() {
		Publication publication = new Publication();
		assertTrue(publication.setStock(1));
		assertEquals(1, publication.getStock());
	}

// ------------------------------------------------------------
//		Creation Tests (TC17–TC20)
//-------------------------------------------------------------

	// TC18
	// Test Objective: Verify publication is created when all details are valid
	// Input(s): "DailyNews", 100, 2
	// Expected Output(s): Publication created successfully
	@Order(18)
	@Test
	void createValidPublication_TC18() {
		Publication publication = new Publication();
		assertTrue(publication.createPublication("DailyNews", 100, 2));
		assertEquals("DailyNews", publication.getName());
		assertEquals(100, publication.getStock());
	}

	// TC19
	// Test Objective: Verify publication creation fails with invalid publication
	// name
	// Input(s): "", 100, 2
	// Expected Output(s): Publication not created
	@Order(19)
	@Test
	void createPublicationInvalidName_TC19() {
		Publication publication = new Publication();
		assertFalse(publication.createPublication("", 100, 2));
	}

	// TC20
	// Test Objective: Verify publication creation fails with invalid publication
	// stock
	// Input(s): "DailyNews", -1, 2
	// Expected Output(s): Publication not created
	@Order(20)
	@Test
	void createPublicationInvalidStock_TC20() {
		Publication publication = new Publication();
		assertFalse(publication.createPublication("DailyNews", -1, 2));
	}
	
	// TC21
	// Test Objective: Verify publication creation fails with invalid publication
	// stock
	// Input(s): "DailyNews", -1, -2
	// Expected Output(s): Publication not created
	@Order(21)
	@Test
	void createPublicationInvalidPrice_TC21() {
		Publication publication = new Publication();
		assertFalse(publication.createPublication("DailyNews", -1, -2));
	}
}