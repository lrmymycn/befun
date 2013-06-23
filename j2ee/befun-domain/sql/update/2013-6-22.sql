ALTER TABLE `project` ADD COLUMN `short_description` varchar(500) DEFAULT NULL;
ALTER TABLE `project` ADD COLUMN `type` varchar(500) DEFAULT NULL;
ALTER TABLE `project` ADD COLUMN `price_range` varchar(500) DEFAULT NULL;

ALTER TABLE `project` ADD COLUMN `stage_count` int(11) DEFAULT 1;
ALTER TABLE `project` ADD COLUMN `building_count` int(11) DEFAULT 1;