# bms_demo_testa
CREATE DATABASE `bms_demo`;
USE `bms_demo`;
# 用户表
CREATE TABLE `test_user` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增ID',
  `username` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '密码',
  `status` TINYINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='用户表';
# 用户角色关系表
CREATE TABLE `test_user_role` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增ID',
  `user_id` BIGINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '用户ID',
  `role_id` BIGINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='用户角色关系表';
# 角色表
CREATE TABLE `test_role` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增ID',
  `role` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '角色名',
  `description` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='角色表';
# 角色权限表
CREATE TABLE `test_role_permission` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增ID',
  `role_id` BIGINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '角色ID',
  `permission_id` BIGINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '权限ID',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='角色权限表';
# 权限表
CREATE TABLE `test_permission` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增ID',
  `url` varchar(128) NOT NULL DEFAULT '' COMMENT '权限路径',
  `permission` varchar(32) NOT NULL DEFAULT '' COMMENT '权限',
  `description` varchar(255) NOT NULL DEFAULT '' COMMENT '描述',
  `parent_id` BIGINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '父ID',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='权限表';
#######################################################################################################################3

INSERT INTO user (id, username, password) VALUES (1,'user','e10adc3949ba59abbe56e057f20f883e');
INSERT INTO user (id, username , password) VALUES (2,'admin','e10adc3949ba59abbe56e057f20f883e');
INSERT INTO role (id, name) VALUES (1,'USER');
INSERT INTO role (id, name) VALUES (2,'ADMIN');
INSERT INTO permission (id, url, name, pid) VALUES (1,'/user/common','common',0);
INSERT INTO permission (id, url, name, pid) VALUES (2,'/user/admin','admin',0);
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 1);
INSERT INTO role_permission (role_id, permission_id) VALUES (2, 1);
INSERT INTO role_permission (role_id, permission_id) VALUES (2, 2);