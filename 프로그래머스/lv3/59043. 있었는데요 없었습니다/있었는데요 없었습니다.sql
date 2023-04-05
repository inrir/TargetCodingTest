-- OUTS 입양일 잘 못 입력 => 보호 시작일 보다 입양일이 빠른 동물의 아이디와 이름 조회
-- 보호 시작일이 빠른 순으로 조회
SELECT B.ANIMAL_ID, B.NAME
FROM ANIMAL_INS A, ANIMAL_OUTS B
WHERE A.ANIMAL_ID = B.ANIMAL_ID and A.DATETIME >= B.DATETIME
ORDER BY A.DATETIME;