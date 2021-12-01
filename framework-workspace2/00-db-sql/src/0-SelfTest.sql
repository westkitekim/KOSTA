/*
오라클 시퀀스란? 
순차적으로 증가하는 유일한 값을 생성하기 위한 객체이ㅣ다 

순차적으로 증가하는 유일한 값을 생성하기 위한 객 체 
주로 primary key를 생성하기 위해 사용된다 
테이블과는 독립적인 구조 

사용시 시퀀스명.nextval 
currval 은 시퀀스를 nextval한 세션 내에서만 사용 가능 한 커넥션 내에서만, db에 사용자가 
접속하여 종료시까지 
create sequence 시퀀스명 
start with 시작번호 
increment by 증가값 
minvalue
maxvalue 
cycle / nocycle 
nocache
*/

/* 
 	정규형
 	Equi Join - 컬럼 정보가 정확하게 일치할 때 사용
 	
 	Non Equi Join - 
 	
 	
 	
 */

create table testself(
 no number primary key,
 title varchar2(100) not null,
 singer varchar2(30) not null,
 price number not null
)

create sequence seq;

insert into testself(no,title,singer,price) values(mp3_seq.nextval,'잊어야 한다는 마음으로','아이유',700);
insert into testself(no,title,singer,price) values(mp3_seq.nextval,'사람','지코',1000);
insert into testself(no,title,singer,price) values(mp3_seq.nextval,'밤편지','아이유',1000);
insert into testself(no,title,singer,price) values(mp3_seq.nextval,'도망가자','선우정아',1000);
insert into testself(no,title,singer,price) values(mp3_seq.nextval,'그날','박효신',1000);
insert into testself(no,title,singer,price) values(mp3_seq.nextval,'좋은밤 좋은꿈','너드커넥션',500);
insert into testself(no,title,singer,price) values(mp3_seq.nextval,'사계','태연',600);
insert into testself(no,title,singer,price) values(mp3_seq.nextval,'제발','이소라',1000);

select * from testself;

select row_number() over(order by no desc) as rnum, no, title from testself;
drop table testself;

select row_number() over(order by no desc) as rnum, 









