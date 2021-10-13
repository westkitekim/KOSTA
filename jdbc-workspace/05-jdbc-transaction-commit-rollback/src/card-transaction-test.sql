-- Transaction
-- 테이블을 따로 생성 ?! 
CREATE TABLE card(
	id VARCHAR2(100) PRIMARY KEY,
	name VARCHAR2(100) NOT NULL
)
CREATE TABLE point(
	id VARCHAR2(100) PRIMARY KEY, 
	point_type VARCHAR2(100) NOT NULL,
	point NUMBER NOT NULL
)

SELECT * FROM card; -- 카드 발급
SELECT * FROM point; -- 포인트 발급 

DELETE FROM card;
DELETE FROM point;

-- db에 반영함으로써 확실하게 지움 
commit 













