ALTER TABLE project_media ADD COLUMN seq_num Integer;
CREATE TABLE app_version (version text(255));
INSERT INTO app_version (version) values ('1.0.0');