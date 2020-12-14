create table customers ( -- 고객 테이블
	custid 	varchar(16) primary key, -- 중복 데이터 입력방지 문구 primary key
	name   	varchar(10), -- 한글은 바이트 차지수가 영어의 2배임을 주의 
	age 	int,
	grade	varchar(10),
	job		varchar(10),
	pnt		int
);
create table products ( -- 제품 테이블
	prdno 		char(4) primary key,
	prdname		char(4),
	stock		int,
	price		int,
	prdmaker	varchar(10)	
);

create table orders ( -- 주문 테이블
	ordno 	int primary key,
	custid	varchar(16), -- 고객 테이블의 값과 같음 
	prdno	char(4), -- 상품 테이블의 값과 같음
	qty		int,
	addr 	varchar(20),
	orddate	datetime -- 날짜이므로 datetime 으로 쓴다.
);



-- 외래키 설정
-- foreign key (컬럼명)
-- references 테이블명 (컬럼명)

-- 주문 - 고객 테이블 간 관계 설정 
-- 주문 - 상품 테이블 간 관계 설정


create table orders2 ( -- 주문 / 고객 외래키 설정.
	ordno 	int primary key,
	custid	varchar(16), -- 고객 테이블의 값과 같음 
	prdno	char(4), -- 상품 테이블의 값과 같음
	qty		int,
	addr 	varchar(20),
	orddate	datetime, -- 날짜이므로 datetime 으로 쓴다.
	foreign key (custid)
	references customers (custid)

);

create table orders3 ( -- 주문 테이블
	ordno 	int primary key,
	custid	varchar(16), -- 고객 테이블의 값과 같음 
	prdno	char(4), -- 상품 테이블의 값과 같음
	qty		int,
	addr 	varchar(20),
	orddate	datetime, -- 날짜이므로 datetime 으로 쓴다.
	foreign key (prdno)
	references products (prdno)
);

create table orders4 ( -- 주문 테이블
	ordno 	int primary key,
	custid	varchar(16), -- 고객 테이블의 값과 같음 
	prdno	char(4), -- 상품 테이블의 값과 같음
	qty		int,
	addr 	varchar(20),
	orddate	datetime, -- 날짜이므로 datetime 으로 쓴다.
	foreign key (custid)
	references customers (custid),
	foreign key (prdno)
	references products (prdno)
);


-- 단 외래키 제약조건을 설정할 떄에는
-- 테이블 생성순서에 주의해야 한다.
-- 고객 -> 상품 -> 주문
















