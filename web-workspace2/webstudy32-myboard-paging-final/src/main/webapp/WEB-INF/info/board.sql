create table board_member(
	id varchar2(100) primary key,
	password varchar2(100) not null,
	name varchar2(100) not null
)
insert into board_member(id,password,name) values('java','a','아이유');
insert into board_member(id,password,name) values('spring','a','강하늘');

select * from BOARD_MEMBER;

create table board(
	no number primary key,
	title varchar2(100) not null,
	content clob not null,
	hits number default 0,
	time_posted date not null,
	id varchar2(100) not null,
	constraint myboard_fk foreign key(id) references board_member(id)
)

create sequence board_seq nocache;

insert into board(no,title,content,time_posted,id) values(board_seq.nextval,'불금','즐거운 공부시간',sysdate,'java');

insert into board(no,title,content,time_posted,id) values(board_seq.nextval,'즐주말','즐거운 주말',sysdate,'spring');

commit

select * from board;

-- 게시물 리스트 조회 ( no, title, writer(member의 name), time_posted, hits ) 
-- writer 는 회원명을 의미, board table과 board_member table 을 조인 ( inner join )
-- 리스트에서는 작성일시이므로 to_char() 함수를 이용해 작성일을 조회한다
select b.no, b.title, m.name, to_char(b.time_posted, 'YYYY.MM.DD'), b.hits
from board b, board_member m
where b.id=m.id
order by b.no desc

-- 로그인 sql : id와 password가 일치하면 정보 조회 , 아니면 정보 조회가 되지 않는다
select name from board_member where id='java' and password='a'; 

-- 조회수 확인
select hits from board where no=1;

-- 조회수 증가
update board set hits= hits+1 where no=1;

-- 상세 게시글 보기 
select b.no, b.title, m.id, m.name, b.content, b.hits, to_char(b.time_posted, 'YYYY.MM.DD HH24.MI.SS') as time_posted
from board b, board_member m
where b.id = m.id and b.no = 1;



















