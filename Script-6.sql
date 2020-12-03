create table abc(
	a int primary key
);

describe abc;
desc abc; -- 테이블 주소 확인(위의 describe 줄인것)


-- x 라는 컬럼 추가(문자(10))
alter table abc
add x varchar(10);

desc abc;


-- 기존 컬럼 삭제
alter table abc
drop x;

desc abc;


-- 기존 컬럼 수정
-- alter table 컬럼명
-- modify column 컬럼정의;


-- 성적데이터를 저장하기 위한 테이블 생성
-- 기본 : 이름, 국어, 영어, 수학(전부 문자로 생성).
-- 추가 : 총점, 평균, 학점 (모두 숫자로 생성)


CREATE table sungjuk (
	name varchar(10),
	sc_kor char(10),
	sc_eng char(10),
	sc_mat char(10)
);

alter table sungjuk add sum int;
alter table sungjuk add mean int;
alter table sungjuk add grd int;

desc sungjuk;


-- 컬럼값들을 변경하기.

alter table sungjuk 
modify column sc_kor int;
alter table sungjuk 
modify column sc_eng int;
alter table sungjuk 
modify column sc_mat int;
ALTER table sungjuk 
modify column grd char(2);

desc sungjuk;

alter table sungjuk 
modify column mean decimal(5,1) -- 전체 실수 5자리 중, 소수는 단 한자리. 즉, 100점의 경우, 100.0으로 나옴
  
desc sungjuk;


-- 테이블 삭제
-- drop table 테이블명

drop table abc;
drop table sungjuk;

-- 테이블이름 변경
-- alter table 테이블명
-- rename to 새이름

alter table emp
rename to employees;

-- 제약조건 추가하기
-- 테이블 생성 시 제약조건은 컬럼단위 또는 행 단위로 설정 가능함.

-- 컬럼단위 제약조건 : empid int primary key;

-- 행 단위 제약조건 : 
-- empid int primary key,
-- foreign key (deptid) references emp (deptid); 

-- 이것들의 단점은 테이블 생성시 반드시 같이 정의해야 한다는 데에서 오는 번거로움.
-- 복잡한 관계들로 구성된 테이블들을 생성시 번거로움이 발생한다.

-- 데이터베이스에 생성된 제약조건 확인
-- select * from 
-- information_schema.table_constraints;

select * from 
information_schema.table_constraints;

-- 기본 키 제약조건 생성
-- alter table 테이블명
-- add constraint 제약조건명 primary key (컬럼명);

create table employees (
 		employee_id int,
 		first_name varchar(25),
 		last_name varchar(25)
);

alter table employees
add constraint pk_emp 
-- 차후 검색의 편의를 위해 이름을 붙히는 것이기 떄문에 constraint 제약조건명 은 빼도 무방하다. 
-- 웬만하면 쓰는게 좋음. pk(primary key의 약자)_를 앞에 붙히는 것은 일종의 암묵적 룰같은 것.
primary key (employee_id);


-- 기본키 제약조건 제거
-- alter table 테이블명
-- drop primary key; (mysql/mariadb)

-- alter table 테이블명
-- drop constraint 제약조건명; (oracle)

alter table employees 
drop primary key;

desc employees;


-- 외래 키 제약조건 추가/제거
-- alter table 테이블명
-- add constraint 제약조건명 (구분을 위해 보통 맨 앞에 fk를 붙힘)
-- foreign key (컬럼명)
-- references 테이블명 (컬럼명);
-- 제약조건명 : fk _ 외래키를 포함하는 테이블 _ 기본 키 테이블

-- alter table 테이블명
-- drop constraint 제약조건명(만들 때 붙혔던 이름)

create table emp1 (
 		empid int,
 		fname varchar(25),
 		lname varchar(25),
 		deptid int
);

create table dept (
 		deptid int,
 		dname varchar(30),
 		mgrid int
);

alter table emp1
add constraint pk_emp primary key (empid);

alter table dept
add constraint pk_dept primary key (deptid);

alter table emp1
add constraint fk_emp_dept -- emp 테이블에서  dept를 참고한다는 의미.
foreign key (deptid)
references dept (deptid);


select * from 
information_schema.table_constraints;



-- not null 제약조건 추가
-- 컬럼에 null(빈값)을 입력못하게 설정하는 컬럼 제약 생성
-- 컬럼 단위 : 컬럼명  컬럼유형  not null


create table emp2 (
 		empid int,
 		fname varchar(25) not null,
 		lname varchar(25) not null,
 		job_id varchar(10),
 		comm decimal(5,2) 
);

-- 초기값 제약조건 추가
-- 컬럼에 데이터 입력 누락 시, 자동으로 값을 생성하게 해주는 제약
-- 컬럼 단위 : 컬럼명  컬럼유형  default 기본값

create table member(
	userid	varchar(20),
	passwd	varchar(20),
	name	varchar(10),
	grade	varchar(10) default 'bronze', -- 아무것도 입력 안하면 default는 bronze 가 됌.
	points	int default 1000,
	regdate timestamp default current_timestamp -- 현재시간을 자동으로 입력.
);


-- hr 데이터베이스의 테이블과
-- oe 데이터베이스의 테이블을 생성하고
-- alter 명령으로 기본키와 외래키 제약조건을 설정하세요.




