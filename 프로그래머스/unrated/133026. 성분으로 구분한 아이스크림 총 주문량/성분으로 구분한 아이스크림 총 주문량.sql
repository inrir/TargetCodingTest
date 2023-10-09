-- 코드를 입력하세요
SELECT ingredient_type, sum(total_order) as total_order
from FIRST_HALF A join ICECREAM_INFO B on A.flavor = B.flavor
group by ingredient_type
order by total_order