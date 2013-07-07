ALTER TABLE `project` ADD COLUMN `rank` int(11) DEFAULT NULL;


CREATE TABLE IF NOT EXISTS `customer_message` (
  `id` bigint(20) NOT NULL,
  `content` text,
  `customer_name` varchar(255) NOT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_mobile` varchar(255) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `floorplan_id` bigint(20) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `process_date` datetime DEFAULT NULL,
  `processed` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`),
  KEY `idx_project_id` (`project_id`),
  KEY `idx_floorplan_id` (`floorplan_id`),
  KEY `idx_creation_date` (`creation_date`),
  KEY `idx_processed` (`processed`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
