ALTER TABLE project_media ADD COLUMN media_type BYTE;
UPDATE project_media SET media_type = 7;
ALTER TABLE project_media ALTER COLUMN media_type BYTE NOT NULL;