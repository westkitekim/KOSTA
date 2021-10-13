-- guestbook table 에 sequence 를 이용
CREATE TABLE guestbook(
	guestbook_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content VARCHAR2(1000) NOT NULL
	
)

CREATE SEQUENCE guestbook_seq;

SELECT * FROM GUESTBOOK

-- LIKE 연산자를 이용해 TITLE에 '즐' 문자열이 포함된 방명록 정보를 조회 
SELECT * FROM GUESTBOOK WHERE TITLE LIKE '%즐%';

-- 위 LIKE 적용 SQL을 PrepatedStatement 에 적용하는 방법은 아래와 같다 
/*
 * String sql = "SELECT * FROM GUESTBOOK WHERE TITLE LIKE '%' || ? || '%'"; ==> ?에 '즐'할당한다 
 */

