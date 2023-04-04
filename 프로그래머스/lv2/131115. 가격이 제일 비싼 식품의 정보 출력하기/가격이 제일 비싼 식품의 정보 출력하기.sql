-- 가격이 제일 비싼 식품, 식품이름, 식품 코드, 식품 분류, 식품 가격
SELECT *
from FOOD_PRODUCT
where price = (SELECT MAX(PRICE) FROM FOOD_PRODUCT);