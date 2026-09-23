# Write your MySQL query statement below
Select MAX(num) AS num
FROM
(
    Select num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(*) = 1
) f