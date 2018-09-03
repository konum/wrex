
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;



DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `plate` varchar(10) NOT NULL ,
  `gas` varchar(45) NULL,
  `vehicle_type` varchar(65) DEFAULT NULL,
  `details` varchar(45) NULL,
  `year` varchar(45) NULL,
  `brand` varchar(45) NULL,
  `model` varchar(10) NULL,
  `chofer` varchar(45) NULL,
  `soap_date` date NULL,
  `tyres` varchar(45) NULL,
  `last_maintenance` date NULL,
  `next_inspection` date NULL,
  PRIMARY KEY (`plate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `vehicle` WRITE;
INSERT INTO `vehicle` VALUES ('FYJA-44','gasolina','Camioneta','coche alcalde','2017','Honda','Hilux','22222222-2','2019-02-26','214-55 R18','2018-06-26','2018-10-26');
INSERT INTO `vehicle` VALUES ('JYSH-22','diesel','Bus','Bus escolar','2017','Honda','Hilux','22222222-2','2019-02-26','214-55 R18','2018-06-26','2018-10-26');
INSERT INTO `vehicle` VALUES ('UKWH-33','gasolina','Tractor','JAC','2017','Honda','Hilux','11111111-1','2019-02-26','214-55 R18','2018-06-26','2018-10-26');
INSERT INTO `vehicle` VALUES ('LAKN-55','gasolina','Ambulancia','Ram payne','2017','Honda','Hilux','11111111-1','2019-02-26','214-55 R18','2018-06-26','2018-10-26');
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (30),(30),(30),(30),(30),(30),(30),(30),(30),(30),(30),(30);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `rut` varchar(10) NOT NULL ,
  `name` varchar(45) NULL,
	PRIMARY KEY (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `driver` values ('22222222-2', 'Walter');
INSERT INTO `driver` values ('11111111-1', 'Danilo');

DROP TABLE IF EXISTS `entry`;
CREATE TABLE `entry` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(1000) NOT NULL ,
  `plate` varchar(10) NOT NULL,
  `date` DATE NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `entry` 
ADD INDEX `plateFK_idx` (`plate` ASC);

ALTER TABLE `entry` 
ADD CONSTRAINT `plateFK`
  FOREIGN KEY (`plate`)
  REFERENCES `vehicle` (`plate`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
INSERT INTO `entry` values (1,'Reparacion 1','FYJA-44','2019-02-26');
INSERT INTO `entry` values (2,'Reparacion 2','FYJA-44','2019-02-27');
INSERT INTO `entry` values (3,'Reparacion 3','FYJA-44','2019-03-12');

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL ,
  `name` varchar(100) NOT NULL,
	PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `users` values ('konum','hola','Guillermo Gefaell');
INSERT INTO `users` values ('cbueno','8819','Cecilia Bueno');