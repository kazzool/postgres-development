-- User Table Add Column
ALTER TABLE `t_user` ADD COLUMN `display_name` varchar(50) DEFAULT NULL AFTER `user_id`;