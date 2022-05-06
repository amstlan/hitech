/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.6.50-log : Database - hitech
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hitech` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `hitech`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `aid` bigint(20) NOT NULL,
  `uid` bigint(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  `post_code` varchar(10) DEFAULT NULL,
  `detailed_address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `address` */

insert  into `address`(`aid`,`uid`,`country`,`province`,`city`,`area`,`post_code`,`detailed_address`) values (1521358563853770754,1520962878970519554,'中国china','fjsss','fzssss','ytsss','ytsss','aasss'),(1522064541749075970,1520962878970519554,'美国','fj','fz','yt','123456','aa'),(1522229824158978050,1520962878970519554,'中国2222222','fj','fz','yt','123456','aa'),(1522491768484982785,1522229114554044418,'中国','fj','fz','yt','123456','aa');

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `bid` bigint(20) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `author` varchar(10) DEFAULT NULL,
  `test` varchar(2000) DEFAULT NULL,
  `imge` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `blog` */

insert  into `blog`(`bid`,`title`,`date`,`author`,`test`,`imge`) values (1,'Donec Ac Elit Id Metus Auctor Imperdiet Vitae Quis',NULL,'zs','Aliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer BiAliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer BiAliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer BiAliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer BiAliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit InterdumAliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer BiAliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer BiAliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer BiAliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer BAliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer BiAliquam Pharetra ','assets/img/blog/blog_1.jpg'),(2,'Nunc Placerat Augue Vel Porta Elementum Consequat ',NULL,'zs','Aliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer Bi','assets/img/blog/blog_2.jpg'),(3,'Nullam In Neque Vitae Arcu Auctor Dignissim Feugia',NULL,'zs','Aliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer Bi','assets/img/blog/blog_3.jpg'),(4,'Maecenas Suscipit Massa Quis Magna Dignissim Ultri',NULL,'zs','Aliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer Bi','assets/img/blog/blog_4.jpg'),(5,'Maecenas Suscipit Massa Quis Magna Dignissim Ultri',NULL,'v','Aliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer Bi','assets/img/blog/blog_5.jpg'),(6,'Maecenas Suscipit Massa Quis Magna Dignissim Ultri',NULL,'zs','Aliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer Bi','assets/img/blog/blog_6.jpg'),(7,'Ac Elit Donec Sollicitudin Lectus Ut Efficitur Lob',NULL,'v','Aliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer Bi','assets/img/blog/blog_2.jpg'),(8,'Ac Elit Donec Sollicitudin Lectus Ut Efficitur Lob',NULL,'zs','Aliquam Pharetra Enim Eget Sollicitudin Cursus. Phasellus Quis Lorem Mi. Vestibulum Luctus Velit Sit Amet Malesuada Molestie. Mauris Aliquam Lacinia Ligula, A Scelerisque Elit Interdum Non. Integer Bi','assets/img/blog/blog_1.jpg');

/*Table structure for table `cart` */

DROP TABLE IF EXISTS `cart`;

CREATE TABLE `cart` (
  `cid` bigint(20) NOT NULL,
  `uid` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `cart` */

insert  into `cart`(`cid`,`uid`,`pid`,`count`) values (1522052661475254274,1520962878970519554,0,1),(1522053313731469313,1520962878970519554,1,10),(1522205944950374401,1520962878970519554,1521510109156134914,1),(1522206042858012673,1520962878970519554,1521644176697421826,1),(1522225250878640130,1520962878970519554,1522225172562595842,1),(1522490679048073218,1522229114554044418,5,1);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `pid` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `size` char(2) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `old_price` int(11) DEFAULT NULL,
  `sku` int(11) DEFAULT NULL,
  `product_describe` varchar(200) DEFAULT NULL,
  `hot` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `product` */

insert  into `product`(`pid`,`name`,`price`,`color`,`brand`,`size`,`image`,`old_price`,`sku`,`product_describe`,`hot`) values (0,'Aliquam Top Erat Volutpat',12,'Black',NULL,'s','assets/img/product/product_3.jpg',1000,NULL,NULL,1),(1,'aaa',323,'White',NULL,'m','assets/img/product/product_5.jpg',1000,NULL,NULL,2),(2,'bbb',12,'Pink',NULL,'m','assets/img/product/product_3.jpg',1000,NULL,NULL,3),(3,'ccc',1,'Yellow',NULL,'l','assets/img/product/product_4.jpg',1000,NULL,NULL,4),(4,'ddd',123,'White',NULL,'xl','assets/img/product/product_5.jpg',1000,NULL,NULL,5),(5,'eee',32,'Pink',NULL,'m','assets/img/product/product_6.jpg',1000,NULL,NULL,6),(6,'qwe',32,'Yellow',NULL,'s','assets/img/product/product_3.jpg',1000,NULL,NULL,7),(7,'ads',232,'Pink',NULL,'s','assets/img/product/product_3.jpg',1000,NULL,NULL,8),(8,'zcx',43,'Black',NULL,'l','assets/img/product/product_3.jpg',1000,44,'666666666',9),(9,'asf',54,'White',NULL,'xl','assets/img/product/product_4.jpg',1000,NULL,NULL,0),(10,'asd',34,'Yellow',NULL,'m','assets/img/product/product_5.jpg',1000,NULL,NULL,0),(100,'超级厉害的',10,'Pink','sony','s','assets/img/20220505115630.jpg',100,99,'hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh',66),(101,'超级厉害的',123,'Pink','sony','m','assets/img/20220505115647.jpg',999,999,'rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr',NULL),(1521508799975452674,'amstlan lan',123,'Pink','123','1','assets/img/product/9aca70ed-7d1f-405d-9d40-1b0814b9531c.jpg',123,123,'123',NULL),(1521509309323370498,'勇者',123,'Black','123','m','assets/img/product/4c9c9a64-a975-402b-bd5b-a2e1cfe12b1a.jpg',112,123,'dd',NULL),(1521509813193515009,'勇者 02',13,'Pink','123','s','assets/img/product/cc0e8df4-76ed-44fb-ae4c-b2f8b786f16c.jpg',123,132,'123',NULL),(1521510109156134914,'amstlan lanaaaaa',123,'White','123','1','assets/img/product/27c711fb-a27d-4ee0-aa0a-c49f9e7dcc38.jpg',123,123,'123',NULL),(1521644176697421826,'aa',123,'Pink','PHILIPS','l','assets/img/product/d1995636-baf3-44cd-b0ba-cd18989f8acf.jpg',123,123,'aa',NULL),(1521646113166860290,'jojo',123,'White','XIAOMI','m','assets/img/product/f2e53032-6c62-4f8b-8303-a619ccf62715.jpg',112,12,'1231',NULL),(1521646708854497281,'jojojjjjjjjj',123,'Yellow','PHILIPS','m','assets/img/product/eaa53426-b771-492d-9ec4-c5241ab3f415.jpg',13,123,'dd',NULL),(1521647134689656834,'rrririri',123,'Pink','sony','s','assets/img/product/e0afed00-cf8c-462b-ae5b-e655fa129cd4.jpg',112,123,'dd',NULL),(1522221975664091137,'欸嘿',6,'Pink','SONY','s','assets/img/product/7bb20437-2ced-41f2-a2c9-cca359b4ee14.jpg',666,66,'666666',NULL),(1522225172562595842,'jojo',13,'Pink','SONY','s','assets/img/product/9dde6e08-d32c-41c9-82a4-bc18f7d0e404.jpg',112,132,'dd',NULL);

/*Table structure for table `shop` */

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
  `sid` bigint(20) NOT NULL,
  `uid` bigint(20) DEFAULT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `aid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `shop` */

insert  into `shop`(`sid`,`uid`,`pid`,`count`,`aid`) values (1522230032263565313,1520962878970519554,0,1,1521358563853770754),(1522230033198895105,1520962878970519554,1521644176697421826,1,1521358563853770754),(1522230033467330562,1520962878970519554,1522225172562595842,1,1521358563853770754),(1522491948605173761,1522229114554044418,5,1,1522491768484982785);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` bigint(11) unsigned NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `power` int(11) DEFAULT '0',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`uid`,`first_name`,`last_name`,`email`,`password`,`birth_date`,`sex`,`power`) values (1520957277892689922,'zhangsan',NULL,NULL,NULL,NULL,NULL,0),(1520959877014847489,'zhangsan',NULL,NULL,NULL,NULL,NULL,0),(1520960814089457666,'ppp',NULL,NULL,NULL,NULL,NULL,0),(1520962878970519554,'amstlan','lan666666','925227315@qq.com','123','2028-07-07',1,1),(1522223719496372226,'者','勇','wy17396553691@163.com','123','2022-05-19',1,0),(1522229114554044418,'jojo','勇','123@qq.com','123','2022-05-05',0,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
