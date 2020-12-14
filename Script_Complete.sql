create table regions ( -- 1
	region_id int primary key,
	region_name char(25)
);

create table countries ( -- 2
	country_id char(5) primary key,
	country_name varchar(15),
	region_id int,
	foreign key (region_id)
	references regions (region_id)
);

create table locations ( -- 3 
	locate_id int primary key,
	street_add varchar(40),
	postal_cod varchar(40),
	city varchar(20),
	state_province varchar(20), 
	country_id char(5),
	foreign key (country_id)
	references countries (country_id)
);

create table departments ( -- 4
	depart_id int primary key,
	depart_name char(25),
	manage_id int,
	locate_id int,
	foreign key (locate_id)
	references locations (locate_id)
	
);

create table jobs ( -- 5
	job_id char(10) primary key,
	job_title varchar(10),
	min_salary int,
	max_salary int
);

create table employees ( -- 6
	emp_id int primary key,
	fname varchar(20),
	lname char(20),
	emali char(20),
	phone varchar(15),
	hdate varchar(10),
	job_id char(10),
	salary int,
	comm double,
	manage_id int,
	depart_id int,
	foreign key (job_id)
	references jobs (job_id),
	foreign key (depart_id)
	references departments (depart_id)
	
);	

create table job_history ( -- 7
	emp_id int,
	start_date varchar(15) primary key,
	end_date varchar(15),
	job_id char(10),
	depart_id int,
	foreign key (emp_id)
	references employees (emp_id),
	foreign key (job_id)
	references jobs (job_id),
	foreign key (depart_id)
	references departments (depart_id)
	
);