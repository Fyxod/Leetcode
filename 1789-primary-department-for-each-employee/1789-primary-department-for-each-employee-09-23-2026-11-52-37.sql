# Write your MySQL query statement below
Select employee_id, department_id
FROM Employee e1
WHERE 
    primary_flag = 'Y'
    OR
    1 = (
        Select COUNT(*) from Employee e2 where e1.employee_id = e2.employee_id
    )