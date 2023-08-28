-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: travel
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `name` varchar(200) DEFAULT NULL,
  `Street` varchar(100) DEFAULT NULL,
  `Area` varchar(200) DEFAULT NULL,
  `MobileNo` int NOT NULL,
  `PackageId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`MobileNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('Adams','st 12	','Alma',85273992,'S707'),('Hayes','St 7','Houston',88003903,'S909'),('peter','st 12','Alma',88260999,'S302'),('Smith','st 123','Putnam',88263082,'S908'),('Jackson','St 2','Boston',88263973,'S303'),('Mana','St 7','Houston',88265999,'S701'),('jill','St 2','Boston',89362587,'S202'),('Kane','st 3','Main',95600023,'S401'),('Mark','st 72','North',95600999,'S402'),('Ram','st 12','Alma',95602989,'S901'),('Jones','st 3','Main',95603002,'S706'),('Williams','st 72','North',95603904,'S505'),('Donald','st 123','Putnam',96500039,'S102'),('Obama','st 175','Park Ave',96500999,'S201'),('Hayes','st 3','Main',96502019,'S203'),('Johnson','st 175','Park Ave',96502945,'S103'),('Linklon','st 72','North',97170045,'S301'),('Adam','St 2','Boston',97170999,'S501'),('Lindsay','St 7','Houston',97172993,'S405'),('Mac','st 123','Putnam',98100999,'S601'),('jack','St 7','Houston',99939992,'s405'),('mannu','st 123','Putnam',852749958,'S209'),('Vasin','st 72','North',956027800,'S202');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package` (
  `PackageId` varchar(20) NOT NULL,
  `NoOfPeople` int DEFAULT NULL,
  `Days` int DEFAULT NULL,
  `Destination` varchar(200) DEFAULT NULL,
  `Cost` int DEFAULT NULL,
  PRIMARY KEY (`PackageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
INSERT INTO `package` VALUES ('S101',2,4,'New York',73000),('S109',2,7,'Goa',56000),('S111',2,4,'America',44000),('S122',6,7,'Africa',23000),('S133',8,4,'Delhi',60000),('S144',7,6,'California',88000),('S145',4,3,'china',76000),('S156',5,2,'Australia',33000),('S202',4,5,'Europe',75000),('S203',8,3,'Europe',42000),('S204',7,2,'Mumbai',38000),('S303',5,6,'Palo Alto',40000),('S326',8,4,'kerala',53000),('S378',6,4,'Rajasthan',27000),('S404',2,4,'Harrison',20000),('S505',8,9,'Stamford',80000),('S551',2,8,'Karnataka',67000),('S606',5,6,'Harrison',45000),('S707',3,4,'Pittsfield',26000),('S767',7,3,'seoul',84000),('S808',4,6,'Rye',55000),('S888',4,2,'Agra',25000),('S899',3,8,'Dubai',93000),('S909',6,9,'korean',90000),('S986',5,2,'tamilnadu',86000);
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05  5:17:26
