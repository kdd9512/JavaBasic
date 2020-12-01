create table regions ( -- 1
	region_id int primary key,
	region_name char(25)
);

create table countries ( -- 2
	country_id char(5),
	country_name varchar(15) primary key,
	region_id int,
	foreign key (region_id)
	references regions (regions_id)
);

create table locations ( -- 3 
	locate_id int primary key,
	street_add varchar(40),
	postal_cod varchar(40),
	city varchar(20) primary key,
	state_province varchar(20) primary key, 
	country_id char(5)
);

create table departments ( -- 4
	depart_id int primary key,
	depart_name char(25) primary key,
	manage_id int primary key,
	locate_id int
);

create table jobs( -- 5
	job_id char(10) primary key,
	job_title varchar(10) primary key,
	min_salary int,
	max_salary int
);

create table employees( -- 6

	empid int primary key,
	fname varchar(20),
	lname char(20),
	emali char(20),
	phone varchar(15),
	hdate varchar(10) primary key,
	jobid char(10),
	salary int,
	comm double,
	manage_id int,
	depart_id int
);	

create table job_history ( -- 7
	empid int,
	start_date varchar(15) primary key,
	end_date varchar(15),
	job_id char(10),
	depart_id int
);
