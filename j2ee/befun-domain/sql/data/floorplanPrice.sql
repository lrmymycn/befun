SET SQL_SAFE_UPDATES=0;
-- 更新floorplan的价格区间
UPDATE floorplan fp 
	SET min_price = (SELECT min(ap.price)-20000 FROM apartment ap WHERE ap.floorplan_id = fp.id AND ap.enabled = 1 AND ap.price > 0),
		max_price = (SELECT max(ap.price)+20000 FROM apartment ap WHERE ap.floorplan_id = fp.id AND ap.enabled = 1 AND ap.price > 0);