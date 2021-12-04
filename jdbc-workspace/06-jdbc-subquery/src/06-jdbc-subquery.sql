-- 항상 sql 파일 먼저 만드는 습관 ! (단위테스트 먼저)

-- 사원 테이블 생성 
-- varchar2 는 가변적, 크기를 크게 잡아줘도 데이터 크기만 있음 
create table s_employee(
	empno number primary key,
	name varchar2(100) not null, 
	job varchar2(100) not null,
	salary number not null

)

-- 시퀀스 생성 
create sequence s_employee_seq;

insert into S_EMPLOYEE(empno, name, job, salary) values(s_employee_seq.nextval, '아이유', '개발', 700);

insert into S_EMPLOYEE(empno, name, job, salary) values(s_employee_seq.nextval, '강하늘', '개발', 900);
insert into S_EMPLOYEE(empno, name, job, salary) values(s_employee_seq.nextval, '유재석', '총무', 600);
insert into S_EMPLOYEE(empno, name, job, salary) values(s_employee_seq.nextval, '박보검', '개발', 900);
insert into S_EMPLOYEE(empno, name, job, salary) values(s_employee_seq.nextval, '이상순', '총무', 600);



select * from S_EMPLOYEE;



-- sql 단위 테스트 

insert into s_employee(empno, name, job, salary) values(s_employee_seq.nextval, ?, ?, ?);


-- insert 실행하고 렉이 걸리면 (autocommit이 잘 안 될때 ) => 수동으로 commit 실행 

-- DAO2
/*
 * 해당 job(직종) 의 사원 중 가장 높은 salary를 받는 
 * 사원 정보를 조회하는 메서드 
 * 반환형은 여러개 일 수 있기 때문에 
 * 높은 연봉 받는 사람이 여러명 일 수 있기 때문에 ArrayList로 받고 
 * 형은 
 */

-- job 에 해당하는 사원의 가장 높은 salary 를 조회
-- 직업이 개발인 사람 중에서  최고값과 같은 row가 있을 수 있기 때문에 where 절에 
-- job = '개발' 추가 
select max(salary) from S_EMPLOYEE where job = '개발';
-- 위 sql에서 조회된 salary를 받는 사원 정보 
select empno, name, job, salary 
from s_employee
where job = '개발' 
and salary = (select max(salary) from S_EMPLOYEE where job = '개발');



select empno, name, job, salary from s_employee where salary = (select max(salary) from S_EMPLOYEE where job = '개발') and job = '개발';

select max(salary) from S_EMPLOYEE where job = '개발';















