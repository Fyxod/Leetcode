/* Write your PL/SQL query statement below */

select a.name ,b.bonus FROM Employee a LEFT join bonus b on a.empid=b.empid where bonus is NULL or bonus<1000;
