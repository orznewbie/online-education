DROP DATABASE IF EXISTS `online_edu`;
CREATE DATABASE `online_edu`;
USE `online_edu`;

-- 登入验证表
DROP TABLE IF EXISTS `verify`;
CREATE TABLE `verify` (
  `id` varchar(30) NOT NULL,
  `pwd` varchar(30) NOT NULL,
  `role` int(10) NOT NULL DEFAULT '1' COMMENT '角色权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `verify` VALUES('admin01', '123456', '0');
INSERT INTO `verify` VALUES('stu01', '123456', '1');
INSERT INTO `verify` VALUES('teacher01', '123456', '2');

-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL DEFAULT '张三',
  `avatar` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `intro` varchar(100) DEFAULT NULL,
  `vip` int(5) NOT NULL DEFAULT '0' COMMENT '是否为vip',
  `balance` float(20) NOT NULL DEFAULT '0.0' COMMENT '账户金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `user`(`id`) VALUES('admin01');
INSERT INTO `user`(`id`) VALUES('stu01');
INSERT INTO `user`(`id`) VALUES('teacher01');

-- 课程表
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `cover` varchar(30) DEFAULT NULL,
  `intro` varchar(100) DEFAULT NULL,
  `price` float(20) NOT NULL DEFAULT '0.0',
  `salecnt` int(20) NOT NULL DEFAULT '0',
  `status` int(10) NOT NULL DEFAULT '0' COMMENT '0表示未发布，1表示已发布',
  `tid` varchar(30) NOT NULL,
  `link` varchar(30) NOT NULL DEFAULT 'http://www.baidu.com',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `course`(`title`, `tid`) VALUES('java基础课程', 'teacher01');

-- 章节表
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `cid` int(30) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 视频表
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(50) NOT NULL,
  `chid` int(20) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 课件表
Drop TABLE IF EXISTS `ppt`;
CREATE TABLE `ppt` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(50) NOT NULL,
  `cid` int(20) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 横幅表
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) NOT NULL,
  `link` varchar(100) NOT NULL DEFAULT 'http://www.baidu.com',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `banner`(`url`) VALUES('https://s2.ax1x.com/2019/04/17/Az0XCj.png');
INSERT INTO `banner`(`url`) VALUES('https://s2.ax1x.com/2019/04/17/Az0j8s.png');
INSERT INTO `banner`(`url`) VALUES('https://s2.ax1x.com/2019/04/17/AzDHhQ.jpg');
INSERT INTO `banner`(`url`) VALUES('https://i.niupic.com/images/2019/04/17/6eX4.jpg');
INSERT INTO `banner`(`url`) VALUES('https://s2.ax1x.com/2019/04/14/AOarGT.jpg');



-- 学生反馈表
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `sid` varchar(30) NOT NULL,
  `info` varchar(100) DEFAULT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
