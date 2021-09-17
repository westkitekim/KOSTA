/*
   IN 연산자
   : 특정값이 포함되는 데이터를 조회하고자 할 때 사용하는 연산자 
   
   select 컬럼, 컬럼
   from 테이블명
   where 컬럼 in('또래오래', '대한곱창');
   
   NOT IN 연산자 
   특정 값이 포함되지 않는 데이터를 조회하고자 할 때 
   
   -- 또래오래와 대한곱창 제조사가 아닌 음식정보를 조회 
   select 컬럼, 컬럼
   from 테이블명
   where 컬럼 not in('또래오래', '대한곱창');
   
   and / or 연산자로 대체하여 사용할 수 있지만
   in / not in 연산자는 서브쿼리를 사용할 수 있다는 장점이 있기 때문에 복잡한 수식에 사용됨 
 */




-- in 사용 예시
-- maker가 대한곱창, 이춘복참치 인 food 정보를 조회 
select id, name, maker, price 
from food 
where maker in('대한곱창', '이춘복참치');

-- 위 sql을 in을 사용하지 않고 아래와 같이 표현할 수 있다 
select id, name, maker, price 
from food  
where maker = '대한곱창' or maker = '이춘복참치';

-- not in 사용 
select id, name, maker, price 
from food 
where maker not in('대한곱창', '이춘복참치');

-- 위 sql을 in을 사용하지 않고 아래와 같이 표현할 수 있다 
select id, name, maker, price 
from food  
where maker <> '대한곱창' and maker <> '이춘복참치';

create table food (
	id number primary key,
	name varchar2(100) not null,
	maker varchar2(100) not null,
	price number not null
)



create sequence food_seq;

insert into food(id, name, maker, price) values(food_seq.nextval, '후라이드', '또래오래', 15000);
insert into food(id, name, maker, price) values(food_seq.nextval, '소곱창', '대한곱창', 20000);
insert into food(id, name, maker, price) values(food_seq.nextval, '양념치킨', '또래오래', 16000);
insert into food(id, name, maker, price) values(food_seq.nextval, '참치회', '이춘복참치', 35000);
insert into food(id, name, maker, price) values(food_seq.nextval, '파닭', '또래오래', 17000);
insert into food(id, name, maker, price) values(food_seq.nextval, '미니전골', '대한곱창', 18000);

commit

select count(*) from food;
-- 반올림한 평균가 20167
select round(avg(price)) from food;
-- maker별 평균가, price 내림차순 : 이춘복참치 35000, 대한곱창 19000, 또래오래 16000
select maker, round(avg(price)) as avgprice
from food 
group by maker 
order by avgprice desc;

-- 전체 상품의 평균가보다 maker별 평균가가 낮은 그 maker에 해당하는 실제 음식명과 가격을 알고 싶을 때?! => IN 사용 

-- 전체 음식의 평균가보다 maker별 음식 평균가가 낮음 maker의 음식정보(name, price, maker) 를 조회하고자 한다( price 내림차순 정렬 )
-- group by ~ having, subquery, in 을 이용
select name, price, maker 
from food 
group by maker
having avg(price) < (select round(avg(price)) from food)
where maker in ()
order by price desc;

-- step1. 전체 음식 평균가 
select avg(price) from food;
-- step2. maker별 음식 평균가 
select avg(price) from food group by maker 
-- step3. 전체 음식 평균가보다 maker별 음식 평균가가 낮은 maker를 조회
-- 		  이 결과과 IN 안으로 들어간다 
select maker 
from food 
group by maker 
having avg(price) < (select avg(price) from food); -- 여기서의 avg(price)는 group 별 평균값
-- step4. 전체 음식의 평균가보다 maker별 음식 평균가가 낮음 maker의 음식정보(name, price, maker) 를 조회하고자 한다( price 내림차순 정렬 )
select name, price, maker
from food
where maker in(
	'대한곱창', '또래오래'
)
order by price desc

-- in 활용(정답)
select name, price, maker
from food
where maker in(
	select maker
	from food
	group by maker
	having avg(price) < (select avg(price) from food)
)
order by price desc;


------------------------------------------------------------------------------
select * from s_employee;

--job 별 사원수가 3명 이상인 job에 해당하는 사원의 name과 job을 조회 
select name, job 
from s_employee
where job in (select job from s_employee group by job having count(*) >= 3);

-- > step1. job 별 사원수가 3명 이상이 job : 이 구문을 IN 연산자 안에 넣어준다 
select job
from s_employee
group by job
having count(*) >= 3;

-- > step2. job 별 사원수가 3명 이상인 job에 해당하는 사원의 name과 job을 조회
select name, job
from s_employee
where job in(
	select job
	from s_employee
	group by job
	having count(*) >= 3
)

/*
* 문제> 
* s_employee 테이블에 저장된 전체 사원 정보의 평균월급(salary)보다 
* 직종별(job) 평균월급이 낮은 직종(job)에 해당하는 사원정보를 조회하여 
* 리스트로 반환받아 출력한다 
*/
-- 전체 사원 평균 월급액 
select avg(salary) from s_employee;

-- 개발 직종의 평균 월급
select avg(salary) from s_employee where job = '개발';
select avg(salary) from s_employee where job = '총무';
select avg(salary) from s_employee where job = '영업';

select job from s_employee 
group by job 
having avg(salary) < (select avg(salary) from s_employee);
-- 완성 sql(by me)
select empno, name, job, salary
from s_employee
where job in (
	select job from s_employee 
	group by job 
	having avg(salary) < (select avg(salary) from s_employee)
)
order by salary desc;

-- < solution by inst >
-- step1.
-- job 별 평균월급 
select job, avg(salary)
from s_employee
group by job

---------------------------------------------------------------
-- step2.
-- 전체 사원 정보의 평균월급(salary)보다 직종별(job) 평균월급이 낮은 직종
select job
from s_employee
group by job
having avg(salary) < (select avg(salary) from s_employee)

/*
* 문제> 
* s_employee 테이블에 저장된 전체 사원 정보의 평균월급(salary)보다 
* 직종별(job) 평균월급이 낮은 직종(job)에 해당하는 사원정보를 조회하여 
* 리스트로 반환받아 출력한다 
*/
-- step.final
select empno, name, job, salary from s_employee
where job in (
	select job from s_employee
	group by job
	having avg(salary) < (select avg(salary) from s_employee)
)
order by salary desc

























