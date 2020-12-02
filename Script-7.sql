-- 계정은  playground 이며
-- 비밀번호는 playground2020 인
-- 데이터베이스 사용자 계정을 생성

-- create database playground
-- create user 'playground'@'%'
-- identified by 'playground2020';
-- grant ~ ont playground.*
-- to 'playground'@'%'
-- with GRANT OPTION;

-- flush privileges;


 -- regions
 create table regions (
 		region_id int primary key,
		region_name varchar(30)
 );

 -- countries 
 create table countries (
 		country_id char(2),
		country_id varchar(30),
 		region_id int,
 		foreign key (region_id)
 		references regions (region_id)
 );

 -- locations
 create table locations (
 		locate_id int primary key,
 		street_address varchar(50),
 		postal_code varchar(10),
 		city varchar(20),
 		state_province varchar(25),
 		country_id char(2),
 		foreign key(country_id)
 		references countries (country_id)
 );

-- -- departments
 create table departments(
 		department_id int primary key,
 		department_name varchar(30),
 		manager_id int,
 		location_id int,
 		foreign key (locate_id)
 		references locations (locate_id)
 );

 -- jobs
 create table jobs (
 		job_id varchar(15) primary key,
 		job_title varchar(50),
 		min_salary int,
 		max_salary int,
 );

 -- employees
 create table employees (
 		employee_id int primary key,
 		first_name varchar(25),
 		last_name varchar(25),
 		email varchar(30),
 		phone_number varchar(15),
 		hire_date datetime,
 		job_id varchar(15),
 		salary int,
 		commission_pct decimal(5,2), -- double은 소수점 이하가 안짤리므로 소수점을 조절가능한 decimal이 훨씬 낫다.
 		manager_id int, -- 이건 사원번호와 관련있는 자료이므로 사원번호와 자료형식을 맞추어야 한다.
 		department_id int,
 		foreign key (manager_id)
 		references employees (employee_id),
 		foreign key (job_id)
 		references jobs (job_id),
 		foreign key (department_id)
 		references departments (department_id)
 );
 -- job_history
 create table job_history(
 		employee_id int,
 		start_date datetime,
 		end_date datetime,
 		job_id varchar(15),
 		department_id int,
 		foreign key (department_id)
 		references departments (department_id),
 		foreign key (job_id)
 		references jobs (job_id),
 		foreign key (manager_id)
 		references employees (employee_id)
 );
 



