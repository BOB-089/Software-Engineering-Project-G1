import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NewsagentTest {
// ------------------------------------------------------------
//		FirstName Tests (TC01–TC06)
//------------------------------------------------------------

	// TC01
	// Test Objective: Verify firstName is accepted when 1 character
	// Input(s): FirstName = "B"
	// Expected Output(s): FirstName accepted
	@Order(1)
	@Test
	void validFirstNameMinBoundary_TC01() {
		Newsagent newsagent = new Newsagent();
		assertTrue(newsagent.verifyFirstName("B"));
	}
	
	// TC02
	// Test Objective: Verify firstName is accepted when more than 1 character
	// Input(s): FirstName = "Brian"
	// Expected Output(s): FirstName accepted
	@Order(2)
	@Test
	void validFirstName_TC02() {
		Newsagent newsagent = new Newsagent();
		assertTrue(newsagent.verifyFirstName("Brian"));
	}
	
	// TC03
	// Test Objective: Verify firstName is rejected when blank
	// Input(s): FirstName = ""
	// Expected Output(s): Error message: Invalid First Name
	@Order(3)
	@Test
	void invalidFirstNameBlank_TC03() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.verifyFirstName(""));
	}
	
	// TC04
	// Test Objective: Verify firstName is rejected with digits
	// Input(s): FirstName = "M1k3"
	// Expected Output(s): Error message: Invalid First Name
	@Order(4)
	@Test
	void invalidFirstNameDigits_TC04() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.verifyFirstName("M1k3"));
	}
	
	// TC05
	// Test Objective: Verify firstName is rejected with invalid symbols
	// Input(s): FirstName = "@!#$%^&*()_+=[]{};:"<>?/\\|~"
	// Expected Output(s): Error message: Invalid First Name
	@Order(5)
	@Test
	void invalidFirstNameInvalidSymbols_TC05() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.verifyFirstName("@!#$%^&*()_+=[]{};:\"<>?/\\\\|~"));
	}
	
	// TC06
	// Test Objective: Verify firstName is accepted with allowed symbols
	// Input(s): FirstName = "'-"
	// Expected Output(s): FirstName accepted
	@Order(6)
	@Test
	void validFirstNameAllowedSymbols_TC06() {
		Newsagent newsagent = new Newsagent();
		assertTrue(newsagent.verifyFirstName("'-"));
	}
	
	//------------------------------------------------------------
	//		SURNAME Tests (TC07–TC12)
	//------------------------------------------------------------
	
	// TC07
	// Test Objective: Verify surname is accepted when 1 character
	// Input(s): Surname = "K"
	// Expected Output(s): Surname accepted
	@Order(7)
	@Test
	void validSurnameMinBoundary_TC07() {
		Newsagent newsagent = new Newsagent();
		assertTrue(newsagent.verifySurname("K"));
	}
	
	// TC08
	// Test Objective: Verify surname is accepted when more than 1 character
	// Input(s): Surname = "Kelly"
	// Expected Output(s): Surname accepted
	@Order(8)
	@Test
	void validSurname_TC08() {
		Newsagent newsagent = new Newsagent();
		assertTrue(newsagent.verifySurname("Kelly"));
	}
	
	// TC09
	// Test Objective: Verify surname is rejected when blank
	// Input(s): Surname = ""
	// Expected Output(s): Error message: Invalid Surname
	@Order(9)
	@Test
	void invalidSurnameBlank_TC09() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.verifySurname(""));
	}
	
	// TC10
	// Test Objective: Verify surname is rejected with digits
	// Input(s): Surname = "Sm1th"
	// Expected Output(s): Error message: Invalid Surname
	@Order(10)
	@Test
	void invalidSurnameDigits_TC10() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.verifySurname("Sm1th"));
	}
	
	// TC11
	// Test Objective: Verify surname is rejected with invalid symbols
	// Input(s): Surname = "@!#$%^&*()_+=[]{};:"<>?/\\|~"
	// Expected Output(s): Error message: Invalid Surname
	@Order(11)
	@Test
	void invalidSurnameInvalidSymbols_TC11() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.verifySurname("@!#$%^&*()_+=[]{};:\"<>?/\\\\|~"));
	}
	
	// TC12
	// Test Objective: Verify surname is accepted with allowed symbols
	// Input(s): Surname = "'-"
	// Expected Output(s): Surname accepted
	@Order(12)
	@Test
	void validSurnameAllowedSymbols_TC12() {
		Newsagent newsagent = new Newsagent();
		assertTrue(newsagent.verifySurname("'-"));
	}
	
// ------------------------------------------------------------
//		Phone Number Tests (TC13–TC17)
//------------------------------------------------------------

	//TC13
	// Test Objective: Verify phone number is accepted when 10 digits
	// Input(s): Phone Number = "0871234567"
	// Expected Output(s): Phone number accepted
	@Order(13)
	@Test
	void validPhoneNumber_TC13() {
		Newsagent newsagent = new Newsagent();
		assertTrue(newsagent.verifyPhoneNumber("0871234567"));
	}
	
	//TC14
	// Test Objective: Verify phone number is rejected when fewer than 10 digits
	// Input(s): Phone Number = "087123456"
	// Expected Output(s): Error message: Invalid Phone Number
	@Order(14)
	@Test
	void invalidPhoneNumberTooShort_TC14() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.verifyPhoneNumber("087123456"));
	}
	
	//TC15
	// Test Objective: Verify phone number is rejected when more than 10 digits
	// Input(s): Phone Number = "08712345678"
	// Expected Output(s): Error message: Invalid Phone Number
	@Order(15)
	@Test
	void invalidPhoneNumberTooLong_TC15() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.verifyPhoneNumber("08712345678"));
	}
	
	//TC16
	//Test Objective: Verify phoneNumber is rejected when containing letters
	//Input(s): PhoneNumber = "08F512345"
	//Expected Output(s): Error message: Invalid Phone Number
	@Order(16)
	@Test
	void invalidPhoneNumberLetters_TC16() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.verifyPhoneNumber("08F512345"));
	}
	
	//TC17
	//Test Objective: Verify phoneNumber is rejected when containing symbols
	//Input(s): PhoneNumber = "085@234567"
	//Expected Output(s): Error message: Invalid Phone Number
	@Order(17)
	@Test
	void invalidPhoneNumberSymbols_TC17() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.verifyPhoneNumber("085@234567"));
	}
	
// ------------------------------------------------------------
//		Creation Tests (TC18–TC21)
//------------------------------------------------------------

	// TC18
	// Test Objective: Verify newsagent account is created when all details are valid
	// Input(s): John, Smith, 0871234567
	// Expected Output(s): Newsagent account created successfully
	@Order(18)
	@Test
	void createValidCustomerAccount_TC18() {
		Newsagent newsagent = new Newsagent();
		assertTrue(newsagent.createNewsagent("John","Smith","0871234567"));
	}
	
	// TC19
	// Test Objective: Verify newsagent account creation fails with invalid first name
	// Input(s): "", Smith, 0871234567
	// Expected Output(s): Newsagent account not created
	@Order(19)
	@Test
	void createAccountInvalidFirstName_TC19() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.createNewsagent("","Smith","0871234567"));
	}
	
	// TC20
	// Test Objective: Verify newsagent account creation fails with invalid surname
	// Input(s): John, "", 0871234567
	// Expected Output(s): Newsagent account not created
	@Order(20)
	@Test
	void createAccountInvalidSurname_TC20() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.createNewsagent("John","","0871234567"));
	}
	
	// TC20
	// Test Objective: Verify newsagent account creation fails with invalid phone number
	// Input(s): John, Smith, 087123456
	// Expected Output(s): Newsagent account not created
	@Order(21)
	@Test
	void createAccountInvalidPhoneNumber_TC21() {
		Newsagent newsagent = new Newsagent();
		assertFalse(newsagent.createNewsagent("John","Smith","087123456"));
	}
	
//------------------------------------------------------------
//		ID Test (TC22)
//------------------------------------------------------------
	
	// TC22
	// Test Objective: Verify ID is generated when newsagent account is created
	// Input(s): John, Smith, 0871234567
	// Expected Output(s): Newsagent ID generated
	@Order(22)
	@Test
	void idGenerated_TC22() {
		Newsagent newsagent = new Newsagent();
		newsagent.createNewsagent("John","Smith","0871234567");
		assertNotNull(newsagent.getId());
	}
	
}
