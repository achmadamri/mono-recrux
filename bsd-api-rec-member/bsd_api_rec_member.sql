-- MariaDB dump 10.19  Distrib 10.4.25-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: bsd_api_rec_member
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
-- Table structure for table `tb_menu`
--

DROP TABLE IF EXISTS `tb_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_menu` (
  `tbm_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbm_create_date` datetime DEFAULT NULL,
  `tbm_create_id` int(11) DEFAULT NULL,
  `tbm_update_date` datetime DEFAULT NULL,
  `tbm_update_id` int(11) DEFAULT NULL,
  `tbm_name` varchar(255) DEFAULT NULL,
  `tbm_sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`tbm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_menu`
--

LOCK TABLES `tb_menu` WRITE;
/*!40000 ALTER TABLE `tb_menu` DISABLE KEYS */;
INSERT INTO `tb_menu` VALUES (1,'2021-07-31 15:26:21',0,NULL,NULL,'Product',2),(2,'2021-07-31 15:26:21',0,NULL,NULL,'Order',3),(3,'2021-07-31 15:26:21',0,NULL,NULL,'Packing',4),(4,'2021-07-31 15:26:21',0,NULL,NULL,'Confirm',5),(5,'2021-07-31 15:26:21',0,NULL,NULL,'Report',6),(6,'2021-07-31 15:26:21',0,NULL,NULL,'User',7),(7,'2021-07-31 15:26:21',0,NULL,NULL,'Market',1);
/*!40000 ALTER TABLE `tb_menu` ENABLE KEYS */;
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
  KEY `tb_user_tbu_status_index` (`tbu_status`),
  KEY `tb_user_tbu_password_index` (`tbu_password`),
  KEY `tb_user_tbu_firstname_index` (`tbu_firstname`),
  KEY `tb_user_tbu_lastname_index` (`tbu_lastname`),
  KEY `tb_user_tbu_token_salt_index` (`tbu_token_salt`),
  KEY `tb_user_tbu_role_index` (`tbu_role`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'2019-09-03 15:42:44',0,'2022-11-22 10:56:16',1,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin','123','Jakarta','1981-08-19 00:00:00','active','xycnh1fzl8chkm8cqr20ni6zvh2ai52c3mvw2uwy0s86mscu9u80h6ylym2imghas6h6ffj05taecfoxfu3g0x8alwbt97q9je8f','1111343528-20q4jm5fw1-Cluster-Morizen-Bekasi-Indonesia.jpg','wdhrpddpa5yyq2sv1i357uchthdm6weghfzb','ADMIN'),(2,'2021-11-04 12:00:07',1,'2022-03-29 09:55:17',1,'pic1@mail.com','202cb962ac59075b964b07152d234b70','pic','one',NULL,NULL,NULL,'active',NULL,NULL,'ng843n6ocg719kklqklb5814t9n2ahilj9zv','PRINCIPAL'),(3,'2021-11-04 12:12:24',1,'2022-03-29 09:55:28',1,'pic2@mail.com','202cb962ac59075b964b07152d234b70','pic','two',NULL,NULL,NULL,'active',NULL,NULL,'b3n95p03tsdpm9fya84cnelibj9u34xffz6j','DISTRIBUTOR'),(4,'2021-11-04 12:13:34',1,'2022-03-29 09:55:39',1,'pic3@mail.com','202cb962ac59075b964b07152d234b70','pic','three',NULL,NULL,NULL,'active',NULL,NULL,'zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl','DISTRIBUTOR'),(5,'2022-02-07 09:12:44',1,'2022-03-29 09:55:49',1,'pic4@mail.com','202cb962ac59075b964b07152d234b70','pic','four',NULL,NULL,NULL,'active',NULL,NULL,'ni5ju0wgw0l4x3gxoq0cgh3jn3lyvejl5aq8','SUBDIST'),(6,'2022-02-07 09:48:32',1,'2022-03-29 09:56:15',1,'pic6@mail.com','202cb962ac59075b964b07152d234b70','pic','six',NULL,NULL,NULL,'active',NULL,NULL,'onlidhsdmmgz9k8gxzq2dfazrhshyx9zv53p','SUBDIST'),(7,'2022-02-08 08:57:14',1,'2022-03-29 09:56:26',1,'pic7@mail.com','202cb962ac59075b964b07152d234b70','pic','seven',NULL,NULL,NULL,'active',NULL,NULL,'it1wq7s6txkfcl6xw2iji0dmebrmc7b41mtv','GROSIR'),(8,'2022-02-08 08:57:34',1,'2022-03-29 09:56:35',1,'pic8@mail.com','202cb962ac59075b964b07152d234b70','pic','eight',NULL,NULL,NULL,'active',NULL,NULL,'macc9yxlcnfjqix254tmbf0h4459a9w22xfi','GROSIR'),(9,'2022-02-08 08:58:30',1,'2022-03-29 09:56:54',1,'pic9@mail.com','202cb962ac59075b964b07152d234b70','pic','nine',NULL,NULL,NULL,'active',NULL,NULL,'jayf1yr5fd07mshu2c4a29ih8li17beubiwc','MOTORIST'),(10,'2022-02-08 08:59:52',1,'2022-03-29 09:57:02',1,'pic10@mail.com','202cb962ac59075b964b07152d234b70','pic','ten',NULL,NULL,NULL,'active',NULL,NULL,'i8m95htaivk0u5mcjfy3ioo0k9zxxf8lpp5h','MOTORIST'),(11,'2022-02-14 11:18:06',1,'2022-03-29 09:57:11',1,'pic11@mail.com','202cb962ac59075b964b07152d234b70','pic','eleven',NULL,NULL,NULL,'active',NULL,NULL,'lk9i5cv2dm5bnyz07apzo3wirxodwfhhxf85','DISTRIBUTOR'),(12,'2022-02-14 11:19:22',1,'2022-03-29 09:57:20',1,'pic12@mail.com','202cb962ac59075b964b07152d234b70','pic','twelve',NULL,NULL,NULL,'active',NULL,NULL,'uzf4niy96076mn4crvfsalm9r06uoey2spjj','GROSIR'),(13,'2022-02-16 07:42:39',1,'2022-03-29 09:57:29',1,'pic13@mail.com','202cb962ac59075b964b07152d234b70','pic','thirteen',NULL,NULL,NULL,'active',NULL,NULL,'oka59r3uxjbqi7pfwpv2kbiyf1tuxedqvam6','GROSIR'),(14,'2022-02-24 03:08:59',1,'2022-04-18 06:25:36',14,'pic14@mail.com','202cb962ac59075b964b07152d234b70','pic','fourteen',NULL,NULL,NULL,'active',NULL,NULL,'ntw5zeue28u72o3bkbdukg0hjahj25bqcljx','PRINCIPAL');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_menu`
--

DROP TABLE IF EXISTS `tb_user_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_menu` (
  `tbum_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbum_create_date` datetime DEFAULT NULL,
  `tbum_create_id` int(11) DEFAULT NULL,
  `tbum_update_date` datetime DEFAULT NULL,
  `tbum_update_id` int(11) DEFAULT NULL,
  `tbu_id` int(11) DEFAULT NULL,
  `tbm_id` int(11) DEFAULT NULL,
  `tbum_add` int(11) DEFAULT NULL,
  `tbum_edit` int(11) DEFAULT NULL,
  `tbum_delete` int(11) DEFAULT NULL,
  `tbum_view` int(11) DEFAULT NULL,
  PRIMARY KEY (`tbum_id`),
  KEY `tb_user_menu_tbu_id_index` (`tbu_id`),
  KEY `tb_user_menu_tbm_id_index` (`tbm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_menu`
--

LOCK TABLES `tb_user_menu` WRITE;
/*!40000 ALTER TABLE `tb_user_menu` DISABLE KEYS */;
INSERT INTO `tb_user_menu` VALUES (128,'2022-03-29 09:55:17',1,NULL,NULL,2,4,1,1,1,1),(129,'2022-03-29 09:55:17',1,NULL,NULL,2,7,1,1,1,1),(130,'2022-03-29 09:55:17',1,NULL,NULL,2,2,1,1,1,1),(131,'2022-03-29 09:55:17',1,NULL,NULL,2,3,1,1,1,1),(132,'2022-03-29 09:55:17',1,NULL,NULL,2,1,1,1,1,1),(133,'2022-03-29 09:55:17',1,NULL,NULL,2,5,1,1,1,1),(134,'2022-03-29 09:55:17',1,NULL,NULL,2,6,1,1,1,0),(135,'2022-03-29 09:55:28',1,NULL,NULL,3,4,1,1,1,1),(136,'2022-03-29 09:55:28',1,NULL,NULL,3,7,1,1,1,0),(137,'2022-03-29 09:55:28',1,NULL,NULL,3,2,1,1,1,1),(138,'2022-03-29 09:55:28',1,NULL,NULL,3,3,1,1,1,1),(139,'2022-03-29 09:55:28',1,NULL,NULL,3,1,1,1,1,1),(140,'2022-03-29 09:55:28',1,NULL,NULL,3,5,1,1,1,1),(141,'2022-03-29 09:55:28',1,NULL,NULL,3,6,1,1,1,0),(142,'2022-03-29 09:55:39',1,NULL,NULL,4,4,1,1,1,1),(143,'2022-03-29 09:55:39',1,NULL,NULL,4,7,1,1,1,0),(144,'2022-03-29 09:55:39',1,NULL,NULL,4,2,1,1,1,1),(145,'2022-03-29 09:55:39',1,NULL,NULL,4,3,1,1,1,1),(146,'2022-03-29 09:55:39',1,NULL,NULL,4,1,1,1,1,1),(147,'2022-03-29 09:55:39',1,NULL,NULL,4,5,1,1,1,1),(148,'2022-03-29 09:55:39',1,NULL,NULL,4,6,1,1,1,0),(149,'2022-03-29 09:55:49',1,NULL,NULL,5,4,1,1,1,1),(150,'2022-03-29 09:55:49',1,NULL,NULL,5,7,1,1,1,0),(151,'2022-03-29 09:55:49',1,NULL,NULL,5,2,1,1,1,1),(152,'2022-03-29 09:55:49',1,NULL,NULL,5,3,1,1,1,1),(153,'2022-03-29 09:55:49',1,NULL,NULL,5,1,1,1,1,0),(154,'2022-03-29 09:55:49',1,NULL,NULL,5,5,1,1,1,1),(155,'2022-03-29 09:55:49',1,NULL,NULL,5,6,1,1,1,0),(156,'2022-03-29 09:56:15',1,NULL,NULL,6,4,1,1,1,1),(157,'2022-03-29 09:56:15',1,NULL,NULL,6,7,1,1,1,0),(158,'2022-03-29 09:56:15',1,NULL,NULL,6,2,1,1,1,1),(159,'2022-03-29 09:56:15',1,NULL,NULL,6,3,1,1,1,1),(160,'2022-03-29 09:56:15',1,NULL,NULL,6,1,1,1,1,0),(161,'2022-03-29 09:56:15',1,NULL,NULL,6,5,1,1,1,1),(162,'2022-03-29 09:56:15',1,NULL,NULL,6,6,1,1,1,0),(163,'2022-03-29 09:56:26',1,NULL,NULL,7,4,1,1,1,1),(164,'2022-03-29 09:56:26',1,NULL,NULL,7,7,1,1,1,0),(165,'2022-03-29 09:56:26',1,NULL,NULL,7,2,1,1,1,0),(166,'2022-03-29 09:56:26',1,NULL,NULL,7,3,1,1,1,1),(167,'2022-03-29 09:56:26',1,NULL,NULL,7,1,1,1,1,0),(168,'2022-03-29 09:56:26',1,NULL,NULL,7,5,1,1,1,1),(169,'2022-03-29 09:56:26',1,NULL,NULL,7,6,1,1,1,0),(170,'2022-03-29 09:56:35',1,NULL,NULL,8,4,1,1,1,1),(171,'2022-03-29 09:56:35',1,NULL,NULL,8,7,1,1,1,0),(172,'2022-03-29 09:56:35',1,NULL,NULL,8,2,1,1,1,0),(173,'2022-03-29 09:56:35',1,NULL,NULL,8,3,1,1,1,1),(174,'2022-03-29 09:56:35',1,NULL,NULL,8,1,1,1,1,0),(175,'2022-03-29 09:56:35',1,NULL,NULL,8,5,1,1,1,1),(176,'2022-03-29 09:56:35',1,NULL,NULL,8,6,1,1,1,0),(177,'2022-03-29 09:56:54',1,NULL,NULL,9,4,1,1,1,0),(178,'2022-03-29 09:56:54',1,NULL,NULL,9,7,1,1,1,0),(179,'2022-03-29 09:56:54',1,NULL,NULL,9,2,1,1,1,1),(180,'2022-03-29 09:56:54',1,NULL,NULL,9,3,1,1,1,0),(181,'2022-03-29 09:56:54',1,NULL,NULL,9,1,1,1,1,0),(182,'2022-03-29 09:56:54',1,NULL,NULL,9,5,1,1,1,1),(183,'2022-03-29 09:56:54',1,NULL,NULL,9,6,1,1,1,0),(184,'2022-03-29 09:57:02',1,NULL,NULL,10,4,1,1,1,0),(185,'2022-03-29 09:57:02',1,NULL,NULL,10,7,1,1,1,0),(186,'2022-03-29 09:57:02',1,NULL,NULL,10,2,1,1,1,1),(187,'2022-03-29 09:57:02',1,NULL,NULL,10,3,1,1,1,0),(188,'2022-03-29 09:57:02',1,NULL,NULL,10,1,1,1,1,0),(189,'2022-03-29 09:57:02',1,NULL,NULL,10,5,1,1,1,1),(190,'2022-03-29 09:57:02',1,NULL,NULL,10,6,1,1,1,0),(191,'2022-03-29 09:57:11',1,NULL,NULL,11,4,1,1,1,1),(192,'2022-03-29 09:57:11',1,NULL,NULL,11,7,1,1,1,0),(193,'2022-03-29 09:57:11',1,NULL,NULL,11,2,1,1,1,1),(194,'2022-03-29 09:57:11',1,NULL,NULL,11,3,1,1,1,1),(195,'2022-03-29 09:57:11',1,NULL,NULL,11,1,1,1,1,1),(196,'2022-03-29 09:57:11',1,NULL,NULL,11,5,1,1,1,1),(197,'2022-03-29 09:57:11',1,NULL,NULL,11,6,1,1,1,0),(198,'2022-03-29 09:57:20',1,NULL,NULL,12,4,1,1,1,1),(199,'2022-03-29 09:57:20',1,NULL,NULL,12,7,1,1,1,0),(200,'2022-03-29 09:57:20',1,NULL,NULL,12,2,1,1,1,0),(201,'2022-03-29 09:57:20',1,NULL,NULL,12,3,1,1,1,1),(202,'2022-03-29 09:57:20',1,NULL,NULL,12,1,1,1,1,0),(203,'2022-03-29 09:57:20',1,NULL,NULL,12,5,1,1,1,1),(204,'2022-03-29 09:57:20',1,NULL,NULL,12,6,1,1,1,0),(205,'2022-03-29 09:57:29',1,NULL,NULL,13,4,1,1,1,1),(206,'2022-03-29 09:57:29',1,NULL,NULL,13,7,1,1,1,0),(207,'2022-03-29 09:57:29',1,NULL,NULL,13,2,1,1,1,0),(208,'2022-03-29 09:57:29',1,NULL,NULL,13,3,1,1,1,1),(209,'2022-03-29 09:57:29',1,NULL,NULL,13,1,1,1,1,0),(210,'2022-03-29 09:57:29',1,NULL,NULL,13,5,1,1,1,1),(211,'2022-03-29 09:57:29',1,NULL,NULL,13,6,1,1,1,0),(212,'2022-03-29 09:57:36',1,NULL,NULL,14,4,1,1,1,1),(213,'2022-03-29 09:57:36',1,NULL,NULL,14,7,1,1,1,1),(214,'2022-03-29 09:57:36',1,NULL,NULL,14,2,1,1,1,1),(215,'2022-03-29 09:57:36',1,NULL,NULL,14,3,1,1,1,1),(216,'2022-03-29 09:57:36',1,NULL,NULL,14,1,1,1,1,1),(217,'2022-03-29 09:57:36',1,NULL,NULL,14,5,1,1,1,1),(218,'2022-03-29 09:57:36',1,NULL,NULL,14,6,1,1,1,0),(219,'2022-03-29 14:06:02',1,NULL,NULL,1,4,1,1,1,1),(220,'2022-03-29 14:06:02',1,NULL,NULL,1,7,1,1,1,1),(221,'2022-03-29 14:06:02',1,NULL,NULL,1,2,1,1,1,1),(222,'2022-03-29 14:06:02',1,NULL,NULL,1,3,1,1,1,1),(223,'2022-03-29 14:06:02',1,NULL,NULL,1,1,1,1,1,1),(224,'2022-03-29 14:06:02',1,NULL,NULL,1,5,1,1,1,1),(225,'2022-03-29 14:06:02',1,NULL,NULL,1,6,1,1,1,1);
/*!40000 ALTER TABLE `tb_user_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `view_user_menu`
--

DROP TABLE IF EXISTS `view_user_menu`;
/*!50001 DROP VIEW IF EXISTS `view_user_menu`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `view_user_menu` (
  `uuid` tinyint NOT NULL,
  `tbu_id` tinyint NOT NULL,
  `tbu_email` tinyint NOT NULL,
  `tbu_firstname` tinyint NOT NULL,
  `tbu_lastname` tinyint NOT NULL,
  `tbm_id` tinyint NOT NULL,
  `tbm_name` tinyint NOT NULL,
  `tbum_add` tinyint NOT NULL,
  `tbum_edit` tinyint NOT NULL,
  `tbum_delete` tinyint NOT NULL,
  `tbum_view` tinyint NOT NULL,
  `tbm_sort` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_user_menu`
--

/*!50001 DROP TABLE IF EXISTS `view_user_menu`*/;
/*!50001 DROP VIEW IF EXISTS `view_user_menu`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_user_menu` AS select uuid() AS `uuid`,`tbu`.`tbu_id` AS `tbu_id`,`tbu`.`tbu_email` AS `tbu_email`,`tbu`.`tbu_firstname` AS `tbu_firstname`,`tbu`.`tbu_lastname` AS `tbu_lastname`,`tbm`.`tbm_id` AS `tbm_id`,`tbm`.`tbm_name` AS `tbm_name`,`tbum`.`tbum_add` AS `tbum_add`,`tbum`.`tbum_edit` AS `tbum_edit`,`tbum`.`tbum_delete` AS `tbum_delete`,`tbum`.`tbum_view` AS `tbum_view`,`tbm`.`tbm_sort` AS `tbm_sort` from ((`tb_user` `tbu` join `tb_user_menu` `tbum` on(`tbu`.`tbu_id` = `tbum`.`tbu_id`)) join `tb_menu` `tbm` on(`tbum`.`tbm_id` = `tbm`.`tbm_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-22 18:39:18
