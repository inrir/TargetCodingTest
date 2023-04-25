-- 코드를 입력하세요
SELECT F.FLAVOR
FROM FIRST_HALF F JOIN JULY J ON F.FLAVOR = J.FLAVOR -- 외래키가 어떤 것인지 알것!!
GROUP BY F.FLAVOR
ORDER BY SUM(F.TOTAL_ORDER) + SUM(J.TOTAL_ORDER) DESC
LIMIT 3