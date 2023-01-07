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
INSERT INTO `tb_department` VALUES (1,NULL,28,1,'2023-01-05 16:58:06',28,'Human Resources','active','26EYH'),(2,NULL,28,1,'2023-01-04 13:55:46',28,'Product and Development','active','9IFU7'),(3,NULL,28,1,'2023-01-05 13:42:42',28,'Sales and Marketing','active','6H74K'),(4,NULL,28,1,'2023-01-05 07:17:52',28,'Information Technology','active','7KJU8'),(5,'2023-01-03 09:11:23',28,1,'2023-01-05 07:56:34',28,'RnD','active','4LO6G'),(7,'2023-01-03 15:39:43',28,1,'2023-01-05 13:25:46',28,'CEO Office','active','0AWNA'),(8,'2023-01-03 15:42:56',28,1,'2023-01-04 09:35:43',28,'Blockchain','active','1WV47'),(9,'2023-01-03 15:43:28',28,1,'2023-01-04 08:33:25',28,'Data Science','active','Q1ITU'),(10,'2023-01-05 13:26:04',28,1,NULL,NULL,'BOD','active','1DSMX'),(11,'2023-01-05 13:28:10',28,1,NULL,NULL,'Legal','active','YOODH');
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
INSERT INTO `tb_department_job` VALUES (1,'2023-01-05 12:01:37',28,1,'2023-01-05 16:05:52',28,'assigned',1,1,'H8T6D'),(2,'2023-01-05 12:01:48',28,1,'2023-01-05 12:04:18',28,'assigned',1,3,'UP7E2'),(3,'2023-01-05 12:02:17',28,1,NULL,NULL,'assigned',2,4,'91I92'),(4,'2023-01-05 12:02:20',28,1,NULL,NULL,'assigned',2,5,'BMMEP'),(5,'2023-01-05 12:02:52',28,1,NULL,NULL,'assigned',3,3,'KRLB4'),(6,'2023-01-05 12:02:58',28,1,NULL,NULL,'assigned',5,5,'5N3AY'),(7,'2023-01-05 12:03:17',28,1,NULL,NULL,'assigned',4,3,'Y6184'),(8,'2023-01-05 12:03:24',28,1,'2023-01-05 13:25:05',28,'assigned',5,3,'1WKT1'),(9,'2023-01-05 13:21:10',28,1,'2023-01-05 13:21:12',28,'assigned',1,2,'PF3BI'),(10,'2023-01-05 13:25:28',28,1,NULL,NULL,'assigned',7,1,'OCM9E'),(11,'2023-01-05 13:41:30',28,1,'2023-01-05 13:41:33',28,'assigned',5,1,'5757N');
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
INSERT INTO `tb_job` VALUES (1,NULL,NULL,1,'2023-01-05 16:33:56',28,'Software Engineer','active','8HU6O'),(2,NULL,NULL,1,'2023-01-05 16:08:53',28,'QA Engineer','active','9LK76'),(3,NULL,NULL,1,'2023-01-05 16:08:54',28,'Product Owner','active','HASD6'),(4,NULL,NULL,1,'2023-01-05 16:08:56',28,'HR Manager','active','17G6Y'),(5,NULL,NULL,1,'2023-01-05 16:51:02',28,'HR Staff','active','A87JH'),(6,NULL,NULL,1,'2023-01-05 16:51:10',28,'CEO','active','G67HJ');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_resume`
--

LOCK TABLES `tb_resume` WRITE;
/*!40000 ALTER TABLE `tb_resume` DISABLE KEYS */;
INSERT INTO `tb_resume` VALUES (1,'2023-01-07 11:50:23',NULL,NULL,NULL,NULL,'ACHMAD AMRI AYUBUH ANSYORI','Achmad','Ansyori','Amri Ayubuh','','[+6281380782318]','[]','[]','1981-08-19','127 c, Jl. Kayuringin Jaya No.13, RT.001/RW.017, Kayuringin Jaya, Kec. Bekasi Sel., Kota Bks, Jawa Barat 17144, Indonesia','17144','Jawa Barat','Indonesia','ID','Jl. Gunung Gede V No 127 C. Rt.04/Rw.13 Kayuringin Jaya. Bekasi - Jawa Barat.','13','Jalan Kayuringin Jaya','127 c',NULL,'','[English]',NULL,'',12,NULL,'[{id=8563966, organization=Fakultas Ilmu Komputer Universitas Gunadarma, accreditation={education=Manajemen Informatika,, educationLevel=null, inputStr=Manajemen Informatika,, matchStr=}, grade=null, location=null, dates={startDate=null, completionDate=2006-01-01, isCurrent=false}}, {id=8563967, organization=Teknik Informatika, MDP, accreditation={educationLevel=null, inputStr=, matchStr=}, grade=null, location={formatted=Palembang, Palembang City, South Sumatra, Indonesia, streetNumber=null, street=null, apartmentNumber=null, city=Palembang, postalCode=null, state=South Sumatra, country=Indonesia, rawInput=Palembang,, countryCode=ID}, dates={startDate=null, completionDate=2000-01-01, isCurrent=false}}, {id=8563968, organization=PALEMBANG, accreditation={education=SMAN 10, educationLevel=null, inputStr=SMAN 10, matchStr=}, grade=null, location=null, dates={startDate=null, completionDate=1999-01-01, isCurrent=false}}, {id=8563969, organization=PALEMBANG, accreditation={education=SMPN 1, educationLevel=null, inputStr=SMPN 1, matchStr=}, grade=null, location=null, dates={startDate=null, completionDate=1993-01-01, isCurrent=false}}]','Senior Platform Developer',NULL,'[{id=15975529, jobTitle=Founder, Director, eCommerce Implementation Consultant, organization=PT. BTECHNO SOLUSI DIGITAL, location=null, dates={startDate=2021-06-01, endDate=2023-01-07, monthsInPosition=19, isCurrent=true}, jobDescription=Project based consultant on various projects from private and government owned company : PT Rajawali Berdikari Indonesia Attendance Application PT. Tiga Global Sejahtera Distribution Management System https://dms.id-trec.com PT Kustodian Sentral Efek Indonesia (KSEI) Revamp GUI for S-Invest Latest technology and/or Methodology that were deployed: Vaadin Angular , occupation={jobTitle=Founder, Director, eCommerce Implementation Consultant, jobTitleNormalized=null, classification=null, managementLevel=null}}, {id=15975530, jobTitle=Senior Manager Platform Development, organization=PT. Sumber Trijaya Lestari (alfacart.com), location=null, dates={startDate=2016-01-01, endDate=2021-03-01, monthsInPosition=62, isCurrent=false}, jobDescription=direct report to VP / Head of IT Managing and mentoring development team in all activities from assessment, pre development strategy, development phase, deployment rollout, and post deployment. Leading development team to delivery ecommerce microservices based applications for both frontend and backend. Technology and/or Methodology that were deployed: Ubuntu Desktop, Ubuntu Server, Centos, Microsoft Windows, Microsoft Project, Microsoft Power point, Microsoft Word, Php, J2EE, Oracle Service Bus, Oracle Database, PostgreSQL Database, MySQL Database, Magento Enterprise, SOLR, Java JAX-WS, Java JAX-RS, Google Web Toolkit, Apache Tomcat, Oracle Weblogic, Code Igniter, Bootstrap, SVN, JIRA, Confluence, Google Cloud Platform, Amazon Web Services, MongoDB, Redis, Kubernetes, Kafka, Confluent, Spring Boot, Machine Learning (Weka, Rapidminer). , occupation={jobTitle=Senior Manager Platform Development, jobTitleNormalized=Platform Development Manager, classification=null, managementLevel=Mid}}, {id=15975531, jobTitle=Senior Manager Backend Developer, organization=PT. XL Planet (elevenia.co.id), location=null, dates={startDate=2014-01-01, endDate=2015-12-01, monthsInPosition=23, isCurrent=false}, jobDescription=Having responsibilities for giving assessment of possibilities, options, and schedule for task and giving directions, strategies, and guidance to team for completing the task based on team load and team capacity. Technology and/or Methodology that were deployed: Microsoft Power point, Microsoft Word, J2EE, Oracle Database, SQL Developer, Apache Tomcat, Oracle Weblogic. , occupation={jobTitle=Senior Manager Backend Developer, jobTitleNormalized=Drupal Backend Developer, classification={socCode=2134, title=Programmers and software development professionals , minorGroup=Information Technology Professionals, subMajorGroup=SCIENCE, RESEARCH, ENGINEERING AND TECHNOLOGY PROFESSIONALS, majorGroup=PROFESSIONAL OCCUPATIONS}, managementLevel=Low}}, {id=15975532, jobTitle=Technical Consultant, organization=PT Mitra Integrasi Informatika, location=null, dates={startDate=2010-11-01, endDate=2013-12-01, monthsInPosition=37, isCurrent=false}, jobDescription=Extending, design and deliver KPEI Middleware, as a backbone for KPEI day to day operational process. Design phase: Gathering requirement and coordinate with multiple application vendors to provide SOA design. Create Project Plan, High Level Requirement, Business Proposal, and Document Design. Deliver phase: In charge with weekly Progress Meeting to update user with the latest condition of project, also with risks and issues arise within accomplished week. Deliver service according with business specification. Support phase: Give assessment with any Change Request, if exists. Bug fixing. Technology and/or Methodology that were deployed: Microsoft Word, Microsoft Project, Microsoft Excel, C++, J2EE, Oracle Database, MySQL Database, SQL Developer, Toad for MySQL, Apache Tomcat, Oracle Weblogic, Oracle SOA Suite. , occupation={jobTitle=Technical Consultant, jobTitleNormalized=Technical Consultant, classification={socCode=2139, title=Information technology professionals n.e.c., minorGroup=Information Technology Professionals, subMajorGroup=SCIENCE, RESEARCH, ENGINEERING AND TECHNOLOGY PROFESSIONALS, majorGroup=PROFESSIONAL OCCUPATIONS}, managementLevel=Low}}]','[{id=86061465, emsiId=KS126PF6PJY1N0ZX5R0P, name=MongoDB, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061467, emsiId=KS1261Z68KSKR1X31KS3, name=Machine Learning, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061469, emsiId=KS123KG6DL8N3D5ZW036, name=Java Platform Enterprise Edition (J2EE), lastUsed=2021-03-01, numberOfMonths=122, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=2, workExperienceId=15975531}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061470, emsiId=KSJF3PBD3995K6E0OF1Z, name=Kubernetes, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061472, emsiId=KS4420H75G906GRK0QJZ, name=Web Services, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061473, emsiId=KSFS12Z1D00MRUX8Z7E8, name=Magento, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061474, emsiId=KS4421N62QZJ2NZ9QJY7, name=Weka, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061475, emsiId=KS121KB68PWHRPJCJKQJ, name=CentOS, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061476, emsiId=ES6D557B9D5BE598FD74, name=Spring Boot, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061477, emsiId=KS120H6772VQ0MQ5RLVD, name=Angular (Web Framework), lastUsed=2023-01-07, numberOfMonths=19, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=15975529}]}, {id=86061479, emsiId=KS1200H6XYN1CR0G5NZ0, name=Microsoft Excel, lastUsed=2013-12-01, numberOfMonths=37, type=soft_skill, sources=[{section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061480, emsiId=KS120265WKHSMJ6HYX8P, name=Microsoft Windows, lastUsed=2021-03-01, numberOfMonths=62, type=soft_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061481, emsiId=KS1200C5XQWW78VQ5ZYL, name=PHP (Scripting Language), lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}, {section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061482, emsiId=KS120076FGP5WGWYMP0F, name=Java (Programming Language), lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061483, emsiId=KSZX7YZWNR5IDR1I2VMZ, name=Microservices, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061484, emsiId=KS120QQ6ZN003B8B7FK1, name=JIRA, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061485, emsiId=KS120JM6ZKSY0Q8PJ7WT, name=Apache Tomcat, lastUsed=2021-03-01, numberOfMonths=122, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=2, workExperienceId=15975531}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061486, emsiId=KS7G3YQ62YJG4LX9QFZT, name=Google Cloud, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061487, emsiId=KS126J46GGVZB8BGGXSY, name=Microsoft Project, lastUsed=2021-03-01, numberOfMonths=99, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061488, emsiId=KS1214R5XG4X4PY7LGY6, name=Bootstrap (Front-End Framework), lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061491, emsiId=KS1218W78FGVPVP2KXPX, name=Management, lastUsed=2023-01-07, numberOfMonths=19, type=soft_skill, sources=[{section=WorkExperience, position=0, workExperienceId=15975529}]}, {id=86061492, emsiId=KS440W865GC4VRBW6LJP, name=SQL (Programming Language), lastUsed=2021-03-01, numberOfMonths=122, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}, {section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=2, workExperienceId=15975531}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061494, emsiId=KSN97GEUHPNGNAQFDCGY, name=Apache Kafka, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061495, emsiId=KS1200365FTR9X0M96T9, name=Microsoft Word, lastUsed=2021-03-01, numberOfMonths=122, type=soft_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=2, workExperienceId=15975531}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061496, emsiId=KS120FG6YP8PQYYNQY9B, name=Amazon Web Services, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061497, emsiId=KS441Q56Y88HLXDMHM4Y, name=Vaadin, lastUsed=2023-01-07, numberOfMonths=19, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=15975529}]}, {id=86061498, emsiId=KS126QY605N7YVHFYCTW, name=MySQL, lastUsed=2021-03-01, numberOfMonths=99, type=hard_skill, sources=[{section=Training/Certifications, position=null, workExperienceId=null}, {section=WorkExperience, position=1, workExperienceId=15975530}, {section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061499, emsiId=KS441S66KZY7LM20RKYN, name=Software Versioning, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061466, emsiId=KS128D367HP9RPXPGSM7, name=RapidMiner, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061468, emsiId=KSIJ33GROZ22YMYACXRW, name=JAX-WS, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061471, emsiId=KS128G66RG96FZNHFCXY, name=Redis, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061478, emsiId=ESC7869CF7378283E0AA, name=Google Cloud Platform (GCP), lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061489, emsiId=KS1QEK3F0I7319NUW1TJ, name=Oracle Service Bus, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061490, emsiId=KS123GK5WYFRJ4L20YK2, name=Middleware, lastUsed=2013-12-01, numberOfMonths=37, type=hard_skill, sources=[{section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061493, emsiId=KS121T56Q1CL65W06BJ5, name=Change Request, lastUsed=2013-12-01, numberOfMonths=37, type=hard_skill, sources=[{section=WorkExperience, position=3, workExperienceId=15975532}]}, {id=86061500, emsiId=KS121CF62WFJ19GK02H7, name=Ubuntu (Operating System), lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}, {id=86061501, emsiId=KSCWA6GA1Q87T9ASI1UL, name=Rajawali, lastUsed=2023-01-07, numberOfMonths=19, type=hard_skill, sources=[{section=WorkExperience, position=0, workExperienceId=15975529}]}, {id=86061502, emsiId=KS125TB6YR6236RKM563, name=PostgreSQL, lastUsed=2021-03-01, numberOfMonths=62, type=hard_skill, sources=[{section=WorkExperience, position=1, workExperienceId=15975530}]}]','[]','[]','[]',NULL,99,NULL,'nDxLzzjZ','e4ebfa03-da4f-4c5e-94ab-db8ddf459cf7',1,'2023-01-07T11:50:22.296739Z',0,NULL,'en',NULL,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,'active','AUZOW');
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
INSERT INTO `tb_user` VALUES (1,'2019-09-03 15:42:44',0,NULL,'2022-10-13 04:38:47',1,'admin@mail.com','202cb962ac59075b964b07152d234b70','admin','admin','123','active','xycnh1fzl8chkm8cqr20ni6zvh2ai52c3mvw2uwy0s86mscu9u80h6ylym2imghas6h6ffj05taecfoxfu3g0x8alwbt97q9je8f','1111343528-20q4jm5fw1-Cluster-Morizen-Bekasi-Indonesia.jpg','ymju8h3zhemj0nhcoqrcvu1i961fhslotr0c',NULL,NULL),(2,'2021-11-04 12:00:07',1,NULL,'2022-03-29 09:55:17',1,'pic1@mail.com','202cb962ac59075b964b07152d234b70','pic','one',NULL,'active',NULL,NULL,'ng843n6ocg719kklqklb5814t9n2ahilj9zv',NULL,NULL),(3,'2021-11-04 12:12:24',1,NULL,'2022-03-29 09:55:28',1,'pic2@mail.com','202cb962ac59075b964b07152d234b70','pic','two',NULL,'active',NULL,NULL,'b3n95p03tsdpm9fya84cnelibj9u34xffz6j',NULL,NULL),(4,'2021-11-04 12:13:34',1,NULL,'2022-03-29 09:55:39',1,'pic3@mail.com','202cb962ac59075b964b07152d234b70','pic','three',NULL,'active',NULL,NULL,'zxfxjhji09xdf66s3usg6ro49l76ckrcmhyl',NULL,NULL),(5,'2022-02-07 09:12:44',1,NULL,'2022-03-29 09:55:49',1,'pic4@mail.com','202cb962ac59075b964b07152d234b70','pic','four',NULL,'active',NULL,NULL,'ni5ju0wgw0l4x3gxoq0cgh3jn3lyvejl5aq8',NULL,NULL),(6,'2022-02-07 09:48:32',1,NULL,'2022-03-29 09:56:15',1,'pic6@mail.com','202cb962ac59075b964b07152d234b70','pic','six',NULL,'active',NULL,NULL,'onlidhsdmmgz9k8gxzq2dfazrhshyx9zv53p',NULL,NULL),(7,'2022-02-08 08:57:14',1,NULL,'2022-03-29 09:56:26',1,'pic7@mail.com','202cb962ac59075b964b07152d234b70','pic','seven',NULL,'active',NULL,NULL,'it1wq7s6txkfcl6xw2iji0dmebrmc7b41mtv',NULL,NULL),(8,'2022-02-08 08:57:34',1,NULL,'2022-03-29 09:56:35',1,'pic8@mail.com','202cb962ac59075b964b07152d234b70','pic','eight',NULL,'active',NULL,NULL,'macc9yxlcnfjqix254tmbf0h4459a9w22xfi',NULL,NULL),(9,'2022-02-08 08:58:30',1,NULL,'2022-03-29 09:56:54',1,'pic9@mail.com','202cb962ac59075b964b07152d234b70','pic','nine',NULL,'active',NULL,NULL,'jayf1yr5fd07mshu2c4a29ih8li17beubiwc',NULL,NULL),(10,'2022-02-08 08:59:52',1,NULL,'2022-03-29 09:57:02',1,'pic10@mail.com','202cb962ac59075b964b07152d234b70','pic','ten',NULL,'active',NULL,NULL,'i8m95htaivk0u5mcjfy3ioo0k9zxxf8lpp5h',NULL,NULL),(11,'2022-02-14 11:18:06',1,NULL,'2022-03-29 09:57:11',1,'pic11@mail.com','202cb962ac59075b964b07152d234b70','pic','eleven',NULL,'active',NULL,NULL,'lk9i5cv2dm5bnyz07apzo3wirxodwfhhxf85',NULL,NULL),(12,'2022-02-14 11:19:22',1,NULL,'2022-03-29 09:57:20',1,'pic12@mail.com','202cb962ac59075b964b07152d234b70','pic','twelve',NULL,'active',NULL,NULL,'uzf4niy96076mn4crvfsalm9r06uoey2spjj',NULL,NULL),(13,'2022-02-16 07:42:39',1,NULL,'2022-03-29 09:57:29',1,'pic13@mail.com','202cb962ac59075b964b07152d234b70','pic','thirteen',NULL,'active',NULL,NULL,'oka59r3uxjbqi7pfwpv2kbiyf1tuxedqvam6',NULL,NULL),(14,'2022-02-24 03:08:59',1,NULL,'2022-04-18 06:25:36',14,'pic14@mail.com','202cb962ac59075b964b07152d234b70','pic','fourteen',NULL,'active',NULL,NULL,'ntw5zeue28u72o3bkbdukg0hjahj25bqcljx',NULL,NULL),(28,'2022-12-13 15:22:59',NULL,1,'2023-01-05 09:47:22',28,'achmad.amri@gmail.com','202cb962ac59075b964b07152d234b70','Achmad','Amri','081380782318','active','71imewz8stbcafcx7s2rrukdyzx6plwbdze9gparu9tlrz1wqlw9yhcuq4jp13xprvwa2o4jkqblhxnoz87c7oh9k631uerecms1',NULL,'j29f9u69biz3oia0xouf9m12iwdmes4au1ey',NULL,NULL);
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-07 18:52:17
