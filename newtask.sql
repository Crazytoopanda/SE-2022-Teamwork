/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.31 : Database - newtask
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`newtask` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `newtask`;

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `UID` varchar(50) NOT NULL,
  `input` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `output` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date` date NOT NULL,
  KEY `historyUID` (`UID`),
  CONSTRAINT `historyUID` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `history` */

insert  into `history`(`UID`,`input`,`output`,`date`) values ('123456','123','','2022-11-20'),('123456','123','','2022-11-20'),('123456','123','','2022-11-20'),('123456','123','壹佰贰拾叁元整','2022-11-20'),('123456','3333','叁仟叁佰叁拾叁元整','2022-11-20'),('123456','1231231','壹佰贰拾叁万壹仟贰佰叁拾壹元整','2022-11-20'),('123456','122','壹佰贰拾贰元整','2022-11-20'),('123456','贰元整','2','2022-11-20'),('123456','1123','壹仟壹佰贰拾叁元整','2022-11-20'),('123456','123123','壹拾贰万叁仟壹佰贰拾叁元整','2022-11-20'),('123456','11','壹拾壹元整','2022-11-20'),('123456','11','壹拾壹元整','2022-11-20');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `UID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `userName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`UID`,`password`,`userName`) values ('1','1','1'),('1231231','13','1'),('123456','123456','对对对'),('1234567','123456','对对对');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
