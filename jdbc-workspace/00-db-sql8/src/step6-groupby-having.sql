/*
 *  group by ~ having 절 
 * 
 *  group by : 테이블에서 특정컬럼을 기준으로 그룹화하여 검색할 때 사용
 * 			   데이터를 원하는 그룹으로 나눌 수 있다. 
 * 
 *  having : group by 와 함께 사용하는 조건절 ( where 과는 다르게 그룹에 대한 조건을 지정 )
 * 			 컬럼의 별칭 사용 불가  그룹함수로 사용해야 한다 
 *  
 *  예) 상품 테이블에서 제조사별 상품수, 평균가
 * 	   사원 테이블에서 부서별 사원수, 평균월급
 */

select * from product;

-- maker별 상품수 조회 
select maker, count(*)
from product 
group by maker

-- maker별 상품수 조회 - 정렬
select maker, count(*) as 상품수 -- as를 통해 별칭을 생성
from product 
group by maker
order by 상품수 desc

-- maker별 상품수 조회하되 상품수가 1개를 초과하는 maker(그룹)들만 조회 ( group by ~ having )
-- having 은 별도의 별칭으로 하는 것이 아니라 그룹함수를 다시 써줘야 한다 
select maker, count(*) as 상품수 -- as를 통해 별칭을 생성
from product 
group by maker
having count(*) > 1 -- having절은 별칭사용이 불가, 그룹함수를 사용해야 한다
order by 상품수 desc

select maker, count(*) as 상품수 -- as를 통해 별칭을 생성
from product 
group by maker
having 상품수 > 1 -- having절은 별칭사용이 불가, 그룹함수를 사용해야 한다 -- invalid identifier error
order by 상품수 desc

-- maker별 상품 평균가(avg())를 조회하되 평균가 내림차순으로 정렬 
-- 평균가가 소수점이하인 경우 반올림(round)
select maker, round(avg(price)) as 평균가
from PRODUCT
group by maker
order by 평균가 desc

select avg(price) from product group by maker; -- 단위테스트 확인

-- maker별 상품 평균가(소수점이하 반올림)가 1540을 초과하는 제조사maker를 조회하되 
-- maker별 상품수,평균가를 조회한다(조회 : maker, 상품수, 평균가)
-- 상품수 오름차순으로 조회
select maker, count(*) as 상품수, round(avg(price)) as 상품평균가
from product
group by maker
having round(avg(price)) > 1540
order by 상품수 asc

select * from s_employee;

-- job 별 사원수 ( job, 사원수 ) 를 조회하되 사원수 내림차순 정렬
select job, count(*) as 사원수
from S_EMPLOYEE
group by job
order by 사원수 desc

-- job 별 평균월급(avg(salary))를 조회하되 평균월급 내림차순 정렬 (job, 평균월급)
select job, avg(salary) as 평균월급
from s_employee
group by job
order by 평균월급 desc

-- job 별 평균월급(avg(salary))를 조회하되 평균월급 내림차순 정렬 (job, 평균월급)
-- 평균월급이 700을 초과하는 job에 한해서 조회한다
select job, avg(salary) as 평균월급
from s_employee
group by job
having avg(salary) > 700
order by 평균월급 desc

-- sql test 
-- job별로 최고 연봉을 받는 사원 조회 (08-jdbc-groupby-employee)
-- count(*)는 별칭 안해줘도 된다? 
select job, count(*), max(salary) as highestsal
from S_EMPLOYEE
group by job
order by highestsal desc

-- 전체 사원의 평균월급(730)보다 job 그룹별 평균월급액이 작은 job 그룹의 job, 평균월급을 조회 
-- 개발을 제외한 job그룹의 정보가 나오면 됌 
select avg(salary) from S_EMPLOYEE; -- 730
select avg(salary) from S_EMPLOYEE where job = '영업'; -- 영업600
select avg(salary) from S_EMPLOYEE where job = '개발'; -- 개발833.333..
select avg(salary) from S_EMPLOYEE where job = '총무'; -- 총무720

-- 총무직종, 영업직종이 조회결과로 나와야 한다 ( group by ~ having, subquery )
-- 총무 720
-- 영업 600

-- 총무직종, 영업직종 조회결과로 나와야 한다 
-- 별칭 사용은 having에서는 불가, order by 는 가능 
select job, avg(salary) as AVGGSAL
from S_EMPLOYEE
group by job
having avg(salary) < (select avg(salary) from S_EMPLOYEE)
order by AVGGSAL desc

-- product
select * from product;
-- 

select avg(price) from product; 
-- 제조사별 상품의 평균가(having)가 전체 상품의 평균가(subquery)보다 작은 제조사의 이름과 상품평균가를 조회하되 평균가 내림차순으로 정렬
-- having 다음 컬럼은 제조사별 평균가
-- having 이 별칭을 못 쓰는 이유 : select 를 할 때 값이 만들어 지는데 select 전에 조건이 붙기 때문 
-- having  조건절이 먼저 실행되고 select 되기 때문 
select maker, round(avg(price)) as avgprice
from product
group by maker
having round(avg(price)) < (select round(avg(price)) from product)
order by avgprice desc

























































