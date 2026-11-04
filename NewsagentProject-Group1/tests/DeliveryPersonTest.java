import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeliveryPersonTest {

// ------------------------------------------------------------
// 					FirstName Tests (TC01–TC06)
// ------------------------------------------------------------

    // TC01
    // Test Objective: Verify firstName is accepted when 1 character
    // Input(s): FirstName = "B"
    // Expected Output(s): FirstName accepted
	@Order(1)
    @Test
    void validFirstNameMinBoundary_TC01() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertTrue(deliveryPerson.verifyFirstName("B"));
    }

    // TC02
    // Test Objective: Verify firstName is accepted when more than 1 character
    // Input(s): FirstName = "Brian"
    // Expected Output(s): FirstName accepted
	@Order(2)
    @Test
    void validFirstName_TC02() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertTrue(deliveryPerson.verifyFirstName("Brian"));
    }

    // TC03
    // Test Objective: Verify firstName is rejected when blank
    // Input(s): FirstName = ""
    // Expected Output(s): Error message: Invalid First Name
	@Order(3)
    @Test
    void invalidFirstNameBlank_TC03() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertFalse(deliveryPerson.verifyFirstName(""));
    }

    // TC04
    // Test Objective: Verify firstName is rejected with digits
    // Input(s): FirstName = "M1k3"
    // Expected Output(s): Error message: Invalid First Name
	@Order(4)
    @Test
    void invalidFirstNameDigits_TC04() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertFalse(deliveryPerson.verifyFirstName("M1k3"));
    }

    // TC05
    // Test Objective: Verify firstName is rejected with invalid symbols
    // Input(s): FirstName = "@!#$%^&*()_+=[]{};:\"<>?/\\|~"
    // Expected Output(s): Error message: Invalid First Name
	@Order(5)
    @Test
    void invalidFirstNameInvalidSymbols_TC05() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertFalse(deliveryPerson.verifyFirstName("@!#$%^&*()_+=[]{};:\"<>?/\\\\|~"));
    }

    // TC06
    // Test Objective: Verify firstName is accepted with allowed symbols
    // Input(s): FirstName = "'-"
    // Expected Output(s): FirstName accepted
	@Order(6)
    @Test
    void validFirstNameAllowedSymbols_TC06() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertTrue(deliveryPerson.verifyFirstName("'-"));
    }

// ------------------------------------------------------------
// 					SURNAME Tests (TC07–TC12)
// ------------------------------------------------------------

    // TC07
    // Test Objective: Verify surname is accepted when 1 character
    // Input(s): Surname = "K"
    // Expected Output(s): Surname accepted
	@Order(7)
    @Test
    void validSurnameMinBoundary_TC07() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertTrue(deliveryPerson.verifySurname("K"));
    }

    // TC08
    // Test Objective: Verify surname is accepted when more than 1 character
    // Input(s): Surname = "Kelly"
    // Expected Output(s): Surname accepted
	@Order(8)
    @Test
    void validSurname_TC08() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertTrue(deliveryPerson.verifySurname("Kelly"));
    }

    // TC09
    // Test Objective: Verify surname is rejected when blank
    // Input(s): Surname = ""
    // Expected Output(s): Error message: Invalid Surname
	@Order(9)
    @Test
    void invalidSurnameBlank_TC09() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertFalse(deliveryPerson.verifySurname(""));
    }

    // TC10
    // Test Objective: Verify surname is rejected with digits
    // Input(s): Surname = "Sm1th"
    // Expected Output(s): Error message: Invalid Surname
	@Order(10)
    @Test
    void invalidSurnameDigits_TC10() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertFalse(deliveryPerson.verifySurname("Sm1th"));
    }

    // TC11
    // Test Objective: Verify surname is rejected with invalid symbols
    // Input(s): Surname = "@!#$%^&*()_+=[]{};:\"<>?/\\|~"
    // Expected Output(s): Error message: Invalid Surname
	@Order(11)
    @Test
    void invalidSurnameInvalidSymbols_TC11() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertFalse(deliveryPerson.verifySurname("@!#$%^&*()_+=[]{};:\"<>?/\\\\|~"));
    }

    // TC12
    // Test Objective: Verify surname is accepted with allowed symbols
    // Input(s): Surname = "'-"
    // Expected Output(s): Surname accepted
	@Order(12)
    @Test
    void validSurnameAllowedSymbols_TC12() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertTrue(deliveryPerson.verifySurname("'-"));
    }

// ------------------------------------------------------------
// 					Phone Number Tests (TC13–TC17)
// ------------------------------------------------------------

    // TC13
    // Test Objective: Verify phone number is accepted when 10 digits
    // Input(s): Phone Number = "0871234567"
    // Expected Output(s): Phone number accepted
	@Order(13)
    @Test
    void validPhoneNumber_TC13() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertTrue(deliveryPerson.verifyPhoneNumber("0871234567"));
    }

    // TC14
    // Test Objective: Verify phone number is rejected when fewer than 10 digits
    // Input(s): Phone Number = "087123456"
    // Expected Output(s): Error message: Invalid Phone Number
	@Order(14)
    @Test
    void invalidPhoneNumberTooShort_TC14() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertFalse(deliveryPerson.verifyPhoneNumber("087123456"));
    }

    // TC15
    // Test Objective: Verify phone number is rejected when more than 10 digits
    // Input(s): Phone Number = "08712345678"
    // Expected Output(s): Error message: Invalid Phone Number
	@Order(15)
    @Test
    void invalidPhoneNumberTooLong_TC15() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertFalse(deliveryPerson.verifyPhoneNumber("08712345678"));
    }

    // TC16
    // Test Objective: Verify phoneNumber is rejected when containing letters
    // Input(s): PhoneNumber = "08F512345"
    // Expected Output(s): Error message: Invalid Phone Number
	@Order(16)
    @Test
    void invalidPhoneNumberLetters_TC16() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertFalse(deliveryPerson.verifyPhoneNumber("08F512345"));
    }

    // TC17
    // Test Objective: Verify phoneNumber is rejected when containing symbols
    // Input(s): PhoneNumber = "085@234567"
    // Expected Output(s): Error message: Invalid Phone Number
	@Order(17)
    @Test
    void invalidPhoneNumberSymbols_TC17() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertFalse(deliveryPerson.verifyPhoneNumber("085@234567"));
    }
    
// ------------------------------------------------------------
// 					AreaCode Tests (TC18–TC22)
// ------------------------------------------------------------

    // TC18
    // Test Objective: Verify areaCode is accepted when within valid range
    // Input(s): AreaCode = 12
    // Expected Output(s): AreaCode accepted
	@Order(18)
    @Test
    void validAreaCode_TC18() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertTrue(deliveryPerson.verifyAreaCode(12));
    }

    // TC19
    // Test Objective: Verify areaCode is accepted at lower boundary
    // Input(s): AreaCode = 1
    // Expected Output(s): AreaCode accepted
	@Order(19)
    @Test
    void validAreaCodeLowerBoundary_TC19() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertTrue(deliveryPerson.verifyAreaCode(1));
    }

    // TC20
    // Test Objective: Verify areaCode is accepted at upper boundary
    // Input(s): AreaCode = 24
    // Expected Output(s): AreaCode accepted
	@Order(20)
    @Test
    void validAreaCodeUpperBoundary_TC20() {
        DeliveryPerson deliveryPerson = new DeliveryPerson();
        assertTrue(deliveryPerson.verifyAreaCode(24));
    }

    // TC21
    // Test Objective: Verify areaCode is rejected when below valid range
    // Input(s): AreaCode = 0
    // Expected Output(s): Error message: Invalid Area Code
	@Order(21)
    @Test
    void invalidAreaCodeTooLow_TC21() {