-- hr 데이터베이스의 테이블과
-- oe 데이터베이스의 테이블을 생성하고
-- alter 명령으로 기본키와 외래키 제약조건을 설정하세요.

create table orders(
	or_id int primary key,
	or_date timestamp default current_timestamp, -- 특별한 입력 없으면 현재시간으로 설정
	or_mod varchar(30),
	custid varchar(50),
	or_stat varchar(20),
	or_total int,
	sales_rep_id int,
	promo_id varchar(50),
	foreign key (sales_rep_id)
	references employees (emp_id)
);
alter table customers 
add constraint fk_cust_emp
foreign key (acc_mgr_id)
references employees (emp_id)

alter table orders
add constraint fk_ord_emp
foreign key (sales_rep_id)
references employees (emp_id)

alter table orders 
add constraint fk_ord_cust
foreign key (custid)
references customers (custid)


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
	prd_id		varchar(20) primary key,
	prd_name	varchar(20),
	prd_dsc		varchar(200),
	ctg_id		int,
	wei_clsint	int,
	warranty	date,
	supplr_id	varchar(20),
	prd_stat	varchar(200),
	list_price	int,
	min_price	int,
	catal_url	varchar(100)
);
create table order_item(
	or_id			int,
	line_item_id	int,
	prd_id			varchar(20),
	unit_price		int,
	quantity		int,
	foreign key (or_id)
	references orders (or_id),
	foreign key (prd_id)
	references product_info (prd_id)
);

alter table order_item 
add constraint fk_orditm_ord
foreign key (or_id)
references orders (or_id)

alter table order_item
add constraint fk_orditem_prdinf
foreign key (prd_id)
references product_info (prd_id)



create table product_decscriptions ( -- 띄어쓰기는 그냥 띄우지 말고 _ 붙혀서 할것
	prd_id		varchar(20),
	lang_id		int,
	transl_name	varchar(20),
	transl_desc	varchar(100),
	foreign key (prd_id)
	references product_info (prd_id)
);
create table warehouses(
	warehouse_id	varchar(15) primary key,
	warehouse_spec	varchar(200),
	warehouse_name	varchar(20),
	locate_id		int,		
	wh_geo_loc		varchar(20),
	foreign key (locate_id)
	references locations (locate_id)
);

alter table warehouses 
add constraint pk_warehouse_id 
primary key (warehouse_id); -- warehouse 테이블의 warehouse_id 컬럼을 primary key로 만듦.

create table inventories(
	prd_id				varchar(20),
	warehouse_id		varchar(15),
	quantity_on_hand	int,
	foreign key (prd_id)
	references product_info (prd_id),
	foreign key (warehouse_id)
	references warehouses (warehouse_id)
);

alter table inventories
add constraint fk_inv_prdinf
foreign key (prd_id)
references product_info (prd_id)

alter table inventories
add constraint fk_inv_wh
foreign key (warehouse_id)
references warehouses (warehouse_id)

alter table product_decscriptions
add constraint fk_prddesc_prdinf
foreign key (prd_id)
references product_info (prd_id)

alter table warehouses 
add constraint fk_wh_loc
foreign key (locate_id)
references locations (locate_id)

alter table product_decscriptions 
add constraint pk_prddesc
primary key(prd_id, lang_id)

alter table inventories 
add constraint pk_inven
primary key (prd_id, warehouse_id)

-- DML
-- 데이터 삽입문 : insert
-- 문법1 : insert into 테이블명 values (컬럼값,...)
-- 문법2 : insert into 테이블명 (대상 컬럼, ... )
--    				   values (대상 컬럼값, ... )

-- 예제 1.
-- member 테이블에 회원정보 입력
-- 회원 id가 abc123이고 비밀번호가 zyx987이고
-- 이름은 홍길동, 등급은 'rookie', 적립금은 50000,
-- 가입일은 '2021-12-03 12:12:12' 인 회원정보를 삽입.

create table member(
	userid	varchar(20),
	passwd	varchar(20),
	name	varchar(10),
	grade	varchar(10) default 'bronze', -- 아무것도 입력 안하면 default는 bronze 가 됌.
	points	int default 1000,
	regdate timestamp default current_timestamp -- 현재시간을 자동으로 입력.
); -- member 테이블 생성.

insert into member values (
	'abc123','zyx987','김현우','noob',50000,'2021-12-03 12:12:12');
--  **테이블에 값 삽입시 반드시 값의 개수는 컬럼의 개수와 동일해야 한다.**
-- == insert into member(userid,passwd,name,grade,points,regdate) 
-- 	  values ('abc123','zyx987','김현우','noob',50000,'2021-12-03 12:12:12');

select * from member; -- 정보확인

-- 회원 아이디가 xyz456이고 비밀번호가 123456 이며
-- 이름은 지현 인 회원정보를 삽입.
insert into member values ('','','',null,null,null);

insert into member (userid,passwd,name) 
values ('','','');
-- 테이블에 특정  컬럼에만 값 삽입시, 
-- values앞에 대상컬럼을 나열해서
-- 값의 개수를 일치시켜야 동작함.

-- 대량의 데이터를 insert 하기
-- bulk insert
-- insert into 테이블명 ()
-- values (값, 값, ...),(값, 값, ...), ....(값, 값, ...); 





