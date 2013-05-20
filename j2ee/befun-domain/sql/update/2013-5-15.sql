ALTER TABLE `media` ADD COLUMN `project_id` bigint(20) DEFAULT NULL;
ALTER TABLE `media` ADD KEY `idx_project_id` (`project_id`);

ALTER TABLE `media` ADD COLUMN `project_bid` varchar(255) DEFAULT NULL;
ALTER TABLE `media` ADD KEY `idx_project_bid` (`project_bid`);

UPDATE media m SET m.project_id = (
	SELECT distinct(p.id) FROM project p WHERE p.picture_id = m.id OR p.logo_id = m.id
	)
	WHERE EXISTS (
		SELECT 1 FROM project p WHERE (p.picture_id = m.id OR p.logo_id = m.id) AND p.id IS NOT NULL
	);

UPDATE media m SET m.project_bid = (
	SELECT distinct(p.bid) FROM project p WHERE p.picture_id = m.id OR p.logo_id = m.id
	)
	WHERE EXISTS (
		SELECT 1 FROM project p WHERE (p.picture_id = m.id OR p.logo_id = m.id) AND p.id IS NOT NULL
	);

UPDATE media m SET m.project_id = (
	SELECT distinct(pm.project_id) FROM project_media pm WHERE pm.media_id = m.id
	)
	WHERE EXISTS (
		SELECT 1 FROM project_media pm WHERE pm.media_id = m.id AND pm.project_ID IS NOT NULL
	);

UPDATE media m SET m.project_bid = (
	SELECT distinct(p.bid) FROM project_media pm LEFT JOIN project p ON pm.project_id = p.id
		WHERE pm.media_id = m.id AND pm.project_id IS NOT NULL
	)
	WHERE EXISTS (
		SELECT 1 FROM project_media pm WHERE pm.media_id = m.id AND pm.project_ID IS NOT NULL
	);

UPDATE media m SET m.project_id = (
	SELECT distinct(p.id) FROM floorplan fp 
		LEFT JOIN building b ON fp.building_id = b.id
		LEFT JOIN stage st ON b.stage_id = st.id
		LEFT JOIN project p ON st.project_id = p.id
		WHERE (fp.public_picture_id = m.id OR fp.sale_picture_id = m.id) AND p.id IS NOT NULL
	)
	WHERE EXISTS (
		SELECT 1 FROM floorplan fp WHERE fp.public_picture_id = m.id OR fp.sale_picture_id = m.id
	);

UPDATE media m SET m.project_bid = (
	SELECT distinct(p.bid) FROM floorplan fp 
		LEFT JOIN building b ON fp.building_id = b.id
		LEFT JOIN stage st ON b.stage_id = st.id
		LEFT JOIN project p ON st.project_id = p.id
		WHERE (fp.public_picture_id = m.id OR fp.sale_picture_id = m.id) AND p.id IS NOT NULL
	)
	WHERE EXISTS (
		SELECT 1 FROM floorplan fp WHERE fp.public_picture_id = m.id OR fp.sale_picture_id = m.id
	);

