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
commission_pct decimal(5,2),
manager_id int, -- 이건 사원번호와 관련있는 자료이므로 사원번호와 자료형식을 맞추어야 한다.
department_id int,
foreign key (manager_id)
references employees (employee_id),
foreign key (job_id)
references jobs (job_id),
foreign key (department_id)
references departments (department_id)
);