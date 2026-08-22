# Write your MySQL query statement below
Select name from Employee a 
where 5 <= (
    Select COUNT(*) from EMPLOYEE b where a.id = b.managerId
)