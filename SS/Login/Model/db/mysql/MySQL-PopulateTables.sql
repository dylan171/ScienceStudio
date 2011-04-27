-- ----------------- Populate Core-schema tables ---------------------------------
--	Copyright (c) Canadian Light Source, Inc. All rights reserved.
--	- see license.txt for details.
--	
--	Description:
--		MySQL-PopulateTables sql file.
--

use scstudio;

-- --------------------- Default Login Roles --------------------------------
insert into scstudio.login_role (name) values ('EVERYBODY'); 		-- id: 1
insert into scstudio.login_role (name) values ('ADMIN_PROJECTS'); 	-- id: 2
insert into scstudio.login_role (name) values ('ADMIN_VESPERS'); -- id: 3

-- --------------------- Default Login Groups --------------------------------
insert into scstudio.login_group (name) values ('EVERYBODY'); 		-- id: 1
insert into scstudio.login_group (name) values ('ADMINISTRATORS'); 	-- id: 2

-- ----------------------- Default Login Group Roles ----------------------------------
insert into scstudio.login_group_role (login_role_id, login_group_id) values (1, 1); -- id: 1
insert into scstudio.login_group_role (login_role_id, login_group_id) values (2, 2); -- id: 2
insert into scstudio.login_group_role (login_role_id, login_group_id) values (3, 2); -- id: 3