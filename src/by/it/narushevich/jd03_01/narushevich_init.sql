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
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE  `login_UNIQUE` (`login` ASC) ,
  UNIQUE  `email_UNIQUE` (`email` ASC) ,
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`role_id`)
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
  PRIMARY KEY (`id`),
  UNIQUE  `trademark_UNIQUE` (`trademark` ASC) )
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
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_teatags_users1`
    FOREIGN KEY (`user_id`)
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

-- -----------------------------------------------------
-- Data for table `narushevich`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');
INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'masha_05', 'qwerty', 'masha_05@tut.by', 1);
INSERT INTO `narushevich`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'fr_pole', 'asdfgh', 'pol_zhan@gmail.com', 2);
INSERT INTO `narushevich`.`users` (`id`, `login`, `password`, `email`, `role_id`) VALUES (DEFAULT, 'dimon_rus', 'wasder', 'dimas@mail.ru', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`material`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'cardboard');
INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'paper');
INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'plastic');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`trademark`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Ahmad tea');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Akbar');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Alattar');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Auchan');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Brooke Bond');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Chelton');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Dilmah');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Forest of Arden');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Golden Bowl');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Greenfield');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Jaf Tea');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Kakoo');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Lipton');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Lord Nelson');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Mabroc');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Maitre de The');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Malwa');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Messmer');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Mistral');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Natursan');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Pickwick');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Princess Java');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Tea');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`teatags`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'English Tea #1', 1, 28, 32, '2017.04.01', '02-08-3', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Cinnamon Haze', 1, 28, 32, '2018.05.05', '02-08-4', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 28, 32, '2002.01.07', '02-09-1', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 28, 32, '2005.09.14', '02-09-2', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Green Tea', 1, 28, 32, '2008.04.18', '02-09-4', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 28, 32, '2001.04.05', '02-10-1', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 28, 32, '1998.10.18', '02-10-2', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Lemon & Lime Twist', 1, 28, 32, '2018.01.06', '02-10-3', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 1, 'Classic black tea', 1, 28, 32, '2013.05.20', '02-10-4', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 28, 32, '2012.03.20', '02-11-2', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 28, 32, '2005.03.20', '02-11-1', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'Royal Ceylon', 1, 28, 32, '2003.05.10', '02-11-3', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'A moment to energise', 1, 26, 28, '2017.12.31', '02-13-2', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'A moment to balance', 1, 26, 28, '2017.12.31', '02-13-3', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'pure black ceylon', 2, 22, 22, '2007.02.15', '01-17-1', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'cherry morello', 2, 22, 22, '2007.10.12', '01-17-2', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'pear chocolate', 2, 22, 22, '2007.08.29', '01-17-3', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'flirty lady', 2, 20, 20, '2015.07.14', '01-17-4', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'blue fruit', 2, 22, 22, '2011.03.20', '01-17-5', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'Orange Jaipur', 2, 22, 22, '2006.12.16', '01-18-3', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 11, 'temptation', 1, 23, 28, '2001.10.02', '01-14-1', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 10, 'finelly selected speciality tea', 2, 20, 28, '2003.05.16', '01-15-1', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 22, 'black', 2, 20, 28, '2000.12.28', '01-06-1', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 20, 'La via del te firenze', 2, 20, 28, '2005.09.12', '01-04-5', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 19, 'Cristmas tea', 1, 23, 28, '2017.12.25', '01-27-1', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 6, '100% pure ceylon tea', 1, 28, 32, '2003.11.12', '02-04-2', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 4, 'Black tea', 1, 28, 32, '2018.04.06', '02-01-1', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 13, 'Russian Earl Grey', 1, 25, 30, '2010.05.20', '02-12-4', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 2, 'English breakfast', 1, 28, 32, '2007.08.31', '02-19-4', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 2, 'flavoured tea', 1, 28, 32, '2011.05.10', '02-19-3', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 14, 'Lemon & Ginger', 1, 28, 32, '2015.10.18', '02-21-2', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 8, '2006', 2, 20, 28, '2008.09.15', '01-02-4', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 15, '1001 night', 2, 20, 28, '2010.04.20', '01-02-2', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 16, 'Noir', 2, 23, 28, '2002.01.19', '01-04-2', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 18, 'Zitrone', 1, 28, 32, '2009.02.14', '02-26-1', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 12, 'Green tea bags', 2, 25, 28, '2010.11.05', '02-26-2', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 23, 'green', 2, 20, 20, '2010.11.06', '01-03-3', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 7, 'Ceylon gold', 2, 25, 30, '2010.04.09', '02-06-3', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 7, 'Lychee', 2, 20, 28, '2012.03.22', '01-09-4', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 7, 'Earl Grey', 2, 20, 28, '2012.01.19', '01-09-5', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 7, 'Strawberry tea', 2, 20, 28, '2012.06.15', '01-09-2', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 7, 'Natural green tea', 2, 20, 28, '2012.07.25', '01-09-1', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 21, 'finest taste', 2, 25, 30, '2006.07.14', '01-16-1', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 17, 'Exclusive smak natury', 2, 20, 28, '2016.12.15', '01-24-3', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 5, 'history', 1, 28, 32, '2008.04.14', '02-35-1', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 5, 'history', 1, 28, 32, '2008.04.14', '02-35-2', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 5, 'history', 1, 28, 32, '2008.04.14', '02-35-3', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 9, 'strawberry', 2, 25, 28, '2011.06.30', '02-39-3', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 9, 'green tea', 1, 26, 28, '2010.03.25', '02-38-4', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 9, 'black tea', 1, 28, 32, '2007.12.15', '02-38-3', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width`, `height`, `in_collection_since`, `num_in_catalog`, `user_id`) VALUES (DEFAULT, 9, 'indian', 1, 26, 28, '2010.05.04', '02-38-1', 3);

COMMIT;

