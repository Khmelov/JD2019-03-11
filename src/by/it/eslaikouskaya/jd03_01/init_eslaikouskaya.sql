-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eslaikouskaya
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `eslaikouskaya` ;

-- -----------------------------------------------------
-- Schema eslaikouskaya
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eslaikouskaya` DEFAULT CHARACTER SET utf8 ;
USE `eslaikouskaya` ;

-- -----------------------------------------------------
-- Table `eslaikouskaya`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`roles` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eslaikouskaya`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`users` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `eslaikouskaya`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eslaikouskaya`.`categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`categories` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`categories` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Category` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eslaikouskaya`.`grades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`grades` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`grades` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Grade` VARCHAR(45) NULL,
  `categories_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_classes_categories1`
    FOREIGN KEY (`categories_ID`)
    REFERENCES `eslaikouskaya`.`categories` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eslaikouskaya`.`materials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`materials` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`materials` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `Price` DECIMAL(45) NULL,
  `grades_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_materials_grades1`
    FOREIGN KEY (`grades_ID`)
    REFERENCES `eslaikouskaya`.`grades` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eslaikouskaya`.`purchases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`purchases` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`purchases` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `users_ID` INT NOT NULL,
  `materials_ID` INT NOT NULL,
  `Number` INT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_purchases_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `eslaikouskaya`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_purchases_materials1`
    FOREIGN KEY (`materials_ID`)
    REFERENCES `eslaikouskaya`.`materials` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Manager');
INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');
INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');

COMMIT;


-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Katya1234', 'qwerty', 'K@gmail.com', 1);
INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Pavel13', 'asdfgh', 'Pav@tut.by', 2);
INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'AbrahamZERO', '123qwe', 'Azero@mail.ru', 3);
INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Lily_33', 'qazwsx', 'LilPop@mail.ru', 4);
INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Sharki07', '1029384756', 'Shark@gmail.com', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`categories`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Сантехника');
INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Металлопрокат');
INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Стройматериалы');
INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Кровля');

COMMIT;


-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`grades`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Трубы канализационные ПВХ и НПВХ', 1);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Уплотнительные матриалы и прочее', 1);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Сантехническое оборудование', 1);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Трубы асбестоцементные', 1);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Трубы полиэтиленовые', 1);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Радиаторы и системы отопления', 1);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Элементы креплений', 1);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Запорная арматура', 1);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Трубные стальные заготовки', 1);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Системы трубопровода из полипропилена', 1);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Уголок', 2);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Арматура рифленая', 2);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Трубы круглые', 2);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Полоса', 2);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Трубы профильные', 2);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Листы', 2);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Проволока вязальная', 2);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Швеллер', 2);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Круг гладкий', 2);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Квадрат', 2);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Блоки газосиликатные', 3);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Кирпич', 3);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Поликарбонат', 3);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Гипсокартон и комплектующие', 3);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Цемент и строительные смеси', 3);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Плиты стружечные', 3);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Сетка', 3);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Кольца колодцев', 3);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Плитка тротуарная бордюры', 3);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Теплоизоляция', 3);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Направляемая кровля', 4);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Шифер', 4);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Гибкая черепица', 4);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Ондулин и комплектующие', 4);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Металлопрофиль', 4);
INSERT INTO `eslaikouskaya`.`grades` (`ID`, `Grade`, `categories_ID`) VALUES (DEFAULT, 'Пленка подкровельная', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`materials`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба серая армированная', 20, 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Угольник', 10, 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Муфта', 15, 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Американка', 15, 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Тройник', 17, 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Опора', 18, 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кран', 13, 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Фильтр из полипропилена', 10, 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Сгон', 30, 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Резьба', 31, 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Контргайка', 35, 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Муфта', 18, 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Бочонок', 10, 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Угольник', 12, 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Тройник', 27, 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Отвод', 25, 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Черная трубная заготовка', 23, 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Оцинкованная трубная заготовка', 23, 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кран шаровой', 24, 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кран муфтовый', 25, 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кран фланцевый', 18, 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Задвижка', 8, 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Вентиль', 34, 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Фильтр', 19, 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Обратный клапан', 30, 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Фланец к обратному клапану', 20, 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Болт', 21, 4);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Гайка', 9, 4);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Шайба', 20, 4);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Шпилька', 11, 4);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Хомут ремонтный', 12, 4);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Хомут для крепления труб', 8, 4);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Радиатор алюминевый', 31, 5);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Радиатор биметаллический', 36, 5);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Радиатор чугунный', 30, 5);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кронштейн', 29, 5);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Клапан для регулировки', 28, 5);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Монтажный комплект', 20, 5);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба ПЭ 25-63 мм', 23, 6);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Муфта', 16, 6);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Тройник', 14, 6);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Угольник', 11, 6);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Заглушка', 9, 6);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Фитинг к полиэтиленовым трубам', 10, 6);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба безнапорная 110х3.95м', 35, 7);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба безнапорная 160х3.95м ', 24, 7);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба напорная 200х5м', 37, 7);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Унитаз', 34, 8);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Умывальник', 31, 8);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Душевой поддон', 34, 8);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Биде', 11, 8);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Писсуар', 11, 8);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Смеситель', 10, 8);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Гибкая подводка', 26, 8);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Паронитовая прокладка', 34, 9);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Техпластина', 31, 9);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Каболка', 23, 9);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Лен сантехнический ', 26, 9);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Шнур асбестовый', 29, 9);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Асбокартон', 10, 9);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Электроды', 14, 9);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба для наружной канализации', 33, 10);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба для внутренней канализации', 23, 10);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Фасонная часть', 29, 10);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Трап', 18, 10);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Люк', 35, 10);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Уголок 25-100 мм', 32, 11);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Арматура рифленая\n6 — 20 мм', 17, 12);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба ВГП 15-50 мм', 12, 13);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба электросварная 57-325 мм', 10, 13);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба оцинкованная 15-108 мм', 6, 13);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Полоса 25х4 и 40х4', 9, 14);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Труба профильная 15х15-100х100', 9, 15);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Лист г/к 2 — 10 мм', 9, 16);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Лист х/к 0.8 — 1.5 мм', 12, 16);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Лист оцинкованный ', 14, 16);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Лист с полимерным покрытием', 14, 16);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Лист рифленый', 15, 16);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Лист ПВЛ', 19, 16);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Проволока вязальная 1.2 — 5 мм', 31, 17);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Швеллер 8 — 20 мм', 34, 18);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Круг 6 -12 мм', 24, 19);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Квадрат 10х10 мм', 27, 20);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Блок 100х290х600', 26, 21);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Блок 200х290х600', 21, 21);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Блок 250х300х600', 31, 21);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Блок 250х400х600', 10, 21);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Перемычка', 19, 21);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Блок газосиликатный', 16, 21);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кирпич силикатный ', 26, 22);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кирпич керамический', 23, 22);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кирпич цветной ', 27, 22);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кирпич гиперпрессованный', 26, 22);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кирпич лицевой ', 19, 22);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кирпич огнеупорный', 21, 22);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Поликарбонат 4-10мм ', 30, 23);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Поликарбонат 2100х6000', 29, 23);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Поликарбонат прозрачный', 28, 23);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Поликарбонат цветной', 29, 23);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Профиль торцевой', 20, 23);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Профиль пристенный', 13, 23);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Профиль соединительный', 8, 23);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Гипсокартон стеновой ', 12, 24);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Гипсокартон потолочный', 22, 24);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Гипсокартон влагостойкий', 10, 24);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Профиль', 12, 24);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Подвес', 17, 24);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Краб', 14, 24);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Цемент', 30, 25);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Штукатурка', 27, 25);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Шпатлевка', 26, 25);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Клей', 36, 25);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Расствор', 16, 25);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Стяжка', 14, 25);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'ДСП', 12, 26);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'ДВП', 19, 26);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Плита ОСБ 9-18 мм', 17, 26);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Фанера', 20, 26);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'ЦСП', 28, 26);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Сетка 3мм 0.5х2 (50х50)', 29, 27);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Сетка 3мм 1х2(100х100)', 27, 27);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Сетка 3мм 1х2(150х150)', 32, 27);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Сетка 4мм 0.5х2 (50х50)', 22, 27);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Сетка 4мм 1х2(100х100)', 33, 27);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Сетка 5мм 1х2(100х100)', 30, 27);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Сетка рабица', 10, 27);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Сетка ССШ', 20, 27);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кольцо ж/б 1.0 -2.0 м', 17, 28);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Плита перекрытия', 27, 28);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Днище колодца ', 14, 28);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Доборные кольца 0.7м', 29, 28);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Люки чугунные', 35, 28);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Люки полимерные', 33, 28);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Плитка серая', 32, 29);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Плитка красная', 17, 29);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'кирпичик 60,80мм', 9, 29);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, '\"Старый город\"', 10, 29);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, '\"Черепашка\"', 15, 29);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, '\"Калифорния\"', 21, 29);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Квадрат ажурный ', 12, 29);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Борт тратуарный', 20, 29);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Борт дорожный', 31, 29);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Утеплитель фасадный ', 34, 30);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Рулон', 25, 30);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Плита', 35, 30);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, '«Кнауф»', 18, 30);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Минвата', 19, 30);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Пенопласт', 26, 30);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Керамзит', 29, 30);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'ТЕХНОНИКОЛЬ', 20, 31);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'БИКРОСТ', 33, 31);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'ЛИНОКРОМ', 32, 31);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'ЭЛАКРОМ', 26, 31);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Шифер', 18, 32);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Шиферный гвоздь', 11, 32);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, '\"Шинглас\"', 31, 33);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Подкладочный ковер', 18, 33);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Гвоздь', 19, 33);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Мастика', 22, 33);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Ондулин красный', 22, 34);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Ондулин коричневый', 26, 34);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Ондулин зеленый', 24, 34);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Конек', 18, 34);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Ендова', 17, 34);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Ветровая планка', 13, 34);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Ондулин черепица', 22, 34);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Гвоздь', 20, 34);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Пленка', 29, 34);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Металлочерепица', 22, 35);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Профнастил', 30, 35);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Доборный элементы', 18, 35);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Кровля', 14, 35);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Саморез', 32, 35);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Пленка', 26, 35);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Гидроизоляция ', 26, 36);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Пароизоляция', 27, 36);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `grades_ID`) VALUES (DEFAULT, 'Армированная пленка', 15, 36);

COMMIT;


-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`purchases`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 3, 15, 3);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 3, 1, 3);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 4, 12, 10);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 4, 13, 1);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 4, 14, 2);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 5, 8, 1);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 5, 3, 1);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 5, 4, 15);

COMMIT;

