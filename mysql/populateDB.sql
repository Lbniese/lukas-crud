USE `lukas-crud-1`;

DELETE FROM Assignment where id > 0;
ALTER TABLE Assignment AUTO_INCREMENT = 1;

INSERT INTO Assignment(name, description)
values
('Web Server', 'Create Web Server'),
('MySQL Server', 'Create MySQL Server');