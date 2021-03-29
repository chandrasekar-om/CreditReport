DROP TABLE IF EXISTS TBL_EMPLOYEES;
 
CREATE TABLE TBL_EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

INSERT INTO
	TBL_EMPLOYEES (first_name, last_name, email)
VALUES
  	('Lokesh', 'Gupta', 'howtodoinjava@gmail.com'),
  	('John', 'Doe', 'xyz@email.com');

DROP TABLE IF EXISTS CUSTOMERS;

CREATE TABLE CUSTOMERS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  address VARCHAR(250) DEFAULT NULL,
  city VARCHAR(100) DEFAULT NULL
);

INSERT INTO
	CUSTOMERS (first_name, last_name, email, address, city)
VALUES
  	('Lokesh', 'Gupta', 'howtodoinjava@gmail.com','319, Mission St, MG Road Area','Pondicherry'),
  	('Harish', 'Jayabharathy', 'harish@email.com','3, Ragavandra Street, Chitlapakkam','Chennai'),
  	('Harini', 'Rajagopalan', 'harini@rediff.com','11, Royal court road, adayar','Chennai'),
  	('Chandra', 'J', 'chandrasekar@email.com','3/4, Koil road, Pulliyandurai','Sirkali'),
  	('SriniKethan', 'Chandrasekar', 'harish@rediff.com','8, patel Street','Srirangam'),
  	('Vinay', 'Kumar', 'vinay@hotmail.com','221, Outer ring Road','Bangalore'),
  	('Ajith', 'Kalyan', 'ajith@gmail.com','33, Nethaji Street','Chidambaram'),
  	('Dharshan', 'Saravanan', 'dharshan@email.com','9, East car street','Ponneri'),
  	('Srikrithi', 'Sandhanam', 'srikrithi@email.com','111, West Street','Trichy'),
  	('Murali', 'Mohan', 'murali@gmail.com','7, second street, phase 1','Salem');

DROP TABLE IF EXISTS SECTOR;

CREATE TABLE SECTOR (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  sector_id INT,
  sector_name VARCHAR(100),
  sub_sector_id INT,
  sub_sector_name VARCHAR(100),
  facilitie_id INT,
  facilitie_name VARCHAR(100)
);

INSERT INTO
	SECTOR (sector_id, sector_name, sub_sector_id, sub_sector_name, facilitie_id, facilitie_name)
VALUES
  	(1, 'Retail', 11, 'Commerical Bank', 1, 'Personal Loan'),
  	(1, 'Retail', 11, 'Commerical Bank', 2, 'Home Loan'),
  	(1, 'Retail', 11, 'Commerical Bank', 3, 'Auto Loan'),
  	(1, 'Retail', 12, 'Private Bank', 1, 'Lines of credit'),
  	(1, 'Retail', 12, 'Private Bank', 2, 'Lending'),
  	(1, 'Retail', 13, 'RRBs', 1, 'Loan'),
  	(2, 'SME', 21, 'Manufacturing', 1, 'Working Capital Loans'),
  	(2, 'SME', 22, 'Essential Products', 1, 'Term Loan'),
  	(2, 'SME', 22, 'Essential Products', 2, 'SuperBiz'),
  	(3, 'MSME', 31, 'Manufacturing and Enterprises rendering Services', 1, 'Investment in Plant and Machinery or Equipment'),
  	(3, 'MSME', 31, 'Manufacturing and Enterprises rendering Services', 2, 'Technology Upgradation and Quality Certification'),
  	(3, 'MSME', 31, 'Manufacturing and Enterprises rendering Services', 2, 'Marketing Promotion Schemes'),
  	(3, 'MSME', 31, 'Manufacturing and Enterprises rendering Services', 2, 'Infrastructure Development Programme'),
  	(4, 'Agriculture', 41, 'Direct Finance', 1, 'Loans for Food Parks and Food Processing Units in Designated Food Parks'),
  	(4, 'Agriculture', 41, 'Direct Finance', 2, 'Loans to Warehouses, Cold Storage and Cold Chain Infrastructure'),
  	(4, 'Agriculture', 41, 'Direct Finance', 3, 'Long Term Irrigation Fund'),
  	(4, 'Agriculture', 42, 'Refinance', 1, 'Short Term Loans'),
  	(4, 'Agriculture', 42, 'Refinance', 2, 'Long Term Loans');

DROP TABLE IF EXISTS CUSTOMER_FACILITIES;

CREATE TABLE CUSTOMER_FACILITIES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  s_id INT,
  c_id INT,
  actual_amount double,
  paid_amount double,
  unpaid_amount double,
  start_date date,
  end_date date
);

INSERT INTO
	CUSTOMER_FACILITIES (s_id, c_id, actual_amount, paid_amount, unpaid_amount, start_date, end_date)
VALUES
  	(11, 2, 100000, 50000, 950000, CURRENT_DATE - 364, CURRENT_DATE + 364),
  	(11, 3, 500000, 10000, 490000, CURRENT_DATE - 200, CURRENT_DATE + 564),
  	(21, 2, 100000, 50000, 950000, CURRENT_DATE - 364, CURRENT_DATE + 364),
    (11, 5, 200000, 10000, 190000, CURRENT_DATE - 250, CURRENT_DATE + 550),
    (41, 4, 100000, 500000, 500000, CURRENT_DATE - 500, CURRENT_DATE + 364),
    (42, 4, 200000, 100000, 100000, CURRENT_DATE - 450, CURRENT_DATE  +100),
    (22, 3, 200000, 10000, 190000, CURRENT_DATE - 250, CURRENT_DATE + 550),
    (31, 3, 200000, 10000, 190000, CURRENT_DATE - 250, CURRENT_DATE + 550);