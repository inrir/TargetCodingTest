-- 보호소에 들어온 후 중성화된 동물
SELECT A.ANIMAL_ID as ANIMAL_ID, A.ANIMAL_TYPE as ANIMAL_TYPE, A.NAME as NAME
FROM ANIMAL_INS A JOIN ANIMAL_OUTS B ON
A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE != B.SEX_UPON_OUTCOME;