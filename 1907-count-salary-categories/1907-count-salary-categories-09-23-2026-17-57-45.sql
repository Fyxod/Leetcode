# Write your MySQL query statement below
Select 'Low Salary' AS category, SUM(income < 20000) AS accounts_count
FROM Accounts

UNION

Select 'Average Salary' AS category, SUM(income between 20000 AND 50000) AS accounts_count
FROM Accounts

UNION

Select 'High Salary' AS category, SUM(income > 50000) AS accounts_count
FROM Accounts