/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2013-11-23 21:09:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `info`
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `birthday` varchar(50) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `userId` int(50) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `userId` (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES ('1', 'hanmin', '19920520', 'nv', '853049349@qq.com', '18764881192', '20');
INSERT INTO `info` VALUES ('3', 'fdg', '353465', 'dg', '354656dfg', '4645654', '20');
INSERT INTO `info` VALUES ('4', '韩敏', 'asd', 'asd', 'asd@qq.com', '12334454544', '20');
INSERT INTO `info` VALUES ('23', 'd', 'd', 'd', 'd', 'd', '20');

-- ----------------------------
-- Table structure for `info_delete`
-- ----------------------------
DROP TABLE IF EXISTS `info_delete`;
CREATE TABLE `info_delete` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `birthday` varchar(50) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of info_delete
-- ----------------------------
INSERT INTO `info_delete` VALUES ('7', 'd', 'd', 'd', 'd', 'd', '20');
INSERT INTO `info_delete` VALUES ('8', 's', 's', 'df', 's', 's', '20');

-- ----------------------------
-- Table structure for `useuser`
-- ----------------------------
DROP TABLE IF EXISTS `useuser`;
CREATE TABLE `useuser` (
  `UserId` int(50) NOT NULL auto_increment,
  `UserName` varchar(50) NOT NULL,
  `UserSex` varchar(50) NOT NULL,
  `UserPwd` varchar(50) NOT NULL,
  `UserEmail` varchar(50) NOT NULL,
  PRIMARY KEY  (`UserId`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of useuser
-- ----------------------------
INSERT INTO `useuser` VALUES ('20', 'abc', 'abc', 'abc', '85545@qq.com');
INSERT INTO `useuser` VALUES ('21', 'asd', 'asd', 'asd', '3436546@qq.com');
