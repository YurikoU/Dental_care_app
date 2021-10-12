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

-- DROP TABLE IF EXISTS noDentalCaresByAge;
-- CREATE TABLE noDentalCaresByAge(
-- 	byAgeId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     ageGroup VARCHAR(20),
--     researchYear INT,
--     isDentalVisit BOOLEAN,
-- 	FOREIGN KEY (byAgeId) REFERENCES noDentalCares(noDentalCaresId)
-- );

-- For chart 1 (output by age in the latest data)
SELECT COUNT(researchYear)
FROM noDentalCares
WHERE researchYear = '2018';

SELECT ageGroup, (COUNT(isDentalVisit) / 1258) * 100 AS "People who COUNLDN'T visited in 2018 (%)"
FROM noDentalCares
WHERE researchYear = '2018' AND isDentalVisit = false
GROUP BY ageGroup 
ORDER BY ageGroup ASC;


-- For chart 2 (output by researchYear)
SELECT researchYear, COUNT(isDentalVisit) AS "Number of people who COUNLDN'T visit in each year"
FROM noDentalCares
WHERE isDentalVisit = false
GROUP BY researchYear
ORDER BY researchYear ASC;

