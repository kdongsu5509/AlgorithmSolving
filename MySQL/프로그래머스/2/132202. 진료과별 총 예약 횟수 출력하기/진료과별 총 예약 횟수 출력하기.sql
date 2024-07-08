SELECT MCDP_CD, COUNT(MCDP_CD) 
FROM APPOINTMENT
WHERE YEAR(APNT_YMD) = 2022 AND MONTH(APNT_YMD) = 05
GROUP BY MCDP_CD
ORDER BY COUNT(MCDP_CD), MCDP_CD;
