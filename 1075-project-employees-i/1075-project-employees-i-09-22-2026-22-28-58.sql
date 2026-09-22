# Write your MySQL query statement below
Select p.project_id, ROUND(AVG(e.experience_years), 2) AS average_years
FROM Project p
JOIN
Employee e
USING (employee_id)
GROUP BY project_id