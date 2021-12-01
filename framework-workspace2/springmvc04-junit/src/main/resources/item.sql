create table spring_item(
	item_no number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
)
create sequence spring_item_seq;
insert into spring_item values(spring_item_seq.nextval,'참이슬','진로',100);
insert into spring_item values(spring_item_seq.nextval,'처음처럼','롯데',200);
commit

select item_no,name,maker,price from spring_item
where item_no=1;

select * from spring_item;

-- reg_date 컬럼을 추가
-- 기존의 데이터가 있는 상태에서 not null 조건을 줄 수 없다
-- 따라서 추가한 컬럼의 제약조건을 따로 지정해줘야 함(아래아래아래 코드 )
alter table spring_item add reg_date date;
-- 컬럼추가 하고 update 해야 정상적으로 db에 데이터 들어감
update spring_item set reg_date=sysdate;

select item_no, name, maker, price, to_char(reg_date, 'YYYY-MM-DD HH24:MI:SS')as regDate 
from spring_item;

-- reg_date 컬럼의 제약조건을 추가 
alter table spring_item modify reg_date not null;

commit 

















