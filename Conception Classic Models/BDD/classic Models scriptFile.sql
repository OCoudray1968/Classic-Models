-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema classicmodels
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema classicmodels
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `classicmodels` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `classicmodels` ;

-- -----------------------------------------------------
-- Table `classicmodels`.`offices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`offices` (
  `officeCode` VARCHAR(10) NOT NULL,
  `city` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(50) NOT NULL,
  `addressLine1` VARCHAR(50) NOT NULL,
  `addressLine2` VARCHAR(50) NULL DEFAULT NULL,
  `state` VARCHAR(50) NULL DEFAULT NULL,
  `country` VARCHAR(50) NOT NULL,
  `postalCode` VARCHAR(15) NOT NULL,
  `territory` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`officeCode`),
  UNIQUE INDEX `officeCode` (`officeCode` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classicmodels`.`registration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`registration` (
  `customerNumber` INT NOT NULL,
  `customerName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `addressLine1` VARCHAR(45) NULL DEFAULT NULL,
  `addressLine2` VARCHAR(45) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `state` VARCHAR(45) NULL DEFAULT NULL,
  `postalCode` VARCHAR(45) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `pwd` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customerNumber`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `classicmodels`.`logins`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`logins` (
  `customerNumber` INT NULL DEFAULT NULL,
  `employeeNumber` INT NULL DEFAULT NULL,
  `login` VARCHAR(32) NOT NULL,
  `pwd` VARCHAR(32) NOT NULL,
  `profil` INT NULL DEFAULT NULL COMMENT '1 = Admin, 2 = Employé, 4 = Client, ',
  `dateCrea` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateMAJ` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `registration_customerNumber` INT NOT NULL,
  PRIMARY KEY (`registration_customerNumber`),
  CONSTRAINT `fk_logins_registration1`
    FOREIGN KEY (`registration_customerNumber`)
    REFERENCES `classicmodels`.`registration` (`customerNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classicmodels`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`employees` (
  `employeeNumber` INT NOT NULL AUTO_INCREMENT,
  `lastName` VARCHAR(50) NOT NULL,
  `firstName` VARCHAR(50) NOT NULL,
  `extension` VARCHAR(10) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `officeCode` VARCHAR(10) NOT NULL,
  `reportsTo` INT NULL DEFAULT NULL,
  `jobTitle` VARCHAR(50) NOT NULL,
  `logins_registration_customerNumber` INT NOT NULL,
  PRIMARY KEY (`employeeNumber`, `logins_registration_customerNumber`),
  UNIQUE INDEX `employeeNumber` (`employeeNumber` ASC) VISIBLE,
  INDEX `reportsTo` (`reportsTo` ASC) VISIBLE,
  INDEX `officeCode` (`officeCode` ASC) VISIBLE,
  INDEX `fk_employees_logins1_idx` (`logins_registration_customerNumber` ASC) VISIBLE,
  CONSTRAINT `employees_employees`
    FOREIGN KEY (`reportsTo`)
    REFERENCES `classicmodels`.`employees` (`employeeNumber`),
  CONSTRAINT `employees_officeCode`
    FOREIGN KEY (`officeCode`)
    REFERENCES `classicmodels`.`offices` (`officeCode`),
  CONSTRAINT `fk_employees_logins1`
    FOREIGN KEY (`logins_registration_customerNumber`)
    REFERENCES `classicmodels`.`logins` (`registration_customerNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1714
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classicmodels`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`customers` (
  `customerNumber` INT NOT NULL,
  `customerName` VARCHAR(50) NOT NULL,
  `contactLastName` VARCHAR(50) NOT NULL,
  `contactFirstName` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(50) NOT NULL,
  `addressLine1` VARCHAR(50) NOT NULL,
  `addressLine2` VARCHAR(50) NULL DEFAULT NULL,
  `city` VARCHAR(50) NOT NULL,
  `state` VARCHAR(50) NULL DEFAULT NULL,
  `postalCode` VARCHAR(15) NULL DEFAULT NULL,
  `country` VARCHAR(50) NOT NULL,
  `salesRepEmployeeNumber` INT NULL DEFAULT NULL,
  `creditLimit` DECIMAL(10,2) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  `logins_registration_customerNumber` INT NOT NULL,
  PRIMARY KEY (`customerNumber`),
  INDEX `salesRepEmployeeNumber` (`salesRepEmployeeNumber` ASC) VISIBLE,
  INDEX `fk_customers_logins1_idx` (`logins_registration_customerNumber` ASC) VISIBLE,
  CONSTRAINT `customers_salesRepEmployeeNumber`
    FOREIGN KEY (`salesRepEmployeeNumber`)
    REFERENCES `classicmodels`.`employees` (`employeeNumber`),
  CONSTRAINT `fk_customers_logins1`
    FOREIGN KEY (`logins_registration_customerNumber`)
    REFERENCES `classicmodels`.`logins` (`registration_customerNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classicmodels`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`orders` (
  `orderNumber` INT NOT NULL,
  `orderDate` DATE NOT NULL,
  `requiredDate` DATE NOT NULL,
  `shippedDate` DATE NULL DEFAULT NULL,
  `status` VARCHAR(15) NOT NULL,
  `comments` TEXT NULL DEFAULT NULL,
  `customerNumber` INT NOT NULL,
  PRIMARY KEY (`orderNumber`),
  INDEX `customerNumber` (`customerNumber` ASC) VISIBLE,
  CONSTRAINT `orders_customerNumber`
    FOREIGN KEY (`customerNumber`)
    REFERENCES `classicmodels`.`customers` (`customerNumber`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classicmodels`.`productlines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`productlines` (
  `productLine` VARCHAR(50) NOT NULL,
  `textDescription` VARCHAR(4000) NULL DEFAULT NULL,
  `htmlDescription` MEDIUMTEXT NULL DEFAULT NULL,
  `image` VARCHAR(64) NULL DEFAULT NULL,
  PRIMARY KEY (`productLine`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classicmodels`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`products` (
  `productCode` VARCHAR(15) NOT NULL,
  `productName` VARCHAR(70) NOT NULL,
  `productLine` VARCHAR(50) NOT NULL,
  `productScale` VARCHAR(10) NOT NULL,
  `productVendor` VARCHAR(50) NOT NULL,
  `productDescription` TEXT NOT NULL,
  `quantityInStock` SMALLINT NOT NULL,
  `buyPrice` DECIMAL(10,2) NOT NULL,
  `MSRP` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`productCode`),
  INDEX `productLine` (`productLine` ASC) VISIBLE,
  CONSTRAINT `products_productLine`
    FOREIGN KEY (`productLine`)
    REFERENCES `classicmodels`.`productlines` (`productLine`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classicmodels`.`orderdetails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`orderdetails` (
  `orderNumber` INT NOT NULL,
  `productCode` VARCHAR(15) NOT NULL,
  `quantityOrdered` INT NOT NULL,
  `priceEach` DECIMAL(10,2) NOT NULL,
  `orderLineNumber` SMALLINT NOT NULL,
  PRIMARY KEY (`orderNumber`, `productCode`),
  INDEX `productCode` (`productCode` ASC) VISIBLE,
  CONSTRAINT `orderdetails_orderNumber`
    FOREIGN KEY (`orderNumber`)
    REFERENCES `classicmodels`.`orders` (`orderNumber`),
  CONSTRAINT `orderdetails_productCode`
    FOREIGN KEY (`productCode`)
    REFERENCES `classicmodels`.`products` (`productCode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classicmodels`.`payments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`payments` (
  `customerNumber` INT NOT NULL,
  `checkNumber` VARCHAR(50) NOT NULL,
  `paymentDate` DATE NOT NULL,
  `amount` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`customerNumber`, `checkNumber`),
  CONSTRAINT `payments_customerNumber`
    FOREIGN KEY (`customerNumber`)
    REFERENCES `classicmodels`.`customers` (`customerNumber`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classicmodels`.`photocategories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`photocategories` (
  `ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identifiant de la catégorie',
  `nom` VARCHAR(32) NOT NULL COMMENT 'Nom de la catégorie',
  `chemin` VARCHAR(128) NOT NULL COMMENT 'Chemin absolu du répértoire contenant les photos de la catégorie',
  `passwd` VARCHAR(32) NULL DEFAULT NULL COMMENT 'Code d\'accès aux photos de la catégorie',
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `nom` (`nom` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `classicmodels`.`photos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `classicmodels`.`photos` (
  `ID` INT NOT NULL AUTO_INCREMENT COMMENT 'Identifiant de l\'enregistrement',
  `nom` VARCHAR(32) NULL DEFAULT NULL,
  `ID_categorie` INT NOT NULL COMMENT 'Catégorie à laquelle la photo appartient',
  `label` VARCHAR(32) NULL DEFAULT NULL COMMENT 'Associe un texte à la photo',
  `tags` VARCHAR(256) NULL DEFAULT NULL COMMENT 'Mots-cléfs associés à la photo avec comme séparateur le caractère espace. Par exemple : Portrait Voiture Harley Davidson Fleur',
  PRIMARY KEY (`ID`),
  INDEX `photos_photocategories` (`ID_categorie` ASC) VISIBLE,
  CONSTRAINT `photos_photocategories`
    FOREIGN KEY (`ID_categorie`)
    REFERENCES `classicmodels`.`photocategories` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 24
DEFAULT CHARACTER SET = utf8;

USE `classicmodels`;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
