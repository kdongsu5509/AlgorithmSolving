SELECT 
    B.INGREDIENT_TYPE, 
    SUM(A.TOTAL_ORDER) AS TOTAL_ORDER
FROM 
    FIRST_HALF AS A
INNER JOIN 
    ICECREAM_INFO AS B
ON 
    A.FLAVOR = B.FLAVOR
GROUP BY 
    B.INGREDIENT_TYPE
ORDER BY 
    TOTAL_ORDER;
