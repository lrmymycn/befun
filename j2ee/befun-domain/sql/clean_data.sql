TRUNCATE TABLE id_generator;
TRUNCATE TABLE project_busroute;
TRUNCATE TABLE busroute_polyline;
TRUNCATE TABLE busroute;
TRUNCATE TABLE apartment_media;
TRUNCATE TABLE floorplan_media;
TRUNCATE TABLE project_media;
TRUNCATE TABLE stage_place_intrest;
TRUNCATE TABLE project_place_intrest;
TRUNCATE TABLE suburb_place_intrest;
TRUNCATE TABLE place_intrest;
TRUNCATE TABLE apartment_comment;
TRUNCATE TABLE apartment;
TRUNCATE TABLE floorplan_comment;
TRUNCATE TABLE floorplan;
TRUNCATE TABLE building_comment;
TRUNCATE TABLE building;
TRUNCATE TABLE stage_comment;
TRUNCATE TABLE stage;
TRUNCATE TABLE project_comment;
TRUNCATE TABLE project;
TRUNCATE TABLE suburb_polyline;
TRUNCATE TABLE suburb_comment;
TRUNCATE TABLE suburb;
TRUNCATE TABLE area_polyline;
TRUNCATE TABLE area_comment;
TRUNCATE TABLE area;
TRUNCATE TABLE comment_rec;
TRUNCATE TABLE media;
TRUNCATE TABLE profile_department;
TRUNCATE TABLE department;
TRUNCATE TABLE role_permission;
TRUNCATE TABLE permission;
TRUNCATE TABLE profile_role;
TRUNCATE TABLE role;
TRUNCATE TABLE client;
TRUNCATE TABLE profile;
--
-- profile
DELETE FROM profile_role;
DELETE FROM role;
DELETE FROM suburb_interest_list_item;
DELETE FROM project_interest_list_item;
DELETE FROM floorplan_interest_list_item;
DELETE FROM apartment_interest_list_item;
DELETE FROM interest_list;
DELETE FROM client_preference;
DELETE FROM employee_client;
DELETE FROM client;
DELETE FROM employee;
DELETE FROM profile;
