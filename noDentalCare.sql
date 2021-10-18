/*
Yuriko Uchida
#200448500
21F Adv Object Oriented Prog-Java - 01 (COMP1011)
*/

-- DROP USER 'student'@'localhost';

-- Create a new username ("student") with its password ("student")
CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';
GRANT ALL PRIVILEGES ON * . * TO 'student'@'localhost';

-- Create a new database and use it
CREATE DATABASE javaProjects;
USE javaProjects;


-- DROP TABLE IF EXISTS noDentalCares;
-- Create new tables
CREATE TABLE noDentalCares(
	noDentalCaresId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ageGroup VARCHAR(20),
    sex VARCHAR(10),
    race VARCHAR(40),
    educationLevel VARCHAR(25),
    researchYear INT,
    isDentalVisit BOOLEAN
);