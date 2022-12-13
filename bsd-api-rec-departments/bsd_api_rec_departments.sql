-- MariaDB dump 10.19  Distrib 10.4.25-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: bsd_api_rec_departments
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
-- Table structure for table `tb_candidate`
--

DROP TABLE IF EXISTS `tb_candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_candidate` (
  `tbc_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbc_create_date` datetime DEFAULT NULL,
  `tbc_create_id` int(11) DEFAULT NULL,
  `tbc_update_date` datetime DEFAULT NULL,
  `tbc_update_id` int(11) DEFAULT NULL,
  `tbc_name` varchar(255) DEFAULT NULL,
  `tbc_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tbc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_candidate`
--

LOCK TABLES `tb_candidate` WRITE;
/*!40000 ALTER TABLE `tb_candidate` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_department`
--

DROP TABLE IF EXISTS `tb_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_department` (
  `tbd_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbd_create_date` datetime DEFAULT NULL,
  `tbd_create_id` int(11) DEFAULT NULL,
  `tbd_update_date` datetime DEFAULT NULL,
  `tbd_update_id` int(11) DEFAULT NULL,
  `tbd_name` varchar(255) DEFAULT NULL,
  `tbd_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tbd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department`
--

LOCK TABLES `tb_department` WRITE;
/*!40000 ALTER TABLE `tb_department` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_department_team`
--

DROP TABLE IF EXISTS `tb_department_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_department_team` (
  `tbdt_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbdt_create_date` datetime DEFAULT NULL,
  `tbdt_create_id` int(11) DEFAULT NULL,
  `tbdt_update_date` datetime DEFAULT NULL,
  `tbdt_update_id` int(11) DEFAULT NULL,
  `tbdt_status` varchar(20) DEFAULT NULL,
  `tbd_id` int(11) DEFAULT NULL,
  `tbu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tbdt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department_team`
--

LOCK TABLES `tb_department_team` WRITE;
/*!40000 ALTER TABLE `tb_department_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_department_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_job`
--

DROP TABLE IF EXISTS `tb_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_job` (
  `tbj_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbj_create_date` datetime DEFAULT NULL,
  `tbj_create_id` int(11) DEFAULT NULL,
  `tbj_update_date` datetime DEFAULT NULL,
  `tbj_update_id` int(11) DEFAULT NULL,
  `tbj_name` varchar(255) DEFAULT NULL,
  `tbj_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`tbj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_job`
--

LOCK TABLES `tb_job` WRITE;
/*!40000 ALTER TABLE `tb_job` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_job_candidate`
--

DROP TABLE IF EXISTS `tb_job_candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_job_candidate` (
  `tbjc_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbjc_create_date` datetime DEFAULT NULL,
  `tbjc_create_id` int(11) DEFAULT NULL,
  `tbjc_update_date` datetime DEFAULT NULL,
  `tbjc_update_id` int(11) DEFAULT NULL,
  `tbjc_status` varchar(20) DEFAULT NULL,
  `tbj_id` int(11) DEFAULT NULL,
  `tbc_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tbjc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_job_candidate`
--

LOCK TABLES `tb_job_candidate` WRITE;
/*!40000 ALTER TABLE `tb_job_candidate` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_job_candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_job_team`
--

DROP TABLE IF EXISTS `tb_job_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_job_team` (
  `tbjt_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbjt_create_date` datetime DEFAULT NULL,
  `tbjt_create_id` int(11) DEFAULT NULL,
  `tbjt_update_date` datetime DEFAULT NULL,
  `tbjt_update_id` int(11) DEFAULT NULL,
  `tbjt_status` varchar(20) DEFAULT NULL,
  `tbj_id` int(11) DEFAULT NULL,
  `tbu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tbjt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_job_team`
--

LOCK TABLES `tb_job_team` WRITE;
/*!40000 ALTER TABLE `tb_job_team` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_job_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `tbu_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbu_create_date` datetime DEFAULT NULL,
  `tbu_create_id` int(11) DEFAULT NULL,
  `tbu_update_date` datetime DEFAULT NULL,
  `tbu_update_id` int(11) DEFAULT NULL,
  `tbu_email` varchar(255) DEFAULT NULL,
  `tbu_password` varchar(32) DEFAULT NULL,
  `tbu_firstname` varchar(100) DEFAULT NULL,
  `tbu_lastname` varchar(100) DEFAULT NULL,
  `tbu_mobile_phone` varchar(100) DEFAULT NULL,
  `tbu_place_of_birth` varchar(100) DEFAULT NULL,
  `tbu_date_of_birth` datetime DEFAULT NULL,
  `tbu_status` varchar(20) DEFAULT NULL,
  `tbu_uid` varchar(100) DEFAULT NULL,
  `tbu_photo` varchar(1000) DEFAULT NULL,
  `tbu_token_salt` varchar(36) DEFAULT NULL,
  `tbu_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tbu_id`),
  UNIQUE KEY `tb_user_tbu_email_uindex` (`tbu_email`),
  UNIQUE KEY `tb_user_tbu_uid_uindex` (`tbu_uid`),
  KEY `tb_user_tbu_firstname_index` (`tbu_firstname`),
  KEY `tb_user_tbu_lastname_index` (`tbu_lastname`),
  KEY `tb_user_tbu_password_index` (`tbu_password`),
  KEY `tb_user_tbu_role_index` (`tbu_role`),
  KEY `tb_user_tbu_status_index` (`tbu_status`),
  KEY `tb_user_tbu_token_salt_index` (`tbu_token_salt`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'2019-09-03 15:42:44',0,'2022-10-13 04:38:47',1,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin','123','Jakarta','1981-08-19 00:00:00','active','xycnh1fzl8chkm8cqr20ni6zvh2ai52c3mvw2uwy0s86mscu9u80h6ylym2imghas6h6ffj05taecfoxfu3g0x8alwbt97q9je8f','1111343528-20q4jm5fw1-Cluster-Morizen-Bekasi-Indonesia.jpg','ymju8h3zhemj0nhcoqrcvu1i961fhslotr0c','ADMIN'),(2,'2021-11-04 12:00:07',1,'2022-03-29 09:55:17',1,'pic1@mail.com','202cb962ac59075b964b07152d234b70','pic','one',NULL,NULL,NULL,'active',NULL,NULL,'ng843n6ocg719kklqklb5814t9n2ahilj9zv','PRINCIPAL'),(3,'2021-11-04 12:12:24',1,'2022-03-29 09:55:28',1,'pic2@mail.com','202cb962ac59075b964b07152d234b70','pic','two',NULL,NULL,NULL,'active',NULL,NULL,'b3n95p03tsdpm9fya84cnelibj9u34xffz6j','DISTRIBUTOR'),(4,'2021-11-04 12:13:34',1,'2022-03-29 09:55:39',1,'pic3@mail.com','202cb962ac59075b964b07152d234b70','pic','three',NULL,NULL,NULL,'active',NULL,NULL,'zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl','DISTRIBUTOR'),(5,'2022-02-07 09:12:44',1,'2022-03-29 09:55:49',1,'pic4@mail.com','202cb962ac59075b964b07152d234b70','pic','four',NULL,NULL,NULL,'active',NULL,NULL,'ni5ju0wgw0l4x3gxoq0cgh3jn3lyvejl5aq8','SUBDIST'),(6,'2022-02-07 09:48:32',1,'2022-03-29 09:56:15',1,'pic6@mail.com','202cb962ac59075b964b07152d234b70','pic','six',NULL,NULL,NULL,'active',NULL,NULL,'onlidhsdmmgz9k8gxzq2dfazrhshyx9zv53p','SUBDIST'),(7,'2022-02-08 08:57:14',1,'2022-03-29 09:56:26',1,'pic7@mail.com','202cb962ac59075b964b07152d234b70','pic','seven',NULL,NULL,NULL,'active',NULL,NULL,'it1wq7s6txkfcl6xw2iji0dmebrmc7b41mtv','GROSIR'),(8,'2022-02-08 08:57:34',1,'2022-03-29 09:56:35',1,'pic8@mail.com','202cb962ac59075b964b07152d234b70','pic','eight',NULL,NULL,NULL,'active',NULL,NULL,'macc9yxlcnfjqix254tmbf0h4459a9w22xfi','GROSIR'),(9,'2022-02-08 08:58:30',1,'2022-03-29 09:56:54',1,'pic9@mail.com','202cb962ac59075b964b07152d234b70','pic','nine',NULL,NULL,NULL,'active',NULL,NULL,'jayf1yr5fd07mshu2c4a29ih8li17beubiwc','MOTORIST'),(10,'2022-02-08 08:59:52',1,'2022-03-29 09:57:02',1,'pic10@mail.com','202cb962ac59075b964b07152d234b70','pic','ten',NULL,NULL,NULL,'active',NULL,NULL,'i8m95htaivk0u5mcjfy3ioo0k9zxxf8lpp5h','MOTORIST'),(11,'2022-02-14 11:18:06',1,'2022-03-29 09:57:11',1,'pic11@mail.com','202cb962ac59075b964b07152d234b70','pic','eleven',NULL,NULL,NULL,'active',NULL,NULL,'lk9i5cv2dm5bnyz07apzo3wirxodwfhhxf85','DISTRIBUTOR'),(12,'2022-02-14 11:19:22',1,'2022-03-29 09:57:20',1,'pic12@mail.com','202cb962ac59075b964b07152d234b70','pic','twelve',NULL,NULL,NULL,'active',NULL,NULL,'uzf4niy96076mn4crvfsalm9r06uoey2spjj','GROSIR'),(13,'2022-02-16 07:42:39',1,'2022-03-29 09:57:29',1,'pic13@mail.com','202cb962ac59075b964b07152d234b70','pic','thirteen',NULL,NULL,NULL,'active',NULL,NULL,'oka59r3uxjbqi7pfwpv2kbiyf1tuxedqvam6','GROSIR'),(14,'2022-02-24 03:08:59',1,'2022-04-18 06:25:36',14,'pic14@mail.com','202cb962ac59075b964b07152d234b70','pic','fourteen',NULL,NULL,NULL,'active',NULL,NULL,'ntw5zeue28u72o3bkbdukg0hjahj25bqcljx','PRINCIPAL');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-22 18:38:47
