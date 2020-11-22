/*
Navicat MySQL Data Transfer

Source Server         : mycloud
Source Server Version : 50648
Source Host           : 175.24.84.47:3306
Source Database       : pigeonnest

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-11-21 22:52:24
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
-- Table structure for picrecord
-- ----------------------------
DROP TABLE IF EXISTS `picrecord`;
CREATE TABLE `picrecord` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `imgpath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of picrecord
-- ----------------------------
INSERT INTO `picrecord` VALUES ('1', '温小伟', '02867cfc45ac4e45a41ae71748e2e6c5.png');
INSERT INTO `picrecord` VALUES ('2', '', '11139324f08a404dba99bb200877016a.jpg');
INSERT INTO `picrecord` VALUES ('3', '', 'f89ca14d8d8c4008b77c059c93f66cf7.jpg');
INSERT INTO `picrecord` VALUES ('4', '', '86537b78fe7d451ca1ce20be970eb6b7.jpg');
INSERT INTO `picrecord` VALUES ('5', '余帅文', '3792f56d2ff3421eacb276d85afe2b8d.jpg');

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
  `activityId` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of signrecord
-- ----------------------------
INSERT INTO `signrecord` VALUES ('001', '22.00', 'dsfa', 'sadfsad', 'sadf', '2020-11-20 15:21:16', 'sdaf', '23', '324', null);
INSERT INTO `signrecord` VALUES ('001', '123.00', 'fd', 'asdf', 'asdf', '2020-11-21 03:48:03', 'asdf', '123', '123', null);
INSERT INTO `signrecord` VALUES ('001', '213.00', 'fdsh', 'dfg', 'fgdf', '2020-11-21 14:51:40', 'agsfd', '123', '123', '1');

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
  `status` varchar(10) DEFAULT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `icon` varchar(255) DEFAULT NULL,
  `telNumber` varchar(13) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('001', '余帅文', '董事会', '123456', '女', '已激活', '2020-11-21 19:34:04', '77f2ae80afff4b73b6fec4204b081af4.jpg', '123423515', '1499356850@qq.com');
INSERT INTO `staff` VALUES ('002', '温小伟', '董事会', '222222', '男', '已激活', '2020-11-18 12:40:36', '/default', null, null);
INSERT INTO `staff` VALUES ('003', '孙云龙', '董事会', '123456', '男', '已激活', '2020-11-20 02:55:24', '/default', null, null);
INSERT INTO `staff` VALUES ('1111', 'jecosine', 'yusw', '123456', '男', '已激活', '2020-11-21 00:51:39', '/default', null, null);
INSERT INTO `staff` VALUES ('123132', '244324', '431342424', '123456', '女', '已激活', '2020-11-20 16:20:56', '/default', null, null);
INSERT INTO `staff` VALUES ('004', 'dsfa', 'gsgsg', '56343', '男', '已激活', '2020-11-21 13:27:01', '/default', null, null);

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
INSERT INTO `vacation` VALUES ('9', null, '001', null, null, null, '待审核', '2020-11-21 13:24:23');
INSERT INTO `vacation` VALUES ('10', '地方', '001', '长度', '2020-11-21 21:24:00', '2020-11-22 21:24:00', '待审核', '2020-11-21 13:24:45');
INSERT INTO `vacation` VALUES ('11', '多吃蔬菜', '001', '第三次', '2020-11-21 21:25:00', '2020-11-22 21:25:00', '待审核', '2020-11-21 13:25:06');
