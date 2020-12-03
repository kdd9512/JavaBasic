

create table sales_customers(
	cust_id		char(20),
	cust_name	varchar(20),
	age			int,
	grd			char(10),
	job			varchar(15),
	pnt			int
);
insert into sales_customers (cust_id,cust_name,age,grd,job,pnt)
values ('apple','정소화',20,'gold','학생',1000),
		('banana','김선우',25,'vip','간호사',2500),
		('carrot','고명석',28,'gold','교사',4500),
		('orange','김용욱',22,'silver','학생',0),
		('melon','성원용',35,'gold','회사원',5000),
		('peach','오형준',null,'silver','의사',300),
		('pear','채광주',31,'silver','회사원',500);
	
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
values ('p01','그냥만두',5000,4500,'대한식품'),
		('p02','매운쫄면',2500,5500,'민국푸드'),
		('p03','쿵떡파이',3600,2600,'한빛제과'),
		('p04','맛난초콜릿',1250,2500,'한빛제과'),
		('p05','얼큰라면',2200,1200,'대한식품'),
		('p06','통통우동',1000,1550,'민국푸드'),
		('p07','달콤비스킷',1650,1500,'한빛제과');
	

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
values ('o01','apple','p03',10,'서울시 마포구','2019-01-01'),
		('o02','melon','p01',5,'인천시 계양구','2019-01-10'),
		('o03','banana','p06',45,'경기도 부천시','2019-01-11'),
		('o04','carrot','p02',8,'부산시 금정구','2019-02-01'),
		('o05','melon','p06',36,'경기도 용인시','2019-02-20'),
		('o06','banana','p01',19,'충청북도 보은군','2019-03-02'),
		('o07','apple','p03',22,'서울시 영등포구','2019-03-15'),
		('o08','pear','p02',50,'강원도 춘천시','2019-04-10'),
		('o09','banana','p04',15,'전라남도 목포시','2019-04-11'),
		('o10','carrot','p03',20,'경기도 안양시','2019-05-22');

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

-- 대량의 데이터를 insert 하기
-- bulk insert
-- insert into 테이블명 ()
-- values (값, 값, ...),(값, 값, ...), ....(값, 값, ...); 


insert into sales_orders ()
values ();

create table Books (
	bookid		char(5),
	bookname	varchar(100),
	pubilsher	char(40),
	price		int
);
insert into Books (bookid,bookname,pubilsher,price)
values ('1','축구의 역사','굿스포츠',7000),
		('2','축구아는 여자','나무수',13000),
		('3','축구의 이해','대한미디어',22000),
		('4','골프 바이블','대한미디어',35000),
		('5','피겨 교본','굿스포츠',8000),
		('6','역도 단계별 기술','굿스포츠',6000),
		('7','야구의 추억','이상미디어',20000),
		('8','야구를 부탁해','이상미디어',13000),
		('9','올림픽 이야기','삼성당',7500),
		('10','Olympic Champions','Pearson',13000);

select * from Books;	
	
create table BookMembers(
	custid		char(10),
	name		varchar(10),
	address		varchar(100),
	phone		varchar(15)
);
insert into BookMembers (custid,name ,address ,phone )
values ('1','박지성','영국 멘체스터','000-5000-0001'),
		('2','김연아','대한민국 서울','000-6000-0001'),
		('3','장미란','대한민국 강원도','000-7000-0001'),
		('4','추신수','미국 클리블랜드','000-8000-0001'),
		('5','박세리','대한민국 대전',null);

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
add constraint fk_ord_bookid -- 외래키_테이블축약어_참조값축약어
foreign key (bookid)
references Books (bookid);

alter table BookOrder 
add constraint fk_ord_custid -- 외래키_테이블축약어_참조값축약어
foreign key (custid)
references BookMembers (custid);

-- 대량의 데이터를 insert 하기
-- bulk insert
-- insert into 테이블명 ()
-- values (값, 값, ...),(값, 값, ...), ....(값, 값, ...); 


-- 데이터 조회 : select

-- 1. 기본적인 컬럼 조회
-- select 컬럼목록 from 테이블명;

-- 1) 고객테이블에서 아이디, 이름, 등급을 조회하시오.
-- ex) select custid,name, grd
-- 	   from sales_customers;

-- 2) 고객테이블에서 모든 컬럼을 조회하세요
-- ex) select * from sales_customers;
--  =  select custid, name, age, grade, job, points
-- 	   from sales_customers;

-- 3) 제품테이블에서 제조업체를 조회하세요
-- select maker from sales_products;

-- 단, 자료에 적힌대로 중복값여부 안따지고 DB에 입력되어 있는 대로 죄다 나오기 때문에, 
-- 총 몇개의 업체가 있는지를 알아보기 위해서는 다른 방법이 필요. 
-- select distinct maker from sales_products;

-- distinct : 목록에서 중복값을 제거하여 한개의 값만 조회하도록 한다.(중복값 제외)
-- all : 중복을 허용하여 존재하는 모든 값을 조회하도록 한다.(기본값, 생략가능)

-- 2. 테이블 컬럼 조회 시, 조회결과 컬럼명을 변경(rename)
-- select 컬럼명 as 새 컬럼명 from 테이블명;

-- 4) 제품테이블에서 제품명과 가격을 조회하되
-- 컬럼명을 한글로 바꿔서 출력하시오.

select prdname as '제품명', 
		price as '단가' -- (실제 이름을 감춘다 -> 객체화)
from sales_products;

-- 오라클에서는 "", mysql 에서는 ''
-- as는 없어도 됌.


-- 3. 산술식을 이용한 검색
-- select 사용시 산술연산자를 이용해서 조회할수도 있음
-- select 산술식 from 테이블명;

-- 5) 제품테이블에서 제품명과 가격을 조회하되,
-- 가격에 500원을 더하여 2021년 단가라는 별칭을 가진 새로운 컬럼을 함께 출력하시오.
select prd_name '제품명', 
		price '2020년 단가', 
		price + 500 '2021년 단가' 
from sales_products;

-- 5-1) 모든 회원의 적립금을 1000씩 추가해 주었을 때, 
-- 이전 적립금과 추가 후 적립금을 각각 출력하여 비교하고자 한다.
-- 이에 적당한 검색문을 작성하시오.
select cust_id '회원id', 
		cust_name '회원명', 
		pnt '추가 전', 
		pnt+1000 '추가 후' 
from sales_customers;

-- 4. 조건식을 이용한 검색
-- 조건을 만족하는 데이터를 검색
-- where 라는 예약어를 이용하며, 
-- 비교연산자, 논리연산자 등으로 구성된 조건식이 필요.
-- select 컬럼명 from 테이블명 where 조건식;

-- 6) 제품테이블에서 '한빛제과'가 제조한 제품의 '제품명', '재고량', '단가' 를 조회하시오.
select prd_name'제품명' ,stock'재고' ,price'단가' from sales_products where maker = '한빛제과';

-- = : 같다
-- < > : 다르다( ' ! ' 가 아니다)

-- 7) 주문테이블에서 apple 이라는 고객이 15개이상 주문한 주문제품, 수량, 주문일자를 조회하세요.
select cust_id '고객id',
		quan '주문수량', 
		ord_date '주문일' 
from sales_orders
where cust_id = 'apple' and quan >= 15;
	  

-- 8) 제품테이블에서 단가가 2000원 이상이고 
-- 3000원 이하인 제품의 제품명, 단가, 제조업체를 조회하세요.
select prd_name '제품명',
		price '단가', 
		maker '제조업체' 
from sales_products
where price >= 2000 and price <= 3000;

-- 8-1)위의 where문을 하나로 합치시오.
select prd_name '제품명',
		price '단가', 
		maker '제조업체' 
from sales_products
where price BETWEEN 2000 and 3000;


-- 5. NULL 검색
-- 해당 컬럼의 값이 NULL인지를 조회할 때는
-- is Null/is not Null 이라는 구문을 사용해서 조회한다.
-- where 컬럼명 is null;

-- 9) 고객 테이블에서 나이가 입력되지 않은 고객을 조회하시오.
select cust_id '고객ID', 
		cust_name '고객명', 
		age '연령' 
from sales_customers 
where age is null;

