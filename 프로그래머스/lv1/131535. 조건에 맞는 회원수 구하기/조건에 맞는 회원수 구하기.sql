-- 2021년 가입 && 20 ~ 29 회원
SELECT count(*) 
from user_info 
where AGE >= 20 and AGE <= 29 and DATE_FORMAT(JOINED, "%Y") = '2021';