# Write your MySQL query statement below
Select Distinct(num) AS ConsecutiveNums
FROM Logs l1
WHERE 
    (Select num from Logs l2 where l2.id = l1.id + 1) = num
    AND
    (Select num from Logs l2 where l2.id = l1.id + 2) = num