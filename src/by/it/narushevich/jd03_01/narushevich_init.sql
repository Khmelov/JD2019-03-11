-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema narushevich
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `narushevich` ;

-- -----------------------------------------------------
-- Schema narushevich
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `narushevich` DEFAULT CHARACTER SET utf8 ;
USE `narushevich` ;

-- -----------------------------------------------------
-- Table `narushevich`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `narushevich`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `narushevich`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(15) NULL,
  `password` VARCHAR(15) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE `login_UNIQUE` (`login` ASC),
  UNIQUE `email_UNIQUE` (`email` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `narushevich`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `narushevich`.`material` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `material` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`trademark`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `narushevich`.`trademark` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `trademark` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`teatags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `narushevich`.`teatags` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `trademark_id` INT NOT NULL,
  `subtitle` VARCHAR(45) NULL,
  `material_id` INT NOT NULL,
  `width` DECIMAL NULL,
  `height` DECIMAL NULL,
  `in_collection_since` DATE NOT NULL,
  `num_in_catalog` VARCHAR(7) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_teatags_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `narushevich`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_teatags_material1`
    FOREIGN KEY (`material_id`)
    REFERENCES `narushevich`.`material` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_teatags_trademark1`
    FOREIGN KEY (`trademark_id`)
    REFERENCES `narushevich`.`trademark` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
