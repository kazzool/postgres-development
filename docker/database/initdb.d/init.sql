-- Create a user for the flyway and grant permissions.
CREATE USER 'flyway'@'%' IDENTIFIED BY 'flyway';
GRANT ALL ON sample_db.* TO 'flyway'@'%';
FLUSH PRIVILEGES;