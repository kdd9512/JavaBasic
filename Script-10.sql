-- 기본키 설정 (完)

alter TABLE REGIONS
ADD CONSTRAINT PK_REG_ID
PRIMARY KEY (REGION_ID);

alter TABLE COUNTRIES 
ADD CONSTRAINT PK_CNT_ID
PRIMARY KEY (COUNTRY_ID);

alter TABLE LOCATIONS 
ADD CONSTRAINT PK_LOC_ID
PRIMARY KEY (LOCATION_ID);

alter TABLE DEPARTMENTS 
ADD CONSTRAINT PK_DPT_ID
PRIMARY KEY (DEPARTMENT_ID);

alter TABLE JOBS 
ADD CONSTRAINT PK_JOB_ID
PRIMARY KEY (JOB_ID);

alter TABLE EMPLOYEES 
ADD CONSTRAINT PK_EMP_ID
PRIMARY KEY (EMPLOYEE_ID);

-- 외래키 설정
ALTER TABLE 