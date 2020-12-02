-- hr 데이터베이스의 테이블과
-- oe 데이터베이스의 테이블을 생성하고
-- alter 명령으로 기본키와 외래키 제약조건을 설정하세요.

create table orders(
	or_id int primary key,
	or_date timestamp default current_timestamp,
	or_mod varchar(30),
	custid varchar(50),
	or_stat varchar(20),
	or_total int,
	sales_rep_id int,
	promo_id varchar(50),
	foreign key (sales_rep_id)
	references employees (emp_id)
);
create table customers (
	custid 			varchar(30) primary key,
	custfname	 	varchar(20),
	custlname		varchar(20),
	custadd			varchar(50),
	custphone		int,
	nls_lang		varchar(40),
	nls_terr		varchar(40),
	cdt_limit		int,
	cust_email		varchar(50),
	acc_mgr_id		int,
	cust_geo_loc	varchar(100),
	birth			date,
	marital			char(5),
	gender			char(5) default 'male',
	income_lv		int,
	foreign key (acc_mgr_id)
	references employees (emp_id)
);
create table product_info (
	prd_id		varchar(20),
	prd_name	varchar(20),
	prd_dsc		varchar(200),
	ctg_id		int,
	wei_clsint	int,
	warranty	date,
	supplr_id	varchar(20),
	prd_stat	varchar(200),
	list_price	int,
	min_price	int,
	catal_url	varchar(100),
);
