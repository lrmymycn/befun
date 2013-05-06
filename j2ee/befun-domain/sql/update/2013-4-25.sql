ALTER TABLE `floorplan` ADD COLUMN `land_size` double NOT NULL DEFAULT 0;
ALTER TABLE `floorplan` ADD KEY `idx_land_size` (`land_size`);

ALTER TABLE `profile` CHANGE COLUMN `middle_name` `middle_name` VARCHAR(45) NULL;
ALTER TABLE `role` CHANGE COLUMN `description` `description` TEXT NULL;

ALTER TABLE `area` CHANGE COLUMN `description` `description` TEXT NULL;

ALTER TABLE `floorplan` ADD COLUMN `orientation_east` tinyint(1) NULL DEFAULT 0 AFTER `orientation` 
ALTER TABLE `floorplan` ADD COLUMN `orientation_south` tinyint(1) NULL DEFAULT 0 AFTER `orientation_east` 
ALTER TABLE `floorplan` ADD COLUMN `orientation_west` tinyint(1) NULL DEFAULT 0 AFTER `orientation_south` 
ALTER TABLE `floorplan` ADD COLUMN `orientation_north` tinyint(1) NULL DEFAULT 0 AFTER `orientation_west` 

ALTER TABLE `floorplan` ADD INDEX `idx_orientation_east` USING BTREE (`orientation_east` ASC) ;
ALTER TABLE `floorplan` ADD INDEX `idx_orientation_south` USING BTREE (`orientation_south` ASC) ;
ALTER TABLE `floorplan` ADD INDEX `idx_orientation_west` USING BTREE (`orientation_west` ASC) ;
ALTER TABLE `floorplan` ADD INDEX `idx_orientation_north` USING BTREE (`orientation_north` ASC) ;

--ALTER TABLE `floorplan` DROP COLUMN `orientation`;

ALTER TABLE `building` ADD COLUMN `orientation_east` tinyint(1) NULL DEFAULT 0 AFTER `orientation` 
ALTER TABLE `building` ADD COLUMN `orientation_south` tinyint(1) NULL DEFAULT 0 AFTER `orientation_east` 
ALTER TABLE `building` ADD COLUMN `orientation_west` tinyint(1) NULL DEFAULT 0 AFTER `orientation_south` 
ALTER TABLE `building` ADD COLUMN `orientation_north` tinyint(1) NULL DEFAULT 0 AFTER `orientation_west` 

ALTER TABLE `building` ADD INDEX `idx_orientation_east` USING BTREE (`orientation_east` ASC) ;
ALTER TABLE `building` ADD INDEX `idx_orientation_south` USING BTREE (`orientation_south` ASC) ;
ALTER TABLE `building` ADD INDEX `idx_orientation_west` USING BTREE (`orientation_west` ASC) ;
ALTER TABLE `building` ADD INDEX `idx_orientation_north` USING BTREE (`orientation_north` ASC) ;

--ALTER TABLE `building` DROP COLUMN `orientation`;



ALTER TABLE `profile` CHANGE COLUMN `middle_name` `middle_name` VARCHAR(45) NULL;