/*
	SQL : 데이터베이스를 정의 조작 제어하는 언어 
		  1. DDL 데이터 정의어 - CREATE, DROP, ALTER
		  2. DML 데이터 조작어 - INSERT, SELECT, UPDATE, DELETE (CRUD; Create, Read, Update, Delete)
		  3. DCL 데이터 제어어 - COMMIT, ROLLBACK
	궁극적으로 SQL을 이용하여 JAVA 

*/

-- DATA TYPE : 문자열 - VARCHAR2(), 오라클에서 권장하는 문자열 타입
--			   정수, 실수 - NUMBER

-- DDL : CREATE 로 테이블 생성 
CREATE TABLE typetest (
	name VARCHAR2(9) PRIMARY KEY,
	money NUMBER NOT NULL
)

-- DML : INSERT
-- ERROR : NAME의 최대 사이즈가 9, 아래는 10개의 문자열이 들어갔으므로 ERROR
INSERT INTO typetest(name, money) VALUES('abcdefghij', 100); -- 데이터는 대소문자 구분 
INSERT INTO typetest(name, money) VALUES('abcdefghi', 100); -- 데이터는 대소문자 구분
-- ERROR : 한글은 한 글자당 3byte를 차지한다. 따라서 아래는 총 12byte이므로 제한을 초과하여 ERROR 
INSERT INTO typetest(name, money) VALUES('아이유님', 100); -- 데이터는 대소문자 구분 
-- 9byte라서 정상 실행(설정한 최대 제한 용량)
INSERT INTO typetest(name, money) VALUES('아이유', 100); -- 데이터는 대소문자 구분 

-- DML : SELECT
SELECT name, money FROM typetest;


-- DML : UPDATE
-- NAME 이 아이유인 대상의 money를 +200 해본다
UPDATE typetest SET money = money + 200 WHERE name = '아이유';

-- DDL : DROP - 테이블을 삭제 
DROP TABLE typetest;

-- DDL : ALTER - 테이블 정보를 변경 ( TABLE 명 변경, COLUMN 명 변경, 제약조건 및 타입 변경 )

CREATE TABLE altertest (
	id VARCHAR2(100) PRIMARY KEY,
	hit NUMBER DEFAULT 0 -- 안 넣어주면 기본값이 0  DEFAULT 없으면 NULL로 들어간다 
)

-- DEFAULT 제약조건 : 별도로 INSERT 하지 않으면 0으로 초기값이 저장
-- DML : INSERT, hit는 DEFAULT에 의해 0으로 저장된다
INSERT INTO altertest(id) VALUES('java');
SELECT id, hit FROM altertest;

-- DDL : ALTER를 이용해서 테이블명을 altertest2 로 변경해본다 
ALTER TABLE altertest RENAME TO altertest2;
SELECT id, count FROM altertest2;
-- DDL : ALTER를 이용해서 컬럼명을 hit에서 count로 변경해본다 
ALTER TABLE altertest2 RENAME COLUMN hit to count;

---------------------------------------------------------
/*
 * day03
 * 테이블명 : product
 * 컬럼명 : id, name, maker, price 
 * 데이터타입 : id, price 는 number 
 * 			 name, maker 는 varchar2(100)
 * 제약조건 : id 는 primary key
 * 		   name, maker 는 not null
 * 		   price 는 default 0
 */

-- DDL
CREATE TABLE product (
	id NUMBER PRIMARY KEY,
	name VARCHAR2(100) NOT NULL,
	maker VARCHAR2(100) NOT NULL,
	price NUMBER DEFAULT 0
)

-- DML
INSERT INTO product VALUES (1, '불닭볶음면', '삼양', 1500);
INSERT INTO product VALUES (2, '진라면', '오뚜기', 1100);
INSERT INTO product VALUES (3, '테라', '하이트진로', 1800);
INSERT INTO product VALUES (4, '참이슬후레쉬', '하이트진로', 1300);

-- DCL
COMMIT -- 실제 DB에 반영 
	   -- 메모리에 있는 데이터가 DB에 반영이 안되어있을 경우를 대비해 실행

-- 데이터 함수 사용해보는 법  이전 공부
-- DML : SELECT
SELECT * FROM product;

-- 데이터베이스 함수 테스트 
-- COUNT(*) : 총 개수 반환, 조회하려는 데이터의 모든 개수 반환
SELECT COUNT(*) FROM product; -- 총 상품 수 
SELECT COUNT(*) FROM member; -- 총 회원 수(이전에 했던 SQL 파일) 

-- * : OPTIMIZER 가장 최선의 방식으로 우리가 원하는 product의 수를 반환 

-- 상품 최저가 
SELECT MIN(price) FROM product; -- 전체 상품의 최저가, price COLUMN의 최저값 반환
-- 상품 최고가
SELECT MAX(PRICE) FROM PRODUCT; -- 전체 상품의 최고가, price COLUMN의 최고값 반환 
-- 상품 평균값
SELECT AVG(PRICE) FROM PRODUCT;
-- 상품 평균값 반올림
SELECT ROUND(AVG(PRICE)) FROM PRODUCT;

-- 정렬 : 오름차순 정렬, 내림차순 정렬 
-- 1. PRICE 오름차순 정렬 
-- 	  ORDER BY 만 명시하면 기본(DEFAULT) 오름차순 정렬 
SELECT NAME,PRICE FROM PRODUCT ORDER BY PRICE; --ORDER BY 다음에 정렬할 COLUMN
SELECT NAME,PRICE FROM PRODUCT ORDER BY PRICE ASC; -- 위와 동일한 코드 
-- 2. PRICE 내림차순 정렬 
SELECT NAME,PRICE FROM PRODUCT ORDER BY PRICE DESC;

/* < 순서 > 
 *  SELECT - SELECT 다음에는 COLUMN
 * 	FROM
 *  WHERE 
 * 	ORDER BY - 가장 마지막에 작성
 */
-- MAKER가 하이트진로인 상품의 ID, NAME, PRICE를 조회하되
-- PRICE 내림차순으로 정렬되게 하세요
SELECT ID, NAME, PRICE 
FROM PRODUCT 
WHERE MAKER = '하이트진로' 
ORDER BY PRICE DESC;

SELECT * FROM PRODUCT;

-- PRICE 가 1300 이상, 2000 이하인 상품의 NAME 과 PRICE 를 조회 ( PRICE 오름차순 )
SELECT NAME, PRICE 
FROM PRODUCT 
WHERE 1300 <= PRICE AND PRICE <= 2000 
ORDER BY PRICE ASC;
-- BETWEEN AND 로 위의 SQL을 표현할 수 있다 
SELECT NAME, PRICE 
FROM PRODUCT 
WHERE PRICE BETWEEN 1300 AND 2000
ORDER BY PRICE ASC;

-- SUBQUERY
SELECT MAX(PRICE) FROM PRODUCT
SELECT NAME FROM PRODUCT WHERE PRICE = 1800;
-- 위의 두 SQL 을 하나의 SQL 로 표현
SELECT NAME FROM PRODUCT WHERE PRICE = (SELECT MAX(PRICE) FROM PRODUCT);

-- PRIMARY KEY로 검색해서 상품 존재 유무 확인 
-- NEXT는 어찌되었든 실행된다 (0번지에 있다고 생각) 테이블은 1부터 시작 
SELECT COUNT(*) FROM PRODUCT WHERE ID = 1; -- 존재하면 1
SELECT COUNT(*) FROM PRODUCT WHERE ID = 7; -- 없으면 0 

-- 컬럼 별칭 
SELECT MIN(PRICE) FROM PRODUCT; -- COLUMN에 함수명인 MIN(PRICE)로 출력 
SELECT MIN(PRICE) AS 최저가 FROM PRODUCT; -- AS ??? 을 통해 COLUMN의 별칭을 만들어준다 

-- MAKER 조회 ( 중복된 MAKER 정보까지 모두 조회 - 탈곡기 탈탈 )
SELECT MAKER FROM PRODUCT;

-- DISTINCT : MAKER 종류를 조회( 중복없이 MAKER 종류만 조회 )
SELECT DISTINCT MAKER FROM PRODUCT;

----------------------------------------------------------------
-- sql4

----------------------------------------------------------------

-- LIKE 연산자 : 일부가 포함되는 내용은 검색하는 연산자 (웹의 검색 기능에서 많이 사용됨)(ex. '감사' 라는 문자열이 포함된 문자열 검색 ETC)
-- 사용법 : WHERE 컬럼명 LIKE '%검색키워드%'
-- % : 0개 이상의 문자 ( 양 옆에 어떤 문자가 있든 특정키워드 있는 문자열 검색 )
SELECT * FROM PRODUCT WHERE NAME LIKE '%면%'; --불닭볶음면, 진라면 반환 
SELECT * FROM PRODUCT WHERE MAKER LIKE '%트진%'; --하이트진로 반환 
-- 어플리케이션 테스트 : 04-jdbc 프로젝트의 TestGuestBookDAO4에서 확인해본다 



























































