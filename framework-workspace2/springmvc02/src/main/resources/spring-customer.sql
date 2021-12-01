CREATE TABLE spring_customer(
	id VARCHAR2(100) PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100) NOT NULL
)
DROP TABLE spring_customer;
select count(*) from SPRING_CUSTOMER;
INSERT INTO spring_customer VALUES('java','아이유','판교');
select * from spring_customer;
commit