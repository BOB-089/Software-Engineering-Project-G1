import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class OrderTest {

    // TC01
    // Test Objective: Verify publication name is accepted when exactly 1 character long
    // Input(s): Publication Name = "A"
    // Expected Output(s): Publication name accepted
    @Test
    void validPublicationNameMinBoundary_TC01() {
        Order order = new Order();
        assertTrue(order.verifyPublicationName("A"));
    }

    // TC02
    // Test Objective: Verify publication name is accepted when 49 characters long
    // Input(s): Publication Name = 49 characters
    // Expected Output(s): Publication name accepted
    @Test
    void validPublicationNameMaxBoundary_TC02() {
        Order order = new Order();
        assertTrue(order.verifyPublicationName("A".repeat(49)));
    }

    // TC03
    // Test Objective: Verify publication name is rejected when blank
    // Input(s): Publication Name = ""
    // Expected Output(s): Invalid Publication Name
    @Test
    void invalidPublicationNameBlank_TC03() {
        Order order = new Order();
        assertFalse(order.verifyPublicationName(""));
    }

    // TC04
    // Test Objective: Verify publication name is rejected when 50 characters long
    // Input(s): Publication Name = 50 characters
    // Expected Output(s): Invalid Publication Name
    @Test
    void invalidPublicationNameTooLong_TC04() {
        Order order = new Order();
        assertFalse(order.verifyPublicationName("A".repeat(50)));
    }

    // TC05
    // Test Objective: Verify customer ID is accepted when exactly 5 characters long
    // Input(s): Customer ID = 12345
    // Expected Output(s): Customer ID accepted
    @Test
    void validCustomerID_TC05() {
        Order order = new Order();
        assertTrue(order.verifyCustomerId(12345));
    }

    // TC06
    // Test Objective: Verify customer ID is rejected when negative
    // Input(s): Customer ID = -1
    // Expected Output(s): Invalid Customer ID
    @Test
    void invalidCustomerIDBlank_TC06() {
        Order order = new Order();
        assertFalse(order.verifyCustomerId(-1));
    }

    // TC07
    // Test Objective: Verify customer ID is rejected when fewer than 5 characters
    // Input(s): Customer ID = 1234
    // Expected Output(s): Invalid Customer ID
    @Test
    void invalidCustomerIDTooShort_TC07() {
        Order order = new Order();
        assertFalse(order.verifyCustomerId(1234));
    }

    // TC08
    // Test Objective: Verify customer ID is rejected when more than 5 characters
    // Input(s): Customer ID = 123456
    // Expected Output(s): Invalid Customer ID
    @Test
    void invalidCustomerIDTooLong_TC08() {
        Order order = new Order();
        assertFalse(order.verifyCustomerId(123456));
    }

    // TC09
    // Test Objective: Verify day is accepted at the minimum boundary
    // Input(s): Day = 1
    // Expected Output(s): Day accepted
    @Test
    void validDayMinBoundary_TC09() {
        Order order = new Order();
        assertTrue(order.verifyDay(1));
    }

    // TC10
    // Test Objective: Verify day is accepted at the maximum boundary
    // Input(s): Day = 31
    // Expected Output(s): Day accepted
    @Test
    void validDayMaxBoundary_TC10() {
        Order order = new Order();
        assertTrue(order.verifyDay(31));
    }

    // TC11
    // Test Objective: Verify day is rejected when less than 1
    // Input(s): Day = 0
    // Expected Output(s): Invalid Day
    @Test
    void invalidDayTooLow_TC11() {
        Order order = new Order();
        assertFalse(order.verifyDay(0));
    }

    // TC12
    // Test Objective: Verify day is rejected when greater than 31
    // Input(s): Day = 32
    // Expected Output(s): Invalid Day
    @Test
    void invalidDayTooHigh_TC12() {
        Order order = new Order();
        assertFalse(order.verifyDay(32));
    }

    // TC13
    // Test Objective: Verify month is accepted at the minimum boundary
    // Input(s): Month = 1
    // Expected Output(s): Month accepted
    @Test
    void validMonthMinBoundary_TC13() {
        Order order = new Order();
        assertTrue(order.verifyMonth(1));
    }

    // TC14
    // Test Objective: Verify month is accepted at the maximum boundary
    // Input(s): Month = 12
    // Expected Output(s): Month accepted
    @Test
    void validMonthMaxBoundary_TC14() {
        Order order = new Order();
        assertTrue(order.verifyMonth(12));
    }

    // TC15
    // Test Objective: Verify month is rejected when less than 1
    // Input(s): Month = 0
    // Expected Output(s): Invalid Month
    @Test
    void invalidMonthTooLow_TC15() {
        Order order = new Order();
        assertFalse(order.verifyMonth(0));
    }

    // TC16
    // Test Objective: Verify month is rejected when greater than 12
    // Input(s): Month = 13
    // Expected Output(s): Invalid Month
    @Test
    void invalidMonthTooHigh_TC16() {
        Order order = new Order();
        assertFalse(order.verifyMonth(13));
    }

    // TC17
    // Test Objective: Verify year is accepted when exactly 4 digits
    // Input(s): Year = 2026
    // Expected Output(s): Year accepted
    @Test
    void validYear_TC17() {
        Order order = new Order();
        assertTrue(order.verifyYear(2026));
    }

    // TC18
    // Test Objective: Verify year is rejected when fewer than 4 digits
    // Input(s): Year = 999
    // Expected Output(s): Invalid Year
    @Test
    void invalidYearTooShort_TC18() {
        Order order = new Order();
        assertFalse(order.verifyYear(999));
    }

    // TC19
    // Test Objective: Verify year is rejected when more than 4 digits
    // Input(s): Year = 10000
    // Expected Output(s): Invalid Year
    @Test
    void invalidYearTooLong_TC19() {
        Order order = new Order();
        assertFalse(order.verifyYear(10000));
    }

    // TC20
    // Test Objective: Verify order is created when all details are valid
    // Input(s): "Daily News", 12345, 12, 10, 2026
    // Expected Output(s): Order created successfully
    @Test
    void createValidOrder_TC20() {
        Order order = new Order();

        assertTrue(order.createOrder(
            "Daily News",
            12345,
            12,
            10,
            2026
        ));
    }

    // TC21
    // Test Objective: Verify order creation fails with invalid publication name
    // Input(s): "", 12345, 12, 10, 2026
    // Expected Output(s): Order not created
    @Test
    void createOrderInvalidPublicationName_TC21() {
        Order order = new Order();

        assertFalse(order.createOrder(
            "",
            12345,
            12,
            10,
            2026
        ));
    }

    // TC22
    // Test Objective: Verify order creation fails with invalid customer ID
    // Input(s): "Daily News", 1234, 12, 10, 2026
    // Expected Output(s): Order not created
    @Test
    void createOrderInvalidCustomerID_TC22() {
        Order order = new Order();

        assertFalse(order.createOrder(
            "Daily News",
            1234,
            12,
            10,
            2026
        ));
    }

    // TC23
    // Test Objective: Verify order creation fails with invalid day
    // Input(s): "Daily News", 12345, 0, 10, 2026
    // Expected Output(s): Order not created
    @Test
    void createOrderInvalidDay_TC23() {
        Order order = new Order();

        assertFalse(order.createOrder(
            "Daily News",
            12345,
            0,
            10,
            2026
        ));
    }

    // TC24
    // Test Objective: Verify order creation fails with invalid month
    // Input(s): "Daily News", 12345, 12, 13, 2026
    // Expected Output(s): Order not created
    @Test
    void createOrderInvalidMonth_TC24() {
        Order order = new Order();

        assertFalse(order.createOrder(
            "Daily News",
            12345,
            12,
            13,
            2026
        ));
    }

    // TC25
    // Test Objective: Verify order creation fails with invalid year
    // Input(s): "Daily News", 12345, 12, 10, 10000
    // Expected Output(s): Order not created
    @Test
    void createOrderInvalidYear_TC25() {
        Order order = new Order();

        assertFalse(order.createOrder(
            "Daily News",
            12345,
            12,
            10,
            10000
        ));
    }
}