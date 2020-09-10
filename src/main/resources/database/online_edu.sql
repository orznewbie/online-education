DROP SCHEMA IF EXISTS `online_edu`;
CREATE SCHEMA `online_edu`;
USE `online_edu`;

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` varchar(20) NOT NULL,
  `pwd` varchar(30) NOT NULL,
  `role` varchar(15) NOT NULL DEFAULT 'stu',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `account` VALUES("admin01", "123456", "admin");
INSERT INTO `account` VALUES("stu01", "233333", "stu");
INSERT INTO `account` VALUES("teacher01", "666666", "teacher");

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `name` varchar(15) NOT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` VALUES('admin01', '管理员', '12345678910', '123@gmail.com');
INSERT INTO `user` VALUES('stu01', '张三', '23333333333', 'sb233@qq.com');
INSERT INTO `user` VALUES('teacher01', '罗翔', '66666666666', '999@bili.com');