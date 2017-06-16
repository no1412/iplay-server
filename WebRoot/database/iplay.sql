/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 60011
Source Host           : 127.0.0.1:3306
Source Database       : iplay

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2017-06-14 19:08:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `surface` varchar(255) DEFAULT NULL,
  `content_detail` text,
  `publish_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `city_code` varchar(255) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `content_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `content_ibfk_2` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES ('1', '这是一道比较好吃的美食', 'http://192.168.191.1:8080/iplay/static/img/food/avatar.png', '嫩嗯嗯嗯我也这样觉得', '2017-05-11 10:34:00', '1', '0371', '1');
INSERT INTO `content` VALUES ('2', '河南烩面感觉也很好吃', 'http://192.168.191.1:8080/iplay/static/img/food/pizza.jpg', '嫩嗯嗯嗯我也这样觉得', '2017-05-05 00:35:39', '1', '0371', '1');
INSERT INTO `content` VALUES ('3', '郑州特色蛋挞', 'http://192.168.191.1:8080/iplay/static/img/food/danta.jpg', '郑州特色蛋挞', '2017-05-05 17:06:39', '1', '0371', '1');
INSERT INTO `content` VALUES ('4', '特色马卡龙', 'http://192.168.191.1:8080/iplay/static/img/food/makalong.jpg', '特色马卡龙', '2017-05-05 17:07:09', '1', '0371', '1');
INSERT INTO `content` VALUES ('5', '必吃的美食-胡辣汤', 'http://192.168.191.1:8080/iplay/static/img/food/hulatang.jpg', '必吃的美食-胡辣汤', '2017-05-05 17:07:55', '1', '0371', '1');
INSERT INTO `content` VALUES ('6', '好吃的饺子', 'http://192.168.191.1:8080/iplay/static/img/food/jiaozi.jpg', '好吃的饺子', '2017-05-05 17:08:27', '1', '0371', '1');
INSERT INTO `content` VALUES ('7', '特色烩面', 'http://192.168.191.1:8080/iplay/static/img/food/huimian.jpg', '特色烩面', '2017-05-05 17:11:48', '1', '0371', '1');
INSERT INTO `content` VALUES ('8', '转角遇到猫猫主题咖啡馆', 'http://192.168.191.1:8080/iplay/static/img/entertainment/20170505_cat.jpg', '嫩嫩按时都能看', '2017-05-03 10:35:04', '1', '0371', '1');
INSERT INTO `content` VALUES ('9', '郑州市人民公园', 'http://192.168.191.1:8080/iplay/static/img/entertainment/20170505_park.jpg', '郑州市人民公园', '2017-05-05 16:59:56', '1', '0371', '2');
INSERT INTO `content` VALUES ('10', '郑州图书馆', 'http://192.168.191.1:8080/iplay/static/img/entertainment/zz_library.jpg', '郑州图书馆', '2017-05-05 17:01:52', '1', '0371', '2');
INSERT INTO `content` VALUES ('11', '郑州紫荆山公园', 'http://192.168.191.1:8080/iplay/static/img/entertainment/zijinshan_park.jpg', '郑州紫荆山公园', '2017-05-05 17:16:51', '1', '0371', '2');
INSERT INTO `content` VALUES ('12', '世纪欢乐园额', 'http://192.168.191.1:8080/iplay/static/img/entertainment/shiji_park.jpg', '世纪欢乐园额', '2017-05-05 17:28:26', '1', '0371', '2');
INSERT INTO `content` VALUES ('13', '方特游乐园', 'http://192.168.191.1:8080/iplay/static/img/entertainment/zz_fangte.jpg', '方特游乐园', '2017-05-05 17:30:08', '1', '0371', '2');
INSERT INTO `content` VALUES ('14', '测试', 'http://192.168.191.1:8080/iplay/upload/food_entertainment/20170609081930_154482752.png', '跨境号地块华盛顿<br><br><br><img src=\"http://192.168.191.1:8080/iplay/upload/food_entertainment/20170609081958_154482682.png\" alt=\"\">', '2017-06-09 08:20:03', '30', '0371', '1');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '美食');
INSERT INTO `type` VALUES ('2', '娱乐');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `head_pic_url` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '123456', '11208809@qq.com', 'http://192.168.191.1:8080/iplay/static/img/user/head_default.png', '张三哈哈哈', '1234567777');
INSERT INTO `user` VALUES ('2', '123456', '11208804@qq.com', 'http://192.168.191.1:8080/iplay/upload/user/20170609034511_159014889.png', 'china baby 啦啦啦', '17602108453');
INSERT INTO `user` VALUES ('13', 'aaaaaa', '', 'http://192.168.191.1:8080/iplay/static/img/user/head_default.png', '啦啦啦', '13253657836');
INSERT INTO `user` VALUES ('20', 'aaaaaa', '', 'http://192.168.191.1:8080/iplay/static/img/user/head_default.png', '哈哈哈', '13253657833');
INSERT INTO `user` VALUES ('21', 'zzzzzz', '', 'http://192.168.191.1:8080/iplay/static/img/user/head_default.png', '嘿嘿', '13253657444');
INSERT INTO `user` VALUES ('23', '123456', '', 'http://192.168.191.1:8080/iplay/static/img/user/head_default.png', '嵌入式', '13653829850');
INSERT INTO `user` VALUES ('24', '123456', '', 'http://192.168.191.1:8080/iplay/static/img/user/head_default.png', '嵌入式', '13014551139');
INSERT INTO `user` VALUES ('28', '123456', '', 'http://192.168.191.1:8080/iplay/static/img/user/head_default.png', '霸道总裁', '13253657837');
INSERT INTO `user` VALUES ('29', '123456', '', 'http://192.168.191.1:8080/iplay/static/img/user/head_default.png', '哈哈哈', '13253657838');
INSERT INTO `user` VALUES ('30', '123456', '', 'http://192.168.191.1:8080/iplay/static/img/user/head_default.png', '哈克斯', '13014551189');
