import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PublicationTest {
	// TC01
	// Test Objective: Verify publication name is accepted when containing only
	// letters
	// Input(s): Publication Name = "DailyNews"
	// Expected Output(s): Publication name accepted
	@Test
	void validPublicationName_TC01() {
		Publication publication = new Publication();
		assertTrue(publication.verifyPublicationName("DailyNews"));
	}

	// TC02
	// Test Objective: Verify publication name is accepted when containing a hyphen
	// Input(s): Publication Name = "Daily-News"
	// Expected Output(s): Publication name accepted
	@Test
	void validPublicationNameHyphen_TC02() {
		Publication publication = new Publication();
		assertTrue(publication.verifyPublicationName("Daily-News"));
	}

	// TC03
	// Test Objective: Verify publication name is accepted when containing an
	// apostrophe
	// Input(s): Publication Name = "The'Times"
	// Expected Output(s): Publication name accepted
	@Test
	void validPublicationNameApostrophe_TC03() {
		Publication publication = new Publication();
		assertTrue(publication.verifyPublicationName("The'Times"));
	}

	// TC04
	// Test Objective: Verify publication name is rejected when blank
	// Input(s): Publication Name = ""
	// Expected Output(s): Invalid Publication Name
	@Test
	void invalidPublicationNameBlank_TC04() {
		Publication publication = new Publication();
		assertFalse(publication.verifyPublicationName(""));
	}

	// TC05
	// Test Objective: Verify publication name is rejected when null
	// Input(s): Publication Name = null
	// Expected Output(s): Invalid Publication Name
	@Test
	void invalidPublicationNameNull_TC05() {
		Publication publication = new Publication();
		assertFalse(publication.verifyPublicationName(null));
	}

	// TC06
	// Test Objective: Verify publication name is rejected when containing numbers
	// Input(s): Publication Name = "Daily123"
	// Expected Output(s): Invalid Publication Name
	@Test
	void invalidPublicationNameNumbers_TC06() {
		Publication publication = new Publication();
		assertFalse(publication.verifyPublicationName("Daily123"));
	}

	// TC07
	// Test Objective: Verify publication name is rejected when containing spaces
	// Input(s): Publication Name = "Daily News"
	// Expected Output(s): Invalid Publication Name
	@Test
	void invalidPublicationNameSpaces_TC07() {
		Publication publication = new Publication();
		assertFalse(publication.verifyPublicationName("Daily News"));
	}

	// TC08
	// Test Objective: Verify publication stock is accepted when greater than 1
	// Input(s): Publication Stock = 2
	// Expected Output(s): Publication stock accepted
	@Test
	void validPublicationStockMinBoundary_TC08() {
		Publication publication = new Publication();
		assertTrue(publication.verifyPublicationStock(2));
	}

	// TC09
	// Test Objective: Verify publication stock is accepted when greater than 2
	// Input(s): Publication Stock = 100
	// Expected Output(s): Publication stock accepted
	@Test
	void validPublicationStock_TC09() {
		Publication publication = new Publication();
		assertTrue(publication.verifyPublicationStock(100));
	}

	// TC10
	// Test Objective: Verify publication stock is rejected when equal to 1
	// Input(s): Publication Stock = 1
	// Expected Output(s): Invalid Publication Stock
	@Test
	void invalidPublicationStockBoundary_TC10() {
		Publication publication = new Publication();
		assertFalse(publication.verifyPublicationStock(1));
	}

	// TC11
	// Test Objective: Verify publication stock is rejected when equal to 0
	// Input(s): Publication Stock = 0
	// Expected Output(s): Invalid Publication Stock
	@Test
	void invalidPublicationStockZero_TC11() {
		Publication publication = new Publication();
		assertFalse(publication.verifyPublicationStock(0));
	}

	// TC12
	// Test Objective: Verify publication stock is rejected when negative
	// Input(s): Publication Stock = -1
	// Expected Output(s): Invalid Publication Stock
	@Test
	void invalidPublicationStockNegative_TC12() {
		Publication publication = new Publication();
		assertFalse(publication.verifyPublicationStock(-1));
	}

	// TC13
	// Test Objective: Verify publication name is successfully set
	// Input(s): Publication Name = "DailyNews"
	// Expected Output(s): Publication name set successfully
	@Test
	void setValidPublicationName_TC13() {
		Publication publication = new Publication();
		assertTrue(publication.setPublicationName("DailyNews"));
		assertEquals("DailyNews", publication.getPublicationName());
	}

	// TC14
	// Test Objective: Verify publication name is not set when invalid
	// Input(s): Publication Name = ""
	// Expected Output(s): Publication name not set
	@Test
	void setInvalidPublicationName_TC14() {
		Publication publication = new Publication();
		assertFalse(publication.setPublicationName(""));
		assertNull(publication.getPublicationName());
	}

	// TC15
	// Test Objective: Verify publication stock is successfully set
	// Input(s): Publication Stock = 10
	// Expected Output(s): Publication stock set successfully
	@Test
	void setValidPublicationStock_TC15() {
		Publication publication = new Publication();
		assertTrue(publication.setPublicationStock(10));
		assertEquals(10, publication.getPublicationStock());
	}

	// TC16
	// Test Objective: Verify publication stock is not set when invalid
	// Input(s): Publication Stock = 1
	// Expected Output(s): Publication stock not set
	@Test
	void setInvalidPublicationStock_TC16() {
		Publication publication = new Publication();
		assertFalse(publication.setPublicationStock(1));
		assertEquals(0, publication.getPublicationStock());
	}

	// TC17
	// Test Objective: Verify publication ID is successfully set
	// Input(s): Publication ID = 12345
	// Expected Output(s): Publication ID set successfully
	@Test
	void setPublicationId_TC17() {
		Publication publication = new Publication();
		publication.setPublicationId(12345);
		assertEquals(12345, publication.getPublicationId());
	}

	// TC18
	// Test Objective: Verify publication is created when all details are valid
	// Input(s): "DailyNews", 100
	// Expected Output(s): Publication created successfully
	@Test
	void createValidPublication_TC18() {
		Publication publication = new Publication();
		assertTrue(publication.createPublication("DailyNews", 100));
		assertEquals("DailyNews", publication.getPublicationName());
		assertEquals(100, publication.getPublicationStock());
	}

	// TC19
	// Test Objective: Verify publication creation fails with invalid publication
	// name
	// Input(s): "", 100
	// Expected Output(s): Publication not created
	@Test
	void createPublicationInvalidName_TC19() {
		Publication publication = new Publication();
		assertFalse(publication.createPublication("", 100));
	}

	// TC20
	// Test Objective: Verify publication creation fails with invalid publication
	// stock
	// Input(s): "DailyNews", 1
	// Expected Output(s): Publication not created
	@Test
	void createPublicationInvalidStock_TC20() {
		Publication publication = new Publication();
		assertFalse(publication.createPublication("DailyNews", 1));
	}
}