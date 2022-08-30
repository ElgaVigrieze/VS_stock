-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: vs_stock
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `category` varchar(45) NOT NULL,
  `price` int DEFAULT NULL,
  `pic` varchar(45) DEFAULT NULL,
  `length` int DEFAULT NULL,
  `power` int DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `total_count` int DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'PW943','gaismu tehnika',50,NULL,NULL,5,_binary '',5,'JV'),(2,'HX-09-B','skatuve',100,NULL,NULL,NULL,_binary '',4,'JN'),(3,'PW945','gaismu tehnika',50,NULL,NULL,5,_binary '\0',8,'VMV'),(4,'PW639','gaismu tehnika',60,NULL,NULL,15,_binary '',12,'VS'),(8,'HX-23-C','ferma',5,NULL,6,NULL,_binary '',4,'ANNAS'),(9,'HX-08-B','ferma',500,NULL,5,NULL,_binary '\0',8,'KZ'),(10,'VW buss lielais','transports',200,NULL,NULL,NULL,_binary '\0',10,'VS'),(11,'VW buss mazais','transports',50,NULL,NULL,NULL,_binary '',5,'KZ'),(12,'BEM09-R','mikrofons',45,NULL,NULL,NULL,_binary '\0',1,'JV'),(13,'BEM02-T','mikrofons',50,NULL,NULL,NULL,_binary '',1,'JN'),(14,'GranMA T3','pults',25,NULL,NULL,NULL,_binary '',3,'VS'),(15,'SWAVE84-TX-PRO','pults',45,NULL,NULL,NULL,_binary '',6,'VS'),(21,'BTV-03','statīvs',25,'',NULL,NULL,_binary '',7,'VS'),(22,'HB-05-B','ferma',500,'',5,NULL,_binary '',10,'VMV'),(23,'XBEAM8-T','kustīgais prožektors',45,NULL,NULL,15,_binary '',12,'VS'),(25,'XBEAM8-B','kustīgais prožektors',25,'',NULL,10,_binary '',8,'CITA'),(26,'XBEAM8-T','fiksētais prožektors',50,'',NULL,10,_binary '\0',20,'VS'),(27,'JBL EON 612','tumba',20,'',NULL,NULL,_binary '',5,'VS'),(28,'JBL EON 615','tumba',25,'',NULL,NULL,_binary '',5,'VS'),(29,'JBL VRX 918s','tumba',30,'',NULL,NULL,_binary '',5,'ANNAS'),(30,'JBL PRX 518s','tumba',25,'',NULL,NULL,_binary '',5,'VS'),(31,'JBL SRX 712m','tumba',20,'',NULL,NULL,_binary '',5,'VS'),(32,'JBL EON G2','tumba',20,'',NULL,NULL,_binary '',5,'VS'),(33,'JBL AM7315 + ASB6128','tumba',500,'',NULL,NULL,_binary '',57,'ZURAS'),(35,'Bubbletron X4','cits',25,NULL,NULL,NULL,_binary '',1,'ARTISTIC'),(37,'Skaņošana','darbs',100,'',NULL,NULL,_binary '',1,'VS'),(44,'CAT5','kabelis',5,NULL,NULL,NULL,_binary '',100,'VS'),(45,'TIX-MI4','mikrofons',50,NULL,NULL,NULL,_binary '',10,'VS'),(47,'TREAM-09-TR0','pults',40,NULL,NULL,NULL,_binary '',1,'VS'),(49,'BTV-03','statīvs',10,NULL,NULL,NULL,_binary '',5,'VS'),(50,'BGR-037','kabelis',5,NULL,NULL,NULL,_binary '',50,'VS'),(51,'Gaismošana','darbs',100,NULL,NULL,NULL,_binary '',1,'VS'),(52,'Skatuve, lielā','skatuve',800,NULL,NULL,NULL,_binary '',1,'ANNAS'),(53,'Skatuve, mazā','skatuve',600,NULL,NULL,NULL,_binary '',1,'ZURAS'),(54,'Skatuve, lielā','darbs',400,NULL,NULL,NULL,_binary '',1,'VS'),(55,'Skatuve, mazā','darbs',300,NULL,NULL,NULL,_binary '',1,'VS'),(56,'GO PRO4','video',100,NULL,NULL,NULL,_binary '',1,'VS');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `location` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `date` date NOT NULL,
  `description` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Ziemassvētku balle','JN','2022-12-22','grupa, 2 solisti, ģitāra, bungas, DJ'),(2,'Sadraudzības koncerts','Lielais laukums, amfiteātris','2022-09-14','koris, max 2 solisti, kamerorķestris'),(3,'1. septembris','Tehnikums','2022-09-01','skatuve 8:00, gaismas nav, transports bungām');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_list`
--

DROP TABLE IF EXISTS `stock_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `item_id` int NOT NULL,
  `project_id` int NOT NULL,
  `item_quantity` int DEFAULT NULL,
  `item_done` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  KEY `FK_projects_idx` (`project_id`),
  KEY `FK_items_idx` (`item_id`),
  CONSTRAINT `FK_items` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`),
  CONSTRAINT `FK_projects` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_list`
--

LOCK TABLES `stock_list` WRITE;
/*!40000 ALTER TABLE `stock_list` DISABLE KEYS */;
INSERT INTO `stock_list` VALUES (35,27,2,2,_binary '\0'),(36,28,2,2,_binary '\0'),(37,31,2,2,_binary '\0'),(38,12,2,2,_binary '\0'),(39,13,2,3,_binary '\0'),(40,14,2,1,_binary '\0'),(41,44,2,5,_binary '\0'),(42,50,2,40,_binary '\0'),(43,27,3,2,_binary ''),(44,32,3,2,_binary '\0'),(45,12,3,3,_binary ''),(46,13,3,2,_binary ''),(47,15,3,1,_binary ''),(48,21,3,2,_binary ''),(49,44,3,10,_binary ''),(50,50,3,40,_binary ''),(51,11,3,1,_binary ''),(52,37,3,1,_binary '\0'),(53,51,3,1,_binary ''),(54,55,3,1,_binary '');
/*!40000 ALTER TABLE `stock_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-30 22:25:36
