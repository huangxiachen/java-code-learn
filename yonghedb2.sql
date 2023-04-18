/*
Navicat MySQL Data Transfer

Source Server         : mydb
Source Server Version : 80012
Source Host           : localhost:3306

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_door
-- ----------------------------
DROP TABLE IF EXISTS `tb_door`;
CREATE TABLE `tb_door` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `tel` varchar(100) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_door
-- ----------------------------
INSERT INTO `tb_door` VALUES ('1', '永和大王(黄石港店)', '0714-6211231', '黄石市黄石港区沿江路黄石港店');
INSERT INTO `tb_door` VALUES ('2', '永和大王(磁湖路店)', '0714-82356537', '湖北省黄石市下陆区磁湖路');
INSERT INTO `tb_door` VALUES ('3', '永和大王(团城山店)', '0714-84477746', '湖北省黄石市下陆区团城山店');
INSERT INTO `tb_door` VALUES ('4', '永和大王(西塞山店)', '0714-65286602', '湖北省黄石市西塞山区西塞山店');
INSERT INTO `tb_door` VALUES ('5', '永和大王(八栋口店)', '0714-62152539', '湖北省黄石市黄石港区沈家营八栋口店');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `door_id` int(11) DEFAULT NULL,
  `order_no` varchar(50) DEFAULT NULL,
  `order_type` varchar(50) DEFAULT NULL,
  `pnum` int(11) DEFAULT NULL,
  `cashier` varchar(50) DEFAULT NULL,
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pay_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `pay_type` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `door_id` (`door_id`),
  CONSTRAINT `tb_order_ibfk_1` FOREIGN KEY (`door_id`) REFERENCES `tb_door` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order`(id,door_id, order_no, order_type, pnum, cashier, pay_type, price) VALUES ('1', '1', 'P001', '堂食', '1', '张三','微信支付', '16');
INSERT INTO `tb_order`(id,door_id, order_no, order_type, pnum, cashier, pay_type, price) VALUES ('2', '1', 'P003', '外卖', '3', '张三','微信支付', '20');
INSERT INTO `tb_order`(id,door_id, order_no, order_type, pnum, cashier, pay_type, price) VALUES ('3', '1', 'P005', '打包', '1', '张三','微信支付', '28');
INSERT INTO `tb_order`(id,door_id, order_no, order_type, pnum, cashier, pay_type, price) VALUES ('4', '1', 'P007', '堂食', '1', '李四','微信支付', '49');
INSERT INTO `tb_order`(id,door_id, order_no, order_type, pnum, cashier, pay_type, price) VALUES ('6', '1', 'hbnu001', '堂食', '2', '陈迪凯','微信支付', '50');
