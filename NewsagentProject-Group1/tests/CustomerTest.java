import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerTest {

// ------------------------------------------------------------
// 					FirstName Tests (TC01–TC06)
// ------------------------------------------------------------

    // TC01
    // Test Objective: Verify firstName is accepted when 1 character
    // Input(s): FirstName = "B"
    // Expected Output(s): FirstName accepted
    @Test
    void validFirstNameMinBoundary_TC01() {
        Customer customer = new Customer();
        assertTrue(customer.verifyFirstName("B"));
    }

    // TC02
    // Test Objective: Verify firstName is accepted when more than 1 character
    // Input(s): FirstName = "Brian"
    // Expected Output(s): FirstName accepted
    @Test
    void validFirstName_TC02() {
        Customer customer = new Customer();
        assertTrue(customer.verifyFirstName("Brian"));
    }

    // TC03
    // Test Objective: Verify firstName is rejected when blank
    // Input(s): FirstName = ""
    // Expected Output(s): Error message: Invalid First Name
    @Test
    void invalidFirstNameBlank_TC03() {
        Customer customer = new Customer();
        assertFalse(customer.verifyFirstName(""));
    }

    // TC04
    // Test Objective: Verify firstName is rejected with digits
    // Input(s): FirstName = "M1k3"
    // Expected Output(s): Error message: Invalid First Name
    @Test
    void invalidFirstNameDigits_TC04() {
        Customer customer = new Customer();
        assertFalse(customer.verifyFirstName("M1k3"));
    }

    // TC05
    // Test Objective: Verify firstName is rejected with invalid symbols
    // Input(s): FirstName = "@!#$%^&*()_+=[]{};:"<>?/\\|~"
    // Expected Output(s): Error message: Invalid First Name
    @Test
    void invalidFirstNameInvalidSymbols_TC05() {
        Customer customer = new Customer();
        assertFalse(customer.verifyFirstName("@!#$%^&*()_+=[]{};:\"<>?/\\\\|~"));
    }

    // TC06
    // Test Objective: Verify firstName is accepted with allowed symbols
    // Input(s): FirstName = "'-"
    // Expected Output(s): FirstName accepted
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
    @Test
    void validSurnameMinBoundary_TC07() {
        Customer customer = new Customer();
        assertTrue(customer.verifySurname("K"));
    }

    // TC08
    // Test Objective: Verify surname is accepted when more than 1 character
    // Input(s): Surname = "Kelly"
    // Expected Output(s): Surname accepted
    @Test
    void validSurname_TC08() {
        Customer customer = new Customer();
        assertTrue(customer.verifySurname("Kelly"));
    }

    // TC09
    // Test Objective: Verify surname is rejected when blank
    // Input(s): Surname = ""
    // Expected Output(s): Error message: Invalid Surname
    @Test
    void invalidSurnameBlank_TC09() {
        Customer customer = new Customer();
        assertFalse(customer.verifySurname(""));
    }

    // TC10
    // Test Objective: Verify surname is rejected with digits
    // Input(s): Surname = "Sm1th"
    // Expected Output(s): Error message: Invalid Surname
    @Test
    void invalidSurnameDigits_TC10() {
        Customer customer = new Customer();
        assertFalse(customer.verifySurname("Sm1th"));
    }

    // TC11
    // Test Objective: Verify surname is rejected with invalid symbols
    // Input(s): Surname = "@!#$%^&*()_+=[]{};:"<>?/\\|~"
    // Expected Output(s): Error message: Invalid Surname
    @Test
    void invalidSurnameInvalidSymbols_TC11() {
        Customer customer = new Customer();
        assertFalse(customer.verifySurname("@!#$%^&*()_+=[]{};:\"<>?/\\\\|~"));
    }

    // TC12
    // Test Objective: Verify surname is accepted with allowed symbols
    // Input(s): Surname = "'-"
    // Expected Output(s): Surname accepted
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
    // Input(s): Address = "M"
    // Expected Output(s): Address accepted
    @Test
    void validAddressMinBoundary_TC13() {
        Customer customer = new Customer();
        assertTrue(customer.verifyAddress("B"));
    }

    // TC14
    // Test Objective: Verify address is accepted when more than 1 character
    // Input(s): Address = "Ballycue"
    // Expected Output(s): Address accepted
    @Test
    void validAddress_TC14() {
        Customer customer = new Customer();
        assertTrue(customer.verifyAddress("Ballycue"));
    }

    // TC15
    // Test Objective: Verify address is rejected when blank
    // Input(s): Address = ""
    // Expected Output(s): Error message: Invalid Address
    @Test
    void invalidAddressBlank_TC15() {
        Customer customer = new Customer();
        assertFalse(customer.verifyAddress(""));
    }

    // TC16
    // Test Objective: Verify address is rejected with invalid symbols
    // Input(s): Address = "Main@Street!"
    // Expected Output(s): Invalid Address
    @Test
    void invalidAddressSymbols_TC16() {
        Customer customer = new Customer();
        assertFalse(customer.verifyAddress("Main@Street!"));
    }

    // TC17
    // Test Objective: Verify address is accepted with allowed symbols
    // Input(s): Address = "O'Connell-Street"
    // Expected Output(s): Address accepted
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
    @Test
    void validPhoneNumber_TC18() {
        Customer customer = new Customer();
        assertTrue(customer.verifyPhoneNumber("0871234567"));
    }

    //TC19
    // Test Objective: Verify phone number is rejected when fewer than 10 digits
    // Input(s): Phone Number = "087123456"
    // Expected Output(s): Error message: Invalid Phone Number
    @Test
    void invalidPhoneNumberTooShort_TC19() {
        Customer customer = new Customer();
        assertFalse(customer.verifyPhoneNumber("087123456"));
    }

    //TC20
    // Test Objective: Verify phone number is rejected when more than 10 digits
    // Input(s): Phone Number = "08712345678"
    // Expected Output(s): Error message: Invalid Phone Number
    @Test
    void invalidPhoneNumberTooLong_TC20() {
        Customer customer = new Customer();
        assertFalse(customer.verifyPhoneNumber("08712345678"));
    }

    //TC21
    //Test Objective: Verify phoneNumber is rejected when containing letters
    //Input(s): PhoneNumber = "08F512345"
    //Expected Output(s): Error message: Invalid Phone Number
    @Test
    void invalidPhoneNumberLetters_TC21() {
        Customer customer = new Customer();
        assertFalse(customer.verifyPhoneNumber("08F512345"));
    }

    //TC22
    //Test Objective: Verify phoneNumber is rejected when containing symbols
    //Input(s): PhoneNumber = "085-123-4567"
    //Expected Output(s): Error message: Invalid Phone Number
    @Test
    void invalidPhoneNumberSymbols_TC22() {
        Customer customer = new Customer();
        assertFalse(customer.verifyPhoneNumber("085@234567"));
    }

// ------------------------------------------------------------
// 					Creation Tests (TC23–TC27)
// ------------------------------------------------------------

    // TC23
    // Test Objective: Verify customer account is created when all details are valid
    // Input(s): John, Smith, Main Street, 0871234567
    // Expected Output(s): Customer account created successfully
    @Test
    void createValidCustomerAccount_TC23() {
        Customer customer = new Customer();
        assertTrue(customer.createCustomer("John","Smith","Main Street","0871234567"));
    }

    // TC24
    // Test Objective: Verify customer account creation fails with invalid first name
    // Input(s): "", Smith, Main Street, 0871234567
    // Expected Output(s): Customer account not created
    @Test
    void createAccountInvalidFirstName_TC24() {
        Customer customer = new Customer();
        assertFalse(customer.createCustomer("","Smith","Main Street","0871234567"));
    }

    // TC25
    // Test Objective: Verify customer account creation fails with invalid surname
    // Input(s): John, "", Main Street, 0871234567
    // Expected Output(s): Customer account not created
    @Test
    void createAccountInvalidSurname_TC25() {
        Customer customer = new Customer();
        assertFalse(customer.createCustomer("John","","Main Street","0871234567"));
    }

    // TC26
    // Test Objective: Verify customer account creation fails with invalid address
    // Input(s): John, Smith, "", 0871234567
    // Expected Output(s): Customer account not created
    @Test
    void createAccountInvalidAddress_TC26() {
        Customer customer = new Customer();
        assertFalse(customer.createCustomer("John","Smith","","0871234567"));
    }

    // TC27
    // Test Objective: Verify customer account creation fails with invalid phone number
    // Input(s): John, Smith, Main Street, 087123456
    // Expected Output(s): Customer account not created
    @Test
    void createAccountInvalidPhoneNumber_TC27() {
        Customer customer = new Customer();
        assertFalse(customer.createCustomer("John","Smith","Main Street","087123456"));
    }
}