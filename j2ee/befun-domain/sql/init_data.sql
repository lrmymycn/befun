INSERT INTO profile (USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, ID) 
	VALUES ('admin', 'admin','admin','742b1a515e013826c17b9ba8e08a846ba60648976863dbd7a487e7905b417060b5de8c0e9a8a0521',-1);
INSERT INTO profile (USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, ID) 
	VALUES ('jadey', 'jade','yang','742b1a515e013826c17b9ba8e08a846ba60648976863dbd7a487e7905b417060b5de8c0e9a8a0521',-2);
INSERT INTO profile (USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, ID) 
	VALUES ('orion','orion','orion','742b1a515e013826c17b9ba8e08a846ba60648976863dbd7a487e7905b417060b5de8c0e9a8a0521',-3);
INSERT INTO profile (USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, ID) 
	VALUES ('huishan','huishan','huishan','742b1a515e013826c17b9ba8e08a846ba60648976863dbd7a487e7905b417060b5de8c0e9a8a0521',-4);
INSERT INTO profile (USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, ID) 
	VALUES ('testDataAdmin','tda','tda','3329a45c2ab54792f05577cea1caf2e6ab448bde732c246e7d990575a3a0f4f3dd207857c342dd27',-10);
INSERT INTO profile (USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, ID) 
	VALUES ('testSale','tda','tda','7cafc01b63e22b0106b2e97849af24b422490617732cc0e5e19896934059f1f1d3b639c08c3d8189',-11);
INSERT INTO profile (USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, ID) 
	VALUES ('testCustomer','tda','tda','7c67d12ba3e02e40b06c555dcfb3617728022d43504fb9c80366c8b72f87586624a6a902510e9800',-12);
INSERT INTO profile (USERNAME, FIRST_NAME, LAST_NAME, PASSWORD, ID) 
	VALUES ('testPublic','tda','tda','401640c39ce08c3cfb867feda6097de2fbdcaa078328f0fd26e4e77c3cfb88f1980c7e006c0c4b8a',-13);


INSERT INTO role (id, name) VALUES (-1, 'SUPER');
INSERT INTO role (id, name) VALUES (-2, 'DATA_ADMIN');
INSERT INTO role (id, name) VALUES (-3, 'SALE');
INSERT INTO role (id, name) VALUES (-4, 'CUSTOMER');
INSERT INTO role (id, name) VALUES (-5, 'PUBLIC');

INSERT INTO profile_role (id, profile_id, role_id) VALUES (-1,-1,-1);
INSERT INTO profile_role (id, profile_id, role_id) VALUES (-2,-2,-1);
INSERT INTO profile_role (id, profile_id, role_id) VALUES (-3,-3,-1);
INSERT INTO profile_role (id, profile_id, role_id) VALUES (-4,-4,-1);
INSERT INTO profile_role (id, profile_id, role_id) VALUES (-5,-10,-2);
INSERT INTO profile_role (id, profile_id, role_id) VALUES (-6,-11,-3);
INSERT INTO profile_role (id, profile_id, role_id) VALUES (-7,-12,-4);
INSERT INTO profile_role (id, profile_id, role_id) VALUES (-8,-13,-5);

INSERT INTO area (id,name,description,longitude,latitude,enabled)
    VALUES (-1, 'City', 'City Desc', 0, 0, 0);
INSERT INTO suburb (id,area_id,name,postcode,description,longitude,latitude,enabled)
    VALUES (-1, -1, 'test_suburb name', 'test_suburb postcode', 'test_suburb desc', 0, 0, 0);
INSERT INTO area (id,name,description,latitude,longitude) VALUES (-2, 'City', 'City desc', -33.874365, 151.206638);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-11, -2, -33.854638, 151.198348,  0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-12, -2, -33.852614, 151.212285,  1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-13, -2, -33.857721, 151.226367,  2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-14, -2, -33.869565, 151.219853,  3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-15, -2, -33.89198,  151.216942, 4);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-16, -2, -33.888809, 151.200277,  5);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-17, -2, -33.874308, 151.190597,  6);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-18, -2, -33.869956, 151.184841,  7);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-19, -2, -33.869686, 151.185285,  8);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-20, -2, -33.862223, 151.189833,  9);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-21, -2, -33.861437, 151.197911,  10);



INSERT INTO area (id,name,description,latitude,longitude) VALUES (-3, 'East', 'East desc', -33.920722, 151.237293);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-111, -3,  -33.857721,151.226367,  0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-112, -3,  -33.869565,151.219853,  1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-113, -3,  -33.89198, 151.216942, 2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-114, -3,  -33.888809,151.200277,  3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-115, -3,  -33.925524,151.181964,  4);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-116, -3,  -33.933846,151.162154,  5);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-117, -3,  -33.972629,151.174276,  6);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-118, -3,  -34.008025,151.248766,  7);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-119, -3,  -33.993849,151.268396,  8);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-120, -3,  -33.850671,151.299947,  9);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-121, -3,  -33.831549,151.280323,  10);



INSERT INTO area (id,name,description,latitude,longitude) VALUES (-4,'Inner West', 'Inner West desc', -33.885514, 151.142734);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-211, -4, -33.821286, 151.085833, 0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-212, -4, -33.846803, 151.134465, 1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-213, -4, -33.840129, 151.152796, 2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-214, -4, -33.85014,  151.16937,  3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-215, -4, -33.844995, 151.184855, 4);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-216, -4, -33.854638, 151.198348, 5);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-217, -4, -33.861437, 151.197911, 6);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-218, -4, -33.862223, 151.189833, 7);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-219, -4, -33.869956, 151.184841, 8);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-220, -4, -33.874308, 151.190597, 9);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-221, -4, -33.888809, 151.200277, 10);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-222, -4, -33.925524, 151.181964, 11);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-223, -4, -33.933846, 151.162154, 12);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-224, -4, -33.908319, 151.076055, 13);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-225, -4, -33.864454, 151.088699, 14);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-226, -4, -33.831517, 151.080401, 15);



INSERT INTO area (id,name,description,latitude,longitude) VALUES (-5,'South West', 'South West desc', -33.961546, 151.112654);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-311, -5, -33.908319, 151.076055, 0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-312, -5, -33.933846, 151.162154, 1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-313, -5, -33.972629, 151.174276, 2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-314, -5, -34.01114,  151.137249, 3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-315, -5, -33.982269, 151.038364, 4);



INSERT INTO area (id,name,description,latitude,longitude) VALUES (-6, 'South Coast', 'South Coast desc', -34.034825, 151.117127);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-411, -6, -33.982269, 151.028264, 0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-412, -6, -34.01114,  151.137249, 1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-413, -6, -33.972629, 151.174276, 2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-414, -6, -34.008025, 151.248766, 3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-415, -6, -34.077888, 151.234116, 4);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-416, -6, -34.077888, 150.998905, 5);



INSERT INTO area (id,name,description,latitude,longitude) VALUES (-7, 'West', 'West desc', -33.898299, 151.029235);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-511, -7, -33.822071, 150.985563, 0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-512, -7, -33.829282, 150.997872, 1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-513, -7, -33.825735, 151.016639, 2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-514, -7, -33.828816, 151.016639, 3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-515, -7, -33.818816, 151.027762, 4);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-516, -7, -33.821286, 151.085833, 5);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-517, -7, -33.831517, 151.080401, 6);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-518, -7, -33.864454, 151.088699, 7);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-519, -7, -33.908319, 151.076055, 8);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-520, -7, -33.982269, 151.038364, 9);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-521, -7, -33.982269, 150.988429, 10);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-522, -7, -33.892938, 150.972874, 11);



INSERT INTO area (id,name,description,latitude,longitude) VALUES (-8, 'North West', 'North West desc', -33.733129, 151.01072);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-611, -8, -33.663477, 150.874518, 0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-612, -8, -33.663477, 151.104792, 1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-613, -8, -33.74082,  151.062326, 2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-614, -8, -33.821286, 151.085833, 3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-615, -8, -33.818816, 151.027762, 4);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-616, -8, -33.803996, 151.030267, 5);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-617, -8, -33.803413, 150.99269,  6);



INSERT INTO area (id,name,description,latitude,longitude) VALUES (-9, 'North', 'North desc', -33.745085, 151.142261);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-711, -9, -33.663477, 151.104792, 0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-712, -9, -33.663477, 151.204096, 1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-713, -9, -33.773144, 151.204096, 2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-714, -9, -33.773144, 151.167062, 3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-715, -9, -33.806117, 151.142305, 4);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-716, -9, -33.840129, 151.152796, 5);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-717, -9, -33.846803, 151.134465, 6);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-718, -9, -33.821286, 151.085833, 7);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-719, -9, -33.74082,  151.062326, 8);



INSERT INTO area (id,name,description,latitude,longitude) VALUES (-10, 'Lower North Shore', 'Lower North Shore desc', -33.816546, 151.200992);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-811, -10, -33.773144, 151.167062, 0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-812, -10, -33.773144, 151.204096, 1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-813, -10, -33.833885, 151.280323, 2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-814, -10, -33.857721, 151.226367, 3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-815, -10, -33.852614, 151.212285, 4);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-816, -10, -33.854638, 151.198348, 5);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-817, -10, -33.844995, 151.184855, 6);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-818, -10, -33.85014,  151.16937,   7);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-819, -10, -33.840129, 151.152796, 8);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-820, -10, -33.806117, 151.142305, 9);



INSERT INTO area (id,name,description,latitude,longitude) VALUES (-11, 'North Coast', 'North Coast desc', -33.746939, 151.256586);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-911, -11, -33.663477, 151.204096, 0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-912, -11, -33.663477, 151.330326, 1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-913, -11, -33.812491, 151.330326, 2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-914, -11, -33.831549, 151.280323, 3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-915, -11, -33.773144, 151.204096, 4);


INSERT INTO area (id,name,description,latitude,longitude) VALUES (-12, 'Parramatta CBD', 'Parramatta CBD desc', -33.815684, 151.005888);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1011, -12, -33.803413, 150.99269,  0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1012, -12, -33.803996, 151.030267, 1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1013, -12, -33.818816, 151.027762, 2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1014, -12, -33.818816, 151.016639, 3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1015, -12, -33.825735, 151.016639, 4);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1016, -12, -33.829282, 150.997872, 5);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1017, -12, -33.822071, 150.985563, 6);



INSERT INTO area (id,name,description,latitude,longitude) VALUES (-13, 'Greater West', 'Greater West desc', -33.846073, 150.899711);

INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1111, -13, -33.663477, 150.850521, 0);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1112, -13, -33.663477, 150.874518, 1);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1113, -13, -33.803413, 150.99269,  2);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1114, -13, -33.822071, 150.985563, 3);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1115, -13, -33.892938, 150.972874, 4);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1116, -13, -33.982269, 150.988429, 5);
INSERT INTO area_polyline (id,area_id,latitude,longitude,seq_num) VALUES (-1117, -13, -33.982269, 150.850521, 6);

INSERT INTO suburb (id,area_id,name,description,master_plan,postcode,latitude,longitude,
	universities,schools,shopping_center,train,chinese_community)
	VALUES (-2,-3,'Zetland','Zetland desc','1','2017',-33.905547,151.206502,
			1,0,1,1,0);
INSERT INTO suburb (id,area_id,name,description,master_plan,postcode,latitude,longitude,
	universities,schools,shopping_center,train,chinese_community)
	VALUES (-3,-4,'Rhodes','Rhodes desc','1','2138',-33.896067,151.200113,
			0,0,1,1,0);
INSERT INTO suburb (id,area_id,name,description,master_plan,postcode,latitude,longitude,
	universities,schools,shopping_center,train,chinese_community)
	VALUES (-4,-9,'Macquarie Park','Macquarie Park desc','1','2113',-33.775438,151.119261,
			1,1,1,1,0);
INSERT INTO suburb (id,area_id,name,description,master_plan,postcode,latitude,longitude,
	universities,schools,shopping_center,train,chinese_community)
	VALUES (-5,-1,'Brisbane','Brisbane desc','1','4000',-27.470963,153.023586,
			0,0,1,1,0);
INSERT INTO suburb (id,area_id,name,description,master_plan,postcode,latitude,longitude,
	universities,schools,shopping_center,train,chinese_community)
	VALUES (-6,-3,'Waterloo','Waterloo desc','1','2017',-33.896067,151.200113,
			0,0,1,0,0);
INSERT INTO suburb (id,area_id,name,description,master_plan,postcode,latitude,longitude,
	universities,schools,shopping_center,train,chinese_community)
	VALUES (-7,-11,'Warriewood','Warriewood desc','1','2102',-33.696637,151.295729,
			0,0,1,0,0);
INSERT INTO suburb (id,area_id,name,description,master_plan,postcode,latitude,longitude,
	universities,schools,shopping_center,train,chinese_community)
	VALUES (-8,-9,'Epping','Epping desc','1','2121',-33.772441,151.081238,
			1,1,0,1,1);
INSERT INTO suburb (id,area_id,name,description,master_plan,postcode,latitude,longitude,
	universities,schools,shopping_center,train,chinese_community)
	VALUES (-9,-9,'St Ives','St Ives desc','1','2075',-33.729337,151.160889,
			0,1,1,0,0);
INSERT INTO suburb (id,area_id,name,description,master_plan,postcode,latitude,longitude,
	universities,schools,shopping_center,train,chinese_community)
	VALUES (-10,-6,'Sylvania','Sylvania desc','1','2224',-34.011973,151.09437,
			0,0,1,0,0);