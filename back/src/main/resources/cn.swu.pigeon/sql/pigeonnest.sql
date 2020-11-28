/*
Navicat MySQL Data Transfer

Source Server         : mycloud
Source Server Version : 50648
Source Host           : 175.24.84.47:3306
Source Database       : pigeonnest

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-11-23 16:25:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
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
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES ('1', 'dfs', '001', 'a', '2020-10-30 17:05:00', '2020-11-22 17:06:00', '已通过', '2020-11-21 14:38:31');
INSERT INTO `application` VALUES ('2', 'dfs', '001', 'a', '2020-10-30 17:05:00', '2020-11-22 17:06:00', '待审核', '2020-11-21 09:34:57');
INSERT INTO `application` VALUES ('3', '申请奖学金', '001', '李雅丽', '2020-11-13 19:24:00', '2020-11-29 19:22:00', '待审核', '2020-11-21 09:35:00');
INSERT INTO `application` VALUES ('4', 'fds', '余帅文', '234', '2020-11-05 14:49:00', '2020-11-12 14:49:00', '待审核', '2020-11-21 06:49:44');
INSERT INTO `application` VALUES ('5', 'dasf', '001', 'dsf', '2020-10-30 14:52:00', '2020-11-14 14:52:00', '待审核', '2020-11-21 06:52:14');
INSERT INTO `application` VALUES ('6', 'casc', '001', 'wcdc', '2020-11-21 16:58:00', '2020-11-22 16:58:00', '待审核', '2020-11-21 08:58:28');

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
-- Table structure for picrecord
-- ----------------------------
DROP TABLE IF EXISTS `picrecord`;
CREATE TABLE `picrecord` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` varchar(255) DEFAULT NULL,
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
  `companyId` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of signrecord
-- ----------------------------
INSERT INTO `signrecord` VALUES ('001', '22.00', 'dsfa', 'sadfsad', 'sadf', '2020-11-20 15:21:16', 'sdaf', '23', '324', '1', null);
INSERT INTO `signrecord` VALUES ('001', '123.00', 'fd', 'asdf', 'asdf', '2020-11-21 03:48:03', 'asdf', '123', '123', '1', null);
INSERT INTO `signrecord` VALUES ('001', '213.00', 'fdsh', 'dfg', 'fgdf', '2020-11-21 14:51:40', 'agsfd', '123', '123', '1', null);
INSERT INTO `signrecord` VALUES ('001', '213.00', 'dasgsa', 'dgfsda', 'sdaf', '2020-11-23 08:00:36', 'fsdafads', '213', '123', '1', null);

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` varchar(255) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `dept` varchar(60) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `telNumber` varchar(13) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `companyId` varchar(20) DEFAULT NULL,
  `originId` varchar(20) DEFAULT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('001', '余帅文', '董事会', '123456', '女', '13054080629', 'yosheven@outlook.com', '4c1954c8cd7b4cf983d773f475ac4027.jpg', '已激活', null, null, '2020-11-23 15:41:58');
INSERT INTO `staff` VALUES ('002', '温小伟', '董事会', '222222', '男', null, null, '/default', '已激活', null, null, '2020-11-18 12:40:36');
INSERT INTO `staff` VALUES ('003', '孙云龙', '董事会', '123456', '男', null, null, '/default', '已激活', null, null, '2020-11-20 02:55:24');
INSERT INTO `staff` VALUES ('1111', 'jecosine', 'yusw', '123456', '男', null, null, '867ecc603cde457aba0eb8309bc02cd4.png', '已激活', null, null, '2020-11-23 01:26:57');
INSERT INTO `staff` VALUES ('123132', '244324', '431342424', '123456', '女', null, null, '/default', '已激活', null, null, '2020-11-20 16:20:56');
INSERT INTO `staff` VALUES ('004', 'dsfa', 'gsgsg', '56343', '男', null, null, '/default', '已激活', null, null, '2020-11-21 13:27:01');
INSERT INTO `staff` VALUES ('1605989758333', '122', null, '111', null, null, null, '/default', '已激活', null, null, '2020-11-21 20:25:09');
INSERT INTO `staff` VALUES ('1606016550375', 'Scarlet', null, '123456', null, null, null, '/default', '已激活', null, null, '2020-11-22 03:43:28');
INSERT INTO `staff` VALUES ('1606060960448', 'jecosine', null, '1234', null, '4321', null, '867ecc603cde457aba0eb8309bc02cd4.png', '已激活', null, null, '2020-11-23 01:30:49');
INSERT INTO `staff` VALUES (null, 'test1', null, '123', null, null, null, '/default', '已激活', null, null, '2020-11-23 07:09:28');

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of vacation
-- ----------------------------
INSERT INTO `vacation` VALUES ('1', '有事儿', '001', '试试', '2020-11-22 12:01:46', '2020-11-22 12:01:46', '已通过', '2020-11-22 12:01:46');
INSERT INTO `vacation` VALUES ('9', null, '001', null, null, null, '待审核', '2020-11-21 13:24:23');
INSERT INTO `vacation` VALUES ('10', '地方', '001', '长度', '2020-11-21 21:24:00', '2020-11-22 21:24:00', '待审核', '2020-11-21 13:24:45');
INSERT INTO `vacation` VALUES ('11', '多吃蔬菜', '001', '第三次', '2020-11-21 21:25:00', '2020-11-22 21:25:00', '待审核', '2020-11-21 13:25:06');
