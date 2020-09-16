-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema order_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `order_db` ;

-- -----------------------------------------------------
-- Schema order_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `order_db` DEFAULT CHARACTER SET utf8 ;
USE `order_db` ;

-- -----------------------------------------------------
-- Table `order_db`.`sys_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order_db`.`sys_user` ;

CREATE TABLE IF NOT EXISTS `order_db`.`sys_user` (
  `ID` BIGINT(20) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_pass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `order_db`.`biz_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order_db`.`biz_order` ;

CREATE TABLE IF NOT EXISTS `order_db`.`biz_order` (
  `ID` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  `create_date` DATETIME NULL,
  `status` INT NOT NULL COMMENT '0: invalid, 1:valid',
  PRIMARY KEY (`ID`),
  INDEX `FK_O_UID_idx` (`user_id` ASC),
  CONSTRAINT `FK_O_UID`
    FOREIGN KEY (`user_id`)
    REFERENCES `order_db`.`sys_user` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `order_db`.`biz_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order_db`.`biz_product` ;

CREATE TABLE IF NOT EXISTS `order_db`.`biz_product` (
  `ID` BIGINT(20) NOT NULL,
  `prod_name` VARCHAR(45) NOT NULL,
  `prod_desc` VARCHAR(1000) NULL,
  `prod_count` INT NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `order_db`.`biz_order_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `order_db`.`biz_order_product` ;

CREATE TABLE IF NOT EXISTS `order_db`.`biz_order_product` (
  `ID` BIGINT(20) NOT NULL,
  `order_id` BIGINT(20) NOT NULL,
  `prod_id` BIGINT(20) NOT NULL,
  `prod_count` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_OID_idx` (`order_id` ASC),
  INDEX `FK_PID_idx` (`prod_id` ASC),
  CONSTRAINT `FK_OID`
    FOREIGN KEY (`order_id`)
    REFERENCES `order_db`.`biz_order` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PID`
    FOREIGN KEY (`prod_id`)
    REFERENCES `order_db`.`biz_product` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
