create table abc(
	a int primary key
);

describe abc;
desc abc; -- ���̺� �ּ� Ȯ��(���� describe ���ΰ�)


-- x ��� �÷� �߰�(����(10))
alter table abc
add x varchar(10);

desc abc;


-- ���� �÷� ����
alter table abc
drop x;

desc abc;


-- ���� �÷� ����
-- alter table �÷���
-- modify column �÷�����;


-- ���������͸� �����ϱ� ���� ���̺� ����
-- �⺻ : �̸�, ����, ����, ����(���� ���ڷ� ����).
-- �߰� : ����, ���, ���� (��� ���ڷ� ����)


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


-- �÷������� �����ϱ�.

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
modify column mean decimal(5,1) -- ��ü �Ǽ� 5�ڸ� ��, �Ҽ��� �� ���ڸ�. ��, 100���� ���, 100.0���� ����
  
desc sungjuk;


-- ���̺� ����
-- drop table ���̺��

drop table abc;
drop table sungjuk;

-- ���̺��̸� ����
-- alter table ���̺��
-- rename to ���̸�

alter table emp
rename to employees;

-- �������� �߰��ϱ�
-- ���̺� ���� �� ���������� �÷����� �Ǵ� �� ������ ���� ������.

-- �÷����� �������� : empid int primary key;

-- �� ���� �������� : 
-- empid int primary key,
-- foreign key (deptid) references emp (deptid); 

-- �̰͵��� ������ ���̺� ������ �ݵ�� ���� �����ؾ� �Ѵٴ� ������ ���� ���ŷο�.
-- ������ ������ ������ ���̺���� ������ ���ŷο��� �߻��Ѵ�.

-- �����ͺ��̽��� ������ �������� Ȯ��
-- select * from 
-- information_schema.table_constraints;

select * from 
information_schema.table_constraints;

-- �⺻ Ű �������� ����
-- alter table ���̺��
-- add constraint �������Ǹ� primary key (�÷���);

create table employees (
 		employee_id int,
 		first_name varchar(25),
 		last_name varchar(25)
);

alter table employees
add constraint pk_emp 
-- ���� �˻��� ���Ǹ� ���� �̸��� ������ ���̱� ������ constraint �������Ǹ� �� ���� �����ϴ�. 
-- �����ϸ� ���°� ����. pk(primary key�� ����)_�� �տ� ������ ���� ������ �Ϲ��� �갰�� ��.
primary key (employee_id);


-- �⺻Ű �������� ����
-- alter table ���̺��
-- drop primary key; (mysql/mariadb)

-- alter table ���̺��
-- drop constraint �������Ǹ�; (oracle)

alter table employees 
drop primary key;

desc employees;


-- �ܷ� Ű �������� �߰�/����
-- alter table ���̺��
-- add constraint �������Ǹ� (������ ���� ���� �� �տ� fk�� ����)
-- foreign key (�÷���)
-- references ���̺�� (�÷���);
-- �������Ǹ� : fk _ �ܷ�Ű�� �����ϴ� ���̺� _ �⺻ Ű ���̺�

-- alter table ���̺��
-- drop constraint �������Ǹ�(���� �� ������ �̸�)

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
add constraint fk_emp_dept -- emp ���̺���  dept�� �����Ѵٴ� �ǹ�.
foreign key (deptid)
references dept (deptid);


select * from 
information_schema.table_constraints;



-- not null �������� �߰�
-- �÷��� null(��)�� �Է¸��ϰ� �����ϴ� �÷� ���� ����
-- �÷� ���� : �÷���  �÷�����  not null


create table emp2 (
 		empid int,
 		fname varchar(25) not null,
 		lname varchar(25) not null,
 		job_id varchar(10),
 		comm decimal(5,2) 
);

-- �ʱⰪ �������� �߰�
-- �÷��� ������ �Է� ���� ��, �ڵ����� ���� �����ϰ� ���ִ� ����
-- �÷� ���� : �÷���  �÷�����  default �⺻��

create table member(
	userid	varchar(20),
	passwd	varchar(20),
	name	varchar(10),
	grade	varchar(10) default 'bronze', -- �ƹ��͵� �Է� ���ϸ� default�� bronze �� ��.
	points	int default 1000,
	regdate timestamp default current_timestamp -- ����ð��� �ڵ����� �Է�.
);


-- hr �����ͺ��̽��� ���̺��
-- oe �����ͺ��̽��� ���̺��� �����ϰ�
-- alter ������� �⺻Ű�� �ܷ�Ű ���������� �����ϼ���.




