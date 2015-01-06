-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 2015-01-03 15:22:02
-- 服务器版本： 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- 表的结构 `building_table`
--

CREATE TABLE IF NOT EXISTS `building_table` (
`t_id` int(10) unsigned NOT NULL,
  `num` int(10) NOT NULL COMMENT '栋数',
  `community_id` int(10) unsigned zerofill NOT NULL COMMENT '外键'
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `building_table`
--

INSERT INTO `building_table` (`t_id`, `num`, `community_id`) VALUES
(1, 2, 0000000001),
(2, 3, 0000000001),
(3, 4, 0000000001),
(4, 5, 0000000001),
(5, 6, 0000000001),
(6, 7, 0000000001),
(7, 1, 0000000002),
(8, 8, 0000000001),
(11, 9, 0000000001),
(12, 1, 0000000004);

-- --------------------------------------------------------

--
-- 表的结构 `community_table`
--

CREATE TABLE IF NOT EXISTS `community_table` (
`c_id` int(10) unsigned NOT NULL,
  `c_name` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '小区名字',
  `c_area` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '小区所在地区'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `community_table`
--

INSERT INTO `community_table` (`c_id`, `c_name`, `c_area`) VALUES
(1, '五缘公寓', '厦门'),
(2, '海韵学生公寓', '厦门'),
(3, '3', '3'),
(4, '海韵一期学生公寓', '厦门');

-- --------------------------------------------------------

--
-- 表的结构 `elec_debt_table`
--

CREATE TABLE IF NOT EXISTS `elec_debt_table` (
`t_id` int(10) unsigned NOT NULL,
  `room_id` int(30) unsigned zerofill NOT NULL,
  `debt` double(10,1) unsigned zerofill NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `elec_degree_table`
--

CREATE TABLE IF NOT EXISTS `elec_degree_table` (
`t_id` int(30) unsigned NOT NULL,
  `building_num` int(10) unsigned zerofill NOT NULL,
  `floor_num` int(10) unsigned zerofill NOT NULL,
  `room_num` int(10) unsigned zerofill NOT NULL,
  `community_id` int(10) unsigned zerofill NOT NULL,
  `last_entering_time` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `this_entering_time` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `last_entering_degree` int(30) unsigned zerofill DEFAULT NULL,
  `this_entering_degree` int(30) unsigned zerofill DEFAULT NULL,
  `degree` int(30) unsigned zerofill DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `elec_payment_table`
--

CREATE TABLE IF NOT EXISTS `elec_payment_table` (
  `t_id` int(30) NOT NULL,
  `community_payment` double(10,1) unsigned zerofill DEFAULT NULL,
  `building_payment` double(10,1) unsigned zerofill DEFAULT NULL,
  `floor_payment` double(10,1) unsigned zerofill DEFAULT NULL,
  `room_id` int(30) unsigned zerofill DEFAULT NULL,
  `room_payment` double(10,1) unsigned zerofill DEFAULT NULL,
  `is_pay` int(10) unsigned zerofill DEFAULT NULL,
  `r_id` int(30) unsigned zerofill DEFAULT NULL,
  `total` double(10,1) unsigned zerofill DEFAULT NULL,
  `day` varchar(30) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `fee_manager_table`
--

CREATE TABLE IF NOT EXISTS `fee_manager_table` (
`t_id` int(10) unsigned NOT NULL COMMENT '表格自增长id',
  `fee_user_id` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户ID',
  `fee_time` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '登记时间',
  `fee_key` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '记录key',
  `fee_value` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '记录value',
  `fee_he_name` varchar(30) DEFAULT NULL COMMENT '标示区分不同小区'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `fee_manager_table`
--

INSERT INTO `fee_manager_table` (`t_id`, `fee_user_id`, `fee_time`, `fee_key`, `fee_value`, `fee_he_name`) VALUES
(1, 'haiyu_13_309', '2014-12-18', '电费', '1000.00', 'haiyun');

-- --------------------------------------------------------

--
-- 表的结构 `fee_table`
--

CREATE TABLE IF NOT EXISTS `fee_table` (
`t_id` int(11) unsigned NOT NULL COMMENT '表格自增长ID',
  `fee_bill_id` varchar(40) CHARACTER SET utf8 NOT NULL COMMENT '账单标识：费用类别＋账单生成时间＋userID',
  `fee_user_id` varchar(40) CHARACTER SET utf8 NOT NULL COMMENT '用户的ID',
  `fee_create_time` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '账单生成时间',
  `fee_end_time` varchar(20) CHARACTER SET utf8 NOT NULL COMMENT '结账期限',
  `fee_kind` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '账单类别',
  `fee_total` varchar(80) CHARACTER SET utf8 NOT NULL COMMENT '总金额',
  `fee_late_payment` varchar(80) CHARACTER SET utf8 NOT NULL COMMENT '滞纳金',
  `fee_pay_status` varchar(10) CHARACTER SET utf8 NOT NULL COMMENT '缴纳状态',
  `fee_he_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_swedish_ci NOT NULL COMMENT '标识不同的小区'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `fee_table`
--

INSERT INTO `fee_table` (`t_id`, `fee_bill_id`, `fee_user_id`, `fee_create_time`, `fee_end_time`, `fee_kind`, `fee_total`, `fee_late_payment`, `fee_pay_status`, `fee_he_name`) VALUES
(1, 'dianfei20141219haiyun_13_309', 'haiyun_13_309', '2014-12-19', '2015-01-19', '用户电费', '1000.00', '0', '已支付', 'haiyun');

-- --------------------------------------------------------

--
-- 表的结构 `floor_table`
--

CREATE TABLE IF NOT EXISTS `floor_table` (
`t_id` int(10) unsigned NOT NULL,
  `num` int(10) NOT NULL,
  `building_id` int(10) unsigned zerofill NOT NULL COMMENT '外键'
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `floor_table`
--

INSERT INTO `floor_table` (`t_id`, `num`, `building_id`) VALUES
(1, 1, 0000000001),
(2, 2, 0000000001),
(3, 1, 0000000012),
(4, 2, 0000000012),
(5, 3, 0000000012),
(6, 4, 0000000012),
(7, 5, 0000000012),
(8, 6, 0000000012),
(9, 7, 0000000012);

-- --------------------------------------------------------

--
-- 表的结构 `housing_estate_table`
--

CREATE TABLE IF NOT EXISTS `housing_estate_table` (
`t_id` int(11) NOT NULL COMMENT '表格自增长ID',
  `he_code` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '小区代码',
  `he_water_standard` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '水价标准',
  `he_electricity_standard` varchar(80) CHARACTER SET utf8 DEFAULT NULL COMMENT '电价标准',
  `he_elevator_standard` varchar(10) CHARACTER SET utf8 DEFAULT NULL COMMENT '电梯计费标准'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `owner`
--

CREATE TABLE IF NOT EXISTS `owner` (
  `ownerId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `ownerName` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ownerSex` varchar(5) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ownerAge` int(5) DEFAULT NULL,
  `ownerPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ownerEmail` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `owner`
--

INSERT INTO `owner` (`ownerId`, `userId`, `ownerName`, `ownerSex`, `ownerAge`, `ownerPhone`, `ownerEmail`) VALUES
(1, 1, '张娜拉', '女', 19, '18106989162', '39142555@qq.com'),
(2, 2, '陈烨彬', '男', 21, '18805432234', 'yb@qq.com');

-- --------------------------------------------------------

--
-- 表的结构 `parking_places_table`
--

CREATE TABLE IF NOT EXISTS `parking_places_table` (
`t_id` int(10) unsigned NOT NULL COMMENT '表格排序id',
  `pp_id` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '车位ID',
  `pp_position` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '车位位置（地上或地下）',
  `pp_type` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '车位类型（租用或临时或通用）',
  `pp_status` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '车位状态 占用还是没占用',
  `pp_car_num` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '车牌号',
  `pp_he_name` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '车位所属小区housing estate',
  `user_id` int(30) unsigned DEFAULT NULL COMMENT '外键：对应user表主键',
  `pp_begin_time` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `pp_end_time` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `pp_last_pay_time` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '租用车位上次收费时间'
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `parking_places_table`
--

INSERT INTO `parking_places_table` (`t_id`, `pp_id`, `pp_position`, `pp_type`, `pp_status`, `pp_car_num`, `pp_he_name`, `user_id`, `pp_begin_time`, `pp_end_time`, `pp_last_pay_time`) VALUES
(1, 'haiyun_pp_1', '地上', '通用车位', '租赁占用', '闽D.77777', '五缘公寓', NULL, '2014-12-26', '', NULL),
(2, 'haiyun_pp_2', '地下', '租用车位', '租赁占用', '闽D.23999', '五缘公寓', NULL, '2014-12-26', '', '2014-12-26'),
(3, 'haiyun_pp_3', '地上', '临时车位', '空', '空', '五缘公寓', NULL, NULL, NULL, NULL),
(4, 'haiyun_pp_4', '地下', '租用车位', '空', '空', '五缘公寓', NULL, NULL, NULL, NULL),
(5, 'haiyun_pp_5', '地上', '临时车位', '空', '空', '五缘公寓', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `room_table`
--

CREATE TABLE IF NOT EXISTS `room_table` (
`t_id` int(30) unsigned NOT NULL COMMENT '表格自增长ID',
  `floor_id` int(10) unsigned zerofill NOT NULL COMMENT '外键',
  `room_num` int(10) unsigned zerofill NOT NULL COMMENT '房号',
  `room_area` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '面积大小',
  `user_id` int(30) unsigned DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `room_table`
--

INSERT INTO `room_table` (`t_id`, `floor_id`, `room_num`, `room_area`, `user_id`) VALUES
(1, 0000000001, 0000000001, '90', NULL),
(2, 0000000001, 0000000002, '90', NULL),
(3, 0000000001, 0000000003, '120', NULL),
(4, 0000000001, 0000000004, '120', NULL),
(5, 0000000003, 0000000001, '90', NULL);

-- --------------------------------------------------------

--
-- 表的结构 `temp_bill`
--

CREATE TABLE IF NOT EXISTS `temp_bill` (
`t_id` int(30) NOT NULL,
  `p_car_num` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `p_he_name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `p_begin_time` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `p_end_time` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `p_hour` int(30) DEFAULT NULL,
  `p_bill` int(30) NOT NULL,
  `p_last_pay_time` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `p_day` int(30) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 转存表中的数据 `temp_bill`
--

INSERT INTO `temp_bill` (`t_id`, `p_car_num`, `p_he_name`, `p_begin_time`, `p_end_time`, `p_hour`, `p_bill`, `p_last_pay_time`, `p_day`) VALUES
(1, '闽D.33344', '五缘公寓', '2014-12-22 11:34:05', '2014-12-22 17:21:25', 6, 30, NULL, NULL),
(2, '闽D.33344', '五缘公寓', '2014-12-22 11:34:05', '2014-12-22 17:21:49', 6, 30, NULL, NULL),
(3, '闽D.SB222', '五缘公寓', '2014-12-22 15:20:04', '2014-12-22 17:37:21', 3, 15, NULL, NULL),
(4, '闽D.33344', '五缘公寓', '2014-12-22 11:34:05', '2014-12-22 17:46:16', 7, 35, NULL, NULL),
(5, '闽D.22223', '五缘公寓', '2014-12-22 10:00:00', '2014-12-22 17:51:58', 8, 40, NULL, NULL),
(6, '闽D.22333', '五缘公寓', '2014-12-22 17:52:34', '2014-12-22 17:58:00', 1, 5, NULL, NULL),
(7, '闽D.22222', '五缘公寓', '2014-12-22 19:30:07', '2014-12-22 19:31:12', 1, 5, NULL, NULL),
(8, '闽D.22111', '五缘公寓', '2014-12-22 20:29:20', '2014-12-22 20:30:22', 1, 5, NULL, NULL),
(9, '闽D.22221', '五缘公寓', '2014-12-24 19:47:22', '2014-12-24 19:47:59', 1, 5, NULL, NULL),
(10, '空', '五缘公寓', '2014-12-25 17:54:30', '2014-12-25 23:54:05', 6, 30, NULL, NULL),
(11, '空', '五缘公寓', '2014-12-25 18:02:55', '2014-12-26 00:08:38', 7, 35, NULL, NULL),
(12, '闽D.22222', '五缘公寓', '2014-12-26 00:02:43', '2014-12-26 00:14:06', 1, 5, NULL, NULL),
(13, '闽D.SB222', '五缘公寓', '2014-12-25 23:58:24', '2014-12-26 00:14:15', 1, 5, NULL, NULL),
(14, '闽D.11111', '五缘公寓', '2014-12-26 00:14:22', '2014-12-26 00:14:58', 1, 5, NULL, NULL),
(15, '闽D.22222', '五缘公寓', '2014-12-26 00:14:41', '2014-12-26 00:16:05', 1, 5, NULL, NULL),
(16, '闽D.22222', '五缘公寓', '2014-12-26 00:16:12', '2014-12-26 00:16:28', 1, 5, NULL, NULL),
(17, '闽D.22222', '五缘公寓', '2014-12-26 00:22:57', '2014-12-26 13:49:29', 14, 70, NULL, NULL),
(18, '闽D.12345', '五缘公寓', '2014-12-26 00:17:24', '2014-12-26 15:53:24', 16, 80, NULL, NULL),
(19, '闽D.23232', '五缘公寓', '2014-12-26', '2014-12-26', 0, 20, '2014-12-31', 2),
(20, '空', '五缘公寓', '2014-12-26', '2014-12-26', 0, 40, '2014-12-01', 4),
(21, '闽D.11112', '五缘公寓', '2014-12-22 ', '2014-12-26', 0, 20, '2014-12-10', 2),
(22, '空', '五缘公寓', '2014-12-10', '2014-12-26', 0, 250, '2014-12-01', 25),
(23, '闽d.00000', '五缘公寓', '2014-12-26 17:16:32', '2014-12-26 17:17:03', 1, 5, NULL, 0),
(24, '闽D.11122', '五缘公寓', '2014-12-26 17:19:35', '2014-12-26 17:20:02', 1, 5, NULL, 0);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
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
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`userId`, `username`, `password`, `roleId`, `name`, `sex`, `age`, `phone`, `email`) VALUES
(1, 'Yao', '123', 1, '张伟颖', 'GAY', 20, '18106989160', 'wyzhang@qq.com'),
(2, 'chen', 'chen17', 1, '陈烨彬', '男', 21, '13398910333', 'yb@qq.com'),
(3, 'yebin', 'chen', 1, 'MAC CHEN', '男', 22, '15880868890', 'xianyuxmu@gmail.com'),
(4, 'xiyu', 'xiyu1', 1, '陈希瑀', '女', 22, '15759263463', 'xychen@qq.com'),
(5, 'yufan', 'yufan', 1, '胡于凡', '女', 21, '18650033909', 'yfhu@qq.com'),
(6, '11', '22', 1, 'zhang', '1', 18, '110', '33@qq.com'),
(7, 'xiyu', 'xiyu', 1, '陈希瑀', '女', 22, '15759263463', 'xychen@qq.com');

-- --------------------------------------------------------

--
-- 表的结构 `users_manager_table`
--

CREATE TABLE IF NOT EXISTS `users_manager_table` (
`t_id` int(30) unsigned NOT NULL COMMENT '表格自增长ID',
  `user_id` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '用户房间ID',
  `user_pwd` varchar(50) CHARACTER SET utf8 NOT NULL COMMENT '密码',
  `user_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户姓名',
  `user_sex` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
  `user_age` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '年龄',
  `user_phone` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '电话',
  `user_email` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '邮件',
  `user_address` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '地址',
  `user_house_status` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '房间状态：闲置、已有户主',
  `community_id` int(10) unsigned zerofill DEFAULT NULL COMMENT '标示不同小区',
  `user_role` varchar(20) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `users_manager_table`
--

INSERT INTO `users_manager_table` (`t_id`, `user_id`, `user_pwd`, `user_name`, `user_sex`, `user_age`, `user_phone`, `user_email`, `user_address`, `user_house_status`, `community_id`, `user_role`) VALUES
(7, 'super_01', '123', '林宥嘉', '男', '22', '187', '111@qq.com', NULL, NULL, NULL, '超级管理员');

-- --------------------------------------------------------

--
-- 表的结构 `water_debt_table`
--

CREATE TABLE IF NOT EXISTS `water_debt_table` (
`t_id` int(10) unsigned NOT NULL,
  `room_id` int(30) unsigned zerofill NOT NULL COMMENT '外键——对应房间',
  `debt` double(10,1) unsigned zerofill NOT NULL COMMENT '欠费款项'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `water_degree_table`
--

CREATE TABLE IF NOT EXISTS `water_degree_table` (
`t_id` int(30) unsigned NOT NULL,
  `building_num` int(10) unsigned zerofill NOT NULL COMMENT '外键——楼',
  `floor_num` int(10) unsigned zerofill NOT NULL COMMENT '外键——层',
  `room_num` int(10) unsigned zerofill NOT NULL COMMENT '外键——房间',
  `community_id` int(10) unsigned zerofill NOT NULL COMMENT '社区',
  `last_entering_time` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '上次抄表度数时间（年月日）',
  `this_entering_time` varchar(30) CHARACTER SET utf8 DEFAULT NULL COMMENT '本次抄表度数时间（年月日）',
  `last_entering_degree` int(30) unsigned zerofill DEFAULT NULL COMMENT '上次抄表度数',
  `this_entering_degree` int(30) unsigned zerofill DEFAULT NULL COMMENT '本次抄表度数',
  `degree` int(30) unsigned zerofill DEFAULT NULL COMMENT '本期所用度数'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- 表的结构 `water_payment_table`
--

CREATE TABLE IF NOT EXISTS `water_payment_table` (
`t_id` int(30) unsigned NOT NULL,
  `community_payment` double(10,1) unsigned zerofill DEFAULT NULL COMMENT '社区公摊水费',
  `building_payment` double(10,1) unsigned zerofill DEFAULT NULL COMMENT '楼房公摊水费',
  `floor_payment` double(10,1) unsigned zerofill DEFAULT NULL COMMENT '层分摊水费',
  `room_id` int(30) unsigned zerofill DEFAULT NULL COMMENT '外键——对应房间度数表',
  `room_payment` double(10,1) unsigned zerofill DEFAULT NULL COMMENT '房间水表费用',
  `is_pay` int(10) unsigned zerofill DEFAULT NULL COMMENT '是否付费（1代表付费，0代表没付费） ',
  `r_id` int(30) unsigned zerofill DEFAULT NULL COMMENT '外键——对应账单所属房间',
  `total` double(10,1) unsigned zerofill DEFAULT NULL COMMENT '总的水费',
  `day` varchar(30) CHARACTER SET utf8 NOT NULL COMMENT '生成账单日期'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `building_table`
--
ALTER TABLE `building_table`
 ADD PRIMARY KEY (`t_id`), ADD KEY `building_community` (`community_id`);

--
-- Indexes for table `community_table`
--
ALTER TABLE `community_table`
 ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `elec_debt_table`
--
ALTER TABLE `elec_debt_table`
 ADD PRIMARY KEY (`t_id`), ADD KEY `elecdebt_room` (`room_id`);

--
-- Indexes for table `elec_degree_table`
--
ALTER TABLE `elec_degree_table`
 ADD PRIMARY KEY (`t_id`), ADD KEY `elec_community` (`community_id`);

--
-- Indexes for table `elec_payment_table`
--
ALTER TABLE `elec_payment_table`
 ADD PRIMARY KEY (`t_id`), ADD KEY `elecpayment_degree` (`room_id`), ADD KEY `elecpayment_room` (`r_id`);

--
-- Indexes for table `fee_manager_table`
--
ALTER TABLE `fee_manager_table`
 ADD PRIMARY KEY (`t_id`), ADD UNIQUE KEY `t_id` (`t_id`);

--
-- Indexes for table `fee_table`
--
ALTER TABLE `fee_table`
 ADD PRIMARY KEY (`t_id`), ADD UNIQUE KEY `t_id` (`t_id`);

--
-- Indexes for table `floor_table`
--
ALTER TABLE `floor_table`
 ADD PRIMARY KEY (`t_id`), ADD KEY `floor_building` (`building_id`);

--
-- Indexes for table `housing_estate_table`
--
ALTER TABLE `housing_estate_table`
 ADD PRIMARY KEY (`t_id`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
 ADD PRIMARY KEY (`ownerId`), ADD KEY `userId` (`userId`);

--
-- Indexes for table `parking_places_table`
--
ALTER TABLE `parking_places_table`
 ADD PRIMARY KEY (`t_id`), ADD UNIQUE KEY `t_id` (`t_id`), ADD KEY `parking_users` (`user_id`);

--
-- Indexes for table `room_table`
--
ALTER TABLE `room_table`
 ADD PRIMARY KEY (`t_id`), ADD KEY `room_floor` (`floor_id`), ADD KEY `room_user` (`user_id`);

--
-- Indexes for table `temp_bill`
--
ALTER TABLE `temp_bill`
 ADD PRIMARY KEY (`t_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `users_manager_table`
--
ALTER TABLE `users_manager_table`
 ADD PRIMARY KEY (`t_id`), ADD KEY `user_community` (`community_id`);

--
-- Indexes for table `water_debt_table`
--
ALTER TABLE `water_debt_table`
 ADD PRIMARY KEY (`t_id`), ADD KEY `waterdebt_room` (`room_id`);

--
-- Indexes for table `water_degree_table`
--
ALTER TABLE `water_degree_table`
 ADD PRIMARY KEY (`t_id`), ADD KEY `water_building` (`building_num`), ADD KEY `water_floor` (`floor_num`), ADD KEY `water_room` (`room_num`), ADD KEY `degree_community` (`community_id`);

--
-- Indexes for table `water_payment_table`
--
ALTER TABLE `water_payment_table`
 ADD PRIMARY KEY (`t_id`), ADD KEY `payment_room_degree` (`room_id`), ADD KEY `payment_room` (`r_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `building_table`
--
ALTER TABLE `building_table`
MODIFY `t_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `community_table`
--
ALTER TABLE `community_table`
MODIFY `c_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `elec_debt_table`
--
ALTER TABLE `elec_debt_table`
MODIFY `t_id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `elec_degree_table`
--
ALTER TABLE `elec_degree_table`
MODIFY `t_id` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `fee_manager_table`
--
ALTER TABLE `fee_manager_table`
MODIFY `t_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '表格自增长id',AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `fee_table`
--
ALTER TABLE `fee_table`
MODIFY `t_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '表格自增长ID',AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `floor_table`
--
ALTER TABLE `floor_table`
MODIFY `t_id` int(10) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `housing_estate_table`
--
ALTER TABLE `housing_estate_table`
MODIFY `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '表格自增长ID';
--
-- AUTO_INCREMENT for table `parking_places_table`
--
ALTER TABLE `parking_places_table`
MODIFY `t_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '表格排序id',AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `room_table`
--
ALTER TABLE `room_table`
MODIFY `t_id` int(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '表格自增长ID',AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `temp_bill`
--
ALTER TABLE `temp_bill`
MODIFY `t_id` int(30) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `users_manager_table`
--
ALTER TABLE `users_manager_table`
MODIFY `t_id` int(30) unsigned NOT NULL AUTO_INCREMENT COMMENT '表格自增长ID',AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `water_debt_table`
--
ALTER TABLE `water_debt_table`
MODIFY `t_id` int(10) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `water_degree_table`
--
ALTER TABLE `water_degree_table`
MODIFY `t_id` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `water_payment_table`
--
ALTER TABLE `water_payment_table`
MODIFY `t_id` int(30) unsigned NOT NULL AUTO_INCREMENT;
--
-- 限制导出的表
--

--
-- 限制表 `building_table`
--
ALTER TABLE `building_table`
ADD CONSTRAINT `building_community` FOREIGN KEY (`community_id`) REFERENCES `community_table` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `elec_debt_table`
--
ALTER TABLE `elec_debt_table`
ADD CONSTRAINT `elecdebt_room` FOREIGN KEY (`room_id`) REFERENCES `room_table` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `elec_degree_table`
--
ALTER TABLE `elec_degree_table`
ADD CONSTRAINT `elec_community` FOREIGN KEY (`community_id`) REFERENCES `community_table` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `elec_payment_table`
--
ALTER TABLE `elec_payment_table`
ADD CONSTRAINT `elecpayment_degree` FOREIGN KEY (`room_id`) REFERENCES `elec_degree_table` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `elecpayment_room` FOREIGN KEY (`r_id`) REFERENCES `room_table` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `floor_table`
--
ALTER TABLE `floor_table`
ADD CONSTRAINT `floor_building` FOREIGN KEY (`building_id`) REFERENCES `building_table` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `owner`
--
ALTER TABLE `owner`
ADD CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `parking_places_table`
--
ALTER TABLE `parking_places_table`
ADD CONSTRAINT `parking_users` FOREIGN KEY (`user_id`) REFERENCES `users_manager_table` (`t_id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- 限制表 `room_table`
--
ALTER TABLE `room_table`
ADD CONSTRAINT `room_floor` FOREIGN KEY (`floor_id`) REFERENCES `floor_table` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `room_user` FOREIGN KEY (`user_id`) REFERENCES `users_manager_table` (`t_id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- 限制表 `users_manager_table`
--
ALTER TABLE `users_manager_table`
ADD CONSTRAINT `user_community` FOREIGN KEY (`community_id`) REFERENCES `community_table` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `water_debt_table`
--
ALTER TABLE `water_debt_table`
ADD CONSTRAINT `waterdebt_room` FOREIGN KEY (`room_id`) REFERENCES `room_table` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `water_degree_table`
--
ALTER TABLE `water_degree_table`
ADD CONSTRAINT `degree_community` FOREIGN KEY (`community_id`) REFERENCES `community_table` (`c_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- 限制表 `water_payment_table`
--
ALTER TABLE `water_payment_table`
ADD CONSTRAINT `payment_room` FOREIGN KEY (`r_id`) REFERENCES `room_table` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `payment_room_degree` FOREIGN KEY (`room_id`) REFERENCES `water_degree_table` (`t_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
