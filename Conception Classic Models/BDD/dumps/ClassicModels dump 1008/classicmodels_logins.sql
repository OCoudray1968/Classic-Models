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
-- Table structure for table `logins`
--

DROP TABLE IF EXISTS `logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logins` (
  `customerNumber` int DEFAULT NULL,
  `employeeNumber` int DEFAULT NULL,
  `login` varchar(32) NOT NULL,
  `pwd` varchar(256) NOT NULL,
  `profil` int DEFAULT NULL COMMENT '1 = Admin, 2 = Employé, 4 = Client, 3 = Admin/Employé, 5 = Client/Admin, 6 = Client/Employé, 7 = ',
  `dateCrea` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `dateMAJ` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logins`
--

LOCK TABLES `logins` WRITE;
/*!40000 ALTER TABLE `logins` DISABLE KEYS */;
INSERT INTO `logins` VALUES (103,NULL,'CARINE','pbkdf2_sha256$10000$19680626$mQKys0V2Vcy6TiWfiQ1TG42UfJLBTpoItlZD1hIlckg=',4,'2020-08-13 10:39:16','2020-08-13 10:39:16'),(NULL,1702,'MARTIN','pbkdf2_sha256$10000$19680626$Xcf6nq4HiYm5IgCHwBWO3oqzjutxH1lYwyl8YphDiVk=',2,'2020-08-13 10:39:16','2020-08-13 10:39:16'),(NULL,1625,'YOSHIMI','pbkdf2_sha256$10000$19680626$jeww5HvBOmNTzOO0y4iQqsf/zB40+U62V+WM+tqZ3f4=',2,'2020-08-13 10:39:16','2020-08-13 10:39:16'),(NULL,1621,'MAMI','pbkdf2_sha256$10000$19680626$w8uP5taz2kk9Gjuu+Y1gvtwlhGd1htfyxtC3kh41f2Y=',2,'2020-08-13 10:39:16','2020-08-13 10:39:16'),(NULL,1619,'TOM','pbkdf2_sha256$10000$19680626$gZYnYaqLGaZQY1g84YAv83lyU4RGZOKO5mVZDxOlmrk=',2,'2020-08-13 10:39:16','2020-08-13 10:39:16'),(NULL,1612,'PETER','pbkdf2_sha256$10000$19680626$H6lRNKgMpBYjHkpqjuTcr/Hulx6JtDjPo2nBrNJYsmw=',2,'2020-08-13 10:39:16','2020-08-13 10:39:16'),(NULL,1611,'ANDY','pbkdf2_sha256$10000$19680626$GKx8i+0PY2zMd0hlKDh5DHCcFKAWnzPPdXv/kw7ChjQ=',2,'2020-08-13 10:39:17','2020-08-13 10:39:17'),(NULL,1504,'BARRY','pbkdf2_sha256$10000$19680626$kyzfuV5BiD1YZz3A0PvZyF+nXTDshFhthKwCUwbbkj0=',2,'2020-08-13 10:39:17','2020-08-13 10:39:17'),(NULL,1501,'LARRY','pbkdf2_sha256$10000$19680626$V/WEMN0ocG2AjZbiIWWpcRgLhT4kW/v4MU1svQ8Xw9M=',2,'2020-08-13 10:39:17','2020-08-13 10:39:17'),(NULL,1401,'PAMELA','pbkdf2_sha256$10000$19680626$zwxa+ew9AlvOwCQjCog41Luo0ziZL1DkmZVEDX4/uTE=',2,'2020-08-13 10:39:17','2020-08-13 10:39:17'),(NULL,1370,'GERARD','pbkdf2_sha256$10000$19680626$wjxQ9nqa9EDtYpPniNR/Dma2Tln5yhpes+AgXeKVN9Y=',2,'2020-08-13 10:39:17','2020-08-13 10:39:17'),(NULL,1337,'LOUIS','pbkdf2_sha256$10000$19680626$+0qIgeldlyxtqDDNtjPLlUdOtNNNfU7Y4ndRgmNZyBQ=',2,'2020-08-13 10:39:17','2020-08-13 10:39:17'),(NULL,1323,'GEORGE','pbkdf2_sha256$10000$19680626$JFJ7DQH8cAQsMALkb8nr/an7G2ukhFhXgIsyEZYPLgE=',2,'2020-08-13 10:39:17','2020-08-13 10:39:17'),(NULL,1286,'FOON YUE','pbkdf2_sha256$10000$19680626$4jk9Y3qpti3799QWayqqDMxfWWDNLtsf3Ltf1+o5H2U=',2,'2020-08-13 10:39:18','2020-08-13 10:39:18'),(NULL,1216,'STEVE','pbkdf2_sha256$10000$19680626$yGfrduXVdgzXdQqyljhkH2n2wmZZPYlFX77FSrrCTy8=',2,'2020-08-13 10:39:18','2020-08-13 10:39:18'),(NULL,1188,'JULIE','pbkdf2_sha256$10000$19680626$6c8pL4+CsMxy2Q1NW4xBA+c7tpIZxn/n2A4jKsujeqE=',2,'2020-08-13 10:39:18','2020-08-13 10:39:18'),(NULL,1166,'LESLIE','pbkdf2_sha256$10000$19680626$4rdrt0lrdaCHEp/rl/XdcsS3sWjB6/JiZ9vrGR3XVvA=',2,'2020-08-13 10:39:18','2020-08-13 10:39:18'),(NULL,1165,'LESLIE','pbkdf2_sha256$10000$19680626$3yYuaEAaTWI0SEI7L9i4gMbie8QYbXCY6mpQMWIros8=',2,'2020-08-13 10:39:18','2020-08-13 10:39:18'),(NULL,1143,'ANTHONY','pbkdf2_sha256$10000$19680626$G7chuC2YwNj//43gOWQiAG2O/FoWjQ6flYSdCbfBQXs=',2,'2020-08-13 10:39:18','2020-08-13 10:39:18'),(NULL,1102,'GERARD','pbkdf2_sha256$10000$19680626$+0qIgeldlyxtqDDNtjPLlUdOtNNNfU7Y4ndRgmNZyBQ=',2,'2020-08-13 10:39:18','2020-08-13 10:39:18'),(NULL,1088,'WILLIAM','pbkdf2_sha256$10000$19680626$yGfrduXVdgzXdQqyljhkH2n2wmZZPYlFX77FSrrCTy8=',2,'2020-08-13 10:39:18','2020-08-13 10:39:18'),(NULL,1076,'JEFF','pbkdf2_sha256$10000$19680626$6c8pL4+CsMxy2Q1NW4xBA+c7tpIZxn/n2A4jKsujeqE=',2,'2020-08-13 10:39:18','2020-08-13 10:39:18'),(NULL,1056,'MARY','pbkdf2_sha256$10000$19680626$yGfrduXVdgzXdQqyljhkH2n2wmZZPYlFX77FSrrCTy8=',2,'2020-08-13 10:39:19','2020-08-13 10:39:19'),(NULL,1002,'DIANE','pbkdf2_sha256$10000$19680626$y3pNnaE3UeHD6P3BR95yCQT+6GO8PVm4gThaBtw2SXQ=',2,'2020-08-13 10:39:19','2020-08-13 10:39:19'),(496,NULL,'TONY','pbkdf2_sha256$10000$19680626$msvh58N7vlOHmN9bDNGzLEVKmlfDMA91/Lfxj6wWA2w=',4,'2020-08-13 10:39:19','2020-08-13 10:39:19'),(495,NULL,'VALARIE','pbkdf2_sha256$10000$19680626$N7QMZ6/ma8iCEZqBb449T/FVtjqUNnZJhgPn+cHTmyg=',4,'2020-08-13 10:39:19','2020-08-13 10:39:19'),(489,NULL,'THOMAS','pbkdf2_sha256$10000$19680626$DALpBxptiEAjlkYuXuqtEcBDtFotE6jx5VvIYLYNPhU=',4,'2020-08-13 10:39:19','2020-08-13 10:39:19'),(NULL,1703,'JANETTE','pbkdf2_sha256$10000$19680626$DD7WecTAwUFp1lLzWWCsvR5hXZomAoGjCEXNgKchdng=',2,'2020-08-13 10:39:19','2020-08-13 10:39:19'),(NULL,1704,'MORGAN','pbkdf2_sha256$10000$19680626$K+a0PjdjrWNP+mDbQxjft0EyeV6VN5Kq3Pp5kADIr7c=',2,'2020-08-13 10:39:19','2020-08-13 10:39:19'),(NULL,1705,'JOLCYATE','pbkdf2_sha256$10000$19680626$E9b+nOnlndeVlsl47WKKyrOIVOK4JoquJCdBk1tl2yE=',2,'2020-08-13 10:39:19','2020-08-13 10:39:19'),(NULL,1706,'JEAN-SAUL','pbkdf2_sha256$10000$19680626$aLwqOrgO72HbY6Hk3oDRX92MA75vSRc7LnqlDnWwSZI=',2,'2020-08-13 10:39:20','2020-08-13 10:39:20'),(NULL,1707,'GIRENDINE','pbkdf2_sha256$10000$19680626$xSVYv5JdGH52iCr16SaS+qhHsajx+be5fOCy96AzonU=',2,'2020-08-13 10:39:20','2020-08-13 10:39:20'),(NULL,1708,'PATAFLIN','pbkdf2_sha256$10000$19680626$7GK6t6MD0Mfm4JQXrXLNCmW1lCS/mbOQgQbrh+LbJaw=',2,'2020-08-13 10:39:20','2020-08-13 10:39:20'),(NULL,1709,'CRUSTILA','pbkdf2_sha256$10000$19680626$0YrohaLOtRxNK8QH4AJVe4jlWuHWJayQAwNNkmhthZI=',2,'2020-08-13 10:39:20','2020-08-13 10:39:20'),(NULL,1710,'GRINGO','pbkdf2_sha256$10000$19680626$jilEFb9UkJIryZfN+SBFD9IWt8aH7hlnpcm1UMW8BS4=',2,'2020-08-13 10:39:20','2020-08-13 10:39:20'),(NULL,1711,'LOU','pbkdf2_sha256$10000$19680626$sfqnjzMzvl61CWdboTBMMPGb32M3yTRmO2oPqgW0zCY=',2,'2020-08-13 10:39:20','2020-08-13 10:39:20'),(NULL,1712,'GERABRICE','pbkdf2_sha256$10000$19680626$ZHwmmRrVLQxvVVMzjN4ChSgQLbegH+0jOF/eXxv5Es8=',2,'2020-08-13 10:39:20','2020-08-13 10:39:20'),(NULL,1713,'OLIVIER','pbkdf2_sha256$10000$19680626$57mq3VTe3xQ8yCvc+QdTeyDEYyIydSYuUutwpMpBaLc=',1,'2020-08-13 10:43:16','2020-08-13 10:43:16'),(NULL,1715,'CHRISTIAN','GATT',2,'2020-08-13 10:43:15','2020-08-13 10:43:15'),(NULL,1714,'NATHALIE','pbkdf2_sha256$10000$19680626$e1Yi1qycYgBJ1sw1RbQb6Fp/yy6Za5vE2XA7bRhVp0I=',1,'2020-08-13 10:43:16','2020-08-13 10:43:16'),(499,NULL,'NATHALIE','DELAGE',4,'2020-08-13 10:43:19','2020-08-13 10:43:19'),(500,NULL,'NATHALIE','DELAGE',4,'2020-08-13 10:43:19','2020-08-13 10:43:19');
/*!40000 ALTER TABLE `logins` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-13 10:48:34
