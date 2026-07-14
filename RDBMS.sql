CREATE TABLE covid_cases (
    case_id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(50) NOT NULL,
    report_date DATE NOT NULL,
    confirmed_cases INT,
    recoveries INT,
    deaths INT,
    population BIGINT
);

CREATE TABLE covid_vaccines (
    vaccine_id INT AUTO_INCREMENT PRIMARY KEY,
    case_id INT,
    vaccinated_people INT,
    fully_vaccinated INT,
    FOREIGN KEY (case_id)
    REFERENCES covid_cases(case_id)
);

CREATE TABLE covid_deaths (
    death_id INT AUTO_INCREMENT PRIMARY KEY,
    case_id INT,
    death_count INT,
    FOREIGN KEY (case_id)
    REFERENCES covid_cases(case_id)
);

SHOW TABLES;

INSERT INTO covid_cases
(country, report_date, confirmed_cases, recoveries, deaths, population)
VALUES
('India','2020-03-15',100,50,2,1380000000),
('USA','2020-03-15',200,80,5,331000000),
('UK','2020-03-15',150,60,3,67000000);

SELECT * FROM covid_cases;

INSERT INTO covid_vaccines
(case_id, vaccinated_people, fully_vaccinated)
VALUES
(1,900000000,800000000),
(2,250000000,220000000),
(3,50000000,45000000);

SELECT * FROM covid_vaccines;

INSERT INTO covid_deaths
(case_id, death_count)
VALUES
(1,2),
(2,5),
(3,3);

SELECT * FROM covid_deaths;

UPDATE covid_cases
SET confirmed_cases = 120
WHERE country = 'India'
AND report_date = '2020-03-15';

SELECT * FROM covid_cases;

INSERT INTO covid_cases
(country, report_date, confirmed_cases, recoveries, deaths, population)
VALUES
('IN','2020-03-16',50,20,1,1000);

DELETE FROM covid_cases
WHERE country = 'IN';

SELECT * FROM covid_cases;

ALTER TABLE covid_cases
ADD vaccination_rate FLOAT;

DESCRIBE covid_cases;

UPDATE covid_cases
SET vaccination_rate = 75.5
WHERE country = 'India';

SELECT * FROM covid_cases;
SELECT * FROM covid_vaccines;
SELECT * FROM covid_deaths;
USE covid_management;