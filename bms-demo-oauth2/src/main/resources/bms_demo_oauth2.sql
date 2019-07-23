CREATE DATABASE `bms_demo_oauth2`;
USE `bms_demo_oauth2`;
# 用户表
CREATE TABLE `user` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增ID',
  `username` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` VARCHAR(128) NOT NULL DEFAULT '' COMMENT '密码',
  `status` TINYINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='用户表';
# 用户角色关系表
CREATE TABLE `user_role` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增ID',
  `user_id` BIGINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '用户ID',
  `role_id` BIGINT UNSIGNED NOT NULL DEFAULT '0' COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='用户角色关系表';
# 角色表
CREATE TABLE `role` (
  `id` BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增ID',
  `role` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '角色名',
  `description` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB CHARSET=utf8mb4 COMMENT='角色表';
########################################################################################################
CREATE TABLE `clientdetails` (
  `appId` varchar(128) NOT NULL DEFAULT '' COMMENT 'appId',
  `resourceIds` varchar(256) NOT NULL DEFAULT '' COMMENT 'resourceIds',
  `appSecret` varchar(256) NOT NULL DEFAULT '' COMMENT 'appSecret',
  `scope` varchar(256) NOT NULL DEFAULT '' COMMENT 'scope',
  `grantTypes` varchar(256) NOT NULL DEFAULT '' COMMENT 'grantTypes',
  `redirectUrl` varchar(256) NOT NULL DEFAULT '' COMMENT 'redirectUrl',
  `authorities` varchar(256) NOT NULL DEFAULT '' COMMENT 'authorities',
  `access_token_validity` int(11) NOT NULL DEFAULT '0' COMMENT 'access_token_validity',
  `refresh_token_validity` int(11) NOT NULL DEFAULT '0' COMMENT 'refresh_token_validity',
  `additionalInformation` varchar(4096) NOT NULL DEFAULT '' COMMENT 'additionalInformation',
  `autoApproveScopes` varchar(256) NOT NULL DEFAULT '' COMMENT 'autoApproveScopes',
  PRIMARY KEY (`appId`)
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) NOT NULL DEFAULT '' COMMENT 'token_id',
  `token` blob,
  `authentication_id` varchar(128) NOT NULL DEFAULT '' COMMENT 'authentication_id',
  `user_name` varchar(256) NOT NULL DEFAULT '' COMMENT 'user_name',
  `client_id` varchar(256) NOT NULL DEFAULT '' COMMENT 'client_id',
  `authentication` blob,
  `refresh_token` varchar(256) NOT NULL DEFAULT '' COMMENT 'refresh_token',
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE `oauth_approvals` (
  `userId` varchar(256) NOT NULL DEFAULT '' COMMENT 'userId',
  `clientId` varchar(256) NOT NULL DEFAULT '' COMMENT 'clientId',
  `scope` varchar(256) NOT NULL DEFAULT '' COMMENT 'scope',
  `status` varchar(10) NOT NULL DEFAULT '' COMMENT 'status',
  `expiresAt` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT 'expiresAt',
  `lastModifiedAt` datetime NOT NULL DEFAULT '1970-01-01 08:00:00' COMMENT 'lastModifiedAt'
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL DEFAULT '' COMMENT 'client_id',
  `resource_ids` varchar(256) NOT NULL DEFAULT '' COMMENT 'resource_ids',
  `client_secret` varchar(256) NOT NULL DEFAULT '' COMMENT 'client_secret',
  `scope` varchar(256) NOT NULL DEFAULT '' COMMENT 'scope',
  `authorized_grant_types` varchar(256) NOT NULL DEFAULT '' COMMENT 'authorized_grant_types',
  `web_server_redirect_uri` varchar(256) NOT NULL DEFAULT '' COMMENT 'web_server_redirect_uri',
  `authorities` varchar(256) NOT NULL DEFAULT '' COMMENT 'authorities',
  `access_token_validity` int(11) NOT NULL DEFAULT '0' COMMENT 'access_token_validity',
  `refresh_token_validity` int(11) NOT NULL DEFAULT '0' COMMENT 'refresh_token_validity',
  `additional_information` varchar(4096) NOT NULL DEFAULT '' COMMENT 'additional_information',
  `autoapprove` varchar(256) NOT NULL DEFAULT '' COMMENT 'autoapprove',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) NOT NULL DEFAULT '' COMMENT 'token ID',
  `token` blob,
  `authentication_id` varchar(128) NOT NULL DEFAULT '' COMMENT 'authentication ID',
  `user_name` varchar(256) NOT NULL DEFAULT '' COMMENT '用户名',
  `client_id` varchar(256) NOT NULL DEFAULT '' COMMENT 'client ID',
  PRIMARY KEY (`authentication_id`)
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE `oauth_code` (
  `code` varchar(256) NOT NULL DEFAULT '' COMMENT 'code',
  `authentication` blob
) ENGINE=InnoDB CHARSET=utf8mb4;

CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) NOT NULL DEFAULT '' COMMENT 'token ID',
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB CHARSET=utf8mb4;

INSERT INTO `oauth_client_details` VALUES (
'dev', '', 'dev', 'app', 'password,client_credentials,authorization_code,refresh_token', 'http://www.baidu.com', '', 3600, 3600, '{\"country\":\"CN\",\"country_code\":\"086\"}', 'false');
