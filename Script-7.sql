-- ������  playground �̸�
-- ��й�ȣ�� playground2020 ��
-- �����ͺ��̽� ����� ������ ����

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
 		commission_pct decimal(5,2), -- double�� �Ҽ��� ���ϰ� ��©���Ƿ� �Ҽ����� ���������� decimal�� �ξ� ����.
 		manager_id int, -- �̰� �����ȣ�� �����ִ� �ڷ��̹Ƿ� �����ȣ�� �ڷ������� ���߾�� �Ѵ�.
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
 



