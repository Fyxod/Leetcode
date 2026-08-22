# Write your MySQL query statement below
Select name, bonus from Employee e LEFT JOIN Bonus b USING(empId) where BONUS < 1000 or BONUS is null 