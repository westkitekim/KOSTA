select * from member;

-- 로그인 sql
select name, address from member where id='java' and password='a';
-- 결과 안 나오는 2가지, rs.next() == false
select name, address from member where id='java' and password='b';
select name, address from member where id='java1' and password='a';

-- DAO, 강사님 sql
select name address from member where id=? and password=?;
-- DAO2 다른 sql
-- id에서 조회하고 서블릿에서 해결하는 방법
select password, name, address from member where id=?;



select id, name from member where address = '오리';


insert into member(id, password, name, address) values('jsp', 'jj', '이제훈', '의정부');
insert into member(id, password, name, address) values('spring', 's2', '한지민', '오리');
insert into member(id, password, name, address) values('python', 'p', '유태오', '의정부');

-- 회원정보수정 sql 
update member set password = 'j' and name = '이제훈' and address = '의정부' where id = 'jsp';

-- 회원가입 정보 등록
insert into member(id, password, name, address) values ('ruby', 'r', '홍길동', '산골짜기');

