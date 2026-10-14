import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerTest {

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
        Customer customer = new Customer();
        assertTrue(customer.verifyFirstName("B"));
    }

    // TC02
    // Test Objective: Verify firstName is accepted when more than 1 character
    // Input(s): FirstName = "Brian"
    // Expected Output(s): FirstName accepted
	@Order(2)
    @Test
    void validFirstName_TC02() {
        Customer customer = new Customer();
        assertTrue(customer.verifyFirstName("Brian"));
    }

    // TC03
    // Test Objective: Verify firstName is rejected when blank
    // Input(s): FirstName = ""
    // Expected Output(s): Error message: Invalid First Name
	@Order(3)
    @Test
    void invalidFirstNameBlank_TC03() {
        Customer customer = new Customer();
        assertFalse(customer.verifyFirstName(""));
    }

    // TC04
    // Test Objective: Verify firstName is rejected with digits
    // Input(s): FirstName = "M1k3"
    // Expected Output(s): Error message: Invalid First Name
	@Order(4)
    @Test
    void invalidFirstNameDigits_TC04() {
        Customer customer = new Customer();
        assertFalse(customer.verifyFirstName("M1k3"));
    }

    // TC05
    // Test Objective: Verify firstName is rejected with invalid symbols
    // Input(s): FirstName = "@!#$%^&*()_+=[]{};:"<>?/\\|~"
    // Expected Output(s): Error message: Invalid First Name
	@Order(5)
    @Test
    void invalidFirstNameInvalidSymbols_TC05() {
        Customer customer = new Customer();
        assertFalse(customer.verifyFirstName("@!#$%^&*()_+=[]{};:\"<>?/\\\\|~"));
    }

    // TC06
    // Test Objective: Verify firstName is accepted with allowed symbols
    // Input(s): FirstName = "'-"
    // Expected Output(s): FirstName accepted
	@Order(6)
    @Test
    void validFirstNameAllowedSymbols_TC06() {
        Customer customer = new Customer();
        assertTrue(customer.verifyFirstName("'-"));
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
        Customer customer = new Customer();
        assertTrue(customer.verifySurname("K"));
    }

    // TC08
    // Test Objective: Verify surname is accepted when more than 1 character
    // Input(s): Surname = "Kelly"
    // Expected Output(s): Surname accepted
	@Order(8)
    @Test
    void validSurname_TC08() {
        Customer customer = new Customer();
        assertTrue(customer.verifySurname("Kelly"));
    }

    // TC09
    // Test Objective: Verify surname is rejected when blank
    // Input(s): Surname = ""
    // Expected Output(s): Error message: Invalid Surname
	@Order(9)
    @Test
    void invalidSurnameBlank_TC09() {
        Customer customer = new Customer();
        assertFalse(customer.verifySurname(""));
    }

    // TC10
    // Test Objective: Verify surname is rejected with digits
    // Input(s): Surname = "Sm1th"
    // Expected Output(s): Error message: Invalid Surname
	@Order(10)
    @Test
    void invalidSurnameDigits_TC10() {
        Customer customer = new Customer();
        assertFalse(customer.verifySurname("Sm1th"));
    }

    // TC11
    // Test Objective: Verify surname is rejected with invalid symbols
    // Input(s): Surname = "@!#$%^&*()_+=[]{};:"<>?/\\|~"
    // Expected Output(s): Error message: Invalid Surname
	@Order(11)
    @Test
    void invalidSurnameInvalidSymbols_TC11() {
        Customer customer = new Customer();
        assertFalse(customer.verifySurname("@!#$%^&*()_+=[]{};:\"<>?/\\\\|~"));
    }

    // TC12
    // Test Objective: Verify surname is accepted with allowed symbols
    // Input(s): Surname = "'-"
    // Expected Output(s): Surname accepted
	@Order(12)
    @Test
    void validSurnameAllowedSymbols_TC12() {
        Customer customer = new Customer();
        assertTrue(customer.verifySurname("'-"));
    }

// ------------------------------------------------------------
// 					Address Tests (TC13–TC17)
// ------------------------------------------------------------

    // TC13
    // Test Objective: Verify address is accepted when 1 character
    // Input(s): Address = "B"
    // Expected Output(s): Address accepted
	@Order(13)
    @Test
    void validAddressMinBoundary_TC13() {
        Customer customer = new Customer();
        assertTrue(customer.verifyAddress("B"));
    }

    // TC14
    // Test Objective: Verify address is accepted when more than 1 character
    // Input(s): Address = "Ballycue"
    // Expected Output(s): Address accepted
	@Order(14)
    @Test
    void validAddress_TC14() {
        Customer customer = new Customer();
        assertTrue(customer.verifyAddress("Ballycue"));
    }

    // TC15
    // Test Objective: Verify address is rejected when blank
    // Input(s): Address = ""
    // Expected Output(s): Error message: Invalid Address
	@Order(15)
    @Test
    void invalidAddressBlank_TC15() {
        Customer customer = new Customer();
        assertFalse(customer.verifyAddress(""));
    }

    // TC16
    // Test Objective: Verify address is rejected with invalid symbols
    // Input(s): Address = "Main@Street!"
    // Expected Output(s): Invalid Address
	@Order(16)
    @Test
    void invalidAddressSymbols_TC16() {
        Customer customer = new Customer();
        assertFalse(customer.verifyAddress("Main@Street!"));
    }

    // TC17
    // Test Objective: Verify address is accepted with allowed symbols
    // Input(s): Address = "O'Connell-Street"
    // Expected Output(s): Address accepted
	@Order(17)
    @Test
    void validAddressAllowedSymbols_TC17() {
        Customer customer = new Customer();
        assertTrue(customer.verifyAddress("O'Connell-Street"));
    }

// ------------------------------------------------------------
// 					Phone Number Tests (TC18–TC22)
// ------------------------------------------------------------

    //TC18
    // Test Objective: Verify phone number is accepted when 10 digits
    // Input(s): Phone Number = "0871234567"
    // Expected Output(s): Phone number accepted
	@Order(18)
    @Test
    void validPhoneNumber_TC18() {
        Customer customer = new Customer();
        assertTrue(customer.verifyPhoneNumber("0871234567"));
    }

    //TC19
    // Test Objective: Verify phone number is rejected when fewer than 10 digits
    // Input(s): Phone Number = "087123456"
    // Expected Output(s): Error message: Invalid Phone Number
	@Order(19)
    @Test
    void invalidPhoneNumberTooShort_TC19() {
        Customer customer = new Customer();
        assertFalse(customer.verifyPhoneNumber("087123456"));
    }

    //TC20
    // Test Objective: Verify phone number is rejected when more than 10 digits
    // Input(s): Phone Number = "08712345678"
    // Expected Output(s): Error message: Invalid Phone Number
	@Order(20)
    @Test
    void invalidPhoneNumberTooLong_TC20() {
        Customer customer = new Customer();
        assertFalse(customer.verifyPhoneNumber("08712345678"));
    }

    //TC21
    //Test Objective: Verify phoneNumber is rejected when containing letters
    //Input(s): PhoneNumber = "08F512345"
    //Expected Output(s): Error message: Invalid Phone Number
	@Order(21)
    @Test
    void invalidPhoneNumberLetters_TC21() {
        Customer customer = new Customer();
        assertFalse(customer.verifyPhoneNumber("08F512345"));
    }

    //TC22
    //Test Objective: Verify phoneNumber is rejected when containing symbols
    //Input(s): PhoneNumber = "085@234567"
    //Expected Output(s): Error message: Invalid Phone Number
	@Order(22)
    @Test
    void invalidPhoneNumberSymbols_TC22() {
        Customer customer = new Customer();
        assertFalse(customer.verifyPhoneNumber("085@234567"));
    }
    
// ------------------------------------------------------------
// 					AreaCode Tests (TC23–TC27)
// ------------------------------------------------------------

 // TC23
    // Test Objective: Verify areaCode is accepted when within valid range
    // Input(s): AreaCode = 12
    // Expected Output(s): AreaCode accepted
	@Order(23)
    @Test
    void validAreaCode_TC23() {
        Customer customer = new Customer();
        assertTrue(customer.verifyAreaCode(12));
    }

    // TC24
    // Test Objective: Verify areaCode is accepted at lower boundary
    // Input(s): AreaCode = 1
    // Expected Output(s): AreaCode accepted
	@Order(24)
    @Test
    void validAreaCodeLowerBoundary_TC24() {
        Customer customer = new Customer();
        assertTrue(customer.verifyAreaCode(1));
    }

    // TC25
    // Test Objective: Verify areaCode is accepted at upper boundary
    // Input(s): AreaCode = 24
    // Expected Output(s): AreaCode accepted
	@Order(25)
    @Test
    void validAreaCodeUpperBoundary_TC25() {
        Customer customer = new Customer();
        assertTrue(customer.verifyAreaCode(24));
    }

    // TC26
    // Test Objective: Verify areaCode is rejected when below valid range
    // Input(s): AreaCode = 0
    // Expected Output(s): Error message: Invalid Area Code
	@Order(26)
    @Test
    void invalidAreaCodeTooLow_TC26() {
        Customer customer = new Customer();
        assertFalse(customer.verifyAreaCode(0));
    }

    // TC27
    // Test Objective: Verify areaCode is rejected when above valid range
    // Input(s): AreaCode = 25
    // Expected Output(s): Error message: Invalid Area Code
	@Order(27)
    @Test
    void invalidAreaCodeTooHigh_TC27() {
        Customer customer = new Customer();
        assertFalse(customer.verifyAreaCode(25));
    }
    
// ------------------------------------------------------------
// 					Creation Tests (TC28–TC33)
// ------------------------------------------------------------

    // TC28
    // Test Objective: Verify customer account is created when all details are valid
    // Input(s): John, Smith, Main Street, 0871234567, 12
    // Expected Output(s): Customer account created successfully
	@Order(28)
    @Test
    void createValidCustomerAccount_TC28() {
        Customer customer = new Customer();
        assertTrue(customer.createCustomer("John","Smith","Main Street","0871234567", 12));
    }

    // TC29
    // Test Objective: Verify customer account creation fails with invalid first name
    // Input(s): "", Smith, Main Street, 0871234567, 12
    // Expected Output(s): Customer account not created
	@Order(29)
    @Test
    void createAccountInvalidFirstName_TC29() {
        Customer customer = new Customer();
        assertFalse(customer.createCustomer("","Smith","Main Street","0871234567", 12));
    }

    // TC30
    // Test Objective: Verify customer account creation fails with invalid surname
    // Input(s): John, "", Main Street, 0871234567, 12
    // Expected Output(s): Customer account not created
	@Order(30)
    @Test
    void createAccountInvalidSurname_TC30() {
        Customer customer = new Customer();
        assertFalse(customer.createCustomer("John","","Main Street","0871234567", 12));
    }

    // TC31
    // Test Objective: Verify customer account creation fails with invalid address
    // Input(s): John, Smith, "", 0871234567, 12
    // Expected Output(s): Customer account not created
	@Order(31)
    @Test
    void createAccountInvalidAddress_TC31() {
        Customer customer = new Customer();
        assertFalse(customer.createCustomer("John","Smith","","0871234567", 12));
    }

    // TC32
    // Test Objective: Verify customer account creation fails with invalid phone number
    // Input(s): John, Smith, Main Street, 087123456, 12
    // Expected Output(s): Customer account not created
	@Order(32)
    @Test
    void createAccountInvalidPhoneNumber_TC32() {
        Customer customer = new Customer();
        assertFalse(customer.createCustomer("John","Smith","Main Street","087123456", 12));
    }
    
    // TC33
    // Test Objective: Verify customer account creation fails with invalid area code
    // Input(s): John, Smith, Main Street, 0871234567, 0
    // Expected Output(s): Customer account not created
	@Order(33)
    @Test
    void createAccountInvalidAreaCode_TC33() {
    	Customer customer = new Customer();
    	assertFalse(customer.createCustomer("John","Smith","Main Street","0871234567", 0));
    }
    
// ------------------------------------------------------------
// 					ID Tests (TC34–TC36)
//------------------------------------------------------------
    
    // TC34
    // Test Objective: Verify ID is generated when customer account is created
    // Input(s): John, Smith, Main Street, 0871234567, 12
    // Expected Output(s): Customer ID generated
	@Order(34)
    @Test
    void idGenerated_TC34() {
        Customer customer = new Customer();
        customer.createCustomer("John","Smith","Main Street","0871234567", 12);
        assertNotNull(customer.getId());
    }

    // TC35
    // Test Objective: Verify generated ID follows the 5-digit no-zero format
    // Input(s): John, Smith, Main Street, 0871234567, 12
    // Expected Output(s): Customer ID matches required format
	@Order(35)
    @Test
    void idMatchesFormat_TC35() {
        Customer customer = new Customer();
        customer.createCustomer("John","Smith","Main Street","0871234567", 12);
        assertTrue(String.valueOf(customer.getId()).matches("^[1-9]{5}$"));
    }

    // TC36
    // Test Objective: Verify each created customer receives a unique ID
    // Input(s): John, Smith, Main Street, 0871234567, 12 AND Mary, Kelly, High Street, 0879876543, 12
    // Expected Output(s): Customer IDs are unique
	@Order(36)
    @Test
    void idUnique_TC36() {
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        c1.createCustomer("John","Smith","Main Street","0871234567", 12);
        c2.createCustomer("Mary","Kelly","High Street","0879876543", 12);
        assertNotEquals(c1.getId(), c2.getId());
    }
}