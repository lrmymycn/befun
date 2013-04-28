CREATE TABLE IF NOT EXISTS `profile` (
  `id` bigint(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL COMMENT '密码应该是经过单向散列算法加密过的，不可逆',
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) DEFAULT NULL,
  `mobile_number` varchar(45) DEFAULT NULL,
  `home_phone` varchar(45) DEFAULT NULL,
  `employee_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`),
  KEY `idx_password` (`password`(255)),
  KEY `idx_firstname` (`first_name`),
  KEY `idx_lastname` (`last_name`),
  KEY `idx_middlename` (`middle_name`),
  KEY `idx_mobile_number` (`mobile_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `client` (
  `client_id` bigint(20) NOT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY (`client_id`),
  CONSTRAINT `fk_client_id` FOREIGN KEY (`client_id`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `profile_role` (
  `id` bigint(20) NOT NULL,
  `profile_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_profile_id` (`profile_id`),
  KEY `idx_role_id` (`role_id`),
  CONSTRAINT `fk_profile_role_profile_id` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `permission` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`),
  KEY `idx_code` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `role_permission` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_role_id` (`role_id`),
  KEY `idx_profile_id` (`permission_id`),
  CONSTRAINT `fk_role_permission_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permission_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `department` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `profile_department` (
  `id` bigint(20) NOT NULL,
  `profile_id` bigint(20) NOT NULL,
  `department_id` bigint(20) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_profile_id` (`profile_id`),
  KEY `idx_department_id` (`department_id`),
  CONSTRAINT `fk_profile_department_profile_id` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_department_dp_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `media` (
  `id` bigint(20) NOT NULL,
  `bid` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `small_url` varchar(5000) NOT NULL,
  `medium_url` varchar(5000) NOT NULL,
  `large_url` varchar(5000) NOT NULL,
  `alt` varchar(5000) DEFAULT NULL,
  `media_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-图片，1-视频',
  `content_type` tinyint(4) NOT NULL DEFAULT '4' COMMENT '0-户型图，1-效果图 室内，2-效果图 室外，3-实际照片，4-周边环境，5-Floorplate，6-other',
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bid` (`bid`),
  KEY `idx_name` (`name`),
  KEY `idx_media_type` (`media_type`),
  KEY `idx_content_type` (`content_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comment_rec` (
  `id` bigint(20) NOT NULL,
  `profile_id` bigint(20) NOT NULL,
  `content` TEXT DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 0,
  `enabled_date` datetime DEFAULT NULL,
  `enabled_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_profile_id` (`profile_id`),
  KEY `idx_enabled` (`enabled`),
  KEY `idx_enabled_by` (`enabled_by`),
  CONSTRAINT `fk_area_comment_profile_id` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_area_comment_enabled_by` FOREIGN KEY (`enabled_by`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `area` (
  `id` bigint(20) NOT NULL,
  `bid` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bid` (`bid`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `area_comment` (
  `id` bigint(20) NOT NULL,
  `area_id` bigint(20) NOT NULL,
  `comment_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_area_id` (`area_id`),
  KEY `idx_comment_id` (`comment_id`),
  CONSTRAINT `fk_area_comment_area_id` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_area_comment_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment_rec` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `area_polyline` (
  `id` bigint(20) NOT NULL,
  `area_id` bigint(20) NOT NULL,
  `longitude` double NOT NULL,
  `latitude` double NOT NULL,
  `seq_num` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_longitude` (`longitude`),
  KEY `idx_latitude` (`latitude`),
  KEY `idx_area_id` (`area_id`),
  CONSTRAINT `fk_area_polyline_area_id` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `suburb` (
  `id` bigint(20) NOT NULL,
  `bid` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `master_plan` text DEFAULT NULL,
  `postcode` varchar(20) NOT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `vacancy_rate` int(11) DEFAULT '0',
  `universities` tinyint(1) DEFAULT '0',
  `schools` tinyint(1) DEFAULT '0',
  `shopping_center` tinyint(1) DEFAULT '0',
  `train` tinyint(1) DEFAULT '0' COMMENT '火车站',
  `chinese_community` tinyint(1) DEFAULT '0' COMMENT '华人社区',
  `removed` tinyint(1) DEFAULT '0',
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_bid` (`bid`),
  KEY `idx_area_id` (`area_id`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `suburb_comment` (
  `id` bigint(20) NOT NULL,
  `suburb_id` bigint(20) NOT NULL,
  `comment_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_suburb_id` (`suburb_id`),
  KEY `idx_comment_id` (`comment_id`),
  CONSTRAINT `fk_suburb_comment_suburb_id` FOREIGN KEY (`suburb_id`) REFERENCES `suburb` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_suburb_comment_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment_rec` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `suburb_polyline` (
  `id` bigint(20) NOT NULL,
  `suburb_id` bigint(20)NOT NULL,
  `longitude` double NOT NULL,
  `latitude` double NOT NULL,
  `seq_num` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_longitude` (`longitude`),
  KEY `idx_latitude` (`latitude`),
  KEY `idx_suburb_id` (`suburb_id`),
  CONSTRAINT `fk_suburb_polyline_suburb_id` FOREIGN KEY (`suburb_id`) REFERENCES `suburb` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `project` (
  `id` bigint(20) NOT NULL,
  `bid` varchar(255) DEFAULT NULL,
  `suburb_id` bigint(20) NOT NULL,
  `block` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `picture_id` bigint(20) DEFAULT NULL,
  `logo_id` bigint(20) DEFAULT NULL,
  `site_url` varchar(500) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `features` text DEFAULT NULL,
  `finish_schema` text DEFAULT NULL,
  `developer` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `postcode` varchar(45) NOT NULL,
  `swimming_pool` tinyint(1) DEFAULT 0,
  `gym` tinyint(1) DEFAULT 0,
  `sauna` tinyint(1) DEFAULT 0,
  `tennis_court` tinyint(1) DEFAULT 0,
  `play_room` tinyint(1) DEFAULT 0,
  `func_room` tinyint(1) DEFAULT 0,
  `theatre_cinema` tinyint(1) DEFAULT 0,
  `music_room` tinyint(1) DEFAULT 0,
  `library` tinyint(1) DEFAULT 0,
  `bbq` tinyint(1) DEFAULT 0,
  `receiption` tinyint(1) DEFAULT 0,
  `visitor_parking` tinyint(1) DEFAULT 0,
  `kids_play_ground` tinyint(1) DEFAULT 0,
  `sky_garden` tinyint(1) DEFAULT 0,
  `land_scaping` tinyint(1) DEFAULT 0,
  `recreation_place` tinyint(1) DEFAULT 0,
  `car_wash_bay` tinyint(1) DEFAULT 0,
  `others` tinyint(1) DEFAULT 0,
  `finish_date` datetime DEFAULT NULL,
  `distance_to_city` double DEFAULT NULL,
  `sold` int(11) DEFAULT 0,
  `sold_out` tinyint(1) DEFAULT 0,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bid` (`bid`),
  KEY `idx_suburb_id` (`suburb_id`),
  KEY `idx_name` (`name`),
  KEY `idx_developer` (`developer`),
  KEY `idx_address` (`address`(255)),
  KEY `idx_postcode` (`postcode`),
  KEY `idx_longitude` (`longitude`),
  KEY `idx_latitude` (`latitude`),
  KEY `idx_distancetocity` (`distance_to_city`),
  CONSTRAINT `fk_project_suburb_id` FOREIGN KEY (`suburb_id`) REFERENCES `suburb` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_picture_id` FOREIGN KEY (`picture_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_logo_id` FOREIGN KEY (`logo_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `project_comment` (
  `id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `comment_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_project_id` (`project_id`),
  KEY `idx_comment_id` (`comment_id`),
  CONSTRAINT `fk_project_comment_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_comment_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment_rec` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `stage` (
  `id` bigint(20) NOT NULL,
  `bid` varchar(255) DEFAULT NULL,
  `project_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `finish_date` datetime DEFAULT NULL,
  `sold` int(11) DEFAULT 0,
  `sold_out` tinyint(1) DEFAULT 0,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bid` (`bid`),
  KEY `idx_name` (`name`),
  KEY `idx_stage_project_id` (`project_id`),
  CONSTRAINT `fk_stage_project_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `stage_comment` (
  `id` bigint(20) NOT NULL,
  `stage_id` bigint(20) NOT NULL,
  `comment_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_stage_id` (`stage_id`),
  KEY `idx_comment_id` (`comment_id`),
  CONSTRAINT `fk_stage_comment_stage_id` FOREIGN KEY (`stage_id`) REFERENCES `stage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stage_comment_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment_rec` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `building` (
  `id` bigint(20) NOT NULL,
  `bid` varchar(255) DEFAULT NULL,
  `stage_id` bigint(20) NOT NULL,
  `building_num` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `finish_date` datetime DEFAULT NULL,
  `floor_count` int(11) DEFAULT NULL,
  `orientation` int(11) DEFAULT NULL COMMENT '1-东，2-南，4-西，8-北',
  `ready_house` tinyint(1) DEFAULT 0 COMMENT '是否现房',
  `sold` int(11) DEFAULT 0,
  `sold_out` tinyint(1) DEFAULT 0,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bid` (`bid`),
  KEY `idx_stage_id` (`stage_id`),
  KEY `idx_finish_date` (`finish_date`),
  CONSTRAINT `fk_building_stage_id` FOREIGN KEY (`stage_id`) REFERENCES `stage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `building_comment` (
  `id` bigint(20) NOT NULL,
  `building_id` bigint(20) NOT NULL,
  `comment_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_building_id` (`building_id`),
  KEY `idx_comment_id` (`comment_id`),
  CONSTRAINT `fk_building_comment_building_id` FOREIGN KEY (`building_id`) REFERENCES `building` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_building_comment_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment_rec` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `floorplan` (
  `id` bigint(20) NOT NULL,
  `bid` varchar(255) DEFAULT NULL,
  `building_id` bigint(20) NOT NULL,
  `public_picture_id` bigint(20) DEFAULT NULL,
  `sale_picture_id` bigint(20) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `type` tinyint(4) NOT NULL DEFAULT 1 COMMENT '1-普通公寓，2-连排别墅，3-独栋别墅',
  `is_split` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0或空-平层，1-复式',
  `is_studio` tinyint(1) DEFAULT 0,
  `bedroom_count` int(11) NOT NULL DEFAULT 0,
  `bathroom_count` int(11) NOT NULL DEFAULT 0,
  `studyroom_count` int(11) NOT NULL DEFAULT 0,
  `open_baclony_count` int(11) NOT NULL DEFAULT 0,
  `enclosed_baclony_count` int(11) NOT NULL DEFAULT 0,
  `courtyard_count` int(11) NOT NULL DEFAULT 0,
  `orientation` int(11) DEFAULT NULL COMMENT '1-东，2-南，4-西，8-北',
  `min_price` int(11) DEFAULT NULL,
  `max_price` int(11) DEFAULT NULL,
  `internal_size` double NOT NULL DEFAULT 0,
  `external_size` double NOT NULL DEFAULT 0,
  `total_size` double NOT NULL DEFAULT 0,
  `land_size` double NOT NULL DEFAULT 0,
  `sold` int(11) NOT NULL DEFAULT 0,
  `sold_out` tinyint(1) NOT NULL DEFAULT 0,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bid` (`bid`),
  KEY `idx_building_id` (`building_id`),
  KEY `idx_public_picture_id` (`public_picture_id`),
  KEY `idx_sale_picture_id` (`sale_picture_id`),
  KEY `idx_type` (`type`),
  KEY `idx_bedroom_count` (`bedroom_count`),
  KEY `idx_bathroom_count` (`bathroom_count`),
  KEY `idx_studyroom_count` (`studyroom_count`),
  KEY `idx_open_baclony_count` (`open_baclony_count`),
  KEY `idx_enclosed_baclony_count` (`enclosed_baclony_count`),
  KEY `idx_courtyard_count` (`courtyard_count`),
  KEY `idx_orientation` (`orientation`),
  KEY `idx_min_price` (`min_price`),
  KEY `idx_max_price` (`max_price`),
  KEY `idx_internal_size` (`internal_size`),
  KEY `idx_external_size` (`external_size`),
  KEY `idx_total_size` (`total_size`),
  KEY `idx_land_size` (`land_size`),
  CONSTRAINT `fk_floorplan_building_id` FOREIGN KEY (`building_id`) REFERENCES `building` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_floorplan_pub_picture_id` FOREIGN KEY (`public_picture_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_floorplan_sale_picture_id` FOREIGN KEY (`sale_picture_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `floorplan_comment` (
  `id` bigint(20) NOT NULL,
  `floorplan_id` bigint(20) NOT NULL,
  `comment_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_floorplan_id` (`floorplan_id`),
  KEY `idx_comment_id` (`comment_id`),
  CONSTRAINT `fk_floorplan_comment_floorplan_id` FOREIGN KEY (`floorplan_id`) REFERENCES `floorplan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_floorplan_comment_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment_rec` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `apartment` (
  `id` bigint(20) NOT NULL,
  `bid` varchar(255) DEFAULT NULL,
  `floorplan_id` bigint(20) NOT NULL,
  `description` text DEFAULT NULL,
  `unit_number` varchar(45) DEFAULT NULL,
  `lot_number` varchar(45) DEFAULT NULL,
  `floor_level` int(11) NOT NULL DEFAULT 0,
  `penthouse` tinyint(1) NOT NULL DEFAULT 0,
  `price` int(11) DEFAULT NULL,
  `unit_entitle_ment` tinyint(5) DEFAULT NULL,
  `colorscheme` varchar(255) DEFAULT NULL,
  `car_parking_count` int(11) NOT NULL DEFAULT 0,
  `storageroom_count` int(11) NOT NULL DEFAULT 0,
  `sold_out` tinyint(1) DEFAULT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_bid` (`bid`),
  KEY `idx_floorplan_id` (`floorplan_id`),
  KEY `idx_price` (`price`),
  KEY `idx_car_parking_count` (`car_parking_count`),
  KEY `idx_storageroom_count` (`storageroom_count`),
  CONSTRAINT `fk_apartment_floorplan_id` FOREIGN KEY (`floorplan_id`) REFERENCES `floorplan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `apartment_comment` (
  `id` bigint(20) NOT NULL,
  `apartment_id` bigint(20) NOT NULL,
  `comment_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_apartment_id` (`apartment_id`),
  KEY `idx_comment_id` (`comment_id`),
  CONSTRAINT `fk_apartment_comment_apartment_id` FOREIGN KEY (`apartment_id`) REFERENCES `apartment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_apartment_comment_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment_rec` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `place_intrest` (
  `id` bigint(20) NOT NULL,
  `bid` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `longitude` double NOT NULL,
  `latitude` double NOT NULL,
  `type` tinyint(4) DEFAULT NULL COMMENT '0-医院，1-超市，2-学校，3-餐厅，4-运动场所，5-公园，6-购物中心，7-地标，8-公交站，9地铁站, 10-City',
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`),
  KEY `idx_longitude` (`longitude`),
  KEY `idx_latitude` (`latitude`),
  KEY `idx_description` (`description`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `suburb_place_intrest` (
  `suburb_id` bigint(20) NOT NULL,
  `place_intrest_id` bigint(20) NOT NULL,
  `distance` double DEFAULT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`suburb_id`,`place_intrest_id`),
  KEY `idx_suburb_id` (`suburb_id`),
  KEY `idx_place_intrest_id` (`place_intrest_id`),
  KEY `idx_distance` (`distance`),
  CONSTRAINT `fk_suburb_place_intrest_place_id` FOREIGN KEY (`place_intrest_id`) REFERENCES `place_intrest` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_suburb_place_intrest_suburb_id` FOREIGN KEY (`suburb_id`) REFERENCES `suburb` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `project_place_intrest` (
  `project_id` bigint(20) NOT NULL,
  `place_intrest_id` bigint(20) NOT NULL,
  `distance` double DEFAULT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`project_id`,`place_intrest_id`),
  KEY `idx_project_id` (`project_id`),
  KEY `idx_place_intrest_id` (`place_intrest_id`),
  KEY `idx_distance` (`distance`),
  CONSTRAINT `fk_project_place_intrest_pro_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_place_intrest_pl_id` FOREIGN KEY (`place_intrest_id`) REFERENCES `place_intrest` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `stage_place_intrest` (
  `stage_id` bigint(20) NOT NULL,
  `place_intrest_id` bigint(20) NOT NULL,
  `distance` double DEFAULT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`stage_id`,`place_intrest_id`),
  KEY `idx_stage_id` (`stage_id`),
  KEY `idx_place_id` (`place_intrest_id`),
  KEY `idx_distance` (`distance`),
  CONSTRAINT `fk_stage_place_intrest_place_id` FOREIGN KEY (`place_intrest_id`) REFERENCES `place_intrest` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stage_place_intrest_stage_id` FOREIGN KEY (`stage_id`) REFERENCES `stage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `project_media` (
  `id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `media_id` bigint(20) NOT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_project_id` (`project_id`),
  KEY `idx_media_id` (`media_id`),
  CONSTRAINT `fk_project_media_pro_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_media_media_id` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `floorplan_media` (
  `id` bigint(20) NOT NULL,
  `floorplan_id` bigint(20) NOT NULL,
  `media_id` bigint(20) NOT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_floorplan_id` (`floorplan_id`),
  KEY `idx_media_id` (`media_id`),
  CONSTRAINT `fk_floorplan_media_pro_id` FOREIGN KEY (`floorplan_id`) REFERENCES `floorplan` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_floorplan_media_media_id` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `apartment_media` (
  `id` bigint(20) NOT NULL,
  `apartment_id` bigint(20) NOT NULL,
  `media_id` bigint(20) NOT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_apartment_id` (`apartment_id`),
  KEY `idx_media_id` (`media_id`),
  CONSTRAINT `fk_apartment_media_ap_id` FOREIGN KEY (`apartment_id`) REFERENCES `apartment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_apartment_media_med_id` FOREIGN KEY (`media_id`) REFERENCES `media` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `busroute` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `starting_point` varchar(255) NOT NULL,
  `finishing_point` varchar(255) NOT NULL,
  `starting_time` time NOT NULL,
  `finishing_time` time NOT NULL,
  `description` text DEFAULT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`),
  KEY `idx_starting_point` (`starting_point`),
  KEY `idx_finishing_point` (`finishing_point`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `busroute_polyline` (
  `id` bigint(20) NOT NULL,
  `busroute_id` bigint(20) NOT NULL,
  `longitude` double NOT NULL,
  `latitude` double NOT NULL,
  `seq_num` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_longitude` (`longitude`),
  KEY `idx_latitude` (`latitude`),
  KEY `idx_busroute_id` (`busroute_id`),
  CONSTRAINT `fk_busroute_polyline_busroute_id` FOREIGN KEY (`busroute_id`) REFERENCES `busroute` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `project_busroute` (
  `project_id` bigint(20) NOT NULL,
  `busroute_id` bigint(20) NOT NULL,
  `distance` double DEFAULT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`project_id`,`busroute_id`),
  KEY `idx_project_id` (`project_id`),
  KEY `idx_busroute_id` (`busroute_id`),
  KEY `idx_distance` (`distance`),
  CONSTRAINT `fk_project_busroute_bus_id` FOREIGN KEY (`busroute_id`) REFERENCES `busroute` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_busroute_pro_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `id_generator` (
  `id` bigint(20) NOT NULL,
  `gen_name` varchar(255) NOT NULL,
  `gen_value` bigint(20) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_gen_name` (`gen_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
