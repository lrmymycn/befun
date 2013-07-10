CREATE TABLE IF NOT EXISTS `profile` (
  `id` bigint(20) NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-GENERAL, 1-EMPLOYEE, 2-SALE, 3-MANAGER, 4-CLIENT, 5-REFERRAL',
  `username` varchar(50) NOT NULL,
  `password` varchar(255) DEFAULT NULL COMMENT '密码应该是经过单向散列算法加密过的，不可逆',
  `enabled` tinyint(1) NOT NULL DEFAULT 1,
  `expired` tinyint(1) NOT NULL DEFAULT 0,
  `credentials_expired` tinyint(1) NOT NULL DEFAULT 0,
  `locked` tinyint(1) NOT NULL DEFAULT 0,
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-male, 1-female, 2-other',
  `surname` varchar(45) DEFAULT NULL,
  `given_name` varchar(45) DEFAULT NULL,
  `preferred_name` varchar(45) DEFAULT NULL,
  `mobile_number` varchar(45) DEFAULT NULL,
  `mobile_number1` varchar(45) DEFAULT NULL,
  `other_number` varchar(45) DEFAULT NULL,
  `home_phone` varchar(45) DEFAULT NULL,
  `home_address` varchar(200) DEFAULT NULL,
  `home_postcode` varchar(20) DEFAULT NULL,
  `mail_address` varchar(200) DEFAULT NULL,
  `mail_postcode` varchar(20) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `creation_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_username` (`username`),
  KEY `idx_enabled` (`enabled`) USING BTREE,
  KEY `idx_expired` (`expired`) USING BTREE,
  KEY `idx_credentials_expired` (`credentials_expired`) USING BTREE,
  KEY `idx_locked` (`locked`) USING BTREE,
  KEY `idx_gender` (`gender`) USING BTREE,
  KEY `idx_surname` (`surname`),
  KEY `idx_given_name` (`given_name`),
  KEY `idx_preferred_name` (`preferred_name`),
  KEY `idx_mobile_number` (`mobile_number`),
  KEY `idx_mobile_number1` (`mobile_number1`),
  KEY `idx_other_number` (`other_number`),
  KEY `idx_home_phone` (`home_phone`),
  KEY `idx_home_postcode` (`home_postcode`),
  KEY `idx_mail_postcode` (`mail_postcode`),
  KEY `idx_email` (`email`),
  KEY `idx_creation_date` (`creation_date`),
  KEY `idx_last_modified_date` (`last_modified_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `employee` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NULL ,
  `title_desc` text NULL ,
  `rank` tinyint(4) NOT NULL DEFAULT '0',
  `employee_number` varchar(255) DEFAULT NULL,
  `abn` varchar(50) DEFAULT NULL,
  `gst` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_employee_number` (`employee_number`),
  CONSTRAINT `fk_sale_id` FOREIGN KEY (`id`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `client_preference` (
  `id` bigint(20) NOT NULL,
  `floorplan_type` varchar(255) NULL,
  `area` varchar(255) NULL,
  `distance_to_city` varchar(255) NULL,
  `bedroom` varchar(255) NULL,
  `bathroom` varchar(255) NULL,
  `studyroom` varchar(255) NULL,
  `price_range` varchar(255) NULL,
  `ready_house` varchar(255) NULL,
  `trains` varchar(255) NULL,
  `shopping_centres` varchar(255) NULL,
  `schools` varchar(255) NULL,
  `water_view` varchar(255) NULL,
  `city_view` varchar(255) NULL,
  `high_quality_finish` varchar(255) NULL,
  `luxury` varchar(255) NULL,
  `good_live_env` varchar(255) NULL,
  `description` varchar(255) NULL,
  `creation_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_creation_date` (`creation_date`),
  KEY `idx_last_modified_date` (`last_modified_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `client` (
  `id` bigint(20) NOT NULL,
  `current_employee` bigint(20) DEFAULT NULL,
  `title` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'MR, MRS, MS, DR',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'PR/Citizen, Overseas investor, Student',
  `language` varchar(50) DEFAULT NULL,
  `national` varchar(50) DEFAULT NULL,
  `purchase_type_first` tinyint(1) DEFAULT '0',
  `purchase_type_owner` tinyint(1) DEFAULT '0',
  `purchase_type_inverstor` tinyint(1) DEFAULT '0',
  `purchase_type_student` tinyint(1) DEFAULT '0',
  `purchase_type_other` tinyint(1) DEFAULT '0',
  `purchase_type_1` tinyint(1) DEFAULT '0',
  `purchase_type_2` tinyint(1) DEFAULT '0',
  `purchase_type_3` tinyint(1) DEFAULT '0',
  `purchase_type_4` tinyint(1) DEFAULT '0',
  `last_active_date` datetime NOT NULL,
  `client_preference_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_status` (`status`) USING BTREE,
  KEY `idx_current_employee` (`current_employee`),
  KEY `idx_pc_type_first` (`purchase_type_first`) USING BTREE,
  KEY `idx_pc_type_owner` (`purchase_type_owner`) USING BTREE,
  KEY `idx_pc_type_inverstor` (`purchase_type_inverstor`) USING BTREE,
  KEY `idx_pc_type_student` (`purchase_type_student`) USING BTREE,
  KEY `idx_pc_type_other` (`purchase_type_other`) USING BTREE,
  KEY `idx_last_active_date` (`last_active_date`),
  KEY `idx_pref_id` (`client_preference_id`),
  CONSTRAINT `fk_client_id` FOREIGN KEY (`id`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_pref_id` FOREIGN KEY (`client_preference_id`) REFERENCES `client_preference` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `client_requirement` (
  `id` bigint(20) NOT NULL,
  `client_id` bigint(20) NOT NULL,
  `min_price` int(11) DEFAULT NULL,
  `max_price` int(11) DEFAULT NULL,
  `penthouse` tinyint(1) DEFAULT NULL,
  `car_parking_count_str` varchar(50) DEFAULT NULL,
  `storageroom_count_str` varchar(50) DEFAULT NULL,
  `bedroom_count_str` varchar(50) DEFAULT NULL,
  `bathroom_count_str` varchar(50) DEFAULT NULL,
  `studyroom_count_str` varchar(50) DEFAULT NULL,
  `courtyard_count_str` varchar(50) DEFAULT NULL,
  `enclosed_baclony_count_str` varchar(50) DEFAULT NULL,
  `floorplan_type_str` varchar(50) DEFAULT NULL,
  `min_total_size`  double DEFAULT NULL,
  `max_total_size`  double DEFAULT NULL,
  `is_split` tinyint(1) DEFAULT NULL,
  `is_studio` tinyint(1) DEFAULT NULL,
  `orientation_str` varchar(50) DEFAULT NULL,
  `ready_house` tinyint(1) DEFAULT NULL,
  `suburb_id` bigint(20) DEFAULT NULL,
  `distance_to_city`  double DEFAULT NULL,
  `universities` tinyint(1) DEFAULT NULL,
  `schools` tinyint(1) DEFAULT NULL,
  `shopping_center` tinyint(1) DEFAULT NULL,
  `train` tinyint(1) DEFAULT NULL,
  `chinese_community` tinyint(1) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `creation_date` datetime NOT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_client_id` (`client_id`),
  CONSTRAINT `fk_client_req_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `employee_client` (
  `id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  `client_id` bigint(20) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `description` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_employee_id` (`employee_id`),
  KEY `idx_client_id` (`client_id`),
  KEY `idx_start_date` (`start_date`),
  KEY `idx_end_date` (`end_date`),
  CONSTRAINT `fk_interest_list_ep_id` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_interest_list_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `interest_list` (
  `id` bigint(20) NOT NULL,
  `client_id` bigint(20) NOT NULL,
  `name` varchar(255) NULL,
  `description` text DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_client_id` (`client_id`),
  KEY `idx_creation_date` (`creation_date`),
  KEY `idx_last_modified_date` (`last_modified_date`),
  CONSTRAINT `fk_interest_list_c_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `apartment_interest_list_item` (
  `id` bigint(20) NOT NULL,
  `interest_list_id` bigint(20) NOT NULL,
  `apartment_id` bigint(20) NOT NULL,
  `description` text DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_interest_list_id` (`interest_list_id`),
  KEY `idx_apartment_id` (`apartment_id`),
  KEY `idx_creation_date` (`creation_date`),
  KEY `idx_last_modified_date` (`last_modified_date`),
  CONSTRAINT `fk_ap_interest_list_id` FOREIGN KEY (`interest_list_id`) REFERENCES `interest_list` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `floorplan_interest_list_item` (
  `id` bigint(20) NOT NULL,
  `interest_list_id` bigint(20) NOT NULL,
  `floorplan_id` bigint(20) NOT NULL,
  `description` text DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_interest_list_id` (`interest_list_id`),
  KEY `idx_floorplan_id` (`floorplan_id`),
  KEY `idx_creation_date` (`creation_date`),
  KEY `idx_last_modified_date` (`last_modified_date`),
  CONSTRAINT `fk_fp_interest_list_id` FOREIGN KEY (`interest_list_id`) REFERENCES `interest_list` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `project_interest_list_item` (
  `id` bigint(20) NOT NULL,
  `interest_list_id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `description` text DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_interest_list_id` (`interest_list_id`),
  KEY `idx_project_id` (`project_id`),
  KEY `idx_creation_date` (`creation_date`),
  KEY `idx_last_modified_date` (`last_modified_date`),
  CONSTRAINT `fk_pro_interest_list_id` FOREIGN KEY (`interest_list_id`) REFERENCES `interest_list` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `suburb_interest_list_item` (
  `id` bigint(20) NOT NULL,
  `interest_list_id` bigint(20) NOT NULL,
  `suburb_id` bigint(20) NOT NULL,
  `description` text DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_interest_list_id` (`interest_list_id`),
  KEY `idx_suburb_id` (`suburb_id`),
  KEY `idx_creation_date` (`creation_date`),
  KEY `idx_last_modified_date` (`last_modified_date`),
  CONSTRAINT `fk_s_interest_list_id` FOREIGN KEY (`interest_list_id`) REFERENCES `interest_list` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` tinyint(4) NOT NULL,
  `description` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`),
  KEY `idx_code` (`code`)
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
  `description` text DEFAULT NULL,
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
  CONSTRAINT `fk_profile_dep_pro_id` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_dep_dp_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `media` (
  `id` bigint(20) NOT NULL,
  `bid` varchar(255) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `project_bid` varchar(255) DEFAULT NULL,
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
  KEY `idx_project_id` (`project_id`),
  KEY `idx_project_bid` (`project_bid`),
  KEY `idx_name` (`name`),
  KEY `idx_media_type` (`media_type`) USING BTREE,
  KEY `idx_content_type` (`content_type`) USING BTREE,
  KEY `idx_enabled` (`enabled`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `comment_rec` (
  `id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `profile_id` bigint(20) DEFAULT NULL,
  `guest_name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` TEXT DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 0,
  `enabled_date` datetime DEFAULT NULL,
  `enabled_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_parent_id` (`parent_id`),
  KEY `idx_profile_id` (`profile_id`),
  KEY `idx_enabled` (`enabled`) USING BTREE,
  KEY `idx_enabled_by` (`enabled_by`),
  CONSTRAINT `fk_pcomment_parent_id` FOREIGN KEY (`parent_id`) REFERENCES `comment_rec` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
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
  `rank` int(11) DEFAULT NULL,
  `picture_id` bigint(20) DEFAULT NULL,
  `logo_id` bigint(20) DEFAULT NULL,
  `short_description` varchar(500) DEFAULT NULL,
  `type` varchar(500) DEFAULT NULL,
  `price_range` varchar(500) DEFAULT NULL,
  `stage_count` int(11) DEFAULT 1,
  `building_count` int(11) DEFAULT 1,
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
  KEY `idx_suburb_id` (`suburb_id`) USING BTREE,
  KEY `idx_name` (`name`),
  KEY `idx_developer` (`developer`),
  KEY `idx_address` (`address`(255)),
  KEY `idx_postcode` (`postcode`),
  KEY `idx_longitude` (`longitude`),
  KEY `idx_latitude` (`latitude`),
  KEY `idx_distancetocity` (`distance_to_city`),
  KEY `idx_enabled` (`enabled`) USING BTREE,
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
  KEY `idx_enabled` (`enabled`) USING BTREE,
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
  `orientation_east` tinyint(1) NULL DEFAULT 0,
  `orientation_south` tinyint(1) NULL DEFAULT 0,
  `orientation_west` tinyint(1) NULL DEFAULT 0,
  `orientation_north` tinyint(1) NULL DEFAULT 0,
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
  KEY `idx_orientation_east` (`orientation_east`) USING BTREE,
  KEY `idx_orientation_south` (`orientation_south`) USING BTREE,
  KEY `idx_orientation_west` (`orientation_west`) USING BTREE,
  KEY `idx_orientation_north` (`orientation_north`) USING BTREE,
  KEY `idx_ready_house` (`ready_house`) USING BTREE,
  KEY `idx_enabled` (`enabled`) USING BTREE,
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
  `orientation_east` tinyint(1) NULL DEFAULT 0,
  `orientation_south` tinyint(1) NULL DEFAULT 0,
  `orientation_west` tinyint(1) NULL DEFAULT 0,
  `orientation_north` tinyint(1) NULL DEFAULT 0,
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
  KEY `idx_type` (`type`) USING BTREE,
  KEY `idx_bedroom_count` (`bedroom_count`) USING BTREE,
  KEY `idx_bathroom_count` (`bathroom_count`) USING BTREE,
  KEY `idx_studyroom_count` (`studyroom_count`) USING BTREE,
  KEY `idx_open_baclony_count` (`open_baclony_count`) USING BTREE,
  KEY `idx_enclosed_baclony_count` (`enclosed_baclony_count`) USING BTREE,
  KEY `idx_courtyard_count` (`courtyard_count`) USING BTREE,
  KEY `idx_orientation_east` (`orientation_east`) USING BTREE,
  KEY `idx_orientation_south` (`orientation_south`) USING BTREE,
  KEY `idx_orientation_west` (`orientation_west`) USING BTREE,
  KEY `idx_orientation_north` (`orientation_north`) USING BTREE,
  KEY `idx_min_price` (`min_price`),
  KEY `idx_max_price` (`max_price`),
  KEY `idx_internal_size` (`internal_size`),
  KEY `idx_external_size` (`external_size`),
  KEY `idx_total_size` (`total_size`),
  KEY `idx_land_size` (`land_size`),
  KEY `idx_enabled` (`enabled`) USING BTREE,
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
  KEY `idx_unit_number` (`unit_number`),
  KEY `idx_lot_number` (`lot_number`),
  KEY `idx_penthouse` (`penthouse`),
  KEY `idx_car_parking_count` (`car_parking_count`) USING BTREE,
  KEY `idx_storageroom_count` (`storageroom_count`) USING BTREE,
  KEY `idx_sold_out` (`sold_out`) USING BTREE,
  KEY `idx_enabled` (`enabled`) USING BTREE,
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
  KEY `idx_enabled` (`enabled`) USING BTREE
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
  KEY `idx_enabled` (`enabled`) USING BTREE,
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
  KEY `idx_enabled` (`enabled`) USING BTREE,
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
  KEY `idx_enabled` (`enabled`) USING BTREE,
  CONSTRAINT `fk_stage_place_intrest_place_id` FOREIGN KEY (`place_intrest_id`) REFERENCES `place_intrest` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_stage_place_intrest_stage_id` FOREIGN KEY (`stage_id`) REFERENCES `stage` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `project_media` (
  `id` bigint(20) NOT NULL,
  `project_id` bigint(20) NOT NULL,
  `media_id` bigint(20) NOT NULL,
  `seq_num` int(11) DEFAULT NULL,
  `removed` tinyint(1) DEFAULT 0,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_project_id` (`project_id`),
  KEY `idx_media_id` (`media_id`),
  KEY `idx_enabled` (`enabled`) USING BTREE,
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
  KEY `idx_enabled` (`enabled`) USING BTREE,
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
  KEY `idx_enabled` (`enabled`) USING BTREE,
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
  KEY `idx_finishing_point` (`finishing_point`),
  KEY `idx_enabled` (`enabled`) USING BTREE
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
  KEY `idx_enabled` (`enabled`) USING BTREE,
  CONSTRAINT `fk_project_busroute_bus_id` FOREIGN KEY (`busroute_id`) REFERENCES `busroute` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_busroute_pro_id` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE IF NOT EXISTS `id_generator` (
  `id` bigint(20) NOT NULL,
  `gen_name` varchar(255) NOT NULL,
  `gen_value` bigint(20) DEFAULT 1,
  PRIMARY KEY (`id`),
  KEY `idx_gen_name` (`gen_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
