-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: classicmodels
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registration` (
  `customerNumber` int NOT NULL,
  `customerName` varchar(45) NOT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `firstName` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `addressLine1` varchar(45) DEFAULT NULL,
  `addressLine2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `postalCode` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `pwd` varchar(256) DEFAULT NULL,
  `email` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registration`
--

LOCK TABLES `registration` WRITE;
/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `registration` VALUES (0,'test','nom','prenom','phone','address1','adress2','city','state','postalcode','country','login','pwd',''),(497,'Castorama','Leroy','Merlin','','244 route de Turin','','Nice','','06300','France','MERLIN','LEROY','Mleroy@castorama.fr'),(499,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(500,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(501,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(502,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(503,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(504,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(505,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(506,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(507,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(508,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(509,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL',''),(510,'Altaya','Nael','Madeleine','0293837108','168 avenue sainte marguerite','','Malestroit','','56800','France','MADELEINE','NAEL','');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-13 10:48:38
