-- hr �����ͺ��̽��� ���̺��
-- oe �����ͺ��̽��� ���̺��� �����ϰ�
-- alter ������� �⺻Ű�� �ܷ�Ű ���������� �����ϼ���.

create table orders(
	or_id int primary key,
	or_date timestamp default current_timestamp, -- Ư���� �Է� ������ ����ð����� ����
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



create table product_decscriptions ( -- ����� �׳� ����� ���� _ ������ �Ұ�
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
primary key (warehouse_id); -- warehouse ���̺��� warehouse_id �÷��� primary key�� ����.

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
-- ������ ���Թ� : insert
-- ����1 : insert into ���̺�� values (�÷���,...)
-- ����2 : insert into ���̺�� (��� �÷�, ... )
--    				   values (��� �÷���, ... )

-- ���� 1.
-- member ���̺� ȸ������ �Է�
-- ȸ�� id�� abc123�̰� ��й�ȣ�� zyx987�̰�
-- �̸��� ȫ�浿, ����� 'rookie', �������� 50000,
-- �������� '2021-12-03 12:12:12' �� ȸ�������� ����.

create table member(
	userid	varchar(20),
	passwd	varchar(20),
	name	varchar(10),
	grade	varchar(10) default 'bronze', -- �ƹ��͵� �Է� ���ϸ� default�� bronze �� ��.
	points	int default 1000,
	regdate timestamp default current_timestamp -- ����ð��� �ڵ����� �Է�.
); -- member ���̺� ����.

insert into member values (
	'abc123','zyx987','������','noob',50000,'2021-12-03 12:12:12');
--  **���̺� �� ���Խ� �ݵ�� ���� ������ �÷��� ������ �����ؾ� �Ѵ�.**
-- == insert into member(userid,passwd,name,grade,points,regdate) 
-- 	  values ('abc123','zyx987','������','noob',50000,'2021-12-03 12:12:12');

select * from member; -- ����Ȯ��

-- ȸ�� ���̵� xyz456�̰� ��й�ȣ�� 123456 �̸�
-- �̸��� ���� �� ȸ�������� ����.
insert into member values ('','','',null,null,null);

insert into member (userid,passwd,name) 
values ('','','');
-- ���̺� Ư��  �÷����� �� ���Խ�, 
-- values�տ� ����÷��� �����ؼ�
-- ���� ������ ��ġ���Ѿ� ������.

-- �뷮�� �����͸� insert �ϱ�
-- bulk insert
-- insert into ���̺�� ()
-- values (��, ��, ...),(��, ��, ...), ....(��, ��, ...); 





