-- sql 한줄 주석
/*
   sql 여러 줄 주석 : /* */
   sql 은 대소문자 구별하지 않는다(Data는 구별)
  
   SQL (Structured Query Language) : 데이터베이스를 제어하는 언어 
   									 데이터베이스를 정의,조작,제어하는 언어 (DDL, DML, DCL)
  
   DDL, DML, DCL ( SQL 은 다음과 같은 범주로 구분될 수 있다 )
   
    1. DDL ( Data Definition Language : 데이터 정의어 ) - CREATE 생성, DROP 삭제, ALTER 수정
    2. DML ( Data Manipulation Language : 데이터 조작어 ) - INSERT 삽입(추가), SELECT 조회, UPDATE 수정, DELETE 삭제 ( CRUD -Create, Read, Update, Delete )
    3. DCL ( Data Control Language : 데이터 제어어 ) - COMMIT 실제 DB에 반영(COMMIT되기 전에는 메모리에만 적재), / auto commit : 명령을 할 때마다 즉시 db에 반영
    											   ROLLBACK(TCL) 작업을 취소하고 원상태로 되돌린다,
    											   GRANT 권한부여, REVOKE 권한취소
    											   
   TABLE - 데이터를 저장하는 공간(데이터를 저장하는 상자)
   COLUMN - 속성 attribute
   CONSTRAINT - 제약조건 ex) PRIMARY KEY ( PK, 기본키, 주키 ) -> 중복 허용하지 않고 NOT NULL이어야 한다 ( UNIQUE + NOT NULL ) / 유일하고 값이 있어야한다
   DATA TYPE - 문자열 : VARCHAR2 ex) VARCHAR2(100) --> String(100);,
   			   숫자형 : NUMBER ...										   
  
 */

-- sql 실행 단축키 : 영역 지정 후 ALT + X (SQL 실행)
--				  혹시라도 안되면 파일 껐다가 다시 실행 해볼 것 
--				  한 라인 실행은 ALT + S (안 될 때도 있음)

-- 작업이 렉 걸렸을 때 : COMMIT 수행 : 실제 DB에 작업 결과를 반영( 명시적 수행 ) 
--					때로 잘 안될 때도 있음 

-- Succeeded 에서 파란생이면 정상 수행

--2번 실행시키면 Failed (이미 존재하기 때문에, 한 번 만들었기 때문)
--개발자가 짓는거는 소문자, 키워드는 대문자

-- DDL : 테이블 생성
CREATE TABLE member (--테이블 생성, ALTER 테이블 정보 변경
	-- id, password, name, address : 책상의 서랍
	id VARCHAR2(100) PRIMARY KEY, -- 기본키로 중복이나 널이면 안됌, 제약조건 : not null + unique
	password VARCHAR2(100) NOT NULL, -- 제약조건 not null
	name VARCHAR2(100) NOT NULL, -- 제약조건 not null
	address VARCHAR2(100)
)
-- DDL : 테이블 삭제
DROP TABLE member;
-- DML : 데이터 조회 Read(정보를 읽는다)
SELECT * FROM member; -- *는 모두 조회

-- DML : 데이터 삽입 Create
-- sql에서는 ''로 문자열 표현
-- INSERT는 CREATE행위이다 (CRUD)
INSERT INTO member(id, password, name, address) VALUES('java', 'a', '아이유', '오리'); --정보 삽입 확인은 SELECT로

INSERT INTO member(id, password, name, address) VALUES('spring', 's', '김서연', '전주');

-- 특정 컬럼( id, name ) 만 조회하고 싶을 경우
SELECT id, name FROM member;

-- ERROR : id 의 제약조건이 primary key -> unique + not null 이어야 하므로 제약조건에 위배되어 error (id가 중복)
INSERT INTO member(id, password, name, address) VALUES('java', 'b', '어이유', '죽전');
-- ERROR : id 의 제약조건이 primary key -> unique + not null 이어야 하므로 제약조건에 위배되어 error (id가 null) 
INSERT INTO member(password, name, address) VALUES('b', '어이유', '죽전');
-- ERROR : password 컬럼의 제약조건이 not null 이므로 반드시 insert 시에 데이터를 삽입해야 한다
INSERT INTO member(id, name, address) VALUES('jdbc', '어이유', '죽전');
-- SUCCESS : address 컬럼은 별도의 제약조건이 없으므로 null이 허용되어 정상수행
INSERT INTO member(id, password, name ) VALUES('jdbc', 'star', '박보검');

SELECT * FROM member;

-- WHERE 조건절을 잉요해 정보 조회 
-- id 가 java 인 회원의 name 과 address를 조회
SELECT name, address FROM member WHERE id = 'java'; -- ;가 없어도 실행은 되지만 문장의 끝을 알려주기 위해 사용 
-- 결과가 안나옴
SELECT name, address FROM member WHERE id = 'java2';
-- name 이 '아이유'이고 address 가 '오리'인 회원의 id를 조회
SELECT id FROM member WHERE name = '아이유' AND address = '오리'; --AND 나 OR 의 개수는 제한이 없다

-- id가 jdbc 인 회원 정보를 조회
SELECT * FROM member WHERE id = 'jdbc';
-- id 가 jdbc 인 회원 주소를 '제주'로 업데이트(수정)
UPDATE member SET address = '제주' WHERE id = 'jdbc';

-- id 가 jdbc 인 회원 정보를 삭제
DELETE FROM member WHERE id = 'jdbc';


-- 실제 DB에 작업 결과를 반영
COMMIT


-- DML ( CRUD : Create - insert, Read - select, Update - update, Delete - delete ) 연습

-- 회원 아이디 angel, 패스워드 kind, 이름 이상순, 주소 애월읍 정보를 insert
-- coulumn을 다 넣을 때는 member만 써도 되지만 원칙적으로 column을 다 써준다 
INSERT INTO member(id, password, name, address) VALUES ('angel', 'kind', '이상순', '애월읍');
-- 회원 name이 이상순 이고 address 가 애월읍인 회원의 id 와 password 를 select
SELECT id, password FROM member WHERE name = '이상순' AND address = '애월읍';
-- 회원의 address가 애월읍인 회원의 address를 오리로 update를 한다 
UPDATE member SET address = '오리' WHERE address = '애월읍'; 
-- 회원의 address가 오리인 회원의 id 와 name을 조회한다 
SELECT id, name FROM member WHERE address = '오리';
-- 회원의 id 가 angel이고 password가 kind인 회원 정보를 삭제 delete
DELETE FROM member WHERE id = 'angel' AND password = 'kind';
-- 회원 id가 angel 인 회원의 name을 조회 (삭제했으므로 조회경과는 없다)
SELECT name FROM member WHERE id = 'angel';
-- 안될 때는 DCL 인 COMMIT 으로 실제적으로 저장되게 한다   (DB에 반영시키는 것 : COMMIT)
COMMIT








