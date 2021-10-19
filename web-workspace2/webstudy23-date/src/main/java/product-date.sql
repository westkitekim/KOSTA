/*
 	MVC + Front Controller 상에서 date 형을 이용해 프로그래밍 연습을 하기 위한 테이블  
 */ 

create table mvc_product(
	id number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null,
	regdate date not null
)

create sequence mvc_product_seq;
-- 20번대로 건너뛰는 것 제외하고 싶을때 캐시 사용 안함으로 설정
-- 하지만 실제에서 사용하지는 않는다 (서버를 계속 가동해야 하기 때문?)
-- create sequence mvc_product_seq nocache;

insert into mvc_product(id, name, maker, price, regdate) values(mvc_product_seq.nextval, '갤럭시21', '삼성', 100, sysdate);

commit
select * from mvc_product;


select id, name, maker, price, regdate from mvc_product where id = 1;

-- to_char()를 이용해 select 테스트 
-- sample : SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;
select name, maker, price, to_char(regdate,'YYYY-MM-DD HH24:MI:SS') from mvc_product where id = 1;
-- 강사님
--regdate를 string으로 가져아야 함 
select name, maker, price, to_char(regdate, 'YYYY-MM-DD HH24:MI:SS') from mvc_product where id = 1;


insert into mvc_product(id, name, maker, price, regdate) values(mvc_product_seq.nextval, '호박고구마', '땅끝마을', 1000, sysdate);

create sequence mvc_product_seq nocache; 
-- 캐시 사용하지 않아서 20건너뛰지 않는데 실제로 서버를 사용할 때는 캐시를 안 잡을 이유가 없다(빨리 하기 위해)cache는 무한대 , 목적은 유일값을 주기위한 것이다
--db 정상적으로 stop 시키면 상관없다
--실제 프로그램시에 1,2,3,4,5,6.. 순서대로 가야하는 것은 아니다
--일련번호 주는 것은 rownum 기술


select id, name, maker, price, to_char(regdate, 'YYYY.MM.DD') from mvc_product order by id desc;

-- product list sql
select name, maker, to_char(regdate, 'YYYY.MM.DD') from mvc_product order by id desc




















