/* 

오라클 시퀀스(sequence)
: 순차적으로 증가, ★유일한 값★을 생성하기 위한 객체 
주로 primary key ( unique + not null ) 를 생성하기 위해 사용
테이블과는 독립적 구조 

실제 적용시 : 시퀀스명.nextval - 다음 시퀀스 값이 반환
ex) 실제 DAO 적용사례 
	insert into guestbook(guestbook_no, title) values(guestbook_seq.nextval, ?)
	
현재 시퀀스 값을 반환 받을 떄 : 시퀀스명.currval
단, currval 은 시퀀스를 nextval 한 세션 내에서만 사용가능(연결시작~연결종료시까지, 즉 nextval한 커넥션 내에서만 currval을 이용할 수 있다,같은 connection 내에서만 사용 가능)
(참고 - session : database에 사용자가 접속하여 ~ 접속 종료시까지 유지되는 정보)
                 database 가 connection 되고 close되기 까지를 말한다 )
시퀀스는 여러 사용자들이 사용하기 때문에 현재값이라는 것은 nextval한 당사자의 현재값을 말한다 
내가 카페에 글쓰기 했는데 nextval한 값을 보고 싶을 때

- 직접 상품 번호 매겨주는 것을 자동화하는 것  -> 유일한 값을 만들어 준다 
- 1씩 증가하는 일련번호라고 생각
- ex) 카페의 동일한 제목의 글은 어떻게 구분할까 --> sequence 필요 
	  글마다 내부적으로 sequence가 동작된다

​CREATE SEQUENCE 시퀀스명 
[START WITH 시작번호]
[INCREMENT BY 증가값]
[MAXVALUE 최대값] 
[MINVALUE 최소값]
[ CYCLE or NOCYCLE ]  --주기 설정 
[ NOCACHE ] --캐시, 임시메모리 영역을 20까지 잡아두고 빠르게 내보내는 것 

​Oracle dual table 
: 오라클에서 제공하는 ★기본 테이블★ (오라클의 함수, 산수연산 등에 사용)
컬럼 하나만 존재 , 주로 시퀀스 또는 날짜함수, 산술연산에 사용
sys Admin 계정에서 관리하고 수정 및 삭제 등 조작은 불가 

*/

--시퀀스는 테이블과 독립된 공간에 저장된다

-- 시퀀스 생성 : 시퀀스명 test_seq
CREATE SEQUENCE test_seq;
-- 시퀀스 삭제(새로 다시 시작해야 할 때)
DROP SEQUENCE test_seq;

-- 값 확인은 듀얼테이블 이용, DUMMY는 의미없는 테이블, COLUMN하나만 있다 
-- 오라클에서 제공하는 dual 테이블을 조회
SELECT * FROM DUAL;

-- dual 테이블을 이용한 예제
-- 연산시 사용
SELECT 2*5 FROM DUAL;
-- 현재시간 SYSDATE
SELECT SYSDATE FROM DUAL;-- 다른 테이블에 COLUMN하나 있어도 되지만 그렇게까지 할 것 없음
-- DUAL TABLE 이용해 시퀀스 값을 확인
-- 시퀀스명.NEXTVAL : 시퀀스 다음 값을 생성
-- TEST_SEQ 무조건 유일값을 만들어낸다 , 중간에 값이 빠져도 무조건 유일값이 목적
SELECT test_seq.nextval FROM DUAL; --0에서 1로 감 반복할 때마다 숫자가 늘어난다(거의 무한대까지)

-- DROP한 test_seq 시퀀스명을 다시 시퀀스를 생성해본다 ( 옵션을 start with 7 적용해서 생성 )
CREATE SEQUENCE test_seq START WITH 7;

-- CAR TABLE 을 생성해서 SEQUENCE를 이용해본다 
-- 자바같은 경우 합성어를 만들 때 CamelCase를 이용하지만 DB에서 이름을 줄 때는 합성어를 _로 준다 
CREATE  TABLE car(
	car_no number primary key,
	model varchar2(100) not null

)
-- car_seq sequence를 생성한다 
create sequence car_seq;
-- insert 시에 sequence 를 이용해 car_no 를 등록한다
-- car_no 가 계속 증가하는 것을 확인할 수 있음 
insert into car(car_no, model) values(car_seq.nextval, '테슬라');
insert into car(car_no, model) values(car_seq.nextval, '아이오닉');

select * from car;

-- guestbook table 에 sequence 를 이용
CREATE TABLE guestbook(
	guestbook_no NUMBER PRIMARY KEY,
	title VARCHAR2(100) NOT NULL,
	content VARCHAR2(1000) NOT NULL
	
)

CREATE SEQUENCE guestbook_seq;

----------------------------------------------------------------
-- Day05

-- currval 사용해보기

-- 시퀀스명.nextval
SELECT guestbook_seq.nextval from dual;
-- 시퀀스명.currval : 단독으로 사용될 수 없고, nextval 한 컨넥션 내에서 currval을 사용할 수 있다( 동일한 세션 내에서만 사용 가능 )
select guestbook_seq.currval from dual; 

-- 에러,
-- nextval 한 connection 상태에서만 사용 가능, because 여러 사용자들이 사용하기 때문에, 내가 글을 쓰는 와중에 

-- 내가 쓴 글에서 발급받았던 번호를 알기 위해서 currval 사용 
-- 자신이 nextval한 것에 대한 currval 을 반환★
-- client가 늘어나면 currval이 달라질 수 있다 











