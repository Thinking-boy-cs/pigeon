/*
Navicat MySQL Data Transfer

Source Server         : mycloud
Source Server Version : 50731
Source Host           : 175.24.84.47:34248
Source Database       : pigeonnest

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-12-14 23:57:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `activityName` varchar(255) DEFAULT NULL,
  `applicant` varchar(10) DEFAULT NULL,
  `approver` varchar(10) DEFAULT NULL,
  `startTime` timestamp NULL DEFAULT NULL,
  `endTime` timestamp NULL DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `submitTime` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', 'dfs', '001', 'a', '2020-10-30 17:05:00', '2020-11-22 17:06:00', '已通过', '2020-11-21 14:38:31');
INSERT INTO `activity` VALUES ('2', 'dfs', '001', 'a', '2020-10-30 17:05:00', '2020-11-22 17:06:00', '待审核', '2020-11-21 09:34:57');
INSERT INTO `activity` VALUES ('3', '申请奖学金', '001', '李雅丽', '2020-11-13 19:24:00', '2020-11-29 19:22:00', '待审核', '2020-11-21 09:35:00');
INSERT INTO `activity` VALUES ('4', 'fds', '余帅文', '234', '2020-11-05 14:49:00', '2020-11-12 14:49:00', '待审核', '2020-11-21 06:49:44');
INSERT INTO `activity` VALUES ('5', 'dasf', '001', 'dsf', '2020-10-30 14:52:00', '2020-11-14 14:52:00', '待审核', '2020-11-21 06:52:14');
INSERT INTO `activity` VALUES ('6', 'casc', '001', 'wcdc', '2020-11-21 16:58:00', '2020-11-22 16:58:00', '待审核', '2020-11-21 08:58:28');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(10) DEFAULT NULL,
  `admin` varchar(20) DEFAULT NULL,
  `dept` varchar(60) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `registerTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `icon` varchar(255) DEFAULT NULL,
  `telNumber` varchar(13) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('001', '余帅文', '董事会', '123456', '男', '已激活', '2020-11-11 11:37:13', '/default', '15340416216', '1499356850@qq.com');

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `id` int(20) DEFAULT NULL,
  `activityName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `applicant` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `participants` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `approver` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `status` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `submitTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of application
-- ----------------------------

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `id` char(15) NOT NULL,
  `name` varchar(60) NOT NULL,
  `userId` char(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `company_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('123456789012345', 'pigeon', '1606060960');

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` char(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `parentId` char(15) DEFAULT NULL,
  `companyId` char(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `group_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of group
-- ----------------------------
INSERT INTO `group` VALUES ('439f285ca099498', '总经理', '8a5f12a5502d4b8', '123456789012345');
INSERT INTO `group` VALUES ('68b429692b794c2', '后台', '925014575aa049b', '123456789012345');
INSERT INTO `group` VALUES ('8a5f12a5502d4b8', '董事会', null, '123456789012345');
INSERT INTO `group` VALUES ('925014575aa049b', '前端', 'f02f39e0ae024ae', '123456789012345');
INSERT INTO `group` VALUES ('9b1275c6e045443', '人事部', '439f285ca099498', '123456789012345');
INSERT INTO `group` VALUES ('f02f39e0ae024ae', '技术部', '439f285ca099498', '123456789012345');

-- ----------------------------
-- Table structure for infocollect
-- ----------------------------
DROP TABLE IF EXISTS `infocollect`;
CREATE TABLE `infocollect` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `colName` varchar(255) DEFAULT NULL,
  `initiator` varchar(255) DEFAULT NULL,
  `taker` varchar(255) DEFAULT NULL,
  `startTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `endTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `info1` varchar(255) DEFAULT NULL,
  `info2` varchar(255) DEFAULT NULL,
  `info3` varchar(255) DEFAULT NULL,
  `info4` varchar(255) DEFAULT NULL,
  `info5` varchar(255) DEFAULT NULL,
  `info6` varchar(255) DEFAULT NULL,
  `info7` varchar(255) DEFAULT NULL,
  `info8` varchar(255) DEFAULT NULL,
  `info9` varchar(255) DEFAULT NULL,
  `info10` varchar(255) DEFAULT NULL,
  `info11` varchar(255) DEFAULT NULL,
  `info12` varchar(255) DEFAULT NULL,
  `info13` varchar(255) DEFAULT NULL,
  `info14` varchar(255) DEFAULT NULL,
  `info15` varchar(255) DEFAULT NULL,
  `info16` varchar(255) DEFAULT NULL,
  `info17` varchar(255) DEFAULT NULL,
  `info18` varchar(255) DEFAULT NULL,
  `info19` varchar(255) DEFAULT NULL,
  `info20` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of infocollect
-- ----------------------------
INSERT INTO `infocollect` VALUES ('1', null, null, null, null, null, '中国', '湖南', '平江', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `infocollect` VALUES ('2', null, null, null, null, null, '中国', '湖南', '平江', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `initiator` char(15) NOT NULL,
  `id` char(15) NOT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `notification_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of notification
-- ----------------------------

-- ----------------------------
-- Table structure for picrecord
-- ----------------------------
DROP TABLE IF EXISTS `picrecord`;
CREATE TABLE `picrecord` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` varchar(20) DEFAULT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  `companyId` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of picrecord
-- ----------------------------
INSERT INTO `picrecord` VALUES ('1', '温小伟', '02867cfc45ac4e45a41ae71748e2e6c5.png', null);
INSERT INTO `picrecord` VALUES ('2', '', '11139324f08a404dba99bb200877016a.jpg', null);
INSERT INTO `picrecord` VALUES ('3', '', 'f89ca14d8d8c4008b77c059c93f66cf7.jpg', null);
INSERT INTO `picrecord` VALUES ('4', '', '86537b78fe7d451ca1ce20be970eb6b7.jpg', null);
INSERT INTO `picrecord` VALUES ('5', '余帅文', '3792f56d2ff3421eacb276d85afe2b8d.jpg', null);
INSERT INTO `picrecord` VALUES ('6', '余帅文', 'd1dfa780ca38445784c24b76c7d16f33.jpg', null);
INSERT INTO `picrecord` VALUES ('7', '余帅文', '3989f6f1bfb4407ba76af7b14e7153b7.jpg', null);
INSERT INTO `picrecord` VALUES ('8', '余帅文', '557c1bb9037c433da0c84c2662114fab.jpg', null);
INSERT INTO `picrecord` VALUES ('9', '余帅文', 'c5948046f9dc4857ac10d08d6b42add8.jpg', null);
INSERT INTO `picrecord` VALUES ('10', '余帅文', 'b89792b625ce437c86374c8f81473e1a.png', null);
INSERT INTO `picrecord` VALUES ('11', '余帅文', '84e18a39f0ac422a857561c014bdc8b2.jpg', null);
INSERT INTO `picrecord` VALUES ('12', '余帅文', '2de409c8a80c4c8da795fa8314123620.jpg', null);
INSERT INTO `picrecord` VALUES ('13', 'jecosine', '867ecc603cde457aba0eb8309bc02cd4.png', null);
INSERT INTO `picrecord` VALUES ('14', '余帅文', 'c5513d9e13b14870b4c07780350ac068.jpg', null);
INSERT INTO `picrecord` VALUES ('15', '001', '13b1d9c31b424c80867a43a62a7b99fe.jpg', null);

-- ----------------------------
-- Table structure for signrecord
-- ----------------------------
DROP TABLE IF EXISTS `signrecord`;
CREATE TABLE `signrecord` (
  `id` varchar(10) DEFAULT NULL,
  `temperature` float(8,2) DEFAULT NULL,
  `nation` varchar(50) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `signTime` timestamp NULL DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `longitude` float(6,0) DEFAULT NULL,
  `latitude` float(6,0) DEFAULT NULL,
  `activityId` int(10) DEFAULT NULL,
  `companyId` varchar(20) DEFAULT NULL,
  `status` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of signrecord
-- ----------------------------
INSERT INTO `signrecord` VALUES ('001', '22.00', 'dsfa', 'sadfsad', 'sadf', '2020-11-20 15:21:16', 'sdaf', '23', '324', '1', null, null);
INSERT INTO `signrecord` VALUES ('001', '123.00', 'fd', 'asdf', 'asdf', '2020-11-21 03:48:03', 'asdf', '123', '123', '1', null, null);
INSERT INTO `signrecord` VALUES ('001', '213.00', 'fdsh', 'dfg', 'fgdf', '2020-11-21 14:51:40', 'agsfd', '123', '123', '1', null, null);
INSERT INTO `signrecord` VALUES ('001', '213.00', 'dasgsa', 'dgfsda', 'sdaf', '2020-11-23 08:00:36', 'fsdafads', '213', '123', '1', null, null);
INSERT INTO `signrecord` VALUES ('1606060960', '12.00', 'weq', 'dafd', 'dasd', '2020-12-14 23:24:11', 'sda', '32', '34', '22', null, null);
INSERT INTO `signrecord` VALUES ('1606060961', '32.00', 'dsds', 'fds', 'fsde', '2020-12-14 23:44:33', 'dfa', '54', '345', '232', null, null);

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` char(15) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `dept` varchar(60) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `hometown` varchar(255) DEFAULT NULL,
  `telNumber` varchar(13) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `companyId` varchar(20) DEFAULT NULL,
  `originId` varchar(20) DEFAULT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `signature` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('1605989758', '122', null, '111', null, null, null, null, '/default', '已激活', null, null, '2020-11-21 20:25:09', null);
INSERT INTO `staff` VALUES ('1606016550', 'Scarlet', null, '1234', '男', null, '1234', 'dfjlijdsl', '1a265c136194467d8614eba879e9dcb5.jpg', '已激活', '123456789012345', null, '2020-11-24 16:20:21', 'mmfsdfsfsd');
INSERT INTO `staff` VALUES ('1606060960', 'jecosine', null, '1234', '女', null, '4321', null, '867ecc603cde457aba0eb8309bc02cd4.png', '已激活', '123456789012345', null, '2020-12-14 23:07:56', '12312');
INSERT INTO `staff` VALUES ('1606060961', 'ysw', null, '1234', '男', null, '1235', null, '4c1954c8cd7b4cf983d773f475ac4027.jpg', '已激活', '123456789012345', null, '2020-12-14 23:07:59', null);
INSERT INTO `staff` VALUES ('1606060962', 'griow', null, '1234', '男', null, '1236', null, '4c1954c8cd7b4cf983d773f475ac4027.jpg', '已激活', '123456789012345', null, '2020-12-14 23:08:02', null);
INSERT INTO `staff` VALUES (null, 'test', null, '123456', null, null, null, null, '/default', '已激活', null, null, '2020-12-14 05:41:42', null);

-- ----------------------------
-- Table structure for user_activity
-- ----------------------------
DROP TABLE IF EXISTS `user_activity`;
CREATE TABLE `user_activity` (
  `userId` char(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activityId` char(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_activity
-- ----------------------------

-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` char(15) NOT NULL,
  `groupId` char(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES ('1', '1606060960', '925014575aa049b');
INSERT INTO `user_group` VALUES ('2', '1606016550', '925014575aa049b');
INSERT INTO `user_group` VALUES ('3', '1606060961', '68b429692b794c2');
INSERT INTO `user_group` VALUES ('4', '1606060962', '68b429692b794c2');
INSERT INTO `user_group` VALUES ('5', '1606060970', '68b429692b794c2');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` char(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sex` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registerTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telNumber` int(13) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of userinfo
-- ----------------------------

-- ----------------------------
-- Table structure for vacation
-- ----------------------------
DROP TABLE IF EXISTS `vacation`;
CREATE TABLE `vacation` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `Reason` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `userId` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `approveUser` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `startTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `endTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `state` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `submitTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of vacation
-- ----------------------------
INSERT INTO `vacation` VALUES ('1', '有事儿', '1606060961', '试试', '2020-12-14 19:20:55', '2020-12-14 19:20:55', '已通过', '2020-12-14 19:20:55');
INSERT INTO `vacation` VALUES ('9', null, '1606060961', null, '2020-12-14 19:20:59', '2020-12-14 19:20:59', '待审核', '2020-12-14 19:20:59');
INSERT INTO `vacation` VALUES ('10', '地方', '1606060961', '长度', '2020-12-14 19:21:02', '2020-12-14 19:21:02', '待审核', '2020-12-14 19:21:02');
INSERT INTO `vacation` VALUES ('11', '多吃蔬菜', '001', '第三次', '2020-11-21 21:25:00', '2020-11-22 21:25:00', '待审核', '2020-11-21 13:25:06');
