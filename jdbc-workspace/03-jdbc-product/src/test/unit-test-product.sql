-- select
select * from product;

-- 총 상품 수 조회
select count(*) from product;

select name, maker from product;

select id from product;

-- id에 대한 상품 존재 유무
select count(*) from product where id = 1; -- 존재하면 1이 출력 
select count(*) from product where id = 8; -- 존재X 는 0 


--윌 상품들이 어떤 제조사에 의해 만들어졌는지 (중복 제거)
-- maker 종류 조회
select distinct maker from product;

select id, name, maker, price
from product 
where price between 1300 and 1700 
order by price desc;

---DAO 에 적용할 Sql
select id, name, maker, price
from product 
where price >= ? and price <= ?
order by price desc;


