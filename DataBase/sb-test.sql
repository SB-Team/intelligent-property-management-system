-- phpMyAdmin SQL Dump
-- version 4.2.5
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Dec 17, 2014 at 09:18 AM
-- Server version: 5.5.38
-- PHP Version: 5.5.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `ownerId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `ownerName` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ownerSex` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ownerAge` int(5) DEFAULT NULL,
  `ownerPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ownerEmail` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`ownerId`, `userId`, `ownerName`, `ownerSex`, `ownerAge`, `ownerPhone`, `ownerEmail`) VALUES
(1, 1, '张娜拉', '女', 19, '18106989162', '39142555@qq.com'),
(2, 2, '陈烨彬', '男', 21, '18805432234', 'yb@qq.com');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` int(11) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(12) NOT NULL,
  `roleId` smallint(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `age` int(5) NOT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `username`, `password`, `roleId`, `name`, `sex`, `age`, `phone`, `email`) VALUES
(1, 'Yao', '123', 1, '张伟颖', 'GAY', 20, '18106989160', 'wyzhang@qq.com'),
(2, 'chen', 'chen17', 1, '陈烨彬', '男', 21, '13398910333', 'yb@qq.com'),
(3, 'yebin', 'chen', 1, 'MAC CHEN', '男', 22, '15880868890', 'xianyuxmu@gmail.com'),
(4, 'xiyu', 'xiyu1', 1, '陈希瑀', '女', 22, '15759263463', 'xychen@qq.com'),
(5, 'yufan', 'yufan', 1, '胡于凡', '女', 21, '18650033909', 'yfhu@qq.com'),
(6, '11', '22', 1, 'zhang', '1', 18, '110', '33@qq.com'),
(7, 'xiyu', 'xiyu', 1, '陈希瑀', '女', 22, '15759263463', 'xychen@qq.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
 ADD PRIMARY KEY (`ownerId`), ADD KEY `userId` (`userId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`userId`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `owner`
--
ALTER TABLE `owner`
ADD CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;
