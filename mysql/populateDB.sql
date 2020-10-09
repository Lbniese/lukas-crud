USE `lukas-crud-1`;

DELETE FROM assignment where id > 0;
ALTER TABLE assignment AUTO_INCREMENT = 1;

INSERT INTO assignment(name, description)
values
('Web Server', 'Create Web Server'),
('MySQL Server', 'Create MySQL Server');