select * from web_member;

DROP TABLE web_member;
CREATE TABLE web_member(
	id VARCHAR2(100) PRIMARY KEY,
	password VARCHAR2(100) NOT NULL,
	name VARCHAR2(100) NOT NULL,
	address VARCHAR2(100) NOT NULL
)
SELECT * FROM web_member;
INSERT INTO web_member values('ajax','1','조승우','판교');
INSERT INTO web_member values('java','1','아이유','오리');
INSERT INTO web_member values('spring','1','강하늘','오리');
commit