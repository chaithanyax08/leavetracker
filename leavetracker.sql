/*
SQLyog Community v13.2.1 (64 bit)
MySQL - 8.0.34 : Database - leavetracker
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`leavetracker` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `leavetracker`;

/*Table structure for table `departments` */

DROP TABLE IF EXISTS `departments`;

CREATE TABLE `departments` (
  `departmentid` int DEFAULT NULL,
  `department_name` varchar(100) NOT NULL,
  UNIQUE KEY `departmentid` (`departmentid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `departments` */

insert  into `departments`(`departmentid`,`department_name`) values 
(1,'CS'),
(2,'ME'),
(3,'EC'),
(4,'EE'),
(5,'principal');

/*Table structure for table `holidays` */

DROP TABLE IF EXISTS `holidays`;

CREATE TABLE `holidays` (
  `holidayid` int NOT NULL,
  `date` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `deleted_at` datetime DEFAULT NULL,
  `fk_created_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `fk_updated_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `fk_deleted_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  KEY `created_by` (`fk_created_by`),
  KEY `updated_by` (`fk_updated_by`),
  KEY `deleted_by` (`fk_deleted_by`),
  CONSTRAINT `holidays_ibfk_1` FOREIGN KEY (`fk_created_by`) REFERENCES `tblusers` (`userid`),
  CONSTRAINT `holidays_ibfk_2` FOREIGN KEY (`fk_updated_by`) REFERENCES `tblusers` (`userid`),
  CONSTRAINT `holidays_ibfk_3` FOREIGN KEY (`fk_deleted_by`) REFERENCES `tblusers` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `holidays` */

insert  into `holidays`(`holidayid`,`date`,`description`,`created_at`,`updated_at`,`deleted_at`,`fk_created_by`,`fk_updated_by`,`fk_deleted_by`) values 
(1,'2024-02-01 12:29:56','pernal','2024-01-01 12:30:07','2024-04-08 12:30:38',NULL,'2',NULL,NULL),
(2,'2024-04-02 12:31:20','ugadi','2024-03-13 12:31:37','2024-04-08 12:31:53',NULL,'2',NULL,NULL);

/*Table structure for table `leaveaction` */

DROP TABLE IF EXISTS `leaveaction`;

CREATE TABLE `leaveaction` (
  `leaveactionid` int DEFAULT NULL,
  `fk_leaveid` int DEFAULT NULL,
  `fk_approved_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `approved_datetime` datetime DEFAULT NULL,
  `fk_rejected_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `reject_datetime` datetime DEFAULT NULL,
  `rejectreason` varchar(255) DEFAULT NULL,
  KEY `leaveid` (`fk_leaveid`),
  KEY `approved_by` (`fk_approved_by`),
  KEY `rejected_by` (`fk_rejected_by`),
  CONSTRAINT `leaveaction_ibfk_1` FOREIGN KEY (`fk_leaveid`) REFERENCES `leaveapply` (`leaveid`),
  CONSTRAINT `leaveaction_ibfk_2` FOREIGN KEY (`fk_approved_by`) REFERENCES `tblusers` (`userid`),
  CONSTRAINT `leaveaction_ibfk_3` FOREIGN KEY (`fk_rejected_by`) REFERENCES `tblusers` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `leaveaction` */

insert  into `leaveaction`(`leaveactionid`,`fk_leaveid`,`fk_approved_by`,`approved_datetime`,`fk_rejected_by`,`reject_datetime`,`rejectreason`) values 
(1,0,NULL,NULL,'2','2024-04-08 12:38:10','pending works'),
(2,1,'2','2024-04-08 18:12:54',NULL,NULL,NULL);

/*Table structure for table `leaveapply` */

DROP TABLE IF EXISTS `leaveapply`;

CREATE TABLE `leaveapply` (
  `leaveid` int DEFAULT NULL,
  `fk_userid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `working_days` int DEFAULT NULL,
  `fk_typeid` int DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  UNIQUE KEY `leaveid` (`leaveid`),
  KEY `userid` (`fk_userid`),
  KEY `typeid` (`fk_typeid`),
  CONSTRAINT `leaveapply_ibfk_1` FOREIGN KEY (`fk_userid`) REFERENCES `tblusers` (`userid`),
  CONSTRAINT `leaveapply_ibfk_2` FOREIGN KEY (`fk_typeid`) REFERENCES `leavetype` (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `leaveapply` */

insert  into `leaveapply`(`leaveid`,`fk_userid`,`from_date`,`to_date`,`working_days`,`fk_typeid`,`reason`) values 
(0,'1','2024-03-29',NULL,1,0,'jathre'),
(1,'3','2024-04-08','2024-04-09',2,1,'fever');

/*Table structure for table `leavetype` */

DROP TABLE IF EXISTS `leavetype`;

CREATE TABLE `leavetype` (
  `typeid` int DEFAULT NULL,
  `typename` varchar(50) DEFAULT NULL,
  `maxdays` int DEFAULT NULL,
  UNIQUE KEY `UK_leavetype_leavetypeid` (`typeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `leavetype` */

insert  into `leavetype`(`typeid`,`typename`,`maxdays`) values 
(0,'casual',15),
(1,'sick',NULL);

/*Table structure for table `tblusers` */

DROP TABLE IF EXISTS `tblusers`;

CREATE TABLE `tblusers` (
  `userid` varchar(50) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fk_departmentid` int DEFAULT NULL,
  `isadmin` int DEFAULT NULL,
  `isactive` int DEFAULT NULL,
  `phoneno` varchar(20) DEFAULT NULL,
  `fk_createduserid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `profilephoto` varchar(255) DEFAULT NULL,
  `created_datetime` datetime DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `userid` (`userid`),
  UNIQUE KEY `phoneno` (`phoneno`),
  KEY `createduserid` (`fk_createduserid`),
  KEY `fk_department` (`fk_departmentid`),
  CONSTRAINT `fk_department` FOREIGN KEY (`fk_departmentid`) REFERENCES `departments` (`departmentid`),
  CONSTRAINT `tblusers_ibfk_1` FOREIGN KEY (`fk_createduserid`) REFERENCES `tblusers` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tblusers` */

insert  into `tblusers`(`userid`,`username`,`password`,`fk_departmentid`,`isadmin`,`isactive`,`phoneno`,`fk_createduserid`,`profilephoto`,`created_datetime`) values 
('1','chaithanya','chaithu',1,0,1,'9483751095','2','url','2024-04-08 11:23:43'),
('2','Anu','anu',5,1,1,'9988774455','2','url','2024-04-08 11:30:10'),
('3','Jahnavi','janu',2,0,1,'9638527410','2','url','2024-04-08 18:11:05');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
