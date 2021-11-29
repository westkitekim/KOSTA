/*
	JOIN SQL - 여러 테이블을 결합하여 정보를 조회하기 위한 SQL (정규화 과정을 거쳐 테이블이 분할되면 여러 테이블을 조합하여 정보 생성) 
	
		1. INNER JOIN - 일반적으로 조인이라고 하는 SQL을 의미
						조인 조건에 부합되는 행에 대해서만 조회
						1) Equi Join - 조인 대상 테이블의 상응하는 컬럼 정보가 정확하게 일치하는 경우의 JOIN
									   (ex. 부서 테이블과 사원 테이블간의 부서번호가 일치할 때 조인)
									   
						2) Non Equi Join - 조인 대상 테이블 간의 상응하는 컬럼 정보가 없을 때 사용하는 JOIN
										   ★테이블 간의 컬럼 값들이 정확하게 일치하지 않을 때★ 사용하는 JOIN
										   (ex. 사원 테이블과 월급 등급 테이블간의 일치하는 컬럼은 없지만 사원의 월급 등급을 
										    	알기 위해 월급 등급 테이블의 hisal, losal 과 사원 테이블의 sal 을 비교)
										    	
		2. Outer JOIN - JOIN 조건에 부합되지 않더라도 모든 행을 반환
						( 부서 테이블과 사원 테이블 조인시 INNER JOIN은 사원이 없는 부서는 제외 
						  OUTER JOIN은 사원이 없는 부서라도 모두 조회 )
						  
		3. Self JOIN - 동일 테이블 상에서의 조인 ( 사원 테이블의 매니저 컬럼의 정보는 또 다른 사원 정보이다. 이를 이용해 
											사원의 매니저인 사원번호, 사원명 등을 조회할 때 Self JOIN 을 사용 )

*/

-- 1. Inner Join 

--	1) equi join
-- 사원 정보 조회시 사원이 속한 부서 정보까지 함께 조회 
select e.empno, e.ename, e.job, d.deptno, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
-- 위의 sql 을 아래와 같이 표현할 수도 있다
select e.empno, e.ename, e.job, d.deptno, d.dname, d.loc
from emp e
inner join dept d on e.deptno = d.deptno

-- 	2) non equi join, 비등가조인
-- 사원 테이블(emp) , 월급등급 테이블(salgrade)
--      sal            hisal, losal
-- 두 테이블간의 연관성은 사원 테이블의 sal 과 월급등급 테이블의 hisal 최고액 , losal 최저액 사이에 있다
select * from emp where ename='SMITH'; -- sal이 800

-- Inner Join ( non equi join )
select e.empno, e.ename, s.grade, e.sal, s.losal, s.hisal 
from emp e, salgrade s
where e.sal >= s.losal and e.sal <= s.hisal
and e.ename='SMITH'


/*
 		2. Outer Join : 일반적인 조인(= Inner Join) 조건에 만족하지 않는 경우에도 조회하기 위해 사용 
 						(ex. 부서와 사원 테이블 조인시 사원이 존재하지 않는 부서정보도 조회하기 위해 Outer Join을 사용)
 						(ex. 올리브영 회원등급!!- 등급에 따라 다양한 %의 할인쿠폰 지급 여부 결정!) 
 						// ex. 회원테이블, 요금제테이블이 있다고하자 
 						// 회원이 어떤 요금제를 쓰는지 알고 싶으면 -- ▣ join 
 								회원테이블 					요금제테이블
 							아이유		1			1. 넷플릭스 초이스 - 90,000
 							강하늘		2			2. 지니 초이스    - 
 							김연아 		1			3. 에어팟 초이스   -
 							
 						   회원 현황을 보는데 에어팟 초이스라는 요금제를 사용하는 회원은 없다
 						   그러나 현황에서 현재 아무도 가입하지 않았지만 현황을 알고 싶으면 -- ▣ outer join
 						   
 						   select 
 						   from 회원, 요금제
 						   where 회원.요금제번호 = 요금제.요금제번호
 						
 						
 						
 						사용방법 : JOIN 조건에 (+) 를 명시 -> 조인 시킬 값이 없는 측에 표기
 						
 						사용 예시) 
 						select column, column ..
 						from table1, table2 ... 
 						where table1.컬럼(+) = table2.컬럼
 						
 						select column, column 
 						from table1, -- 이 테이블을 기준으로 데이터조회(부서테이블, 사원이 없는 부서정보까지 포함시켜야하므로)
 						left outer join table2 on 컬럼 = 컬럼 
		
 */
-- distinct 중복제거 ㄴ
select distinct deptno from dept; -- 10, 20, 30, 40 번 부서가 존재
select distinct deptno from emp; -- 10, 20, 30 번 부서가 존재

-- inner join : 조인하는 테이블 간의 컬럼값이 일치되지 않는 경우는 조회되지 않는다
--				즉 사원이 존재하지 않는 40번 부서는 정보가 조회되지 않는다
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from dept d, emp e
where d.deptno=e.deptno

SELECT * FROM emp;

-- outer join : (+) outer join 기호는 데이터가 없는 측에 명시
-- (+)연산자는 데이터가 없는 쪽에 붙여준다. 40번은 부서테이블에 있고 사원테이블에 없으므로 사원테이블에 붙여줌
-- 40번 부서가 출력되는 것을 확인한다
-- 40번 부서정보는 부서테이블에 존재, 40번 부서에 속한 사원이 없으므로 사원테이블에 outer join 연산기호를 표시한다
-- outer join을 실행한 결과를 보면 사원이 존재하지 않는 40번 부서정보까지 모두 조회 
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from dept d, emp e
where d.deptno=e.deptno(+)

-- 아래와 같이 Outer Join을 표현할 수 있다
-- 기준이 되는 테이블은 column이 다 있는 테이블 --> 이렇게 기준이 되는 테이블을 모두 표현하는 것 
-- left join 은 왼쪽을ㅁ 기준으로 결합 ,왼쪽 테이블이 모든 column을 가지고 있고
-- right join은 오른족이 기준이 되며 오른족 테이블이 모든 column을 가지고 있음
-- 1. left인 dept d 가 기준(다 있는것, 왼). <부서테이블 기준으로 사원을 붙임!!>(left outer)
-- 왼쪽이 다 나오도록??? 
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from dept d
left outer join emp e on d.deptno=e.deptno
-- 2. right인 dept d가 기준 
-- left, right 순서만 변경, 같은 결과 반환
-- 오른쪽은 다 나오도록
select e.empno, e.ename, e.deptno, d.deptno, d.dname
from emp e
right outer join dept d on d.deptno=e.deptno


/*
		3. Self Join : 테이블 자체에서(동일한 테이블 내) 조인 
					   동일한 테이블이지만 개념적으로 다른 정보를 결합 
					   ex. 사원테이블의 매니저 번호는 또 다른 사원의 사원번호이다
					   	   하나의 사원테이블에서 사원정보와 그 사원의 매니저 정보를 
					   	   함께 조회하고자 할 때 self join을 이용한다
					  
 */

select * from emp;
-- 7902 사원의 매니저 번호는 7566이고 7566은 또 다른 사원의 사원번호이다
select empno, ename, mgr from emp where empno = 7902
select empno, ename, mgr from emp where empno = 7566

-- 사원의 사원번호 empno, 사원명 ename, 매니저번호 mgr, 매내저명(다른 사원명) 을 조회하고자 한다 -> 이 때 self join을 이용
-- 사원을 조회하고자 하는데, 사원에 대한 정보뿐만 아니라 상급 관리자의 사원정보까지 알고싶을 때 사용
-- from emp e, emp m 으로 별칭을 다르게 준다 

select e.empno, e.ename, e.mgr, m.empno, m.ename
from emp e, emp m
where e.mgr = m.empno
and e.empno = 7902;

-- Inner Join : 13명 사원 정보가 조회 -> mgr이 없는 king 사원이 조회 대상에서 제외
select e.empno, e.ename, e.mgr, m.empno, m.ename
from emp e, emp m
where e.mgr = m.empno

select * from emp; -- 14명 사원

-- Outer Join : 위의 Inner Join 시 결과행은 13명이 조회된다. 이유는 mgr이 없는 king 사원이 제외되었기 때문
-- 				매니저가 없는 사원까지 모두 조회하고자 할 때 Outer Join을 이용한다
--				사원 정보는 존재하고 매니저 정보가 존재하지 않으므로 매니저 측에 Outer Join 연산자를 명시하면 된다
--				mgr이 없는 값이 있기 때문에 m.empno에 (+) 표시

-- emp e - 사원, emp m - 매니저
select e.empno, e.ename, e.mgr, m.empno, m.ename
from emp e, emp m 
where e.mgr = m.empno(+)

select e.empno, e.ename, e.mgr, m.empno as 매니저번호, m.ename as 매니저명
from emp e, emp m 
where e.mgr = m.empno(+)


-- join sql 연습 
-- empno 가 7369 인 사원의 사원명 ename, 부서명 dname, 월급등급 grade, 매니저명 mgr 의 ename 으로 조회 
-- emp table, dept table, salgrade table, emp manager table
-- SMITH, RESERCH, FORD, 1
select e.ename, d.dname, s.grade, m.ename as mgr_name
from emp e, dept d, salgrade s, emp m
where e.deptno = d.deptno
and e.sal >= s.losal
and e.sal <= s.hisal
and e.mgr = m.empno
and e.empno = 7369


-- 사원의 사원명 ename, 부서명 dname, 월급등급 grade, 매니저명 mgr 의 ename 으 조회
-- 매니저가 없는 사원까지 모두 조회한다 ( Outer join 을 이용 ) 
select e.ename, d.dname, s.grade, m.ename as mgr_name
from emp e, dept d, salgrade s, emp m
where e.deptno = d.deptno
and e.sal >= s.losal
and e.sal <= s.hisal
and e.mgr = m.empno(+)























