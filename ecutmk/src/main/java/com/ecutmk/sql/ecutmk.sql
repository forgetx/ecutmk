DROP DATABASE IF EXISTS `ecutmk`;
CREATE DATABASE `ecutmk` CHARACTER SET utf8;

 
USE `ecutmk`;
DROP TABLE  IF EXISTS `user` ;
CREATE TABLE `ecutmk`.`user` (
  `user_id` INT (4) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR (50) NOT NULL UNIQUE,
  `user_password` VARCHAR (128) NOT NULL,
  `user_phone` VARCHAR (11) NOT NULL,
  `user_count_msg` INT(4) DEFAULT 0 NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE = INNODB CHARSET = utf8;

DROP TABLE  IF EXISTS `good` ;
CREATE TABLE `ecutmk`.`good` (
  `good_id` INT (4) NOT NULL AUTO_INCREMENT,
  `good_owner` INT (4) NOT NULL,
  `good_kind` VARCHAR(10) NOT NULL,
  `good_summary` VARCHAR (30) NOT NULL,
  `good_explain` TEXT NOT NULL,
  `good_price` DOUBLE (6, 1) NOT NULL,
  `good_picture1` MEDIUMBLOB NOT NULL,
  `good_picture2` MEDIUMBLOB,
  `good_picture3` MEDIUMBLOB,
  `good_picture4` MEDIUMBLOB,
  
  PRIMARY KEY (`good_id`)
) ENGINE = INNODB CHARSET = utf8;

DROP TABLE  IF EXISTS `message` ;
CREATE TABLE `ecutmk`.`message` (
  `m_id` INT (4) NOT NULL AUTO_INCREMENT,
  `m_user` VARCHAR (50) NOT NULL,
  `m_good` INT (4) NOT NULL,
  `m_date` TIMESTAMP NOT NULL,
  `m_content` TEXT NOT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE = INNODB CHARSET = utf8;


DROP TABLE  IF EXISTS `reply` ;
CREATE TABLE `ecutmk`.`reply` (
  `r_id` INT (4) NOT NULL AUTO_INCREMENT,
  `r_user` VARCHAR (50) NOT NULL,
  `r_m_id` INT (4) NOT NULL,
  `r_m_user` VARCHAR (50) NOT NULL,
  `r_good` INT (4) NOT NULL,
  `r_date` TIMESTAMP NOT NULL,
  `r_content` TEXT NOT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE = INNODB CHARSET = utf8;


