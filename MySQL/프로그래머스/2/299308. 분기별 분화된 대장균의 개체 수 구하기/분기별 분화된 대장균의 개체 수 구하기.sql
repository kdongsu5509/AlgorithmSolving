SELECT 
    CONCAT(QUARTER(DIFFERENTIATION_DATE), 'Q') AS 'QUARTER',
    COUNT(*) AS 'ECOLI_COUNT'
FROM ECOLI_DATA
GROUP BY CONCAT(QUARTER(DIFFERENTIATION_DATE), 'Q')
ORDER BY MIN(DIFFERENTIATION_DATE);
