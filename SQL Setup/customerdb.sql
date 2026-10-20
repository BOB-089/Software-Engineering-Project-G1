DROP DATABASE IF EXISTS customerdb;
CREATE DATABASE IF NOT EXISTS customerdb;
USE customerdb;

CREATE TABLE CustomerTable
(
	firstName VARCHAR(50) NOT NULL,
	surname VARCHAR(50) NOT NULL,
	address VARCHAR(150) NOT NULL,
	phoneNumber VARCHAR(20) NOT NULL,
	onHoliday BOOLEAN NOT NULL,
    publicationsAvailable BOOLEAN NOT NULL,
    areaCode INT NOT NULL,
    customerId INT AUTO_INCREMENT PRIMARY KEY
);

-- SELECT * FROM CustomerTable;
