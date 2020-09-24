DROP DATABASE IF EXISTS `online_edu`;
CREATE DATABASE `online_edu`;
USE `online_edu`;

-- 登入验证表
DROP TABLE IF EXISTS `verify`;
CREATE TABLE `verify` (
  `id` varchar(30) NOT NULL,
  `pwd` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `verify` VALUES('admin01', '123456');
INSERT INTO `verify` VALUES('stu01', '123456');
INSERT INTO `verify` VALUES('teacher01', '123456');

-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(30) NOT NULL,
  `role` int(10) NOT NULL DEFAULT '1' COMMENT '角色权限',
  `name` varchar(30) NOT NULL DEFAULT '张三',
  `avatar` varchar(100) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `intro` varchar(100) DEFAULT NULL,
  `vip` int(5) NOT NULL DEFAULT '0' COMMENT '是否为vip',
  `balance` float(20) NOT NULL DEFAULT '0.0' COMMENT '账户金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `user`(`id`, `role`, `avatar`) VALUES('admin01', 0, "http://localhost:8080/userdata/pic/avatar/03b0d39583f48206768a7534e55bcpng.jpg");
INSERT INTO `user`(`id`, `role`, `avatar`) VALUES('stu01', 1, "http://localhost:8080/userdata/pic/avatar/03b0d39583f48206768a7534e55bcpng.jpg");
INSERT INTO `user`(`id`, `role`, `avatar`) VALUES('teacher01', 2, "http://localhost:8080/userdata/pic/avatar/03b0d39583f48206768a7534e55bcpng.jpg");

-- 课程表
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  `cover` varchar(100) DEFAULT NULL,
  `category` int(20) DEFAULT 0,
  `intro` varchar(200) DEFAULT NULL,
  `price` float(20) NOT NULL DEFAULT '0.0',
  `salecnt` int(20) NOT NULL DEFAULT '0',
  `status` int(10) NOT NULL DEFAULT '0' COMMENT '0表示未发布，1表示已发布',
  `tid` varchar(30) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `course`(`title`, `cover`, `tid`) VALUES('java基础课程', 'https://s2.ax1x.com/2019/04/17/Az0j8s.png', 'teacher01');
INSERT INTO `course`(`title`, `cover`, `tid`) VALUES('java基础课程', 'https://s2.ax1x.com/2019/04/17/Az0j8s.png', 'teacher01');
INSERT INTO `course`(`title`, `cover`, `tid`) VALUES('java基础课程', 'https://s2.ax1x.com/2019/04/17/Az0j8s.png', 'teacher01');
INSERT INTO `course`(`title`, `cover`, `tid`) VALUES('java基础课程', 'https://s2.ax1x.com/2019/04/17/Az0j8s.png', 'teacher01');
INSERT INTO `course`(`title`, `cover`, `tid`) VALUES('java基础课程', 'https://s2.ax1x.com/2019/04/17/Az0j8s.png', 'teacher01');
INSERT INTO `course`(`title`, `cover`, `tid`) VALUES('java基础课程', 'https://s2.ax1x.com/2019/04/17/Az0j8s.png', 'teacher01');
INSERT INTO `course`(`title`, `cover`, `tid`) VALUES('java基础课程', 'https://s2.ax1x.com/2019/04/17/Az0j8s.png', 'teacher01');
INSERT INTO `course`(`title`, `cover`, `tid`) VALUES('java基础课程', 'https://s2.ax1x.com/2019/04/17/Az0j8s.png', 'teacher01');
INSERT INTO `course`(`title`, `cover`, `tid`) VALUES('java基础课程', 'https://s2.ax1x.com/2019/04/17/Az0j8s.png', 'teacher01');


-- 章节表
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `inde` int(20) NOT NULL DEFAULT 0,
  `title` varchar(30) DEFAULT NULL,
  `cid` int(30) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `chapter`(`inde`, `title`, `cid`) VALUES('1', 'java入门基础', '1');
INSERT INTO `chapter`(`inde`, `title`, `cid`) VALUES('3', 'oop初步认识', '1');
INSERT INTO `chapter`(`inde`, `title`, `cid`) VALUES('2', '基本结构和语法', '1');
INSERT INTO `chapter`(`inde`, `title`, `cid`) VALUES('4', '异常、注解与反射', '1');
INSERT INTO `chapter`(`inde`, `title`, `cid`) VALUES('5', '多线程与网络编程初步', '1');

-- 视频表
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `url` varchar(50) NOT NULL,
  `chid` int(20) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO  `video`(`title`, `url`, `chid`) VALUES('int、double和其他数据类型', '//vjs.zencdn.net/v/oceans.mp4', '1');
INSERT INTO  `video`(`title`, `url`, `chid`) VALUES('环境安装与ide', '//vjs.zencdn.net/v/oceans.mp4', '1');
INSERT INTO  `video`(`title`, `url`, `chid`) VALUES('跳转语句和分支语句', '//vjs.zencdn.net/v/oceans.mp4', '3');
INSERT INTO  `video`(`title`, `url`, `chid`) VALUES('int、double和其他数据类型', '//vjs.zencdn.net/v/oceans.mp4', '2');
INSERT INTO  `video`(`title`, `url`, `chid`) VALUES('int、double和其他数据类型', '//vjs.zencdn.net/v/oceans.mp4', '3');
INSERT INTO  `video`(`title`, `url`, `chid`) VALUES('int、double和其他数据类型', '//vjs.zencdn.net/v/oceans.mp4', '4');
INSERT INTO  `video`(`title`, `url`, `chid`) VALUES('int、double和其他数据类型', '//vjs.zencdn.net/v/oceans.mp4', '4');

-- 课件表
Drop TABLE IF EXISTS `ppt`;
CREATE TABLE `ppt` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) DEFAULT NULL, 
  `url` varchar(50) NOT NULL,
  `cid` int(20) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 横幅表
DROP TABLE IF EXISTS `banner`;
CREATE TABLE `banner` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) NOT NULL,
  `cid` Integer(30) NOT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `banner`(`url`, `cid`) VALUES('https://s2.ax1x.com/2019/04/17/Az0XCj.png', '1');
INSERT INTO `banner`(`url`, `cid`) VALUES('https://s2.ax1x.com/2019/04/17/Az0j8s.png',  '3');
INSERT INTO `banner`(`url`, `cid`) VALUES('https://s2.ax1x.com/2019/04/17/AzDHhQ.jpg', '4');
INSERT INTO `banner`(`url`, `cid`) VALUES('https://i.niupic.com/images/2019/04/17/6eX4.jpg', '5');
INSERT INTO `banner`(`url`, `cid`) VALUES('https://s2.ax1x.com/2019/04/14/AOarGT.jpg', '2');



-- 学生反馈表
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `sid` varchar(30) NOT NULL,
  `info` varchar(100) DEFAULT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 学生购买视频表
DROP TABLE IF EXISTS `sbuyc`;
CREATE TABLE `sbuyc` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `sid` varchar(30) NOT NULL,
  `cid` Integer(30) NOT NULL,
  `cost` float(20) NOT NULL DEFAULT '0.0',
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sbuyc`(`sid`, `cid`, `cost`) VALUES('stu01', '1', 100);

-- 课程种类表
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) DEFAULT NULL,
  PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `category`(`title`) VALUES("Java");
INSERT INTO `category`(`title`) VALUES("C++");
INSERT INTO `category`(`title`) VALUES("Python");
INSERT INTO `category`(`title`) VALUES("数据结构和算法");
INSERT INTO `category`(`title`) VALUES("计算机组成原理");
INSERT INTO `category`(`title`) VALUES("操作系统");
INSERT INTO `category`(`title`) VALUES("计算机网络");
INSERT INTO `category`(`title`) VALUES("编译原理");
INSERT INTO `category`(`title`) VALUES("数据库与mysql");
INSERT INTO `category`(`title`) VALUES("大数据开发");
INSERT INTO `category`(`title`) VALUES("人工智能");
INSERT INTO `category`(`title`) VALUES("前端开发");
INSERT INTO `category`(`title`) VALUES("后端与服务器");
