-- Create a user for the flyway and grant permissions.
CREATE USER 'flywayuser'@'localhost' IDENTIFIED BY 'flywaypass';
GRANT ALL ON sample_db.* TO 'flywayuser'@'localhost';
FLUSH PRIVILEGES;