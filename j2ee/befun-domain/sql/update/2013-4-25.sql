ALTER TABLE `floorplan` ADD COLUMN `land_size` double NOT NULL DEFAULT 0;
ALTER TABLE `floorplan` ADD KEY `idx_land_size` (`land_size`);

ALTER TABLE `profile` CHANGE COLUMN `middle_name` `middle_name` VARCHAR(45) NULL;
ALTER TABLE `role` CHANGE COLUMN `description` `description` TEXT NULL;