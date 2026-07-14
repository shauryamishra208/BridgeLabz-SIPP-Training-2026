CREATE DATABASE covid_analysis;
USE covid_analysis;

CREATE TABLE session3_cases (
    case_id INT PRIMARY KEY,
    country VARCHAR(100),
    report_date DATE,
    confirmed_cases INT,
    recoveries INT,
    deaths INT,
    population BIGINT
);

CREATE TABLE session3_vaccines (
    vaccine_id INT PRIMARY KEY,
    case_id INT,
    vaccinated_people INT,
    fully_vaccinated INT,
    FOREIGN KEY (case_id)
    REFERENCES session3_cases(case_id)
);

CREATE TABLE session3_deaths (
    death_id INT PRIMARY KEY,
    case_id INT,
    death_count INT,
    FOREIGN KEY (case_id)
    REFERENCES session3_cases(case_id)
);

SELECT country,
       confirmed_cases
FROM session3_cases
WHERE report_date = '2020-03-15'
ORDER BY confirmed_cases DESC
LIMIT 1;

SELECT c.country,
       d.death_count,
       v.vaccinated_people,
       v.fully_vaccinated
FROM session3_cases c
LEFT JOIN session3_deaths d
ON c.case_id = d.case_id
LEFT JOIN session3_vaccines v
ON c.case_id = v.case_id;

SELECT country,
       SUM(deaths) AS total_deaths
FROM session3_cases
GROUP BY country;

SELECT report_date,
       AVG(deaths) AS average_daily_deaths
FROM session3_cases
GROUP BY report_date
ORDER BY report_date;

SELECT country,
       confirmed_cases,
       population,
       ROUND((confirmed_cases * 100.0) / population, 4) AS infection_rate
FROM session3_cases
ORDER BY infection_rate DESC;