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
INSERT INTO `tb_department` VALUES (1,NULL,28,1,'2023-01-12 09:45:29',28,'Human Resources','active','26EYH'),(2,NULL,28,1,'2023-01-04 13:55:46',28,'Product and Development','active','9IFU7'),(3,NULL,28,1,'2023-01-05 13:42:42',28,'Sales and Marketing','active','6H74K'),(4,NULL,28,1,'2023-01-05 07:17:52',28,'Information Technology','active','7KJU8'),(5,'2023-01-03 09:11:23',28,1,'2023-01-05 07:56:34',28,'RnD','active','4LO6G'),(7,'2023-01-03 15:39:43',28,1,'2023-01-05 13:25:46',28,'CEO Office','active','0AWNA'),(8,'2023-01-03 15:42:56',28,1,'2023-01-04 09:35:43',28,'Blockchain','active','1WV47'),(9,'2023-01-03 15:43:28',28,1,'2023-01-04 08:33:25',28,'Data Science','active','Q1ITU'),(10,'2023-01-05 13:26:04',28,1,NULL,NULL,'BOD','active','1DSMX'),(11,'2023-01-05 13:28:10',28,1,NULL,NULL,'Legal','active','YOODH');
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department_job`
--

LOCK TABLES `tb_department_job` WRITE;
/*!40000 ALTER TABLE `tb_department_job` DISABLE KEYS */;
INSERT INTO `tb_department_job` VALUES (1,'2023-01-09 03:34:36',28,1,'2023-01-12 07:12:33',28,'assigned',1,2,'1C1ST'),(2,'2023-01-09 03:55:20',28,1,'2023-01-18 05:15:57',28,'not assigned',1,1,'P74C1'),(3,'2023-01-09 05:17:27',28,1,'2023-01-11 05:20:14',28,'not assigned',5,1,'020UZ'),(4,'2023-01-09 05:17:36',28,1,'2023-01-09 07:36:59',28,'not assigned',5,2,'60HDX'),(5,'2023-01-09 05:17:38',28,1,'2023-01-09 05:17:59',28,'not assigned',5,3,'HDM5J'),(6,'2023-01-09 05:17:39',28,1,'2023-01-09 05:17:56',28,'not assigned',5,4,'QB7YC'),(7,'2023-01-09 05:17:40',28,1,'2023-01-09 05:17:49',28,'not assigned',5,5,'TFU42'),(8,'2023-01-09 05:17:41',28,1,NULL,NULL,'assigned',5,6,'2UKN8'),(9,'2023-01-09 07:36:27',28,1,'2023-01-09 07:36:35',28,'not assigned',3,2,'KLIBG'),(10,'2023-01-12 09:45:38',28,1,NULL,NULL,'assigned',4,1,'CM4AK'),(11,'2023-01-12 09:45:40',28,1,NULL,NULL,'assigned',4,2,'B17AI');
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
INSERT INTO `tb_job` VALUES (1,NULL,NULL,1,'2023-01-18 05:15:43',28,'Software Engineer','active','8HU6O'),(2,NULL,NULL,1,'2023-01-05 16:08:53',28,'QA Engineer','active','9LK76'),(3,NULL,NULL,1,'2023-01-05 16:08:54',28,'Product Owner','active','HASD6'),(4,NULL,NULL,1,'2023-01-05 16:08:56',28,'HR Manager','active','17G6Y'),(5,NULL,NULL,1,'2023-01-05 16:51:02',28,'HR Staff','active','A87JH'),(6,NULL,NULL,1,'2023-01-12 09:43:07',28,'CEO','active','G67HJ');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_job_resume`
--

LOCK TABLES `tb_job_resume` WRITE;
/*!40000 ALTER TABLE `tb_job_resume` DISABLE KEYS */;
INSERT INTO `tb_job_resume` VALUES (1,NULL,NULL,NULL,NULL,NULL,'assigned',1,1,'BH78J'),(2,'2023-01-18 04:50:55',28,1,NULL,NULL,'assigned',1,3,'YRUT7'),(3,'2023-01-18 05:06:20',28,1,NULL,NULL,'assigned',1,4,'IH5RY');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume`
--

LOCK TABLES `tb_resume` WRITE;
/*!40000 ALTER TABLE `tb_resume` DISABLE KEYS */;
INSERT INTO `tb_resume` VALUES (1,'2023-01-07 11:50:23',NULL,NULL,NULL,NULL,'ACHMAD AMRI AYUBUH ANSYORI','Achmad','Ansyori','Amri Ayubuh','','[+6281380782318]','[]','[]','1981-08-19','127 c, Jl. Kayuringin Jaya No.13, RT.001/RW.017, Kayuringin Jaya, Kec. Bekasi Sel., Kota Bks, Jawa Barat 17144, Indonesia','17144','Jawa Barat','Indonesia','ID','Jl. Gunung Gede V No 127 C. Rt.04/Rw.13 Kayuringin Jaya. Bekasi - Jawa Barat.','13','Jalan Kayuringin Jaya','127 c',NULL,'','[English]',NULL,'',12,NULL,'[{id=8563966, organization=Fakultas Ilmu Komputer Universitas Gunadarma, accreditation={education=Manajemen Informatika,, educationLevel=null, inputStr=Manajemen Informatika,, matchStr=}, grade=null, location=null, dates={startDate=null, completionDate=2006-01-01, isCurrent=false}}, {id=8563967, organization=Teknik Informatika, MDP, accreditation={educationLevel=null, inputStr=, matchStr=}, grade=null, location={formatted=Palembang, Palembang City, South Sumatra, Indonesia, streetNumber=null, street=null, apartmentNumber=null, city=Palembang, postalCode=null, state=South Sumatra, country=Indonesia, rawInput=Palembang,, countryCode=ID}, dates={startDate=null, completionDate=2000-01-01, isCurrent=false}}, {id=8563968, organization=PALEMBANG, accreditation={education=SMAN 10, educationLevel=null, inputStr=SMAN 10, matchStr=}, grade=null, location=null, dates={startDate=null, completionDate=1999-01-01, isCurrent=false}}, {id=8563969, organization=PALEMBANG, accreditation={education=SMPN 1, educationLevel=null, inputStr=SMPN 1, matchStr=}, grade=null, location=null, dates={startDate=null, completionDate=1993-01-01, isCurrent=false}}]','Senior Platform Developer',NULL,'[{id=15975529, jobTitle=Founder, Director, eCommerce Implementation Consultant, organization=PT. BTECHNO SOLUSI DIGITAL, location=null, dates={startDate=2021-06-01, endDate=2023-01-07, monthsInPosition=19, isCurrent=true}, jobDescription=Project based consultant on various projects from private and government owned company : PT Rajawali Berdikari Indonesia Attendance Application PT. Tiga Global Sejahtera Distribution Management System https://dms.id-trec.com PT Kustodian Sentral Efek Indonesia (KSEI) Revamp GUI for S-Invest Latest technology and/or Methodology that were deployed: Vaadin Angular , occupation={jobTitle=Founder, Director, eCommerce Implementation Consultant, jobTitleNormalized=null, classification=null, managementLevel=null}}, {id=15975530, jobTitle=Senior Manager Platform Development, organization=PT. Sumber Trijaya Lestari (alfacart.com), location=null, dates={startDate=2016-01-01, endDate=2021-03-01, monthsInPosition=62, isCurrent=false}, jobDescription=direct report to VP / Head of IT Managing and mentoring development team in all activities from assessment, pre development strategy, development phase, deployment rollout, and post deployment. Leading development team to delivery ecommerce microservices based applications for both frontend and backend. Technology and/or Methodology that were deployed: Ubuntu Desktop, Ubuntu Server, Centos, Microsoft Windows, Microsoft Project, Microsoft Power point, Microsoft Word, Php, J2EE, Oracle Service Bus, Oracle Database, PostgreSQL Database, MySQL Database, Magento Enterprise, SOLR, Java JAX-WS, Java JAX-RS, Google Web Toolkit, Apache Tomcat, Oracle Weblogic, Code Igniter, Bootstrap, SVN, JIRA, Confluence, Google Cloud Platform, Amazon Web Services, MongoDB, Redis, Kubernetes, Kafka, Confluent, Spring Boot, Machine Learning (Weka, Rapidminer). , occupation={jobTitle=Senior Manager Platform Development, jobTitleNormalized=Platform Development Manager, classification=null, managementLevel=Mid}}, {id=15975531, jobTitle=Senior Manager Backend Developer, organization=PT. XL Planet (elevenia.co.id), location=null, dates={startDate=2014-01-01, endDate=2015-12-01, monthsInPosition=23, isCurrent=false}, jobDescription=Having responsibilities for giving assessment of possibilities, options, and schedule for task and giving directions, strategies, and guidance to team for completing the task based on team load and team capacity. Technology and/or Methodology that were deployed: Microsoft Power point, Microsoft Word, J2EE, Oracle Database, SQL Developer, Apache Tomcat, Oracle Weblogic. , occupation={jobTitle=Senior Manager Backend Developer, jobTitleNormalized=Drupal Backend Developer, classification={socCode=2134, title=Programmers and software development professionals , minorGroup=Information Technology Professionals, subMajorGroup=SCIENCE, RESEARCH, ENGINEERING AND TECHNOLOGY PROFESSIONALS, majorGroup=PROFESSIONAL OCCUPATIONS}, managementLevel=Low}}, {id=15975532, jobTitle=Technical Consultant, organization=PT Mitra Integrasi Informatika, location=null, dates={startDate=2010-11-01, endDate=2013-12-01, monthsInPosition=37, isCurrent=false}, jobDescription=Extending, design and deliver KPEI Middleware, as a backbone for KPEI day to day operational process. Design phase: Gathering requirement and coordinate with multiple application vendors to provide SOA design. Create Project Plan, High Level Requirement, Business Proposal, and Document Design. Deliver phase: In charge with weekly Progress Meeting to update user with the latest condition of project, also with risks and issues arise within accomplished week. Deliver service according with business specification. Support phase: Give assessment with any Change Request, if exists. Bug fixing. Technology and/or Methodology that were deployed: Microsoft Word, Microsoft Project, Microsoft Excel, C++, J2EE, Oracle Database, MySQL Database, SQL Developer, Toad for MySQL, Apache Tomcat, Oracle Weblogic, Oracle SOA Suite. , occupation={jobTitle=Technical Consultant, jobTitleNormalized=Technical Consultant, classification={socCode=2139, title=Information technology professionals n.e.c., minorGroup=Information Technology Professionals, subMajorGroup=SCIENCE, RESEARCH, ENGINEERING AND TECHNOLOGY PROFESSIONALS, majorGroup=PROFESSIONAL OCCUPATIONS}, managementLevel=Low}}]','[{id=86061465, emsiId=KS126PF6PJY1N0ZX5R0P, name=MongoDB, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061467, emsiId=KS1261Z68KSKR1X31KS3, name=Machine Learning, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061469, emsiId=KS123KG6DL8N3D5ZW036, name=Java Platform Enterprise Edition (J2EE), lastUsed=2021-03-01, numberOfMonths=122, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=2, workExperienceId=15975531}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061470, emsiId=KSJF3PBD3995K6E0OF1Z, name=Kubernetes, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061472, emsiId=KS4420H75G906GRK0QJZ, name=Web Services, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061473, emsiId=KSFS12Z1D00MRUX8Z7E8, name=Magento, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061474, emsiId=KS4421N62QZJ2NZ9QJY7, name=Weka, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061475, emsiId=KS121KB68PWHRPJCJKQJ, name=CentOS, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061476, emsiId=ES6D557B9D5BE598FD74, name=Spring Boot, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061477, emsiId=KS120H6772VQ0MQ5RLVD, name=Angular (Web Framework), lastUsed=2023-01-07, numberOfMonths=19, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=15975529}]}, {id=86061479, emsiId=KS1200H6XYN1CR0G5NZ0, name=Microsoft Excel, lastUsed=2013-12-01, numberOfMonths=37, type=soft_skill, sources=[{section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061480, emsiId=KS120265WKHSMJ6HYX8P, name=Microsoft Windows, lastUsed=2021-03-01, numberOfMonths=62, type=soft_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061481, emsiId=KS1200C5XQWW78VQ5ZYL, name=PHP (Scripting Language), lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}, {section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061482, emsiId=KS120076FGP5WGWYMP0F, name=Java (Programming Language), lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061483, emsiId=KSZX7YZWNR5IDR1I2VMZ, name=Microservices, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061484, emsiId=KS120QQ6ZN003B8B7FK1, name=JIRA, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061485, emsiId=KS120JM6ZKSY0Q8PJ7WT, name=Apache Tomcat, lastUsed=2021-03-01, numberOfMonths=122, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=2, workExperienceId=15975531}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061486, emsiId=KS7G3YQ62YJG4LX9QFZT, name=Google Cloud, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061487, emsiId=KS126J46GGVZB8BGGXSY, name=Microsoft Project, lastUsed=2021-03-01, numberOfMonths=99, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061488, emsiId=KS1214R5XG4X4PY7LGY6, name=Bootstrap (Front-End Framework), lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061491, emsiId=KS1218W78FGVPVP2KXPX, name=Management, lastUsed=2023-01-07, numberOfMonths=19, type=soft_skill, sources=[{section=WorkExperience, position=0, workExperienceId=15975529}]}, {id=86061492, emsiId=KS440W865GC4VRBW6LJP, name=SQL (Programming Language), lastUsed=2021-03-01, numberOfMonths=122, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}, {section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=2, workExperienceId=15975531}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061494, emsiId=KSN97GEUHPNGNAQFDCGY, name=Apache Kafka, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061495, emsiId=KS1200365FTR9X0M96T9, name=Microsoft Word, lastUsed=2021-03-01, numberOfMonths=122, type=soft_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=2, workExperienceId=15975531}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061496, emsiId=KS120FG6YP8PQYYNQY9B, name=Amazon Web Services, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061497, emsiId=KS441Q56Y88HLXDMHM4Y, name=Vaadin, lastUsed=2023-01-07, numberOfMonths=19, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=15975529}]}, {id=86061498, emsiId=KS126QY605N7YVHFYCTW, name=MySQL, lastUsed=2021-03-01, numberOfMonths=99, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}, {section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061499, emsiId=KS441S66KZY7LM20RKYN, name=Software Versioning, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061466, emsiId=KS128D367HP9RPXPGSM7, name=RapidMiner, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061468, emsiId=KSIJ33GROZ22YMYACXRW, name=JAX-WS, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061471, emsiId=KS128G66RG96FZNHFCXY, name=Redis, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061478, emsiId=ESC7869CF7378283E0AA, name=Google Cloud Platform (GCP), lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061489, emsiId=KS1QEK3F0I7319NUW1TJ, name=Oracle Service Bus, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061490, emsiId=KS123GK5WYFRJ4L20YK2, name=Middleware, lastUsed=2013-12-01, numberOfMonths=37, type=hard_skill, sources=[{section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061493, emsiId=KS121T56Q1CL65W06BJ5, name=Change Request, lastUsed=2013-12-01, numberOfMonths=37, type=hard_skill, sources=[{section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061500, emsiId=KS121CF62WFJ19GK02H7, name=Ubuntu (Operating System), lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061501, emsiId=KSCWA6GA1Q87T9ASI1UL, name=Rajawali, lastUsed=2023-01-07, numberOfMonths=19, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=15975529}]}, {id=86061502, emsiId=KS125TB6YR6236RKM563, name=PostgreSQL, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}]','[]','[]','[]',NULL,99,NULL,'nDxLzzjZ','e4ebfa03-da4f-4c5e-94ab-db8ddf459cf7',1,'2023-01-07T11:50:22.296739Z',0,NULL,'en',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,'active','AUZOW'),(3,'2023-01-18 04:50:55',NULL,NULL,NULL,NULL,'Arie Wirawan Margono','Arie','Margono','Wirawan','','[+6282111041805]','[http://www.sap.com/services/education/certification/certificationtest.epx]','[arie.margono@360consulting.co.id]','1980-10-26',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','[English, Indonesian]',NULL,'',3,NULL,'[{id=8979737, organization=Monash University, accreditation={education=Master of Business, educationLevel=masters, inputStr=Master of Business Systems Professional, matchStr=}, grade={raw=Point Average (GPA) : 3.81 (out of 4.00), value=3.81, metric=Point Average}, location={formatted=Melbourne VIC, Australia, streetNumber=null, street=null, apartmentNumber=null, city=Melbourne, postalCode=null, state=Victoria, country=Australia, rawInput=Melbourne Victoria, Australia, countryCode=AU, latitude=-37.8136276, longitude=144.9630576}, dates={startDate=2006-01-01, completionDate=2007-12-01, isCurrent=false}}, {id=8979738, organization=Petra Christian University, accreditation={education=Bachelor of Science, educationLevel=bachelors, inputStr=Bachelor of Computer Science, matchStr=}, grade={raw=(GPA) : 3.77 (out of 4.00), value=3.77, metric=GPA}, location={formatted=Surabaya, Surabaya City, East Java, Indonesia, streetNumber=null, street=null, apartmentNumber=null, city=Surabaya, postalCode=null, state=East Java, country=Indonesia, rawInput=Surabaya East Java, Indonesia, countryCode=ID, latitude=-7.2574719, longitude=112.7520883}, dates={startDate=1999-08-01, completionDate=2003-07-01, isCurrent=false}}]','Solution architect',NULL,'[{id=16769442, jobTitle=SAP BPC-BW-Dashboard Solution Architect, organization=Astra, location=null, dates={startDate=2019-12-01, endDate=2023-01-18, monthsInPosition=38, isCurrent=true}, jobDescription=Responsibilities : \n•Requirement analysis and system design, including preparation of Blueprint documentation for RKAP (Rencana Kerja & Anggaran Perusahaan), Prognosa (Forecast), and PAJM (Proyeksi Anggaran Jangka Menengah with 5-years duration), for following Planning Areas: a. OPEX planning (including utilization of Activity-Based Costing method) b. HR Planning c. Revenue & Other Cost Planning d. Budget Revision & Re-Allocation e. Cashflow Forecasting f. Budget Monitoring & Control g. Financial Statements planning (Balance Sheet, Profit & Loss, Cashflow) \n•Requirement analysis and system design for dashboards, including preparation of Blueprint documentation, covering dashboards from following areas: a. Dashboard Revenue & Expenditures Performance b. Dashboard Expense Detail c. Dashboard Collection / Receivables d. Dashboard Expenses Per Activity OJK Wide e. Dashboard Budget Realization by Division & Working Unit (aka Satuan Kerja (Satker)) f. Dashboard EWS (Early Warning System) as follows: 1. Fixed Asset 2. Business Trip 3. Cash Advance 4. Debt 5. Budget Transfer across Activities g. Dashboard Budget Revision h. Dashboard Financial \n•Design and set up of BW ETL objects (Extraction, Transformation, Loading) to load from SAP S/4 HANA to BW for Dashboard & BPC \n•Design and set up BPC Input Schedules & Reports for Input Data & Reporting \n•Design and set up BPF (Business Process Flow) for workflow, linking all tasks required to be done in sequential manner \n•Design and set up BPC Security (User, Team, Task Profile, Member Access Profile). \n•Conducting user training. \n•Unit Testing, preparation of UAT script, troubleshooting and bug-fixing during UAT (User Acceptance Testing). \n•Writing final functional-technical documentation. \n•Post Go-Live on-site support Project : Implementation for SAP BW for Group Tax Report Client : PT Astra International, Tbk - Indonesia Astra International was established in 1957, is a large and well-known group of companies in Indonesia, which operates in the following business segments: Automotive, Financial Services, Heavy Industry, Mining, Construction & Energy, Agrobusiness, Infrastructure & Logistic, Information Technology, Property. At the end of 2018, Astra International Group has 229 Subsidiaries, Joint Ventures and Associates, which in total employ 224,488 employees , occupation={jobTitle=SAP BPC-BW-Dashboard Solution Architect, jobTitleNormalized=SAP BW Architect, classification=null, managementLevel=Low}}]','[{id=90710911, emsiId=KS126Z06HW8YB5PM0JXL, name=Networking Basics, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710912, emsiId=KS440SJ73G5RZYMLVKV7, name=Source (Game Engine), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710913, emsiId=ESB4C707E98B551DE4A2, name=Variance Analysis, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710914, emsiId=KS4408D6DYMSTKBP94N4, name=SAP CRM, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Achievements, position=null, workExperienceId=null}, {section=PersonalDetails, position=null, workExperienceId=null}, {section=Projects, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710915, emsiId=KS1218L60PDVZX16NZT1, name=Dashboard, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710918, emsiId=KS123YJ6KVWC91BTMB4R, name=Financial Statements, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710919, emsiId=KS123X777H5WFNXQ6BPM, name=Sales, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710920, emsiId=KS122B071LMGXVTT3Z91, name=Consulting, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Achievements, position=null, workExperienceId=null}, {section=PersonalDetails, position=null, workExperienceId=null}]}, {id=90710924, emsiId=KS122J96Z72S4MNP021Z, name=Critical Path Method (CPM) Scheduling, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Achievements, position=null, workExperienceId=null}]}, {id=90710925, emsiId=KS122626T550SLQ7QZ1C, name=Procurement, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710926, emsiId=KS1200365FTR9X0M96T9, name=Microsoft Word, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710927, emsiId=KS440GC6JXTJ6G11QFF1, name=Sensitivity Analysis, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710931, emsiId=KS1254G739VBXHP430DV, name=Information Management, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710934, emsiId=KS120HK5XY6JV257QLTX, name=Budgeting, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710937, emsiId=KS122PM76DCYL9WC89Y7, name=Data Modeling, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710938, emsiId=KSUS9XM8DSF96YI9S2QY, name=Query Designer, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710939, emsiId=KS680KR72KH02C5GM5TY, name=Scheduling, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710940, emsiId=KS1225K67C74NWDXNJSL, name=Community Development, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710947, emsiId=KS125716TLTGH6SDHJD1, name=Integration, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710949, emsiId=KS1200H6XYN1CR0G5NZ0, name=Microsoft Excel, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710951, emsiId=KSBACVV6XBM187ND3YP9, name=Enterprise Portal, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710956, emsiId=KS120GV5ZXR64CJLL1J4, name=Analytics, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710958, emsiId=KS122086PPY11B2M1G6N, name=Library, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710962, emsiId=KS1203W702ND09XHKJR5, name=Accounting, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710965, emsiId=KS1218W78FGVPVP2KXPX, name=Management, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710966, emsiId=KSBLWK2MV120ZA9RXZZA, name=Aluminum, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710967, emsiId=KS4420B62MSJ581QJTY7, name=Web Intelligence, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710968, emsiId=ESFB6F6182E69DA80843, name=Production Planning, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710973, emsiId=KS122556LMQ829GZCCRV, name=Communications, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710974, emsiId=KSIWI0KC7LJJOB1UUOPN, name=SAP BusinessObjects, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710975, emsiId=KS441JM6PR848J3HYJDK, name=Trial Balance, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710977, emsiId=KS441K2756CXYXBG990G, name=Troubleshooting (Problem Solving), lastUsed=2023-01-18, numberOfMonths=38, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710978, emsiId=KS122K364PHRMJK84H46, name=Crystal Reports (Reporting Software), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710979, emsiId=KS1265P60HXFPH0VLFVP, name=Marketing Planning, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710981, emsiId=KS4425C7820LCHZS7VGX, name=Writing, lastUsed=2023-01-18, numberOfMonths=38, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710982, emsiId=KS1282Z69X0BW8CXTPXH, name=Production Systems, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710984, emsiId=KS123Q76HP7VYGN828DQ, name=Exchange Web Services (EWS), lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710985, emsiId=KS120BG6ZM1GMLSN3RN2, name=Agribusiness, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710987, emsiId=KS127ZG6DBSF76WF7VYX, name=Microsoft PowerPoint, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710989, emsiId=KS120SX72T8B5VLXS1VN, name=Unit Testing, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710935, emsiId=ESEB1D4619E6E83A061D, name=Planning, lastUsed=2023-01-18, numberOfMonths=38, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710936, emsiId=KS1217R6SMDJ0WQHN6LK, name=Construction, lastUsed=2023-01-18, numberOfMonths=38, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710946, emsiId=KSPKPXOKV8TQIZVTYC7I, name=Heavy Industry, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710950, emsiId=KS121XY6VSGJ3Z6J82FQ, name=Infrastructure, lastUsed=2023-01-18, numberOfMonths=38, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710954, emsiId=KS120W2749QQKD4JMM68, name=Transformation (Genetics), lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710969, emsiId=KS1202P6S8HY0WGG2T0Z, name=Activity-Based Costing, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710908, emsiId=KS4407L6GDCJ6V5MR7CN, name=Sales Planning, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710909, emsiId=KS441RD6NRHRTH3K7RCB, name=Visual Basic For Applications, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710910, emsiId=KS123ZJ5X02D3GL6CNQT, name=Fixed Asset, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710916, emsiId=KS1218Y74WJ6YV4KH0DM, name=Business Process, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Achievements, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710917, emsiId=KS126XY72XMMYBGMY9NR, name=Net Income, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710923, emsiId=KS123226LLZPHTR6L2RN, name=Distribution System Operators (DSO), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710929, emsiId=KS1287R64YNBZGR50Y1N, name=Purchasing, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710932, emsiId=KS7G24169Z487XMD80CY, name=Lifecycle Management, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710933, emsiId=KS1281Z6YSCYDNCG1D8T, name=Process Design, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Achievements, position=null, workExperienceId=null}]}, {id=90710943, emsiId=KS123Y56VDHMZ288XX1W, name=Financial Accounting, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710944, emsiId=KS1277F6C7QNT6S8QB0N, name=Occupational Health And Safety Management System (OHSAS), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710945, emsiId=KS123CS6YTNDCKSB4Q8Z, name=Enterprise Information Management, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710948, emsiId=KS4408479KK2CRZ06GYC, name=SAP ABAP, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Achievements, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710952, emsiId=KS122PG64BT2BT6X15HF, name=Data Management, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710953, emsiId=KS686Y976L1WJ98QFSD4, name=Authorization (Computing), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710959, emsiId=KS126YT5ZTJ1MF8NDP4M, name=SAP NetWeaver, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710960, emsiId=KS125XD6KD05NGCNJ67M, name=Live Reporting, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710961, emsiId=KS7G0RD6WYFCX6NMLMHB, name=Staging, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710963, emsiId=KS1202M5WG4B7X3VVF6Y, name=Advanced Business Application Programming (ABAP), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Achievements, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710964, emsiId=KS7G34L6G8Q52CN7WNYB, name=BI Launch Pad (Software), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710970, emsiId=KS120ZX7019J4V8DHBTM, name=Business Intelligence, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710971, emsiId=KS1238D6ZKKXT9GPCZK8, name=Web Dynpro, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Achievements, position=null, workExperienceId=null}]}, {id=90710972, emsiId=KS127NP6PY9GM1BTM9V9, name=Pension Funds, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710976, emsiId=KS126LQ6ZKDQX58GZ0QF, name=Minority Interest, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710980, emsiId=KS1219B681X3J9MK0KPH, name=Business Systems, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Achievements, position=null, workExperienceId=null}]}, {id=90710983, emsiId=KS7G7X55ZKBF0R0WCSZQ, name=Consolidation, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90710986, emsiId=KS1241P6PXRCKTDSWHTV, name=Forecasting, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710988, emsiId=KS127H05WDKJ5BPKWVH2, name=Outsourcing, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90710990, emsiId=KS1226Y6DNDT05G7FJ4J, name=Computer Science, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Achievements, position=null, workExperienceId=null}]}, {id=90710922, emsiId=KS120W86KJ30NQJCQ3ZP, name=Balance Sheet, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710928, emsiId=KS1227V6WBR3BH3SJYSZ, name=Information Technology, lastUsed=2023-01-18, numberOfMonths=38, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710930, emsiId=KS123Y170CZM0V5Z3XXB, name=Financial Services, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710941, emsiId=KS125KC6WBFJFHX7DH12, name=Joint Ventures, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710955, emsiId=KS122PF6FZS3609GDG0V, name=Extract Transform Load (ETL), lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=WorkExperience, position=0, workExperienceId=16769442}]}, {id=90710957, emsiId=KS7G27Y6XMZTKKSN6VCG, name=Receivables, lastUsed=2023-01-18, numberOfMonths=38, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=16769442}]}]','[Feb 2010 SAP Certified Application Associate Business Intelligence with, SAP NetWeaver 7 0 SAP Official Certification, Certificate ID 0005065369, Note Certificate and Exam Result in Appendix D Normally exam, I got exemption to take only the certification exam without undertaking, Oct 2011 Certified SAP BusinessObjects 4 0 Business Intelligence BI, Note Certificate in Appendix E, Oct 2011 Certified SAP BusinessObjects Planning Consolidation BPC, Note Certificate in Appendix F, Aug 2007 SAP BW Certificate of Achievement, Note Certificate attached in Appendix G, Dec 2007 SAP ABAP Certificate of Achievement, Note Certificate attached in Appendix H, Feb 2004 Dec 2004 Cisco Networking Academy Program CNAP, Courses completed, Full Time Intensive English Training, Indonesia Australia Language Foundation IALF]','[]','[]',NULL,NULL,NULL,'jUJGbZrK','24b432f1-0908-46d3-b99e-1550ee98a2ce',1,'2023-01-18T04:50:54.333494Z',0,NULL,'en',NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'active','AOZMJ'),(4,'2023-01-18 05:06:20',NULL,NULL,NULL,NULL,'ASWIN SETYAWAN MARGONO','Aswin','Margono','Setyawan','','[]','[]','[]',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'','[Formula, English]',NULL,'SAP CERTIFIED CONSULTANT- MODULE BPC / BO / BW',0,NULL,'[{id=8980258, organization=Monash University, accreditation={education=Master of Business, educationLevel=masters, inputStr=MASTER OF BUSINESS SYSTEMS PROFESSIONAL, matchStr=Master of Business}, grade={raw=GPA : 3.81 OUT OF 4.00, value=3.81, metric=GPA}, location={formatted=Melbourne VIC, Australia, streetNumber=null, street=null, apartmentNumber=null, city=Melbourne, postalCode=null, state=Victoria, country=Australia, rawInput=MELBOURNE, AUSTRALIA., countryCode=AU, latitude=-37.8136276, longitude=144.9630576}, dates=null}, {id=8980259, organization=SEKOLAH TINGGI TEKNIK SURABAYA (STTS) UNIVERSITY, accreditation={education=Bachelor of Science, educationLevel=bachelors, inputStr=BACHELOR OF COMPUTER SCIENCE, matchStr=}, grade={raw=GPA : 3.88 OUT OF 4.00, value=3.88, metric=GPA}, location={formatted=Surabaya, Surabaya City, East Java, Indonesia, streetNumber=null, street=null, apartmentNumber=null, city=Surabaya, postalCode=null, state=East Java, country=Indonesia, rawInput=SURABAYA, INDONESIA., countryCode=ID, latitude=-7.2574719, longitude=112.7520883}, dates=null}, {id=8980260, organization=EDUCATION, accreditation={educationLevel=null, inputStr=, matchStr=}, grade=null, location={formatted=Germany, streetNumber=null, street=null, apartmentNumber=null, city=null, postalCode=null, state=null, country=Germany, rawInput=Germany, countryCode=DE, latitude=51.165691, longitude=10.451526}, dates=null}, {id=8980261, organization=Australia, accreditation={educationLevel=null, inputStr=, matchStr=}, grade=null, location=null, dates=null}]',NULL,NULL,'[]','[{id=90716049, emsiId=KS121XY6VSGJ3Z6J82FQ, name=Infrastructure, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716050, emsiId=KS120XP636CB5432F5TP, name=Telecommunications, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Summary, position=null, workExperienceId=null}]}, {id=90716051, emsiId=KS1200365FTR9X0M96T9, name=Microsoft Word, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716053, emsiId=KSIWI0KC7LJJOB1UUOPN, name=SAP BusinessObjects, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Summary, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716054, emsiId=KS440SJ73G5RZYMLVKV7, name=Source (Game Engine), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716057, emsiId=KS4408D6DYMSTKBP94N4, name=SAP CRM, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Summary, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716058, emsiId=KS1218L60PDVZX16NZT1, name=Dashboard, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716059, emsiId=KS125B66VRYM8D0PT6J2, name=Inventory Turnover, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716060, emsiId=KS120W2749QQKD4JMM68, name=Transformation (Genetics), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716061, emsiId=KS1254G739VBXHP430DV, name=Information Management, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716068, emsiId=KS128F265DV4XTBR70H7, name=Real Estate, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Summary, position=null, workExperienceId=null}]}, {id=90716069, emsiId=KS120HK5XY6JV257QLTX, name=Budgeting, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Summary, position=null, workExperienceId=null}]}, {id=90716070, emsiId=KS122086PPY11B2M1G6N, name=Library, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716071, emsiId=KS122K364PHRMJK84H46, name=Crystal Reports (Reporting Software), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Summary, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716072, emsiId=ESEB1D4619E6E83A061D, name=Planning, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Summary, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716073, emsiId=KS123YJ6KVWC91BTMB4R, name=Financial Statements, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716074, emsiId=KS123X777H5WFNXQ6BPM, name=Sales, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716075, emsiId=KS122B071LMGXVTT3Z91, name=Consulting, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Summary, position=null, workExperienceId=null}]}, {id=90716076, emsiId=KS4402175903S3CYQ6CK, name=Restructuring (Business), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716077, emsiId=KSUS9XM8DSF96YI9S2QY, name=Query Designer, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Summary, position=null, workExperienceId=null}]}, {id=90716079, emsiId=KS680KR72KH02C5GM5TY, name=Scheduling, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716080, emsiId=KS120265WKHSMJ6HYX8P, name=Microsoft Windows, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Summary, position=null, workExperienceId=null}]}, {id=90716081, emsiId=KS122FL69C9376N0WS3D, name=Cosmetics, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716082, emsiId=KS7G2KJ6SYXLHHSC3RC4, name=Business Development Company (BDC), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716084, emsiId=KS1204B6FBVM6CXV6RDX, name=Depreciation, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716088, emsiId=KS123MH78JSKSKNGJPP3, name=Equity Method, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716089, emsiId=KS1218W78FGVPVP2KXPX, name=Management, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716093, emsiId=KS4420B62MSJ581QJTY7, name=Web Intelligence, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716095, emsiId=KS127CH6C5XN5Y6B4126, name=Working Capital, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716096, emsiId=ESFB6F6182E69DA80843, name=Production Planning, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716099, emsiId=KS125716TLTGH6SDHJD1, name=Integration, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716100, emsiId=KS127ZG6DBSF76WF7VYX, name=Microsoft PowerPoint, lastUsed=null, numberOfMonths=null, type=soft_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716048, emsiId=KS4407L6GDCJ6V5MR7CN, name=Sales Planning, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716052, emsiId=KS124DX6G31F5M9ZHNGC, name=Warehousing, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Summary, position=null, workExperienceId=null}]}, {id=90716055, emsiId=KS123NK6JJHH5LVPSZ4T, name=Estate Planning, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716056, emsiId=KS1221X6165XMMSMM26F, name=Coal Mining, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716062, emsiId=KS122PF6FZS3609GDG0V, name=Extract Transform Load (ETL), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716063, emsiId=KS1218Y74WJ6YV4KH0DM, name=Business Process, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716064, emsiId=KS126XY72XMMYBGMY9NR, name=Net Income, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716066, emsiId=KS122Q96S1LT3253TW3H, name=Data Warehousing, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Summary, position=null, workExperienceId=null}]}, {id=90716067, emsiId=KS126LQ6ZKDQX58GZ0QF, name=Minority Interest, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716078, emsiId=KS125XD6KD05NGCNJ67M, name=Live Reporting, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716083, emsiId=KS7G7X55ZKBF0R0WCSZQ, name=Consolidation, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Summary, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716085, emsiId=KS7G0RD6WYFCX6NMLMHB, name=Staging, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716086, emsiId=KS1202M5WG4B7X3VVF6Y, name=Advanced Business Application Programming (ABAP), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716087, emsiId=KS7G34L6G8Q52CN7WNYB, name=BI Launch Pad (Software), lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716090, emsiId=KS123TF6GHYX0KXK5LYZ, name=Fair Value, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716091, emsiId=KS123CS6YTNDCKSB4Q8Z, name=Enterprise Information Management, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716092, emsiId=KS1241P6PXRCKTDSWHTV, name=Forecasting, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716094, emsiId=KS122W96W0FK6XTZ20W4, name=Development Planning, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[]}, {id=90716097, emsiId=KS120W86KJ30NQJCQ3ZP, name=Balance Sheet, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Projects, position=null, workExperienceId=null}]}, {id=90716098, emsiId=KS120ZX7019J4V8DHBTM, name=Business Intelligence, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Summary, position=null, workExperienceId=null}, {section=Training/Certifications, position=null, workExperienceId=null}]}, {id=90716101, emsiId=KS4408479KK2CRZ06GYC, name=SAP ABAP, lastUsed=null, numberOfMonths=null, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}]}]','[Solution Consultant Certificate ID 0016099226, Certified SAP BusinessObjects Business Intelligence BI Enterprise, SAP ABAP Certificate of Achievement, SAP BW Certificate of Achievement, 13 Training on designing modules for Budget Planning and Forecasting and, 14 Training on developing BPC Input Schedules Reports, 15 Training on setting up BPC Security User Team Task Profile Member, 16 Training on setting up BPC Work Status to lock data, 17 Training on setting up Business Process Flow BPF as a guided menu for, 18 Training on Script Logic and BAdI for BPC]','[]','[]',NULL,NULL,NULL,'sRlomjNP','c5d27fef-6b5e-4149-8b80-afc0dcd15c60',1,'2023-01-18T05:06:21.089170Z',0,NULL,'en',NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,'active','VLA5W');
/*!40000 ALTER TABLE `tb_resume` ENABLE KEYS */;
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
INSERT INTO `tb_user` VALUES (1,'2019-09-03 15:42:44',0,NULL,'2022-10-13 04:38:47',1,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin','123','active','xycnh1fzl8chkm8cqr20ni6zvh2ai52c3mvw2uwy0s86mscu9u80h6ylym2imghas6h6ffj05taecfoxfu3g0x8alwbt97q9je8f','1111343528-20q4jm5fw1-Cluster-Morizen-Bekasi-Indonesia.jpg','ymju8h3zhemj0nhcoqrcvu1i961fhslotr0c',NULL,NULL),(2,'2021-11-04 12:00:07',1,NULL,'2022-03-29 09:55:17',1,'pic1@mail.com','202cb962ac59075b964b07152d234b70','pic','one',NULL,'active',NULL,NULL,'ng843n6ocg719kklqklb5814t9n2ahilj9zv',NULL,NULL),(3,'2021-11-04 12:12:24',1,NULL,'2022-03-29 09:55:28',1,'pic2@mail.com','202cb962ac59075b964b07152d234b70','pic','two',NULL,'active',NULL,NULL,'b3n95p03tsdpm9fya84cnelibj9u34xffz6j',NULL,NULL),(4,'2021-11-04 12:13:34',1,NULL,'2022-03-29 09:55:39',1,'pic3@mail.com','202cb962ac59075b964b07152d234b70','pic','three',NULL,'active',NULL,NULL,'zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl',NULL,NULL),(5,'2022-02-07 09:12:44',1,NULL,'2022-03-29 09:55:49',1,'pic4@mail.com','202cb962ac59075b964b07152d234b70','pic','four',NULL,'active',NULL,NULL,'ni5ju0wgw0l4x3gxoq0cgh3jn3lyvejl5aq8',NULL,NULL),(6,'2022-02-07 09:48:32',1,NULL,'2022-03-29 09:56:15',1,'pic6@mail.com','202cb962ac59075b964b07152d234b70','pic','six',NULL,'active',NULL,NULL,'onlidhsdmmgz9k8gxzq2dfazrhshyx9zv53p',NULL,NULL),(7,'2022-02-08 08:57:14',1,NULL,'2022-03-29 09:56:26',1,'pic7@mail.com','202cb962ac59075b964b07152d234b70','pic','seven',NULL,'active',NULL,NULL,'it1wq7s6txkfcl6xw2iji0dmebrmc7b41mtv',NULL,NULL),(8,'2022-02-08 08:57:34',1,NULL,'2022-03-29 09:56:35',1,'pic8@mail.com','202cb962ac59075b964b07152d234b70','pic','eight',NULL,'active',NULL,NULL,'macc9yxlcnfjqix254tmbf0h4459a9w22xfi',NULL,NULL),(9,'2022-02-08 08:58:30',1,NULL,'2022-03-29 09:56:54',1,'pic9@mail.com','202cb962ac59075b964b07152d234b70','pic','nine',NULL,'active',NULL,NULL,'jayf1yr5fd07mshu2c4a29ih8li17beubiwc',NULL,NULL),(10,'2022-02-08 08:59:52',1,NULL,'2022-03-29 09:57:02',1,'pic10@mail.com','202cb962ac59075b964b07152d234b70','pic','ten',NULL,'active',NULL,NULL,'i8m95htaivk0u5mcjfy3ioo0k9zxxf8lpp5h',NULL,NULL),(11,'2022-02-14 11:18:06',1,NULL,'2022-03-29 09:57:11',1,'pic11@mail.com','202cb962ac59075b964b07152d234b70','pic','eleven',NULL,'active',NULL,NULL,'lk9i5cv2dm5bnyz07apzo3wirxodwfhhxf85',NULL,NULL),(12,'2022-02-14 11:19:22',1,NULL,'2022-03-29 09:57:20',1,'pic12@mail.com','202cb962ac59075b964b07152d234b70','pic','twelve',NULL,'active',NULL,NULL,'uzf4niy96076mn4crvfsalm9r06uoey2spjj',NULL,NULL),(13,'2022-02-16 07:42:39',1,NULL,'2022-03-29 09:57:29',1,'pic13@mail.com','202cb962ac59075b964b07152d234b70','pic','thirteen',NULL,'active',NULL,NULL,'oka59r3uxjbqi7pfwpv2kbiyf1tuxedqvam6',NULL,NULL),(14,'2022-02-24 03:08:59',1,NULL,'2022-04-18 06:25:36',14,'pic14@mail.com','202cb962ac59075b964b07152d234b70','pic','fourteen',NULL,'active',NULL,NULL,'ntw5zeue28u72o3bkbdukg0hjahj25bqcljx',NULL,NULL),(28,'2022-12-13 15:22:59',NULL,1,'2023-01-18 11:56:10',28,'achmad.amri@gmail.com','202cb962ac59075b964b07152d234b70','Achmad','Amri','081380782318','active','71imewz8stbcafcx7s2rrukdyzx6plwbdze9gparu9tlrz1wqlw9yhcuq4jp13xprvwa2o4jkqblhxnoz87c7oh9k631uerecms1',NULL,'AEK3NX1GQOYFCDHGL8E5G8SG1OP0ZTJUW72E',NULL,NULL);
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

-- Dump completed on 2023-01-18 19:06:28
