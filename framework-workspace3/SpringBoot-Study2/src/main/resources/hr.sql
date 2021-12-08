drop table springboot_department;
create table springboot_department(
	deptno number primary key,
	dname varchar2(100) not null,
	loc varchar2(100) not null
)

select * from springboot_employee;
create table springboot_employee(
	empno number primary key,
	ename varchar2(100) not null,
	sal number not null,
	deptno number not null,
	constraint fk_springboot_deptno foreign key(deptno) references springboot_department(deptno)
)


insert into springboot_department values(10,'전략기획','판교');
insert into springboot_department values(20,'해양수산','부산');
insert into springboot_department values(30,'공공사업','판교');

-- 부서 테이블에는 40번 부서가 없으므로 error , 참조 무결성 제약조건 위배 
-- insert into springboot_employee values(4,'아이유',300,40);
insert into springboot_employee values(1,'아이유',300,10);
insert into springboot_employee values(2,'조승우',500,10);
insert into springboot_employee values(3,'배두나',400,20);
insert into springboot_employee values(4,'유재석',700,10);

commit
select * from springboot_department;
select * from springboot_employee;

-- JOIN SQL : 하나 이상의 테이블을 결합하여 조회 
-- INNER JOIN : 조인 조건에 부합되는 정보를 조회 
-- OUTER JOIN : 조인 조건에 부합되지 않는 정보까지 모두 조회 
-- SELF JOIN : 하나의 테이블 자체에서 조인 


-- findEmployeeAndDeptByEmpNo
select e.ename, d.dname, d.loc
from springboot_employee e,springboot_department d
where e.deptno=d.deptno
and e.empno=1

-- findEmployeeAndDeptListOuterJoin : outer join 
select e.empno,e.ename,d.deptno,d.dname
from springboot_employee e,springboot_department d
where e.deptno(+)=d.deptno
-- LEFT OUTER JOIN 으로 표현 
select e.empno,e.ename,d.deptno,d.dname
from springboot_department d 
left outer join springboot_employee e 
on e.deptno=d.deptno

-- getEmpGroupByDeptno
-- group by 
select deptno,count(*) as emp_count
from springboot_employee
group by deptno

-- inline view 를 이용해서 join -> 부서명을 조회 
select	g.deptno,d.dname,g.emp_count
from (
	select deptno,count(*) as emp_count
	from springboot_employee
	group by deptno
) g, springboot_department d
where g.deptno=d.deptno
order by g.deptno desc

-- 조회 결과가 null 인 값을 다른 값으로 치환하는 함수  nvl(컬럼,치환값)
select nvl(null,0) from dual;


-- inline view 를 이용해서 outer join -> 부서명을 조회 ( 조회시 사원이 없는 부서 정보도 조회 ) 
select	d.deptno,d.dname,nvl(g.emp_count,0) as emp_count
from (
	select deptno,count(*) as emp_count
	from springboot_employee
	group by deptno
) g, springboot_department d
where g.deptno(+)=d.deptno
order by g.deptno desc











