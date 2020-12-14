create table customers ( -- �� ���̺�
	custid 	varchar(16) primary key, -- �ߺ� ������ �Է¹��� ���� primary key
	name   	varchar(10), -- �ѱ��� ����Ʈ �������� ������ 2������ ���� 
	age 	int,
	grade	varchar(10),
	job		varchar(10),
	pnt		int
);
create table products ( -- ��ǰ ���̺�
	prdno 		char(4) primary key,
	prdname		char(4),
	stock		int,
	price		int,
	prdmaker	varchar(10)	
);

create table orders ( -- �ֹ� ���̺�
	ordno 	int primary key,
	custid	varchar(16), -- �� ���̺��� ���� ���� 
	prdno	char(4), -- ��ǰ ���̺��� ���� ����
	qty		int,
	addr 	varchar(20),
	orddate	datetime -- ��¥�̹Ƿ� datetime ���� ����.
);



-- �ܷ�Ű ����
-- foreign key (�÷���)
-- references ���̺�� (�÷���)

-- �ֹ� - �� ���̺� �� ���� ���� 
-- �ֹ� - ��ǰ ���̺� �� ���� ����


create table orders2 ( -- �ֹ� / �� �ܷ�Ű ����.
	ordno 	int primary key,
	custid	varchar(16), -- �� ���̺��� ���� ���� 
	prdno	char(4), -- ��ǰ ���̺��� ���� ����
	qty		int,
	addr 	varchar(20),
	orddate	datetime, -- ��¥�̹Ƿ� datetime ���� ����.
	foreign key (custid)
	references customers (custid)

);

create table orders3 ( -- �ֹ� ���̺�
	ordno 	int primary key,
	custid	varchar(16), -- �� ���̺��� ���� ���� 
	prdno	char(4), -- ��ǰ ���̺��� ���� ����
	qty		int,
	addr 	varchar(20),
	orddate	datetime, -- ��¥�̹Ƿ� datetime ���� ����.
	foreign key (prdno)
	references products (prdno)
);

create table orders4 ( -- �ֹ� ���̺�
	ordno 	int primary key,
	custid	varchar(16), -- �� ���̺��� ���� ���� 
	prdno	char(4), -- ��ǰ ���̺��� ���� ����
	qty		int,
	addr 	varchar(20),
	orddate	datetime, -- ��¥�̹Ƿ� datetime ���� ����.
	foreign key (custid)
	references customers (custid),
	foreign key (prdno)
	references products (prdno)
);


-- �� �ܷ�Ű ���������� ������ ������
-- ���̺� ���������� �����ؾ� �Ѵ�.
-- �� -> ��ǰ -> �ֹ�
















