/*
MySQL Backup
Source Server Version: 5.5.28
Source Database: myworld
Date: 2017/7/17 16:09:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `wei_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `wei_dictionary`;
CREATE TABLE `wei_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `type` varchar(50) DEFAULT NULL COMMENT '����',
  `type_desc` varchar(50) DEFAULT NULL COMMENT '��������',
  `code` varchar(50) DEFAULT NULL COMMENT '����',
  `code_desc` varchar(50) DEFAULT NULL COMMENT '��������',
  `sorted` int(11) DEFAULT NULL COMMENT '����',
  `state` int(11) DEFAULT NULL COMMENT '����״̬',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_time` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  `creator` varchar(50) DEFAULT NULL COMMENT '������',
  `updater` varchar(50) DEFAULT NULL COMMENT '�޸���',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����ֵ��';

-- ----------------------------
--  Table structure for `wei_user`
-- ----------------------------
DROP TABLE IF EXISTS `wei_user`;
CREATE TABLE `wei_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `username` char(20) DEFAULT NULL COMMENT '����',
  `password` char(20) DEFAULT NULL COMMENT '����',
  `email` char(30) DEFAULT NULL COMMENT '����',
  `role` char(22) DEFAULT NULL COMMENT '��ɫ',
  `state` int(11) DEFAULT NULL COMMENT '״̬��0������/1�����ߣ�',
  `create_time` datetime DEFAULT NULL COMMENT '����ʱ��',
  `update_time` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  `creater` char(22) DEFAULT NULL COMMENT '������',
  `updater` char(22) DEFAULT NULL COMMENT '�޸���',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='�û���';

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `wei_user` VALUES ('1','卫子鱼','234234234','email@qq.com','ADMIN',NULL,NULL,NULL,NULL,NULL);
