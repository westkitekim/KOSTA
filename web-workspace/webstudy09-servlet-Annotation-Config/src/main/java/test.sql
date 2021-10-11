select * from member;

create table member (
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null,
	address varchar2(100) not null
)

insert into member values('java','a','아이유','오리');
insert into member values('servlet','s','강하늘','종로');

commit

select count(*) from member;