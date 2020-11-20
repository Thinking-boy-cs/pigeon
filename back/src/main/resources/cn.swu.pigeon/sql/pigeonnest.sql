/*
Navicat MySQL Data Transfer

Source Server         : mycloud
Source Server Version : 50648
Source Host           : 175.24.84.47:3306
Source Database       : pigeonnest

Target Server Type    : MYSQL
Target Server Version : 50648
File Encoding         : 65001

Date: 2020-11-20 16:16:42
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', 'dfs', '余帅文', 'a', '2020-10-30 17:05:00', '2020-11-22 17:06:00', '待审核', '2020-11-19 09:07:34');
INSERT INTO `activity` VALUES ('2', 'dfs', '余帅文', 'a', '2020-10-30 17:05:00', '2020-11-22 17:06:00', '待审核', '2020-11-19 09:07:43');

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
  `signTime` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of signrecord
-- ----------------------------
INSERT INTO `signrecord` VALUES ('001', '123.00', 'adsf', 'adfs', 'afds', '2020-11-20 07:05:25');
INSERT INTO `signrecord` VALUES ('001', '123.00', 'fsd', 'fgsdh', 'asdga', '2020-11-20 07:57:32');
INSERT INTO `signrecord` VALUES ('001', '564.00', 'fsd', 'fgsdh', 'asdga', '2020-11-20 07:57:36');
INSERT INTO `signrecord` VALUES ('001', '123.00', 'fsd', 'fgsdh', 'asdga', '2020-11-20 07:58:01');
INSERT INTO `signrecord` VALUES ('001', '7777.00', 'fsd', 'fgsdh', 'asdga', '2020-11-20 07:58:04');

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` varchar(10) DEFAULT NULL,
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
INSERT INTO `staff` VALUES ('001', '余帅文', '董事会', '123456', '男', '已激活', '2020-11-20 09:58:36', '撒地方', null, null);
INSERT INTO `staff` VALUES ('002', '温小伟', '董事会', '222222', '男', '已激活', '2020-11-18 12:40:36', '/default', null, null);
INSERT INTO `staff` VALUES ('003', '孙云龙', '董事会', '123456', '男', '已激活', '2020-11-20 02:55:24', '/default', null, null);
