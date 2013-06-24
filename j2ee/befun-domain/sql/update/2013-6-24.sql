ALTER TABLE `comment_rec` ADD COLUMN `parent_id` bigint(20) DEFAULT NULL;
ALTER TABLE `comment_rec` ADD COLUMN `guest_name` varchar(255) DEFAULT NULL;

ALTER TABLE `comment_rec` ADD INDEX `idx_parent_id` (`parent_id` ASC) ;
ALTER TABLE `comment_rec` ADD CONSTRAINT `fk_comment_parent_id` FOREIGN KEY (`parent_id` ) REFERENCES `comment_rec` (`id` ) ON DELETE NO ACTION ON UPDATE NO ACTION;

