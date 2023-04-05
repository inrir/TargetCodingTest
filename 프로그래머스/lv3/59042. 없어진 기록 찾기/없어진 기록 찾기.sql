-- 보호소에 들어온 기록을 찾아야 한다. 
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_OUTS A LEFT OUTER JOIN ANIMAL_INS B
ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY B.ANIMAL_ID