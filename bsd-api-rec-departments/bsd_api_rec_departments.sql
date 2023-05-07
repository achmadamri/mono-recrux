-- MariaDB dump 10.19  Distrib 10.4.27-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: bsd_api_rec_departments
-- ------------------------------------------------------
-- Server version	10.4.27-MariaDB

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department`
--

LOCK TABLES `tb_department` WRITE;
/*!40000 ALTER TABLE `tb_department` DISABLE KEYS */;
INSERT INTO `tb_department` VALUES (1,NULL,28,1,'2023-03-25 15:21:44',28,'CEO','active','26EYH'),(2,NULL,28,1,'2023-03-25 14:54:27',28,'IT','active','9IFU7'),(3,NULL,28,1,'2023-01-05 13:42:42',28,'Product','active','6H74K'),(4,NULL,28,1,'2023-01-24 12:16:47',28,'Sales','active','7KJU8'),(5,'2023-01-03 09:11:23',28,1,'2023-02-02 04:37:48',28,'Legal','active','4LO6G'),(7,'2023-01-03 15:39:43',28,1,'2023-01-05 13:25:46',28,'Human Resources','active','0AWNA'),(8,'2023-01-03 15:42:56',28,1,'2023-01-04 09:35:43',28,'Operation','active','1WV47'),(9,'2023-01-03 15:43:28',28,1,'2023-01-04 08:33:25',28,'Data Science','active','Q1ITU'),(10,'2023-01-05 13:26:04',28,1,NULL,NULL,'Finance','active','1DSMX'),(11,'2023-01-05 13:28:10',28,1,NULL,NULL,'Public Relation','active','YOODH');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department_job`
--

LOCK TABLES `tb_department_job` WRITE;
/*!40000 ALTER TABLE `tb_department_job` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
  `tbj_description` varchar(10000) DEFAULT NULL,
  `tbj_status` varchar(20) DEFAULT NULL,
  `tbj_uuid` varchar(50) DEFAULT NULL,
  `tbd_id` int(11) DEFAULT NULL,
  `tbj_assigned` varchar(20) DEFAULT NULL,
  `tbj_resume_status` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`tbj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_job`
--

LOCK TABLES `tb_job` WRITE;
/*!40000 ALTER TABLE `tb_job` DISABLE KEYS */;
INSERT INTO `tb_job` VALUES (1,'2023-05-01 05:20:47',28,1,'2023-05-06 16:33:27',28,'IT Head','IT Head\n\nJob Summary:\n\nThe IT Head is responsible for leading the IT department and overseeing all IT operations. This position will be responsible for developing and implementing IT strategies, managing IT staff, and ensuring the security and reliability of the organizations IT systems.\n\nResponsibilities:\n\n Develop and implement IT strategies and plans that align with the organizations business objectives.\n Manage and oversee the IT department, including hiring, training, and evaluating staff.\n Ensure the security and reliability of the organizations IT systems.\n Monitor and analyze IT performance and recommend improvements.\n Research and evaluate new technologies and make recommendations for implementation.\n Develop and maintain IT policies and procedures.\n Manage IT budgets and ensure cost-effectiveness.\n Liaise with vendors and other stakeholders to ensure the smooth running of IT operations.\n Provide technical support and troubleshooting for IT systems.\n\nQualifications:\n\n Bachelors degree in Computer Science, Information Technology, or a related field.\n 5+ years of experience in IT management.\n Knowledge of IT systems, networks, and security protocols.\n Excellent problem-solving and communication skills.\n Ability to work independently and manage multiple projects.\n Strong leadership and organizational skills.','active','9J4B2',NULL,NULL,'Available, HR Interview, Hiring Manager Interview, Technical Test, Offer, Exclude'),(2,'2023-05-01 05:20:57',28,1,NULL,NULL,'Java Lead','\n\nJob Title: Java Lead\n\nLocation: Remote\n\nJob Summary:\n\nWe are looking for an experienced Java Lead to join our team. The Java Lead will be responsible for leading the development of Java-based applications and providing technical guidance to the development team. The ideal candidate will have a strong background in Java development and a passion for developing high-quality software.\n\nResponsibilities:\n\n Lead the development of Java-based applications, ensuring that all code is written to the highest standards.\n\n Provide technical guidance and mentorship to the development team.\n\n Design and implement efficient and reliable software solutions.\n\n Troubleshoot and debug software issues.\n\n Monitor and optimize application performance.\n\n Ensure that all software is developed in accordance with industry best practices.\n\n Stay up-to-date with the latest technologies and trends in the Java development space.\n\nRequirements:\n\n Bachelors degree in Computer Science or related field.\n\n 5+ years of experience in Java development.\n\n Expertise in object-oriented programming and design patterns.\n\n Experience with web services and REST APIs.\n\n Knowledge of databases and SQL.\n\n Excellent problem-solving and communication skills.\n\n Ability to work independently and as part of a team.','active','YFRJZ',NULL,NULL,'Available, HR Interview, Hiring Manager Interview, Technical Test, Offer, Exclude'),(3,'2023-05-01 05:21:04',28,1,NULL,NULL,'IOS Lead','\n\nIOS Lead\n\nJob Summary:\n\nWe are looking for an experienced IOS Lead to join our team and lead the development of our IOS applications. The IOS Lead will be responsible for developing, testing, and deploying IOS applications, as well as managing the team of IOS developers.\n\nResponsibilities:\n\n Develop, test, and deploy IOS applications.\n\n Manage the team of IOS developers.\n\n Monitor and maintain the performance of IOS applications.\n\n Troubleshoot and resolve any issues with IOS applications.\n\n Ensure that all IOS applications are up to date with the latest technologies.\n\n Collaborate with other teams to ensure that IOS applications are integrated with other systems.\n\n Provide technical guidance and support to the IOS development team.\n\n Stay up to date with the latest IOS technologies and trends.\n\nRequirements:\n\n Bachelors degree in Computer Science, Information Technology, or related field.\n\n 5+ years of experience developing IOS applications.\n\n Expert knowledge of IOS development tools and frameworks.\n\n Experience managing and leading a team of IOS developers.\n\n Excellent problem-solving and communication skills.\n\n Ability to work independently and as part of a team.','active','KJ00D',NULL,NULL,'Available, HR Interview, Hiring Manager Interview, Technical Test, Offer, Exclude'),(4,'2023-05-01 05:21:10',28,1,NULL,NULL,'Android Lead','\n\nAndroid Lead\n\nJob Summary:\n\nWe are looking for an experienced Android Lead to join our team and lead the development of our Android applications. The Android Lead will be responsible for designing, developing, and maintaining our Android applications, as well as providing technical guidance and support to the Android development team.\n\nResponsibilities:\n\n Design, develop, and maintain Android applications.\n\n Lead the Android development team and provide technical guidance and support.\n\n Collaborate with other teams to ensure successful integration of Android applications with other systems.\n\n Monitor and optimize application performance.\n\n Troubleshoot and debug application issues.\n\n Develop and maintain documentation related to Android applications.\n\n Stay up-to-date with the latest Android technologies and trends.\n\nRequirements:\n\n Bachelors degree in Computer Science, Software Engineering, or related field.\n\n 5+ years of experience developing Android applications.\n\n Expert knowledge of Java, Kotlin, and Android SDK.\n\n Experience with Android Studio, Gradle, and other development tools.\n\n Knowledge of RESTful APIs and web services.\n\n Excellent problem-solving and communication skills.\n\n Ability to work independently and as part of a team.','active','G19QI',NULL,NULL,'Available, HR Interview, Hiring Manager Interview, Technical Test, Offer, Exclude'),(5,'2023-05-01 09:54:25',28,1,'2023-05-01 10:24:25',28,'Java Programmer','Job Title: Java Programmer\n\nJob Summary:\n\nWe are looking for an experienced Java Programmer to join our team. The successful candidate will be responsible for developing, testing, and maintaining software applications using the Java programming language. The ideal candidate should have a strong understanding of object-oriented programming principles and be able to work independently and collaboratively.\n\nResponsibilities:\n\n Develop, test, and maintain software applications using the Java programming language\n Design and implement software solutions to meet customer requirements\n Troubleshoot and debug software applications\n Create and maintain technical documentation\n Collaborate with other developers and stakeholders to ensure successful project completion\n Stay up-to-date with the latest technologies and trends\n\nRequirements:\n Bachelors degree in Computer Science or related field\n 5+ years of experience in software development\n Expertise in Java programming language\n Knowledge of object-oriented programming principles\n Experience with web development frameworks such as Spring and Hibernate\n Familiarity with databases such as MySQL and Oracle\n Excellent problem-solving and communication skills\n Ability to work independently and collaboratively','active','INYXD',NULL,NULL,'Available, HR Interview, Hiring Manager Interview, Technical Test, Offer, Exclude');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_job_resume`
--

LOCK TABLES `tb_job_resume` WRITE;
/*!40000 ALTER TABLE `tb_job_resume` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
  `tbr_data_name_raw` text DEFAULT NULL,
  `tbr_data_name_first` text DEFAULT NULL,
  `tbr_data_name_last` text DEFAULT NULL,
  `tbr_data_name_middle` text DEFAULT NULL,
  `tbr_data_name_title` text DEFAULT NULL,
  `tbr_data_phone_numbers` text DEFAULT NULL,
  `tbr_data_websites` text DEFAULT NULL,
  `tbr_data_emails` text DEFAULT NULL,
  `tbr_data_date_of_birth` text DEFAULT NULL,
  `tbr_data_location_formatted` text DEFAULT NULL,
  `tbr_data_location_postal_code` text DEFAULT NULL,
  `tbr_data_location_state` text DEFAULT NULL,
  `tbr_data_location_country` text DEFAULT NULL,
  `tbr_data_location_country_code` text DEFAULT NULL,
  `tbr_data_location_raw_input` text DEFAULT NULL,
  `tbr_data_location_street_number` text DEFAULT NULL,
  `tbr_data_location_street` text DEFAULT NULL,
  `tbr_data_location_apartment_number` text DEFAULT NULL,
  `tbr_data_location_city` text DEFAULT NULL,
  `tbr_data_objective` text DEFAULT NULL,
  `tbr_data_languages` text DEFAULT NULL,
  `tbr_data_language_codes` text DEFAULT NULL,
  `tbr_data_summary` text DEFAULT NULL,
  `tbr_data_total_years_experience` int(11) DEFAULT NULL,
  `tbr_data_head_shot` text DEFAULT NULL,
  `tbr_data_education` text DEFAULT NULL,
  `tbr_data_profession` text DEFAULT NULL,
  `tbr_data_linkedin` text DEFAULT NULL,
  `tbr_data_work_experience` text DEFAULT NULL,
  `tbr_data_skills` text DEFAULT NULL,
  `tbr_data_certifications` text DEFAULT NULL,
  `tbr_data_publications` text DEFAULT NULL,
  `tbr_data_referees` text DEFAULT NULL,
  `tbr_data_sections` text DEFAULT NULL,
  `tbr_data_is_resume_probability` int(11) DEFAULT NULL,
  `tbr_data_raw_text` text DEFAULT NULL,
  `tbr_meta_identifier` text DEFAULT NULL,
  `tbr_meta_file_name` text DEFAULT NULL,
  `tbr_meta_ready` int(11) DEFAULT NULL,
  `tbr_meta_ready_dt` text DEFAULT NULL,
  `tbr_meta_failed` int(11) DEFAULT NULL,
  `tbr_meta_expiry_time` text DEFAULT NULL,
  `tbr_meta_language` text DEFAULT NULL,
  `tbr_meta_pdf` text DEFAULT NULL,
  `tbr_meta_parent_document_identifier` text DEFAULT NULL,
  `tbr_meta_child_documents` text DEFAULT NULL,
  `tbr_meta_pages` text DEFAULT NULL,
  `tbr_meta_is_verified` int(11) DEFAULT NULL,
  `tbr_meta_review_url` text DEFAULT NULL,
  `tbr_meta_ocr_confidence` double DEFAULT NULL,
  `tbr_error_error_code` text DEFAULT NULL,
  `tbr_error_error_detail` text DEFAULT NULL,
  `tbr_status` varchar(20) DEFAULT NULL,
  `tbr_uuid` varchar(5) DEFAULT NULL,
  `tbj_id` int(11) DEFAULT NULL,
  `tbr_assigned` varchar(20) DEFAULT NULL,
  `tbr_score` int(11) DEFAULT NULL,
  `tbr_star` int(11) DEFAULT NULL,
  `tbr_note` text DEFAULT NULL,
  `tbr_resume_status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tbr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume`
--

LOCK TABLES `tb_resume` WRITE;
/*!40000 ALTER TABLE `tb_resume` DISABLE KEYS */;
INSERT INTO `tb_resume` VALUES (1,'2023-05-01 09:55:14',28,1,'2023-05-06 16:24:22',28,'Achmad  Amri','Achmad','Amri',NULL,NULL,'081380782318',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CV Achmad Amri 03102022 (1).pdf_AXFM8.pdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','I5ZD3',5,'assigned',153,0,NULL,'Available'),(2,'2023-05-01 09:55:14',28,1,'2023-05-07 09:06:57',28,'Adri  Aulia','Adri','Aulia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CV Adri Aulia Rakhman Latest.pdf_E0VWJ.pdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','SSUOR',5,'assigned',169,3,NULL,'HR Interview'),(3,'2023-05-01 09:55:14',28,1,'2023-05-07 10:25:31',28,'Cedi  Haryo','Cedi','Haryo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Cedi Haryo - QA.docx.pdf_9J8QR.pdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','AYMEL',5,'assigned',124,0,NULL,'HR Interview'),(4,'2023-05-01 09:56:35',28,1,'2023-05-07 10:25:40',28,'Cedi  Haryo','Cedi','Haryo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Cedi Haryo - QA.docx.pdf_I3GIV.pdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','CLZB6',1,'assigned',135,0,NULL,'Available'),(5,'2023-05-01 09:56:35',28,1,'2023-05-01 09:56:55',0,'Adri Aulia','Adri','Aulia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CV Adri Aulia Rakhman Latest.pdf_7P89Q.pdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','Q48BB',1,'assigned',174,0,NULL,'HR Interview'),(6,'2023-05-01 09:56:35',28,1,'2023-05-01 09:56:56',0,'Achmad Amri','Achmad','Amri',NULL,NULL,'081380782318',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CV Achmad Amri 03102022 (1).pdf_DP7D9.pdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','46TD5',1,'assigned',150,0,NULL,'Hiring Manager Interview'),(7,'2023-05-01 09:56:51',28,1,'2023-05-07 10:25:20',28,'Cedi  Haryo','Cedi','Haryo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Cedi Haryo - QA.docx.pdf_HJ8FP.pdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','VX19M',2,'assigned',139,0,NULL,'Available'),(8,'2023-05-01 09:56:51',28,1,'2023-05-01 09:57:14',0,'Adri Aulia','Adri','Aulia',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CV Adri Aulia Rakhman Latest.pdf_GAY5Q.pdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','HPLY2',2,'assigned',157,1,NULL,'HR Interview'),(9,'2023-05-01 09:56:51',28,1,'2023-05-01 11:07:01',28,'Achmad  Amri','Achmad','Amri',NULL,NULL,'081380782318',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'CV Achmad Amri 03102022 (1).pdf_N7ZUT.pdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','M58C3',2,'assigned',171,1,NULL,'Technical Test');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume_certification`
--

LOCK TABLES `tb_resume_certification` WRITE;
/*!40000 ALTER TABLE `tb_resume_certification` DISABLE KEYS */;
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
  `tbre_text` text DEFAULT NULL,
  PRIMARY KEY (`tbre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume_education`
--

LOCK TABLES `tb_resume_education` WRITE;
/*!40000 ALTER TABLE `tb_resume_education` DISABLE KEYS */;
INSERT INTO `tb_resume_education` VALUES (1,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','SCB4I','2005 to 2011 Gunadarma University â Depok Indonesian'),(2,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','D3YU3','S1 Information System'),(3,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','6KLEV','CGPA : 3.32'),(4,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','MU862','2002 to 2005 SMA Muhammadiyah 11, Jakarta â Indonesia.'),(5,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','187L3',' â¢ âPemrograman web dengan menggunakan PHP dan MYSQLâ'),(6,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','BMK8J','At Lembaga Pengembangan Teknologi Universitas Gunadarma, 2002 â¢ âPemrograman database dengan Visual Basic dan MsAccessâ'),(7,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','HT4MV','At Lembaga Pengembangan Teknologi Universitas Gunadarma, 2001 â¢ Oracle SOA Assessment and Enablement'),(8,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','4LR8R','Oracle Indonesia, 2011'),(9,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','629R5','WORKING EXPERIENCES:'),(10,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','41ZD5','PT. BTECHNO SOLUSI DIGITAL as Founder - eCommerce Implementation '),(11,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','N3XTB',': Manajemen Informatika, Fakultas Ilmu Komputer Universitas Gunadarma, 2006 Teknik Informatika, MDP Palembang, 2000 SMAN 10 Palembang 1999 SMPN 1 Palembang 1993'),(12,'2023-05-01 09:56:55',28,1,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','QDW1P','2005 to 2011 Gunadarma University â Depok Indonesian'),(13,'2023-05-01 09:56:55',28,1,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','3S7SD','S1 Information System'),(14,'2023-05-01 09:56:55',28,1,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','HLPJB','CGPA : 3.32'),(15,'2023-05-01 09:56:55',28,1,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','HJSSN','2002 to 2005 SMA Muhammadiyah 11, Jakarta â Indonesia.'),(16,'2023-05-01 09:56:56',28,1,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','XED2E',' â¢ âPemrograman web dengan menggunakan PHP dan MYSQLâ'),(17,'2023-05-01 09:56:56',28,1,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','U42KN','At Lembaga Pengembangan Teknologi Universitas Gunadarma, 2002 â¢ âPemrograman database dengan Visual Basic dan MsAccessâ'),(18,'2023-05-01 09:56:56',28,1,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','2FF5A','At Lembaga Pengembangan Teknologi Universitas Gunadarma, 2001 â¢ Oracle SOA Assessment and Enablement'),(19,'2023-05-01 09:56:56',28,1,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','I3Y8T','Oracle Indonesia, 2011'),(20,'2023-05-01 09:56:56',28,1,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','6FZY1','WORKING EXPERIENCES:'),(21,'2023-05-01 09:56:56',28,1,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','HKCOZ','PT. BTECHNO SOLUSI DIGITAL as Founder - eCommerce Implementation '),(22,'2023-05-01 09:56:56',28,1,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','HM02O',': Manajemen Informatika, Fakultas Ilmu Komputer Universitas Gunadarma, 2006 Teknik Informatika, MDP Palembang, 2000 SMAN 10 Palembang 1999 SMPN 1 Palembang 1993'),(23,'2023-05-01 09:57:14',28,1,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','M3XNV','2005 to 2011 Gunadarma University â Depok Indonesian'),(24,'2023-05-01 09:57:14',28,1,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','O22UY','S1 Information System'),(25,'2023-05-01 09:57:14',28,1,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','G4H1U','CGPA : 3.32'),(26,'2023-05-01 09:57:14',28,1,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','E5NYB','2002 to 2005 SMA Muhammadiyah 11, Jakarta â Indonesia.'),(27,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','MB196',' â¢ âPemrograman web dengan menggunakan PHP dan MYSQLâ'),(28,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','KEWZ5','At Lembaga Pengembangan Teknologi Universitas Gunadarma, 2002 â¢ âPemrograman database dengan Visual Basic dan MsAccessâ'),(29,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','ZJ9K6','At Lembaga Pengembangan Teknologi Universitas Gunadarma, 2001 â¢ Oracle SOA Assessment and Enablement'),(30,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','DV8NM','Oracle Indonesia, 2011'),(31,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','FN8VI','WORKING EXPERIENCES:'),(32,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','TY6UM','PT. BTECHNO SOLUSI DIGITAL as Founder - eCommerce Implementation '),(33,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','4FBI6',': Manajemen Informatika, Fakultas Ilmu Komputer Universitas Gunadarma, 2006 Teknik Informatika, MDP Palembang, 2000 SMAN 10 Palembang 1999 SMPN 1 Palembang 1993'),(34,'2023-05-01 10:39:49',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','VRB9A',NULL),(35,'2023-05-01 10:39:51',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','N3RZH',NULL),(36,'2023-05-01 10:39:56',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','EPQ9P',NULL),(37,'2023-05-01 10:39:59',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','GB7KC',NULL),(38,'2023-05-06 15:45:25',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','MMU2G',NULL),(39,'2023-05-06 15:45:42',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','Y4DFZ',NULL),(40,'2023-05-06 15:46:17',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','97OGT',NULL),(41,'2023-05-06 15:47:58',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','19ONC',NULL),(42,'2023-05-06 15:47:59',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','B8XA9',NULL),(43,'2023-05-06 15:48:00',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','CYQ7B',NULL),(44,'2023-05-06 15:48:00',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','10YIO',NULL),(45,'2023-05-06 15:48:00',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','AGPJU',NULL),(46,'2023-05-06 15:48:01',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','T61IY',NULL),(47,'2023-05-06 15:48:02',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','NKY5G',NULL),(48,'2023-05-06 15:49:17',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','IIIPL',NULL),(49,'2023-05-06 15:49:17',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','L7R45',NULL),(50,'2023-05-06 15:49:22',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','UVRHF',NULL),(51,'2023-05-06 15:49:23',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','4ILZE',NULL),(52,'2023-05-06 15:49:24',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','ZYIGR',NULL),(53,'2023-05-06 15:49:24',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','CJV26',NULL),(54,'2023-05-06 15:49:25',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'not active','MN654',NULL),(55,'2023-05-06 15:49:26',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','VQ1LU',NULL),(56,'2023-05-06 15:49:28',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','TOTNF',NULL),(57,'2023-05-06 15:49:28',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','DW7F0',NULL),(58,'2023-05-06 15:49:29',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','TI3ZL',NULL),(59,'2023-05-06 15:49:30',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','1RHPB',NULL),(60,'2023-05-06 15:49:34',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','H8ESY',NULL),(61,'2023-05-06 15:49:35',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','UN0BV',NULL),(62,'2023-05-06 15:49:37',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','WGJ8Z',NULL),(63,'2023-05-06 15:49:37',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','09Y26',NULL),(64,'2023-05-06 15:49:38',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','HPUK6',NULL),(65,'2023-05-06 15:49:39',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','O2K7Q',NULL),(66,'2023-05-06 15:49:39',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','JCLW7',NULL),(67,'2023-05-06 15:49:40',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','BE2V1',NULL),(68,'2023-05-06 15:49:40',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','ETMAR',NULL),(69,'2023-05-06 15:49:41',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','CD8NV',NULL),(70,'2023-05-06 15:49:41',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','8U9MV',NULL),(71,'2023-05-06 15:49:42',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','BB2WQ',NULL),(72,'2023-05-06 15:52:33',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','88V7J',NULL),(73,'2023-05-06 15:52:34',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','TK8GK',NULL),(74,'2023-05-06 15:52:35',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','LR42H',NULL),(75,'2023-05-06 16:14:04',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','TBSF2',NULL),(76,'2023-05-06 16:14:05',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','5JS9O',NULL),(77,'2023-05-06 16:14:07',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','Z4344',NULL),(78,'2023-05-06 16:14:08',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','K3MQV',NULL),(79,'2023-05-06 16:14:09',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','BUB0I',NULL),(80,'2023-05-06 16:14:09',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','RUG0D',NULL),(81,'2023-05-06 16:14:10',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','GV5ZB',NULL),(82,'2023-05-06 16:14:10',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','0RS90',NULL),(83,'2023-05-06 16:14:11',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','G1QCD',NULL),(84,'2023-05-06 16:14:11',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','Q7GB3',NULL),(85,'2023-05-06 16:14:12',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','RR2SD',NULL),(86,'2023-05-06 16:14:12',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','B10EH',NULL),(87,'2023-05-06 16:14:12',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','OAAJV',NULL),(88,'2023-05-06 16:14:15',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','P59YT',NULL),(89,'2023-05-06 16:14:15',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','77IDK',NULL),(90,'2023-05-06 16:15:47',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','TWVRA',NULL),(91,'2023-05-06 16:15:48',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','8TFAL',NULL),(92,'2023-05-06 16:17:55',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','LM6IG',NULL),(93,'2023-05-06 16:17:56',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','JOVYK',NULL),(94,'2023-05-06 16:17:57',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','VHES4',NULL),(95,'2023-05-06 16:17:59',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','L9UPS',NULL),(96,'2023-05-06 16:18:00',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','F08DK',NULL),(97,'2023-05-06 16:18:00',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','JVVBY',NULL),(98,'2023-05-07 09:06:56',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','PSXC1',NULL),(99,'2023-05-07 09:06:57',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','7Z0KA',NULL);
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
  `tbrs_score` int(11) DEFAULT NULL,
  `tbrs_last_used` datetime DEFAULT NULL,
  `tbrs_number_of_months` int(11) DEFAULT NULL,
  `tbrs_type` varchar(255) DEFAULT NULL,
  `tbrs_status` varchar(20) DEFAULT NULL,
  `tbrs_uuid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`tbrs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume_skill`
--

LOCK TABLES `tb_resume_skill` WRITE;
/*!40000 ALTER TABLE `tb_resume_skill` DISABLE KEYS */;
INSERT INTO `tb_resume_skill` VALUES (1,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Networking',8,NULL,NULL,'hard_skill','active','44232'),(2,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Presentation',5,NULL,NULL,'hard_skill','active','DHKER'),(3,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Plan',6,NULL,NULL,'hard_skill','active','719EI'),(4,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Installation',7,NULL,NULL,'hard_skill','active','WK4OL'),(5,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Improvement',7,NULL,NULL,'hard_skill','active','G5GON'),(6,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Schedule',6,NULL,NULL,'hard_skill','active','TN21E'),(7,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Operations',8,NULL,NULL,'hard_skill','active','HD0JI'),(8,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Automation',8,NULL,NULL,'hard_skill','active','71P79'),(9,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'System',9,NULL,NULL,'hard_skill','active','F4C30'),(10,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Linux',8,NULL,NULL,'hard_skill','active','8Q0AR'),(11,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Reporting',7,NULL,NULL,'hard_skill','active','SWWHI'),(12,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Cisco',8,NULL,NULL,'hard_skill','active','I8Q04'),(13,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Testing',8,NULL,NULL,'hard_skill','active','3HNVC'),(14,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Benchmarking',7,NULL,NULL,'hard_skill','active','PNREI'),(15,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Training',6,NULL,NULL,'hard_skill','active','ZK5QP'),(16,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Scripting',8,NULL,NULL,'hard_skill','active','C1MJ3'),(17,'2023-05-01 09:55:42',28,1,NULL,NULL,3,'Troubleshooting',8,NULL,NULL,'hard_skill','active','J6DXB'),(18,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Analytical',10,NULL,NULL,'hard_skill','active','WNY1Y'),(19,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Data Entry',8,NULL,NULL,'hard_skill','active','8ARLN'),(20,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Java',10,NULL,NULL,'hard_skill','active','AOEUD'),(21,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'MySQL',8,NULL,NULL,'hard_skill','active','EAUHT'),(22,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'CSS',8,NULL,NULL,'hard_skill','active','B9MBT'),(23,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'System',8,NULL,NULL,'hard_skill','active','QR8L8'),(24,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Javascript',8,NULL,NULL,'hard_skill','active','1QV6B'),(25,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Analysis',9,NULL,NULL,'hard_skill','active','0Q4UL'),(26,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Hospitality',3,NULL,NULL,'hard_skill','active','Y3TKW'),(27,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Email',8,NULL,NULL,'hard_skill','active','3EVPN'),(28,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Excel',8,NULL,NULL,'hard_skill','active','Q3OC2'),(29,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Health',4,NULL,NULL,'hard_skill','active','7RHYL'),(30,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Mobile',7,NULL,NULL,'hard_skill','active','128JB'),(31,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Programming',10,NULL,NULL,'hard_skill','active','58DK6'),(32,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Licensing',6,NULL,NULL,'hard_skill','active','UDFYX'),(33,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Word',7,NULL,NULL,'hard_skill','active','6TXMU'),(34,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'SQL',8,NULL,NULL,'hard_skill','active','5IJJ4'),(35,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Jira',7,NULL,NULL,'hard_skill','active','WBBA0'),(36,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'XML',8,NULL,NULL,'hard_skill','active','0KQR5'),(37,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'English',8,NULL,NULL,'hard_skill','active','OH7GB'),(38,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'HTML',8,NULL,NULL,'hard_skill','active','PD5CS'),(39,'2023-05-01 09:55:42',28,1,NULL,NULL,2,'Database',8,NULL,NULL,'hard_skill','active','9A1EM'),(40,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'PHP',8,NULL,NULL,'hard_skill','active','VD28K'),(41,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Jira',8,NULL,NULL,'hard_skill','active','ZUM6D'),(42,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Machine Learning',7,NULL,NULL,'hard_skill','active','SBQHW'),(43,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Microsoft Excel',8,NULL,NULL,'hard_skill','active','QQYDH'),(44,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Microsoft Word',8,NULL,NULL,'hard_skill','active','3ZI5Q'),(45,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Word',6,NULL,NULL,'hard_skill','active','DDMEW'),(46,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Proposal',6,NULL,NULL,'hard_skill','active','R89BB'),(47,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Process',7,NULL,NULL,'hard_skill','active','R9IKI'),(48,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'SQL',9,NULL,NULL,'hard_skill','active','ZNM3D'),(49,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Ubuntu',6,NULL,NULL,'hard_skill','active','RBQOA'),(50,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Ecommerce',7,NULL,NULL,'hard_skill','active','W6SDW'),(51,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Design',7,NULL,NULL,'hard_skill','active','LBJ1H'),(52,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'C++',6,NULL,NULL,'hard_skill','active','7QCPU'),(53,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Vendors',6,NULL,NULL,'hard_skill','active','54AMZ'),(54,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Strategy',6,NULL,NULL,'hard_skill','active','GGO3Y'),(55,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Technical',8,NULL,NULL,'hard_skill','active','UFGU0'),(56,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'PostgreSQL',8,NULL,NULL,'hard_skill','active','UZQGQ'),(57,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Oracle',8,NULL,NULL,'hard_skill','active','I2FIU'),(58,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Excel',8,NULL,NULL,'hard_skill','active','4NYJ6'),(59,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'Database',8,NULL,NULL,'hard_skill','active','4BAUH'),(60,'2023-05-01 09:55:47',28,1,NULL,NULL,1,'MySQL',8,NULL,NULL,'hard_skill','active','KI6YU'),(61,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Benchmarking',8,NULL,NULL,'hard_skill','active','9WH18'),(62,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Troubleshooting',9,NULL,NULL,'hard_skill','active','T537X'),(63,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Testing',8,NULL,NULL,'hard_skill','active','MD5AB'),(64,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Presentation',6,NULL,NULL,'hard_skill','active','L3QOM'),(65,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Schedule',7,NULL,NULL,'hard_skill','active','CIR68'),(66,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Scripting',8,NULL,NULL,'hard_skill','active','N371I'),(67,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Linux',9,NULL,NULL,'hard_skill','active','3H2U0'),(68,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Networking',9,NULL,NULL,'hard_skill','active','IVYFQ'),(69,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Plan',8,NULL,NULL,'hard_skill','active','CFRM6'),(70,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Training',7,NULL,NULL,'hard_skill','active','M85JY'),(71,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Automation',8,NULL,NULL,'hard_skill','active','GOOSM'),(72,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Operations',8,NULL,NULL,'hard_skill','active','2VVN2'),(73,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Installation',8,NULL,NULL,'hard_skill','active','Z0QSS'),(74,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Improvement',8,NULL,NULL,'hard_skill','active','9WQ7H'),(75,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Cisco',8,NULL,NULL,'hard_skill','active','2O7UA'),(76,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'System',9,NULL,NULL,'hard_skill','active','0UUNA'),(77,'2023-05-01 09:57:00',28,1,NULL,NULL,4,'Reporting',7,NULL,NULL,'hard_skill','active','8AHQZ'),(78,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Mobile',8,NULL,NULL,'hard_skill','active','OE85R'),(79,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Jira',8,NULL,NULL,'hard_skill','active','L7GT6'),(80,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'English',9,NULL,NULL,'hard_skill','active','O5UJH'),(81,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Health',5,NULL,NULL,'hard_skill','active','AY9JS'),(82,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'SQL',9,NULL,NULL,'hard_skill','active','ZX47W'),(83,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Word',8,NULL,NULL,'hard_skill','active','H57E4'),(84,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Excel',8,NULL,NULL,'hard_skill','active','J2YLK'),(85,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Hospitality',5,NULL,NULL,'hard_skill','active','7TJQP'),(86,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Database',9,NULL,NULL,'hard_skill','active','BA8W0'),(87,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Javascript',8,NULL,NULL,'hard_skill','active','VWX5R'),(88,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Oracle',8,NULL,NULL,'hard_skill','active','LCRTN'),(89,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'MySQL',8,NULL,NULL,'hard_skill','active','IP9R7'),(90,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'System',9,NULL,NULL,'hard_skill','active','WR7EH'),(91,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'HTML',8,NULL,NULL,'hard_skill','active','MX4SJ'),(92,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Data Entry',8,NULL,NULL,'hard_skill','active','3VS0T'),(93,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'XML',8,NULL,NULL,'hard_skill','active','I7BXX'),(94,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Analysis',9,NULL,NULL,'hard_skill','active','LAOTW'),(95,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Programming',9,NULL,NULL,'hard_skill','active','OUXW2'),(96,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Transactions',8,NULL,NULL,'hard_skill','active','L755Y'),(97,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'CSS',8,NULL,NULL,'hard_skill','active','B8K4S'),(98,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Email',8,NULL,NULL,'hard_skill','active','CLW12'),(99,'2023-05-01 09:57:01',28,1,NULL,NULL,5,'Licensing',6,NULL,NULL,'hard_skill','active','8KMXN'),(100,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Machine Learning',8,NULL,NULL,'hard_skill','active','LBD6R'),(101,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Schedule',7,NULL,NULL,'hard_skill','active','1R235'),(102,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Ubuntu',6,NULL,NULL,'hard_skill','active','KQTF5'),(103,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Cloud',8,NULL,NULL,'hard_skill','active','YRYM9'),(104,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Visual',6,NULL,NULL,'hard_skill','active','68XL7'),(105,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Oracle',7,NULL,NULL,'hard_skill','active','P8DU0'),(106,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Microsoft Excel',8,NULL,NULL,'hard_skill','active','O74K0'),(107,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Plan',7,NULL,NULL,'hard_skill','active','XM1ED'),(108,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Windows',8,NULL,NULL,'hard_skill','active','E5EHZ'),(109,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'MySQL',7,NULL,NULL,'hard_skill','active','0OVDS'),(110,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Distribution',6,NULL,NULL,'hard_skill','active','XPOPB'),(111,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'PostgreSQL',7,NULL,NULL,'hard_skill','active','CB053'),(112,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Ecommerce',6,NULL,NULL,'hard_skill','active','IIJKB'),(113,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Proposal',7,NULL,NULL,'hard_skill','active','XV2L3'),(114,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'C++',7,NULL,NULL,'hard_skill','active','N0S9L'),(115,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Design',8,NULL,NULL,'hard_skill','active','X7ZP7'),(116,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Vendors',6,NULL,NULL,'hard_skill','active','RCWM7'),(117,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Technical',8,NULL,NULL,'hard_skill','active','085HU'),(118,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Word',8,NULL,NULL,'hard_skill','active','QHDDA'),(119,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'Excel',8,NULL,NULL,'hard_skill','active','UP1FD'),(120,'2023-05-01 09:57:02',28,1,NULL,NULL,6,'PHP',7,NULL,NULL,'hard_skill','active','HLB63'),(121,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Operations',8,NULL,NULL,'hard_skill','active','VSYZT'),(122,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Scripting',9,NULL,NULL,'hard_skill','active','ZWFV8'),(123,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Reporting',8,NULL,NULL,'hard_skill','active','D7IWN'),(124,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Installation',8,NULL,NULL,'hard_skill','active','6TTI1'),(125,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Linux',9,NULL,NULL,'hard_skill','active','8HYPS'),(126,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Cisco',8,NULL,NULL,'hard_skill','active','VVF1A'),(127,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Benchmarking',7,NULL,NULL,'hard_skill','active','8N9D9'),(128,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Training',8,NULL,NULL,'hard_skill','active','60PVY'),(129,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Plan',8,NULL,NULL,'hard_skill','active','0Z6MY'),(130,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Networking',9,NULL,NULL,'hard_skill','active','0ALVQ'),(131,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Schedule',8,NULL,NULL,'hard_skill','active','SD85R'),(132,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Presentation',7,NULL,NULL,'hard_skill','active','80OJN'),(133,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Automation',9,NULL,NULL,'hard_skill','active','5OZFG'),(134,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Testing',8,NULL,NULL,'hard_skill','active','E8JV3'),(135,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Troubleshooting',8,NULL,NULL,'hard_skill','active','AAI9M'),(136,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'Improvement',8,NULL,NULL,'hard_skill','active','Z5UQ1'),(137,'2023-05-01 09:57:13',28,1,NULL,NULL,7,'System',9,NULL,NULL,'hard_skill','active','BZMHD'),(138,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'System',8,NULL,NULL,'hard_skill','active','QEUMR'),(139,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Postgresql',8,NULL,NULL,'hard_skill','active','QJJ74'),(140,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Plan',8,NULL,NULL,'hard_skill','active','0NZYL'),(141,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Java',10,NULL,NULL,'hard_skill','active','ZXS4B'),(142,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Schedule',8,NULL,NULL,'hard_skill','active','05RLV'),(143,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Oracle',8,NULL,NULL,'hard_skill','active','U5N6R'),(144,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Distribution',8,NULL,NULL,'hard_skill','active','E6WZM'),(145,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Process',8,NULL,NULL,'hard_skill','active','GRZPE'),(146,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Windows',8,NULL,NULL,'hard_skill','active','HRA2F'),(147,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Cloud',8,NULL,NULL,'hard_skill','active','O7GVU'),(148,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Design',8,NULL,NULL,'hard_skill','active','SLU83'),(149,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'PHP',6,NULL,NULL,'hard_skill','active','XCA5E'),(150,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Microsoft Excel',8,NULL,NULL,'hard_skill','active','BA0AC'),(151,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Technical',8,NULL,NULL,'hard_skill','active','GOYQM'),(152,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Ubuntu',7,NULL,NULL,'hard_skill','active','UNLJW'),(153,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Database',8,NULL,NULL,'hard_skill','active','EQZKK'),(154,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'C++',7,NULL,NULL,'hard_skill','active','TQM1K'),(155,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Visual',7,NULL,NULL,'hard_skill','active','DV6JM'),(156,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Proposal',7,NULL,NULL,'hard_skill','active','GEBBV'),(157,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Word',7,NULL,NULL,'hard_skill','active','G1QAK'),(158,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'Strategy',8,NULL,NULL,'hard_skill','active','J656X'),(159,'2023-05-01 09:57:20',28,1,NULL,NULL,9,'MySQL',8,NULL,NULL,'hard_skill','active','TNOLA'),(160,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Mobile',8,NULL,NULL,'hard_skill','active','GNNYF'),(161,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Jsp',8,NULL,NULL,'hard_skill','active','FC8SN'),(162,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Java',10,NULL,NULL,'hard_skill','active','0FL2W'),(163,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Correspondence',6,NULL,NULL,'hard_skill','active','ITT1G'),(164,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Word',6,NULL,NULL,'hard_skill','active','ZHQ4Y'),(165,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'English',8,NULL,NULL,'hard_skill','active','O31XZ'),(166,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Health',5,NULL,NULL,'hard_skill','active','SINJI'),(167,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'System',8,NULL,NULL,'hard_skill','active','5MB3Q'),(168,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Programming',9,NULL,NULL,'hard_skill','active','GX460'),(169,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Email',7,NULL,NULL,'hard_skill','active','JSXW7'),(170,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Licensing',6,NULL,NULL,'hard_skill','active','7PL6L'),(171,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Analysis',8,NULL,NULL,'hard_skill','active','OGSTQ'),(172,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Data entry',6,NULL,NULL,'hard_skill','active','ZUEV4'),(173,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Database',8,NULL,NULL,'hard_skill','active','42FU2'),(174,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'SQL',9,NULL,NULL,'hard_skill','active','UKR3O'),(175,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Hospitality',4,NULL,NULL,'hard_skill','active','0SHX7'),(176,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'XML',8,NULL,NULL,'hard_skill','active','O7WA0'),(177,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'HTML',8,NULL,NULL,'hard_skill','active','0V1J9'),(178,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Analytical',9,NULL,NULL,'hard_skill','active','GM6TA'),(179,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Oracle',8,NULL,NULL,'hard_skill','active','INK9D'),(180,'2023-05-01 09:57:21',28,1,NULL,NULL,8,'Javascript',8,NULL,NULL,'hard_skill','active','M8R9J');
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
  `tbrwe_text` text DEFAULT NULL,
  `tbrwe_start` varchar(255) DEFAULT NULL,
  `tbrwe_end` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tbrwe_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume_work_experience`
--

LOCK TABLES `tb_resume_work_experience` WRITE;
/*!40000 ALTER TABLE `tb_resume_work_experience` DISABLE KEYS */;
INSERT INTO `tb_resume_work_experience` VALUES (1,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','Y8JND',NULL,NULL,NULL),(2,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','R9XR4',NULL,NULL,NULL),(3,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,'Team Leader',NULL,'Government',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','XFUWO',' (since June 2013)\n\nSoftware and Platform: Java Language with spring and ibatis framework, using Eclipse tools and oracle\n\nfor database.\n\nPT. Gramedia Bookstore Data Entry (June, 2008 to July, 2008)\n\nAddress: Sunter Mall, Jl. Danau Sunter Utara, Tj. Priok, Kota Jkt Utara, Jakarta 14350\n\nDuration: June 2008 to July 2008\n\nRole: Data Entry\n\nfill up book list to database through internal application\n','April 2014',NULL),(4,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','VZZDL',NULL,NULL,NULL),(5,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','5KEE4',NULL,NULL,NULL),(6,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,'Manager',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','FX2QU',' to\n\nNovember, 2015)\n\nAddress: Lippo Kuningan Building 22th floor. HR. Rasuna Said kav.B12 Kuningan, Jakarta 12940, (+62)\n\n21 2964 4811 ext 453\n\n? elevenia.co.id is a product of PT XL Planet which is a joint venture\n\nbetween PT XL Axiata Tbk. and SK Planet Co., Ltd.\n\n? Transaction on elevenia means you can enjoy shopping system\n\nwith an open marketplace platform. Payment solutions we provide are\n\nEscrow System, which ensures the safe running transactions.\n\n','April, 2014',NULL),(7,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','BC693',NULL,NULL,NULL),(8,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,'Manager',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','MEQUY',' â Frontend Developer\n\nSoftware and Platform: Java Language with spring framework, using Eclipse tools and oracle for\n\ndatabase.\n\n?\n\nPT. Xybase Indonesia Java ','April 2014',NULL),(9,'2023-05-01 09:55:36',28,1,'2023-05-01 11:11:22',28,2,'Developer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','7Y2OY',')\n\nAddress: Menara Duta Building 4th floor, wing C. HR. Rasuna Said kav.B9 Kuningan, Jakarta 12910, (+62)\n\n21 550 5117\n\n? XYBASE is a systems integrator, IPR developer and solutions provider and have been\n\nimplemented a number of large IT projects and are known worldwide for our airport IT\n\nexpertise.\n\n','April, 2014',NULL),(10,'2023-05-01 09:55:36',28,1,'2023-05-07 10:25:31',28,3,'Engineer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','S9RFN',' h. Status Kepegawaian Pada Perusahaan ini\n\n: Kontrak\n\n3. a. Nama Kegiatan : IT Support Specialist b. Lokasi Kegiatan : Jakarta c. Pengguna Jasa : PT. Nalysa Microsoft partner d. Nama Perusahaan : PT. Nalysa Microsoft Partner e. Uraian Tugas : ? Handle maintenance andsupport\n\nevery client also PT Nalysa internal site ,this includes all maintenance procedures ,reporting, team management ,schedule maintenance and support priorities\n\n? Improve maintenance and support processes,by any actions\n\n? Back up operations scripting ,monitoring tool installation\n\n? Network bandwidth and QOS management\n\n? Computer installation automation ? Internal tools improvement such as\n\notrs, and qlickview\n\n2 dari 3\n\nFUSI SOLUSI TRANSFORMASI Manage Services Division\n\n? Benchmarking and new tools propositions\n\nf. Waktu Pelaksanaan : Mei 2015 / Juni 2016 g. Posisi Penugasan : IT Support Specialist h. Status Kepegawaian Pada Perusahaan ini\n\n: Kontrak\n\n4. a. Nama Kegiatan : IT Trainer and Software Tester b. Lokasi Kegiatan : Jakarta c. Pengguna Jasa : PT. Pharmindo Rimpang Kokoh d. Nama Perusahaan e.Uraian Tugas\n\n: :\n\nPT. Pharmindo Rimpang Kokoh ? Testing application role modul per modul ? Report bug to programmer with bug\n\ntracking system ? Create test document ? Create user and testing manual ? Make presentation to user ? Lead IT trainer team ? Schedule user training everyday for IT\n\ntrainer team to visit each polyclinic\n\nf. Waktu Pelaksanaan : Mei 2014 / Maret 2015 g. Posisi Penugasan : IT Trainer and Software Tester\n\n5.\n\nh. Status Kepegawaian Pada Perusahaan ini.\n\na. Nama kegiatan b. Lokasi Kegiatan c. Pengguna Jasa d. Nama Perusahaan e. Uraian Tugas\n\nf.Waktu Pelaksanaan g.Posisi Penugasan h.Status Kepegawaian\n\n:\n\n: : : : :\n\n: : :\n\nKontrak\n\nIT Staff Jakarta PT.East Star Corporation Prudential Agency PT.East Star Corporation Prudential Agency\n\n? Prepare for presentation ? Networking and troubleshooting all IT\n\nproblems in office then make a report for intener usage every week\n\nDesember 2012 / Desember 2013 IT Staff Kontrak\n\nDaftar riwayat hidup ini saya buat dengan sebenar-benarnya dan penuh rasa tanggung jawab. Jika\n\nterdapat pengungkapan keterangan yang tidak benar secara sengaja atau sepatutnya diduga maka saya\n\nsiap untuk digugurkan dari proses seleksi atau dikeluarkan jika sudah dipekerjakan.\n\n3 dari 3\n','2017',NULL),(11,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,'Consultant',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','NONEJ',' â Present\n\n','June 2021',NULL),(12,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','2EZJR',NULL,NULL,NULL),(13,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,'VP',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','P3ID2','\n\nManaging and mentoring development team in all activities from assessment, pre development strategy, development phase, deployment rollout, and post deployment. Leading development team to delivery ecommerce microservices based applications for both frontend and backend.\n\nTechnology and/or Methodology that were deployed: Ubuntu Desktop, Ubuntu Server, Centos, Microsoft Windows, Microsoft Project, Microsoft Power point, Microsoft Word, Php, J2EE, Oracle Service Bus, Oracle Database, PostgreSQL Database, MySQL Database, Magento Enterprise, SOLR, Java JAX-WS, Java JAX-RS, Google Web Toolkit, Apache Tomcat, Oracle Weblogic, Code Igniter, Bootstrap, SVN, JIRA, Confluence, Google Cloud Platform, Amazon Web Services, MongoDB, Redis, Kubernetes, Ka?a, Confluent, Spring Boot, Machine Learning (Weka, Rapidminer).\n\nhttps://dms.id-trec.com\n\nPT. XL Planet (elevenia.co.id) ','January 2016','March 2021'),(14,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,'Developer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','EVRV3','\n\nHaving responsibilities for giving assessment of possibilities, options, and schedule for task and giving directions, strategies, and guidance to team for completing the task based on team load and team capacity.\n\nTechnology and/or Methodology that were deployed: Microsoft Power point, Microsoft Word, J2EE, Oracle Database, SQL Developer, Apache Tomcat, Oracle Weblogic.\n\nPT Mitra Integrasi Informatika ','January 2014','December 2015'),(15,'2023-05-01 09:55:37',28,1,'2023-05-06 16:24:22',28,1,'Consultant',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','6PQDJ','\n\nExtending, design and deliver KPEI Middleware, as a backbone for KPEI day to day operational process.\n\nDesign phase: Gathering requirement and coordinate with multiple application vendors to provide SOA design. Create Project Plan, High Level Requirement, Business Proposal, and Document Design.\n\nDeliver phase: In charge with weekly Progress Meeting to update user with the latest condition of project, also with risks and issues arise within accomplished week. Deliver service according with business specification. Support phase: Give assessment with any Change Request, if exists. Bug fixing. Technology and/or Methodology that were deployed: Microsoft Word, Microsoft Project, Microsoft Excel, C++, J2EE, Oracle Database, MySQL Database, SQL Developer, Toad for MySQL, Apache Tomcat, Oracle Weblogic, Oracle SOA Suite.\n','November 2010','December 2013'),(16,'2023-05-01 09:56:54',28,1,'2023-05-07 10:25:40',28,4,'Engineer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','PX6GY',' h. Status Kepegawaian Pada Perusahaan ini\n\n: Kontrak\n\n3. a. Nama Kegiatan : IT Support Specialist b. Lokasi Kegiatan : Jakarta c. Pengguna Jasa : PT. Nalysa Microsoft partner d. Nama Perusahaan : PT. Nalysa Microsoft Partner e. Uraian Tugas : ? Handle maintenance andsupport\n\nevery client also PT Nalysa internal site ,this includes all maintenance procedures ,reporting, team management ,schedule maintenance and support priorities\n\n? Improve maintenance and support processes,by any actions\n\n? Back up operations scripting ,monitoring tool installation\n\n? Network bandwidth and QOS management\n\n? Computer installation automation ? Internal tools improvement such as\n\notrs, and qlickview\n\n2 dari 3\n\nFUSI SOLUSI TRANSFORMASI Manage Services Division\n\n? Benchmarking and new tools propositions\n\nf. Waktu Pelaksanaan : Mei 2015 / Juni 2016 g. Posisi Penugasan : IT Support Specialist h. Status Kepegawaian Pada Perusahaan ini\n\n: Kontrak\n\n4. a. Nama Kegiatan : IT Trainer and Software Tester b. Lokasi Kegiatan : Jakarta c. Pengguna Jasa : PT. Pharmindo Rimpang Kokoh d. Nama Perusahaan e.Uraian Tugas\n\n: :\n\nPT. Pharmindo Rimpang Kokoh ? Testing application role modul per modul ? Report bug to programmer with bug\n\ntracking system ? Create test document ? Create user and testing manual ? Make presentation to user ? Lead IT trainer team ? Schedule user training everyday for IT\n\ntrainer team to visit each polyclinic\n\nf. Waktu Pelaksanaan : Mei 2014 / Maret 2015 g. Posisi Penugasan : IT Trainer and Software Tester\n\n5.\n\nh. Status Kepegawaian Pada Perusahaan ini.\n\na. Nama kegiatan b. Lokasi Kegiatan c. Pengguna Jasa d. Nama Perusahaan e. Uraian Tugas\n\nf.Waktu Pelaksanaan g.Posisi Penugasan h.Status Kepegawaian\n\n:\n\n: : : : :\n\n: : :\n\nKontrak\n\nIT Staff Jakarta PT.East Star Corporation Prudential Agency PT.East Star Corporation Prudential Agency\n\n? Prepare for presentation ? Networking and troubleshooting all IT\n\nproblems in office then make a report for intener usage every week\n\nDesember 2012 / Desember 2013 IT Staff Kontrak\n\nDaftar riwayat hidup ini saya buat dengan sebenar-benarnya dan penuh rasa tanggung jawab. Jika\n\nterdapat pengungkapan keterangan yang tidak benar secara sengaja atau sepatutnya diduga maka saya\n\nsiap untuk digugurkan dari proses seleksi atau dikeluarkan jika sudah dipekerjakan.\n\n3 dari 3\n','2017',NULL),(17,'2023-05-01 09:56:55',28,1,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','5A7AL',NULL,NULL,NULL),(18,'2023-05-01 09:56:55',28,1,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','SW43V',NULL,NULL,NULL),(19,'2023-05-01 09:56:55',28,1,NULL,NULL,5,'Team Leader',NULL,'Government',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','MWYNB',' (since June 2013)\n\nSoftware and Platform: Java Language with spring and ibatis framework, using Eclipse tools and oracle\n\nfor database.\n\nPT. Gramedia Bookstore Data Entry (June, 2008 to July, 2008)\n\nAddress: Sunter Mall, Jl. Danau Sunter Utara, Tj. Priok, Kota Jkt Utara, Jakarta 14350\n\nDuration: June 2008 to July 2008\n\nRole: Data Entry\n\nfill up book list to database through internal application\n','April 2014',NULL),(20,'2023-05-01 09:56:55',28,1,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','L4CSW',NULL,NULL,NULL),(21,'2023-05-01 09:56:55',28,1,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','P3A75',NULL,NULL,NULL),(22,'2023-05-01 09:56:55',28,1,NULL,NULL,5,'Manager',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','2PFVQ',' to\n\nNovember, 2015)\n\nAddress: Lippo Kuningan Building 22th floor. HR. Rasuna Said kav.B12 Kuningan, Jakarta 12940, (+62)\n\n21 2964 4811 ext 453\n\n? elevenia.co.id is a product of PT XL Planet which is a joint venture\n\nbetween PT XL Axiata Tbk. and SK Planet Co., Ltd.\n\n? Transaction on elevenia means you can enjoy shopping system\n\nwith an open marketplace platform. Payment solutions we provide are\n\nEscrow System, which ensures the safe running transactions.\n\n','April, 2014',NULL),(23,'2023-05-01 09:56:55',28,1,NULL,NULL,5,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','B4ZNU',NULL,NULL,NULL),(24,'2023-05-01 09:56:55',28,1,NULL,NULL,5,'Manager',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','3ZBFA',' â Frontend Developer\n\nSoftware and Platform: Java Language with spring framework, using Eclipse tools and oracle for\n\ndatabase.\n\n?\n\nPT. Xybase Indonesia Java ','April 2014',NULL),(25,'2023-05-01 09:56:55',28,1,NULL,NULL,5,'Developer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','8AFJY',')\n\nAddress: Menara Duta Building 4th floor, wing C. HR. Rasuna Said kav.B9 Kuningan, Jakarta 12910, (+62)\n\n21 550 5117\n\n? XYBASE is a systems integrator, IPR developer and solutions provider and have been\n\nimplemented a number of large IT projects and are known worldwide for our airport IT\n\nexpertise.\n\n','April, 2014',NULL),(26,'2023-05-01 09:56:56',28,1,NULL,NULL,6,'Consultant',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','OFVR6',' â Present\n\n','June 2021',NULL),(27,'2023-05-01 09:56:56',28,1,NULL,NULL,6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','TV9NL',NULL,NULL,NULL),(28,'2023-05-01 09:56:56',28,1,NULL,NULL,6,'VP',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','NTMXN','\n\nManaging and mentoring development team in all activities from assessment, pre development strategy, development phase, deployment rollout, and post deployment. Leading development team to delivery ecommerce microservices based applications for both frontend and backend.\n\nTechnology and/or Methodology that were deployed: Ubuntu Desktop, Ubuntu Server, Centos, Microsoft Windows, Microsoft Project, Microsoft Power point, Microsoft Word, Php, J2EE, Oracle Service Bus, Oracle Database, PostgreSQL Database, MySQL Database, Magento Enterprise, SOLR, Java JAX-WS, Java JAX-RS, Google Web Toolkit, Apache Tomcat, Oracle Weblogic, Code Igniter, Bootstrap, SVN, JIRA, Confluence, Google Cloud Platform, Amazon Web Services, MongoDB, Redis, Kubernetes, Ka?a, Confluent, Spring Boot, Machine Learning (Weka, Rapidminer).\n\nhttps://dms.id-trec.com\n\nPT. XL Planet (elevenia.co.id) ','January 2016','March 2021'),(29,'2023-05-01 09:56:56',28,1,NULL,NULL,6,'Developer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','N3JQH','\n\nHaving responsibilities for giving assessment of possibilities, options, and schedule for task and giving directions, strategies, and guidance to team for completing the task based on team load and team capacity.\n\nTechnology and/or Methodology that were deployed: Microsoft Power point, Microsoft Word, J2EE, Oracle Database, SQL Developer, Apache Tomcat, Oracle Weblogic.\n\nPT Mitra Integrasi Informatika ','January 2014','December 2015'),(30,'2023-05-01 09:56:56',28,1,NULL,NULL,6,'Consultant',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','XUN58','\n\nExtending, design and deliver KPEI Middleware, as a backbone for KPEI day to day operational process.\n\nDesign phase: Gathering requirement and coordinate with multiple application vendors to provide SOA design. Create Project Plan, High Level Requirement, Business Proposal, and Document Design.\n\nDeliver phase: In charge with weekly Progress Meeting to update user with the latest condition of project, also with risks and issues arise within accomplished week. Deliver service according with business specification. Support phase: Give assessment with any Change Request, if exists. Bug fixing. Technology and/or Methodology that were deployed: Microsoft Word, Microsoft Project, Microsoft Excel, C++, J2EE, Oracle Database, MySQL Database, SQL Developer, Toad for MySQL, Apache Tomcat, Oracle Weblogic, Oracle SOA Suite.\n','November 2010','December 2013'),(31,'2023-05-01 09:57:09',28,1,'2023-05-07 10:25:20',28,7,'Engineer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','8KUNV',' h. Status Kepegawaian Pada Perusahaan ini\n\n: Kontrak\n\n3. a. Nama Kegiatan : IT Support Specialist b. Lokasi Kegiatan : Jakarta c. Pengguna Jasa : PT. Nalysa Microsoft partner d. Nama Perusahaan : PT. Nalysa Microsoft Partner e. Uraian Tugas : ? Handle maintenance andsupport\n\nevery client also PT Nalysa internal site ,this includes all maintenance procedures ,reporting, team management ,schedule maintenance and support priorities\n\n? Improve maintenance and support processes,by any actions\n\n? Back up operations scripting ,monitoring tool installation\n\n? Network bandwidth and QOS management\n\n? Computer installation automation ? Internal tools improvement such as\n\notrs, and qlickview\n\n2 dari 3\n\nFUSI SOLUSI TRANSFORMASI Manage Services Division\n\n? Benchmarking and new tools propositions\n\nf. Waktu Pelaksanaan : Mei 2015 / Juni 2016 g. Posisi Penugasan : IT Support Specialist h. Status Kepegawaian Pada Perusahaan ini\n\n: Kontrak\n\n4. a. Nama Kegiatan : IT Trainer and Software Tester b. Lokasi Kegiatan : Jakarta c. Pengguna Jasa : PT. Pharmindo Rimpang Kokoh d. Nama Perusahaan e.Uraian Tugas\n\n: :\n\nPT. Pharmindo Rimpang Kokoh ? Testing application role modul per modul ? Report bug to programmer with bug\n\ntracking system ? Create test document ? Create user and testing manual ? Make presentation to user ? Lead IT trainer team ? Schedule user training everyday for IT\n\ntrainer team to visit each polyclinic\n\nf. Waktu Pelaksanaan : Mei 2014 / Maret 2015 g. Posisi Penugasan : IT Trainer and Software Tester\n\n5.\n\nh. Status Kepegawaian Pada Perusahaan ini.\n\na. Nama kegiatan b. Lokasi Kegiatan c. Pengguna Jasa d. Nama Perusahaan e. Uraian Tugas\n\nf.Waktu Pelaksanaan g.Posisi Penugasan h.Status Kepegawaian\n\n:\n\n: : : : :\n\n: : :\n\nKontrak\n\nIT Staff Jakarta PT.East Star Corporation Prudential Agency PT.East Star Corporation Prudential Agency\n\n? Prepare for presentation ? Networking and troubleshooting all IT\n\nproblems in office then make a report for intener usage every week\n\nDesember 2012 / Desember 2013 IT Staff Kontrak\n\nDaftar riwayat hidup ini saya buat dengan sebenar-benarnya dan penuh rasa tanggung jawab. Jika\n\nterdapat pengungkapan keterangan yang tidak benar secara sengaja atau sepatutnya diduga maka saya\n\nsiap untuk digugurkan dari proses seleksi atau dikeluarkan jika sudah dipekerjakan.\n\n3 dari 3\n','2017',NULL),(32,'2023-05-01 09:57:14',28,1,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','N2GPV',NULL,NULL,NULL),(33,'2023-05-01 09:57:14',28,1,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','SZ2OV',NULL,NULL,NULL),(34,'2023-05-01 09:57:14',28,1,NULL,NULL,8,'Team Leader',NULL,'Government',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','Y7OST',' (since June 2013)\n\nSoftware and Platform: Java Language with spring and ibatis framework, using Eclipse tools and oracle\n\nfor database.\n\nPT. Gramedia Bookstore Data Entry (June, 2008 to July, 2008)\n\nAddress: Sunter Mall, Jl. Danau Sunter Utara, Tj. Priok, Kota Jkt Utara, Jakarta 14350\n\nDuration: June 2008 to July 2008\n\nRole: Data Entry\n\nfill up book list to database through internal application\n','April 2014',NULL),(35,'2023-05-01 09:57:14',28,1,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','CQ58N',NULL,NULL,NULL),(36,'2023-05-01 09:57:14',28,1,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','Z7E51',NULL,NULL,NULL),(37,'2023-05-01 09:57:14',28,1,NULL,NULL,8,'Manager',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','Z3FAX',' to\n\nNovember, 2015)\n\nAddress: Lippo Kuningan Building 22th floor. HR. Rasuna Said kav.B12 Kuningan, Jakarta 12940, (+62)\n\n21 2964 4811 ext 453\n\n? elevenia.co.id is a product of PT XL Planet which is a joint venture\n\nbetween PT XL Axiata Tbk. and SK Planet Co., Ltd.\n\n? Transaction on elevenia means you can enjoy shopping system\n\nwith an open marketplace platform. Payment solutions we provide are\n\nEscrow System, which ensures the safe running transactions.\n\n','April, 2014',NULL),(38,'2023-05-01 09:57:14',28,1,NULL,NULL,8,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','5O7S4',NULL,NULL,NULL),(39,'2023-05-01 09:57:14',28,1,NULL,NULL,8,'Manager',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','QAUBN',' â Frontend Developer\n\nSoftware and Platform: Java Language with spring framework, using Eclipse tools and oracle for\n\ndatabase.\n\n?\n\nPT. Xybase Indonesia Java ','April 2014',NULL),(40,'2023-05-01 09:57:14',28,1,NULL,NULL,8,'Developer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','T2WLV',')\n\nAddress: Menara Duta Building 4th floor, wing C. HR. Rasuna Said kav.B9 Kuningan, Jakarta 12910, (+62)\n\n21 550 5117\n\n? XYBASE is a systems integrator, IPR developer and solutions provider and have been\n\nimplemented a number of large IT projects and are known worldwide for our airport IT\n\nexpertise.\n\n','April, 2014',NULL),(41,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,'Consultant',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','714YM',' â Present\n\n','June 2021',NULL),(42,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','0MCJG',NULL,NULL,NULL),(43,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,'VP',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','FIXFX','\n\nManaging and mentoring development team in all activities from assessment, pre development strategy, development phase, deployment rollout, and post deployment. Leading development team to delivery ecommerce microservices based applications for both frontend and backend.\n\nTechnology and/or Methodology that were deployed: Ubuntu Desktop, Ubuntu Server, Centos, Microsoft Windows, Microsoft Project, Microsoft Power point, Microsoft Word, Php, J2EE, Oracle Service Bus, Oracle Database, PostgreSQL Database, MySQL Database, Magento Enterprise, SOLR, Java JAX-WS, Java JAX-RS, Google Web Toolkit, Apache Tomcat, Oracle Weblogic, Code Igniter, Bootstrap, SVN, JIRA, Confluence, Google Cloud Platform, Amazon Web Services, MongoDB, Redis, Kubernetes, Ka?a, Confluent, Spring Boot, Machine Learning (Weka, Rapidminer).\n\nhttps://dms.id-trec.com\n\nPT. XL Planet (elevenia.co.id) ','January 2016','March 2021'),(44,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,'Developer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','XMZRA','\n\nHaving responsibilities for giving assessment of possibilities, options, and schedule for task and giving directions, strategies, and guidance to team for completing the task based on team load and team capacity.\n\nTechnology and/or Methodology that were deployed: Microsoft Power point, Microsoft Word, J2EE, Oracle Database, SQL Developer, Apache Tomcat, Oracle Weblogic.\n\nPT Mitra Integrasi Informatika ','January 2014','December 2015'),(45,'2023-05-01 09:57:15',28,1,'2023-05-01 11:07:01',28,9,'Consultant',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','NHQ31','\n\nExtending, design and deliver KPEI Middleware, as a backbone for KPEI day to day operational process.\n\nDesign phase: Gathering requirement and coordinate with multiple application vendors to provide SOA design. Create Project Plan, High Level Requirement, Business Proposal, and Document Design.\n\nDeliver phase: In charge with weekly Progress Meeting to update user with the latest condition of project, also with risks and issues arise within accomplished week. Deliver service according with business specification. Support phase: Give assessment with any Change Request, if exists. Bug fixing. Technology and/or Methodology that were deployed: Microsoft Word, Microsoft Project, Microsoft Excel, C++, J2EE, Oracle Database, MySQL Database, SQL Developer, Toad for MySQL, Apache Tomcat, Oracle Weblogic, Oracle SOA Suite.\n','November 2010','December 2013'),(46,'2023-05-01 10:39:49',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','3XFVL',NULL,NULL,NULL),(47,'2023-05-01 10:39:51',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','Z4XSG',NULL,NULL,NULL),(48,'2023-05-01 10:39:56',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','IIM0M',NULL,NULL,NULL),(49,'2023-05-01 10:39:59',28,1,'2023-05-01 11:07:01',28,9,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','TP5O1',NULL,NULL,NULL),(50,'2023-05-06 15:45:25',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','G0P70',NULL,NULL,NULL),(51,'2023-05-06 15:45:42',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','J7GXJ',NULL,NULL,NULL),(52,'2023-05-06 15:46:17',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','N34V4',NULL,NULL,NULL),(53,'2023-05-06 15:47:58',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','B0AYD',NULL,NULL,NULL),(54,'2023-05-06 15:47:59',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','N56ZU',NULL,NULL,NULL),(55,'2023-05-06 15:48:00',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','CFHTZ',NULL,NULL,NULL),(56,'2023-05-06 15:48:00',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','J43P3',NULL,NULL,NULL),(57,'2023-05-06 15:48:00',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','6FNLL',NULL,NULL,NULL),(58,'2023-05-06 15:48:01',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','ERWOO',NULL,NULL,NULL),(59,'2023-05-06 15:48:02',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','ILRLM',NULL,NULL,NULL),(60,'2023-05-06 15:49:17',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','DRHZB',NULL,NULL,NULL),(61,'2023-05-06 15:49:17',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','LAPIX',NULL,NULL,NULL),(62,'2023-05-06 15:49:22',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','DRYT4',NULL,NULL,NULL),(63,'2023-05-06 15:49:23',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','8JMV0',NULL,NULL,NULL),(64,'2023-05-06 15:49:24',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','C998A',NULL,NULL,NULL),(65,'2023-05-06 15:49:24',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','GVMQ7',NULL,NULL,NULL),(66,'2023-05-06 15:49:25',28,1,'2023-05-06 16:24:22',28,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','6789K',NULL,NULL,NULL),(67,'2023-05-06 15:49:26',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','MJCXU',NULL,NULL,NULL),(68,'2023-05-06 15:49:28',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','7NBAO',NULL,NULL,NULL),(69,'2023-05-06 15:49:28',28,1,'2023-05-07 10:25:31',28,3,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','WWHMQ',NULL,NULL,NULL),(70,'2023-05-06 15:49:29',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','O6IOX',NULL,NULL,NULL),(71,'2023-05-06 15:49:30',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','SJN70',NULL,NULL,NULL),(72,'2023-05-06 15:49:34',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','8KTOD',NULL,NULL,NULL),(73,'2023-05-06 15:49:35',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','OVYV0',NULL,NULL,NULL),(74,'2023-05-06 15:49:37',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','W606G',NULL,NULL,NULL),(75,'2023-05-06 15:49:37',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','NED7O',NULL,NULL,NULL),(76,'2023-05-06 15:49:38',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','0AS95',NULL,NULL,NULL),(77,'2023-05-06 15:49:39',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','XTF5N',NULL,NULL,NULL),(78,'2023-05-06 15:49:39',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','DUSHD',NULL,NULL,NULL),(79,'2023-05-06 15:49:40',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','560TO',NULL,NULL,NULL),(80,'2023-05-06 15:49:40',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','QYI4K',NULL,NULL,NULL),(81,'2023-05-06 15:49:41',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','LI878',NULL,NULL,NULL),(82,'2023-05-06 15:49:41',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','7Y3MQ',NULL,NULL,NULL),(83,'2023-05-06 15:49:42',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','9AVM2',NULL,NULL,NULL),(84,'2023-05-06 15:52:33',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','EPTT6',NULL,NULL,NULL),(85,'2023-05-06 15:52:34',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','32PW8',NULL,NULL,NULL),(86,'2023-05-06 15:52:35',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','MR1K2',NULL,NULL,NULL),(87,'2023-05-06 16:14:04',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','PFUG7',NULL,NULL,NULL),(88,'2023-05-06 16:14:05',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','F2C4X',NULL,NULL,NULL),(89,'2023-05-06 16:14:07',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','7O4S9',NULL,NULL,NULL),(90,'2023-05-06 16:14:08',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','C254P',NULL,NULL,NULL),(91,'2023-05-06 16:14:09',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','TA52T',NULL,NULL,NULL),(92,'2023-05-06 16:14:09',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','3Y9IE',NULL,NULL,NULL),(93,'2023-05-06 16:14:10',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','LOUYR',NULL,NULL,NULL),(94,'2023-05-06 16:14:10',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','DEYUY',NULL,NULL,NULL),(95,'2023-05-06 16:14:11',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','2K3JW',NULL,NULL,NULL),(96,'2023-05-06 16:14:11',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','WZUYO',NULL,NULL,NULL),(97,'2023-05-06 16:14:12',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','AIK2S',NULL,NULL,NULL),(98,'2023-05-06 16:14:12',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','AIU6W',NULL,NULL,NULL),(99,'2023-05-06 16:14:12',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','G6NF8',NULL,NULL,NULL),(100,'2023-05-06 16:14:15',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','63DL7',NULL,NULL,NULL),(101,'2023-05-06 16:14:15',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','X94YL',NULL,NULL,NULL),(102,'2023-05-06 16:15:47',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','42Q91',NULL,NULL,NULL),(103,'2023-05-06 16:15:48',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','782DH',NULL,NULL,NULL),(104,'2023-05-06 16:17:55',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','MZ9GK',NULL,NULL,NULL),(105,'2023-05-06 16:17:56',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','IKLGF',NULL,NULL,NULL),(106,'2023-05-06 16:17:57',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','NXHW8',NULL,NULL,NULL),(107,'2023-05-06 16:17:59',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','P5KXL',NULL,NULL,NULL),(108,'2023-05-06 16:18:00',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','8OOK4',NULL,NULL,NULL),(109,'2023-05-06 16:18:00',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','OKP37',NULL,NULL,NULL),(110,'2023-05-07 09:06:56',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','8HGOR',NULL,NULL,NULL),(111,'2023-05-07 09:06:57',28,1,NULL,NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'active','A8425',NULL,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'2019-09-03 15:42:44',0,NULL,'2023-02-05 04:59:34',1,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin','123','active','xycnh1fzl8chkm8cqr20ni6zvh2ai52c3mvw2uwy0s86mscu9u80h6ylym2imghas6h6ffj05taecfoxfu3g0x8alwbt97q9je8f','1111343528-20q4jm5fw1-Cluster-Morizen-Bekasi-Indonesia.jpg','5BVJFT084HBZH038UGD1LTFEV92KKDIOFMER',NULL,NULL),(2,'2021-11-04 12:00:07',1,NULL,'2022-03-29 09:55:17',1,'pic1@mail.com','202cb962ac59075b964b07152d234b70','pic','one',NULL,'active',NULL,NULL,'ng843n6ocg719kklqklb5814t9n2ahilj9zv',NULL,NULL),(3,'2021-11-04 12:12:24',1,NULL,'2022-03-29 09:55:28',1,'pic2@mail.com','202cb962ac59075b964b07152d234b70','pic','two',NULL,'active',NULL,NULL,'b3n95p03tsdpm9fya84cnelibj9u34xffz6j',NULL,NULL),(4,'2021-11-04 12:13:34',1,NULL,'2022-03-29 09:55:39',1,'pic3@mail.com','202cb962ac59075b964b07152d234b70','pic','three',NULL,'active',NULL,NULL,'zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl',NULL,NULL),(5,'2022-02-07 09:12:44',1,NULL,'2022-03-29 09:55:49',1,'pic4@mail.com','202cb962ac59075b964b07152d234b70','pic','four',NULL,'active',NULL,NULL,'ni5ju0wgw0l4x3gxoq0cgh3jn3lyvejl5aq8',NULL,NULL),(6,'2022-02-07 09:48:32',1,NULL,'2022-03-29 09:56:15',1,'pic6@mail.com','202cb962ac59075b964b07152d234b70','pic','six',NULL,'active',NULL,NULL,'onlidhsdmmgz9k8gxzq2dfazrhshyx9zv53p',NULL,NULL),(7,'2022-02-08 08:57:14',1,NULL,'2022-03-29 09:56:26',1,'pic7@mail.com','202cb962ac59075b964b07152d234b70','pic','seven',NULL,'active',NULL,NULL,'it1wq7s6txkfcl6xw2iji0dmebrmc7b41mtv',NULL,NULL),(8,'2022-02-08 08:57:34',1,NULL,'2022-03-29 09:56:35',1,'pic8@mail.com','202cb962ac59075b964b07152d234b70','pic','eight',NULL,'active',NULL,NULL,'macc9yxlcnfjqix254tmbf0h4459a9w22xfi',NULL,NULL),(9,'2022-02-08 08:58:30',1,NULL,'2022-03-29 09:56:54',1,'pic9@mail.com','202cb962ac59075b964b07152d234b70','pic','nine',NULL,'active',NULL,NULL,'jayf1yr5fd07mshu2c4a29ih8li17beubiwc',NULL,NULL),(10,'2022-02-08 08:59:52',1,NULL,'2022-03-29 09:57:02',1,'pic10@mail.com','202cb962ac59075b964b07152d234b70','pic','ten',NULL,'active',NULL,NULL,'i8m95htaivk0u5mcjfy3ioo0k9zxxf8lpp5h',NULL,NULL),(11,'2022-02-14 11:18:06',1,NULL,'2022-03-29 09:57:11',1,'pic11@mail.com','202cb962ac59075b964b07152d234b70','pic','eleven',NULL,'active',NULL,NULL,'lk9i5cv2dm5bnyz07apzo3wirxodwfhhxf85',NULL,NULL),(12,'2022-02-14 11:19:22',1,NULL,'2022-03-29 09:57:20',1,'pic12@mail.com','202cb962ac59075b964b07152d234b70','pic','twelve',NULL,'active',NULL,NULL,'uzf4niy96076mn4crvfsalm9r06uoey2spjj',NULL,NULL),(13,'2022-02-16 07:42:39',1,NULL,'2022-03-29 09:57:29',1,'pic13@mail.com','202cb962ac59075b964b07152d234b70','pic','thirteen',NULL,'active',NULL,NULL,'oka59r3uxjbqi7pfwpv2kbiyf1tuxedqvam6',NULL,NULL),(14,'2022-02-24 03:08:59',1,NULL,'2022-04-18 06:25:36',14,'pic14@mail.com','202cb962ac59075b964b07152d234b70','pic','fourteen',NULL,'active',NULL,NULL,'ntw5zeue28u72o3bkbdukg0hjahj25bqcljx',NULL,NULL),(28,'2022-12-13 15:22:59',NULL,1,'2023-05-06 16:10:48',28,'achmad.amri@gmail.com','202cb962ac59075b964b07152d234b70','Achmad','Amri','081380782318','active','71imewz8stbcafcx7s2rrukdyzx6plwbdze9gparu9tlrz1wqlw9yhcuq4jp13xprvwa2o4jkqblhxnoz87c7oh9k631uerecms1',NULL,'IF8XM41R4GVH58RDENBP2MVIWRSWU3IBWR6D',NULL,NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `view_job_department`
--

DROP TABLE IF EXISTS `view_job_department`;
/*!50001 DROP VIEW IF EXISTS `view_job_department`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_job_department` AS SELECT
 1 AS `uuid`,
  1 AS `tbj_id`,
  1 AS `tbj_create_date`,
  1 AS `tbj_create_id`,
  1 AS `tbj_create_idc`,
  1 AS `tbj_update_date`,
  1 AS `tbj_update_id`,
  1 AS `tbj_name`,
  1 AS `tbj_status`,
  1 AS `tbj_assigned`,
  1 AS `tbj_uuid`,
  1 AS `tbd_id`,
  1 AS `tbd_create_date`,
  1 AS `tbd_create_id`,
  1 AS `tbd_create_idc`,
  1 AS `tbd_update_date`,
  1 AS `tbd_update_id`,
  1 AS `tbd_name`,
  1 AS `tbd_status`,
  1 AS `tbd_uuid` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `view_job_resume`
--

DROP TABLE IF EXISTS `view_job_resume`;
/*!50001 DROP VIEW IF EXISTS `view_job_resume`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_job_resume` AS SELECT
 1 AS `uuid`,
  1 AS `tbj_id`,
  1 AS `tbj_create_date`,
  1 AS `tbj_create_id`,
  1 AS `tbj_create_idc`,
  1 AS `tbj_update_date`,
  1 AS `tbj_update_id`,
  1 AS `tbj_name`,
  1 AS `tbj_status`,
  1 AS `tbj_uuid`,
  1 AS `tbjr_id`,
  1 AS `tbjr_create_date`,
  1 AS `tbjr_create_id`,
  1 AS `tbjr_create_idc`,
  1 AS `tbjr_update_date`,
  1 AS `tbjr_update_id`,
  1 AS `tbjr_status`,
  1 AS `tbjr_uuid`,
  1 AS `tbr_id`,
  1 AS `tbr_create_date`,
  1 AS `tbr_create_id`,
  1 AS `tbr_create_idc`,
  1 AS `tbr_update_date`,
  1 AS `tbr_update_id`,
  1 AS `tbr_data_name_raw`,
  1 AS `tbr_data_name_first`,
  1 AS `tbr_data_name_last`,
  1 AS `tbr_data_name_middle`,
  1 AS `tbr_data_name_title`,
  1 AS `tbr_data_phone_numbers`,
  1 AS `tbr_data_websites`,
  1 AS `tbr_data_emails`,
  1 AS `tbr_data_date_of_birth`,
  1 AS `tbr_data_location_formatted`,
  1 AS `tbr_data_location_postal_code`,
  1 AS `tbr_data_location_state`,
  1 AS `tbr_data_location_country`,
  1 AS `tbr_data_location_country_code`,
  1 AS `tbr_data_location_raw_input`,
  1 AS `tbr_data_location_street_number`,
  1 AS `tbr_data_location_street`,
  1 AS `tbr_data_location_apartment_number`,
  1 AS `tbr_data_location_city`,
  1 AS `tbr_data_objective`,
  1 AS `tbr_data_languages`,
  1 AS `tbr_data_language_codes`,
  1 AS `tbr_data_summary`,
  1 AS `tbr_data_total_years_experience`,
  1 AS `tbr_data_head_shot`,
  1 AS `tbr_data_education`,
  1 AS `tbr_data_profession`,
  1 AS `tbr_data_linkedin`,
  1 AS `tbr_data_work_experience`,
  1 AS `tbr_data_skills`,
  1 AS `tbr_data_certifications`,
  1 AS `tbr_data_publications`,
  1 AS `tbr_data_referees`,
  1 AS `tbr_data_sections`,
  1 AS `tbr_data_is_resume_probability`,
  1 AS `tbr_data_raw_text`,
  1 AS `tbr_meta_identifier`,
  1 AS `tbr_meta_file_name`,
  1 AS `tbr_meta_ready`,
  1 AS `tbr_meta_ready_dt`,
  1 AS `tbr_meta_failed`,
  1 AS `tbr_meta_expiry_time`,
  1 AS `tbr_meta_language`,
  1 AS `tbr_meta_pdf`,
  1 AS `tbr_meta_parent_document_identifier`,
  1 AS `tbr_meta_child_documents`,
  1 AS `tbr_meta_pages`,
  1 AS `tbr_meta_is_verified`,
  1 AS `tbr_meta_review_url`,
  1 AS `tbr_meta_ocr_confidence`,
  1 AS `tbr_error_error_code`,
  1 AS `tbr_error_error_detail`,
  1 AS `tbr_status`,
  1 AS `tbr_uuid` */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `view_resume_job`
--

DROP TABLE IF EXISTS `view_resume_job`;
/*!50001 DROP VIEW IF EXISTS `view_resume_job`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `view_resume_job` AS SELECT
 1 AS `uuid`,
  1 AS `tbr_id`,
  1 AS `tbr_create_date`,
  1 AS `tbr_create_id`,
  1 AS `tbr_create_idc`,
  1 AS `tbr_update_date`,
  1 AS `tbr_update_id`,
  1 AS `tbr_data_name_raw`,
  1 AS `tbr_data_name_first`,
  1 AS `tbr_data_name_last`,
  1 AS `tbr_data_name_middle`,
  1 AS `tbr_data_name_title`,
  1 AS `tbr_data_phone_numbers`,
  1 AS `tbr_data_websites`,
  1 AS `tbr_data_emails`,
  1 AS `tbr_data_date_of_birth`,
  1 AS `tbr_data_location_formatted`,
  1 AS `tbr_data_location_postal_code`,
  1 AS `tbr_data_location_state`,
  1 AS `tbr_data_location_country`,
  1 AS `tbr_data_location_country_code`,
  1 AS `tbr_data_location_raw_input`,
  1 AS `tbr_data_location_street_number`,
  1 AS `tbr_data_location_street`,
  1 AS `tbr_data_location_apartment_number`,
  1 AS `tbr_data_location_city`,
  1 AS `tbr_data_objective`,
  1 AS `tbr_data_languages`,
  1 AS `tbr_data_language_codes`,
  1 AS `tbr_data_summary`,
  1 AS `tbr_data_total_years_experience`,
  1 AS `tbr_data_head_shot`,
  1 AS `tbr_data_education`,
  1 AS `tbr_data_profession`,
  1 AS `tbr_data_linkedin`,
  1 AS `tbr_data_work_experience`,
  1 AS `tbr_data_skills`,
  1 AS `tbr_data_certifications`,
  1 AS `tbr_data_publications`,
  1 AS `tbr_data_referees`,
  1 AS `tbr_data_sections`,
  1 AS `tbr_data_is_resume_probability`,
  1 AS `tbr_data_raw_text`,
  1 AS `tbr_meta_identifier`,
  1 AS `tbr_meta_file_name`,
  1 AS `tbr_meta_ready`,
  1 AS `tbr_meta_ready_dt`,
  1 AS `tbr_meta_failed`,
  1 AS `tbr_meta_expiry_time`,
  1 AS `tbr_meta_language`,
  1 AS `tbr_meta_pdf`,
  1 AS `tbr_meta_parent_document_identifier`,
  1 AS `tbr_meta_child_documents`,
  1 AS `tbr_meta_pages`,
  1 AS `tbr_meta_is_verified`,
  1 AS `tbr_meta_review_url`,
  1 AS `tbr_meta_ocr_confidence`,
  1 AS `tbr_error_error_code`,
  1 AS `tbr_error_error_detail`,
  1 AS `tbr_status`,
  1 AS `tbr_uuid`,
  1 AS `tbr_assigned`,
  1 AS `tbr_score`,
  1 AS `tbr_star`,
  1 AS `tbr_resume_status`,
  1 AS `tbj_id`,
  1 AS `tbj_create_date`,
  1 AS `tbj_create_id`,
  1 AS `tbj_create_idc`,
  1 AS `tbj_update_date`,
  1 AS `tbj_update_id`,
  1 AS `tbj_name`,
  1 AS `tbj_status`,
  1 AS `tbj_uuid` */;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `view_job_department`
--

/*!50001 DROP VIEW IF EXISTS `view_job_department`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_job_department` AS select cast(uuid() as char(36) charset utf8mb4) AS `uuid`,`tbj`.`tbj_id` AS `tbj_id`,`tbj`.`tbj_create_date` AS `tbj_create_date`,`tbj`.`tbj_create_id` AS `tbj_create_id`,`tbj`.`tbj_create_idc` AS `tbj_create_idc`,`tbj`.`tbj_update_date` AS `tbj_update_date`,`tbj`.`tbj_update_id` AS `tbj_update_id`,`tbj`.`tbj_name` AS `tbj_name`,`tbj`.`tbj_status` AS `tbj_status`,`tbj`.`tbj_assigned` AS `tbj_assigned`,`tbj`.`tbj_uuid` AS `tbj_uuid`,`tbd`.`tbd_id` AS `tbd_id`,`tbd`.`tbd_create_date` AS `tbd_create_date`,`tbd`.`tbd_create_id` AS `tbd_create_id`,`tbd`.`tbd_create_idc` AS `tbd_create_idc`,`tbd`.`tbd_update_date` AS `tbd_update_date`,`tbd`.`tbd_update_id` AS `tbd_update_id`,`tbd`.`tbd_name` AS `tbd_name`,`tbd`.`tbd_status` AS `tbd_status`,`tbd`.`tbd_uuid` AS `tbd_uuid` from (`tb_job` `tbj` left join `tb_department` `tbd` on(`tbd`.`tbd_id` = `tbj`.`tbd_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `view_job_resume`
--

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

--
-- Final view structure for view `view_resume_job`
--

/*!50001 DROP VIEW IF EXISTS `view_resume_job`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `view_resume_job` AS select cast(uuid() as char(36) charset utf8mb4) AS `uuid`,`tbr`.`tbr_id` AS `tbr_id`,`tbr`.`tbr_create_date` AS `tbr_create_date`,`tbr`.`tbr_create_id` AS `tbr_create_id`,`tbr`.`tbr_create_idc` AS `tbr_create_idc`,`tbr`.`tbr_update_date` AS `tbr_update_date`,`tbr`.`tbr_update_id` AS `tbr_update_id`,`tbr`.`tbr_data_name_raw` AS `tbr_data_name_raw`,`tbr`.`tbr_data_name_first` AS `tbr_data_name_first`,`tbr`.`tbr_data_name_last` AS `tbr_data_name_last`,`tbr`.`tbr_data_name_middle` AS `tbr_data_name_middle`,`tbr`.`tbr_data_name_title` AS `tbr_data_name_title`,`tbr`.`tbr_data_phone_numbers` AS `tbr_data_phone_numbers`,`tbr`.`tbr_data_websites` AS `tbr_data_websites`,`tbr`.`tbr_data_emails` AS `tbr_data_emails`,`tbr`.`tbr_data_date_of_birth` AS `tbr_data_date_of_birth`,`tbr`.`tbr_data_location_formatted` AS `tbr_data_location_formatted`,`tbr`.`tbr_data_location_postal_code` AS `tbr_data_location_postal_code`,`tbr`.`tbr_data_location_state` AS `tbr_data_location_state`,`tbr`.`tbr_data_location_country` AS `tbr_data_location_country`,`tbr`.`tbr_data_location_country_code` AS `tbr_data_location_country_code`,`tbr`.`tbr_data_location_raw_input` AS `tbr_data_location_raw_input`,`tbr`.`tbr_data_location_street_number` AS `tbr_data_location_street_number`,`tbr`.`tbr_data_location_street` AS `tbr_data_location_street`,`tbr`.`tbr_data_location_apartment_number` AS `tbr_data_location_apartment_number`,`tbr`.`tbr_data_location_city` AS `tbr_data_location_city`,`tbr`.`tbr_data_objective` AS `tbr_data_objective`,`tbr`.`tbr_data_languages` AS `tbr_data_languages`,`tbr`.`tbr_data_language_codes` AS `tbr_data_language_codes`,`tbr`.`tbr_data_summary` AS `tbr_data_summary`,`tbr`.`tbr_data_total_years_experience` AS `tbr_data_total_years_experience`,`tbr`.`tbr_data_head_shot` AS `tbr_data_head_shot`,`tbr`.`tbr_data_education` AS `tbr_data_education`,`tbr`.`tbr_data_profession` AS `tbr_data_profession`,`tbr`.`tbr_data_linkedin` AS `tbr_data_linkedin`,`tbr`.`tbr_data_work_experience` AS `tbr_data_work_experience`,`tbr`.`tbr_data_skills` AS `tbr_data_skills`,`tbr`.`tbr_data_certifications` AS `tbr_data_certifications`,`tbr`.`tbr_data_publications` AS `tbr_data_publications`,`tbr`.`tbr_data_referees` AS `tbr_data_referees`,`tbr`.`tbr_data_sections` AS `tbr_data_sections`,`tbr`.`tbr_data_is_resume_probability` AS `tbr_data_is_resume_probability`,`tbr`.`tbr_data_raw_text` AS `tbr_data_raw_text`,`tbr`.`tbr_meta_identifier` AS `tbr_meta_identifier`,`tbr`.`tbr_meta_file_name` AS `tbr_meta_file_name`,`tbr`.`tbr_meta_ready` AS `tbr_meta_ready`,`tbr`.`tbr_meta_ready_dt` AS `tbr_meta_ready_dt`,`tbr`.`tbr_meta_failed` AS `tbr_meta_failed`,`tbr`.`tbr_meta_expiry_time` AS `tbr_meta_expiry_time`,`tbr`.`tbr_meta_language` AS `tbr_meta_language`,`tbr`.`tbr_meta_pdf` AS `tbr_meta_pdf`,`tbr`.`tbr_meta_parent_document_identifier` AS `tbr_meta_parent_document_identifier`,`tbr`.`tbr_meta_child_documents` AS `tbr_meta_child_documents`,`tbr`.`tbr_meta_pages` AS `tbr_meta_pages`,`tbr`.`tbr_meta_is_verified` AS `tbr_meta_is_verified`,`tbr`.`tbr_meta_review_url` AS `tbr_meta_review_url`,`tbr`.`tbr_meta_ocr_confidence` AS `tbr_meta_ocr_confidence`,`tbr`.`tbr_error_error_code` AS `tbr_error_error_code`,`tbr`.`tbr_error_error_detail` AS `tbr_error_error_detail`,`tbr`.`tbr_status` AS `tbr_status`,`tbr`.`tbr_uuid` AS `tbr_uuid`,`tbr`.`tbr_assigned` AS `tbr_assigned`,`tbr`.`tbr_score` AS `tbr_score`,`tbr`.`tbr_star` AS `tbr_star`,`tbr`.`tbr_resume_status` AS `tbr_resume_status`,`tbj`.`tbj_id` AS `tbj_id`,`tbj`.`tbj_create_date` AS `tbj_create_date`,`tbj`.`tbj_create_id` AS `tbj_create_id`,`tbj`.`tbj_create_idc` AS `tbj_create_idc`,`tbj`.`tbj_update_date` AS `tbj_update_date`,`tbj`.`tbj_update_id` AS `tbj_update_id`,`tbj`.`tbj_name` AS `tbj_name`,`tbj`.`tbj_status` AS `tbj_status`,`tbj`.`tbj_uuid` AS `tbj_uuid` from (`tb_resume` `tbr` left join `tb_job` `tbj` on(`tbj`.`tbj_id` = `tbr`.`tbj_id`)) */;
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

-- Dump completed on 2023-05-07 21:05:21
