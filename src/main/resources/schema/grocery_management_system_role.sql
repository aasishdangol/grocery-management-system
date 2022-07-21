-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: grocery_management_system
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
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'create users','GET_USER'),(2,'For user update','LIST_USER'),(3,'create the user form','CREATE_USER'),(4,'update user list','UPDATE_USER'),(5,'delete user from user list','DELETE_USER'),(6,'category add','GET_CATEGORY'),(7,'list of category','LIST_CATEGORY'),(8,'category form create','CREATE_CATEGORY'),(9,'category update','UPDATE_CATEGORY'),(10,'delete category ','DELETE_CATEGORY'),(11,'for view the profile','PROFILE_VIEW'),(12,'for view the bill','BILL_VIEW'),(13,'for product add','GET_PRODUCT'),(14,'list of products','LIST_PRODUCT'),(15,'create product','CREATE_PRODUCT'),(16,'update product','UPDATE_PRODUCT'),(17,'delete product','DELETE_PRODUCT'),(18,'add role','GET_ROLE'),(19,'list of role','LIST_ROLE'),(20,'role create','CREATE_ROLE'),(21,'role list update','UPDATE_ROLE'),(22,'delete role','DELETE_ROLE'),(23,'list of sales','LIST_SALES'),(24,'add sales','GET_SALES'),(25,'create sales','CREATE_SALES'),(26,'update sales','UPDATE_SALES'),(27,'delete sales','DELETE_SALES'),(28,'usertype add','GET_USERTYPE'),(29,'usertype list','LIST_USERTYPE'),(30,'usertype form create','CREATE_USERTYPE'),(31,'update usertype','UPDATE_USERTYPE'),(32,'delete usertype','DELETE_USERTYPE');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-21 19:34:11
