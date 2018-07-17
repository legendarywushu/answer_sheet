/*
 Navicat MySQL Data Transfer

 Source Server         : 1
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : data

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 17/07/2018 17:01:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for information
-- ----------------------------
DROP TABLE IF EXISTS `information`;
CREATE TABLE `information`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userid` int(10) NOT NULL,
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of information
-- ----------------------------
INSERT INTO `information` VALUES (1, 1507, 'score', 'time');
INSERT INTO `information` VALUES (2, 1507, 'null', 'null');
INSERT INTO `information` VALUES (3, 1507, '10', '1');
INSERT INTO `information` VALUES (4, 1507, '0', 'Sun Jul 15 2018 15:46:23 GMT+0800 (中国标准时间)');
INSERT INTO `information` VALUES (5, 1507, '0', 'Sun Jul 15 2018 15:47:24 GMT+0800 (中国标准时间)');
INSERT INTO `information` VALUES (6, 1507, '0', 'Sun Jul 15 2018 15:47:24 GMT+0800 (中国标准时间)');
INSERT INTO `information` VALUES (7, 1507, '0', 'Sun Jul 15 2018 15:50:44 GMT+0800 (中国标准时间)');
INSERT INTO `information` VALUES (8, 1507, '0', 'Sun Jul 15 2018 15:50:44 GMT+0800 (中国标准时间)');
INSERT INTO `information` VALUES (9, 1507, '0', 'Sun Jul 15 2018 16:06:44 GMT+0800 (中国标准时间)');
INSERT INTO `information` VALUES (10, 1507, '0', 'Sun Jul 15 2018 16:30:56 GMT+0800 (CST)');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `tid` int(10) NOT NULL,
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `optA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `optB` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `optC` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `optD` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES (1, '1+1=?', '1', '2', '3', '4', 'B');
INSERT INTO `test` VALUES (2, '2+2=?', '1', '2', '3', '4', 'D');
INSERT INTO `test` VALUES (3, '3+3=?', '2', '3', '5', '6', 'D');
INSERT INTO `test` VALUES (4, '2+3=?', '3', '4', '5', '6', 'C');
INSERT INTO `test` VALUES (5, '3+4=?', '6', '7', '8', '9', 'B');
INSERT INTO `test` VALUES (6, '4+4=?', '6', '7', '8', '9', 'C');
INSERT INTO `test` VALUES (7, '5+5=?', '7', '8', '9', '10', 'D');
INSERT INTO `test` VALUES (8, '6+6=?', '10', '11', '12', '13', 'C');
INSERT INTO `test` VALUES (9, '7+7=?', '11', '12', '13', '14', 'D');
INSERT INTO `test` VALUES (10, '8+8=?', '14', '15', '16', '17', 'C');

SET FOREIGN_KEY_CHECKS = 1;
