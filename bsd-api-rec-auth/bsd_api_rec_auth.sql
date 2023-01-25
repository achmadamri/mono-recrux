-- MariaDB dump 10.19  Distrib 10.4.25-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: bsd_api_rec_auth
-- ------------------------------------------------------
-- Server version	10.4.25-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_auth`
--

DROP TABLE IF EXISTS `tb_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_auth` (
  `tba_id` int(11) NOT NULL AUTO_INCREMENT,
  `tba_create_date` datetime DEFAULT NULL,
  `tba_create_id` int(11) DEFAULT NULL,
  `tba_update_date` datetime DEFAULT NULL,
  `tba_update_id` int(11) DEFAULT NULL,
  `tba_email` varchar(255) DEFAULT NULL,
  `tba_password` varchar(32) DEFAULT NULL,
  `tba_status` varchar(20) DEFAULT NULL,
  `tba_token_salt` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`tba_id`),
  KEY `tb_auth_tba_email_index` (`tba_email`),
  KEY `tb_auth_tba_password_index` (`tba_password`),
  KEY `tb_auth_tba_status_index` (`tba_status`),
  KEY `tb_auth_tba_token_salt_index` (`tba_token_salt`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_auth`
--

LOCK TABLES `tb_auth` WRITE;
/*!40000 ALTER TABLE `tb_auth` DISABLE KEYS */;
INSERT INTO `tb_auth` VALUES (1,'2019-09-03 15:43:36',0,'2022-12-07 15:46:30',0,'admin@mail.com','202cb962ac59075b964b07152d234b70','active','88keo73b4cx8bwava8lp1cnrwqklbaesug2h'),(2,'2021-11-04 12:00:07',0,'2022-03-29 09:55:17',0,'pic1@mail.com','202cb962ac59075b964b07152d234b70','active','ng843n6ocg719kklqklb5814t9n2ahilj9zv'),(3,'2021-11-04 12:12:24',0,'2022-03-29 09:55:28',0,'pic2@mail.com','202cb962ac59075b964b07152d234b70','active','b3n95p03tsdpm9fya84cnelibj9u34xffz6j'),(4,'2021-11-04 12:13:34',0,'2022-03-29 09:55:39',0,'pic3@mail.com','202cb962ac59075b964b07152d234b70','active','zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl'),(5,'2022-02-07 09:12:44',0,'2022-03-29 09:55:49',0,'pic4@mail.com','202cb962ac59075b964b07152d234b70','active','ni5ju0wgw0l4x3gxoq0cgh3jn3lyvejl5aq8'),(6,'2022-02-07 09:48:32',0,'2022-03-29 09:56:15',0,'pic6@mail.com','202cb962ac59075b964b07152d234b70','active','onlidhsdmmgz9k8gxzq2dfazrhshyx9zv53p'),(7,'2022-02-08 08:57:14',0,'2022-03-29 09:56:26',0,'pic7@mail.com','202cb962ac59075b964b07152d234b70','active','it1wq7s6txkfcl6xw2iji0dmebrmc7b41mtv'),(8,'2022-02-08 08:57:34',0,'2022-03-29 09:56:35',0,'pic8@mail.com','202cb962ac59075b964b07152d234b70','active','macc9yxlcnfjqix254tmbf0h4459a9w22xfi'),(9,'2022-02-08 08:58:30',0,'2022-03-29 09:56:54',0,'pic9@mail.com','202cb962ac59075b964b07152d234b70','active','jayf1yr5fd07mshu2c4a29ih8li17beubiwc'),(10,'2022-02-08 08:59:52',0,'2022-03-29 09:57:02',0,'pic10@mail.com','202cb962ac59075b964b07152d234b70','active','i8m95htaivk0u5mcjfy3ioo0k9zxxf8lpp5h'),(11,'2022-02-14 11:18:06',0,'2022-03-29 09:57:11',0,'pic11@mail.com','202cb962ac59075b964b07152d234b70','active','lk9i5cv2dm5bnyz07apzo3wirxodwfhhxf85'),(12,'2022-02-14 11:19:22',0,'2022-03-29 09:57:20',0,'pic12@mail.com','202cb962ac59075b964b07152d234b70','active','uzf4niy96076mn4crvfsalm9r06uoey2spjj'),(13,'2022-02-16 07:42:39',0,'2022-03-29 09:57:29',0,'pic13@mail.com','202cb962ac59075b964b07152d234b70','active','oka59r3uxjbqi7pfwpv2kbiyf1tuxedqvam6'),(14,'2022-02-24 03:08:59',0,'2022-10-17 05:37:45',0,'pic14@mail.com','202cb962ac59075b964b07152d234b70','active','mogvebpxsz7rdbm7nrz1yj77310d86jhh4e7'),(28,'2022-12-13 15:22:59',0,'2023-01-25 12:14:17',0,'achmad.amri@gmail.com','202cb962ac59075b964b07152d234b70','active','Z6M7SPL0ZCZG0OFS2HO7SR51T1B31AH95FGF');
/*!40000 ALTER TABLE `tb_auth` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-25 22:29:16
