

create table sales_customers(
	cust_id		char(20),
	cust_name	varchar(20),
	age			int,
	grd			char(10),
	job			varchar(15),
	pnt			int
);
insert into sales_customers (cust_id,cust_name,age,grd,job,pnt)
values ('apple','����ȭ',20,'gold','�л�',1000),
		('banana','�輱��',25,'vip','��ȣ��',2500),
		('carrot','���',28,'gold','����',4500),
		('orange','����',22,'silver','�л�',0),
		('melon','������',35,'gold','ȸ���',5000),
		('peach','������',null,'silver','�ǻ�',300),
		('pear','ä����',31,'silver','ȸ���',500);
	
select * from sales_customers;
select cust_id, cust_name, grd 
from sales_customers;


create table sales_products(
	prd_no		varchar(10),
	prd_name	varchar(30),
	stock		int,
	price		int,
	maker		varchar(50)
);
insert into sales_products (prd_no,prd_name,stock,price,maker)
values ('p01','�׳ɸ���',5000,4500,'���ѽ�ǰ'),
		('p02','�ſ��̸�',2500,5500,'�α�Ǫ��'),
		('p03','��������',3600,2600,'�Ѻ�����'),
		('p04','�������ݸ�',1250,2500,'�Ѻ�����'),
		('p05','��ū���',2200,1200,'���ѽ�ǰ'),
		('p06','����쵿',1000,1550,'�α�Ǫ��'),
		('p07','���޺�Ŷ',1650,1500,'�Ѻ�����');
	

select * from sales_products;
	
create table sales_orders(
	ord_no		varchar(10),
	cust_id		char(20),
	prd_no		varchar(10),	
	quan		int,
	post_add	varchar(255),
	ord_date	datetime default current_time
);

insert into sales_orders (ord_no,cust_id,prd_no,quan,post_add,ord_date)
values ('o01','apple','p03',10,'����� ������','2019-01-01'),
		('o02','melon','p01',5,'��õ�� ��籸','2019-01-10'),
		('o03','banana','p06',45,'��⵵ ��õ��','2019-01-11'),
		('o04','carrot','p02',8,'�λ�� ������','2019-02-01'),
		('o05','melon','p06',36,'��⵵ ���ν�','2019-02-20'),
		('o06','banana','p01',19,'��û�ϵ� ������','2019-03-02'),
		('o07','apple','p03',22,'����� ��������','2019-03-15'),
		('o08','pear','p02',50,'������ ��õ��','2019-04-10'),
		('o09','banana','p04',15,'���󳲵� ������','2019-04-11'),
		('o10','carrot','p03',20,'��⵵ �Ⱦ��','2019-05-22');

select * from sales_orders;

alter table sales_customers
add constraint pk_cust_id
primary key (cust_id);

alter table sales_products
add constraint pk_prd_no
primary key (prd_no);

alter table sales_orders
add constraint pk_ord_no
primary key (ord_no);

alter table sales_orders
add constraint fk_ord_cust
foreign key (cust_id)
references sales_customers (cust_id);

alter table sales_orders
add constraint fk_ord_prdno
foreign key (prd_no)
references sales_products (prd_no);

alter table sales_orders 
modify column ord_date	datetime default current_time;

alter table sales_customers 
modify column grd char(10) default 'bronze';

-- �뷮�� �����͸� insert �ϱ�
-- bulk insert
-- insert into ���̺�� ()
-- values (��, ��, ...),(��, ��, ...), ....(��, ��, ...); 


insert into sales_orders ()
values ();

create table Books (
	bookid		char(5),
	bookname	varchar(100),
	pubilsher	char(40),
	price		int
);
insert into Books (bookid,bookname,pubilsher,price)
values ('1','�౸�� ����','�½�����',7000),
		('2','�౸�ƴ� ����','������',13000),
		('3','�౸�� ����','���ѹ̵��',22000),
		('4','���� ���̺�','���ѹ̵��',35000),
		('5','�ǰ� ����','�½�����',8000),
		('6','���� �ܰ躰 ���','�½�����',6000),
		('7','�߱��� �߾�','�̻�̵��',20000),
		('8','�߱��� ��Ź��','�̻�̵��',13000),
		('9','�ø��� �̾߱�','�Ｚ��',7500),
		('10','Olympic Champions','Pearson',13000);

select * from Books;	
	
create table BookMembers(
	custid		char(10),
	name		varchar(10),
	address		varchar(100),
	phone		varchar(15)
);
insert into BookMembers (custid,name ,address ,phone )
values ('1','������','���� ��ü����','000-5000-0001'),
		('2','�迬��','���ѹα� ����','000-6000-0001'),
		('3','��̶�','���ѹα� ������','000-7000-0001'),
		('4','�߽ż�','�̱� Ŭ������','000-8000-0001'),
		('5','�ڼ���','���ѹα� ����',null);

create table BookOrder(
	orderid		char(10),
	custid		char(10),
	bookid		char(5),
	saleprice	int,
	orderdate	datetime
);
insert into BookOrder (orderid,custid,bookid,saleprice,orderdate)
values ('1','1','1',6000,'2014-07-01'),
		('2','1','3',21000,'2014-07-03'),
		('3','2','5',8000,'2014-07-03'),
		('4','3','6',6000,'2014-07-04'),
		('5','4','7',20000,'2014-07-05'),
		('6','1','2',12000,'2014-07-07'),
		('7','4','8',13000,'2014-07-07'),
		('8','3','10',12000,'2014-07-08'),
		('9','2','10',7000,'2014-07-09'),
		('10','3','8',13000,'2014-07-10');
	
alter table BookOrder 
modify column orderdate datetime default current_time;

alter table Books
add constraint pk_book_id
primary key (bookid);

alter table BookMembers 
add constraint pk_cust_id
primary key (custid);

alter table BookOrder
add constraint pk_ord_id
primary key (orderid);

alter table BookOrder 
add constraint fk_ord_bookid -- �ܷ�Ű_���̺�����_����������
foreign key (bookid)
references Books (bookid);

alter table BookOrder 
add constraint fk_ord_custid -- �ܷ�Ű_���̺�����_����������
foreign key (custid)
references BookMembers (custid);

-- �뷮�� �����͸� insert �ϱ�
-- bulk insert
-- insert into ���̺�� ()
-- values (��, ��, ...),(��, ��, ...), ....(��, ��, ...); 


-- ������ ��ȸ : select

-- 1. �⺻���� �÷� ��ȸ
-- select �÷���� from ���̺��;

-- 1) �����̺��� ���̵�, �̸�, ����� ��ȸ�Ͻÿ�.
-- ex) select custid,name, grd
-- 	   from sales_customers;

-- 2) �����̺��� ��� �÷��� ��ȸ�ϼ���
-- ex) select * from sales_customers;
--  =  select custid, name, age, grade, job, points
-- 	   from sales_customers;

-- 3) ��ǰ���̺��� ������ü�� ��ȸ�ϼ���
-- select maker from sales_products;

-- ��, �ڷῡ ������� �ߺ������� �ȵ����� DB�� �ԷµǾ� �ִ� ��� �˴� ������ ������, 
-- �� ��� ��ü�� �ִ����� �˾ƺ��� ���ؼ��� �ٸ� ����� �ʿ�. 
-- select distinct maker from sales_products;

-- distinct : ��Ͽ��� �ߺ����� �����Ͽ� �Ѱ��� ���� ��ȸ�ϵ��� �Ѵ�.(�ߺ��� ����)
-- all : �ߺ��� ����Ͽ� �����ϴ� ��� ���� ��ȸ�ϵ��� �Ѵ�.(�⺻��, ��������)

-- 2. ���̺� �÷� ��ȸ ��, ��ȸ��� �÷����� ����(rename)
-- select �÷��� as �� �÷��� from ���̺��;

-- 4) ��ǰ���̺��� ��ǰ��� ������ ��ȸ�ϵ�
-- �÷����� �ѱ۷� �ٲ㼭 ����Ͻÿ�.

select prdname as '��ǰ��', 
		price as '�ܰ�' -- (���� �̸��� ����� -> ��üȭ)
from sales_products;

-- ����Ŭ������ "", mysql ������ ''
-- as�� ��� ��.


-- 3. ������� �̿��� �˻�
-- select ���� ��������ڸ� �̿��ؼ� ��ȸ�Ҽ��� ����
-- select ����� from ���̺��;

-- 5) ��ǰ���̺��� ��ǰ��� ������ ��ȸ�ϵ�,
-- ���ݿ� 500���� ���Ͽ� 2021�� �ܰ���� ��Ī�� ���� ���ο� �÷��� �Բ� ����Ͻÿ�.
select prd_name '��ǰ��', 
		price '2020�� �ܰ�', 
		price + 500 '2021�� �ܰ�' 
from sales_products;

-- 5-1) ��� ȸ���� �������� 1000�� �߰��� �־��� ��, 
-- ���� �����ݰ� �߰� �� �������� ���� ����Ͽ� ���ϰ��� �Ѵ�.
-- �̿� ������ �˻����� �ۼ��Ͻÿ�.
select cust_id 'ȸ��id', 
		cust_name 'ȸ����', 
		pnt '�߰� ��', 
		pnt+1000 '�߰� ��' 
from sales_customers;

-- 4. ���ǽ��� �̿��� �˻�
-- ������ �����ϴ� �����͸� �˻�
-- where ��� ���� �̿��ϸ�, 
-- �񱳿�����, �������� ������ ������ ���ǽ��� �ʿ�.
-- select �÷��� from ���̺�� where ���ǽ�;

-- 6) ��ǰ���̺��� '�Ѻ�����'�� ������ ��ǰ�� '��ǰ��', '���', '�ܰ�' �� ��ȸ�Ͻÿ�.
select prd_name'��ǰ��' ,stock'���' ,price'�ܰ�' from sales_products where maker = '�Ѻ�����';

-- = : ����
-- < > : �ٸ���( ' ! ' �� �ƴϴ�)

-- 7) �ֹ����̺��� apple �̶�� ���� 15���̻� �ֹ��� �ֹ���ǰ, ����, �ֹ����ڸ� ��ȸ�ϼ���.
select cust_id '��id',
		quan '�ֹ�����', 
		ord_date '�ֹ���' 
from sales_orders
where cust_id = 'apple' and quan >= 15;
	  

-- 8) ��ǰ���̺��� �ܰ��� 2000�� �̻��̰� 
-- 3000�� ������ ��ǰ�� ��ǰ��, �ܰ�, ������ü�� ��ȸ�ϼ���.
select prd_name '��ǰ��',
		price '�ܰ�', 
		maker '������ü' 
from sales_products
where price >= 2000 and price <= 3000;

-- 8-1)���� where���� �ϳ��� ��ġ�ÿ�.
select prd_name '��ǰ��',
		price '�ܰ�', 
		maker '������ü' 
from sales_products
where price BETWEEN 2000 and 3000;


-- 5. NULL �˻�
-- �ش� �÷��� ���� NULL������ ��ȸ�� ����
-- is Null/is not Null �̶�� ������ ����ؼ� ��ȸ�Ѵ�.
-- where �÷��� is null;

-- 9) �� ���̺��� ���̰� �Էµ��� ���� ���� ��ȸ�Ͻÿ�.
select cust_id '��ID', 
		cust_name '����', 
		age '����' 
from sales_customers 
where age is null;

