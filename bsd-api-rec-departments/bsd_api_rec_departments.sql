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
  `tbc_create_idc` int(11) DEFAULT NULL,
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
  `tbd_create_idc` int(11) DEFAULT NULL,
  `tbd_update_date` datetime DEFAULT NULL,
  `tbd_update_id` int(11) DEFAULT NULL,
  `tbd_name` varchar(255) DEFAULT NULL,
  `tbd_status` varchar(20) DEFAULT NULL,
  `tbd_uuid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`tbd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department`
--

LOCK TABLES `tb_department` WRITE;
/*!40000 ALTER TABLE `tb_department` DISABLE KEYS */;
INSERT INTO `tb_department` VALUES (1,NULL,28,1,'2023-01-24 12:18:22',28,'Human Resources','active','26EYH'),(2,NULL,28,1,'2023-01-04 13:55:46',28,'Product and Development','active','9IFU7'),(3,NULL,28,1,'2023-01-05 13:42:42',28,'Sales and Marketing','active','6H74K'),(4,NULL,28,1,'2023-01-24 12:16:47',28,'Information Technology','active','7KJU8'),(5,'2023-01-03 09:11:23',28,1,'2023-01-05 07:56:34',28,'RnD','active','4LO6G'),(7,'2023-01-03 15:39:43',28,1,'2023-01-05 13:25:46',28,'CEO Office','active','0AWNA'),(8,'2023-01-03 15:42:56',28,1,'2023-01-04 09:35:43',28,'Blockchain','active','1WV47'),(9,'2023-01-03 15:43:28',28,1,'2023-01-04 08:33:25',28,'Data Science','active','Q1ITU'),(10,'2023-01-05 13:26:04',28,1,NULL,NULL,'BOD','active','1DSMX'),(11,'2023-01-05 13:28:10',28,1,NULL,NULL,'Legal','active','YOODH');
/*!40000 ALTER TABLE `tb_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_department_job`
--

DROP TABLE IF EXISTS `tb_department_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_department_job` (
  `tbdj_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbdj_create_date` datetime DEFAULT NULL,
  `tbdj_create_id` int(11) DEFAULT NULL,
  `tbdj_create_idc` int(11) DEFAULT NULL,
  `tbdj_update_date` datetime DEFAULT NULL,
  `tbdj_update_id` int(11) DEFAULT NULL,
  `tbdj_status` varchar(20) DEFAULT NULL,
  `tbd_id` int(11) DEFAULT NULL,
  `tbj_id` int(11) DEFAULT NULL,
  `tbdj_uuid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`tbdj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department_job`
--

LOCK TABLES `tb_department_job` WRITE;
/*!40000 ALTER TABLE `tb_department_job` DISABLE KEYS */;
INSERT INTO `tb_department_job` VALUES (1,'2023-01-09 03:34:36',28,1,'2023-01-24 12:18:47',28,'assigned',1,2,'1C1ST'),(2,'2023-01-09 03:55:20',28,1,'2023-01-24 12:18:42',28,'assigned',1,1,'P74C1'),(3,'2023-01-09 05:17:27',28,1,'2023-01-11 05:20:14',28,'not assigned',5,1,'020UZ'),(4,'2023-01-09 05:17:36',28,1,'2023-01-09 07:36:59',28,'not assigned',5,2,'60HDX'),(5,'2023-01-09 05:17:38',28,1,'2023-01-09 05:17:59',28,'not assigned',5,3,'HDM5J'),(6,'2023-01-09 05:17:39',28,1,'2023-01-09 05:17:56',28,'not assigned',5,4,'QB7YC'),(7,'2023-01-09 05:17:40',28,1,'2023-01-09 05:17:49',28,'not assigned',5,5,'TFU42'),(8,'2023-01-09 05:17:41',28,1,NULL,NULL,'assigned',5,6,'2UKN8'),(9,'2023-01-09 07:36:27',28,1,'2023-01-09 07:36:35',28,'not assigned',3,2,'KLIBG'),(10,'2023-01-12 09:45:38',28,1,'2023-01-24 12:15:32',28,'assigned',4,1,'CM4AK'),(11,'2023-01-12 09:45:40',28,1,'2023-01-24 12:15:37',28,'assigned',4,2,'B17AI'),(12,'2023-01-24 01:18:20',28,1,NULL,NULL,'assigned',1,5,'VMRN7'),(13,'2023-01-24 01:18:23',28,1,NULL,NULL,'assigned',1,4,'TQ72L'),(14,'2023-01-24 12:15:38',28,1,NULL,NULL,'assigned',4,3,'2ULEA'),(15,'2023-01-24 12:18:54',28,1,NULL,NULL,'assigned',1,3,'62YEB');
/*!40000 ALTER TABLE `tb_department_job` ENABLE KEYS */;
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
  `tbj_create_idc` int(11) DEFAULT NULL,
  `tbj_update_date` datetime DEFAULT NULL,
  `tbj_update_id` int(11) DEFAULT NULL,
  `tbj_name` varchar(255) DEFAULT NULL,
  `tbj_status` varchar(20) DEFAULT NULL,
  `tbj_uuid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tbj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_job`
--

LOCK TABLES `tb_job` WRITE;
/*!40000 ALTER TABLE `tb_job` DISABLE KEYS */;
INSERT INTO `tb_job` VALUES (1,NULL,NULL,1,'2023-01-24 12:16:24',28,'Software Engineer','active','8HU6O'),(2,NULL,NULL,1,'2023-01-05 16:08:53',28,'QA Engineer','active','9LK76'),(3,NULL,NULL,1,'2023-01-05 16:08:54',28,'Product Owner','active','HASD6'),(4,NULL,NULL,1,'2023-01-05 16:08:56',28,'HR Manager','active','17G6Y'),(5,NULL,NULL,1,'2023-01-05 16:51:02',28,'HR Staff','active','A87JH'),(6,NULL,NULL,1,'2023-01-12 09:43:07',28,'CEO','active','G67HJ');
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
  `tbjc_create_idc` int(11) DEFAULT NULL,
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
-- Table structure for table `tb_job_resume`
--

DROP TABLE IF EXISTS `tb_job_resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_job_resume` (
  `tbjr_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbjr_create_date` datetime DEFAULT NULL,
  `tbjr_create_id` int(11) DEFAULT NULL,
  `tbjr_create_idc` int(11) DEFAULT NULL,
  `tbjr_update_date` datetime DEFAULT NULL,
  `tbjr_update_id` int(11) DEFAULT NULL,
  `tbjr_status` varchar(20) DEFAULT NULL,
  `tbj_id` int(11) DEFAULT NULL,
  `tbr_id` int(11) DEFAULT NULL,
  `tbjr_uuid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`tbjr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_job_resume`
--

LOCK TABLES `tb_job_resume` WRITE;
/*!40000 ALTER TABLE `tb_job_resume` DISABLE KEYS */;
INSERT INTO `tb_job_resume` VALUES (1,'2023-01-24 15:05:56',28,1,NULL,NULL,'assigned',1,1,'X921O'),(2,'2023-01-24 15:07:02',28,1,NULL,NULL,'assigned',1,2,'WZXPS'),(3,'2023-01-24 15:07:14',28,1,NULL,NULL,'assigned',1,3,'Q7F6G'),(4,'2023-01-25 06:49:22',28,1,NULL,NULL,'assigned',1,4,'7X9K4'),(5,'2023-01-25 14:32:04',28,1,NULL,NULL,'assigned',1,5,'67Q7M'),(6,'2023-01-25 15:25:46',28,1,NULL,NULL,'assigned',1,1,'AW3WM'),(7,'2023-01-25 15:25:47',28,1,NULL,NULL,'assigned',1,2,'KI3YI'),(8,'2023-01-25 15:25:50',28,1,NULL,NULL,'assigned',1,3,'WBBHU');
/*!40000 ALTER TABLE `tb_job_resume` ENABLE KEYS */;
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
-- Table structure for table `tb_resume`
--

DROP TABLE IF EXISTS `tb_resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_resume` (
  `tbr_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbr_create_date` datetime DEFAULT NULL,
  `tbr_create_id` int(11) DEFAULT NULL,
  `tbr_create_idc` int(11) DEFAULT NULL,
  `tbr_update_date` datetime DEFAULT NULL,
  `tbr_update_id` int(11) DEFAULT NULL,
  `tbr_data_name_raw` varchar(500) DEFAULT NULL,
  `tbr_data_name_first` varchar(500) DEFAULT NULL,
  `tbr_data_name_last` varchar(500) DEFAULT NULL,
  `tbr_data_name_middle` varchar(500) DEFAULT NULL,
  `tbr_data_name_title` varchar(500) DEFAULT NULL,
  `tbr_data_phone_numbers` text DEFAULT NULL,
  `tbr_data_websites` text DEFAULT NULL,
  `tbr_data_emails` text DEFAULT NULL,
  `tbr_data_date_of_birth` varchar(500) DEFAULT NULL,
  `tbr_data_location_formatted` varchar(500) DEFAULT NULL,
  `tbr_data_location_postal_code` varchar(500) DEFAULT NULL,
  `tbr_data_location_state` varchar(500) DEFAULT NULL,
  `tbr_data_location_country` varchar(500) DEFAULT NULL,
  `tbr_data_location_country_code` varchar(500) DEFAULT NULL,
  `tbr_data_location_raw_input` varchar(500) DEFAULT NULL,
  `tbr_data_location_street_number` varchar(500) DEFAULT NULL,
  `tbr_data_location_street` varchar(500) DEFAULT NULL,
  `tbr_data_location_apartment_number` varchar(500) DEFAULT NULL,
  `tbr_data_location_city` varchar(500) DEFAULT NULL,
  `tbr_data_objective` varchar(500) DEFAULT NULL,
  `tbr_data_languages` text DEFAULT NULL,
  `tbr_data_language_codes` text DEFAULT NULL,
  `tbr_data_summary` varchar(500) DEFAULT NULL,
  `tbr_data_total_years_experience` int(11) DEFAULT NULL,
  `tbr_data_head_shot` varchar(500) DEFAULT NULL,
  `tbr_data_education` text DEFAULT NULL,
  `tbr_data_profession` varchar(500) DEFAULT NULL,
  `tbr_data_linkedin` varchar(500) DEFAULT NULL,
  `tbr_data_work_experience` text DEFAULT NULL,
  `tbr_data_skills` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `tbr_data_certifications` text DEFAULT NULL,
  `tbr_data_publications` text DEFAULT NULL,
  `tbr_data_referees` text DEFAULT NULL,
  `tbr_data_sections` text DEFAULT NULL,
  `tbr_data_is_resume_probability` int(11) DEFAULT NULL,
  `tbr_data_raw_text` varchar(500) DEFAULT NULL,
  `tbr_meta_identifier` varchar(500) DEFAULT NULL,
  `tbr_meta_file_name` varchar(500) DEFAULT NULL,
  `tbr_meta_ready` int(11) DEFAULT NULL,
  `tbr_meta_ready_dt` varchar(500) DEFAULT NULL,
  `tbr_meta_failed` int(11) DEFAULT NULL,
  `tbr_meta_expiry_time` varchar(500) DEFAULT NULL,
  `tbr_meta_language` varchar(500) DEFAULT NULL,
  `tbr_meta_pdf` varchar(500) DEFAULT NULL,
  `tbr_meta_parent_document_identifier` varchar(500) DEFAULT NULL,
  `tbr_meta_child_documents` text DEFAULT NULL,
  `tbr_meta_pages` text DEFAULT NULL,
  `tbr_meta_is_verified` int(11) DEFAULT NULL,
  `tbr_meta_review_url` varchar(500) DEFAULT NULL,
  `tbr_meta_ocr_confidence` double DEFAULT NULL,
  `tbr_error_error_code` varchar(500) DEFAULT NULL,
  `tbr_error_error_detail` varchar(500) DEFAULT NULL,
  `tbr_status` varchar(20) DEFAULT NULL,
  `tbr_uuid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`tbr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume`
--

LOCK TABLES `tb_resume` WRITE;
/*!40000 ALTER TABLE `tb_resume` DISABLE KEYS */;
INSERT INTO `tb_resume` VALUES (1,'2023-01-25 15:25:46',28,1,NULL,NULL,'ASWIN SETYAWAN MARGONO','Aswin','Margono','Setyawan','','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','Formula, English',NULL,'SAP CERTIFIED CONSULTANT- MODULE BPC / BO / BW',0,NULL,'[{\"id\":9784923,\"organization\":\"Monash University\",\"accreditation\":{\"education\":\"Master of Business\",\"educationLevel\":\"masters\",\"inputStr\":\"MASTER OF BUSINESS SYSTEMS PROFESSIONAL\",\"matchStr\":\"\"},\"grade\":{\"raw\":\"GPA : 3.81 OUT OF 4.00\",\"value\":\"3.81\",\"metric\":\"GPA\"},\"location\":{\"formatted\":\"Melbourne VIC, Australia\",\"city\":\"Melbourne\",\"state\":\"Victoria\",\"country\":\"Australia\",\"rawInput\":\"MELBOURNE, AUSTRALIA.\",\"countryCode\":\"AU\",\"latitude\":-37.8136276,\"longitude\":144.9630576}},{\"id\":9784924,\"organization\":\"SEKOLAH TINGGI TEKNIK SURABAYA (STTS) UNIVERSITY\",\"accreditation\":{\"education\":\"Bachelor of Science\",\"educationLevel\":\"bachelors\",\"inputStr\":\"BACHELOR OF COMPUTER SCIENCE\",\"matchStr\":\"\"},\"grade\":{\"raw\":\"GPA : 3.88 OUT OF 4.00\",\"value\":\"3.88\",\"metric\":\"GPA\"},\"location\":{\"formatted\":\"Surabaya, Surabaya City, East Java, Indonesia\",\"city\":\"Surabaya\",\"state\":\"East Java\",\"country\":\"Indonesia\",\"rawInput\":\"SURABAYA, INDONESIA.\",\"countryCode\":\"ID\",\"latitude\":-7.2574719,\"longitude\":112.7520883}},{\"id\":9784925,\"organization\":\"EDUCATION\",\"accreditation\":{\"inputStr\":\"\",\"matchStr\":\"\"},\"location\":{\"formatted\":\"Germany\",\"country\":\"Germany\",\"rawInput\":\"Germany\",\"countryCode\":\"DE\",\"latitude\":51.165691,\"longitude\":10.451526}},{\"id\":9784926,\"organization\":\"Australia\",\"accreditation\":{\"inputStr\":\"\",\"matchStr\":\"\"}}]',NULL,NULL,'[]','[{\"id\":98725269,\"emsiId\":\"KS122FL69C9376N0WS3D\",\"name\":\"Cosmetics\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725272,\"emsiId\":\"KS123X777H5WFNXQ6BPM\",\"name\":\"Sales\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725273,\"emsiId\":\"KS680KR72KH02C5GM5TY\",\"name\":\"Scheduling\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725275,\"emsiId\":\"KS120265WKHSMJ6HYX8P\",\"name\":\"Microsoft Windows\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Summary\"}]},{\"id\":98725276,\"emsiId\":\"KS120XP636CB5432F5TP\",\"name\":\"Telecommunications\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Summary\"}]},{\"id\":98725277,\"emsiId\":\"KS122K364PHRMJK84H46\",\"name\":\"Crystal Reports (Reporting Software)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Summary\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725279,\"emsiId\":\"KS4420B62MSJ581QJTY7\",\"name\":\"Web Intelligence\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725280,\"emsiId\":\"KS123MH78JSKSKNGJPP3\",\"name\":\"Equity Method\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725281,\"emsiId\":\"KS127ZG6DBSF76WF7VYX\",\"name\":\"Microsoft PowerPoint\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725283,\"emsiId\":\"KS1200365FTR9X0M96T9\",\"name\":\"Microsoft Word\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725284,\"emsiId\":\"KS1204B6FBVM6CXV6RDX\",\"name\":\"Depreciation\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725285,\"emsiId\":\"KS440SJ73G5RZYMLVKV7\",\"name\":\"Source (Game Engine)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725286,\"emsiId\":\"KS125B66VRYM8D0PT6J2\",\"name\":\"Inventory Turnover\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725287,\"emsiId\":\"KS120HK5XY6JV257QLTX\",\"name\":\"Budgeting\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Summary\"}]},{\"id\":98725288,\"emsiId\":\"KS122086PPY11B2M1G6N\",\"name\":\"Library\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725293,\"emsiId\":\"KS121XY6VSGJ3Z6J82FQ\",\"name\":\"Infrastructure\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725294,\"emsiId\":\"KS4408D6DYMSTKBP94N4\",\"name\":\"SAP CRM\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Summary\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725295,\"emsiId\":\"KS128F265DV4XTBR70H7\",\"name\":\"Real Estate\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Summary\"}]},{\"id\":98725298,\"emsiId\":\"KSUS9XM8DSF96YI9S2QY\",\"name\":\"Query Designer\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Summary\"}]},{\"id\":98725300,\"emsiId\":\"KS1218W78FGVPVP2KXPX\",\"name\":\"Management\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725301,\"emsiId\":\"KS127CH6C5XN5Y6B4126\",\"name\":\"Working Capital\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725302,\"emsiId\":\"KS1254G739VBXHP430DV\",\"name\":\"Information Management\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725303,\"emsiId\":\"KS123YJ6KVWC91BTMB4R\",\"name\":\"Financial Statements\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725305,\"emsiId\":\"KSIWI0KC7LJJOB1UUOPN\",\"name\":\"SAP BusinessObjects\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Summary\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725307,\"emsiId\":\"KS7G2KJ6SYXLHHSC3RC4\",\"name\":\"Business Development Company (BDC)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725309,\"emsiId\":\"KS1218L60PDVZX16NZT1\",\"name\":\"Dashboard\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725313,\"emsiId\":\"ESEB1D4619E6E83A061D\",\"name\":\"Planning\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Summary\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725314,\"emsiId\":\"KS122B071LMGXVTT3Z91\",\"name\":\"Consulting\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Summary\"}]},{\"id\":98725315,\"emsiId\":\"KS125716TLTGH6SDHJD1\",\"name\":\"Integration\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725318,\"emsiId\":\"KS4402175903S3CYQ6CK\",\"name\":\"Restructuring (Business)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725321,\"emsiId\":\"ESFB6F6182E69DA80843\",\"name\":\"Production Planning\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725268,\"emsiId\":\"KS4408479KK2CRZ06GYC\",\"name\":\"SAP ABAP\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725270,\"emsiId\":\"KS120W86KJ30NQJCQ3ZP\",\"name\":\"Balance Sheet\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725271,\"emsiId\":\"KS123NK6JJHH5LVPSZ4T\",\"name\":\"Estate Planning\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725274,\"emsiId\":\"KS1221X6165XMMSMM26F\",\"name\":\"Coal Mining\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725278,\"emsiId\":\"KS1241P6PXRCKTDSWHTV\",\"name\":\"Forecasting\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725282,\"emsiId\":\"KS4407L6GDCJ6V5MR7CN\",\"name\":\"Sales Planning\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725290,\"emsiId\":\"KS124DX6G31F5M9ZHNGC\",\"name\":\"Warehousing\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Summary\"}]},{\"id\":98725291,\"emsiId\":\"KS123TF6GHYX0KXK5LYZ\",\"name\":\"Fair Value\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725292,\"emsiId\":\"KS1202M5WG4B7X3VVF6Y\",\"name\":\"Advanced Business Application Programming (ABAP)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725296,\"emsiId\":\"KS7G34L6G8Q52CN7WNYB\",\"name\":\"BI Launch Pad (Software)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725297,\"emsiId\":\"KS1218Y74WJ6YV4KH0DM\",\"name\":\"Business Process\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725299,\"emsiId\":\"KS122PF6FZS3609GDG0V\",\"name\":\"Extract Transform Load (ETL)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725304,\"emsiId\":\"KS120ZX7019J4V8DHBTM\",\"name\":\"Business Intelligence\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Summary\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725306,\"emsiId\":\"KS120W2749QQKD4JMM68\",\"name\":\"Transformation (Genetics)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725308,\"emsiId\":\"KS122Q96S1LT3253TW3H\",\"name\":\"Data Warehousing\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Summary\"}]},{\"id\":98725310,\"emsiId\":\"KS126XY72XMMYBGMY9NR\",\"name\":\"Net Income\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725311,\"emsiId\":\"KS125XD6KD05NGCNJ67M\",\"name\":\"Live Reporting\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725312,\"emsiId\":\"KS7G0RD6WYFCX6NMLMHB\",\"name\":\"Staging\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725316,\"emsiId\":\"KS123CS6YTNDCKSB4Q8Z\",\"name\":\"Enterprise Information Management\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725317,\"emsiId\":\"KS7G7X55ZKBF0R0WCSZQ\",\"name\":\"Consolidation\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Summary\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725319,\"emsiId\":\"KS126LQ6ZKDQX58GZ0QF\",\"name\":\"Minority Interest\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725320,\"emsiId\":\"KS122W96W0FK6XTZ20W4\",\"name\":\"Development Planning\",\"type\":\"hard_skill\",\"sources\":[]}]','[\"Solution Consultant Certificate ID 0016099226\",\"Certified SAP BusinessObjects Business Intelligence BI Enterprise\",\"SAP ABAP Certificate of Achievement\",\"SAP BW Certificate of Achievement\",\"13 Training on designing modules for Budget Planning and Forecasting and\",\"14 Training on developing BPC Input Schedules Reports\",\"15 Training on setting up BPC Security User Team Task Profile Member\",\"16 Training on setting up BPC Work Status to lock data\",\"17 Training on setting up Business Process Flow BPF as a guided menu for\",\"18 Training on Script Logic and BAdI for BPC\"]','[]','[]',NULL,99,NULL,'ETNFqctA','d80729fa-3f46-4341-80e4-1f7a59c2d16f',1,'2023-01-25T15:25:46.740399Z',0,NULL,'en',NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'active','0AAD8'),(2,'2023-01-25 15:25:47',28,1,NULL,NULL,'Arie Wirawan Margono','Arie','Margono','Wirawan','','+6282111041805','http://www.sap.com/services/education/certification/certificationtest.epx','arie.margono@360consulting.co.id','1980-10-26',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','Indonesian, English',NULL,'',3,NULL,'[{\"id\":9784927,\"organization\":\"Monash University\",\"accreditation\":{\"education\":\"Master of Business\",\"educationLevel\":\"masters\",\"inputStr\":\"Master of Business Systems Professional\",\"matchStr\":\"\"},\"grade\":{\"raw\":\"Point Average (GPA) : 3.81 (out of 4.00)\",\"value\":\"3.81\",\"metric\":\"Point Average\"},\"location\":{\"formatted\":\"Melbourne VIC, Australia\",\"city\":\"Melbourne\",\"state\":\"Victoria\",\"country\":\"Australia\",\"rawInput\":\"Melbourne Victoria, Australia\",\"countryCode\":\"AU\",\"latitude\":-37.8136276,\"longitude\":144.9630576},\"dates\":{\"startDate\":\"2006-01-01\",\"completionDate\":\"2007-12-01\",\"isCurrent\":false}},{\"id\":9784928,\"organization\":\"Petra Christian University\",\"accreditation\":{\"education\":\"Bachelor of Science\",\"educationLevel\":\"bachelors\",\"inputStr\":\"Bachelor of Computer Science\",\"matchStr\":\"\"},\"grade\":{\"raw\":\"(GPA) : 3.77 (out of 4.00)\",\"value\":\"3.77\",\"metric\":\"GPA\"},\"location\":{\"formatted\":\"Surabaya, Surabaya City, East Java, Indonesia\",\"city\":\"Surabaya\",\"state\":\"East Java\",\"country\":\"Indonesia\",\"rawInput\":\"Surabaya East Java, Indonesia\",\"countryCode\":\"ID\",\"latitude\":-7.2574719,\"longitude\":112.7520883},\"dates\":{\"startDate\":\"1999-08-01\",\"completionDate\":\"2003-07-01\",\"isCurrent\":false}}]','Solution architect',NULL,'[{\"id\":18508742,\"jobTitle\":\"SAP BPC-BW-Dashboard Solution Architect\",\"organization\":\"Astra\",\"dates\":{\"startDate\":\"2019-12-01\",\"endDate\":\"2023-01-25\",\"monthsInPosition\":38,\"isCurrent\":true},\"jobDescription\":\"Responsibilities : \\n•Requirement analysis and system design, including preparation of Blueprint documentation for RKAP (Rencana Kerja \\u0026 Anggaran Perusahaan), Prognosa (Forecast), and PAJM (Proyeksi Anggaran Jangka Menengah with 5-years duration), for following Planning Areas: a. OPEX planning (including utilization of Activity-Based Costing method) b. HR Planning c. Revenue \\u0026 Other Cost Planning d. Budget Revision \\u0026 Re-Allocation e. Cashflow Forecasting f. Budget Monitoring \\u0026 Control g. Financial Statements planning (Balance Sheet, Profit \\u0026 Loss, Cashflow) \\n•Requirement analysis and system design for dashboards, including preparation of Blueprint documentation, covering dashboards from following areas: a. Dashboard Revenue \\u0026 Expenditures Performance b. Dashboard Expense Detail c. Dashboard Collection / Receivables d. Dashboard Expenses Per Activity OJK Wide e. Dashboard Budget Realization by Division \\u0026 Working Unit (aka Satuan Kerja (Satker)) f. Dashboard EWS (Early Warning System) as follows: 1. Fixed Asset 2. Business Trip 3. Cash Advance 4. Debt 5. Budget Transfer across Activities g. Dashboard Budget Revision h. Dashboard Financial \\n•Design and set up of BW ETL objects (Extraction, Transformation, Loading) to load from SAP S/4 HANA to BW for Dashboard \\u0026 BPC \\n•Design and set up BPC Input Schedules \\u0026 Reports for Input Data \\u0026 Reporting \\n•Design and set up BPF (Business Process Flow) for workflow, linking all tasks required to be done in sequential manner \\n•Design and set up BPC Security (User, Team, Task Profile, Member Access Profile). \\n•Conducting user training. \\n•Unit Testing, preparation of UAT script, troubleshooting and bug-fixing during UAT (User Acceptance Testing). \\n•Writing final functional-technical documentation. \\n•Post Go-Live on-site support Project : Implementation for SAP BW for Group Tax Report Client : PT Astra International, Tbk - Indonesia Astra International was established in 1957, is a large and well-known group of companies in Indonesia, which operates in the following business segments: Automotive, Financial Services, Heavy Industry, Mining, Construction \\u0026 Energy, Agrobusiness, Infrastructure \\u0026 Logistic, Information Technology, Property. At the end of 2018, Astra International Group has 229 Subsidiaries, Joint Ventures and Associates, which in total employ 224,488 employees \",\"occupation\":{\"jobTitle\":\"SAP BPC-BW-Dashboard Solution Architect\",\"jobTitleNormalized\":\"SAP BW Architect\",\"managementLevel\":\"Low\"}}]','[{\"id\":98725323,\"emsiId\":\"KS122K364PHRMJK84H46\",\"name\":\"Crystal Reports (Reporting Software)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725327,\"emsiId\":\"KS1217R6SMDJ0WQHN6LK\",\"name\":\"Construction\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725331,\"emsiId\":\"KS1218W78FGVPVP2KXPX\",\"name\":\"Management\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725334,\"emsiId\":\"KS1202P6S8HY0WGG2T0Z\",\"name\":\"Activity-Based Costing\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725336,\"emsiId\":\"KS126Z06HW8YB5PM0JXL\",\"name\":\"Networking Basics\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725337,\"emsiId\":\"KS123YJ6KVWC91BTMB4R\",\"name\":\"Financial Statements\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725339,\"emsiId\":\"KSBACVV6XBM187ND3YP9\",\"name\":\"Enterprise Portal\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725340,\"emsiId\":\"KS441K2756CXYXBG990G\",\"name\":\"Troubleshooting (Problem Solving)\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725342,\"emsiId\":\"KS1287R64YNBZGR50Y1N\",\"name\":\"Purchasing\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725345,\"emsiId\":\"KS125716TLTGH6SDHJD1\",\"name\":\"Integration\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725347,\"emsiId\":\"KS1203W702ND09XHKJR5\",\"name\":\"Accounting\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725349,\"emsiId\":\"KS120BG6ZM1GMLSN3RN2\",\"name\":\"Agribusiness\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725350,\"emsiId\":\"KS1282Z69X0BW8CXTPXH\",\"name\":\"Production Systems\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725352,\"emsiId\":\"KS4420B62MSJ581QJTY7\",\"name\":\"Web Intelligence\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725353,\"emsiId\":\"KS127ZG6DBSF76WF7VYX\",\"name\":\"Microsoft PowerPoint\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725354,\"emsiId\":\"KS1200365FTR9X0M96T9\",\"name\":\"Microsoft Word\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725355,\"emsiId\":\"KS4425C7820LCHZS7VGX\",\"name\":\"Writing\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725356,\"emsiId\":\"ESB4C707E98B551DE4A2\",\"name\":\"Variance Analysis\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725357,\"emsiId\":\"KSPKPXOKV8TQIZVTYC7I\",\"name\":\"Heavy Industry\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725360,\"emsiId\":\"KS122PM76DCYL9WC89Y7\",\"name\":\"Data Modeling\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725362,\"emsiId\":\"KS122556LMQ829GZCCRV\",\"name\":\"Communications\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725365,\"emsiId\":\"KS440GC6JXTJ6G11QFF1\",\"name\":\"Sensitivity Analysis\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725368,\"emsiId\":\"KS441JM6PR848J3HYJDK\",\"name\":\"Trial Balance\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725372,\"emsiId\":\"ESEB1D4619E6E83A061D\",\"name\":\"Planning\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Training/Certifications\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725373,\"emsiId\":\"KS122B071LMGXVTT3Z91\",\"name\":\"Consulting\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Achievements\"},{\"section\":\"PersonalDetails\"}]},{\"id\":98725375,\"emsiId\":\"KS1225K67C74NWDXNJSL\",\"name\":\"Community Development\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725377,\"emsiId\":\"KS680KR72KH02C5GM5TY\",\"name\":\"Scheduling\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725378,\"emsiId\":\"KS440SJ73G5RZYMLVKV7\",\"name\":\"Source (Game Engine)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725380,\"emsiId\":\"ESFB6F6182E69DA80843\",\"name\":\"Production Planning\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725382,\"emsiId\":\"KS123X777H5WFNXQ6BPM\",\"name\":\"Sales\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725384,\"emsiId\":\"KS120HK5XY6JV257QLTX\",\"name\":\"Budgeting\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725385,\"emsiId\":\"KS122086PPY11B2M1G6N\",\"name\":\"Library\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725386,\"emsiId\":\"KS120GV5ZXR64CJLL1J4\",\"name\":\"Analytics\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725388,\"emsiId\":\"KS122J96Z72S4MNP021Z\",\"name\":\"Critical Path Method (CPM) Scheduling\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Achievements\"}]},{\"id\":98725389,\"emsiId\":\"KS4408D6DYMSTKBP94N4\",\"name\":\"SAP CRM\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Achievements\"},{\"section\":\"PersonalDetails\"},{\"section\":\"Projects\"},{\"section\":\"Training/Certifications\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725390,\"emsiId\":\"KSUS9XM8DSF96YI9S2QY\",\"name\":\"Query Designer\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725392,\"emsiId\":\"KS123Q76HP7VYGN828DQ\",\"name\":\"Exchange Web Services (EWS)\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725393,\"emsiId\":\"KSIWI0KC7LJJOB1UUOPN\",\"name\":\"SAP BusinessObjects\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725394,\"emsiId\":\"KS1218L60PDVZX16NZT1\",\"name\":\"Dashboard\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Training/Certifications\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725395,\"emsiId\":\"KS1200H6XYN1CR0G5NZ0\",\"name\":\"Microsoft Excel\",\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725396,\"emsiId\":\"KS1265P60HXFPH0VLFVP\",\"name\":\"Marketing Planning\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725397,\"emsiId\":\"KSBLWK2MV120ZA9RXZZA\",\"name\":\"Aluminum\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725401,\"emsiId\":\"KS121XY6VSGJ3Z6J82FQ\",\"name\":\"Infrastructure\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725402,\"emsiId\":\"KS120SX72T8B5VLXS1VN\",\"name\":\"Unit Testing\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725404,\"emsiId\":\"KS1254G739VBXHP430DV\",\"name\":\"Information Management\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725322,\"emsiId\":\"KS127H05WDKJ5BPKWVH2\",\"name\":\"Outsourcing\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725324,\"emsiId\":\"KS122626T550SLQ7QZ1C\",\"name\":\"Procurement\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725325,\"emsiId\":\"KS7G24169Z487XMD80CY\",\"name\":\"Lifecycle Management\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725326,\"emsiId\":\"KS127NP6PY9GM1BTM9V9\",\"name\":\"Pension Funds\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725328,\"emsiId\":\"KS7G34L6G8Q52CN7WNYB\",\"name\":\"BI Launch Pad (Software)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725329,\"emsiId\":\"KS1218Y74WJ6YV4KH0DM\",\"name\":\"Business Process\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Achievements\"},{\"section\":\"Training/Certifications\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725330,\"emsiId\":\"KS123ZJ5X02D3GL6CNQT\",\"name\":\"Fixed Asset\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725332,\"emsiId\":\"KS122PG64BT2BT6X15HF\",\"name\":\"Data Management\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725333,\"emsiId\":\"KS686Y976L1WJ98QFSD4\",\"name\":\"Authorization (Computing)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725335,\"emsiId\":\"KS441RD6NRHRTH3K7RCB\",\"name\":\"Visual Basic For Applications\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725338,\"emsiId\":\"KS126YT5ZTJ1MF8NDP4M\",\"name\":\"SAP NetWeaver\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725341,\"emsiId\":\"KS1219B681X3J9MK0KPH\",\"name\":\"Business Systems\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Achievements\"}]},{\"id\":98725343,\"emsiId\":\"KS126XY72XMMYBGMY9NR\",\"name\":\"Net Income\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725344,\"emsiId\":\"KS125XD6KD05NGCNJ67M\",\"name\":\"Live Reporting\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725346,\"emsiId\":\"KS7G7X55ZKBF0R0WCSZQ\",\"name\":\"Consolidation\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725348,\"emsiId\":\"KS4408479KK2CRZ06GYC\",\"name\":\"SAP ABAP\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Achievements\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725351,\"emsiId\":\"KS1241P6PXRCKTDSWHTV\",\"name\":\"Forecasting\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725358,\"emsiId\":\"KS1202M5WG4B7X3VVF6Y\",\"name\":\"Advanced Business Application Programming (ABAP)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"Achievements\"},{\"section\":\"Training/Certifications\"}]},{\"id\":98725359,\"emsiId\":\"KS1281Z6YSCYDNCG1D8T\",\"name\":\"Process Design\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Achievements\"}]},{\"id\":98725363,\"emsiId\":\"KS125KC6WBFJFHX7DH12\",\"name\":\"Joint Ventures\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725364,\"emsiId\":\"KS123Y56VDHMZ288XX1W\",\"name\":\"Financial Accounting\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725366,\"emsiId\":\"KS1227V6WBR3BH3SJYSZ\",\"name\":\"Information Technology\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"soft_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725367,\"emsiId\":\"KS123226LLZPHTR6L2RN\",\"name\":\"Distribution System Operators (DSO)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725369,\"emsiId\":\"KS120W2749QQKD4JMM68\",\"name\":\"Transformation (Genetics)\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725370,\"emsiId\":\"KS7G0RD6WYFCX6NMLMHB\",\"name\":\"Staging\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725371,\"emsiId\":\"KS1277F6C7QNT6S8QB0N\",\"name\":\"Occupational Health And Safety Management System (OHSAS)\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725374,\"emsiId\":\"KS123CS6YTNDCKSB4Q8Z\",\"name\":\"Enterprise Information Management\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725376,\"emsiId\":\"KS126LQ6ZKDQX58GZ0QF\",\"name\":\"Minority Interest\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725379,\"emsiId\":\"KS123Y170CZM0V5Z3XXB\",\"name\":\"Financial Services\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725381,\"emsiId\":\"KS120W86KJ30NQJCQ3ZP\",\"name\":\"Balance Sheet\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725387,\"emsiId\":\"KS1238D6ZKKXT9GPCZK8\",\"name\":\"Web Dynpro\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Achievements\"}]},{\"id\":98725391,\"emsiId\":\"KS120ZX7019J4V8DHBTM\",\"name\":\"Business Intelligence\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"}]},{\"id\":98725398,\"emsiId\":\"KS7G27Y6XMZTKKSN6VCG\",\"name\":\"Receivables\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]},{\"id\":98725399,\"emsiId\":\"KS1226Y6DNDT05G7FJ4J\",\"name\":\"Computer Science\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Achievements\"}]},{\"id\":98725400,\"emsiId\":\"KS4407L6GDCJ6V5MR7CN\",\"name\":\"Sales Planning\",\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"}]},{\"id\":98725403,\"emsiId\":\"KS122PF6FZS3609GDG0V\",\"name\":\"Extract Transform Load (ETL)\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":38,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Projects\"},{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508742}]}]','[\"Courses completed\",\"Full Time Intensive English Training\",\"Indonesia Australia Language Foundation IALF\",\"Feb 2010 SAP Certified Application Associate Business Intelligence with\",\"SAP NetWeaver 7 0 SAP Official Certification\",\"Certificate ID 0005065369\",\"Note Certificate and Exam Result in Appendix D Normally exam\",\"I got exemption to take only the certification exam without undertaking\",\"Oct 2011 Certified SAP BusinessObjects 4 0 Business Intelligence BI\",\"Note Certificate in Appendix E\",\"Oct 2011 Certified SAP BusinessObjects Planning Consolidation BPC\",\"Note Certificate in Appendix F\",\"Aug 2007 SAP BW Certificate of Achievement\",\"Note Certificate attached in Appendix G\",\"Dec 2007 SAP ABAP Certificate of Achievement\",\"Note Certificate attached in Appendix H\",\"Feb 2004 Dec 2004 Cisco Networking Academy Program CNAP\"]','[]','[]',NULL,99,NULL,'ZTWiJsmH','c0290f8f-3d7c-47f3-9770-1ad3edafedf7',1,'2023-01-25T15:25:47.783303Z',0,NULL,'en',NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'active','XAQL4'),(3,'2023-01-25 15:25:50',28,1,NULL,NULL,'ACHMAD AMRI AYUBUH ANSYORI','Achmad','Ansyori','Amri Ayubuh','','+6281380782318','','','1981-08-19','127 c, Jl. Kayuringin Jaya No.13, RT.001/RW.017, Kayuringin Jaya, Kec. Bekasi Sel., Kota Bks, Jawa Barat 17144, Indonesia','17144','Jawa Barat','Indonesia','ID','Jl. Gunung Gede V No 127 C. Rt.04/Rw.13 Kayuringin Jaya. Bekasi - Jawa Barat.','13','Jalan Kayuringin Jaya','127 c',NULL,'','English',NULL,'',12,NULL,'[{\"id\":9784933,\"organization\":\"Fakultas Ilmu Komputer Universitas Gunadarma\",\"accreditation\":{\"education\":\"Manajemen Informatika,\",\"inputStr\":\"Manajemen Informatika,\",\"matchStr\":\"\"},\"dates\":{\"completionDate\":\"2006-01-01\",\"isCurrent\":false}},{\"id\":9784934,\"organization\":\"Teknik Informatika, MDP\",\"accreditation\":{\"inputStr\":\"\",\"matchStr\":\"\"},\"location\":{\"formatted\":\"Palembang, Palembang City, South Sumatra, Indonesia\",\"city\":\"Palembang\",\"state\":\"South Sumatra\",\"country\":\"Indonesia\",\"rawInput\":\"Palembang,\",\"countryCode\":\"ID\",\"latitude\":-2.9760735,\"longitude\":104.7754307},\"dates\":{\"completionDate\":\"2000-01-01\",\"isCurrent\":false}},{\"id\":9784935,\"organization\":\"PALEMBANG\",\"accreditation\":{\"education\":\"SMAN 10\",\"inputStr\":\"SMAN 10\",\"matchStr\":\"\"},\"dates\":{\"completionDate\":\"1999-01-01\",\"isCurrent\":false}},{\"id\":9784936,\"organization\":\"PALEMBANG\",\"accreditation\":{\"education\":\"SMPN 1\",\"inputStr\":\"SMPN 1\",\"matchStr\":\"\"},\"dates\":{\"completionDate\":\"1993-01-01\",\"isCurrent\":false}}]','Senior Platform Developer',NULL,'[{\"id\":18508758,\"jobTitle\":\"Founder, Director, eCommerce Implementation Consultant\",\"organization\":\"PT. BTECHNO SOLUSI DIGITAL\",\"dates\":{\"startDate\":\"2021-06-01\",\"endDate\":\"2023-01-25\",\"monthsInPosition\":20,\"isCurrent\":true},\"jobDescription\":\"Project based consultant on various projects from private and government owned company : PT Rajawali Berdikari Indonesia Attendance Application PT. Tiga Global Sejahtera Distribution Management System https://dms.id-trec.com PT Kustodian Sentral Efek Indonesia (KSEI) Revamp GUI for S-Invest Latest technology and/or Methodology that were deployed: Vaadin Angular \",\"occupation\":{\"jobTitle\":\"Founder, Director, eCommerce Implementation Consultant\"}},{\"id\":18508759,\"jobTitle\":\"Senior Manager Platform Development\",\"organization\":\"PT. Sumber Trijaya Lestari (alfacart.com)\",\"dates\":{\"startDate\":\"2016-01-01\",\"endDate\":\"2021-03-01\",\"monthsInPosition\":62,\"isCurrent\":false},\"jobDescription\":\"direct report to VP / Head of IT Managing and mentoring development team in all activities from assessment, pre development strategy, development phase, deployment rollout, and post deployment. Leading development team to delivery ecommerce microservices based applications for both frontend and backend. Technology and/or Methodology that were deployed: Ubuntu Desktop, Ubuntu Server, Centos, Microsoft Windows, Microsoft Project, Microsoft Power point, Microsoft Word, Php, J2EE, Oracle Service Bus, Oracle Database, PostgreSQL Database, MySQL Database, Magento Enterprise, SOLR, Java JAX-WS, Java JAX-RS, Google Web Toolkit, Apache Tomcat, Oracle Weblogic, Code Igniter, Bootstrap, SVN, JIRA, Confluence, Google Cloud Platform, Amazon Web Services, MongoDB, Redis, Kubernetes, Kafka, Confluent, Spring Boot, Machine Learning (Weka, Rapidminer). \",\"occupation\":{\"jobTitle\":\"Senior Manager Platform Development\",\"jobTitleNormalized\":\"Platform Development Manager\",\"managementLevel\":\"Mid\"}},{\"id\":18508760,\"jobTitle\":\"Senior Manager Backend Developer\",\"organization\":\"PT. XL Planet (elevenia.co.id)\",\"dates\":{\"startDate\":\"2014-01-01\",\"endDate\":\"2015-12-01\",\"monthsInPosition\":23,\"isCurrent\":false},\"jobDescription\":\"Having responsibilities for giving assessment of possibilities, options, and schedule for task and giving directions, strategies, and guidance to team for completing the task based on team load and team capacity. Technology and/or Methodology that were deployed: Microsoft Power point, Microsoft Word, J2EE, Oracle Database, SQL Developer, Apache Tomcat, Oracle Weblogic. \",\"occupation\":{\"jobTitle\":\"Senior Manager Backend Developer\",\"jobTitleNormalized\":\"Drupal Backend Developer\",\"classification\":{\"socCode\":2134,\"title\":\"Programmers and software development professionals \",\"minorGroup\":\"Information Technology Professionals\",\"subMajorGroup\":\"SCIENCE, RESEARCH, ENGINEERING AND TECHNOLOGY PROFESSIONALS\",\"majorGroup\":\"PROFESSIONAL OCCUPATIONS\"},\"managementLevel\":\"Low\"}},{\"id\":18508761,\"jobTitle\":\"Technical Consultant\",\"organization\":\"PT Mitra Integrasi Informatika\",\"dates\":{\"startDate\":\"2010-11-01\",\"endDate\":\"2013-12-01\",\"monthsInPosition\":37,\"isCurrent\":false},\"jobDescription\":\"Extending, design and deliver KPEI Middleware, as a backbone for KPEI day to day operational process. Design phase: Gathering requirement and coordinate with multiple application vendors to provide SOA design. Create Project Plan, High Level Requirement, Business Proposal, and Document Design. Deliver phase: In charge with weekly Progress Meeting to update user with the latest condition of project, also with risks and issues arise within accomplished week. Deliver service according with business specification. Support phase: Give assessment with any Change Request, if exists. Bug fixing. Technology and/or Methodology that were deployed: Microsoft Word, Microsoft Project, Microsoft Excel, C++, J2EE, Oracle Database, MySQL Database, SQL Developer, Toad for MySQL, Apache Tomcat, Oracle Weblogic, Oracle SOA Suite. \",\"occupation\":{\"jobTitle\":\"Technical Consultant\",\"jobTitleNormalized\":\"Technical Consultant\",\"classification\":{\"socCode\":2139,\"title\":\"Information technology professionals n.e.c.\",\"minorGroup\":\"Information Technology Professionals\",\"subMajorGroup\":\"SCIENCE, RESEARCH, ENGINEERING AND TECHNOLOGY PROFESSIONALS\",\"majorGroup\":\"PROFESSIONAL OCCUPATIONS\"},\"managementLevel\":\"Low\"}}]','[{\"id\":98725455,\"emsiId\":\"KS120265WKHSMJ6HYX8P\",\"name\":\"Microsoft Windows\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"soft_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725456,\"emsiId\":\"KS1200C5XQWW78VQ5ZYL\",\"name\":\"PHP (Scripting Language)\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"},{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725457,\"emsiId\":\"ES6D557B9D5BE598FD74\",\"name\":\"Spring Boot\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725458,\"emsiId\":\"KS120076FGP5WGWYMP0F\",\"name\":\"Java (Programming Language)\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725460,\"emsiId\":\"KS121KB68PWHRPJCJKQJ\",\"name\":\"CentOS\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725461,\"emsiId\":\"KS120QQ6ZN003B8B7FK1\",\"name\":\"JIRA\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725463,\"emsiId\":\"KS1200H6XYN1CR0G5NZ0\",\"name\":\"Microsoft Excel\",\"lastUsed\":\"2013-12-01\",\"numberOfMonths\":37,\"type\":\"soft_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":3,\"workExperienceId\":18508761}]},{\"id\":98725464,\"emsiId\":\"KS441Q56Y88HLXDMHM4Y\",\"name\":\"Vaadin\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":20,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508758}]},{\"id\":98725466,\"emsiId\":\"KS7G3YQ62YJG4LX9QFZT\",\"name\":\"Google Cloud\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725467,\"emsiId\":\"KS440W865GC4VRBW6LJP\",\"name\":\"SQL (Programming Language)\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":122,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"},{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759},{\"section\":\"WorkExperience\",\"position\":2,\"workExperienceId\":18508760},{\"section\":\"WorkExperience\",\"position\":3,\"workExperienceId\":18508761}]},{\"id\":98725468,\"emsiId\":\"KS1214R5XG4X4PY7LGY6\",\"name\":\"Bootstrap (Front-End Framework)\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725470,\"emsiId\":\"KS123KG6DL8N3D5ZW036\",\"name\":\"Java Platform Enterprise Edition (J2EE)\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":122,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759},{\"section\":\"WorkExperience\",\"position\":2,\"workExperienceId\":18508760},{\"section\":\"WorkExperience\",\"position\":3,\"workExperienceId\":18508761}]},{\"id\":98725473,\"emsiId\":\"KSJF3PBD3995K6E0OF1Z\",\"name\":\"Kubernetes\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725474,\"emsiId\":\"KSN97GEUHPNGNAQFDCGY\",\"name\":\"Apache Kafka\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725475,\"emsiId\":\"KSZX7YZWNR5IDR1I2VMZ\",\"name\":\"Microservices\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725476,\"emsiId\":\"KS1218W78FGVPVP2KXPX\",\"name\":\"Management\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":20,\"type\":\"soft_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508758}]},{\"id\":98725477,\"emsiId\":\"KS120H6772VQ0MQ5RLVD\",\"name\":\"Angular (Web Framework)\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":20,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508758}]},{\"id\":98725478,\"emsiId\":\"KS441S66KZY7LM20RKYN\",\"name\":\"Software Versioning\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725479,\"emsiId\":\"KS4420H75G906GRK0QJZ\",\"name\":\"Web Services\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725481,\"emsiId\":\"KS126PF6PJY1N0ZX5R0P\",\"name\":\"MongoDB\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725483,\"emsiId\":\"KS1200365FTR9X0M96T9\",\"name\":\"Microsoft Word\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":122,\"type\":\"soft_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759},{\"section\":\"WorkExperience\",\"position\":2,\"workExperienceId\":18508760},{\"section\":\"WorkExperience\",\"position\":3,\"workExperienceId\":18508761}]},{\"id\":98725485,\"emsiId\":\"KS1261Z68KSKR1X31KS3\",\"name\":\"Machine Learning\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725486,\"emsiId\":\"KS120FG6YP8PQYYNQY9B\",\"name\":\"Amazon Web Services\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725487,\"emsiId\":\"KS126QY605N7YVHFYCTW\",\"name\":\"MySQL\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":99,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"Training/Certifications\"},{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759},{\"section\":\"WorkExperience\",\"position\":3,\"workExperienceId\":18508761}]},{\"id\":98725488,\"emsiId\":\"KSFS12Z1D00MRUX8Z7E8\",\"name\":\"Magento\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725490,\"emsiId\":\"KS4421N62QZJ2NZ9QJY7\",\"name\":\"Weka\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725491,\"emsiId\":\"KS120JM6ZKSY0Q8PJ7WT\",\"name\":\"Apache Tomcat\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":122,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759},{\"section\":\"WorkExperience\",\"position\":2,\"workExperienceId\":18508760},{\"section\":\"WorkExperience\",\"position\":3,\"workExperienceId\":18508761}]},{\"id\":98725492,\"emsiId\":\"KS126J46GGVZB8BGGXSY\",\"name\":\"Microsoft Project\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":99,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759},{\"section\":\"WorkExperience\",\"position\":3,\"workExperienceId\":18508761}]},{\"id\":98725459,\"emsiId\":\"KSCWA6GA1Q87T9ASI1UL\",\"name\":\"Rajawali\",\"lastUsed\":\"2023-01-25\",\"numberOfMonths\":20,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":0,\"workExperienceId\":18508758}]},{\"id\":98725462,\"emsiId\":\"KS121T56Q1CL65W06BJ5\",\"name\":\"Change Request\",\"lastUsed\":\"2013-12-01\",\"numberOfMonths\":37,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":3,\"workExperienceId\":18508761}]},{\"id\":98725465,\"emsiId\":\"KS1QEK3F0I7319NUW1TJ\",\"name\":\"Oracle Service Bus\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725469,\"emsiId\":\"KS128G66RG96FZNHFCXY\",\"name\":\"Redis\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725471,\"emsiId\":\"KS128D367HP9RPXPGSM7\",\"name\":\"RapidMiner\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725472,\"emsiId\":\"KS123GK5WYFRJ4L20YK2\",\"name\":\"Middleware\",\"lastUsed\":\"2013-12-01\",\"numberOfMonths\":37,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":3,\"workExperienceId\":18508761}]},{\"id\":98725480,\"emsiId\":\"KS121CF62WFJ19GK02H7\",\"name\":\"Ubuntu (Operating System)\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725482,\"emsiId\":\"KS125TB6YR6236RKM563\",\"name\":\"PostgreSQL\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725484,\"emsiId\":\"KSIJ33GROZ22YMYACXRW\",\"name\":\"JAX-WS\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]},{\"id\":98725489,\"emsiId\":\"ESC7869CF7378283E0AA\",\"name\":\"Google Cloud Platform (GCP)\",\"lastUsed\":\"2021-03-01\",\"numberOfMonths\":62,\"type\":\"hard_skill\",\"sources\":[{\"section\":\"WorkExperience\",\"position\":1,\"workExperienceId\":18508759}]}]','[]','[]','[]',NULL,99,NULL,'yXLirDoA','43d1d23d-16a8-4cfd-8099-d71e3b6892dd',1,'2023-01-25T15:25:50.818306Z',0,NULL,'en',NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'active','GKQOF');
/*!40000 ALTER TABLE `tb_resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_resume_certification`
--

DROP TABLE IF EXISTS `tb_resume_certification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_resume_certification` (
  `tbrc_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbrc_create_date` datetime DEFAULT NULL,
  `tbrc_create_id` int(11) DEFAULT NULL,
  `tbrc_create_idc` int(11) DEFAULT NULL,
  `tbrc_update_date` datetime DEFAULT NULL,
  `tbrc_update_id` int(11) DEFAULT NULL,
  `tbr_id` int(11) DEFAULT NULL,
  `tbrc_name` varchar(255) DEFAULT NULL,
  `tbrc_status` varchar(20) DEFAULT NULL,
  `tbrc_uuid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tbrc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume_certification`
--

LOCK TABLES `tb_resume_certification` WRITE;
/*!40000 ALTER TABLE `tb_resume_certification` DISABLE KEYS */;
INSERT INTO `tb_resume_certification` VALUES (1,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Solution Consultant Certificate ID 0016099226','active','LVFQS'),(2,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Certified SAP BusinessObjects Business Intelligence BI Enterprise','active','TVI9Z'),(3,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'SAP ABAP Certificate of Achievement','active','L5Q88'),(4,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'SAP BW Certificate of Achievement','active','UJWB1'),(5,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'13 Training on designing modules for Budget Planning and Forecasting and','active','Y8CST'),(6,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'14 Training on developing BPC Input Schedules Reports','active','3XOT8'),(7,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'15 Training on setting up BPC Security User Team Task Profile Member','active','65HT3'),(8,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'16 Training on setting up BPC Work Status to lock data','active','PLSTB'),(9,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'17 Training on setting up Business Process Flow BPF as a guided menu for','active','9XDIS'),(10,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'18 Training on Script Logic and BAdI for BPC','active','JH7HG'),(11,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Courses completed','active','XVJEI'),(12,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Full Time Intensive English Training','active','6XRF6'),(13,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Indonesia Australia Language Foundation IALF','active','VWWZ3'),(14,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Feb 2010 SAP Certified Application Associate Business Intelligence with','active','P6D4V'),(15,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'SAP NetWeaver 7 0 SAP Official Certification','active','RKJC0'),(16,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Certificate ID 0005065369','active','2T3OS'),(17,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Note Certificate and Exam Result in Appendix D Normally exam','active','PR33K'),(18,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'I got exemption to take only the certification exam without undertaking','active','31KRY'),(19,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Oct 2011 Certified SAP BusinessObjects 4 0 Business Intelligence BI','active','HKUSH'),(20,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Note Certificate in Appendix E','active','5J2RG'),(21,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Oct 2011 Certified SAP BusinessObjects Planning Consolidation BPC','active','6NM48'),(22,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Note Certificate in Appendix F','active','TM867'),(23,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Aug 2007 SAP BW Certificate of Achievement','active','ZFZZ0'),(24,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Note Certificate attached in Appendix G','active','C2B7I'),(25,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Dec 2007 SAP ABAP Certificate of Achievement','active','ICR27'),(26,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Note Certificate attached in Appendix H','active','248CL'),(27,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Feb 2004 Dec 2004 Cisco Networking Academy Program CNAP','active','U4EV4');
/*!40000 ALTER TABLE `tb_resume_certification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_resume_education`
--

DROP TABLE IF EXISTS `tb_resume_education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_resume_education` (
  `tbre_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbre_create_date` datetime DEFAULT NULL,
  `tbre_create_id` int(11) DEFAULT NULL,
  `tbre_create_idc` int(11) DEFAULT NULL,
  `tbre_update_date` datetime DEFAULT NULL,
  `tbre_update_id` int(11) DEFAULT NULL,
  `tbr_id` int(11) DEFAULT NULL,
  `tbre_organization` varchar(255) DEFAULT NULL,
  `tbre_education` varchar(255) DEFAULT NULL,
  `tbre_education_level` varchar(255) DEFAULT NULL,
  `tbre_input_str` varchar(255) DEFAULT NULL,
  `tbre_match_str` varchar(255) DEFAULT NULL,
  `tbre_grade_raw` varchar(255) DEFAULT NULL,
  `tbre_grade_value` varchar(255) DEFAULT NULL,
  `tbre_grade_metric` varchar(255) DEFAULT NULL,
  `tbre_location_formatted` varchar(255) DEFAULT NULL,
  `tbre_location_city` varchar(255) DEFAULT NULL,
  `tbre_location_state` varchar(255) DEFAULT NULL,
  `tbre_location_country` varchar(255) DEFAULT NULL,
  `tbre_location_raw_input` varchar(255) DEFAULT NULL,
  `tbre_location_country_code` varchar(255) DEFAULT NULL,
  `tbre_location_latitude` varchar(255) DEFAULT NULL,
  `tbre_location_longitude` varchar(255) DEFAULT NULL,
  `tbre_start_date` datetime DEFAULT NULL,
  `tbre_completion_date` datetime DEFAULT NULL,
  `tbre_is_current` varchar(20) DEFAULT NULL,
  `tbre_status` varchar(20) DEFAULT NULL,
  `tbre_uuid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tbre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume_education`
--

LOCK TABLES `tb_resume_education` WRITE;
/*!40000 ALTER TABLE `tb_resume_education` DISABLE KEYS */;
INSERT INTO `tb_resume_education` VALUES (1,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Monash University','Master of Business','masters','MASTER OF BUSINESS SYSTEMS PROFESSIONAL','','GPA : 3.81 OUT OF 4.00','3.81','GPA','Melbourne VIC, Australia','Melbourne','Victoria','Australia','MELBOURNE, AUSTRALIA.','AU','-37.8136276','144.9630576',NULL,NULL,NULL,'active','E5BBS'),(2,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'SEKOLAH TINGGI TEKNIK SURABAYA (STTS) UNIVERSITY','Bachelor of Science','bachelors','BACHELOR OF COMPUTER SCIENCE','','GPA : 3.88 OUT OF 4.00','3.88','GPA','Surabaya, Surabaya City, East Java, Indonesia','Surabaya','East Java','Indonesia','SURABAYA, INDONESIA.','ID','-7.2574719','112.7520883',NULL,NULL,NULL,'active','GWBZO'),(3,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'EDUCATION',NULL,NULL,'','',NULL,NULL,NULL,'Germany',NULL,NULL,'Germany','Germany','DE','51.165691','10.451526',NULL,NULL,NULL,'active','5GGN8'),(4,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Australia',NULL,NULL,'','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','VTDAO'),(5,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Monash University','Master of Business','masters','Master of Business Systems Professional','','Point Average (GPA) : 3.81 (out of 4.00)','3.81','Point Average','Melbourne VIC, Australia','Melbourne','Victoria','Australia','Melbourne Victoria, Australia','AU','-37.8136276','144.9630576',NULL,NULL,NULL,'active','9TCB7'),(6,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Petra Christian University','Bachelor of Science','bachelors','Bachelor of Computer Science','','(GPA) : 3.77 (out of 4.00)','3.77','GPA','Surabaya, Surabaya City, East Java, Indonesia','Surabaya','East Java','Indonesia','Surabaya East Java, Indonesia','ID','-7.2574719','112.7520883',NULL,NULL,NULL,'active','VN018'),(7,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Fakultas Ilmu Komputer Universitas Gunadarma','Manajemen Informatika,',NULL,'Manajemen Informatika,','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','A047Y'),(8,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Teknik Informatika, MDP',NULL,NULL,'','',NULL,NULL,NULL,'Palembang, Palembang City, South Sumatra, Indonesia','Palembang','South Sumatra','Indonesia','Palembang,','ID','-2.9760735','104.7754307',NULL,NULL,NULL,'active','6U8XK'),(9,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'PALEMBANG','SMAN 10',NULL,'SMAN 10','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','9J3FF'),(10,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'PALEMBANG','SMPN 1',NULL,'SMPN 1','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','QTQZB');
/*!40000 ALTER TABLE `tb_resume_education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_resume_skill`
--

DROP TABLE IF EXISTS `tb_resume_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_resume_skill` (
  `tbrs_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbrs_create_date` datetime DEFAULT NULL,
  `tbrs_create_id` int(11) DEFAULT NULL,
  `tbrs_create_idc` int(11) DEFAULT NULL,
  `tbrs_update_date` datetime DEFAULT NULL,
  `tbrs_update_id` int(11) DEFAULT NULL,
  `tbr_id` int(11) DEFAULT NULL,
  `tbrs_name` varchar(255) DEFAULT NULL,
  `tbrs_last_used` datetime DEFAULT NULL,
  `tbrs_number_of_months` int(11) DEFAULT NULL,
  `tbrs_type` varchar(255) DEFAULT NULL,
  `tbrs_status` varchar(20) DEFAULT NULL,
  `tbrs_uuid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tbrs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume_skill`
--

LOCK TABLES `tb_resume_skill` WRITE;
/*!40000 ALTER TABLE `tb_resume_skill` DISABLE KEYS */;
INSERT INTO `tb_resume_skill` VALUES (1,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Cosmetics',NULL,NULL,'hard_skill','active','5A3CM'),(2,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Sales',NULL,NULL,'soft_skill','active','AMOY6'),(3,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Scheduling',NULL,NULL,'soft_skill','active','AAU3I'),(4,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Microsoft Windows',NULL,NULL,'soft_skill','active','8ASNB'),(5,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Telecommunications',NULL,NULL,'hard_skill','active','X0RFR'),(6,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Crystal Reports (Reporting Software)',NULL,NULL,'hard_skill','active','TBTKH'),(7,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Web Intelligence',NULL,NULL,'hard_skill','active','1D7DM'),(8,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Equity Method',NULL,NULL,'hard_skill','active','4WYH1'),(9,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Microsoft PowerPoint',NULL,NULL,'soft_skill','active','RJ4E9'),(10,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Microsoft Word',NULL,NULL,'soft_skill','active','1QAWB'),(11,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Depreciation',NULL,NULL,'hard_skill','active','TK4AG'),(12,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Source (Game Engine)',NULL,NULL,'hard_skill','active','5X45V'),(13,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Inventory Turnover',NULL,NULL,'hard_skill','active','LHZCX'),(14,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Budgeting',NULL,NULL,'hard_skill','active','PWIGQ'),(15,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Library',NULL,NULL,'hard_skill','active','0K3OM'),(16,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Infrastructure',NULL,NULL,'soft_skill','active','I2T04'),(17,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'SAP CRM',NULL,NULL,'hard_skill','active','UOEPR'),(18,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Real Estate',NULL,NULL,'soft_skill','active','C4MS1'),(19,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Query Designer',NULL,NULL,'hard_skill','active','VQ2ZH'),(20,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Management',NULL,NULL,'soft_skill','active','55FYV'),(21,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Working Capital',NULL,NULL,'hard_skill','active','41DZL'),(22,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Information Management',NULL,NULL,'hard_skill','active','V433B'),(23,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Financial Statements',NULL,NULL,'hard_skill','active','6DCUY'),(24,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'SAP BusinessObjects',NULL,NULL,'hard_skill','active','O326S'),(25,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Business Development Company (BDC)',NULL,NULL,'hard_skill','active','OJ84Q'),(26,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Dashboard',NULL,NULL,'hard_skill','active','K66G4'),(27,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Planning',NULL,NULL,'soft_skill','active','F0KCV'),(28,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Consulting',NULL,NULL,'soft_skill','active','6X5MQ'),(29,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Integration',NULL,NULL,'soft_skill','active','XBSM6'),(30,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Restructuring (Business)',NULL,NULL,'hard_skill','active','S0F5R'),(31,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Production Planning',NULL,NULL,'hard_skill','active','6JR1P'),(32,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'SAP ABAP',NULL,NULL,'hard_skill','active','6F8X9'),(33,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Balance Sheet',NULL,NULL,'hard_skill','active','WHAYN'),(34,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Estate Planning',NULL,NULL,'hard_skill','active','5JOEX'),(35,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Coal Mining',NULL,NULL,'hard_skill','active','QA0AY'),(36,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Forecasting',NULL,NULL,'hard_skill','active','12LTI'),(37,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Sales Planning',NULL,NULL,'hard_skill','active','1YUCZ'),(38,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Warehousing',NULL,NULL,'hard_skill','active','HZIRT'),(39,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Fair Value',NULL,NULL,'hard_skill','active','UN301'),(40,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Advanced Business Application Programming (ABAP)',NULL,NULL,'hard_skill','active','U5TS9'),(41,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'BI Launch Pad (Software)',NULL,NULL,'hard_skill','active','HC9U5'),(42,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Business Process',NULL,NULL,'hard_skill','active','PJ5TL'),(43,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Extract Transform Load (ETL)',NULL,NULL,'hard_skill','active','RORGB'),(44,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Business Intelligence',NULL,NULL,'hard_skill','active','KTZVE'),(45,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Transformation (Genetics)',NULL,NULL,'hard_skill','active','17F5G'),(46,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Data Warehousing',NULL,NULL,'hard_skill','active','BQAOU'),(47,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Net Income',NULL,NULL,'hard_skill','active','HN3WU'),(48,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Live Reporting',NULL,NULL,'hard_skill','active','9BDM6'),(49,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Staging',NULL,NULL,'hard_skill','active','IF1ZG'),(50,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Enterprise Information Management',NULL,NULL,'hard_skill','active','ME25E'),(51,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Consolidation',NULL,NULL,'hard_skill','active','XL86P'),(52,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Minority Interest',NULL,NULL,'hard_skill','active','NVX7Q'),(53,'2023-01-25 15:25:46',28,1,NULL,NULL,1,'Development Planning',NULL,NULL,'hard_skill','active','OTW8D'),(54,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Crystal Reports (Reporting Software)',NULL,NULL,'hard_skill','active','6IT5M'),(55,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Construction','2023-01-24 17:00:00',38,'soft_skill','active','DEA96'),(56,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Management',NULL,NULL,'soft_skill','active','HIYND'),(57,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Activity-Based Costing','2023-01-24 17:00:00',38,'hard_skill','active','IONB5'),(58,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Networking Basics',NULL,NULL,'hard_skill','active','FUIDT'),(59,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Financial Statements','2023-01-24 17:00:00',38,'hard_skill','active','NVVNJ'),(60,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Enterprise Portal',NULL,NULL,'hard_skill','active','D1KD0'),(61,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Troubleshooting (Problem Solving)','2023-01-24 17:00:00',38,'soft_skill','active','AP121'),(62,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Purchasing',NULL,NULL,'hard_skill','active','H6RW6'),(63,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Integration',NULL,NULL,'soft_skill','active','OLMPX'),(64,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Accounting',NULL,NULL,'hard_skill','active','KJZYY'),(65,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Agribusiness',NULL,NULL,'hard_skill','active','KKLE4'),(66,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Production Systems',NULL,NULL,'hard_skill','active','27CTG'),(67,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Web Intelligence',NULL,NULL,'hard_skill','active','WHPAV'),(68,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Microsoft PowerPoint',NULL,NULL,'soft_skill','active','SVTCW'),(69,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Microsoft Word',NULL,NULL,'soft_skill','active','15XP6'),(70,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Writing','2023-01-24 17:00:00',38,'soft_skill','active','NKX8T'),(71,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Variance Analysis',NULL,NULL,'hard_skill','active','TV9XS'),(72,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Heavy Industry','2023-01-24 17:00:00',38,'hard_skill','active','0XEX0'),(73,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Data Modeling',NULL,NULL,'hard_skill','active','TAKWL'),(74,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Communications',NULL,NULL,'soft_skill','active','S8XM7'),(75,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Sensitivity Analysis',NULL,NULL,'hard_skill','active','PXKV0'),(76,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Trial Balance',NULL,NULL,'hard_skill','active','4W6LG'),(77,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Planning','2023-01-24 17:00:00',38,'soft_skill','active','CXQRU'),(78,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Consulting',NULL,NULL,'soft_skill','active','UQREK'),(79,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Community Development',NULL,NULL,'hard_skill','active','V5YRW'),(80,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Scheduling',NULL,NULL,'soft_skill','active','QN6A5'),(81,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Source (Game Engine)',NULL,NULL,'hard_skill','active','EIN4I'),(82,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Production Planning',NULL,NULL,'hard_skill','active','O4CTB'),(83,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Sales',NULL,NULL,'soft_skill','active','ZL8JY'),(84,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Budgeting',NULL,NULL,'hard_skill','active','ZUPN9'),(85,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Library',NULL,NULL,'hard_skill','active','U7M3D'),(86,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Analytics',NULL,NULL,'hard_skill','active','JAZYK'),(87,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Critical Path Method (CPM) Scheduling',NULL,NULL,'hard_skill','active','11DWD'),(88,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'SAP CRM','2023-01-24 17:00:00',38,'hard_skill','active','QWIKU'),(89,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Query Designer',NULL,NULL,'hard_skill','active','5KWSG'),(90,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Exchange Web Services (EWS)','2023-01-24 17:00:00',38,'hard_skill','active','8G44J'),(91,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'SAP BusinessObjects',NULL,NULL,'hard_skill','active','JIF4I'),(92,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Dashboard','2023-01-24 17:00:00',38,'hard_skill','active','BEX51'),(93,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Microsoft Excel',NULL,NULL,'soft_skill','active','V0R9D'),(94,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Marketing Planning',NULL,NULL,'hard_skill','active','SE966'),(95,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Aluminum',NULL,NULL,'hard_skill','active','IODO6'),(96,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Infrastructure','2023-01-24 17:00:00',38,'soft_skill','active','VUDV2'),(97,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Unit Testing','2023-01-24 17:00:00',38,'hard_skill','active','419GC'),(98,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Information Management',NULL,NULL,'hard_skill','active','V1HUZ'),(99,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Outsourcing',NULL,NULL,'hard_skill','active','SPYEZ'),(100,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Procurement',NULL,NULL,'hard_skill','active','08YL3'),(101,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Lifecycle Management',NULL,NULL,'hard_skill','active','NP586'),(102,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Pension Funds',NULL,NULL,'hard_skill','active','3SOEM'),(103,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'BI Launch Pad (Software)',NULL,NULL,'hard_skill','active','IDSGQ'),(104,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Business Process','2023-01-24 17:00:00',38,'hard_skill','active','R7ELU'),(105,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Fixed Asset','2023-01-24 17:00:00',38,'hard_skill','active','6EL79'),(106,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Data Management',NULL,NULL,'hard_skill','active','X95ME'),(107,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Authorization (Computing)',NULL,NULL,'hard_skill','active','T2WZY'),(108,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Visual Basic For Applications',NULL,NULL,'hard_skill','active','112QR'),(109,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'SAP NetWeaver',NULL,NULL,'hard_skill','active','HLS1U'),(110,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Business Systems',NULL,NULL,'hard_skill','active','JBC5G'),(111,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Net Income',NULL,NULL,'hard_skill','active','JL9OB'),(112,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Live Reporting',NULL,NULL,'hard_skill','active','2YSF0'),(113,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Consolidation',NULL,NULL,'hard_skill','active','5056N'),(114,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'SAP ABAP',NULL,NULL,'hard_skill','active','TG40E'),(115,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Forecasting','2023-01-24 17:00:00',38,'hard_skill','active','VFTB4'),(116,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Advanced Business Application Programming (ABAP)',NULL,NULL,'hard_skill','active','931UM'),(117,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Process Design',NULL,NULL,'hard_skill','active','0CQPK'),(118,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Joint Ventures','2023-01-24 17:00:00',38,'hard_skill','active','QMKTZ'),(119,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Financial Accounting',NULL,NULL,'hard_skill','active','NAO48'),(120,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Information Technology','2023-01-24 17:00:00',38,'soft_skill','active','VV5Q9'),(121,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Distribution System Operators (DSO)',NULL,NULL,'hard_skill','active','SIU34'),(122,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Transformation (Genetics)','2023-01-24 17:00:00',38,'hard_skill','active','UOMRU'),(123,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Staging',NULL,NULL,'hard_skill','active','L921K'),(124,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Occupational Health And Safety Management System (OHSAS)',NULL,NULL,'hard_skill','active','ZU9WV'),(125,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Enterprise Information Management',NULL,NULL,'hard_skill','active','VTR9U'),(126,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Minority Interest',NULL,NULL,'hard_skill','active','ZSHIK'),(127,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Financial Services','2023-01-24 17:00:00',38,'hard_skill','active','X56KA'),(128,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Balance Sheet','2023-01-24 17:00:00',38,'hard_skill','active','OSQZX'),(129,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Web Dynpro',NULL,NULL,'hard_skill','active','THF54'),(130,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Business Intelligence',NULL,NULL,'hard_skill','active','47Z0K'),(131,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Receivables','2023-01-24 17:00:00',38,'hard_skill','active','W97DN'),(132,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Computer Science',NULL,NULL,'hard_skill','active','UYPU3'),(133,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Sales Planning',NULL,NULL,'hard_skill','active','L3RDD'),(134,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'Extract Transform Load (ETL)','2023-01-24 17:00:00',38,'hard_skill','active','USUF5'),(135,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Microsoft Windows','2021-02-28 17:00:00',62,'soft_skill','active','2VUVH'),(136,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'PHP (Scripting Language)','2021-02-28 17:00:00',62,'hard_skill','active','APRXM'),(137,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Spring Boot','2021-02-28 17:00:00',62,'hard_skill','active','WMQ3B'),(138,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Java (Programming Language)','2021-02-28 17:00:00',62,'hard_skill','active','WXEG0'),(139,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'CentOS','2021-02-28 17:00:00',62,'hard_skill','active','F4GB9'),(140,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'JIRA','2021-02-28 17:00:00',62,'hard_skill','active','CF7B3'),(141,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Microsoft Excel','2013-11-30 17:00:00',37,'soft_skill','active','OQGE3'),(142,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Vaadin','2023-01-24 17:00:00',20,'hard_skill','active','M9ROA'),(143,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Google Cloud','2021-02-28 17:00:00',62,'hard_skill','active','UTYM9'),(144,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'SQL (Programming Language)','2021-02-28 17:00:00',122,'hard_skill','active','GAGZ3'),(145,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Bootstrap (Front-End Framework)','2021-02-28 17:00:00',62,'hard_skill','active','KFV6Y'),(146,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Java Platform Enterprise Edition (J2EE)','2021-02-28 17:00:00',122,'hard_skill','active','R4P7Z'),(147,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Kubernetes','2021-02-28 17:00:00',62,'hard_skill','active','M4ZVM'),(148,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Apache Kafka','2021-02-28 17:00:00',62,'hard_skill','active','DL4H9'),(149,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Microservices','2021-02-28 17:00:00',62,'hard_skill','active','DE0AS'),(150,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Management','2023-01-24 17:00:00',20,'soft_skill','active','PUH89'),(151,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Angular (Web Framework)','2023-01-24 17:00:00',20,'hard_skill','active','EK9P1'),(152,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Software Versioning','2021-02-28 17:00:00',62,'hard_skill','active','OWU13'),(153,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Web Services','2021-02-28 17:00:00',62,'hard_skill','active','FCO5I'),(154,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'MongoDB','2021-02-28 17:00:00',62,'hard_skill','active','584CL'),(155,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Microsoft Word','2021-02-28 17:00:00',122,'soft_skill','active','MLBHB'),(156,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Machine Learning','2021-02-28 17:00:00',62,'hard_skill','active','5HSQ0'),(157,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Amazon Web Services','2021-02-28 17:00:00',62,'hard_skill','active','YPC5M'),(158,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'MySQL','2021-02-28 17:00:00',99,'hard_skill','active','YI2JO'),(159,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Magento','2021-02-28 17:00:00',62,'hard_skill','active','6E9X7'),(160,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Weka','2021-02-28 17:00:00',62,'hard_skill','active','KMLH9'),(161,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Apache Tomcat','2021-02-28 17:00:00',122,'hard_skill','active','7YJ2W'),(162,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Microsoft Project','2021-02-28 17:00:00',99,'hard_skill','active','QL0YD'),(163,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Rajawali','2023-01-24 17:00:00',20,'hard_skill','active','VDVG5'),(164,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Change Request','2013-11-30 17:00:00',37,'hard_skill','active','8ELJL'),(165,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Oracle Service Bus','2021-02-28 17:00:00',62,'hard_skill','active','5XXUV'),(166,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Redis','2021-02-28 17:00:00',62,'hard_skill','active','B768V'),(167,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'RapidMiner','2021-02-28 17:00:00',62,'hard_skill','active','07S6T'),(168,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Middleware','2013-11-30 17:00:00',37,'hard_skill','active','S0CMD'),(169,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Ubuntu (Operating System)','2021-02-28 17:00:00',62,'hard_skill','active','Q2EKH'),(170,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'PostgreSQL','2021-02-28 17:00:00',62,'hard_skill','active','JQYT4'),(171,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'JAX-WS','2021-02-28 17:00:00',62,'hard_skill','active','9FU0N'),(172,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Google Cloud Platform (GCP)','2021-02-28 17:00:00',62,'hard_skill','active','60RJU');
/*!40000 ALTER TABLE `tb_resume_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_resume_work_experience`
--

DROP TABLE IF EXISTS `tb_resume_work_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_resume_work_experience` (
  `tbrwe_id` int(11) NOT NULL AUTO_INCREMENT,
  `tbrwe_create_date` datetime DEFAULT NULL,
  `tbrwe_create_id` int(11) DEFAULT NULL,
  `tbrwe_create_idc` int(11) DEFAULT NULL,
  `tbrwe_update_date` datetime DEFAULT NULL,
  `tbrwe_update_id` int(11) DEFAULT NULL,
  `tbr_id` int(11) DEFAULT NULL,
  `tbrwe_job_title` varchar(255) DEFAULT NULL,
  `tbrwe_job_title_normalized` varchar(255) DEFAULT NULL,
  `tbrwe_organization` varchar(255) DEFAULT NULL,
  `tbrwe_start_date` datetime DEFAULT NULL,
  `tbrwe_end_date` datetime DEFAULT NULL,
  `tbrwe_months_in_position` int(11) DEFAULT NULL,
  `tbrwe_is_current` varchar(255) DEFAULT NULL,
  `tbrwe_job_description` varchar(10000) DEFAULT NULL,
  `tbrwe_minor_group` varchar(255) DEFAULT NULL,
  `tbrwe_major_group` varchar(255) DEFAULT NULL,
  `tbrwe_sub_major_group` varchar(255) DEFAULT NULL,
  `tbrwe_management_level` varchar(255) DEFAULT NULL,
  `tbrwe_status` varchar(20) DEFAULT NULL,
  `tbrwe_uuid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tbrwe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume_work_experience`
--

LOCK TABLES `tb_resume_work_experience` WRITE;
/*!40000 ALTER TABLE `tb_resume_work_experience` DISABLE KEYS */;
INSERT INTO `tb_resume_work_experience` VALUES (1,'2023-01-25 15:25:47',28,1,NULL,NULL,2,'SAP BPC-BW-Dashboard Solution Architect','SAP BW Architect','Astra','2019-11-30 17:00:00','2023-01-24 17:00:00',38,'true','Responsibilities : \n•Requirement analysis and system design, including preparation of Blueprint documentation for RKAP (Rencana Kerja & Anggaran Perusahaan), Prognosa (Forecast), and PAJM (Proyeksi Anggaran Jangka Menengah with 5-years duration), for following Planning Areas: a. OPEX planning (including utilization of Activity-Based Costing method) b. HR Planning c. Revenue & Other Cost Planning d. Budget Revision & Re-Allocation e. Cashflow Forecasting f. Budget Monitoring & Control g. Financial Statements planning (Balance Sheet, Profit & Loss, Cashflow) \n•Requirement analysis and system design for dashboards, including preparation of Blueprint documentation, covering dashboards from following areas: a. Dashboard Revenue & Expenditures Performance b. Dashboard Expense Detail c. Dashboard Collection / Receivables d. Dashboard Expenses Per Activity OJK Wide e. Dashboard Budget Realization by Division & Working Unit (aka Satuan Kerja (Satker)) f. Dashboard EWS (Early Warning System) as follows: 1. Fixed Asset 2. Business Trip 3. Cash Advance 4. Debt 5. Budget Transfer across Activities g. Dashboard Budget Revision h. Dashboard Financial \n•Design and set up of BW ETL objects (Extraction, Transformation, Loading) to load from SAP S/4 HANA to BW for Dashboard & BPC \n•Design and set up BPC Input Schedules & Reports for Input Data & Reporting \n•Design and set up BPF (Business Process Flow) for workflow, linking all tasks required to be done in sequential manner \n•Design and set up BPC Security (User, Team, Task Profile, Member Access Profile). \n•Conducting user training. \n•Unit Testing, preparation of UAT script, troubleshooting and bug-fixing during UAT (User Acceptance Testing). \n•Writing final functional-technical documentation. \n•Post Go-Live on-site support Project : Implementation for SAP BW for Group Tax Report Client : PT Astra International, Tbk - Indonesia Astra International was established in 1957, is a large and well-known group of companies in Indonesia, which operates in the following business segments: Automotive, Financial Services, Heavy Industry, Mining, Construction & Energy, Agrobusiness, Infrastructure & Logistic, Information Technology, Property. At the end of 2018, Astra International Group has 229 Subsidiaries, Joint Ventures and Associates, which in total employ 224,488 employees ',NULL,NULL,NULL,'Low','active','135O1'),(2,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Founder, Director, eCommerce Implementation Consultant',NULL,'PT. BTECHNO SOLUSI DIGITAL','2021-05-31 17:00:00','2023-01-24 17:00:00',20,'true','Project based consultant on various projects from private and government owned company : PT Rajawali Berdikari Indonesia Attendance Application PT. Tiga Global Sejahtera Distribution Management System https://dms.id-trec.com PT Kustodian Sentral Efek Indonesia (KSEI) Revamp GUI for S-Invest Latest technology and/or Methodology that were deployed: Vaadin Angular ',NULL,NULL,NULL,NULL,'active','RPXMN'),(3,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Senior Manager Platform Development','Platform Development Manager','PT. Sumber Trijaya Lestari (alfacart.com)','2015-12-31 17:00:00','2021-02-28 17:00:00',62,'false','direct report to VP / Head of IT Managing and mentoring development team in all activities from assessment, pre development strategy, development phase, deployment rollout, and post deployment. Leading development team to delivery ecommerce microservices based applications for both frontend and backend. Technology and/or Methodology that were deployed: Ubuntu Desktop, Ubuntu Server, Centos, Microsoft Windows, Microsoft Project, Microsoft Power point, Microsoft Word, Php, J2EE, Oracle Service Bus, Oracle Database, PostgreSQL Database, MySQL Database, Magento Enterprise, SOLR, Java JAX-WS, Java JAX-RS, Google Web Toolkit, Apache Tomcat, Oracle Weblogic, Code Igniter, Bootstrap, SVN, JIRA, Confluence, Google Cloud Platform, Amazon Web Services, MongoDB, Redis, Kubernetes, Kafka, Confluent, Spring Boot, Machine Learning (Weka, Rapidminer). ',NULL,NULL,NULL,'Mid','active','YEW17'),(4,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Senior Manager Backend Developer','Drupal Backend Developer','PT. XL Planet (elevenia.co.id)','2013-12-31 17:00:00','2015-11-30 17:00:00',23,'false','Having responsibilities for giving assessment of possibilities, options, and schedule for task and giving directions, strategies, and guidance to team for completing the task based on team load and team capacity. Technology and/or Methodology that were deployed: Microsoft Power point, Microsoft Word, J2EE, Oracle Database, SQL Developer, Apache Tomcat, Oracle Weblogic. ','Information Technology Professionals','PROFESSIONAL OCCUPATIONS','SCIENCE, RESEARCH, ENGINEERING AND TECHNOLOGY PROFESSIONALS','Low','active','IEK58'),(5,'2023-01-25 15:25:50',28,1,NULL,NULL,3,'Technical Consultant','Technical Consultant','PT Mitra Integrasi Informatika','2010-10-31 17:00:00','2013-11-30 17:00:00',37,'false','Extending, design and deliver KPEI Middleware, as a backbone for KPEI day to day operational process. Design phase: Gathering requirement and coordinate with multiple application vendors to provide SOA design. Create Project Plan, High Level Requirement, Business Proposal, and Document Design. Deliver phase: In charge with weekly Progress Meeting to update user with the latest condition of project, also with risks and issues arise within accomplished week. Deliver service according with business specification. Support phase: Give assessment with any Change Request, if exists. Bug fixing. Technology and/or Methodology that were deployed: Microsoft Word, Microsoft Project, Microsoft Excel, C++, J2EE, Oracle Database, MySQL Database, SQL Developer, Toad for MySQL, Apache Tomcat, Oracle Weblogic, Oracle SOA Suite. ','Information Technology Professionals','PROFESSIONAL OCCUPATIONS','SCIENCE, RESEARCH, ENGINEERING AND TECHNOLOGY PROFESSIONALS','Low','active','JN7SL');
/*!40000 ALTER TABLE `tb_resume_work_experience` ENABLE KEYS */;
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
  `tbu_create_idc` int(11) DEFAULT NULL,
  `tbu_update_date` datetime DEFAULT NULL,
  `tbu_update_id` int(11) DEFAULT NULL,
  `tbu_email` varchar(255) DEFAULT NULL,
  `tbu_password` varchar(32) DEFAULT NULL,
  `tbu_firstname` varchar(100) DEFAULT NULL,
  `tbu_lastname` varchar(100) DEFAULT NULL,
  `tbu_mobile_phone` varchar(100) DEFAULT NULL,
  `tbu_status` varchar(20) DEFAULT NULL,
  `tbu_uid` varchar(100) DEFAULT NULL,
  `tbu_photo` varchar(1000) DEFAULT NULL,
  `tbu_token_salt` varchar(36) DEFAULT NULL,
  `tbu_type` varchar(20) DEFAULT NULL,
  `tbu_expired` datetime DEFAULT NULL,
  PRIMARY KEY (`tbu_id`),
  UNIQUE KEY `tb_user_tbu_email_uindex` (`tbu_email`),
  UNIQUE KEY `tb_user_tbu_uid_uindex` (`tbu_uid`),
  KEY `tb_user_tbu_firstname_index` (`tbu_firstname`),
  KEY `tb_user_tbu_lastname_index` (`tbu_lastname`),
  KEY `tb_user_tbu_password_index` (`tbu_password`),
  KEY `tb_user_tbu_status_index` (`tbu_status`),
  KEY `tb_user_tbu_token_salt_index` (`tbu_token_salt`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'2019-09-03 15:42:44',0,NULL,'2022-10-13 04:38:47',1,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin','123','active','xycnh1fzl8chkm8cqr20ni6zvh2ai52c3mvw2uwy0s86mscu9u80h6ylym2imghas6h6ffj05taecfoxfu3g0x8alwbt97q9je8f','1111343528-20q4jm5fw1-Cluster-Morizen-Bekasi-Indonesia.jpg','ymju8h3zhemj0nhcoqrcvu1i961fhslotr0c',NULL,NULL),(2,'2021-11-04 12:00:07',1,NULL,'2022-03-29 09:55:17',1,'pic1@mail.com','202cb962ac59075b964b07152d234b70','pic','one',NULL,'active',NULL,NULL,'ng843n6ocg719kklqklb5814t9n2ahilj9zv',NULL,NULL),(3,'2021-11-04 12:12:24',1,NULL,'2022-03-29 09:55:28',1,'pic2@mail.com','202cb962ac59075b964b07152d234b70','pic','two',NULL,'active',NULL,NULL,'b3n95p03tsdpm9fya84cnelibj9u34xffz6j',NULL,NULL),(4,'2021-11-04 12:13:34',1,NULL,'2022-03-29 09:55:39',1,'pic3@mail.com','202cb962ac59075b964b07152d234b70','pic','three',NULL,'active',NULL,NULL,'zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl',NULL,NULL),(5,'2022-02-07 09:12:44',1,NULL,'2022-03-29 09:55:49',1,'pic4@mail.com','202cb962ac59075b964b07152d234b70','pic','four',NULL,'active',NULL,NULL,'ni5ju0wgw0l4x3gxoq0cgh3jn3lyvejl5aq8',NULL,NULL),(6,'2022-02-07 09:48:32',1,NULL,'2022-03-29 09:56:15',1,'pic6@mail.com','202cb962ac59075b964b07152d234b70','pic','six',NULL,'active',NULL,NULL,'onlidhsdmmgz9k8gxzq2dfazrhshyx9zv53p',NULL,NULL),(7,'2022-02-08 08:57:14',1,NULL,'2022-03-29 09:56:26',1,'pic7@mail.com','202cb962ac59075b964b07152d234b70','pic','seven',NULL,'active',NULL,NULL,'it1wq7s6txkfcl6xw2iji0dmebrmc7b41mtv',NULL,NULL),(8,'2022-02-08 08:57:34',1,NULL,'2022-03-29 09:56:35',1,'pic8@mail.com','202cb962ac59075b964b07152d234b70','pic','eight',NULL,'active',NULL,NULL,'macc9yxlcnfjqix254tmbf0h4459a9w22xfi',NULL,NULL),(9,'2022-02-08 08:58:30',1,NULL,'2022-03-29 09:56:54',1,'pic9@mail.com','202cb962ac59075b964b07152d234b70','pic','nine',NULL,'active',NULL,NULL,'jayf1yr5fd07mshu2c4a29ih8li17beubiwc',NULL,NULL),(10,'2022-02-08 08:59:52',1,NULL,'2022-03-29 09:57:02',1,'pic10@mail.com','202cb962ac59075b964b07152d234b70','pic','ten',NULL,'active',NULL,NULL,'i8m95htaivk0u5mcjfy3ioo0k9zxxf8lpp5h',NULL,NULL),(11,'2022-02-14 11:18:06',1,NULL,'2022-03-29 09:57:11',1,'pic11@mail.com','202cb962ac59075b964b07152d234b70','pic','eleven',NULL,'active',NULL,NULL,'lk9i5cv2dm5bnyz07apzo3wirxodwfhhxf85',NULL,NULL),(12,'2022-02-14 11:19:22',1,NULL,'2022-03-29 09:57:20',1,'pic12@mail.com','202cb962ac59075b964b07152d234b70','pic','twelve',NULL,'active',NULL,NULL,'uzf4niy96076mn4crvfsalm9r06uoey2spjj',NULL,NULL),(13,'2022-02-16 07:42:39',1,NULL,'2022-03-29 09:57:29',1,'pic13@mail.com','202cb962ac59075b964b07152d234b70','pic','thirteen',NULL,'active',NULL,NULL,'oka59r3uxjbqi7pfwpv2kbiyf1tuxedqvam6',NULL,NULL),(14,'2022-02-24 03:08:59',1,NULL,'2022-04-18 06:25:36',14,'pic14@mail.com','202cb962ac59075b964b07152d234b70','pic','fourteen',NULL,'active',NULL,NULL,'ntw5zeue28u72o3bkbdukg0hjahj25bqcljx',NULL,NULL),(28,'2022-12-13 15:22:59',NULL,1,'2023-01-25 12:14:17',28,'achmad.amri@gmail.com','202cb962ac59075b964b07152d234b70','Achmad','Amri','081380782318','active','71imewz8stbcafcx7s2rrukdyzx6plwbdze9gparu9tlrz1wqlw9yhcuq4jp13xprvwa2o4jkqblhxnoz87c7oh9k631uerecms1',NULL,'Z6M7SPL0ZCZG0OFS2HO7SR51T1B31AH95FGF',NULL,NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `view_job_department`
--

DROP TABLE IF EXISTS `view_job_department`;
/*!50001 DROP VIEW IF EXISTS `view_job_department`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `view_job_department` (
  `uuid` tinyint NOT NULL,
  `tbj_id` tinyint NOT NULL,
  `tbj_create_date` tinyint NOT NULL,
  `tbj_create_id` tinyint NOT NULL,
  `tbj_create_idc` tinyint NOT NULL,
  `tbj_update_date` tinyint NOT NULL,
  `tbj_update_id` tinyint NOT NULL,
  `tbj_name` tinyint NOT NULL,
  `tbj_status` tinyint NOT NULL,
  `tbj_uuid` tinyint NOT NULL,
  `tbdj_id` tinyint NOT NULL,
  `tbdj_create_date` tinyint NOT NULL,
  `tbdj_create_id` tinyint NOT NULL,
  `tbdj_create_idc` tinyint NOT NULL,
  `tbdj_update_date` tinyint NOT NULL,
  `tbdj_update_id` tinyint NOT NULL,
  `tbdj_status` tinyint NOT NULL,
  `tbdj_uuid` tinyint NOT NULL,
  `tbd_id` tinyint NOT NULL,
  `tbd_create_date` tinyint NOT NULL,
  `tbd_create_id` tinyint NOT NULL,
  `tbd_create_idc` tinyint NOT NULL,
  `tbd_update_date` tinyint NOT NULL,
  `tbd_update_id` tinyint NOT NULL,
  `tbd_name` tinyint NOT NULL,
  `tbd_status` tinyint NOT NULL,
  `tbd_uuid` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `view_job_resume`
--

DROP TABLE IF EXISTS `view_job_resume`;
/*!50001 DROP VIEW IF EXISTS `view_job_resume`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `view_job_resume` (
  `uuid` tinyint NOT NULL,
  `tbj_id` tinyint NOT NULL,
  `tbj_create_date` tinyint NOT NULL,
  `tbj_create_id` tinyint NOT NULL,
  `tbj_create_idc` tinyint NOT NULL,
  `tbj_update_date` tinyint NOT NULL,
  `tbj_update_id` tinyint NOT NULL,
  `tbj_name` tinyint NOT NULL,
  `tbj_status` tinyint NOT NULL,
  `tbj_uuid` tinyint NOT NULL,
  `tbjr_id` tinyint NOT NULL,
  `tbjr_create_date` tinyint NOT NULL,
  `tbjr_create_id` tinyint NOT NULL,
  `tbjr_create_idc` tinyint NOT NULL,
  `tbjr_update_date` tinyint NOT NULL,
  `tbjr_update_id` tinyint NOT NULL,
  `tbjr_status` tinyint NOT NULL,
  `tbjr_uuid` tinyint NOT NULL,
  `tbr_id` tinyint NOT NULL,
  `tbr_create_date` tinyint NOT NULL,
  `tbr_create_id` tinyint NOT NULL,
  `tbr_create_idc` tinyint NOT NULL,
  `tbr_update_date` tinyint NOT NULL,
  `tbr_update_id` tinyint NOT NULL,
  `tbr_data_name_raw` tinyint NOT NULL,
  `tbr_data_name_first` tinyint NOT NULL,
  `tbr_data_name_last` tinyint NOT NULL,
  `tbr_data_name_middle` tinyint NOT NULL,
  `tbr_data_name_title` tinyint NOT NULL,
  `tbr_data_phone_numbers` tinyint NOT NULL,
  `tbr_data_websites` tinyint NOT NULL,
  `tbr_data_emails` tinyint NOT NULL,
  `tbr_data_date_of_birth` tinyint NOT NULL,
  `tbr_data_location_formatted` tinyint NOT NULL,
  `tbr_data_location_postal_code` tinyint NOT NULL,
  `tbr_data_location_state` tinyint NOT NULL,
  `tbr_data_location_country` tinyint NOT NULL,
  `tbr_data_location_country_code` tinyint NOT NULL,
  `tbr_data_location_raw_input` tinyint NOT NULL,
  `tbr_data_location_street_number` tinyint NOT NULL,
  `tbr_data_location_street` tinyint NOT NULL,
  `tbr_data_location_apartment_number` tinyint NOT NULL,
  `tbr_data_location_city` tinyint NOT NULL,
  `tbr_data_objective` tinyint NOT NULL,
  `tbr_data_languages` tinyint NOT NULL,
  `tbr_data_language_codes` tinyint NOT NULL,
  `tbr_data_summary` tinyint NOT NULL,
  `tbr_data_total_years_experience` tinyint NOT NULL,
  `tbr_data_head_shot` tinyint NOT NULL,
  `tbr_data_education` tinyint NOT NULL,
  `tbr_data_profession` tinyint NOT NULL,
  `tbr_data_linkedin` tinyint NOT NULL,
  `tbr_data_work_experience` tinyint NOT NULL,
  `tbr_data_skills` tinyint NOT NULL,
  `tbr_data_certifications` tinyint NOT NULL,
  `tbr_data_publications` tinyint NOT NULL,
  `tbr_data_referees` tinyint NOT NULL,
  `tbr_data_sections` tinyint NOT NULL,
  `tbr_data_is_resume_probability` tinyint NOT NULL,
  `tbr_data_raw_text` tinyint NOT NULL,
  `tbr_meta_identifier` tinyint NOT NULL,
  `tbr_meta_file_name` tinyint NOT NULL,
  `tbr_meta_ready` tinyint NOT NULL,
  `tbr_meta_ready_dt` tinyint NOT NULL,
  `tbr_meta_failed` tinyint NOT NULL,
  `tbr_meta_expiry_time` tinyint NOT NULL,
  `tbr_meta_language` tinyint NOT NULL,
  `tbr_meta_pdf` tinyint NOT NULL,
  `tbr_meta_parent_document_identifier` tinyint NOT NULL,
  `tbr_meta_child_documents` tinyint NOT NULL,
  `tbr_meta_pages` tinyint NOT NULL,
  `tbr_meta_is_verified` tinyint NOT NULL,
  `tbr_meta_review_url` tinyint NOT NULL,
  `tbr_meta_ocr_confidence` tinyint NOT NULL,
  `tbr_error_error_code` tinyint NOT NULL,
  `tbr_error_error_detail` tinyint NOT NULL,
  `tbr_status` tinyint NOT NULL,
  `tbr_uuid` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_job_department`
--

/*!50001 DROP TABLE IF EXISTS `view_job_department`*/;
/*!50001 DROP VIEW IF EXISTS `view_job_department`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_job_department` AS select cast(uuid() as char(36) charset utf8mb4) AS `uuid`,`tbj`.`tbj_id` AS `tbj_id`,`tbj`.`tbj_create_date` AS `tbj_create_date`,`tbj`.`tbj_create_id` AS `tbj_create_id`,`tbj`.`tbj_create_idc` AS `tbj_create_idc`,`tbj`.`tbj_update_date` AS `tbj_update_date`,`tbj`.`tbj_update_id` AS `tbj_update_id`,`tbj`.`tbj_name` AS `tbj_name`,`tbj`.`tbj_status` AS `tbj_status`,`tbj`.`tbj_uuid` AS `tbj_uuid`,`tbdj`.`tbdj_id` AS `tbdj_id`,`tbdj`.`tbdj_create_date` AS `tbdj_create_date`,`tbdj`.`tbdj_create_id` AS `tbdj_create_id`,`tbdj`.`tbdj_create_idc` AS `tbdj_create_idc`,`tbdj`.`tbdj_update_date` AS `tbdj_update_date`,`tbdj`.`tbdj_update_id` AS `tbdj_update_id`,`tbdj`.`tbdj_status` AS `tbdj_status`,`tbdj`.`tbdj_uuid` AS `tbdj_uuid`,`tbd`.`tbd_id` AS `tbd_id`,`tbd`.`tbd_create_date` AS `tbd_create_date`,`tbd`.`tbd_create_id` AS `tbd_create_id`,`tbd`.`tbd_create_idc` AS `tbd_create_idc`,`tbd`.`tbd_update_date` AS `tbd_update_date`,`tbd`.`tbd_update_id` AS `tbd_update_id`,`tbd`.`tbd_name` AS `tbd_name`,`tbd`.`tbd_status` AS `tbd_status`,`tbd`.`tbd_uuid` AS `tbd_uuid` from ((`tb_job` `tbj` left join `tb_department_job` `tbdj` on(`tbdj`.`tbdj_create_idc` = `tbj`.`tbj_create_idc` and `tbdj`.`tbj_id` = `tbj`.`tbj_id`)) left join `tb_department` `tbd` on(`tbd`.`tbd_id` = `tbdj`.`tbd_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_job_resume`
--

/*!50001 DROP TABLE IF EXISTS `view_job_resume`*/;
/*!50001 DROP VIEW IF EXISTS `view_job_resume`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_job_resume` AS select cast(uuid() as char(36) charset utf8mb4) AS `uuid`,`tbj`.`tbj_id` AS `tbj_id`,`tbj`.`tbj_create_date` AS `tbj_create_date`,`tbj`.`tbj_create_id` AS `tbj_create_id`,`tbj`.`tbj_create_idc` AS `tbj_create_idc`,`tbj`.`tbj_update_date` AS `tbj_update_date`,`tbj`.`tbj_update_id` AS `tbj_update_id`,`tbj`.`tbj_name` AS `tbj_name`,`tbj`.`tbj_status` AS `tbj_status`,`tbj`.`tbj_uuid` AS `tbj_uuid`,`tbjr`.`tbjr_id` AS `tbjr_id`,`tbjr`.`tbjr_create_date` AS `tbjr_create_date`,`tbjr`.`tbjr_create_id` AS `tbjr_create_id`,`tbjr`.`tbjr_create_idc` AS `tbjr_create_idc`,`tbjr`.`tbjr_update_date` AS `tbjr_update_date`,`tbjr`.`tbjr_update_id` AS `tbjr_update_id`,`tbjr`.`tbjr_status` AS `tbjr_status`,`tbjr`.`tbjr_uuid` AS `tbjr_uuid`,`tbr`.`tbr_id` AS `tbr_id`,`tbr`.`tbr_create_date` AS `tbr_create_date`,`tbr`.`tbr_create_id` AS `tbr_create_id`,`tbr`.`tbr_create_idc` AS `tbr_create_idc`,`tbr`.`tbr_update_date` AS `tbr_update_date`,`tbr`.`tbr_update_id` AS `tbr_update_id`,`tbr`.`tbr_data_name_raw` AS `tbr_data_name_raw`,`tbr`.`tbr_data_name_first` AS `tbr_data_name_first`,`tbr`.`tbr_data_name_last` AS `tbr_data_name_last`,`tbr`.`tbr_data_name_middle` AS `tbr_data_name_middle`,`tbr`.`tbr_data_name_title` AS `tbr_data_name_title`,`tbr`.`tbr_data_phone_numbers` AS `tbr_data_phone_numbers`,`tbr`.`tbr_data_websites` AS `tbr_data_websites`,`tbr`.`tbr_data_emails` AS `tbr_data_emails`,`tbr`.`tbr_data_date_of_birth` AS `tbr_data_date_of_birth`,`tbr`.`tbr_data_location_formatted` AS `tbr_data_location_formatted`,`tbr`.`tbr_data_location_postal_code` AS `tbr_data_location_postal_code`,`tbr`.`tbr_data_location_state` AS `tbr_data_location_state`,`tbr`.`tbr_data_location_country` AS `tbr_data_location_country`,`tbr`.`tbr_data_location_country_code` AS `tbr_data_location_country_code`,`tbr`.`tbr_data_location_raw_input` AS `tbr_data_location_raw_input`,`tbr`.`tbr_data_location_street_number` AS `tbr_data_location_street_number`,`tbr`.`tbr_data_location_street` AS `tbr_data_location_street`,`tbr`.`tbr_data_location_apartment_number` AS `tbr_data_location_apartment_number`,`tbr`.`tbr_data_location_city` AS `tbr_data_location_city`,`tbr`.`tbr_data_objective` AS `tbr_data_objective`,`tbr`.`tbr_data_languages` AS `tbr_data_languages`,`tbr`.`tbr_data_language_codes` AS `tbr_data_language_codes`,`tbr`.`tbr_data_summary` AS `tbr_data_summary`,`tbr`.`tbr_data_total_years_experience` AS `tbr_data_total_years_experience`,`tbr`.`tbr_data_head_shot` AS `tbr_data_head_shot`,`tbr`.`tbr_data_education` AS `tbr_data_education`,`tbr`.`tbr_data_profession` AS `tbr_data_profession`,`tbr`.`tbr_data_linkedin` AS `tbr_data_linkedin`,`tbr`.`tbr_data_work_experience` AS `tbr_data_work_experience`,`tbr`.`tbr_data_skills` AS `tbr_data_skills`,`tbr`.`tbr_data_certifications` AS `tbr_data_certifications`,`tbr`.`tbr_data_publications` AS `tbr_data_publications`,`tbr`.`tbr_data_referees` AS `tbr_data_referees`,`tbr`.`tbr_data_sections` AS `tbr_data_sections`,`tbr`.`tbr_data_is_resume_probability` AS `tbr_data_is_resume_probability`,`tbr`.`tbr_data_raw_text` AS `tbr_data_raw_text`,`tbr`.`tbr_meta_identifier` AS `tbr_meta_identifier`,`tbr`.`tbr_meta_file_name` AS `tbr_meta_file_name`,`tbr`.`tbr_meta_ready` AS `tbr_meta_ready`,`tbr`.`tbr_meta_ready_dt` AS `tbr_meta_ready_dt`,`tbr`.`tbr_meta_failed` AS `tbr_meta_failed`,`tbr`.`tbr_meta_expiry_time` AS `tbr_meta_expiry_time`,`tbr`.`tbr_meta_language` AS `tbr_meta_language`,`tbr`.`tbr_meta_pdf` AS `tbr_meta_pdf`,`tbr`.`tbr_meta_parent_document_identifier` AS `tbr_meta_parent_document_identifier`,`tbr`.`tbr_meta_child_documents` AS `tbr_meta_child_documents`,`tbr`.`tbr_meta_pages` AS `tbr_meta_pages`,`tbr`.`tbr_meta_is_verified` AS `tbr_meta_is_verified`,`tbr`.`tbr_meta_review_url` AS `tbr_meta_review_url`,`tbr`.`tbr_meta_ocr_confidence` AS `tbr_meta_ocr_confidence`,`tbr`.`tbr_error_error_code` AS `tbr_error_error_code`,`tbr`.`tbr_error_error_detail` AS `tbr_error_error_detail`,`tbr`.`tbr_status` AS `tbr_status`,`tbr`.`tbr_uuid` AS `tbr_uuid` from ((`tb_job` `tbj` left join `tb_job_resume` `tbjr` on(`tbjr`.`tbj_id` = `tbj`.`tbj_id`)) left join `tb_resume` `tbr` on(`tbr`.`tbr_id` = `tbjr`.`tbr_id`)) */;
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

-- Dump completed on 2023-01-25 22:29:20
