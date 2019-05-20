-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pileiko
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pileiko` ;

-- -----------------------------------------------------
-- Schema pileiko
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pileiko` DEFAULT CHARACTER SET utf8 ;
USE `pileiko` ;

-- -----------------------------------------------------
-- Table `pileiko`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pileiko`.`roles` ;

CREATE TABLE IF NOT EXISTS `pileiko`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pileiko`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pileiko`.`users` ;

CREATE TABLE IF NOT EXISTS `pileiko`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `pileiko`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pileiko`.`cars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pileiko`.`cars` ;

CREATE TABLE IF NOT EXISTS `pileiko`.`cars` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `engine` DOUBLE NULL,
  `price` DOUBLE NULL,
  `year` INT NULL,
  `description` VARCHAR(5000) NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_cars_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `pileiko`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `pileiko`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `pileiko`;
INSERT INTO `pileiko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `pileiko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');
INSERT INTO `pileiko`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `pileiko`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `pileiko`;
INSERT INTO `pileiko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'gfhjkm', 'admin@gmail.com', 1);
INSERT INTO `pileiko`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user', 'uspass', 'us@mail.ru', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `pileiko`.`cars`
-- -----------------------------------------------------
START TRANSACTION;
USE `pileiko`;
INSERT INTO `pileiko`.`cars` (`ID`, `brand`, `model`, `engine`, `price`, `year`, `description`, `users_ID`) VALUES (DEFAULT, 'Audi', 'A6', 1800, 5500, 2001, 'norm avto', 2);
INSERT INTO `pileiko`.`cars` (`ID`, `brand`, `model`, `engine`, `price`, `year`, `description`, `users_ID`) VALUES (DEFAULT, 'Fiat', 'a500', 800, 8050, 2014, 'small and pretty', 1);

COMMIT;

