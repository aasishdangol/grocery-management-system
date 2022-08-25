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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_code` varchar(255) DEFAULT NULL,
  `usertype_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4nc7vu5h8yfxgq1sxpf8n96ic` (`usertype_id`),
  CONSTRAINT `FK4nc7vu5h8yfxgq1sxpf8n96ic` FOREIGN KEY (`usertype_id`) REFERENCES `user_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (47,'khokana, lalitpur','testuser1@mailinatorl.com','test1','male','Maharjan','$12$xerSbxa9b8Nzk1X3SJWw2.wqBStI03JqOR3cKK12JciL/8g8j7L3u','Active','USER126767',46),(48,'khokana, lalitpur','test@gmail.com','test2','male','Dangol','$12$xerSbxa9b8Nzk1X3SJWw2.wqBStI03JqOR3cKK12JciL/8g8j7L3u','Active','USER045160',1),(56,'patan','testuser3@gmail.com','test3','female','Shakya','$2a$12$xerSbxa9b8Nzk1X3SJWw2.wqBStI03JqOR3cKK12JciL/8g8j7L3u','Active','USER289036',1),(58,'khokana','Avi@gmail.com','test4','male','Dangol','$12$xerSbxa9b8Nzk1X3SJWw2.wqBStI03JqOR3cKK12JciL/8g8j7L3u','Active','USER140499',46),(64,'khokana','ranjit@gmail.com','ranjit','male','maharjan','$12$xerSbxa9b8Nzk1X3SJWw2.wqBStI03JqOR3cKK12JciL/8g8j7L3u','Active','USER018103',63);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
