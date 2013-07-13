ALTER TABLE `floorplan` ADD COLUMN `recommended` tinyint(1) NOT NULL DEFAULT 0;
ALTER TABLE `floorplan` ADD INDEX `idx_recommended` (`recommended`) USING BTREE ;